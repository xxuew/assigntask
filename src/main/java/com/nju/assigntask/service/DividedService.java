package com.nju.assigntask.service;

import com.nju.assigntask.entity.Divided;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/10 13:40
 * @Version 1.0
 */
@Repository
public interface DividedService {
    public int insertDivided(int releaseId,int inputId,String algname1,String algname2);

    List<Divided> selectAll();

    String findIfDivided(int dividedId);
//    float getAveScore1(int releaseid,String algname1,String algname2);
//    float getAveScore2(int releaseid,String algname1,String algname2);

    int updataDivided(String ifdivided,int dividedId);
    void updateOrdered(int dividedid,String ordered);
//    void updateScore1(float score1,int dividedid);
//    void updateScore2(float score2,int dividedid);



 //   public int findDividedIdByAlgs(String algname1,String algname2);
}
