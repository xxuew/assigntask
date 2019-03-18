package com.wx.assigntask.service.impl;

import com.wx.assigntask.dao.AlgresultMapper;
import com.wx.assigntask.dao.TaskNumMapper;
import com.wx.assigntask.entity.Algresult;
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
    @Autowired
    AlgresultMapper algresultMapper;

    @Override
    public List<Integer> currenttasknum() {
        int ctnum;
        List<Integer> list = new ArrayList();
        List<TaskNum> taskList = taskNumMapper.selectAll();
        Algresult algresult1 = algresultMapper.selectByPrimaryKey(1);
        Algresult algresult2 = algresultMapper.selectByPrimaryKey(2);
        Algresult algresult3 = algresultMapper.selectByPrimaryKey(3);
        for (TaskNum a:taskList) {
            int id = a.getTable_id();
            int num = a.getCurrent_num();
            int frequence = a.getFrequence();
            if (id <= 3){
                if(frequence == 0){
                    ctnum = 30000;
                }else {
                    ctnum = 30000-num-(frequence-1)*10000;
                }
                if (ctnum<0){
                    ctnum = 0;
                }
                list.add(ctnum);
            }else if (id == 4){
                if (algresult1.getWinAlgname() == null){
                    ctnum = 0;
                }else if(frequence == 0){
                    ctnum = 30000;
                }else {
                    ctnum = 30000-num-(frequence-1)*10000;
                }
                if (ctnum<0){
                    ctnum = 0;
                }
                list.add(ctnum);
            }else if (id == 5){
                if (algresult2.getWinAlgname() == null){
                    ctnum = 0;
                }else if(frequence == 0){
                    ctnum = 30000;
                }else {
                    ctnum = 30000-num-(frequence-1)*10000;
                }
                if (ctnum<0){
                    ctnum = 0;
                }
                list.add(ctnum);
            }else if (id == 6){
                if (algresult3.getWinAlgname() == null){
                    ctnum = 0;
                }else if(frequence == 0){
                    ctnum = 30000;
                }else {
                    ctnum = 30000-num-(frequence-1)*10000;
                }
                if (ctnum<0){
                    ctnum = 0;
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
