package com.nju.assigntask.service;

import com.nju.assigntask.comment.ItemList;
import com.nju.assigntask.entity.Myreceive;
import com.nju.assigntask.entity.OriginalData;
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
  //  void geneSubTask(int releaseId);
    void geneSubTask(List<Release> releases);

    //todo delete
     List<ItemList> insertSubTask(List<OriginalData> originalData);

 //   int insertSubTask(String plan,String algName1,String algName2, int dividedId, String itemName1, String itemDes1, String itemName2, String itemDes2);


    List<Subtask> selectAllSubTask(String plan, String algName1, String algName2);

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


//    int selectSumScore1 (int dividedid,int plan,String algName1,String algName2);
//    int selectSumScore2(int dividedid,int plan,String algName1,String algName2);
//    int selectItem1AveScore(int divided,int itemName);//查询A1出现在itemName1时的平均score
//    int selectItem2AveScore(int divided,int itemName);

    void updateRandom(); //String algName1,String algName2, int subtaskCount, List<Integer> subtaskids
//    void updateFre(String  plan,String algName1,String algName2, Subtask subtask);
//    void updateScore1(int score1,int subtaskid,int plan,String algName1,String algName2);
//    void updateScore2(int score2,int subtaskid,int plan,String algName1,String algName2);
    void updateStatus(int releaseid);

    /**
     * 处理usertask表的用户打分，得到sutask表的score
     */
//    void handleSubtaskData(int plan);
//    void handleSubtaskData(int plan,String algname1,String algname2);
    /**
     * 处理usertask表的用户打分，得到divided表的score
     */
 //   void  handleDividedData(int plan,String algName1,String algName2);

}
