package com.wx.assigntask.service.impl;

import com.wx.assigntask.dao.DividedMapper;
import com.wx.assigntask.entity.Divided;
import com.wx.assigntask.service.DividedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/10 13:41
 * @Version 1.0
 */
@Service
public class DividedServiceImpl implements DividedService {
    @Autowired
    DividedMapper dividedMapper;

    @Override
    public int updataDivided(String ifdivided, int dividedId) {
        return dividedMapper.updataDivided(ifdivided,dividedId);
    }

    @Override
    public String findIfDivided(int dividedId) {
        return dividedMapper.findIfDivided(dividedId);
    }

    @Override
    public List<Divided> selectAll() {

        return dividedMapper.selectAll();
    }

    @Override
    public int insertDivided(int releaseId,String inputName,String algname1, String algname2) {
        Divided divided =new Divided();
        divided.setReleaseid(releaseId);
        divided.setInputname(inputName);
        divided.setAlgname1(algname1);
        divided.setAlgname2(algname2);
       dividedMapper.insertDivided(divided);
       int id =divided.getDividedid();
       return id;
    }

//    @Override
//    public int findDividedIdByAlgs(String algname1, String algname2) {
//        int dividedId = dividedMapper.findDividedIdByAlgs(algname1,algname2);
//        return dividedId;
//    }
}
