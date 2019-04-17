package com.wx.assigntask.controller;

import com.wx.assigntask.entity.User;
import com.wx.assigntask.service.*;
import com.wx.assigntask.tools.Constant;
import com.wx.assigntask.tools.WriteSql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@RestController
public class SubmitReleaseController {
    @Autowired
    ReleaseService releaseService;
    @Autowired
    ReleaseTablesService releaseTablesService;
    @Autowired
    SubTaskService subTaskService;

    @Autowired
    Constant constant;
    @Autowired
    WriteSql writeSql;

    /**
     * 提交发布内容
     * @param fileUpload
     * @param recommandTableNames
     * @param recommandAlgNames
     * @param request
     * @param httpSession
     * @return
     */
    @PostMapping("/submitrelease")
    public Map upload(@RequestParam(value = "mFiles",required = false) MultipartFile[] fileUpload,
                      @RequestParam(value = "recommandAlgTableNames",required = false) String[] recommandTableNames,
                      @RequestParam(value = "recommandAlgNames",required = false) String[] recommandAlgNames,
                      HttpServletRequest request, HttpSession httpSession){

        User user = (User) httpSession.getAttribute("currentUser");
        Map result = new HashMap();
        if (user == null){
            result.put("releaseid",-1);
            result.put("msg","请登录！");
        }else {
            boolean checkWriteSql =  writeSql.saveSqlFile(fileUpload); //保存写入SQL文件
            if (checkWriteSql == false) { //写入SQL失败
                result.put("releaseid",-2);
                result.put("msg","写入文件发生错误!");
            }else {
                String checkTable = writeSql.checkColNameType(recommandTableNames,request); //检查SQL文件字段
                if (!checkTable.equals("success")){ //字段不符合要求
                    result.put("releaseid",-3);
                    result.put("msg",checkTable);
                }else {  //数据源符合要求，插入发布信息
                    int releaseid = releaseService.insertRelease(request,user.getUserid(),recommandAlgNames); //插入发布信息release表
                    releaseTablesService.insertRecord(request,recommandTableNames,recommandAlgNames,releaseid); //插入已发布项目和数据源关系表releaseTable表
                    result.put("releaseid",releaseid);
                    result.put("msg","发布成功！");
                    result.put("user",user);
                }
            }
        }
        return result;
    }

    /**
     * 存session
     * @param request
     * @param response
     * @param user
     * @return
     */
    @PostMapping("/setSession")
    public String setSession(HttpServletRequest request, HttpServletResponse response,User user){

        if (user == null){
            return null;
        }
        HttpSession session = request.getSession();
        session.setAttribute("currentUser",user);
        return "success";
    }


    /**
     * 调用生成子任务接口
     * @param releaseid
     */
    @PostMapping("/gensubtask")
    public  void gensubtask(@RequestParam(value = "releaseid",required = false) int releaseid){
        subTaskService.geneSubTask(releaseid);

    }

    /**
     * 控制“发布任务”页面，“子任务量”
     * @param optionText
     * @return
     */
    @GetMapping("/subtaskNum")
    public String changeSubtaskNum(String optionText) {
        if (optionText.equals(constant.getPLAN_AHP())) {
            //AHP
            return constant.getAHP_subtaskFormula();
        } else if (optionText.equals(constant.getPLAN_COMPARECOMPLETE())) {
            //充分对比剪枝
            return constant.getCOMPARECOMPLETE_subtaskFormula();
        } else if (optionText.equals(constant.getPLAN_SAMELAYER())) {
            //同层对比剪枝
            return constant.getSAMELAYER_subtaskFormula();
        } else return "未知方案";
    }
}
