package com.wx.assigntask.controller;

import com.wx.assigntask.entity.User;
import com.wx.assigntask.comment.ItemList;
import com.wx.assigntask.entity.OriginalData;
import com.wx.assigntask.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

@Controller
public class AssignTaskController {
    //依赖注入
//    @Autowired
//    IUserService userService;
//    依赖好像只用注入一次、

    @Autowired
    OriginalDataService originalDataService;



    @RequestMapping(value = "/home")
    public String home( HttpServletRequest request,HttpSession httpSession){
        User user = (User) httpSession.getAttribute("currentUser");
        if (user != null) {


            return "user/home";
        } else {
            return "user/login";
        }
    }

//    //返回数据库数据传给jsp
//    @RequestMapping(value = "/myreleasetask")
//    public String releaseInfo(){
//
//
//        return  "user/myreleasetask";
//    }


}
