package com.wx.assigntask.service.impl;


import com.wx.assigntask.dao.ReleaseMapper;
import com.wx.assigntask.dao.SubtaskMapper;
import com.wx.assigntask.dao.UserMapper;
import com.wx.assigntask.dao.UsertaskMapper;
import com.wx.assigntask.entity.OriginalData;
import com.wx.assigntask.entity.Subtask;
import com.wx.assigntask.entity.Usertask;
import com.wx.assigntask.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: wx
 * @Date: 2018/12/9 21:44
 * @Version 1.0
 */
@Service
public class SubTaskServiceImpl implements SubTaskService {

    @Autowired
    SubtaskMapper subtaskMapper;
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UsertaskMapper usertaskMapper;
    @Autowired
    ReleaseMapper releaseMapper;
    @Autowired
    OriginalDataService originalDataService;
    @Autowired
    DividedService dividedService;

//    @Override
//    public SubTask findSubBySubId(int id) {
//        SubTask subTask = subTaskDao.findSubBySubId(id);
//        return subTask;
//    }

    @Override
    public int updateRandom(int algNum, int random, int subtaskid) {
        Subtask subtask = new Subtask();
        subtask.setRandomnum(random);
        subtask.setSubtaskid(subtaskid);

        if (algNum == 0) {
            //algNum=0对应lstm和nn对比
            subtaskMapper.updateLstmNnRandom(subtask);
        } else if (algNum == 2) {
            //algNum=0对应cnn和tfidf对比
            subtaskMapper.updateCnnTfidf(subtask);
        } else if (algNum == 4) {
            //algNum=0对应doc和index对比
            subtaskMapper.updateDocIndex(subtask);
        }
        return 0;
    }

    @Override
    public List<Subtask> selectAllSubTask(int algNum) {
        //返回所有frequency小于5的subtask
        List<Subtask> subtasks = new ArrayList<>();
        if (algNum == 0) {
            //algNum=0对应lstm和nn对比
            subtasks = subtaskMapper.selectAllLstmNn();
        } else if (algNum == 2) {
            //algNum=0对应cnn和tfidf对比
            subtasks = subtaskMapper.selectAllCnnTfidf();
        } else if (algNum == 4) {
            //algNum=0对应doc和index对比
            subtasks = subtaskMapper.selectAllDocIndex();
        }
        return subtasks;
    }

    @Override
    public void updateFre(int algNum, Subtask subtask) {
        if (algNum == 0) {
            //algNum=0对应lstm和nn对比
            subtaskMapper.updateFreLstmNn(subtask);
        } else if (algNum == 2) {
            //algNum=0对应cnn和tfidf对比
            subtaskMapper.updateFreCnnTfidf(subtask);
        } else if (algNum == 4) {
            //algNum=0对应doc和index对比
            subtaskMapper.updateFreDocIndex(subtask);
        }
    }

    @Override
    public void geneSubTask(int releaseId) {
        //根据releaseID生成subtask
        String ifDivided = releaseMapper.findDivided(releaseId); //判断刚插入的是否分配
        if (!ifDivided.equals("yes")) {
            //完整步骤是去releaseInput关联表查找本次inputID，再去original_data查找相关数据,目前没有关联表，直接去original_data查找相关数据
            List inputs = originalDataService.selectAll();

            List algs = algs(); //6种算法名,针对每次input都要进行6种算法的划分以及生成subtask
            for (int k = 0; k < algs.size() - 1; ) {
                //把100次input关于该对比组的subtask都生成并分发
                for (int i = 0; i < inputs.size(); i++) {
                    //从original_data获取itemNames和itemDes
                    OriginalData originalData = (OriginalData) inputs.get(i);
                    List itemNames = originalDataService.selectAllItemsNames(originalData.getOid());
                    List itemDes = originalDataService.selectAllItemDes(originalData.getOid());
                    String alg1 = algs.get(k).toString();
                    String alg2 = algs.get(k + 1).toString();
                    int dividedId = dividedService.insertDivided(releaseId, originalData.getName(), alg1, alg2);
                    //写进divided即划分subtask写进subtask表
                    String diIfDiv = dividedService.findIfDivided(dividedId);
                    if (!diIfDiv.equals("yes") || diIfDiv.isEmpty()) {
                        List<Integer> subtaskids = new ArrayList<Integer>();
                        int subtaskCount = 0; //subtask个数
                        //若没有分配则分配写入subtask
                        subtaskCount = subTaskCp(itemNames, itemDes, k, subtaskids, dividedId, subtaskCount);
                        dividedService.updataDivided("yes", dividedId);
                        int[] randoms = getNumber(subtaskCount);
                        for (int z = 0; z < subtaskids.size() && z < randoms.length; z++) {
                            //更新每个subtask的randomNum
                            updateRandom(k, randoms[z], subtaskids.get(z).intValue());
                        }
                        assignTaskToUser();//分派任务，将userID和subtaskid写进usertask表
                    }
                }
                k = k + 2;
            }
        }
    }

