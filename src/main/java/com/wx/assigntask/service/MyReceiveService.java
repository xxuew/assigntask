package com.wx.assigntask.service;

/**
 * @Author:wx
 * @Date:Created in 18:56 2019/2/24
 * @Modified by:
 */

import com.wx.assigntask.entity.Myreceive;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 整合用户收到的任务，十个subtask为一个任务
 */
@Repository
public interface MyReceiveService {
    void insertRecord(List<Integer> subtaskids,int userid,int divided);
    List<Myreceive> selectByUser(int userid);
    Myreceive selectByUser(int userid,int count);
}
