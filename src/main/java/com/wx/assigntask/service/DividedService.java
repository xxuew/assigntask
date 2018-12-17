package com.wx.assigntask.service;

import com.wx.assigntask.entity.Divided;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/10 13:40
 * @Version 1.0
 */
@Repository
public interface DividedService {
    public int insertDivided(int releaseId,String inputName,String algname1,String algname2);

    List<Divided> selectAll();

    String findIfDivided(int dividedId);

    int updataDivided(String ifdivided,int dividedId);

 //   public int findDividedIdByAlgs(String algname1,String algname2);
}
