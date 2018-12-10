package com.wx.assigntask.service.impl;

import com.wx.assigntask.dao.SubTaskDao;
import com.wx.assigntask.entity.SubTask;
import com.wx.assigntask.service.SubTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wx
 * @Date: 2018/12/9 21:44
 * @Version 1.0
 */
@Service
public class SubTaskServiceImpl implements SubTaskService {

    @Autowired
    SubTaskDao subTaskDao;

    @Override
    public SubTask findSubBySubId(int id) {
        SubTask subTask = subTaskDao.findSubBySubId(id);
        return subTask;
    }

    @Override
    public void insertSubTask(int algorithm_id1, int algorithm_id2,int judged_frequency) {
        subTaskDao.insertSubTask(algorithm_id1,algorithm_id2,judged_frequency);
    }
}
