package com.wx.assigntask.dao;

import com.wx.assigntask.entity.ReleaseTask;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: wx
 * @Date: 2018/12/5 14:45
 * @Version 1.0
 */
@Mapper
@Repository
public interface ReleaseMapper {
     ReleaseTask selectReleaseByUserId(int id);
}
