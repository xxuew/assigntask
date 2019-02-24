package com.wx.assigntask.service;

import antlr.collections.impl.LList;
import com.wx.assigntask.entity.Userreceive;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/11 14:16
 * @Version 1.0
 */
@Repository
public interface UserReceiveService {

     List<Userreceive> findByUserId(int userId);
     int selectAveScore1(int taskid);
     int selectAveScore2(int taskid);
    List<Integer> selectReleaseIdByUser(int userid);

}