    public int subTaskCp(List itemNames, List itemDes, int algNum, List subtaskids, int dividedId, int subtaskCount) {
        for (int j = 0; j < 10; j++) {
            //A1对B1-B10，A1不变，B变
            int index1 = algNum * 10 + j;
            for (int z = 0; z < 10; z++) {
                int index2 = algNum * 10 + z;
                String itemName1 = itemNames.get(index1).toString();
                String itemName2 = itemNames.get(index2 + 10).toString();
                String itemDes1 = itemDes.get(index1).toString();
                String itemDes2 = itemDes.get(index2 + 10).toString();

                //插入subtask
                int subtaskid = insertSubTask(algNum, dividedId, itemName1, itemDes1, itemName2, itemDes2);
                subtaskids.add(subtaskid);
                subtaskCount++;
            }
        }
        return subtaskCount;
    }

    @Override
    public int insertSubTask(int algNum, int dividedId, String itemName1, String itemDes1, String itemName2, String itemDes2) {
        Subtask subtask = new Subtask();
        subtask.setDividedid(dividedId);
        subtask.setItemname1(itemName1);
        subtask.setItemdes1(itemDes1);
        subtask.setItemname2(itemName2);
        subtask.setItemdes2(itemDes2);

        if (algNum == 0) {
            //algNum=0对应lstm和nn对比
            subtaskMapper.inserToLstmNn(subtask);
        } else if (algNum == 2) {
            //algNum=0对应cnn和tfidf对比
            subtaskMapper.insertToCnnTfidf(subtask);
        } else if (algNum == 4) {
            //algNum=0对应doc和index对比
            subtaskMapper.insertToDocIndex(subtask);
        }
        int subtaskid = subtask.getSubtaskid();
        return subtaskid;
    }

    public List<String> algs() {
        //TODO  这里算法名称已经写死了
        List algs = new ArrayList();
        algs.add("lstm");
        algs.add("nn");
        algs.add("cnn");
        algs.add("tfidf");
        algs.add("doc");
        algs.add("index");
        return algs;
    }

    public int[] getNumber(int total) {
        int[] NumberBox = new int[total];           //容器A
        int[] rtnNumber = new int[total];           //容器B
        for (int i = 0; i < total; i++) {
            NumberBox[i] = i;     //先把N个数放入容器A中
        }
        int end = total - 1;
        for (int j = 0; j < total; j++) {
            int num = new Random().nextInt(end + 1);  //取随机数
            rtnNumber[j] = NumberBox[num];            //把随机数放入容器B
            NumberBox[num] = NumberBox[end];          //把容器A中最后一个数覆盖所取的随机数
            end--;                                    //缩小随机数所取范围
        }
        return rtnNumber;                           //返回int型数组
    }

    public void assignTaskToUser() {
        List<Integer> userIDs = userService.selectAllId(); //所有用户ID
        List algs = algs();
        for (int algNum = 0; algNum < algs.size(); algNum++) {
            //根据algs存放顺序分配
            List<Subtask> subtasks = selectAllSubTask(algNum); //所有frequency小于5的subtask
            int userCount = 0;//用来记录用户ID移动
            int taskCount = 0;//记录subtask的移动
            if (subtasks.size() > 0) {
                while (userCount < userIDs.size() && taskCount < subtasks.size()) {
                    //分配任务插入对应的usertask表
                    Usertask usertask = new Usertask();
                    int userId = userIDs.get(userCount);
                    for (int i = 0; i < 10; i++) {
                        //先保证每个用户分到了10个subtask
                        Subtask subtask = subtasks.get(taskCount);
                        int subTaskId = subtask.getSubtaskid();
                        usertask.setUserid(userId);
                        usertask.setTaskid(subTaskId);
                        usertaskMapper.insertSubTask(usertask);
                        subtask.setFrequency(subtask.getFrequency() + 1);//修改subtask的frequency
                        updateFre(algNum, subtask);
                        taskCount++;
                        if (taskCount > subtasks.size()) //若没有剩余的subtask了则终止分配
                            break;
                    }

                    userMapper.updateTaking(userId,userMapper.findUserById(userId).getTasking()+1);//用户目前任务+1
                    if (userCount + 1 > userIDs.size() && taskCount < subtasks.size()) {
                        //当用户都分配过一次，subt还没分配完，就将用户从头再分配一次
                        // TODO
                        // 需要控制最多3次,目前没控制，在user表或者usertask加个字段
                        userCount = -1;
                    }
                    userCount++;
                }
            }
        }
    }

}
