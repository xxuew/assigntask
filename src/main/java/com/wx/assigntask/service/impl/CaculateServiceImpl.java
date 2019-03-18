package com.wx.assigntask.service.impl;

import com.wx.assigntask.dao.*;
import com.wx.assigntask.entity.*;
import com.wx.assigntask.service.ICaculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
        Algresult algresult1 = algresultMapper.selectByPrimaryKey(1);
        Algresult algresult2 = algresultMapper.selectByPrimaryKey(2);
        Algresult algresult3 = algresultMapper.selectByPrimaryKey(3);
        if (algresult1.getWinAlgname() == null){
            System.out.println("algresult1.getWinAlgname()："+algresult1.getWinAlgname());
            System.out.println("algresult2.getIffinal()："+algresult2.getIffinal());
            System.out.println(algresult1.getIffinal().equals("yes") );
        }
        if (algresult1.getIffinal().equals("yes")&& algresult1.getWinAlgname() == null &&
                algresult2.getIffinal().equals("yes")&& algresult2.getWinAlgname() == null &&
                algresult3.getIffinal().equals("yes")&& algresult3.getWinAlgname() == null ){
            System.out.println("内部在执行");

            for(int i = 1;i <=10000;i++){
                ScoreCnnTfidf scoreLstmNn = scoreCnnTfidfMapper.selectByPrimaryKey(i);
                SubtaskCnnTfidf subtaskLstmNn = subtaskCnnTfidfMapper.selectByPrimaryKey(i);
                if (scoreLstmNn == null){
                    scoreLstmNn = new ScoreCnnTfidf();
                    scoreLstmNn.setScorea1(0);
                    scoreLstmNn.setScorea2(0);
                    scoreLstmNn.setScorea3(0);
                    scoreLstmNn.setScoreb1(0);
                    scoreLstmNn.setScoreb2(0);
                    scoreLstmNn.setScoreb3(0);
                }
                if (scoreLstmNn.getScorea1() == null){
                    scoreLstmNn.setScorea1(0);
                }
                if (scoreLstmNn.getScorea2() == null){
                    scoreLstmNn.setScorea2(0);
                }
                if (scoreLstmNn.getScorea3() == null){
                    scoreLstmNn.setScorea3(0);
                }
                if (scoreLstmNn.getScoreb1() == null){
                    scoreLstmNn.setScoreb1(0);
                }
                if (scoreLstmNn.getScoreb2() == null){
                    scoreLstmNn.setScoreb2(0);
                }
                if (scoreLstmNn.getScoreb3() == null){
                    scoreLstmNn.setScoreb3(0);
                }
                float scorea = (scoreLstmNn.getScorea1()+scoreLstmNn.getScorea2()+scoreLstmNn.getScorea3())/5;
                float scoreb = (scoreLstmNn.getScoreb1()+scoreLstmNn.getScoreb2()+scoreLstmNn.getScoreb3())/5;
                subtaskLstmNn.setScore1(scorea);
                subtaskLstmNn.setScore2(scoreb);
                subtaskCnnTfidfMapper.updateByPrimaryKey(subtaskLstmNn);
            }


            for(int i = 1;i <=10000;i++){
                SubtaskDocIndex subtaskLstmNn = subtaskDocIndexMapper.selectByPrimaryKey(i);
                ScoreDocIndex scoreLstmNn = scoreDocIndexMapper.selectByPrimaryKey(i);
                if (scoreLstmNn == null){
                    scoreLstmNn = new ScoreDocIndex();
                    scoreLstmNn.setScorea1(0);
                    scoreLstmNn.setScorea2(0);
                    scoreLstmNn.setScorea3(0);
                    scoreLstmNn.setScoreb1(0);
                    scoreLstmNn.setScoreb2(0);
                    scoreLstmNn.setScoreb3(0);
                }
                if (scoreLstmNn.getScorea1() == null){
                    scoreLstmNn.setScorea1(0);
                }
                if (scoreLstmNn.getScorea2() == null){
                    scoreLstmNn.setScorea2(0);
                }
                if (scoreLstmNn.getScorea3() == null){
                    scoreLstmNn.setScorea3(0);
                }
                if (scoreLstmNn.getScoreb1() == null){
                    scoreLstmNn.setScoreb1(0);
                }
                if (scoreLstmNn.getScoreb2() == null){
                    scoreLstmNn.setScoreb2(0);
                }
                if (scoreLstmNn.getScoreb3() == null){
                    scoreLstmNn.setScoreb3(0);
                }

                float scorea = (scoreLstmNn.getScorea1()+scoreLstmNn.getScorea2()+scoreLstmNn.getScorea3())/5;
                float scoreb = (scoreLstmNn.getScoreb1()+scoreLstmNn.getScoreb2()+scoreLstmNn.getScoreb3())/5;
                subtaskLstmNn.setScore1(scorea);
                subtaskLstmNn.setScore2(scoreb);
                subtaskDocIndexMapper.updateByPrimaryKey(subtaskLstmNn);
            }

            for(int i = 1;i <=10000;i++){
                ScoreLstmNn scoreLstmNn = scoreLstmNnMapper.selectByPrimaryKey(i);
                SubtaskLstmNn subtaskLstmNn = subtaskLstmNnMapper.selectByPrimaryKey(i);
                if (scoreLstmNn == null){
                    scoreLstmNn = new ScoreLstmNn();
                    scoreLstmNn.setScorea1(0);
                    scoreLstmNn.setScorea2(0);
                    scoreLstmNn.setScorea3(0);
                    scoreLstmNn.setScoreb1(0);
                    scoreLstmNn.setScoreb2(0);
                    scoreLstmNn.setScoreb3(0);
                }
                if (scoreLstmNn.getScorea1() == null){
                    scoreLstmNn.setScorea1(0);
                }
                if (scoreLstmNn.getScorea2() == null){
                    scoreLstmNn.setScorea2(0);
                }
                if (scoreLstmNn.getScorea3() == null){
                    scoreLstmNn.setScorea3(0);
                }
                if (scoreLstmNn.getScoreb1() == null){
                    scoreLstmNn.setScoreb1(0);
                }
                if (scoreLstmNn.getScoreb2() == null){
                    scoreLstmNn.setScoreb2(0);
                }
                if (scoreLstmNn.getScoreb3() == null){
                    scoreLstmNn.setScoreb3(0);
                }
                float scorea = (scoreLstmNn.getScorea1()+scoreLstmNn.getScorea2()+scoreLstmNn.getScorea3())/5;
                float scoreb = (scoreLstmNn.getScoreb1()+scoreLstmNn.getScoreb2()+scoreLstmNn.getScoreb3())/5;
                subtaskLstmNn.setScore1(scorea);
                subtaskLstmNn.setScore2(scoreb);
                subtaskLstmNnMapper.updateByPrimaryKey(subtaskLstmNn);
            }


            System.out.println("完成第一部分");
            for (int i = 1;i<=10000;i++){
                cnn = cnn +subtaskCnnTfidfMapper.selectByPrimaryKey(i).getScore1();
                tfidf = tfidf + subtaskCnnTfidfMapper.selectByPrimaryKey(i).getScore2();
            }
            Algresult cnntfidf = algresultMapper.selectByPrimaryKey(1);
            score1 = cnn/10000;
            score2 = tfidf/10000;
            cnntfidf.setScore1(score1);
            cnntfidf.setScore2(score2);
            taskNum = taskNumMapper.selectById(4);
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
            taskNum = taskNumMapper.selectById(5);
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
            taskNum = taskNumMapper.selectById(6);
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

            System.out.println("完成第二部分");
        }
    }
}
