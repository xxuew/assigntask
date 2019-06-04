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
    ScoreFinal1Mapper scoreFinal1;
    @Autowired
    ScoreFinal2Mapper scoreFinal2;
    @Autowired
    ScoreFinal3Mapper scoreFinal3;
    @Autowired
    SubtaskDocIndexMapper subtaskDocIndexMapper;
    @Autowired
    SubtaskLstmNnMapper subtaskLstmNnMapper;
    @Autowired
    SubtaskCnnTfidfMapper subtaskCnnTfidfMapper;
    @Autowired
    SubtaskCnnIndexMapper subtaskCnnIndexMapper;
    @Autowired
    SubtaskCnnNnMapper subtaskCnnNnMapper;
    @Autowired
    SubtaskIndexNnMapper subtaskIndexNnMapper;
    @Autowired
    AlgresultMapper algresultMapper;
    @Autowired
    TaskNumMapper taskNumMapper;
    @Autowired
    ProcessCnnIndexMapper processCnnIndexMapper;
    @Autowired
    ProcessCnnNnMapper processCnnNnMapper;
    @Autowired
    ProcessCnnTfidfMapper processCnnTfidfMapper;
    @Autowired
    ProcessDocIndexMapper processDocIndexMapper;
    @Autowired
    ProcessIndexNnMapper processIndexNnMapper;
    @Autowired
    ProcessLstmNnMapper processLstmNnMapper;
    @Autowired
    ResultCnnIndexMapper resultCnnIndexMapper;
    @Autowired
    ResultCnnNnMapper resultCnnNnMapper;
    @Autowired
    ResultCnnTfidfMapper resultCnnTfidfMapper;
    @Autowired
    ResultDocIndexMapper resultDocIndexMapper;
    @Autowired
    ResultIndexNnMapper resultIndexNnMapper;
    @Autowired
    ResultLstmNnMapper resultLstmNnMapper;


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


    @Override
    public void caculatePartOne() {
        TaskNum taskNum;
        float doc = 0,index= 0,lstm= 0,nn= 0,cnn= 0,tfidf = 0,score1 = 0,score2 = 0;
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
            int num = 0;
            if (scoreLstmNn.getScorea1() != 0){
                num=num+1;
            }
            if (scoreLstmNn.getScorea2() != 0){
                num=num+1;
            }
            if (scoreLstmNn.getScorea3() != 0){
                num=num+1;
            }

            float scorea = (scoreLstmNn.getScorea1()+scoreLstmNn.getScorea2()+scoreLstmNn.getScorea3())/num;
            num = 0;
            if (scoreLstmNn.getScoreb1() != 0){
                num=num+1;
            }
            if (scoreLstmNn.getScoreb2() != 0){
                num=num+1;
            }
            if (scoreLstmNn.getScoreb3() != 0){
                num=num+1;
            }
            float scoreb = (scoreLstmNn.getScoreb1()+scoreLstmNn.getScoreb2()+scoreLstmNn.getScoreb3())/num;
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

            int num = 0;
            if (scoreLstmNn.getScorea1() != 0){
                num=num+1;
            }
            if (scoreLstmNn.getScorea2() != 0){
                num=num+1;
            }
            if (scoreLstmNn.getScorea3() != 0){
                num=num+1;
            }
            float scorea = (scoreLstmNn.getScorea1()+scoreLstmNn.getScorea2()+scoreLstmNn.getScorea3())/num;

            num = 0;
            if (scoreLstmNn.getScorea1() != 0){
                num=num+1;
            }
            if (scoreLstmNn.getScorea2() != 0){
                num=num+1;
            }
            if (scoreLstmNn.getScorea3() != 0){
                num=num+1;
            }
            float scoreb = (scoreLstmNn.getScoreb1()+scoreLstmNn.getScoreb2()+scoreLstmNn.getScoreb3())/num;
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
                int num = 0;
                if (scoreLstmNn.getScorea1() != 0){
                    num=num+1;
                }
                if (scoreLstmNn.getScorea2() != 0){
                    num=num+1;
                }
                if (scoreLstmNn.getScorea3() != 0){
                    num=num+1;
                }
                float scorea = (scoreLstmNn.getScorea1()+scoreLstmNn.getScorea2()+scoreLstmNn.getScorea3())/num;
                num = 0;
                if (scoreLstmNn.getScorea1() != 0){
                    num=num+1;
                }
                if (scoreLstmNn.getScorea2() != 0){
                    num=num+1;
                }
                if (scoreLstmNn.getScorea3() != 0){
                    num=num+1;
                }
                float scoreb = (scoreLstmNn.getScoreb1()+scoreLstmNn.getScoreb2()+scoreLstmNn.getScoreb3())/num;
                subtaskLstmNn.setScore1(scorea);
                subtaskLstmNn.setScore2(scoreb);
                subtaskLstmNnMapper.updateByPrimaryKey(subtaskLstmNn);
            }
            System.out.println("完成第一部分");

    }

    @Override
    public void caculatePartTwo(){
        for(int i = 1;i <=10000;i++){
            ScoreFinal1 scoreFinal = scoreFinal1.selectByPrimaryKey(i);
            SubtaskCnnIndex subtaskCnnIndex = subtaskCnnIndexMapper.selectByPrimaryKey(i);
            if (scoreFinal.getScorea3() != null){
                subtaskCnnIndex.setScore1((float)scoreFinal.getScorea3());
                subtaskCnnIndex.setScore2((float)scoreFinal.getScoreb3());
                subtaskCnnIndexMapper.updateByPrimaryKey(subtaskCnnIndex);
            }

            }
        for(int i = 1;i <=10000;i++){
            ScoreFinal2 scoreFinal = scoreFinal2.selectByPrimaryKey(i);
            SubtaskCnnNn subtaskCnnIndex = subtaskCnnNnMapper.selectByPrimaryKey(i);
            if (scoreFinal.getScorea3() != null) {
                subtaskCnnIndex.setScore1((float) scoreFinal.getScorea3());
                subtaskCnnIndex.setScore2((float) scoreFinal.getScoreb3());
                subtaskCnnNnMapper.updateByPrimaryKey(subtaskCnnIndex);
            }
            }
        for(int i = 1;i <=10000;i++){
            ScoreFinal3 scoreFinal = scoreFinal3.selectByPrimaryKey(i);
            SubtaskIndexNn subtaskCnnIndex = subtaskIndexNnMapper.selectByPrimaryKey(i);
            if (scoreFinal.getScorea3() != null) {
                subtaskCnnIndex.setScore1((float) scoreFinal.getScorea3());
                subtaskCnnIndex.setScore2((float) scoreFinal.getScoreb3());
                subtaskIndexNnMapper.updateByPrimaryKey(subtaskCnnIndex);
            }
        }
    }

    @Override
    public void caculatePartThree(){
        for(int i = 0;i <100;i++){
            for (int j = 0;j<10;j++){
                float averagea,averageb;
                float suma=0,sumb=0;
                int numa=0,numb=0;
                ProcessCnnTfidf processCnnTfidf = new ProcessCnnTfidf();
                processCnnTfidf.setProcessId(10*i+j+1);
                for (int m=0;m<10;m++){
                    SubtaskCnnTfidf subtaskCnnIndex = subtaskCnnTfidfMapper.selectByPrimaryKey(10*(10*i+j)+m+1);
                    if (subtaskCnnIndex.getScore1() != 0 && subtaskCnnIndex.getScore1()!= null){
                        suma = suma+subtaskCnnIndex.getScore1();
                        numa=numa+1;
                    }

                }
                for (int n=0;n<10;n++){
                    SubtaskCnnTfidf subtaskCnnIndex = subtaskCnnTfidfMapper.selectByPrimaryKey(10*(10*i+n)+j+1);
                    System.out.println(10*(10*i+n)+j+1);
                    if (subtaskCnnIndex.getScore2() != 0&&subtaskCnnIndex.getScore2()!=null){
                        sumb = sumb+subtaskCnnIndex.getScore2();
                        numb=numb+1;
                    }
                }
                processCnnTfidf.setAveragea(suma/numa);
                processCnnTfidf.setAverageb(sumb/numb);
                processCnnTfidfMapper.insert(processCnnTfidf);
            }
        }

        for(int i = 0;i <100;i++){
            for (int j = 0;j<10;j++){
                float averagea,averageb;
                float suma=0,sumb=0;
                int numa=0,numb=0;
                ProcessCnnIndex processCnnTfidf = new ProcessCnnIndex();
                processCnnTfidf.setProcessId(10*i+j+1);
                for (int m=0;m<10;m++){
                    SubtaskCnnIndex subtaskCnnIndex = subtaskCnnIndexMapper.selectByPrimaryKey(10*(10*i+j)+m+1);
                    if (subtaskCnnIndex.getScore1() != 0 && subtaskCnnIndex.getScore1()!= null){
                        suma = suma+subtaskCnnIndex.getScore1();
                        numa=numa+1;
                    }

                }
                for (int n=0;n<10;n++){
                    SubtaskCnnIndex subtaskCnnIndex = subtaskCnnIndexMapper.selectByPrimaryKey(10*(10*i+n)+j+1);
                    System.out.println("CnnIndex"+10*(10*i+n)+j+1);
                    if (subtaskCnnIndex.getScore2() != 0&&subtaskCnnIndex.getScore2()!=null){
                        sumb = sumb+subtaskCnnIndex.getScore2();
                        numb=numb+1;
                    }
                }
                processCnnTfidf.setAveragea(suma/numa);
                processCnnTfidf.setAverageb(sumb/numb);
                processCnnIndexMapper.insert(processCnnTfidf);
            }
        }


        for(int i = 0;i <100;i++){
            for (int j = 0;j<10;j++){
                float averagea,averageb;
                float suma=0,sumb=0;
                int numa=0,numb=0;
                ProcessCnnNn processCnnTfidf = new ProcessCnnNn();
                processCnnTfidf.setProcessId(10*i+j+1);
                for (int m=0;m<10;m++){
                    SubtaskCnnNn subtaskCnnIndex = subtaskCnnNnMapper.selectByPrimaryKey(10*(10*i+j)+m+1);
                    if (subtaskCnnIndex.getScore1() != 0 && subtaskCnnIndex.getScore1()!= null){
                        suma = suma+subtaskCnnIndex.getScore1();
                        numa=numa+1;
                    }

                }
                for (int n=0;n<10;n++){
                    SubtaskCnnNn subtaskCnnIndex = subtaskCnnNnMapper.selectByPrimaryKey(10*(10*i+n)+j+1);
                    System.out.println("CnnNn"+10*(10*i+n)+j+1);
                    if (subtaskCnnIndex.getScore2() != 0&&subtaskCnnIndex.getScore2()!=null){
                        sumb = sumb+subtaskCnnIndex.getScore2();
                        numb=numb+1;
                    }
                }
                processCnnTfidf.setAveragea(suma/numa);
                processCnnTfidf.setAverageb(sumb/numb);
                processCnnNnMapper.insert(processCnnTfidf);
            }
        }




        for(int i = 0;i <100;i++){
            for (int j = 0;j<10;j++){
                float averagea,averageb;
                float suma=0,sumb=0;
                int numa=0,numb=0;
                ProcessDocIndex processCnnTfidf = new ProcessDocIndex();
                processCnnTfidf.setProcessId(10*i+j+1);
                for (int m=0;m<10;m++){
                    SubtaskDocIndex subtaskCnnIndex = subtaskDocIndexMapper.selectByPrimaryKey(10*(10*i+j)+m+1);
                    if (subtaskCnnIndex.getScore1() != 0 && subtaskCnnIndex.getScore1()!= null){
                        suma = suma+subtaskCnnIndex.getScore1();
                       numa=numa+1;
                    }

                }
                for (int n=0;n<10;n++){
                    SubtaskDocIndex subtaskCnnIndex = subtaskDocIndexMapper.selectByPrimaryKey(10*(10*i+n)+j+1);
                    System.out.println("DocIndex"+10*(10*i+n)+j+1);
                    if (subtaskCnnIndex.getScore2() != 0&&subtaskCnnIndex.getScore2()!=null){
                        sumb = sumb+subtaskCnnIndex.getScore2();
                        numb=numb+1;
                    }
                }
                processCnnTfidf.setAveragea(suma/numa);
                processCnnTfidf.setAverageb(sumb/numb);
                processDocIndexMapper.insert(processCnnTfidf);
            }
        }



        for(int i = 0;i <100;i++){
            for (int j = 0;j<10;j++){
                float averagea,averageb;
                float suma=0,sumb=0;
                int numa=0,numb=0;
                ProcessIndexNn processCnnTfidf = new ProcessIndexNn();
                processCnnTfidf.setProcessId(10*i+j+1);
                for (int m=0;m<10;m++){
                    SubtaskIndexNn subtaskCnnIndex = subtaskIndexNnMapper.selectByPrimaryKey(10*(10*i+j)+m+1);
                    if (subtaskCnnIndex.getScore1() != 0 && subtaskCnnIndex.getScore1()!= null){
                        suma = suma+subtaskCnnIndex.getScore1();
                        numa=numa+1;
                    }

                }
                for (int n=0;n<10;n++){
                    SubtaskIndexNn subtaskCnnIndex = subtaskIndexNnMapper.selectByPrimaryKey(10*(10*i+n)+j+1);
                    System.out.println("IndexNn"+10*(10*i+n)+j+1);
                    if (subtaskCnnIndex.getScore2() != 0&&subtaskCnnIndex.getScore2()!=null){
                        sumb = sumb+subtaskCnnIndex.getScore2();
                        numb=numb+1;
                    }
                }
                processCnnTfidf.setAveragea(suma/numa);
                processCnnTfidf.setAverageb(sumb/numb);
                processIndexNnMapper.insert(processCnnTfidf);
            }
        }


        for(int i = 0;i <100;i++){
            for (int j = 0;j<10;j++){
                float averagea,averageb;
                float suma=0,sumb=0;
                int numa=0,numb=0;
                ProcessLstmNn processCnnTfidf = new ProcessLstmNn();
                processCnnTfidf.setProcessId(10*i+j+1);
                for (int m=0;m<10;m++){
                    SubtaskLstmNn subtaskCnnIndex = subtaskLstmNnMapper.selectByPrimaryKey(10*(10*i+j)+m+1);
                    if (subtaskCnnIndex.getScore1() != 0 && subtaskCnnIndex.getScore1()!= null){
                        suma = suma+subtaskCnnIndex.getScore1();
                        numa=numa+1;
                    }

                }
                for (int n=0;n<10;n++){
                    SubtaskLstmNn subtaskCnnIndex = subtaskLstmNnMapper.selectByPrimaryKey(10*(10*i+n)+j+1);
                    System.out.println("LstmNn"+10*(10*i+n)+j+1);
                    if (subtaskCnnIndex.getScore2() != 0&&subtaskCnnIndex.getScore2()!=null){
                        sumb = sumb+subtaskCnnIndex.getScore2();
                        numb=numb+1;
                    }
                }
                processCnnTfidf.setAveragea(suma/numa);
                processCnnTfidf.setAverageb(sumb/numb);
                processLstmNnMapper.insert(processCnnTfidf);
            }
        }

    }

    @Override
    public void caculatePartFour(){
        float suma=0;float sumb=0;
        for (int i =0;i<100;i++){
            suma=0;sumb=0;
            for (int j = 0; j<10; j++){
                ProcessCnnIndex processCnnIndex = processCnnIndexMapper.selectById((10*i+j+1));
                suma = suma + processCnnIndex.getAveragea();
                sumb = sumb + processCnnIndex.getAverageb();
            }
            ResultCnnIndex resultCnnIndex=new ResultCnnIndex();
            resultCnnIndex.setProcessId(i+1);
            resultCnnIndex.setAveragea(suma/10);
            resultCnnIndex.setAverageb(sumb/10);
            resultCnnIndexMapper.insert(resultCnnIndex);
        }
        for (int i =0;i<100;i++){
        suma=0;sumb=0;
        for (int j = 0; j<10; j++){
            ProcessCnnNn processCnnIndex = processCnnNnMapper.selectById((10*i+j+1));
            suma = suma + processCnnIndex.getAveragea();
            sumb = sumb + processCnnIndex.getAverageb();
        }
        ResultCnnNn resultCnnIndex=new ResultCnnNn();
        resultCnnIndex.setProcessId(i+1);
        resultCnnIndex.setAveragea(suma/10);
        resultCnnIndex.setAverageb(sumb/10);
        resultCnnNnMapper.insert(resultCnnIndex);
        }


        for (int i =0;i<100;i++){
            suma=0;sumb=0;
            for (int j = 0; j<10; j++){
                ProcessCnnTfidf processCnnIndex = processCnnTfidfMapper.selectById((10*i+j+1));
                suma = suma + processCnnIndex.getAveragea();
                sumb = sumb + processCnnIndex.getAverageb();
            }
            ResultCnnTfidf resultCnnIndex=new ResultCnnTfidf();
            resultCnnIndex.setProcessId(i+1);
            resultCnnIndex.setAveragea(suma/10);
            resultCnnIndex.setAverageb(sumb/10);
            resultCnnTfidfMapper.insert(resultCnnIndex);
        }


        for (int i =0;i<100;i++){
            suma=0;sumb=0;
            for (int j = 0; j<10; j++){
                ProcessDocIndex processCnnIndex = processDocIndexMapper.selectById((10*i+j+1));
                suma = suma + processCnnIndex.getAveragea();
                sumb = sumb + processCnnIndex.getAverageb();
            }
            ResultDocIndex resultCnnIndex=new ResultDocIndex();
            resultCnnIndex.setProcessId(i+1);
            resultCnnIndex.setAveragea(suma/10);
            resultCnnIndex.setAverageb(sumb/10);
            resultDocIndexMapper.insert(resultCnnIndex);
        }


        for (int i =0;i<100;i++){
            suma=0;sumb=0;
            for (int j = 0; j<10; j++){
                ProcessIndexNn processCnnIndex = processIndexNnMapper.selectById((10*i+j+1));
                suma = suma + processCnnIndex.getAveragea();
                sumb = sumb + processCnnIndex.getAverageb();
            }
            ResultIndexNn resultCnnIndex=new ResultIndexNn();
            resultCnnIndex.setProcessId(i+1);
            resultCnnIndex.setAveragea(suma/10);
            resultCnnIndex.setAverageb(sumb/10);
            resultIndexNnMapper.insert(resultCnnIndex);
        }


        for (int i =0;i<100;i++){
            suma=0;sumb=0;
            for (int j = 0; j<10; j++){
                ProcessLstmNn processCnnIndex = processLstmNnMapper.selectById((10*i+j+1));
                suma = suma + processCnnIndex.getAveragea();
                sumb = sumb + processCnnIndex.getAverageb();
            }
            ResultLstmNn resultCnnIndex=new ResultLstmNn();
            resultCnnIndex.setProcessId(i+1);
            resultCnnIndex.setAveragea(suma/10);
            resultCnnIndex.setAverageb(sumb/10);
            resultLstmNnMapper.insert(resultCnnIndex);
        }
    }
}
