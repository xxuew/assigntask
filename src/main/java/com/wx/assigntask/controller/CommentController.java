package com.wx.assigntask.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wx.assigntask.comment.ItemList;
import com.wx.assigntask.entity.*;
import com.wx.assigntask.service.MyReceiveService;
import com.wx.assigntask.service.RecommandService;
import com.wx.assigntask.service.SubTaskService;
import com.wx.assigntask.service.UserReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
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
    RecommandService recommandService;
    @Autowired
    UserReceiveService userReceiveService;

    @GetMapping("/commentInfo")
    @ResponseBody
    public JSONObject commentItemInfo(int userid,String queryString){

        queryString = queryString.replace("?","");
        try{
            int count = Integer.parseInt(queryString);
            Myreceive myreceive = myReceiveService.selectByUser(userid,count);//从myreceive中获得完整任务
            if (myreceive != null){
                List<Subtask> subtasks = subTaskService.selectSubBySubId(myreceive);//根据subtaskid_1-10从subtask中获取itemname和itemDes
                //根据myreceive中获得的dividedid，从divided表找相应的inputid，从而找到inputname和inputdes
                //todo 要保证divided表中的inputID是准确的，一开始分配任务时没有考虑发布的任务不是六种算法的情况，inputid可能不准确
                Recommand recommand = recommandService.selectInputById(myreceive);

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("input",recommand);
                jsonObject.put("subtasks",subtasks);
                return jsonObject;
            }
            else  return null;
        }catch (Exception e){
           // e.printStackTrace();
            return null;

        }

        //todo 之后会在recommend原始表插入releaseid，但是对这里不影响，因为inputid对于原始数据来说是唯一标识，插入releaseid只对生成任务有影响？
    }

    @PostMapping("/comment_result")
    @ResponseBody
    public String insertCommentRes(HttpServletRequest request,@RequestBody Subtask[] subtasks){

        User user = (User) request.getSession().getAttribute("currentUser");
        for (int i=0;i<subtasks.length;i++){
            Subtask subtask = subtasks[i];
            int score1 = subtask.getScore1();
            int score2 = subtask.getScore2();
            int divided = subtask.getDividedid();
            userReceiveService.updateScore(subtask.getDividedid(),user.getUserid(),
                    subtask.getSubtaskid(),score1,score2);
        }
        //任务列表myreceives，具体到用户的第几个myreceive,可以将comment_count作为myreceives的下标获取对应的myreceive



        //            for(int i = 0;i < 10;i++){
//                String item1 =lists.get(i).itema;
//                String item2 =lists.get(i).itemb;
//                String resulta = request.getParameter("itema"+(i+1));
//                String resultb = request.getParameter("itemb"+(i+1));
//                System.out.println(item1+" "+resulta);
//                System.out.println(item2+" "+resultb);
//            }
        return "OK";
    }

}
