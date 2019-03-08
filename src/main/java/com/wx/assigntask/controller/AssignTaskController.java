package com.wx.assigntask.controller;

import com.wx.assigntask.entity.User;
import com.wx.assigntask.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AssignTaskController {
    //依赖注入
//    @Autowired
//    IUserService userService;
//    依赖好像只用注入一次、

//    @Autowired
//    IOriginalDataService originalDataService;
//


    @RequestMapping(value = "/home")
    public String home( HttpServletRequest request,HttpSession httpSession){
        User user = (User) httpSession.getAttribute("currentUser");
        if (user != null) {


            return "user/home";
        } else {
            return "user/login";
        }
    }

}
