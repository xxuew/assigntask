package com.nju.assigntask.service;

import com.nju.assigntask.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/4 19:02
 * @Version 1.0
 */
@Repository
public interface UserService {


    User findUserByUserName(String username);

    List<Integer> selectAllId();

    boolean save(User curuser);

    boolean updatePassword(Integer userid, String password);

    User findUserByEmail(String email);

    //   public void  assignTaskToU(int userId,int taskId);

    //    void updateTasking(int userid);

    //    public User userLogin(String username,String password);

}
