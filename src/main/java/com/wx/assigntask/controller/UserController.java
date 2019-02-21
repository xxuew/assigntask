package com.wx.assigntask.controller;

import com.wx.assigntask.comment.ItemList;
import com.wx.assigntask.dao.DividedMapper;
import com.wx.assigntask.dao.OriginalDataMapper;
import com.wx.assigntask.dao.ReleaseMapper;
import com.wx.assigntask.entity.OriginalData;
import com.wx.assigntask.entity.Release;
import com.wx.assigntask.entity.User;
import com.wx.assigntask.service.*;
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
import java.util.*;

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
//            Release release = new Release();
//            release.setPlan("两两对比排除");
//            //release.setPlan("先纵再横，算法内排序");
//            release.setAlgnames("lstm,nn,cnn,tfidf,doc,index");
//            int releaseId = releaseService.insertRelease(release); //发布即插入
//            if (releaseId == -1)
//                return "user/myreleasetask";
//            else {
//                //如果该方案未分派则生成方案分派
//                subTaskService.geneSubTask(releaseId);
//                return  "user/myreleasetask";
//            }

        return  "user/myreleasetask";

    }

    //TODO DEV
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
