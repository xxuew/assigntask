package com.wx.assigntask.controller;

import com.wx.assigntask.tools.Massage;
import com.wx.assigntask.tools.WriteSql;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * @Author: wx
 * @Date: 2019/1/7 10:50
 * @Version 1.0
 */
@RestController
public class PicUploadController {

    @PostMapping("/upload")
    public String upload(MultipartFile fileUpload){
        //获取文件名
        String fileName = fileUpload.getOriginalFilename(); //文件不能超过1M
        //获取文件后缀名
//        String suffixName = fileName.substring(fileName.lastIndexOf("."));
//        //重新生成文件名
//        fileName = UUID.randomUUID()+suffixName;
        //指定本地文件夹存储图片
        String filePath = "F:\\IDEAProjects\\assigntask\\src\\main\\resources\\static\\uploadsqlfiles\\";
        File file = new File(filePath+fileName);
        try {
            //将图片保存到static文件夹里
            fileUpload.transferTo(file);
            new WriteSql().WriteSqlFile(file);
            return "0,success to upload";
        } catch (Exception e) {
            e.printStackTrace();
            return "-1,fail to upload";
        }
    }
}
