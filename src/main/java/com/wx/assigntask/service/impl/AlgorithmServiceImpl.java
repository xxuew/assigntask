package com.wx.assigntask.service.impl;

import com.wx.assigntask.dao.AlgorithmDao;
import com.wx.assigntask.entity.Algorithm;
import com.wx.assigntask.service.AlgorithmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/8 18:37
 * @Version 1.0
 */
@Service
public class AlgorithmServiceImpl implements AlgorithmService {
    @Autowired
    AlgorithmDao algorithmDao;

    @Override
    public List findItemByAloName(String algName, String inputName) {
        List itemName = algorithmDao.findItemByAlgName(algName,inputName);
        return itemName;
    }


//
//    @Override
//    public ArrayList<Algorithm> allJobInfo() {
//        ArrayList<Algorithm> algorithm = algorithmDao.findAllJobData();
//        return algorithm;
//    }
//
//    @Override
//    public void insertTask(String algorithmName, int item_num, String item_1, String item_2, String item_3, String item_4, String item_5, String item_6, String item_7, String item_8, String item_9, String item_10, int judged_frequency) {
//        algorithmDao.insertTask(algorithmName,item_num,item_1,item_2,item_3,item_4,item_5,item_6,item_7,item_8,item_9,item_10,judged_frequency);
//    }
//
//    @Override
//    public void updateJudFreq(int algorithmId,int judged_frequency) {
//        algorithmDao.updateJudFreq(algorithmId,judged_frequency);
//    }
//
//    @Override
//    public void updateDivided(int algorithmId,String divided) {
//        algorithmDao.updataeDivided(algorithmId,divided);
//    }


}
