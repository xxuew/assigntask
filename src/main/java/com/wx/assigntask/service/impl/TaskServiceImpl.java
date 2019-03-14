package com.wx.assigntask.service.impl;

import com.wx.assigntask.comment.ItemList;
import com.wx.assigntask.dao.AlgresultMapper;
import com.wx.assigntask.dao.UserMapper;
import com.wx.assigntask.entity.Algresult;
import com.wx.assigntask.entity.User;
import com.wx.assigntask.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements ITaskService {
    @Autowired
    IAHPService ahpService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    IMutualService iMutualService;
    @Autowired
    IHorizonService iHorizonService;
    @Autowired
    ISecondPartService secondPartService;
    @Autowired
    AlgresultMapper algresultMapper;
    @Override
    public List<ItemList> assignTask(int id, User user) {
        List<ItemList> lists = new ArrayList<>();
        User currentuser = userMapper.findUserByUserName(user.getUsername());
        switch (id){
            case 1:
                System.out.println("任务1");
                lists = iMutualService.cnn_tfidf_assignTask(currentuser);
                break;
            case 2:
                System.out.println("任务2");
                lists = iMutualService.doc_index_assignTask(currentuser);
                break;
            case 3:
                System.out.println("任务3");
                lists = iMutualService.lstm_nn_assignTask(currentuser);
                break;
            case 4:
                System.out.println("任务4");
                lists = iHorizonService.assignTask(currentuser);
                break;
            case 5:
                System.out.println("任务5");
                lists = ahpService.assignTask(currentuser);
                break;
            case 6:
                System.out.println("任务6");
                String result11 = algresultMapper.selectByPrimaryKey(1).getWinAlgname();
                String result12 = algresultMapper.selectByPrimaryKey(2).getWinAlgname();
                if (result11 == "cnn"&&result12 == "doc"){
                    lists = secondPartService.cnn_doc_assignTask(currentuser);
                }else if (result11 == "cnn"&&result12 == "index"){
                    lists = secondPartService.cnn_index_assignTask(currentuser);
                }else if (result11 == "tfidf"&&result12 == "doc"){
                    lists = secondPartService.tfidf_doc_assignTask(currentuser);
                }else if (result11 == "tfidf"&&result12 == "index"){
                    lists = secondPartService.tfidf_index_assignTask(currentuser);
                }
                break;
            case 7:
                System.out.println("任务7");
                String result21 = algresultMapper.selectByPrimaryKey(1).getWinAlgname();
                String result22 = algresultMapper.selectByPrimaryKey(3).getWinAlgname();
                if (result21 == "cnn"&&result22 == "lstm"){
                    lists = secondPartService.cnn_lstm_assignTask(currentuser);
                }else if (result21 == "cnn"&&result22 == "nn"){
                    lists = secondPartService.cnn_nn_assignTask(currentuser);
                }else if (result21 == "tfidf"&&result22 == "lstm"){
                    lists = secondPartService.tfidf_lstm_assignTask(currentuser);
                }else if (result21 == "tfidf"&&result22 == "nn"){
                    lists = secondPartService.tfidf_nn_assignTask(currentuser);
                }
                break;
            case 8:
                System.out.println("任务8");
                String result31 = algresultMapper.selectByPrimaryKey(2).getWinAlgname();
                String result32 = algresultMapper.selectByPrimaryKey(3).getWinAlgname();
                if (result31 == "doc"&&result32 == "lstm"){
                    lists = secondPartService.doc_lstm_assignTask(currentuser);
                }else if (result31 == "doc"&&result32 == "nn"){
                    lists = secondPartService.doc_nn_assignTask(currentuser);
                }else if (result31 == "index"&&result32 == "lstm"){
                    lists = secondPartService.index_lstm_assignTask(currentuser);
                }else if (result31 == "index"&&result32 == "nn"){
                    lists = secondPartService.index_nn_assignTask(currentuser);
                }
                break;
        }
        return lists;
    }

    @Override
    public void StoreData(int id, User user, List<ItemList> lists) {
        User currentuser = userMapper.findUserByUserName(user.getUsername());
        System.out.println("-----存储了-------"+id);
        switch (id){
            case 1:
                System.out.println("任务1");
                iMutualService.cnn_tfidf_StoreData(currentuser,lists);
                break;
            case 2:
                System.out.println("任务2");
                iMutualService.doc_index_StoreData(currentuser,lists);
                break;
            case 3:
                System.out.println("任务3");
                iMutualService.lstm_nn_StoreData(currentuser,lists);
                break;
            case 4:
                System.out.println("任务4");
                iHorizonService.StoreData(currentuser,lists);
                break;
            case 5:
                System.out.println("任务5");
                ahpService.StoreData(currentuser,lists);
                break;
            case 6:
                System.out.println("任务6");
                secondPartService.final1_StoreData(currentuser,lists);
                break;
            case 7:
                System.out.println("任务7");
                secondPartService.final2_StoreData(currentuser,lists);
                break;
            case 8:
                System.out.println("任务8");
                secondPartService.final3_StoreData(currentuser,lists);
                break;
        }
    }
}
