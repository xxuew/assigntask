package com.nju.assigntask.controller;

import com.alibaba.fastjson.JSONObject;
import com.nju.assigntask.entity.Inputs;
import com.nju.assigntask.entity.Myreceive;
import com.nju.assigntask.entity.Subtask;
import com.nju.assigntask.entity.User;
import com.nju.assigntask.service.*;
import com.nju.assigntask.entity.*;
import com.nju.assigntask.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 处理评估页面
 * @Author:wx
 * @Date:Created in 20:38 2019/2/24
 * @Modified by:
 */
@Controller
public class CommentController {
    @Autowired
    MyReceiveService myReceiveService;
    @Autowired
    SubTaskService subTaskService;

    @Autowired
    UserReceiveService userReceiveService;

    @Autowired
    InputsService inputsService;

    /**
     * 显示评估详情页内容
     * @param userid
     * @param queryString
     * @return
     */
    @GetMapping("/commentInfo")
    @ResponseBody
    public JSONObject commentItemInfo(int userid,String queryString){

        if(queryString == null || queryString == ""){
            return null;
        }

        try{
            int myReceiveId = Integer.parseInt(queryString.trim());
            Myreceive myreceive = myReceiveService.selectByUser(userid,myReceiveId);//从myreceive中获得完整任务
            if (myreceive != null){
                List<Subtask> subtasks = subTaskService.selectSubBySubId(myreceive);//根据subtaskid_1-10从subtask中获取itemname和itemDes
                //根据myreceive中获得的dividedid，从divided表找相应的inputid，从而找到inputname和inputdes
                //todo 要保证divided表中的inputID是准确的，一开始分配任务时没有考虑发布的任务不是六种算法的情况，inputid可能不准确
                Inputs inputs = inputsService.selectInputById(myreceive);

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("input", inputs);
                jsonObject.put("subtasks",subtasks);
                jsonObject.put("myreceive",myreceive);
                return jsonObject;
            }
            else  return null;
        }catch (Exception e){
           e.printStackTrace();
            return null;

        }

        //todo 之后会在recommend原始表插入releaseid，但是对这里不影响，因为inputid对于原始数据来说是唯一标识，插入releaseid只对生成任务有影响？
    }

    /**
     * 接收评估结果
     * @param request
     * @param queryString
     * @param formValues
     * @return
     */
    @PostMapping("/comment_result")
    @ResponseBody
    public String insertCommentRes(HttpServletRequest request, String queryString,int[] formValues ){

        User user = (User) request.getSession().getAttribute("currentUser");
        JSONObject jsonObject = commentItemInfo(user.getUserid(), queryString);
        List<Subtask> subtasks = (List<Subtask>) jsonObject.get("subtasks");
        int formCount = -1;
        for (int i=0;i<subtasks.size()&&formCount<formValues.length-1;i++){
            Subtask subtask = subtasks.get(i);
                int score1 = formValues[++formCount];
                int score2 = formValues[++formCount];

                userReceiveService.updateScore(subtask.getDividedid(),user.getUserid(),
                        subtask.getSubtaskid(),score1,score2);
        }
        Myreceive myreceive = (Myreceive) jsonObject.get("myreceive");
        myReceiveService.updateIfcomple(myreceive.getId(),"已完成"); //myreceive ifcomplete改为完成

        return "OK";
    }

}
