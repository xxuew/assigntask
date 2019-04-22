package com.nju.assigntask.controller;

import com.nju.assigntask.entity.User;
import com.nju.assigntask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping("/loginjudge")
    @ResponseBody
    public String loginJudge(HttpServletRequest request, String username, String password){
        User user = userService.findUserByUserName(username);
        if(user == null){
            return "该用户不存在！";
        } else if (user.getPassword().equals(password)){
//            UserSession session = SpringUtil.getBean(UserSession.class);
//            session.setUser(user);
            HttpSession session = request.getSession(true);
            session.setAttribute("currentUser",user);
            return "OK";
        }
        else {
            return "用户名或密码错误";
        }

    }

    @GetMapping("/loginInfo")
    @ResponseBody
    public User loginInfo(HttpServletRequest request,HttpServletResponse response){

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");
//        UserSession userSession = SpringUtil.getBean(UserSession.class);
//        User user =  userSession.getUser();
       if (user == null ){
            user = new User(-1);
        }
        return user;
    }

    @PostMapping("/registerInfo")
    @ResponseBody
    public String register(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String ckpassword = request.getParameter("ckpassword");
        String email = request.getParameter("email");

        if(username == null || username.equals("")){
            return "errorName";
        }
        if(password == null || ckpassword == null || !password .equals(ckpassword)){
            return "errorPassword";
        }
        String emailReg = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regx = Pattern.compile(emailReg);
        Matcher matcher = regx.matcher(email);

        if(!matcher.matches()){
            return "errorEmail";
        }

        User curuser = new User(username,password);
        HttpSession session = request.getSession();
        User user = userService.findUserByUserName(username);
        User user1 = userService.findUserByEmail(email);

        if(user != null){
            return "existUserName";
        }
        if(user1 != null){
            return "existEmial";
        }
        curuser.setEmail(email);
        if(userService.save(curuser)){
//            UserSession userSession = SpringUtil.getBean(UserSession.class);
//            userSession.setUser(curuser);

            session.setAttribute("currentUser",curuser);
            return "success";
        }
        return "errorRegister";
    }


    @PostMapping("/resetPassword")
    @ResponseBody
    public String resetPassword(HttpServletRequest request, HttpServletResponse response){
        String type = request.getParameter("type");
        int typeInt = Integer.parseInt(type.trim());
        String username = request.getParameter("username");

        User user = userService.findUserByUserName(username);
        if(user == null){
            return "notExistUser";
        }

        if(typeInt == 0){//验证邮箱
            String email = request.getParameter("email");
            if(email == null){
                return "nullEmail";
            }

            if(user.getEmail().equals(email.trim())){
                return "success";
            }
            return "errorEmail";
        }
        else if (typeInt == 1){//重置密码；
            String password = request.getParameter("password");

            if(userService.updatePassword(user.getUserid(),password)){
                return "success";
            }
        }

        return "error";
    }
}
