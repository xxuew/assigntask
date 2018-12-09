package com.wx.assigntask.service.impl;

import com.wx.assigntask.dao.TestDao;
import com.wx.assigntask.entity.TaskTest;
import com.wx.assigntask.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/8 18:37
 * @Version 1.0
 */
@Service
public class TestServiceIml implements TestService {
    @Autowired
    TestDao testDao;

    @Override
    public ArrayList<TaskTest> allJobInfo() {
        ArrayList<TaskTest> taskTest = testDao.findAllJobData();
        return taskTest;
    }
}
