package com.wx.assigntask.dao;

import com.wx.assigntask.entity.Items;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/10 19:21
 * @Version 1.0
 */
@Repository
@Mapper
public interface ItemsDao {
    //根据itemName查询description
    public String findDesByItemName(String itemName);
}
