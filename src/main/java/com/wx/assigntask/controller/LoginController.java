package com.wx.assigntask.controller;

import com.wx.assigntask.entity.User;
import com.wx.assigntask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.text.resources.FormatData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping("/loginjudge")
    @ResponseBody
    public String loginJudge(HttpServletRequest request, String username, String password){
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

    @GetMapping("/loginInfo")
    @ResponseBody
    public User loginInfo(HttpServletRequest request,HttpSession httpSession){
        User user = (User) httpSession.getAttribute("currentUser");

        return user;
    }
}
