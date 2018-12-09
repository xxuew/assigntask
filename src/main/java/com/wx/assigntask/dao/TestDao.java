package com.wx.assigntask.dao;

import com.wx.assigntask.entity.TaskTest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/8 18:24
 * @Version 1.0
 */
@Repository
@Mapper
public interface TestDao {
    public ArrayList<TaskTest> findAllJobData();
}
