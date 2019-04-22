package com.nju.assigntask.service;

import com.nju.assigntask.entity.Userreceive;
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

    void updateScore(int dividedid,int userid,int subtaskid,int score1,int score2);


}
