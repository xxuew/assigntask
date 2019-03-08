package com.wx.assigntask.service;

import com.wx.assigntask.entity.OriginalData;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IOriginalDataService {
    public OriginalData selectByid(Integer oid);
    public List<OriginalData> selectAll();
    OriginalData selectByPrimaryKey(Integer oid);
}
