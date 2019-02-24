package com.wx.assigntask.service.impl;


import com.wx.assigntask.dao.UserreceiveMapper;
import com.wx.assigntask.entity.Userreceive;
import com.wx.assigntask.service.UserReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/11 14:17
 * @Version 1.0
 */
@Service
public class UserReceiveServiceImpl implements UserReceiveService {
    @Autowired
    UserreceiveMapper userreceiveMapper;

    @Override
    public List<Userreceive> findByUserId(int userId) {
        List<Userreceive> list = userreceiveMapper.findByUserId(userId);
        return list;
    }

    @Override
    public int selectAveScore1(int taskid) {
        Userreceive userreceive = new Userreceive();
        userreceive.setTaskid(taskid);
        int aveScore1 = userreceiveMapper.selectAveScore1(userreceive);
        return aveScore1;
    }

    @Override
    public int selectAveScore2(int taskid) {
        Userreceive userreceive =new Userreceive();
        userreceive.setTaskid(taskid);
        int aveScore2 = userreceiveMapper.selectAveScore2(userreceive);
        return aveScore2;
    }

    @Override
    public List<Integer> selectReleaseIdByUser(int userid) {
        List<Integer> releaseids = userreceiveMapper.selectReleaseIdByUser(userid);
        return releaseids;
    }
}
