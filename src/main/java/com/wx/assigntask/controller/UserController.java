package com.wx.assigntask.controller;


import com.wx.assigntask.comment.ItemList;
import com.wx.assigntask.entity.User;
import com.wx.assigntask.service.UserService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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


    @RequestMapping(value = "/comment")
    public String common(Map<String, Object> map){
        List<ItemList> lists = new ArrayList<ItemList>();
        for(int i = 0;i < 10;i++){
            String itema = "A" + (i+1) ;
            String itemb = "B" + (i+1) ;
            ItemList item = new ItemList();
            item.setItema(itema);
            item.setItemb(itemb);
            lists.add(item);
        }
        map.put("lists",lists);
        for(ItemList item:lists){
            System.out.println(item.itema+" "+item.getItemb());
        }
        return "user/comment";
    }

    @ResponseBody
    @RequestMapping(value="/results",method= RequestMethod.POST)
    public String results(HttpServletRequest request){
        System.out.println("--------------------");
        String[] s = new String[20];
        for(int i = 0;i < 10;i++){
            int j = 2*i;
            s[j] = "A" + (i+1) ;
        }
        for(int i = 0;i < 10;i++){
            int j = 2*i+1;
            s[j] = "B" + (i+1) ;
        }
        for (String a:s){
            System.out.println(a);
        }

        for(int i = 0;i < 20;i++){
            String[] insts = new String[20];
            insts[i] = request.getParameter(s[i]);
            System.out.println(s[i]+" "+insts[i]);
        }

        return "OK";
    }




}
