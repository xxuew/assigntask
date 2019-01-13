package com.wx.assigntask.controller;


import com.wx.assigntask.comment.ItemList;
import com.wx.assigntask.dao.DividedMapper;
import com.wx.assigntask.dao.OriginalDataMapper;
import com.wx.assigntask.dao.ReleaseMapper;
import com.wx.assigntask.dao.SubtaskMapper;
import com.wx.assigntask.entity.OriginalData;
import com.wx.assigntask.entity.User;
import com.wx.assigntask.service.OriginalDataService;
import com.wx.assigntask.service.ReleaseService;
import com.wx.assigntask.service.SubTaskService;
import com.wx.assigntask.service.UserService;
import com.wx.assigntask.subtask.BuildTask;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;


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
    ReleaseMapper releaseMapper;
    @Autowired
    OriginalDataMapper originalDataMapper;
    @Autowired
    DividedMapper dividedMapper;
    @Autowired
    SubTaskService subTaskService;
    @Autowired
    OriginalDataService originalDataService;

    @RequestMapping(value = "/login")
    public String login(){

        return "user/login";
    }

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
    public String home( HttpServletRequest request){
//        User user = (User) httpSession.getAttribute("currentUser");
//        request.setAttribute("userInfo",user);
        String username = request.getParameter("username");
        System.out.println(username+"看看有啥");
        return "user/home";
    }

    //返回数据库数据传给jsp
    @RequestMapping(value = "/myreleasetask")
    public String releaseInfo(){


        return  "user/myreleasetask";
    }

//        ReleaseTask releaseTask =releaseService.findReleaseById(1);
//        request.setAttribute("releaseInfos",releaseTask);






    @RequestMapping(value = "/comment")
    public String common(Map<String, Object> map){
        List<OriginalData> lista;
        List<ItemList> a;
        lista= originalDataService.selectAll();
        a = subTaskService.insertSubTask(lista);
        List<ItemList> lists = new ArrayList<ItemList>();

        for(int i = 0;i < 10;i++){
            ItemList item = new ItemList();
            item = a.get(i);
            lists.add(item);
        }

        map.put("lists",lists);
//        for(ItemList item:lists){
//            System.out.println(item.itema+" "+item.getItemb());
//        }
//        下列代码可获取需要生成的任务
//        List<OriginalData> lista;
//        lista= originalDataService.selectAll();
//        subTaskService.insertSubTask(lista);



        return "user/comment";
    }


//    private OriginalDataMapper originalDataService;
    @ResponseBody
    @RequestMapping(value="/results",method= RequestMethod.POST)
    public String results(HttpServletRequest request){
        System.out.println("--------------------");
        List<OriginalData> lista;
        List<ItemList> a;
        lista= originalDataService.selectAll();
        a = subTaskService.insertSubTask(lista);
        List<ItemList> lists = new ArrayList<ItemList>();

        for(int i = 0;i < 10;i++){
            ItemList item = new ItemList();
            item = a.get(i);
            lists.add(item);
        }

        for(int i = 0;i < 10;i++){
            String item1 =lists.get(i).itema;
            String item2 =lists.get(i).itemb;
            String resulta = request.getParameter("itema"+(i+1));
            String resultb = request.getParameter("itemb"+(i+1));
            System.out.println(item1+" "+resulta);
            System.out.println(item2+" "+resultb);
        }


        return "OK";
    }





}
