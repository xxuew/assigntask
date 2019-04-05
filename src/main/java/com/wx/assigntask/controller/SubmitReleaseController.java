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
import javax.servlet.http.HttpSession;
import java.io.File;
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

    @PostMapping("/submitrelease")
    public int upload(@RequestParam(value = "mFiles",required = false) MultipartFile[] fileUpload,
                      @RequestParam(value = "recommandAlgTableNames",required = false) String[] recommandTableNames,
                      @RequestParam(value = "recommandAlgNames",required = false) String[] recommandAlgNames,
                      HttpServletRequest request, HttpSession httpSession){

        User user = (User) httpSession.getAttribute("currentUser");
        if (user == null){
           return -2;
        }else {
            int returNum =  writeSql.saveSqlFile(fileUpload); //保存写入SQL文件
            if (returNum == -1) {
               return -1;
            }else {
                int releaseid = releaseService.insertRelease(request,user.getUserid(),recommandAlgNames); //插入发布信息release表
                releaseTablesService.insertRecord(request,recommandTableNames,recommandAlgNames,releaseid); //插入已发布项目和数据源关系表releaseTable表
                int test = request.getSession().getMaxInactiveInterval();

                return releaseid;
            }
        }
    }

    @PostMapping("/gensubtask")
    public  void gensubtask(@RequestParam(value = "releaseid",required = false) int releaseid){
        subTaskService.geneSubTask(releaseid);

    }

    @GetMapping("/subtaskNum")
    public String changeSubtaskNum(String optionText) {
        if (optionText.equals(constant.getPLAN1())) {
            //AHP
            return constant.getPLAN1_subtaskFormula();
        } else if (optionText.equals(constant.getPLAN2())) {
            //充分对比剪枝
            return constant.getPLAN2_subtaskFormula();
        } else if (optionText.equals(constant.getPLAN3())) {
            //同层对比剪枝
            return constant.getPLAN3_subtaskFormula();
        } else return "未知方案";
    }
}
