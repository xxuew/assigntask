package com.wx.assigntask.controller;

import com.wx.assigntask.comment.ItemList;
import com.wx.assigntask.dao.UserMapper;
import com.wx.assigntask.entity.User;
import com.wx.assigntask.service.IAHPService;
import com.wx.assigntask.service.ITaskService;
import com.wx.assigntask.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class CommentController {
    @Autowired
    IUserService userService;
    @Autowired
    IAHPService ahpService;
    @Autowired
    ITaskService taskService;

    @RequestMapping(value = "/comment")
    public String common(Map<String, Object> map, HttpSession httpSession,HttpServletRequest request){
        User user = (User) httpSession.getAttribute("currentUser");
        if (user != null) {
            System.out.println("----------检查是否申请任务----------");
            User currentuser = userService.findUserByUserName(user.getUsername());
            List<ItemList> lists = new ArrayList<ItemList>();
//        判断是否分配了任务
            int received_id = currentuser.getReceived_id();
            if(received_id == 0){
//        生成任务，将用户id写入任务数据表表
                System.out.println("----------申请任务----------");
                int id = Integer.parseInt(request.getParameter("id"));
                System.out.println("申请任务的id为："+id);
                lists = taskService.assignTask(id,currentuser);
            }else{
//                检查并返回用户当前已经申请的任务
                lists = userService.checkUser(user);
            }

            map.put("lists",lists);
            return "user/comment";
        }else{
            return "user/login";
        }
    }

//提交数据，并存入数据
//    @PostMapping("get_comment")
    @RequestMapping(value = "get_comment")
    public String getComment(HttpServletRequest request, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("currentUser");
        if (user != null) {
            System.out.println("----------提交任务----------");
            User currentuser = userService.findUserByUserName(user.getUsername());
            int algo_id = currentuser.getAlgo_id();
            System.out.println("algo_id"+algo_id);
            List<ItemList> lists = new ArrayList<ItemList>();
            for(int i = 0;i < 10;i++){
                ItemList itemList = new ItemList();
                String scorea = request.getParameter("scorea"+(i+1));
                String scoreb = request.getParameter("scoreb"+(i+1));
                System.out.println("scorea"+(i+1)+" "+scorea);
                System.out.println("scoreb"+(i+1)+" "+scoreb);
                itemList.setScorea(Integer.valueOf(scorea));
                itemList.setScoreb(Integer.valueOf(scoreb));
                lists.add(itemList);
            }
            taskService.StoreData(algo_id,user,lists);
        } else {
            return "user/login";
        }
        return "user/home";
    }



    //    private OriginalDataMapper originalDataService;
//    @ResponseBody
//    @RequestMapping(value="/results",method= RequestMethod.POST)
//    public String results(HttpServletRequest request){
//        System.out.println("--------------------");
//        List<OriginalData> lista;
//        List<ItemList> a = ahpService.CreatTask();
//        List<ItemList> lists = new ArrayList<ItemList>();
//
//        for(int i = 0;i < 10;i++){
//            ItemList item = new ItemList();
//            item = a.get(i);
//            lists.add(item);
//        }
//
//        for(int i = 0;i < 10;i++){
//            String item1 =lists.get(i).itema;
//            String item2 =lists.get(i).itemb;
//            String resulta = request.getParameter("itema"+(i+1));
//            String resultb = request.getParameter("itemb"+(i+1));
//            System.out.println(item1+" "+resulta);
//            System.out.println(item2+" "+resultb);
//        }
//
//
//        return "OK";
//    }
}
