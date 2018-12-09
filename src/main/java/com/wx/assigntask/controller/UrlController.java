package com.wx.assigntask.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类的作用：响应url
 * @Author: wx
 * @Date: 2018/12/6 15:12
 * @Version 1.0
 */
@Controller
public class UrlController {



    @RequestMapping(value = "/index")
    public String index(){

        return "head";
    }



//    @RequestMapping(value = "/myreleasetask")
//    public String myReleaseTask(){
//        return "user/myreleasetask";
//    }

    @RequestMapping(value = "myreceivedtask")
    public String myReceivedTask(){

        return "user/myreceivedtask";
    }
}
