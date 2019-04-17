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

    @Autowired
    UserMapper userMapper;

    @Override
    public List<Integer> selectAllId() {
        //查询所有用户Id
        List userids = userMapper.selectAllIdByTasking();
        if (userids.size()<50){
            //如果当前用户少于5K，则插入用户达到5K
           // int count  = 5000-users.size();
            for (int i=userids.size();i<50;i++){
                String username = "张" + i;
                String password = "123456";
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                userMapper.insert(user);
                int id = user.getUserid();
                userids.add(user.getUserid());//存入新插入用户ID
            }
        }
        return userids;
    }

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

    @Override
    public boolean save(User curuser) {
       int val =  userMapper.insert(curuser);//insert 的返回值：代表 受影响的行数
        return val == 1;
    }

    @Override
    public boolean updatePassword(Integer userid, String password) {
        int val = userMapper.updatePassword(userid,password);
        return val == 1;
    }

    @Override
    public User findUserByEmail(String email) {
        User user = userMapper.findUserByEmail(email);
        return user;
    }


}
