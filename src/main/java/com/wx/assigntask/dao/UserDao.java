package com.wx.assigntask.dao;

import com.wx.assigntask.entity.ReleaseTask;
import com.wx.assigntask.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/4 17:22
 * @Version 1.0
 */
@Mapper     //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface UserDao {
    /**
     * 功能描述：根据登录用户名和密码获取用户信息
     * @param username
     * @param password
     * @return
     */
    User selectUserByLogin(String username,String password);

    User findUserByUserName(String username);



}
