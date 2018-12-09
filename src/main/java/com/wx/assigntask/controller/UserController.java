package com.wx.assigntask.controller;

import com.wx.assigntask.entity.ReleaseTask;
import com.wx.assigntask.entity.User;
import com.wx.assigntask.service.ReleaseService;
import com.wx.assigntask.service.UserService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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

    @Autowired
    ReleaseService releaseService;

    @Autowired
    HttpServletRequest request;


    @RequestMapping(value = "/login")
    public String login(){
        return "user/login";
    }

    @RequestMapping(value = "loginjudge",method = RequestMethod.POST)
    @ResponseBody
    public String loginJudge(){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.print(username + password);

        User user = userService.userLogin(username,password);
        if (user == null)
            return "用户名或密码错误";
        else {
            HttpSession session = request.getSession();

            session.setAttribute("username",username);
            session.setAttribute("password",password);

            return "OK";
        }
    }

    @RequestMapping(value = "/home")
    public String home( HttpServletRequest request){
//        HttpSession session = request.getSession();
//        String username = (String) session.getAttribute("username");
        User user = userService.findUserByUserName("xx");
        request.setAttribute("userInfo",user);
        return "user/home";
    }

    //返回数据库数据传给jsp
    @RequestMapping(value = "/myreleasetask")
    public String releaseInfo(){

        ReleaseTask releaseTask =releaseService.findReleaseById(1);
        request.setAttribute("releaseInfos",releaseTask);
        return  "user/myreleasetask";
    }

}
