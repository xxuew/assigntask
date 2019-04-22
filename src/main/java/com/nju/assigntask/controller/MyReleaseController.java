package com.nju.assigntask.controller;

import com.nju.assigntask.dao.ReleaseMapper;
import com.nju.assigntask.entity.Release;
import com.nju.assigntask.service.ReleaseService;
import com.nju.assigntask.service.SubTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MyReleaseController {

    @Autowired
    ReleaseService releaseService;
    @Autowired
    SubTaskService subTaskService;
    @Autowired
    ReleaseMapper releaseMapper;

    @GetMapping("/my_release")
    @ResponseBody //此注解不能省略，否则Ajax不能接收返回值
    public List<Release> myRelease(int userid) {

        List<Release> releArr = releaseService.selectByUserid(userid);

        return releArr;
    }

//    /**
//     * 调用生成子任务接口
//     */
//    @PostMapping("/gensubtask")
//    public String gensubtask() {
//        List<Release> releases = releaseMapper.selectAllUnComplete(); //所有未完成的项目
//        if (releases.size() == 0) {
//            return "无待评估项目";
//        } else {
//            subTaskService.geneSubTask(releases);
//            return "评估项目中";
//        }
//    }
}
