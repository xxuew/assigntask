package com.wx.assigntask.controller;

import com.wx.assigntask.entity.ReleaseTask;
import com.wx.assigntask.entity.User;
import com.wx.assigntask.service.UserService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
/**
 * @Author: wx
 * @Date: 2018/12/4 17:20
 * @Version 1.0
 */
//证明是controller层并返回json
@Controller
public class UserController {
    //依赖注入
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login")
    public String login(){
        return "user/login";
    }
    @RequestMapping(value = "loginjudge",method = RequestMethod.POST)
    @ResponseBody
    public String loginJudge(){
        return "OK";
    }

    @RequestMapping(value = "/index")
    public String index(){

        return "user/index";
    }

    @RequestMapping(value = "/home")
    public String home(){

        return "user/home";
    }

    @RequestMapping(value = "/myreleasetask")
    public String myReleaseTask(){
        ReleaseTask releaseTask = userService.queryRelease(1);

        return "user/myreleasetask";
    }

    @RequestMapping(value = "myreceivedtask")
    public String myReceivedTask(){

        return "user/myreceivedtask";
    }
}
