package com.wx.assigntask.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: wx
 * @Date: 2019/1/7 10:41
 * @Version 1.0
 */
@Controller
public class ToHtmlController {
    @RequestMapping("/picUpload")
    public String picUpload(){
        return "user/picUpload";
    }
}
