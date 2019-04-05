//package com.wx.assigntask.tools;
//
//import com.wx.assigntask.dao.AlgresultMapper;
//import com.wx.assigntask.dao.DividedMapper;
//import com.wx.assigntask.dao.SubtaskMapper;
//import com.wx.assigntask.dao.UserreceiveMapper;
//import com.wx.assigntask.entity.Algresult;
//import com.wx.assigntask.entity.Divided;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Author:wx
// * @Date:Created in 9:04 2019/3/15
// * @Modified by:
// */
//public class HandleData {
//    @Autowired
//    SubtaskMapper subtaskMapper;
//    @Autowired
//    DividedMapper dividedMapper;
//    @Autowired
//    UserreceiveMapper userreceiveMapper;
//    @Autowired
//    ModifiedGrubbs grubbs;
//    @Autowired
//    Constant constant;
//    @Autowired
//    AlgresultMapper algresultMapper;
//
//    public boolean judgeComment(List<Double> data){
//
//        //判断相同数据比例
//        //if<90% return true  比例写在Constant
//        //else
//
//        return false;
//    }
//
//    public void handleSubtaskData(int plan) {
//
//        List<Integer> nullScore1Ids = subtaskMapper.selectNullScore1();//从subtask表获取score为null的subtaskid
//        List<Integer> nullScore2Ids = subtaskMapper.selectNullScore2();
//        for (int i = 0; i < nullScore1Ids.size(); i++) {
//            int subtaskid = nullScore1Ids.get(i);
//            Divided divided = dividedMapper.selectByPrimaryKey(subtaskMapper.selectByPrimaryKey(subtaskid).getDividedid());
////            int score1 = userReceiveService.selectAveScore1(subtaskid);//根据subtaskid从usertask表获取score平均值
////            updateScore1(score1,subtaskid,plan,divided.getAlgname1(),divided.getAlgname2());
//            List score1Data = userreceiveMapper.selectScore1BySubtaskId(int subtaskid); //关于subtaskid的score1
//            score1Data = grubbs.judgeGrubbs(score1Data); //去可疑值
//            double score1 = grubbs.calcAverage(score1Data);//求平均值
//            subtaskMapper.updateScore1( int subtaskid, double score1);//score2同理
//
//        }
//        for (int i = 0; i < nullScore2Ids.size(); i++) {
//            int subtaskid = nullScore2Ids.get(i);
//            Divided divided = dividedMapper.selectByPrimaryKey(subtaskMapper.selectByPrimaryKey(subtaskid).getDividedid());
//            int score2 = userreceiveMapper.selectAveScore2(subtaskid);//从usertask表获取score平均值
//            userreceiveMapper(score2, subtaskid, plan, divided.getAlgname1(), divided.getAlgname2());
//        }
//    }
//
//    public void handleDividedData(int plan,String algName1,String algName2) {
//        List<Integer> nullScore1Ids = dividedMapper.selectNullScore1();//从divided表获取score为null的dividedid
//        List<Integer> nullScore2Ids = dividedMapper.selectNullScore2();
//        for (int i=0;i<nullScore1Ids.size();i++){
//            int dividedid = nullScore1Ids.get(i);
////            int score1 = selectSumScore1(dividedid,plan,algName1,algName2);//根据subtaskid从usertask表获取score平均值
//            List<Double> score1Data = subtaskMapper.selectScore1ByDividedid(int dividedid);
//            score1Data = grubbs.judgeGrubbs(score1Data);//去可疑值
//            double score1 = grubbs.calcAverage(score1Data);
//            dividedMapper.updateScore1(score1,dividedid);
//        }
//        for (int i=0;i<nullScore2Ids.size();i++){
//            int dividedid = nullScore1Ids.get(i);
//            int score2 = selectSumScore2(dividedid,plan,algName1,algName2);//从usertask表获取score平均值
//            dividedService.updateScore2(score2,dividedid);
//        }
//    }
//
//    public void handleAlgResult() {
//        List<Algresult> algresults = algresultMapper.selectNullWinAlgs();
//        for (int i=0;i<algresults.size();i++){
//            Algresult algresult = algresults.get(i);
//            List score1Data = dividedMapper.selectScore1Data(algresult.getReleaseid(),algresult.getAlgname1(),algresult.getAlgname2());
//            score1Data = grubbs.judgeGrubbs(score1Data);
//            double score1 = grubbs.calcAverage(score1Data);
////            float score1 = dividedMapper.getAveScore1(algresult.getReleaseid(),algresult.getAlgname1(),algresult.getAlgname2());
//            float score2 = dividedMapper.getAveScore2(algresult.getReleaseid(),algresult.getAlgname1(),algresult.getAlgname2());
//            algresult.setScore1(score1);
//            algresult.setScore2(score2);
//            algresultMapper.updateScore(algresult.getId(),double score1,double score2);
//            if (score1 >=score2){
//                algresult.setWinalgname(algresult.getAlgname1());
//                algresultMapper.updateWinAlg(algresult);
//            }else {
//                algresult.setWinalgname(algresult.getAlgname2());
//                algresultMapper.updateWinAlg(algresult);
//            }
//        }
//    }
//}