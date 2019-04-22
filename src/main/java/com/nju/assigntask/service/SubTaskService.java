package com.nju.assigntask.service;


import com.nju.assigntask.entity.Myreceive;

import com.nju.assigntask.entity.Release;
import com.nju.assigntask.entity.Subtask;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/9 21:43
 * @Version 1.0
 */
@Repository
public interface SubTaskService {

    /**
     * 生成任务
     */
    void geneSubTask(List<Release> releases);


    /**
     * 通过subtaskid查询
     * @param subtaskid
     * @param plan
     * @param algName1
     * @param algName2
     * @return
     */
    Subtask selectSubBySubId(int subtaskid,int plan,String algName1,String algName2);
    /**
     * 通过myreceive的subtask_1--subtask_10查询
     * @param myreceives
     * @return
     */
    List<Subtask> selectSubBySubId(Myreceive myreceives);


    void updateRandom();

    void updateStatus(int releaseid);

}
