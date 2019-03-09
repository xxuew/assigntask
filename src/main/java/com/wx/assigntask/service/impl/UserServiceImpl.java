package com.wx.assigntask.service.impl;


import com.wx.assigntask.comment.ItemList;
import com.wx.assigntask.dao.*;
import com.wx.assigntask.entity.*;
import com.wx.assigntask.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/4 19:01
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    SubtaskAhpMapper ahpSubtaskMapper;
    @Autowired
    SubtaskHorizonMapper subtaskMapper;
    @Autowired
    SubtaskCnnTfidfMapper subtaskCnnTfidfMapper;
    @Autowired
    SubtaskDocIndexMapper subtaskDocIndexMapper;
    @Autowired
    SubtaskLstmNnMapper subtaskLstmNnMapper;

    @Override
    public int addUser(User user) {
        user.setReceived_id(0);
        user.setAlgo_id(0);
        return userMapper.insert(user);
    }

    @Override
    public List<ItemList> checkUser(User user) {
        List<ItemList> list = new ArrayList<>();
        User currentuser = userMapper.findUserByUserName(user.getUsername());
        int id = currentuser.getUser_id();
        int received_id = currentuser.getReceived_id();
        switch (id){
            case 1:
                System.out.println("任务1被分配过了");
                for(int i = 0;i<10;i++){
                    if(i!=0){
                        received_id++;
                    }
                    ItemList itemList = new ItemList();
                    SubtaskCnnTfidf subtaskCnnTfidf = subtaskCnnTfidfMapper.selectByPrimaryKey(received_id);
                    itemList.setId(subtaskCnnTfidf.getSubtaskId());
                    itemList.setInputname(subtaskCnnTfidf.getInputName());
                    itemList.setInputdes(subtaskCnnTfidf.getInputDes());
                    itemList.setItema(subtaskCnnTfidf.getItemName1());
                    itemList.setDesa(subtaskCnnTfidf.getItemDes1());
                    itemList.setItemb(subtaskCnnTfidf.getItemName2());
                    itemList.setDesb(subtaskCnnTfidf.getItemDes2());
                    list.add(itemList);
                }
                break;
            case 2:
                System.out.println("任务2被分配过了");
                for(int i = 0;i<10;i++){
                    if(i!=0){
                        received_id++;
                    }
                    ItemList itemList = new ItemList();
                    SubtaskDocIndex subtaskDocIndex = subtaskDocIndexMapper.selectByPrimaryKey(received_id);
                    itemList.setId(subtaskDocIndex.getSubtaskId());
                    itemList.setInputname(subtaskDocIndex.getInputName());
                    itemList.setInputdes(subtaskDocIndex.getInputDes());
                    itemList.setItema(subtaskDocIndex.getItemName1());
                    itemList.setDesa(subtaskDocIndex.getItemDes1());
                    itemList.setItemb(subtaskDocIndex.getItemName2());
                    itemList.setDesb(subtaskDocIndex.getItemDes2());
                    list.add(itemList);
                }
                break;
            case 3:
                System.out.println("任务3被分配过了");
                for(int i = 0;i<10;i++){
                    if(i!=0){
                        received_id++;
                    }
                    ItemList itemList = new ItemList();
                    SubtaskLstmNn subtaskLstmNn = subtaskLstmNnMapper.selectByPrimaryKey(received_id);
                    itemList.setId(subtaskLstmNn.getSubtaskId());
                    itemList.setInputname(subtaskLstmNn.getInputName());
                    itemList.setInputdes(subtaskLstmNn.getInputDes());
                    itemList.setItema(subtaskLstmNn.getItemName1());
                    itemList.setDesa(subtaskLstmNn.getItemDes1());
                    itemList.setItemb(subtaskLstmNn.getItemName2());
                    itemList.setDesb(subtaskLstmNn.getItemDes2());
                    list.add(itemList);
                }
                break;
            case 4:
                System.out.println("任务4被分配过了");
                for(int i = 0;i<10;i++){
                    if(i!=0){
                        received_id++;
                    }
                    ItemList itemList = new ItemList();
                    SubtaskHorizon subtask = subtaskMapper.selectByPrimaryKey(received_id);
                    itemList.setId(subtask.getSubtaskId());
                    itemList.setInputname(subtask.getInputName());
                    itemList.setInputdes(subtask.getInputDes());
                    itemList.setItema(subtask.getItemName1());
                    itemList.setDesa(subtask.getItemDes1());
                    itemList.setItemb(subtask.getItemName2());
                    itemList.setDesb(subtask.getItemDes2());
                    list.add(itemList);
                }
                break;
            case 5:
                System.out.println("任务5被分配过了");
                for(int i = 0;i<10;i++){
                    if(i!=0){
                        received_id++;
                    }
                    ItemList itemList = new ItemList();
                    SubtaskAhp ahpSubtask = ahpSubtaskMapper.selectByPrimaryKey(received_id);
                    itemList.setId(ahpSubtask.getSubtaskid());
                    itemList.setInputname(ahpSubtask.getInputname());
                    itemList.setInputdes(ahpSubtask.getInputdes());
                    itemList.setItema(ahpSubtask.getItemname1());
                    itemList.setDesa(ahpSubtask.getItemdes1());
                    itemList.setItemb(ahpSubtask.getItemname2());
                    itemList.setDesb(ahpSubtask.getItemdes2());
                    list.add(itemList);
                }
                break;
            case 6:
                System.out.println("任务6");
                for(int i = 0;i<10;i++){
                    if(i!=0){
                        received_id++;
                    }
                    ItemList itemList = new ItemList();
                    SubtaskAhp ahpSubtask = ahpSubtaskMapper.selectByPrimaryKey(received_id);
                    itemList.setId(ahpSubtask.getSubtaskid());
                    itemList.setInputname(ahpSubtask.getInputname());
                    itemList.setInputdes(ahpSubtask.getInputdes());
                    itemList.setItema(ahpSubtask.getItemname1());
                    itemList.setDesa(ahpSubtask.getItemdes1());
                    itemList.setItemb(ahpSubtask.getItemname2());
                    itemList.setDesb(ahpSubtask.getItemdes2());
                    list.add(itemList);
                }
                break;
            case 7:
                System.out.println("任务7");
                for(int i = 0;i<10;i++){
                    if(i!=0){
                        received_id++;
                    }
                    ItemList itemList = new ItemList();
                    SubtaskAhp ahpSubtask = ahpSubtaskMapper.selectByPrimaryKey(received_id);
                    itemList.setId(ahpSubtask.getSubtaskid());
                    itemList.setInputname(ahpSubtask.getInputname());
                    itemList.setInputdes(ahpSubtask.getInputdes());
                    itemList.setItema(ahpSubtask.getItemname1());
                    itemList.setDesa(ahpSubtask.getItemdes1());
                    itemList.setItemb(ahpSubtask.getItemname2());
                    itemList.setDesb(ahpSubtask.getItemdes2());
                    list.add(itemList);
                }
                break;
            case 8:
                System.out.println("任务8");
                for(int i = 0;i<10;i++){
                    if(i!=0){
                        received_id++;
                    }
                    ItemList itemList = new ItemList();
                    SubtaskAhp ahpSubtask = ahpSubtaskMapper.selectByPrimaryKey(received_id);
                    itemList.setId(ahpSubtask.getSubtaskid());
                    itemList.setInputname(ahpSubtask.getInputname());
                    itemList.setInputdes(ahpSubtask.getInputdes());
                    itemList.setItema(ahpSubtask.getItemname1());
                    itemList.setDesa(ahpSubtask.getItemdes1());
                    itemList.setItemb(ahpSubtask.getItemname2());
                    itemList.setDesb(ahpSubtask.getItemdes2());
                    list.add(itemList);
                }
                break;
        }

        return list;
    }

    @Override
    public User findUserByUserName(String username) {
        User user = userMapper.findUserByUserName(username);
        return user;
    }



}
