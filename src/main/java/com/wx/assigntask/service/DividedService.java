package com.wx.assigntask.service;

import org.springframework.stereotype.Repository;

/**
 * @Author: wx
 * @Date: 2018/12/10 13:40
 * @Version 1.0
 */
@Repository
public interface DividedService {
    public int insertDivided(String algname1,String algname2);

    public int findDividedIdByAlgs(String algname1,String algname2);
}
