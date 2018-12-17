package com.wx.assigntask.service;

import com.wx.assigntask.entity.Subtask;
import org.springframework.stereotype.Repository;

/**
 * @Author: wx
 * @Date: 2018/12/9 21:43
 * @Version 1.0
 */
@Repository
public interface SubTaskService {
//    public Subtask findSubBySubId(int id);

    public int insertSubTask(int dividedId,String itemName1,String itemDes1,String itemName2,String itemDes2);

    public int updateRandom(int random,int subtaskid);
}
