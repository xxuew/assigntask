package com.wx.assigntask.service.impl;


import com.wx.assigntask.dao.SubtaskMapper;
import com.wx.assigntask.entity.Subtask;
import com.wx.assigntask.service.SubTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wx
 * @Date: 2018/12/9 21:44
 * @Version 1.0
 */
@Service
public class SubTaskServiceImpl implements SubTaskService {

    @Autowired
    SubtaskMapper subtaskMapper;

//    @Override
//    public SubTask findSubBySubId(int id) {
//        SubTask subTask = subTaskDao.findSubBySubId(id);
//        return subTask;
//    }

    @Override
    public int updateRandom(int random, int subtaskid) {
        Subtask subtask = new Subtask();
        subtask.setRandomnum(random);
        subtask.setSubtaskid(subtaskid);
        subtaskMapper.updateRandom(subtask);
        return 0;
    }

    @Override
    public int insertSubTask(int dividedId,String itemName1,String itemDes1,String itemName2,String itemDes2) {
        Subtask subtask = new Subtask();
        subtask.setDividedid(dividedId);
        subtask.setItemname1(itemName1);
        subtask.setItemdes1(itemDes1);
        subtask.setItemname2(itemName2);
        subtask.setItemdes2(itemDes2);
        subtaskMapper.insertSubTask(subtask);
        int subtaskid = subtask.getSubtaskid();
        return  subtaskid;
    }
}
