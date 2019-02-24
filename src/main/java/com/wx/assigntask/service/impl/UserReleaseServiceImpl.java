package com.wx.assigntask.service.impl;

import com.wx.assigntask.dao.UserreleaseMapper;
import com.wx.assigntask.entity.Userrelease;
import com.wx.assigntask.service.UserReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserReleaseServiceImpl implements UserReleaseService {
    @Autowired
    UserreleaseMapper userreleaseMapper;

    @Override
    public void insertRecord(int userid,int releaseid) {
        Userrelease userrelease = new Userrelease();
        userrelease.setUserid(userid);
        userrelease.setReleaseid(releaseid);
        userreleaseMapper.insert(userrelease);
    }

    @Override
    public List<Integer> selectByUser(int userid) {
        List<Integer> releaseids = userreleaseMapper.selectByUser(userid);
        return releaseids;
    }
}
