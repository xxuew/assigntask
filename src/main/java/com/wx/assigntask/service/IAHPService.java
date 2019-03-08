package com.wx.assigntask.service;

import com.wx.assigntask.comment.ItemList;
import com.wx.assigntask.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAHPService {
    List<ItemList> CreatTask();
    List<ItemList>  assignTask(User user);
    void StoreData(User user,List<ItemList> lists);
}
