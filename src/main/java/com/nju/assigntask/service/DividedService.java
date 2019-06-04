package com.nju.assigntask.service;

import com.nju.assigntask.entity.Divided;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * divided表业务相关处理
 * @Author: wx
 * @Date: 2018/12/10 13:40
 * @Version 1.0
 */
@Repository
public interface DividedService {
    /**
     * 插入记录
     * @param releaseId
     * @param inputId
     * @param algname1
     * @param algname2
     * @return
     */
    int insertDivided(int releaseId,int inputId,String algname1,String algname2);

    List<Divided> selectAll();

    /**
     * 查找ifDivided字段
     * @param dividedId
     * @return
     */
    String findIfDivided(int dividedId);
//    float getAveScore1(int releaseid,String algname1,String algname2);
//    float getAveScore2(int releaseid,String algname1,String algname2);

    /**
     * 更新ifDivided字段
     * @param ifdivided
     * @param dividedId
     * @return
     */
    int updataDivided(String ifdivided,int dividedId);

    /**
     * 更新ordered字段
     * @param dividedid
     * @param ordered
     */
    void updateOrdered(int dividedid,String ordered);
//    void updateScore1(float score1,int dividedid);
//    void updateScore2(float score2,int dividedid);



 //   public int findDividedIdByAlgs(String algname1,String algname2);
}
