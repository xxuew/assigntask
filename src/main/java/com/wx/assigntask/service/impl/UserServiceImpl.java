package com.wx.assigntask.service.impl;

import com.wx.assigntask.dao.ReleaseMapper;
import com.wx.assigntask.dao.UserMapper;
import com.wx.assigntask.entity.ReleaseTask;
import com.wx.assigntask.entity.User;
import com.wx.assigntask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/4 19:01
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    ReleaseMapper releaseMapper;

    @Override
    public User queryUser(int id) {
        User user = userMapper.selectUserById(1);
        return user;
    }

    @Override
    public ReleaseTask queryRelease(int id) {
        ReleaseTask releaseTask = releaseMapper.selectReleaseByUserId(1);
        return releaseTask;
    }


}
