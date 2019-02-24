package com.wx.assigntask.controller;

import com.wx.assigntask.entity.Myreceive;
import com.wx.assigntask.entity.Userreceive;
import com.wx.assigntask.service.MyReceiveService;
import com.wx.assigntask.service.UserReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author:wx
 * @Date:Created in 17:03 2019/2/24
 * @Modified by:
 */
@Controller
public class MyReceiveController {
    @Autowired
    MyReceiveService myReceiveService;


    @GetMapping("/my_receive")
    @ResponseBody //此注解不能省略，否则Ajax不能接收返回值
    public List<Myreceive> myReceive(int userid){

        List<Myreceive> myreceives = myReceiveService.selectByUser(userid);

        return myreceives;
    }
}
