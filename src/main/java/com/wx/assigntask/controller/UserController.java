package com.wx.assigntask.controller;


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

    @RequestMapping(value = "/login")
    public String login(){

        return "user/login";
    }

    @RequestMapping(value = "loginjudge",method = RequestMethod.POST)
    @ResponseBody
    public String loginJudge(HttpServletRequest request,String username,String password){
        User user = userService.findUserByUserName(username);
        if (user.getPassword().equals(password)){
            HttpSession session = request.getSession();

            session.setAttribute("currentUser",user);
            return "OK";
        }
        else {
            return "用户名或密码错误";
        }

    }

    @RequestMapping(value = "/home")
    public String home( HttpSession httpSession){
//        User user = (User) httpSession.getAttribute("currentUser");
//        request.setAttribute("userInfo",user);
        return "user/home";
    }

    //返回数据库数据传给jsp
    @RequestMapping(value = "/myreleasetask")
    public String releaseInfo(){

//        ReleaseTask releaseTask =releaseService.findReleaseById(1);
//        request.setAttribute("releaseInfos",releaseTask);
        return  "user/myreleasetask";
    }

}
