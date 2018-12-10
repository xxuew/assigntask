package com.wx.assigntask.service.impl;

import com.wx.assigntask.dao.DividedDao;
import com.wx.assigntask.service.DividedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wx
 * @Date: 2018/12/10 13:41
 * @Version 1.0
 */
@Service
public class DividedServiceImpl implements DividedService {
    @Autowired
    DividedDao dividedDao;

    @Override
    public void insertDivided(int algorithm_id1, int algorithm_id2) {
        dividedDao.insertDivided(algorithm_id1,algorithm_id2);
    }
}
