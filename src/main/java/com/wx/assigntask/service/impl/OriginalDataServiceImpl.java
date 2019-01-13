package com.wx.assigntask.service.impl;

import com.wx.assigntask.dao.OriginalDataMapper;
import com.wx.assigntask.entity.OriginalData;
import com.wx.assigntask.service.OriginalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//
@Service
public class OriginalDataServiceImpl implements OriginalDataService {
    @Autowired
    private OriginalDataMapper originalDataMapper;
    @Override
    public OriginalData selectByid(@RequestParam("oid")Integer oid) {
        return originalDataMapper.selectByPrimaryKey(oid);
    }

    @Override
    public List<OriginalData> selectAll() {
        return originalDataMapper.selectAll();
    }
}
