package com.wx.assigntask.controller;

import com.wx.assigntask.entity.User;
import com.wx.assigntask.service.ReleaseService;
import com.wx.assigntask.service.SubTaskService;
import com.wx.assigntask.service.UserReleaseService;
import com.wx.assigntask.service.UserService;
import com.wx.assigntask.tools.WriteSql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;


@RestController
public class SubmitReleaseController {
    @Autowired
    ReleaseService releaseService;
    @Autowired
    UserReleaseService userReleaseService;
    @Autowired
    SubTaskService subTaskService;

    @PostMapping("/submitrelease")
    public int upload(@RequestParam(value = "files[]",required = false) MultipartFile[] fileUpload,
                         HttpServletRequest request, HttpSession httpSession){

        //本地项目地址/target/clases
        String proPath = this.getClass().getClassLoader().getResource("").getPath();
        String filePath = proPath + "upload-files/";
        //获取文件名
       // List<String> fileNames = new ArrayList<>();
        for (int i=0;i<fileUpload.length;i++){
            String fileName = fileUpload[i].getOriginalFilename();//文件不能超过1M
            File file = new File(filePath+fileName);
            File fileParent = file.getParentFile();
            if (!fileParent.exists()){
                fileParent.mkdirs();
            }
            try {
                //将文件保存到相应路径里
                fileUpload[i].transferTo(file);
                //写入数据库
                new WriteSql().WriteSqlFile(file);
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }
        User user = (User) httpSession.getAttribute("currentUser");
        String releaseName = request.getParameter("release_name");
        String releasePlan = request.getParameter("release_plan");
        String releaseAlgs = request.getParameter("release_algs");
        int releaseid = releaseService.insertRelease(user.getUserid(),releaseName,releasePlan,releaseAlgs);
        userReleaseService.insertRecord(user.getUserid(),releaseid);

        return releaseid;
        //获取文件后缀名
//        String suffixName = fileName.substring(fileName.lastIndexOf("."));
//        //重新生成文件名
//        fileName = UUID.randomUUID()+suffixName;
        //指定本地文件夹存储图片
    }

    @PostMapping("/gensubtask")
    public  void gensubtask(@RequestParam(value = "releaseid",required = false) int releaseid){
        subTaskService.geneSubTask(releaseid);

    }
}
