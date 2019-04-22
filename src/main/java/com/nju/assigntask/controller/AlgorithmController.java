//package com.wx.assigntask.controller;
//
//import com.wx.assigntask.service.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.*;
//
///**
// * @Author: wx
// * @Date: 2018/12/8 18:40
// * @Version 1.0
// */
//@Controller
//public class AlgorithmController {
//
//    @Autowired
//    SubTaskService subTaskService;
//    @Autowired
//    DividedService dividedService;
//
//    @Autowired
//    ReleaseService releaseService;
//    @Autowired
//    UserTaskService userTaskService;
//
//    @RequestMapping("/test1")
//    public  String divideJob(HttpServletRequest request){
//
//
//        //根据某次input的项目名称获取所使用的算法名称
//         List algs = releaseService.finAlgsByInputName("QQ");
//
//        //TODO
//        //整合一下，写死了 ，获取算法相应的item名称
////        List itemsAName = algorithmService.findItemByAloName("A","QQ");
////        List itemsBName = algorithmService.findItemByAloName("B","QQ");
////        List itemsCName = algorithmService.findItemByAloName("C","QQ");
//
//        //插入divided表，两两分配，AB一组，C暂时不分配
//        for (int i=0;i<algs.size()-1;){
//            String alg1 = algs.get(i).toString();
//            String alg2 = algs.get(i+1).toString();
//            String alg1Divided = releaseService.findDivided("QQ",alg1); //alg1算法是否已分配
//            String alg2Divided = releaseService.findDivided("QQ",alg2);
//            if (!(alg1Divided.equals("yes")) && (!alg2Divided.equals("yes")) ){
//                int dividedId = dividedService.insertDivided(alg1,alg2);
//                releaseService.updateDivided("yes","QQ",alg1);
//                releaseService.updateDivided("yes","QQ",alg2);
//
//                //根据itemName获取相应的description
////                HashMap hashMapA = new LinkedHashMap();
////                for (int j=0;j<itemsAName.size();j++){
////
////                    String itemName=itemsAName.get(j).toString();
////                    String des = itemsService.findDesByItemsName(itemName);
////                    hashMapA.put(itemName,des);
////                }
////
////                HashMap hashMapB = new LinkedHashMap();
////                for (int k=0;k<itemsBName.size();k++){
////                    String itemName=itemsBName.get(k).toString();
////                    String des = itemsService.findDesByItemsName(itemName);
////                    hashMapB.put(itemName,des);
////                }
//
//                //生成子任务插入subtask表
//                // int dividedId = dividedService.findDividedIdByAlgs(alg1,alg2);
////                Iterator iterator1 = hashMapA.keySet().iterator();
////
////                while (iterator1.hasNext() ){
////                    String item1Name = iterator1.next().toString();
////                    String item1Des = hashMapA.get(item1Name).toString();
////                    Iterator iterator2 = hashMapB.keySet().iterator();
////                    while (iterator2.hasNext()){
////                        String item2Name = iterator2.next().toString();
////                        String item2Des = hashMapB.get(item2Name).toString();
////                        subTaskService.insertSubTask(dividedId,item1Name,item1Des,item2Name,item2Des);
////                    }
//                }
//            i =i +2;
//            }
//
//
//        //TODO 分派给用户，具体分派方案：尽量不出现重复项目，没人分派10个，每个项目被分派给10个人
//        //给ID为1的用户插入10个subtask
////        for (int i=1;i<= 10 ;i++){
////            int userId = 1;
////            int taskId = i;
////            userTaskService.assignTaskToU(userId,taskId);
////        }
//
//
////        HashMap hashMapC = new LinkedHashMap();
////
////        for (int i=0;i<itemsCName.size();i++){
////            String itemName=itemsCName.get(i).toString();
////            String des=itemsService.findDesByItemsName(itemName);
////            hashMapC.put(i,des);
////        }
//
////
////         ArrayList<Algorithm> algorithms = algorithmService.allJobInfo(); //获取数据库中的原始任务数据
//
//
//         //两两划分一组
////         for (int i=1;i< algorithms.size();){
////             if (algorithms.get(i).getDivided() != 1 && algorithms.get(i+1).getDivided() != 1){ //判断该算法是否被分配过,TODO id定位问题
////                    dividedService.insertDivided(i,i+1); //分配i算法和i+1为一组插入sub_divided表
////                                                            //改变algorithm表该算法的divided值为1
////                    i = i + 2;
////
////             }
////
////         }
//
//        return "test";
//    }
//
//    @RequestMapping("/myreceivedtask")
//    public ModelAndView taskLists(){
//        List taskList = userTaskService.findByUserId(1);
//        ModelAndView modelAndView = new ModelAndView("user/myreceivedtask");
//        modelAndView.addObject("taskList",taskList);
//        return modelAndView;
//    }
//}
//
//
