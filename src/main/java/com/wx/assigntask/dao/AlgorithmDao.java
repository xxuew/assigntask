package com.wx.assigntask.dao;

import com.wx.assigntask.entity.Algorithm;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/8 18:24
 * @Version 1.0
 */
@Repository
@Mapper
public interface AlgorithmDao {
 //   public void updataeDivided(int algorithmId,String divided);
      public List findItemByAlgName(String algName, String inputName);

}
