//package com.wx.assigntask.controller;
//
//import com.wx.assigntask.dao.tool.CheckTableMapper;
//import com.wx.assigntask.service.SubTaskService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//import java.util.Map;
//
///**
// * @Author: wx
// * @Date: 2019/1/7 10:41
// * @Version 1.0
// */
//
///**
// * 该处URL都未在系统中使用，仅用于测试
// */
//@Controller
//public class ToHtmlController {
//
//   @Autowired
//    SubTaskService subTaskService;
//   @Autowired
//    CheckTableMapper checkTableMapper;
//
//    @RequestMapping("/picUpload")
//    public String picUpload(){
//        return "user/picUpload";
//    }
//
//    @RequestMapping("/index")
//    public String templeteIndex(){
//        return "index";
//    }
//
//    @RequestMapping("/login")
//    public String templeteLogin(){
//        return "templete/login";
//    }
//
//    @RequestMapping("/general")
//    public String templeteGernal(){
//        return "templete/general";
//    }
//
//    @RequestMapping("/ahpCreateTask")
//    public void ahpCreateTask(){
//
////       subTaskService.geneSubTask();
////        return "templete/general";
//    }
//
//    @RequestMapping("/testCheckTble")
//    public void checkTable(){
//        List<Map> checkTables = checkTableMapper.selectColNameType("algresult");
//        for (int i = 0;i<checkTables.size();i++){
//            Map checkTable = checkTables.get(i);
////            String columnname = checkTable.getColumnname();
////            String datatype = checkTable.getDatatype();
////            System.out.println(columnname + " ###### " +datatype);
//        }
//    }
//
//    @RequestMapping("/handleGrubbs")
//    public String grubbs(HttpServletRequest request){
//
////        ModifiedGrubbs grubbs = new ModifiedGrubbs();
//////         List<Double> matrix = (List<Double>) request.getSession().getAttribute("grubbsMatrix");
//////         String queryString []=   request.getQueryString().replace("+"," ").split("");
////        List<Double> matrix2 = new ArrayList<>();
////        String queryString [] = request.getParameter("grubbsMatrix").split(" ");
////        for (int i =0;i<queryString.length;i++){
////            matrix2.add((double)new Integer(queryString[i]));
////        }
//////        grubbs.judgeGrubbs(matrix);
////        List<Double> resultMatrix =  grubbs.judgeGrubbs(matrix2);
////        request.setAttribute("resultMatrix:",resultMatrix);
////        return resultMatrix;
////        return "templete/general";
//        return "ok";
//    }
//}
