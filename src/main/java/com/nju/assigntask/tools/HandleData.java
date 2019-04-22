package com.nju.assigntask.tools;

import com.nju.assigntask.dao.AlgresultMapper;
import com.nju.assigntask.dao.DividedMapper;
import com.nju.assigntask.dao.SubtaskMapper;
import com.nju.assigntask.dao.UserreceiveMapper;
import com.nju.assigntask.entity.Algresult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:wx
 * @Date:Created in 9:04 2019/3/15
 * @Modified by:
 */
@Component
public class HandleData {
    @Autowired
    SubtaskMapper subtaskMapper;
    @Autowired
    DividedMapper dividedMapper;
    @Autowired
    UserreceiveMapper userreceiveMapper;
    @Autowired
    Grubbs grubbs;
    @Autowired
    Constant constant;
    @Autowired
    AlgresultMapper algresultMapper;

    public boolean judgeComment(List<Double> data){

        //判断相同数据比例
        //if<90% return true  比例写在Constant
        //else

        return false;
    }

    public void handleSubtaskData() {

        List<Integer> nullScore1Ids = subtaskMapper.selectNullScore1();//从subtask表获取score为null的subtaskid
        List<Integer> nullScore2Ids = subtaskMapper.selectNullScore2();
        for (int i = 0; i < nullScore1Ids.size(); i++) {
            int subtaskid = nullScore1Ids.get(i);

            List<Double> score1Data = userreceiveMapper.selectScore1BySubtaskId(subtaskid); //关于subtaskid的score1
            boolean ifhandle = judgeIfHandle(score1Data); //判断是否可以处理
            if (ifhandle == true){
                double score1 = handleResultScore(score1Data);
                subtaskMapper.updateScore1( subtaskid,score1); //更新subtask表的score1
            }
        }
        for (int i = 0; i < nullScore2Ids.size(); i++) {
            int subtaskid = nullScore2Ids.get(i);
            List<Double> score2Data = userreceiveMapper.selectScore2BySubtaskId(subtaskid); //关于subtaskid的score1
            boolean ifhandle = judgeIfHandle(score2Data); //判断是否可以处理
            if (ifhandle == true){

                score2Data = grubbs.judgeGrubbs(score2Data); //去可疑值
                double score2 = grubbs.calcAverage(score2Data);//求平均值
                subtaskMapper.updateScore2( subtaskid,score2); //更新subtask表的score2
            }
        }
    }

    public void handleIntraSubtaskDate(){
        //处理内部排序产生的subtask的score
    }

    public void handleDividedData() {
        List<Integer> nullScore1Ids = dividedMapper.selectNullScore1();//从divided表获取score为null的dividedid
        List<Integer> nullScore2Ids = dividedMapper.selectNullScore2();
        for (int i=0;i<nullScore1Ids.size();i++){
            int dividedid = nullScore1Ids.get(i);
//            int score1 = selectSumScore1(dividedid,plan,algName1,algName2);//根据subtaskid从usertask表获取score平均值
            List<Double> score1Data = subtaskMapper.selectScore1ByDividedid(dividedid);
            boolean ifhandle = judgeIfHandle(score1Data); //判断是否可以处理
            if (ifhandle == true){
//                score1Data = grubbs.judgeGrubbs(score1Data);//去可疑值
//                double score1 = grubbs.calcAverage(score1Data); //平均值
                double score1 = handleResultScore(score1Data);
                dividedMapper.updateScore1(dividedid,score1); //更新divided表的score1
            }
        }
        for (int i=0;i<nullScore2Ids.size();i++){
            int dividedid = nullScore2Ids.get(i);
      //      int score2 = selectSumScore2(dividedid,plan,algName1,algName2);//从usertask表获取score平均值
            List<Double> score2Data = subtaskMapper.selectScore2ByDividedid(dividedid);
            boolean ifhandle = judgeIfHandle(score2Data); //判断是否可以处理
            if (ifhandle == true){

                double score2 = handleResultScore(score2Data);
                dividedMapper.updateScore2(dividedid,score2); //更新divided表的score2
            }
        }
    }

