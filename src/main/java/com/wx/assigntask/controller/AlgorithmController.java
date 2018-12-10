package com.wx.assigntask.controller;

import com.wx.assigntask.dao.ItemsDao;
import com.wx.assigntask.entity.Algorithm;
import com.wx.assigntask.service.*;
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
public class AlgorithmController {
    @Autowired
    AlgorithmService algorithmService;
    @Autowired
    SubTaskService subTaskService;
    @Autowired
    DividedService dividedService;
    @Autowired
    ItemsService itemsService;
    @Autowired
    ReleaseService releaseService;

    @RequestMapping("/test")
    public  String divideJob(HttpServletRequest request){

        //TODO
        // 需要再建一个task表，存放inputName、inputDes、用到的算法、complete
        //根据某次input的项目名称和所使用的算法名称得到相应的item项目名称

        String algs = releaseService.finAlgsByInputName("QQ");

        List itemsAName = algorithmService.findItemByAloName("'A'","'QQ'");
        List itemsBName = algorithmService.findItemByAloName("'B'","'QQ'");
        List itemsCName = algorithmService.findItemByAloName("'C'","'QQ'");

        //根据itemName获取相应的description
        HashMap hashMapA = new LinkedHashMap();
        HashMap hashMapB = new LinkedHashMap();
        HashMap hashMapC = new LinkedHashMap();

        for (int i=0;i<itemsAName.size();i++){
            String itemName = "'" +(String) itemsAName.get(i) + "'";
            String des = itemsService.findDesByItemsName(itemName);
            hashMapA.put(itemName,des);
        }

//
//         ArrayList<Algorithm> algorithms = algorithmService.allJobInfo(); //获取数据库中的原始任务数据
         request.setAttribute("allJobInfo", hashMapA);
        request.setAttribute("test", algs);

         //两两划分一组
//         for (int i=1;i< algorithms.size();){
//             if (algorithms.get(i).getDivided() != 1 && algorithms.get(i+1).getDivided() != 1){ //判断该算法是否被分配过,TODO id定位问题
//                    dividedService.insertDivided(i,i+1); //分配i算法和i+1为一组插入sub_divided表
//                                                            //改变algorithm表该算法的divided值为1
//                    i = i + 2;
//
//             }
//
//         }




        return "test";
    }
}
