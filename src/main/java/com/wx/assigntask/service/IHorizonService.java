package com.wx.assigntask.service;

import com.wx.assigntask.comment.ItemList;
import com.wx.assigntask.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IHorizonService {
    List<ItemList> assignTask(User user);
    void StoreData(User user,List<ItemList> lists);
}
