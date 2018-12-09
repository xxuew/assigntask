package com.wx.assigntask.service.impl;

import com.wx.assigntask.dao.ReleaseDao;
import com.wx.assigntask.dao.UserDao;
import com.wx.assigntask.entity.ReleaseTask;
import com.wx.assigntask.entity.User;
import com.wx.assigntask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wx
 * @Date: 2018/12/4 19:01
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

//    @Override
//    public User queryUser(int id) {
//        User user = userDao.selectUserByLogin("xx","123456");
//        return user;
//    }

    @Override
    public User userLogin(String username, String password) {
        User user = userDao.selectUserByLogin(username,password);
        return user;
    }

    @Override
    public User findUserByUserName(String username) {
        User user = userDao.findUserByUserName(username);
        return user;
    }


}
