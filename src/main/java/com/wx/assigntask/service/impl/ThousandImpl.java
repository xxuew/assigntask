package com.wx.assigntask.service.impl;

import com.wx.assigntask.dao.*;
import com.wx.assigntask.entity.*;
import com.wx.assigntask.service.IThousand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ThousandImpl implements IThousand {
    @Autowired
    Cnn302000Mapper cnn;
    @Autowired
    Nn302000Mapper nn;
    @Autowired
    Lstm302000Mapper lstm;
    @Autowired
    Doc302000Mapper index;
    @Autowired
    ScoreFinal1Mapper lstmscore;
    @Autowired
    Index2000scoreMapper lstm2000scoreMapper;
    @Autowired
    NnDocIndexMapper nnDocIndexMapper;

    @Override
    public void insert() {
//        List list = cnn.selectAll();
//        int i = 1;
//        for (Object a: list) {
//            Cnn302000 c = (Cnn302000) a;
//            c.setId(i);
//            int j = cnn.update(c);
//            System.out.println(j+" "+i+" "+c.getId()+" "+c.getName());
//            i++;
//        }
//        List list = nn.selectAll();
//        int i = 1;
//        for (Object a: list) {
//            Nn302000 c = (Nn302000) a;
//            c.setId(i);
//            int j = nn.update(c);
//            System.out.println(j+" "+i+" "+c.getId()+" "+c.getName());
//            i++;
//        }
//
//        List list1 = lstm.selectAll();
//        i = 1;
//        for (Object a: list1) {
//            Lstm302000 c = (Lstm302000) a;
//            c.setId(i);
//            int j = lstm.update(c);
//            System.out.println(j+" "+i+" "+c.getId()+" "+c.getName());
//            i++;
//        }

        List list2 = index.selectAll();
        int i = 1;
        for (Object a: list2) {
            Doc302000 c = (Doc302000) a;
            c.setId(i);
            int j = index.update(c);
//            System.out.println(j+" "+i+" "+c.getId()+" "+c.getName());
            i++;
        }

    }

    @Override
    public Cnn302000 SelectByName(String record) {
        Cnn302000 cs = cnn.selectByName(record);
        System.out.println(cs.getName()+" " +cs.getDes());
        return cs;
    }

    @Override
    public void insertlstmscore() {
        for(int i = 0;i<1000;i++){
            Index2000score ls = new Index2000score();
            ScoreFinal1 ls1 = lstmscore.selectByPrimaryKey(10*i+1);
            ScoreFinal1 ls2 = lstmscore.selectByPrimaryKey(10*i+2);
            ScoreFinal1 ls3 = lstmscore.selectByPrimaryKey(10*i+3);
            ScoreFinal1 ls4 = lstmscore.selectByPrimaryKey(10*i+4);
            ScoreFinal1 ls5 = lstmscore.selectByPrimaryKey(10*i+5);
            ScoreFinal1 ls6 = lstmscore.selectByPrimaryKey(10*i+6);
            ScoreFinal1 ls7 = lstmscore.selectByPrimaryKey(10*i+7);
            ScoreFinal1 ls8 = lstmscore.selectByPrimaryKey(10*i+8);
            ScoreFinal1 ls9 = lstmscore.selectByPrimaryKey(10*i+9);
            ScoreFinal1 ls10 = lstmscore.selectByPrimaryKey(10*i+10);
            if(ls1.getScoreb1()==null)ls1.setScoreb1(3);
            if(ls2.getScoreb1()==null)ls2.setScoreb1(3);
            if(ls3.getScoreb1()==null)ls3.setScoreb1(3);
            if(ls4.getScoreb1()==null)ls4.setScoreb1(3);
            if(ls5.getScoreb1()==null)ls5.setScoreb1(3);
            if(ls6.getScoreb1()==null)ls6.setScoreb1(3);
            if(ls7.getScoreb1()==null)ls7.setScoreb1(3);
            if(ls8.getScoreb1()==null)ls8.setScoreb1(3);
            if(ls9.getScoreb1()==null)ls9.setScoreb1(3);
            if(ls10.getScoreb1()==null)ls10.setScoreb1(3);
            ls.setSid(i+1);
            ls.setScore1(ls1.getScoreb1());;
            ls.setScore2(ls2.getScoreb1());
            ls.setScore3(ls3.getScoreb1());
            ls.setScore4(ls4.getScoreb1());
            ls.setScore5(ls5.getScoreb1());
            ls.setScore6(ls6.getScoreb1());
            ls.setScore7(ls7.getScoreb1());
            ls.setScore8(ls8.getScoreb1());
            ls.setScore9(ls9.getScoreb1());
            ls.setScore10(ls10.getScoreb1());
            lstm2000scoreMapper.insert(ls);
        }

        for(int i = 0;i<1000;i++){
            Index2000score ls = new Index2000score();
            ScoreFinal1 ls1 = lstmscore.selectByPrimaryKey(10*i+1);
            ScoreFinal1 ls2 = lstmscore.selectByPrimaryKey(10*i+2);
            ScoreFinal1 ls3 = lstmscore.selectByPrimaryKey(10*i+3);
            ScoreFinal1 ls4 = lstmscore.selectByPrimaryKey(10*i+4);
            ScoreFinal1 ls5 = lstmscore.selectByPrimaryKey(10*i+5);
            ScoreFinal1 ls6 = lstmscore.selectByPrimaryKey(10*i+6);
            ScoreFinal1 ls7 = lstmscore.selectByPrimaryKey(10*i+7);
            ScoreFinal1 ls8 = lstmscore.selectByPrimaryKey(10*i+8);
            ScoreFinal1 ls9 = lstmscore.selectByPrimaryKey(10*i+9);
            ScoreFinal1 ls10 = lstmscore.selectByPrimaryKey(10*i+10);
            if(ls1.getScoreb2()==null)ls1.setScoreb2(3);
            if(ls2.getScoreb2()==null)ls2.setScoreb2(3);
            if(ls3.getScoreb2()==null)ls3.setScoreb2(3);
            if(ls4.getScoreb2()==null)ls4.setScoreb2(3);
            if(ls5.getScoreb2()==null)ls5.setScoreb2(3);
            if(ls6.getScoreb2()==null)ls6.setScoreb2(3);
            if(ls7.getScoreb2()==null)ls7.setScoreb2(3);
            if(ls8.getScoreb2()==null)ls8.setScoreb2(3);
            if(ls9.getScoreb2()==null)ls9.setScoreb2(3);
            if(ls10.getScoreb2()==null)ls10.setScoreb2(3);
            ls.setSid(i+1001);
            ls.setScore1(ls1.getScoreb2());;
            ls.setScore2(ls2.getScoreb2());
            ls.setScore3(ls3.getScoreb2());
            ls.setScore4(ls4.getScoreb2());
            ls.setScore5(ls5.getScoreb2());
            ls.setScore6(ls6.getScoreb2());
            ls.setScore7(ls7.getScoreb2());
            ls.setScore8(ls8.getScoreb2());
            ls.setScore9(ls9.getScoreb2());
            ls.setScore10(ls10.getScoreb2());
            lstm2000scoreMapper.insert(ls);
        }

    }

    public void ScoreSort(){
        for(int i = 1;i <= 2000;i++){
            int[] range=new int[30];
            int[] score=new int[30];
            System.out.println(i);
            NnDocIndex record = nnDocIndexMapper.selectById(i);
            score[0]=record.getNnScore1();
            score[1]=record.getNnScore2();
            score[2]=record.getNnScore3();
            score[3]=record.getNnScore4();
            score[4]=record.getNnScore5();
            score[5]=record.getNnScore6();
            score[6]=record.getNnScore7();
            score[7]=record.getNnScore8();
            score[8]=record.getNnScore9();
            score[9]=record.getNnScore10();

            score[10]=record.getDocScore1();
            score[11]=record.getDocScore2();
            score[12]=record.getDocScore3();
            score[13]=record.getDocScore4();
            score[14]=record.getDocScore5();
            score[15]=record.getDocScore6();
            score[16]=record.getDocScore7();
            score[17]=record.getDocScore8();
            score[18]=record.getDocScore9();
            score[19]=record.getDocScore10();

            score[20]=record.getIndexScore1();
            score[21]=record.getIndexScore2();
            score[22]=record.getIndexScore3();
            score[23]=record.getIndexScore4();
            score[24]=record.getIndexScore5();
            score[25]=record.getIndexScore6();
            score[26]=record.getIndexScore7();
            score[27]=record.getIndexScore8();
            score[28]=record.getIndexScore9();
            score[29]=record.getIndexScore10();

            HashMap map = new HashMap();
            for (int j= 0; j < score.length; j++)map.put(score[j],j);
            Arrays.sort(score);

            for (int j = 0; j < score.length; j++){
                range[j] = (int)map.get(score[j]);
            }

            record.setNnRange1(30-range[0]);
            record.setNnRange2(30-range[1]);
            record.setNnRange3(30-range[2]);
            record.setNnRange4(30-range[3]);
            record.setNnRange5(30-range[4]);
            record.setNnRange6(30-range[5]);
            record.setNnRange7(30-range[6]);
            record.setNnRange8(30-range[7]);
            record.setNnRange9(30-range[8]);
            record.setNnRange10(30-range[9]);

            record.setDocRange1(30-range[10]);
            record.setDocRange2(30-range[11]);
            record.setDocRange3(30-range[12]);
            record.setDocRange4(30-range[13]);
            record.setDocRange5(30-range[14]);
            record.setDocRange6(30-range[15]);
            record.setDocRange7(30-range[16]);
            record.setDocRange8(30-range[17]);
            record.setDocRange9(30-range[18]);
            record.setDocRange10(30-range[19]);

            record.setIndexRange1(30-range[20]);
            record.setIndexRange2(30-range[21]);
            record.setIndexRange3(30-range[22]);
            record.setIndexRange4(30-range[23]);
            record.setIndexRange5(30-range[24]);
            record.setIndexRange6(30-range[25]);
            record.setIndexRange7(30-range[26]);
            record.setIndexRange8(30-range[27]);
            record.setIndexRange9(30-range[28]);
            record.setIndexRange10(30-range[29]);

            nnDocIndexMapper.update(record);

        }
    }
}
