package com.wx.assigntask.service;

import com.wx.assigntask.entity.ReleaseTask;
import org.springframework.stereotype.Repository;

/**
 * @Author: wx
 * @Date: 2018/12/7 18:29
 * @Version 1.0
 */
@Repository
public interface ReleaseService {

    public ReleaseTask findReleaseById(int id);
}
