package com.wx.assigntask.dao.tool;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author:wx
 * @Date:Created in 14:58 2019/4/16
 * @Modified by:
 */
@Mapper
@Repository
public interface CheckTableMapper {
    List<Map> selectColNameType(String tablename);
}
