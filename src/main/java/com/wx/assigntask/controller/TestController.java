package com.wx.assigntask.controller;

import com.wx.assigntask.entity.TaskTest;
import com.wx.assigntask.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Author: wx
 * @Date: 2018/12/8 18:40
 * @Version 1.0
 */
@Controller
public class TestController {
    @Autowired
    TestService testService;

    @RequestMapping("/test")
    public  String divideJob(HttpServletRequest request){
         ArrayList<TaskTest> taskTests = testService.allJobInfo();
         request.setAttribute("allJobInfo",taskTests);

         //两两划分一组
         for (int i=0;i<taskTests.size();){
             List listA = (List)taskTests.get(i);
         }
   //      request.setAttribute("test",itemsAll);



        return "test";
    }
}
