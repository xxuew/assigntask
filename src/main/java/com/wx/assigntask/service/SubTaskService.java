package com.wx.assigntask.service;

import com.wx.assigntask.dao.SubtaskMapper;
import com.wx.assigntask.dao.UserMapper;
import com.wx.assigntask.entity.Subtask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author: wx
 * @Date: 2018/12/9 21:43
 * @Version 1.0
 */
/**
 * @Author: xd
 * @Date: 2018-12-17 16:16:20
 * @Version 2.0
 */
@Repository
public interface SubTaskService {
    public Subtask findSubBySubId(int id);
    public void insertSubTask(int dividedId,String item1Name,String item1Des,String item2Name,String item2Des);

    public Subtask selectByPrimaryKey(int id);


}
