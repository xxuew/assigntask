package com.wx.assigntask.controller;

import com.wx.assigntask.entity.Myreceive;
import com.wx.assigntask.entity.Subtask;
import com.wx.assigntask.service.MyReceiveService;
import com.wx.assigntask.service.SubTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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

    @GetMapping("/commentItemInfo")
    @ResponseBody
    public List commentItemInfo(int userid){
        //从myreceive中获得完整任务，根据subtaskid_1-10从subtask中获取itemname和itemDes
        List<Myreceive> myreceives = myReceiveService.selectByUser(userid);
        for (int i=0;i<myreceives.size();i++){
            Myreceive myreceive = myreceives.get(i);
            for (int j=1;j<=10;j++){
                switch (j){
                    case 1:
                }
            }
            Subtask subtask = subTaskService.findSubBySubId(myreceive.getSubtaskid_1());
        }
        //根据myreceive中获得的dividedid，从divided表找相应的inputid，从而找到inputname和inputdes
        //todo 之后会在recommend原始表插入releaseid，但是对这里不影响，因为inputid对于原始数据来说是唯一标识，插入releaseid只对生成任务有影响？
        List commentInfos = new ArrayList();

        return commentInfos;
    }

}
