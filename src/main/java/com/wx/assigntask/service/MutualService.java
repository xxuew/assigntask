package com.wx.assigntask.service;

import com.wx.assigntask.comment.ItemList;
import com.wx.assigntask.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MutualService {
    List<ItemList> cnn_tfidf_assignTask(User user);
    List<ItemList> doc_index_assignTask(User user);
    List<ItemList> lstm_nn_assignTask(User user);
    void StoreData(User user,List<ItemList> lists);
}

