package com.wx.assigntask.service.impl;


import com.wx.assigntask.dao.UserMapper;
import com.wx.assigntask.entity.User;
import com.wx.assigntask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/4 19:01
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<Integer> selectAllId() {
        //查询所有用户Id
        List users = userMapper.selectAllByTasking();
        List userIds  = new ArrayList();
        for (int i =0 ;i<users.size();i++){
            User user = (User) users.get(i);
            userIds.add(user.getUserid()); //存入当前已有用户ID
        }
        if (users.size()<5000){
            //如果当前用户少于5K，则插入用户达到5K
           // int count  = 5000-users.size();
            for (int i=users.size();i<5000;i++){
                String username = "张" + i;
                String password = "123456";
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                userMapper.insert(user);
                int id = user.getUserid();
                userIds.add(user.getUserid());//存入新插入用户ID
            }
        }
        return userIds;
    }

    @Autowired
    UserMapper userMapper;

//    @Override
//    public User queryUser(int id) {
//        User user = userDao.selectUserByLogin("xx","123456");
//        return user;
//    }

//    @Override
//    public User userLogin(String username, String password) {
//        User user = userDao.selectUserByLogin(username,password);
//        return user;
//    }

    @Override
    public User findUserByUserName(String username) {
        User user = userMapper.findUserByUserName(username);
        return user;
    }

    //插入任务ID
//    @Override
//    public void assignTaskToU(int userId,int taskId) {
//        userDao.assignTaskToU(userId,taskId);
//    }


    @Override
    public void updateTasking(int userid) {
        User user = userMapper.findUserById(userid);
        int tasking = user.getTasking();
        if (tasking == -1){
            userMapper.updateTaking(userid,tasking+2);
        }
        else userMapper.updateTaking(userid,tasking+1);
    }
}
