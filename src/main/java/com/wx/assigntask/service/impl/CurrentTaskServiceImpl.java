package com.wx.assigntask.service.impl;

import com.wx.assigntask.dao.TaskNumMapper;
import com.wx.assigntask.entity.TaskNum;
import com.wx.assigntask.service.ICurrentTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CurrentTaskServiceImpl implements ICurrentTaskService {
    @Autowired
    TaskNumMapper taskNumMapper;
    @Override
    public List<Integer> currenttasknum() {
        int ctnum;
        List<Integer> list = new ArrayList();
        List<TaskNum> taskList = taskNumMapper.selectAll();
        for (TaskNum a:taskList) {
            int id = a.getTable_id();
            int num = a.getCurrent_num();
            int frequence = a.getFrequence();
            if (id <= 3){
                if(frequence == 0){
                    ctnum = 50000;
                }else {
                    ctnum = 50000-num-(frequence-1)*10000;
                }
                list.add(ctnum);
            }else if (id == 4){
                if(frequence == 0){
                    ctnum = 32000*5;
                }else {
                    ctnum = 32000*5-num-(frequence-1)*10000;
                }
                list.add(ctnum);
            }else if (id == 5){
                if(frequence == 0){
                    ctnum = 15000*5;
                }else {
                    ctnum = 15000*5-num-(frequence-1)*10000;
                }
                list.add(ctnum);
            }
        }

        for (int i: list) {
            System.out.println("当前任务总量 "+i);
        }
        return list;
    }
}
