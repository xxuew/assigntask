package com.wx.assigntask.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: wx
 * @Date: 2019/1/7 10:41
 * @Version 1.0
 */

/**
 * 该处URL都未在系统中使用，仅用于测试
 */
@Controller
public class ToHtmlController {
    @RequestMapping("/picUpload")
    public String picUpload(){
        return "user/picUpload";
    }

    @RequestMapping("/index")
    public String templeteIndex(){
        return "index";
    }

    @RequestMapping("/login")
    public String templeteLogin(){
        return "templete/login";
    }

    @RequestMapping("/general")
    public String templeteGernal(){
        return "templete/general";
    }
}
