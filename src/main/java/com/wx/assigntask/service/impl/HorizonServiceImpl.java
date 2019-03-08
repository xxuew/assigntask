package com.wx.assigntask.service.impl;

import com.wx.assigntask.comment.ItemList;
import com.wx.assigntask.dao.SubtaskMapper;
import com.wx.assigntask.dao.UserMapper;
import com.wx.assigntask.entity.AhpSubtask;
import com.wx.assigntask.entity.Subtask;
import com.wx.assigntask.entity.SubtaskCnnTfidf;
import com.wx.assigntask.entity.User;
import com.wx.assigntask.service.IHorizonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HorizonServiceImpl implements IHorizonService {
    @Autowired
    SubtaskMapper subtaskMapper;
    @Autowired
    UserMapper userMapper;

    private int horizon_count = 0;
    @Override
    public List<ItemList> assignTask(User user) {
        List<ItemList> list = new ArrayList<>();
        System.out.println("-----------horizon_count------------");
        System.out.println(horizon_count);
//        生成任务，将用户id写入任务数据表表
        int uid = user.getUser_id();
        for(int i = 0;i<10;i++) {
            ItemList itemList = new ItemList();
            horizon_count++;
//            将分配的任务id写入用户数据表
            if (i == 0) {
                user.setReceived_id(horizon_count);
                user.setAlgo_id(4);
                userMapper.updateUser(user);
            }
            Subtask subtask = subtaskMapper.selectByPrimaryKey(horizon_count);
//            id表示任务分配给了谁
            subtask.setDividedId(uid);
            subtaskMapper.updateByPrimaryKey(subtask);

            itemList.setId(subtask.getSubtaskId());
            itemList.setInputname(subtask.getInputName());
            itemList.setInputdes(subtask.getInputDes());
            itemList.setItema(subtask.getItemName1());
            itemList.setDesa(subtask.getItemDes1());
            itemList.setItemb(subtask.getItemName2());
            itemList.setDesb(subtask.getItemDes2());
            list.add(itemList);
        }
        return list;
    }

    @Override
    public void StoreData(User user, List<ItemList> lists) {
        int received_id = user.getReceived_id();
        for(int i = 0;i<10;i++){
            if(i != 0){
                received_id++;
            }
            Subtask subtask = subtaskMapper.selectByPrimaryKey(received_id);
            subtask.setScore1((float) lists.get(i).getScorea());
            subtask.setScore2((float)lists.get(i).getScoreb());
            subtaskMapper.updateByPrimaryKey(subtask);
        }
        user.setReceived_id(0);
        user.setAlgo_id(0);
        userMapper.updateUser(user);
    }
}
