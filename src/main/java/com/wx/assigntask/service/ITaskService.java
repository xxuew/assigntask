package com.wx.assigntask.service;


import com.wx.assigntask.comment.ItemList;
import com.wx.assigntask.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITaskService {
    List<ItemList> assignTask(int Id, User user);
    void StoreData(int id,User user,List<ItemList> lists);
}
