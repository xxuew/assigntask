//package com.wx.assigntask.service.impl;
//
//import com.wx.assigntask.dao.ReleaseDao;
//import com.wx.assigntask.entity.ReleaseTask;
//import com.wx.assigntask.service.ReleaseService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * @Author: wx
// * @Date: 2018/12/7 18:30
// * @Version 1.0
// */
//@Service
//public class ReleaseServiceImpl implements ReleaseService {
//
//    @Autowired
//    ReleaseDao releaseDao;
//
//    @Override
//    public List finAlgsByInputName(String inputName) {
//
//        List algs = releaseDao.finAlgsByInputName(inputName);
//        return algs;
//    }
//
//    @Override
//    public void updateDivided(String divided,String inputName,String algName) {
//        releaseDao.updateDivided(divided,inputName,algName);
//    }
//
//    @Override
//    public String findDivided(String inputName, String algName) {
//        String divided = releaseDao.findDivided(inputName,algName);
//        return divided;
//    }
//}
