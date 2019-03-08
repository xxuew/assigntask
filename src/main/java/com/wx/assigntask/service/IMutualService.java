package com.wx.assigntask.service;

import com.wx.assigntask.comment.ItemList;
import com.wx.assigntask.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMutualService {
    List<ItemList> cnn_tfidf_assignTask(User user);
    List<ItemList> doc_index_assignTask(User user);
    List<ItemList> lstm_nn_assignTask(User user);
    void cnn_tfidf_StoreData(User user,List<ItemList> lists);
    void doc_index_StoreData(User user,List<ItemList> lists);
    void lstm_nn_StoreData(User user,List<ItemList> lists);

}

