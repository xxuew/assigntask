package com.wx.assigntask.service.impl;

import com.wx.assigntask.comment.ItemList;
import com.wx.assigntask.dao.UserMapper;
import com.wx.assigntask.entity.User;
import com.wx.assigntask.service.IAHPService;
import com.wx.assigntask.service.IHorizonService;
import com.wx.assigntask.service.ITaskService;
import com.wx.assigntask.service.IMutualService;
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
                lists = ahpService.assignTask(currentuser);
                break;
            case 7:
                System.out.println("任务7");
                lists = ahpService.assignTask(currentuser);
                break;
            case 8:
                System.out.println("任务8");
                lists = ahpService.assignTask(currentuser);
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
                ahpService.StoreData(currentuser,lists);
                break;
            case 7:
                System.out.println("任务7");
                ahpService.StoreData(currentuser,lists);
                break;
            case 8:
                System.out.println("任务8");
                ahpService.StoreData(currentuser,lists);
                break;
        }
    }
}
