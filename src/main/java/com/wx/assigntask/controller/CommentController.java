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
    public String common(Map<String, Object> map, HttpSession httpSession){
        User user = (User) httpSession.getAttribute("currentUser");
        if (user != null) {
            List<OriginalData> lista;
            List<ItemList> a = ahpService.CreatTask();
//        lista= originalDataService.selectAll();
//        a = subTaskService.insertSubTask(lista);
            List<ItemList> lists = new ArrayList<ItemList>();

            for(int i = 0;i < 10;i++){
                ItemList item = new ItemList();
                item = a.get(i);
                lists.add(item);
            }

            map.put("lists",lists);

            return "user/comment";
        } else {
            return "user/login";
        }
    }


    @PostMapping("get_comment")
    public String getComment(HttpServletRequest request, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("currentUser");
        System.out.println("调用了");
        if (user != null) {
            System.out.println("--------------------");
            List<ItemList> a = ahpService.CreatTask();
            List<ItemList> lists = new ArrayList<ItemList>();

            for(int i = 0;i < 10;i++){
                ItemList item;
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
