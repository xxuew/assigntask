//package com.wx.assigntask.service.impl;
//
//import com.wx.assigntask.dao.DividedDao;
//import com.wx.assigntask.service.DividedService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * @Author: wx
// * @Date: 2018/12/10 13:41
// * @Version 1.0
// */
//@Service
//public class DividedServiceImpl implements DividedService {
//    @Autowired
//    DividedDao dividedDao;
//
//    @Override
//    public int insertDivided(String algname1, String algname2) {
//       int dividedId = dividedDao.insertDivided(algname1,algname2);
//        return dividedId;
//    }
//
//    @Override
//    public int findDividedIdByAlgs(String algname1, String algname2) {
//        int dividedId = dividedDao.findDividedIdByAlgs(algname1,algname2);
//        return dividedId;
//    }
//}
