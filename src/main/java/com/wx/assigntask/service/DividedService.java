package com.wx.assigntask.service;

import org.springframework.stereotype.Repository;

/**
 * @Author: wx
 * @Date: 2018/12/10 13:40
 * @Version 1.0
 */
@Repository
public interface DividedService {
    public void insertDivided(int algorithm_id1,int algorithm_id2);
}
