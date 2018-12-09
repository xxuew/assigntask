package com.wx.assigntask.service;

import com.wx.assigntask.entity.TaskTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/8 18:33
 * @Version 1.0
 */
@Repository
public interface TestService {
    public ArrayList<TaskTest> allJobInfo();
}

