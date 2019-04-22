package com.nju.assigntask.controller;

import com.nju.assigntask.service.ReleaseService;
import com.nju.assigntask.service.ReleaseTablesService;
import com.nju.assigntask.service.SubTaskService;
import com.nju.assigntask.tools.WriteSql;
import com.nju.assigntask.dao.ReleaseMapper;
import com.nju.assigntask.entity.Release;
import com.nju.assigntask.entity.User;
import com.nju.assigntask.service.*;
import com.nju.assigntask.tools.Constant;
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
import java.util.List;
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
    ReleaseMapper releaseMapper;

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


//    /**
//     * 调用生成子任务接口
//     */
//    @PostMapping("/gensubtask")
//    public  void gensubtask(){
//        subTaskService.geneSubTask();
//
//    }

        /**
     * 调用生成子任务接口
     */
    @PostMapping("/gensubtask")
    public String gensubtask() {
        List<Release> releases = releaseMapper.selectAllUnComplete(); //所有未完成的项目
        if (releases.size() == 0) {
            return "无待评估项目";
        } else {
            subTaskService.geneSubTask(releases);
            return "评估项目中";
        }
    }

    /**
     * 控制“发布任务”页面，“子任务量”
     * @param optionText
     * @return
     */
    @GetMapping("/subtaskNum")
    public String changeSubtaskNum(String optionText) {
        if (optionText.equals(constant.getPLAN_AHP())) {
            //OriginalAHP
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
