package com.wx.assigntask.service.impl;

import com.wx.assigntask.comment.ItemList;
import com.wx.assigntask.dao.SubtaskCnnTfidfMapper;
import com.wx.assigntask.dao.SubtaskDocIndexMapper;
import com.wx.assigntask.dao.SubtaskLstmNnMapper;
import com.wx.assigntask.dao.UserMapper;
import com.wx.assigntask.entity.*;
import com.wx.assigntask.service.IMutualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MutualServiceImpl implements IMutualService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    SubtaskCnnTfidfMapper subtaskCnnTfidfMapper;
    @Autowired
    SubtaskDocIndexMapper subtaskDocIndexMapper;
    @Autowired
    SubtaskLstmNnMapper subtaskLstmNnMapper;

    private int cnn_tfidf_count = 0;
    private int doc_index_count = 0;
    private int lstm_nn_count = 0;
    @Override
    public List<ItemList> cnn_tfidf_assignTask(User user) {
        List<ItemList> list = new ArrayList<>();
        System.out.println("-----------cnn_tfidf_count------------");
        System.out.println(cnn_tfidf_count);
//        生成任务，将用户id写入任务数据表表
        int uid = user.getUser_id();
        for(int i = 0;i<10;i++) {
            ItemList itemList = new ItemList();
            cnn_tfidf_count++;
//            将分配的任务id写入用户数据表
            if (i == 0) {
                user.setReceived_id(cnn_tfidf_count);
                user.setAlgo_id(1);
                userMapper.updateUser(user);
            }
            SubtaskCnnTfidf subtaskCnnTfidf = subtaskCnnTfidfMapper.selectByPrimaryKey(cnn_tfidf_count);
//            id表示任务分配给了谁
            subtaskCnnTfidf.setDividedId(uid);
            subtaskCnnTfidfMapper.updateByPrimaryKey(subtaskCnnTfidf);
            itemList.setId(subtaskCnnTfidf.getSubtaskId());
            itemList.setInputname(subtaskCnnTfidf.getInputName());
            itemList.setInputdes(subtaskCnnTfidf.getInputDes());
            itemList.setItema(subtaskCnnTfidf.getItemName1());
            itemList.setDesa(subtaskCnnTfidf.getItemDes1());
            itemList.setItemb(subtaskCnnTfidf.getItemName2());
            itemList.setDesb(subtaskCnnTfidf.getItemDes2());
            list.add(itemList);
        }
        return list;
    }

    @Override
    public List<ItemList> doc_index_assignTask(User user) {
        List<ItemList> list = new ArrayList<>();
        System.out.println("-----------doc_index_count------------");
        System.out.println(doc_index_count);
//        生成任务，将用户id写入任务数据表表
        int uid = user.getUser_id();
        for(int i = 0;i<10;i++) {
            ItemList itemList = new ItemList();
            doc_index_count++;
//            将分配的任务id写入用户数据表
            if (i == 0) {
                user.setReceived_id(doc_index_count);
                user.setAlgo_id(2);
                userMapper.updateUser(user);
            }
            SubtaskDocIndex subtaskDocIndex = subtaskDocIndexMapper.selectByPrimaryKey(doc_index_count);
//            id表示任务分配给了谁
            subtaskDocIndex.setDividedId(uid);
            subtaskDocIndexMapper.updateByPrimaryKey(subtaskDocIndex);
            itemList.setId(subtaskDocIndex.getSubtaskId());
            itemList.setInputname(subtaskDocIndex.getInputName());
            itemList.setInputdes(subtaskDocIndex.getInputDes());
            itemList.setItema(subtaskDocIndex.getItemName1());
            itemList.setDesa(subtaskDocIndex.getItemDes1());
            itemList.setItemb(subtaskDocIndex.getItemName2());
            itemList.setDesb(subtaskDocIndex.getItemDes2());
            list.add(itemList);
        }
        return list;
    }

    @Override
    public List<ItemList> lstm_nn_assignTask(User user) {
        List<ItemList> list = new ArrayList<>();
        System.out.println("-----------lstm_nn_count------------");
        System.out.println(lstm_nn_count);
//        生成任务，将用户id写入任务数据表表
        int uid = user.getUser_id();
        for(int i = 0;i<10;i++) {
            ItemList itemList = new ItemList();
            lstm_nn_count++;
//            将分配的任务id写入用户数据表
            if (i == 0) {
                user.setReceived_id(lstm_nn_count);
                user.setAlgo_id(3);
                userMapper.updateUser(user);
            }
            SubtaskLstmNn subtaskLstmNn = subtaskLstmNnMapper.selectByPrimaryKey(lstm_nn_count);
//            id表示任务分配给了谁
            subtaskLstmNn.setDividedId(uid);
            subtaskLstmNnMapper.updateByPrimaryKey(subtaskLstmNn);
            itemList.setId(subtaskLstmNn.getSubtaskId());
            itemList.setInputname(subtaskLstmNn.getInputName());
            itemList.setInputdes(subtaskLstmNn.getInputDes());
            itemList.setItema(subtaskLstmNn.getItemName1());
            itemList.setDesa(subtaskLstmNn.getItemDes1());
            itemList.setItemb(subtaskLstmNn.getItemName2());
            itemList.setDesb(subtaskLstmNn.getItemDes2());
            list.add(itemList);
        }
        return list;
    }

    @Override
    public void cnn_tfidf_StoreData(User user, List<ItemList> lists) {
        int received_id = user.getReceived_id();
        for(int i = 0;i<10;i++){
            if(i != 0){
                received_id++;
            }
            SubtaskCnnTfidf subtaskCnnTfidf = subtaskCnnTfidfMapper.selectByPrimaryKey(received_id);
            subtaskCnnTfidf.setScore1((float) lists.get(i).getScorea());
            subtaskCnnTfidf.setScore2((float)lists.get(i).getScoreb());
            subtaskCnnTfidfMapper.updateByPrimaryKey(subtaskCnnTfidf);
        }
        user.setReceived_id(0);
        user.setAlgo_id(0);
        userMapper.updateUser(user);
    }

    @Override
    public void doc_index_StoreData(User user, List<ItemList> lists) {
        int received_id = user.getReceived_id();
        for(int i = 0;i<10;i++){
            if(i != 0){
                received_id++;
            }
            SubtaskDocIndex subtaskDocIndex = subtaskDocIndexMapper.selectByPrimaryKey(received_id);
            subtaskDocIndex.setScore1((float) lists.get(i).getScorea());
            subtaskDocIndex.setScore2((float)lists.get(i).getScoreb());
            subtaskDocIndexMapper.updateByPrimaryKey(subtaskDocIndex);
        }
        user.setReceived_id(0);
        user.setAlgo_id(0);
        userMapper.updateUser(user);
    }

    @Override
    public void lstm_nn_StoreData(User user, List<ItemList> lists) {
        int received_id = user.getReceived_id();
        for(int i = 0;i<10;i++){
            if(i != 0){
                received_id++;
            }
            SubtaskLstmNn subtaskLstmNn = subtaskLstmNnMapper.selectByPrimaryKey(received_id);
            subtaskLstmNn.setScore1((float) lists.get(i).getScorea());
            subtaskLstmNn.setScore2((float)lists.get(i).getScoreb());
            subtaskLstmNnMapper.updateByPrimaryKey(subtaskLstmNn);
        }
        user.setReceived_id(0);
        user.setAlgo_id(0);
        userMapper.updateUser(user);
    }


}
