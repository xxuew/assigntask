package com.wx.assigntask.controller;

import com.wx.assigntask.entity.Release;
import com.wx.assigntask.service.ReleaseService;
import com.wx.assigntask.service.UserReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyReleaseController {
    @Autowired
    UserReleaseService userReleaseService;
    @Autowired
    ReleaseService releaseService;

    @GetMapping("/my_release")
    @ResponseBody //此注解不能省略，否则Ajax不能接收返回值
    public List<Release> myRelease(int userid){

        List<Integer> releaseids = userReleaseService.selectByUser(userid);
        List<Release> releArr = new ArrayList<>();
        for (int i = 0; i < releaseids.size();i++){
            int releaseid = releaseids.get(i);
            releArr.add(releaseService.selectById(releaseid));
        }

        return releArr;
    }

}
