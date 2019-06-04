package com.nju.assigntask.controller;

import com.nju.assigntask.dao.ReleaseMapper;
import com.nju.assigntask.entity.Release;
import com.nju.assigntask.service.ReleaseService;
import com.nju.assigntask.service.SubTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * “我发布的项目”版块相关处理
 */
@Controller
public class MyReleaseController {

    @Autowired
    ReleaseService releaseService;
    @Autowired
    SubTaskService subTaskService;
    @Autowired
    ReleaseMapper releaseMapper;

    /**
     * 展示“我收到的任务”不同任务列表的内容
     * @param userid
     * @return
     */
    @GetMapping("/my_release")
    @ResponseBody //此注解不能省略，否则Ajax不能接收返回值
    public List<Release> myRelease(int userid) {

        List<Release> releArr = releaseService.selectByUserid(userid);

        return releArr;
    }

    /**
     * 评价项目结果
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/addPj")
    @ResponseBody
    public String addPj(HttpServletRequest request, HttpServletResponse response){

        String satisfaction = request.getParameter("optionText");
        String releaseIdStr= request.getParameter("releaseId");
        if(releaseIdStr == null || releaseIdStr == "" ){
            return null;
        }
        try{
            Integer releaseId = Integer.parseInt(releaseIdStr.trim());
            if(satisfaction == null || satisfaction == ""){
                return  null;
            }
            if(releaseService.updateSatisById(releaseId,satisfaction)){
                return  "success";
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
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
