package com.wx.assigntask.controller;

import com.wx.assigntask.comment.ItemList;
import com.wx.assigntask.entity.OriginalData;
import com.wx.assigntask.entity.User;
import com.wx.assigntask.service.AHPService;
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
    IUserService userService;
    @Autowired
    AHPService ahpService;


    @RequestMapping(value = "/comment")
    public String common(Map<String, Object> map, HttpSession httpSession,HttpServletRequest request){
        User user = (User) httpSession.getAttribute("currentUser");
        if (user != null) {
            System.out.println("----------申请任务----------");
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println("申请任务的id为："+id);
            List<ItemList> lists = new ArrayList<ItemList>();
//            不同id对应不同的任务
            switch (id){
                case 1:
                    System.out.println("任务1");
                    lists = ahpService.assignTask(user);
                    break;
                case 2:
                    System.out.println("任务2");
                    lists = ahpService.assignTask(user);
                    break;
                case 3:
                    System.out.println("任务3");
                    lists = ahpService.assignTask(user);
                    break;
                case 4:
                    System.out.println("任务4");
                    lists = ahpService.assignTask(user);
                    break;
                case 5:
                    System.out.println("任务5");
                    lists = ahpService.assignTask(user);
                    break;
                case 6:
                    System.out.println("任务6");
                    lists = ahpService.assignTask(user);
                    break;
                case 7:
                    System.out.println("任务7");
                    lists = ahpService.assignTask(user);
                    break;
                case 8:
                    System.out.println("任务8");
                    lists = ahpService.assignTask(user);
                    break;
            }
            map.put("lists",lists);
            return "user/comment";
        } else {
            return "user/login";
        }
    }

//提交数据，并存入数据
    @PostMapping("get_comment")
    public String getComment(HttpServletRequest request, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("currentUser");
        if (user != null) {
            System.out.println("----------提交任务----------");
            System.out.println(request.getParameter("id"));
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
            ahpService.StoreData(user,lists);
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
