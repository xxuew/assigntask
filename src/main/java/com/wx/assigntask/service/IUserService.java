package com.wx.assigntask.service;
import com.wx.assigntask.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService  {
    User findUserByUserName(String username);
    int addUser(User user);
}
