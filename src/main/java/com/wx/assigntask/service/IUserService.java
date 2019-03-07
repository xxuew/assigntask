package com.wx.assigntask.service;
import com.wx.assigntask.comment.ItemList;
import com.wx.assigntask.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService  {
    User findUserByUserName(String username);
    int addUser(User user);
    List<ItemList> checkUser(User user);
}
