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
    IUserService userService;
//    @PostMapping是一个组合注解，是@RequestMapping(method = RequestMethod.POST)的缩写。
    @PostMapping("login")
    @ResponseBody
    public String loginJudge(HttpServletRequest request, String username, String password) {
        User user = userService.findUserByUserName(username);
        if (user != null && user.getPassword() != null && user.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", user);
            return "OK";
        } else {
            return "用户名或密码错误";
        }

    }

    @PostMapping("add_user")
    @ResponseBody
    public String addUser(HttpServletRequest request, String username, String password) {
        User user = userService.findUserByUserName(username);
        if (user != null) {
            return "该用户已注册";
        } else {
            user = new User();
            user.setUsername(username);
            user.setPassword(password);
            int userID = userService.addUser(user);
            if (userID > 0) {
                return "OK";
            } else {
                return "注册用户失败";
            }
        }

    }

    @RequestMapping(value = "")
    public String home(HttpServletRequest request, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("currentUser");
        if(user != null) {
            request.setAttribute("userInfo", user);
            return "user/home";
        }else{
            return "user/login";
        }
    }

    @RequestMapping(value = "/signup")
    public String signUp(HttpSession httpSession) {
        return "user/signup";
    }

    @RequestMapping(value = "/login")
    public String login(HttpSession httpSession) {
        return "user/login";
    }



}
