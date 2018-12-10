package com.wx.assigntask.service;

import com.wx.assigntask.entity.Algorithm;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/8 18:33
 * @Version 1.0
 */
@Repository
public interface AlgorithmService {
//    public ArrayList<Algorithm> allJobInfo();

//    public void insertTask(String algorithmName, int item_num, String item_1, String item_2, String item_3, String item_4, String item_5, String item_6, String item_7, String item_8, String item_9, String item_10, int judged_frequency);
//
//    public void updateJudFreq(int algorithmId,int judged_frequency);
//
//    public void updateDivided(int algorithmId,String divided);
     public List findItemByAloName(String algName, String inputName);
}

