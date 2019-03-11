package com.wx.assigntask.service.impl;

import com.wx.assigntask.comment.ItemList;
import com.wx.assigntask.dao.ScoreHorizonMapper;
import com.wx.assigntask.dao.SubtaskHorizonMapper;
import com.wx.assigntask.dao.TaskNumMapper;
import com.wx.assigntask.dao.UserMapper;
import com.wx.assigntask.entity.*;
import com.wx.assigntask.service.IHorizonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HorizonServiceImpl implements IHorizonService {
    @Autowired
    SubtaskHorizonMapper subtaskMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ScoreHorizonMapper scoreHorizonMapper;
    @Autowired
    TaskNumMapper taskNumMapper;

    private int horizon_count = 0;
    @Override
    public List<ItemList> assignTask(User user) {
        List<ItemList> list = new ArrayList<>();
        int frequency = 0;
        System.out.println("-----------horizon_count------------");
        System.out.println(horizon_count);
        if (horizon_count == 32000){
            horizon_count = 0;
        }
//        生成任务，将用户id写入任务数据表表
        int uid = user.getUser_id();
        for(int i = 0;i<10;i++) {
            ItemList itemList = new ItemList();
            horizon_count++;
            SubtaskHorizon subtask = subtaskMapper.selectByPrimaryKey(horizon_count);
//            id表示任务分配给了谁
            subtask.setDividedId(uid);
            //            更新重复次数
            frequency = subtask.getFrequency();
            frequency++;
            //            将分配的任务id写入用户数据表
            if (i == 0) {
                user.setReceived_id(horizon_count);
                user.setAlgo_id(4);
                user.setFrequency(frequency);
                userMapper.updateUser(user);
            }
            if(frequency <= 5) {
                subtask.setFrequency(frequency);
                subtaskMapper.updateByPrimaryKey(subtask);
                itemList.setId(subtask.getSubtaskId());
                itemList.setInputname(subtask.getInputName());
                itemList.setInputdes(subtask.getInputDes());
                itemList.setItema(subtask.getItemName1());
                itemList.setDesa(subtask.getItemDes1());
                itemList.setItemb(subtask.getItemName2());
                itemList.setDesb(subtask.getItemDes2());
                list.add(itemList);
            }else {
                return null;
            }
        }
        TaskNum taskNum = new TaskNum();
        taskNum.setTable_id(4);
        taskNum.setCurrent_num(horizon_count);
        taskNum.setFrequence(frequency);
        taskNumMapper.update(taskNum);
        return list;
    }

    @Override
    public void StoreData(User user, List<ItemList> lists) {
        int uid = user.getUser_id();
        int received_id = user.getReceived_id();
        for(int i = 0;i<10;i++){
            if(i != 0){
                received_id++;
            }
            ScoreHorizon scoreHorizon = new ScoreHorizon();
            scoreHorizon.setScoreId(received_id);
            scoreHorizon.setSubtaskId(received_id);
            if(scoreHorizonMapper.selectByPrimaryKey(received_id) == null){
                scoreHorizon.setScoreId(received_id);
                scoreHorizon.setSubtaskId(received_id);
                scoreHorizonMapper.insert(scoreHorizon);
            }else {
                scoreHorizon = scoreHorizonMapper.selectByPrimaryKey(received_id);
            }
            int frequency = user.getFrequency();
            switch (frequency){
                case 1:
                    scoreHorizon.setUid1(uid);
                    scoreHorizon.setScorea1(lists.get(i).getScorea());
                    scoreHorizon.setScoreb1(lists.get(i).getScoreb());
                    break;
                case 2:
                    scoreHorizon.setUid2(uid);
                    scoreHorizon.setScorea2(lists.get(i).getScorea());
                    scoreHorizon.setScoreb2(lists.get(i).getScoreb());
                    break;
                case 3:
                    scoreHorizon.setUid3(uid);
                    scoreHorizon.setScorea3(lists.get(i).getScorea());
                    scoreHorizon.setScoreb3(lists.get(i).getScoreb());
                    break;
                case 4:
                    scoreHorizon.setUid4(uid);
                    scoreHorizon.setScorea4(lists.get(i).getScorea());
                    scoreHorizon.setScoreb4(lists.get(i).getScoreb());
                    break;
                case 5:
                    scoreHorizon.setUid5(uid);
                    scoreHorizon.setScorea5(lists.get(i).getScorea());
                    scoreHorizon.setScoreb5(lists.get(i).getScoreb());
                    break;
            }
            scoreHorizonMapper.updateByPrimaryKey(scoreHorizon);
        }
        user.setReceived_id(0);
        user.setAlgo_id(0);
        user.setFrequency(0);
        userMapper.updateUser(user);
    }
}
