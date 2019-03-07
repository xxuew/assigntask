package com.wx.assigntask.service.impl;

import com.wx.assigntask.comment.ItemList;
import com.wx.assigntask.dao.SubtaskCnnTfidfMapper;
import com.wx.assigntask.dao.UserMapper;
import com.wx.assigntask.entity.AhpSubtask;
import com.wx.assigntask.entity.SubtaskCnnTfidf;
import com.wx.assigntask.entity.User;
import com.wx.assigntask.service.MutualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MutualServiceImpl implements MutualService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    SubtaskCnnTfidfMapper subtaskCnnTfidfMapper;
    

    private int count = 0;
    @Override
    public List<ItemList> cnn_tfidf_assignTask(User user) {
        return null;
    }

    @Override
    public List<ItemList> doc_index_assignTask(User user) {
        return null;
    }

    @Override
    public List<ItemList> lstm_nn_assignTask(User user) {
        return null;
    }

    @Override
    public void StoreData(User user, List<ItemList> lists) {

    }
}
