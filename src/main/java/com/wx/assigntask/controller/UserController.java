package com.wx.assigntask.controller;

import com.wx.assigntask.entity.User;
import com.wx.assigntask.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;


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
    SubTaskService subTaskService;


    @PostMapping("loginjudge")
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

    @RequestMapping(value = "/myreleasetask")
    public String releaseInfo(){
            //TODO
            // 这里写死了
            int releaseId = releaseService.insertRelease("两两对比排除"); //发布即插入
            if (releaseId == -1)
                return "user/myreleasetask";
            else {
                //如果该方案未分派则生成方案分派
                subTaskService.geneSubTask(releaseId);
                return  "user/myreleasetask";
            }
    }



}
