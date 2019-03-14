package com.wx.assigntask.service.impl;

import com.wx.assigntask.dao.*;
import com.wx.assigntask.entity.*;
import com.wx.assigntask.service.ICaculateService;
import org.springframework.beans.factory.annotation.Autowired;

public class CaculateServiceImpl implements ICaculateService {
    @Autowired
    ScoreLstmNnMapper scoreLstmNnMapper;
    @Autowired
    ScoreDocIndexMapper scoreDocIndexMapper;
    @Autowired
    ScoreCnnTfidfMapper scoreCnnTfidfMapper;
    @Autowired
    SubtaskDocIndexMapper subtaskDocIndexMapper;
    @Autowired
    SubtaskLstmNnMapper subtaskLstmNnMapper;
    @Autowired
    SubtaskCnnTfidfMapper subtaskCnnTfidfMapper;
    @Autowired
    AlgresultMapper algresultMapper;
    @Autowired
    TaskNumMapper taskNumMapper;

    @Override
    public void caculate() {
        TaskNum taskNum;
        float doc = 0,index= 0,lstm= 0,nn= 0,cnn= 0,tfidf = 0,score1 = 0,score2 = 0;
        for(int i = 1;i <=10000;i++){
            ScoreDocIndex scoreLstmNn = scoreDocIndexMapper.selectByPrimaryKey(i);
            SubtaskDocIndex subtaskLstmNn = subtaskDocIndexMapper.selectByPrimaryKey(i);
            float scorea = (scoreLstmNn.getScorea1()+scoreLstmNn.getScorea2()+scoreLstmNn.getScorea3()+
                    scoreLstmNn.getScorea4()+scoreLstmNn.getScorea5())/5;
            float scoreb = (scoreLstmNn.getScoreb1()+scoreLstmNn.getScoreb2()+scoreLstmNn.getScoreb3()+
                    scoreLstmNn.getScoreb4()+scoreLstmNn.getScoreb5())/5;
            subtaskLstmNn.setScore1(scorea);
            subtaskLstmNn.setScore2(scoreb);
            subtaskDocIndexMapper.updateByPrimaryKey(subtaskLstmNn);
        }

        for(int i = 1;i <=10000;i++){
            ScoreLstmNn scoreLstmNn = scoreLstmNnMapper.selectByPrimaryKey(i);
            SubtaskLstmNn subtaskLstmNn = subtaskLstmNnMapper.selectByPrimaryKey(i);
            float scorea = (scoreLstmNn.getScorea1()+scoreLstmNn.getScorea2()+scoreLstmNn.getScorea3()+
                    scoreLstmNn.getScorea4()+scoreLstmNn.getScorea5())/5;
            float scoreb = (scoreLstmNn.getScoreb1()+scoreLstmNn.getScoreb2()+scoreLstmNn.getScoreb3()+
                    scoreLstmNn.getScoreb4()+scoreLstmNn.getScoreb5())/5;
            subtaskLstmNn.setScore1(scorea);
            subtaskLstmNn.setScore2(scoreb);
            subtaskLstmNnMapper.updateByPrimaryKey(subtaskLstmNn);
        }

        for(int i = 1;i <=10000;i++){
            ScoreCnnTfidf scoreLstmNn = scoreCnnTfidfMapper.selectByPrimaryKey(i);
            SubtaskCnnTfidf subtaskLstmNn = subtaskCnnTfidfMapper.selectByPrimaryKey(i);
            float scorea = (scoreLstmNn.getScorea1()+scoreLstmNn.getScorea2()+scoreLstmNn.getScorea3()+
                    scoreLstmNn.getScorea4()+scoreLstmNn.getScorea5())/5;
            float scoreb = (scoreLstmNn.getScoreb1()+scoreLstmNn.getScoreb2()+scoreLstmNn.getScoreb3()+
                    scoreLstmNn.getScoreb4()+scoreLstmNn.getScoreb5())/5;
            subtaskLstmNn.setScore1(scorea);
            subtaskLstmNn.setScore2(scoreb);
            subtaskCnnTfidfMapper.updateByPrimaryKey(subtaskLstmNn);
        }


        for (int i = 1;i<=10000;i++){
            cnn = cnn +subtaskCnnTfidfMapper.selectByPrimaryKey(i).getScore1();
            tfidf = tfidf + subtaskCnnTfidfMapper.selectByPrimaryKey(i).getScore2();
        }
        Algresult cnntfidf = algresultMapper.selectByPrimaryKey(1);
        score1 = cnn/10000;
        score2 = tfidf/10000;
        cnntfidf.setScore1(score1);
        cnntfidf.setScore2(score2);
        taskNum = taskNumMapper.selectById(6);
        if(score1 >= score2){
            taskNum.setAlgo("cnn");
            taskNumMapper.update(taskNum);
            cnntfidf.setWinAlgname("cnn");
        }else{
            taskNum.setAlgo("tfidf");
            taskNumMapper.update(taskNum);
            cnntfidf.setWinAlgname("tfidf");
        }
        algresultMapper.updateByPrimaryKey(cnntfidf);



        for (int i = 1;i<=10000;i++){
            doc = doc +subtaskDocIndexMapper.selectByPrimaryKey(i).getScore1();
            index = index + subtaskDocIndexMapper.selectByPrimaryKey(i).getScore2();
        }
        Algresult algresult = algresultMapper.selectByPrimaryKey(2);
        score1 = doc/10000;
        score2 = index/10000;
        algresult.setScore1(score1);
        algresult.setScore2(score2);
        taskNum = taskNumMapper.selectById(7);
        if(score1 >= score2){
            taskNum.setAlgo("doc");
            taskNumMapper.update(taskNum);
            algresult.setWinAlgname("doc");
        }else{
            taskNum.setAlgo("index");
            taskNumMapper.update(taskNum);
            algresult.setWinAlgname("index");
        }
        algresultMapper.updateByPrimaryKey(algresult);




        for (int i = 1;i<=10000;i++){
            lstm = lstm +subtaskLstmNnMapper.selectByPrimaryKey(i).getScore1();
            nn = nn + subtaskLstmNnMapper.selectByPrimaryKey(i).getScore2();
        }
        Algresult lstm_nn = algresultMapper.selectByPrimaryKey(3);
        score1 = lstm/10000;
        score2 = nn/10000;
        lstm_nn.setScore1(score1);
        lstm_nn.setScore2(score2);
        taskNum = taskNumMapper.selectById(8);
        if(score1 >= score2){
            taskNum.setAlgo("lstm");
            taskNumMapper.update(taskNum);
            lstm_nn.setWinAlgname("lstm");
        }else{
            taskNum.setAlgo("nn");
            taskNumMapper.update(taskNum);
            lstm_nn.setWinAlgname("nn");
        }
        algresultMapper.updateByPrimaryKey(lstm_nn);
    }
}
