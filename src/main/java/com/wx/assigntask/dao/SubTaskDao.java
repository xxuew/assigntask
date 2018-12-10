package com.wx.assigntask.dao;

import com.wx.assigntask.entity.SubTask;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: wx
 * @Date: 2018/12/9 21:39
 * @Version 1.0
 */
@Mapper
@Repository
public interface SubTaskDao {
    public SubTask findSubBySubId(int id);
    public void insertSubTask( int algorithm_id1,int algorithm_id2,int judged_frequency);
}
