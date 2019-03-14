package com.wx.assigntask.service;

import com.wx.assigntask.comment.ItemList;
import com.wx.assigntask.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ISecondPartService {
    List<ItemList> cnn_doc_assignTask(User user);
    List<ItemList> cnn_index_assignTask(User user);
    List<ItemList> cnn_lstm_assignTask(User user);
    List<ItemList> cnn_nn_assignTask(User user);
    List<ItemList> tfidf_doc_assignTask(User user);
    List<ItemList> tfidf_index_assignTask(User user);
    List<ItemList> tfidf_lstm_assignTask(User user);
    List<ItemList> tfidf_nn_assignTask(User user);
    List<ItemList> doc_lstm_assignTask(User user);
    List<ItemList> doc_nn_assignTask(User user);
    List<ItemList> index_lstm_assignTask(User user);
    List<ItemList> index_nn_assignTask(User user);
    void final1_StoreData(User user,List<ItemList> lists);
    void final2_StoreData(User user,List<ItemList> lists);
    void final3_StoreData(User user,List<ItemList> lists);
}
