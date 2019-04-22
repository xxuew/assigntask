package com.nju.assigntask.service.impl;

import com.nju.assigntask.dao.DividedMapper;
import com.nju.assigntask.entity.Divided;
import com.nju.assigntask.service.DividedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/10 13:41
 * @Version 1.0
 */
@Service
public class DividedServiceImpl implements DividedService {
    @Autowired
    DividedMapper dividedMapper;

    @Override
    public int updataDivided(String ifdivided, int dividedId) {
        return dividedMapper.updataDivided(ifdivided,dividedId);
    }

    @Override
    public String findIfDivided(int dividedId) {
        return dividedMapper.findIfDivided(dividedId);
    }

    @Override
    public List<Divided> selectAll() {

        return dividedMapper.selectAll();
    }

    @Override
    public int insertDivided(int releaseId,int inputId,String algname1, String algname2) {
        Divided divided =new Divided();
        divided.setReleaseid(releaseId);
        divided.setInputid(inputId);
        divided.setAlgname1(algname1);
        divided.setAlgname2(algname2);
       dividedMapper.insertDivided(divided);
       int id =divided.getDividedid();
       return id;
    }

//    @Override
//    public float getAveScore1(int releaseid,String algname1,String algname2) {
//        Divided divided = new Divided();
//        divided.setReleaseid(releaseid);
//        divided.setAlgname1(algname1);
//        divided.setAlgname2(algname2);
//        int dataNum = dividedMapper.selectByReleaseAlgs(divided).size();
//        int sumScore1 = dividedMapper.selectSumScore1(divided);
//        float aveScore1 = (float) sumScore1/dataNum;
//
//        return aveScore1;
//    }
//
//    @Override
//    public float getAveScore2(int releaseid, String algname1, String algname2) {
//        Divided divided = new Divided();
//        divided.setReleaseid(releaseid);
//        divided.setAlgname1(algname1);
//        divided.setAlgname2(algname2);
//        int dataNum = dividedMapper.selectByReleaseAlgs(divided).size();
//        int sumScore2 = dividedMapper.selectSumScore2(divided);
//        float aveScore2 = (float) sumScore2/dataNum;
//
//        return aveScore2;
//    }

//    @Override
//    public void updateScore1(float score1, int dividedid) {
//        Divided divided = new Divided();
//        divided.setScore1(score1);
//        divided.setDividedid(dividedid);
//        dividedMapper.updateScore1(divided);
//    }
//
//    @Override
//    public void updateScore2(float score2, int dividedid) {
//        Divided divided = new Divided();
//        divided.setScore2(score2);
//        divided.setDividedid(dividedid);
//        dividedMapper.updateScore2(divided);
//    }

    @Override
    public void updateOrdered(int dividedid, String ordered) {
        Divided divided = new Divided();
        divided.setDividedid(dividedid);
        divided.setOrdered(ordered);
        dividedMapper.updateOrdered(divided);
    }
    //    @Override
//    public int findDividedIdByAlgs(String algname1, String algname2) {
//        int dividedId = dividedMapper.findDividedIdByAlgs(algname1,algname2);
//        return dividedId;
//    }
}
