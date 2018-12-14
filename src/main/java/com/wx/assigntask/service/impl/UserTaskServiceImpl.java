//package com.wx.assigntask.service.impl;
//
//import com.wx.assigntask.dao.UserTaskDao;
//import com.wx.assigntask.entity.UserTask;
//import com.wx.assigntask.service.UserTaskService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * @Author: wx
// * @Date: 2018/12/11 14:17
// * @Version 1.0
// */
//@Service
//public class UserTaskServiceImpl implements UserTaskService {
//    @Autowired
//    UserTaskDao userTaskDao;
//
//    @Override
//    public void assignTaskToU(int userId, int taskId) {
//    userTaskDao.assignTaskToU(userId,taskId);
//    }
//
//    @Override
//    public List findByUserId(int userId) {
//        List list = userTaskDao.findByUserId(userId);
//        return null;
//    }
//}
