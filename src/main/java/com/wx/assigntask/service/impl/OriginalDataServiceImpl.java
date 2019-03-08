package com.wx.assigntask.service.impl;

import com.wx.assigntask.dao.OriginalDataMapper;
import com.wx.assigntask.entity.OriginalData;
import com.wx.assigntask.service.IOriginalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//
@Service
public class OriginalDataServiceImpl implements IOriginalDataService {

    @Autowired
    private OriginalDataMapper originalDataMapper;

//    OriginalDataService originalDataMapper = new OriginalDataServiceImpl();
    @Override
    public OriginalData selectByid(@RequestParam("oid")Integer oid) {
        return originalDataMapper.selectByPrimaryKey(oid);
    }

    @Override
    public List<OriginalData> selectAll() {
        return originalDataMapper.selectAll();
    }

    @Override
    public OriginalData selectByPrimaryKey(Integer oid) {
        return null;
    }
}
