package com.wx.assigntask.service.impl;


import com.wx.assigntask.dao.UserMapper;
import com.wx.assigntask.entity.User;
import com.wx.assigntask.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wx
 * @Date: 2018/12/4 19:01
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insertUser(user);
    }
    
    @Override
    public User findUserByUserName(String username) {
        User user = userMapper.findUserByUserName(username);
        return user;
    }



}
