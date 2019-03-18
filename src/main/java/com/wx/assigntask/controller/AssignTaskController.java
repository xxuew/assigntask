package com.wx.assigntask.controller;

import com.wx.assigntask.entity.User;
import com.wx.assigntask.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class AssignTaskController {
    //依赖注入
//    @Autowired
//    IUserService userService;
//    依赖好像只用注入一次、

//    @Autowired
//    IOriginalDataService originalDataService;
    @Autowired
    ICurrentTaskService currentTaskService;
    @Autowired
    ICaculateService caculateService;

    @RequestMapping(value = "/home")
    public String home(Map<String, Object> map, HttpSession httpSession){
        User user = (User) httpSession.getAttribute("currentUser");
        if (user != null) {

            List<Integer> list = new ArrayList<>();
            list = currentTaskService.currenttasknum();
            int cnn = list.get(0);
            int doc = list.get(1);
            int lstm = list.get(2);
            int final1 = list.get(3);
            int final2 = list.get(4);
            int final3 = list.get(5);
            map.put("cnn",cnn);
            map.put("doc",doc);
            map.put("lstm",lstm);
            map.put("final1",final1);
            map.put("final2",final2);
            map.put("final3",final3);

            caculateService.caculate();
            return "user/home";
        } else {
            return "user/login";
        }
    }

    @RequestMapping(value = "mytask")
    public String mytask(){
        return null;
    }

}
