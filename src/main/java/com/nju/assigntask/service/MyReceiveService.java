package com.nju.assigntask.service;

/**
 * @Author:wx
 * @Date:Created in 18:56 2019/2/24
 * @Modified by:
 */

import com.nju.assigntask.entity.Myreceive;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * myreceive表业务相关处理
 * 整合用户收到的任务，十个subtask为一个任务
 */
@Repository
public interface MyReceiveService {
    /**
     * 插入记录
     * @param subtaskids
     * @param userid
     * @param releaseid
     * @param divided
     */
    void insertRecord(List<Integer> subtaskids,int userid,int releaseid,int divided);

    /**
     * 更新ifcomplete字段
     * @param id
     * @param ifComplete
     */
    void updateIfcomple(int id,String ifComplete);

    /**
     *
     * @param userid
     * @return
     */
    List<Myreceive> selectByUser(int userid);

    /**
     * 查询某用户收到的某组任务
     * @param userid
     * @param myReceiveId
     * @return
     */
    Myreceive selectByUser(int userid,int myReceiveId);

    /**
     * 查询某用户的某个任务状态下的任务列表
     * @param userid
     * @param ifComplete
     * @return
     */
    List<Myreceive> selectIfcomByUser(int userid,String ifComplete);

}
