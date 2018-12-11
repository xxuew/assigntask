package com.wx.assigntask.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: wx
 * @Date: 2018/12/10 10:59
 * @Version 1.0
 */
@Mapper
@Repository
public interface DividedDao {
    public int insertDivided(String algname1,String algname2);
    public int findDividedIdByAlgs(String algname1,String algname2);
}