    /**
     * 获取algresult表winalgname is null的记录，处理该记录获得score以及winalgname
     */
    public void handleAlgResult() {
        List<Algresult> algresults = algresultMapper.selectNullWinAlgs();
        for (int i=0;i<algresults.size();i++){
            Algresult algresult = algresults.get(i);

            List<Double> score1Data = dividedMapper.selectScore1Data(algresult.getReleaseid(),algresult.getAlgname1(),algresult.getAlgname2());
            boolean ifhandlescore1 = judgeIfHandle(score1Data); //判断是否可以处理
            if (ifhandlescore1 ==true) {

                double score1 = handleResultScore(score1Data);
                algresultMapper.updateScore1(algresult.getId(), score1);
                algresult.setScore1(score1);
            }
            List<Double> score2Data = dividedMapper.selectScore2Data(algresult.getReleaseid(),algresult.getAlgname1(),algresult.getAlgname2());
            boolean ifhandlescore2 = judgeIfHandle(score2Data); //判断是否可以处理
            if (ifhandlescore2 == true){

                double score2 = handleResultScore(score2Data);
                algresultMapper.updateScore2(algresult.getId(),score2);
                algresult.setScore2(score2);
            }
            if (algresult.getScore1()!=-1 && algresult.getScore2()!=-1 &&
                    algresult.getScore1() !=0 && algresult.getScore2()!=0){
                //初始值为-1
                if (algresult.getScore1() >=algresult.getScore2()){
                    algresult.setWinalgname(algresult.getAlgname1());
                    algresultMapper.updateWinAlg(algresult);
                }else {
                    algresult.setWinalgname(algresult.getAlgname2());
                    algresultMapper.updateWinAlg(algresult);
                }
            }
        }
    }

    /**
     * 判断是否可以处理处理该组数据，若有任务还未评分完毕则暂不处理，返回false
     * @param data
     * @return
     */
    public boolean judgeIfHandle(List<Double> data){
        int nullCount = 0;
        for (int j=0;j<data.size();j++){
            if (data.get(j) == -1){
                nullCount++;
            }
        }
        if (nullCount > 0) {
            //说明有的还未评分，暂不处理
            return false;
        }else {
            return true;
        }
    }

    /**
     * 调用Grubbs去可疑值，本项目Grubbs测定的一组数据不超过25个，因此超出25个数据时，分组检测
     * @param scoreData
     * @return
     */
    public double handleResultScore(List<Double> scoreData){
        double score = 0;
        if (scoreData.size()>24){
            int count = 0;
            if (scoreData.size()%24 != 0){
                count = scoreData.size()/24 +1;
            }else {
                count = scoreData.size()/24;
            }
            List<Double> resultData = new ArrayList<>();//存放grubbs处理后的所有数据
            for (int j=0;j<count;j++){
                List<Double> data = new ArrayList<>();
                for (int z=j*24;data.size()<24&&z<scoreData.size();z++){
                    data.add(scoreData.get(z));  //每24个数一组去可疑值
                }
                data = grubbs.judgeGrubbs(data); //去可疑值
                resultData.addAll(data); //汇总到resultData
            }
            score = grubbs.calcAverage(resultData);//求平均值
        }else {
            scoreData = grubbs.judgeGrubbs(scoreData); //去可疑值
            score = grubbs.calcAverage(scoreData);//求平均值
        }

        return score;
    }

    public String getWinalgName(List<double[]> comWeight,List algs){
        //求算法A的最终权重，因为A在input1出现，在input2出现，因此A的权重为两次平均值
        double[] algFinalResult = new double[comWeight.get(0).length];

        for (int i=0;i<comWeight.get(0).length;i++){
            double sumScore = 0;
            for (int j=0;j<comWeight.size();j++){
                sumScore = sumScore + comWeight.get(j)[i];
            }
            double aveScore = sumScore/comWeight.size();
            algFinalResult[i] = aveScore;
        }
        int index = getMax(algFinalResult);
        return algs.get(index).toString();
    }

    public int getMax(double[] data){
        int result = -1;
        for (int i=0;i<data.length-1;i++){
            if (data[i] > data[i+1]){
                result = i;
            }
        }
        return result;
    }
}