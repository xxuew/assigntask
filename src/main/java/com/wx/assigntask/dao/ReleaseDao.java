package com.wx.assigntask.dao;

import com.wx.assigntask.entity.ReleaseTask;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/5 14:45
 * @Version 1.0
 */
@Mapper
@Repository
public interface ReleaseDao {
     public List finAlgsByInputName(String inputName);

     public void updateDivided(String divided,String inputName,String algName);

     public String findDivided(String inputName,String algName);

}
