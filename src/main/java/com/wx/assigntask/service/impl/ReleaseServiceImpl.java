package com.wx.assigntask.service.impl;

import com.wx.assigntask.dao.ReleaseDao;
import com.wx.assigntask.entity.ReleaseTask;
import com.wx.assigntask.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wx
 * @Date: 2018/12/7 18:30
 * @Version 1.0
 */
@Service
public class ReleaseServiceImpl implements ReleaseService {

    @Autowired
    ReleaseDao releaseDao;

    @Override
    public String finAlgsByInputName(String inputName) {

        String algs = releaseDao.finAlgsByInputName(inputName);
        return algs;
    }
}
