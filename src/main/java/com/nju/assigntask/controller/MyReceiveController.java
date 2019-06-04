package com.nju.assigntask.controller;

import com.nju.assigntask.entity.Myreceive;
import com.nju.assigntask.service.MyReceiveService;
import com.nju.assigntask.entity.Release;
import com.nju.assigntask.entity.User;
import com.nju.assigntask.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * “我收到的任务”版块相关处理
 * @Author:wx
 * @Date:Created in 17:03 2019/2/24
 * @Modified by:
 */
@Controller
public class MyReceiveController {
    @Autowired
    MyReceiveService myReceiveService;
    @Autowired
    ReleaseService releaseService;


    /**
     * 展示“我收到的任务”不同任务列表的内容
     * @param userid
     * @param optionText
     * @param request
     * @return
     */
    @GetMapping("/my_receive")
    @ResponseBody //此注解不能省略，否则Ajax不能接收返回值
    public Map myReceive(int userid, String optionText, HttpServletRequest request){

        List<Myreceive> myreceives ;

        if (!optionText.isEmpty()){
            myreceives = myReceiveService.selectIfcomByUser(userid,optionText);
            if (optionText.equals("不可信")){
                int tex=0;
                System.out.println(myreceives);
            }

        }else{
            myreceives = myReceiveService.selectByUser(userid);
        }
        List<Release> releases = new ArrayList<>();
        for (int i=0;i<myreceives.size();i++){
            Myreceive myreceive = myreceives.get(i);
            Release release = releaseService.findReleaseById(myreceive.getReleaseid());
            releases.add(release);
        }

        HttpSession session  =  request.getSession();
        User userInfo = (User) session.getAttribute("currentUser");

        Map map = new HashMap<String,List>();
        map.put("releases",releases);
        map.put("myreceives",myreceives);
        map.put("userInfo",userInfo);

        return map;
    }
}
