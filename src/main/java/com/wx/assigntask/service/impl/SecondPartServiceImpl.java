package com.wx.assigntask.service.impl;

import com.wx.assigntask.comment.ItemList;
import com.wx.assigntask.dao.*;
import com.wx.assigntask.entity.*;
import com.wx.assigntask.service.ISecondPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SecondPartServiceImpl implements ISecondPartService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    SubtaskCnnDocMapper subtaskCnnDocMapper;
    @Autowired
    SubtaskCnnIndexMapper subtaskCnnIndexMapper;
    @Autowired
    SubtaskCnnLstmMapper subtaskCnnLstmMapper;
    @Autowired
    SubtaskCnnNnMapper subtaskCnnNnMapper;
    @Autowired
    SubtaskTfidfDocMapper subtaskTfidfDocMapper;
    @Autowired
    SubtaskTfidfIndexMapper subtaskTfidfIndexMapper;
    @Autowired
    SubtaskTfidfLstmMapper subtaskTfidfLstmMapper;
    @Autowired
    SubtaskTfidfNnMapper subtaskTfidfNnMapper;
    @Autowired
    SubtaskDocLstmMapper subtaskDocLstmMapper;
    @Autowired
    SubtaskDocNnMapper subtaskDocNnMapper;
    @Autowired
    SubtaskIndexLstmMapper subtaskIndexLstmMapper;
    @Autowired
    SubtaskIndexNnMapper subtaskIndexNnMapper;
    @Autowired
    TaskNumMapper taskNumMapper;
    @Autowired
    ScoreFinal1Mapper scoreFinal1Mapper;
    @Autowired
    ScoreFinal2Mapper scoreFinal2Mapper;
    @Autowired
    ScoreFinal3Mapper scoreFinal3Mapper;

    private int cnn_doc_count = 0;
    private int cnn_index_count = 0;
    private int cnn_lstm_count = 0;
    private int cnn_nn_count = 0;
    private int tfidf_doc_count = 0;
    private int tfidf_index_count = 0;
    private int tfidf_lstm_count = 0;
    private int tfidf_nn_count = 0;
    private int doc_lstm_count = 0;
    private int doc_nn_count = 0;
    private int index_lstm_count = 0;
    private int index_nn_count = 0;

    @Override
    public List<ItemList> cnn_doc_assignTask(User user,int id) {
        TaskNum taskNum = taskNumMapper.selectById(id);
        int frequency = taskNum.getFrequence();
        cnn_doc_count = taskNum.getCurrent_num();
        System.out.println("taskNum.getFrequence()"+frequency);
        if (cnn_doc_count == 10000&&frequency == 3){
            return null;
        }else {
            List<ItemList> list = new ArrayList<>();
            System.out.println("-----------cnn_doc_count------------");
            System.out.println(cnn_doc_count);
            if (cnn_doc_count == 10000&&frequency != 3) {
                cnn_doc_count = 0;
            }
//        生成任务，将用户id写入任务数据表表
            int uid = user.getUser_id();
            for (int i = 0; i < 10; i++) {
                ItemList itemList = new ItemList();
                cnn_doc_count++;
                SubtaskCnnDoc subtaskCnnDoc = subtaskCnnDocMapper.selectByPrimaryKey(cnn_doc_count);
                //            uid表示任务分配给了谁
                subtaskCnnDoc.setDividedId(uid);
//            更新重复次数
                frequency = subtaskCnnDoc.getFrequency();
                if (frequency<3){frequency++;}
//            将分配的任务id写入用户数据表
                if (i == 0) {
                    user.setReceived_id(cnn_doc_count);
                    user.setAlgo_id(id);
                    user.setFrequency(frequency);
                    userMapper.updateUser(user);
                }

                subtaskCnnDoc.setFrequency(frequency);
                System.out.println("frequency:" + frequency);
                subtaskCnnDocMapper.updateByPrimaryKey(subtaskCnnDoc);
                itemList.setId(subtaskCnnDoc.getSubtaskId());
                itemList.setInputname(subtaskCnnDoc.getInputName());
                itemList.setInputdes(subtaskCnnDoc.getInputDes());
                itemList.setItema(subtaskCnnDoc.getItemName1());
                itemList.setDesa(subtaskCnnDoc.getItemDes1());
                itemList.setItemb(subtaskCnnDoc.getItemName2());
                itemList.setDesb(subtaskCnnDoc.getItemDes2());
                list.add(itemList);

            }
            taskNum.setCurrent_num(cnn_doc_count);
            taskNum.setFrequence(frequency);
            taskNumMapper.update(taskNum);
            return list;
        }
        }


    @Override
    public List<ItemList> cnn_index_assignTask(User user,int id) {
        TaskNum taskNum = taskNumMapper.selectById(id);
        int frequency = taskNum.getFrequence();
        cnn_index_count = taskNum.getCurrent_num();
        System.out.println("taskNum.getFrequence()"+frequency);
        if (cnn_index_count == 10000&&frequency == 3){
            return null;
        }else {
            List<ItemList> list = new ArrayList<>();
            System.out.println("-----------cnn_index_count------------");
            System.out.println(cnn_index_count);
            if (cnn_index_count == 10000&&frequency != 3) {
                cnn_index_count = 0;
            }

//        生成任务，将用户id写入任务数据表表
            int uid = user.getUser_id();
            for (int i = 0; i < 10; i++) {
                ItemList itemList = new ItemList();
                cnn_index_count++;
                SubtaskCnnIndex subtaskCnnTfidf = subtaskCnnIndexMapper.selectByPrimaryKey(cnn_index_count);
                //            uid表示任务分配给了谁
                subtaskCnnTfidf.setDividedId(uid);
//            更新重复次数
                frequency = subtaskCnnTfidf.getFrequency();
                if (frequency<3){frequency++;}
//            将分配的任务id写入用户数据表
                if (i == 0) {
                    user.setReceived_id(cnn_index_count);
                    user.setAlgo_id(id);
                    user.setFrequency(frequency);
                    userMapper.updateUser(user);
                }

                subtaskCnnTfidf.setFrequency(frequency);
                System.out.println("frequency:" + frequency);
                subtaskCnnIndexMapper.updateByPrimaryKey(subtaskCnnTfidf);
                itemList.setId(subtaskCnnTfidf.getSubtaskId());
                itemList.setInputname(subtaskCnnTfidf.getInputName());
                itemList.setInputdes(subtaskCnnTfidf.getInputDes());
                itemList.setItema(subtaskCnnTfidf.getItemName1());
                itemList.setDesa(subtaskCnnTfidf.getItemDes1());
                itemList.setItemb(subtaskCnnTfidf.getItemName2());
                itemList.setDesb(subtaskCnnTfidf.getItemDes2());
                list.add(itemList);
            }

            taskNum.setCurrent_num(cnn_index_count);
            taskNum.setFrequence(frequency);
            taskNumMapper.update(taskNum);
            return list;
        }
    }

    @Override
    public List<ItemList> cnn_lstm_assignTask(User user,int id) {
        TaskNum taskNum = taskNumMapper.selectById(id);
        int frequency = taskNum.getFrequence();
        cnn_lstm_count = taskNum.getCurrent_num();
        System.out.println("taskNum.getFrequence()"+frequency);
        if (cnn_lstm_count == 10000&&frequency == 3){
            return null;
        }else {
            List<ItemList> list = new ArrayList<>();
            System.out.println("-----------cnn_lstm_count------------");
            System.out.println(cnn_lstm_count);
            if (cnn_lstm_count == 10000 && frequency != 3) {
                cnn_lstm_count = 0;
            }

//        生成任务，将用户id写入任务数据表表
            int uid = user.getUser_id();
            for (int i = 0; i < 10; i++) {
                ItemList itemList = new ItemList();
                cnn_lstm_count++;
                SubtaskCnnLstm subtaskCnnTfidf = subtaskCnnLstmMapper.selectByPrimaryKey(cnn_lstm_count);
                //            uid表示任务分配给了谁
                subtaskCnnTfidf.setDividedId(uid);
//            更新重复次数
                frequency = subtaskCnnTfidf.getFrequency();
                if (frequency < 3) {
                    frequency++;
                }
//            将分配的任务id写入用户数据表
                if (i == 0) {
                    user.setReceived_id(cnn_lstm_count);
                    user.setAlgo_id(id);
                    user.setFrequency(frequency);
                    userMapper.updateUser(user);
                }

                    subtaskCnnTfidf.setFrequency(frequency);
                    System.out.println("frequency:" + frequency);
                    subtaskCnnLstmMapper.updateByPrimaryKey(subtaskCnnTfidf);
                    itemList.setId(subtaskCnnTfidf.getSubtaskId());
                    itemList.setInputname(subtaskCnnTfidf.getInputName());
                    itemList.setInputdes(subtaskCnnTfidf.getInputDes());
                    itemList.setItema(subtaskCnnTfidf.getItemName1());
                    itemList.setDesa(subtaskCnnTfidf.getItemDes1());
                    itemList.setItemb(subtaskCnnTfidf.getItemName2());
                    itemList.setDesb(subtaskCnnTfidf.getItemDes2());
                    list.add(itemList);

            }
            taskNum.setCurrent_num(cnn_lstm_count);
            taskNum.setFrequence(frequency);
            taskNumMapper.update(taskNum);
            return list;
        }
    }

    @Override
    public List<ItemList> cnn_nn_assignTask(User user,int id) {
        TaskNum taskNum = taskNumMapper.selectById(id);
        int frequency = taskNum.getFrequence();
        cnn_nn_count = taskNum.getCurrent_num();
        System.out.println("taskNum.getFrequence()"+frequency);
        if (cnn_nn_count == 10000&&frequency == 3){
            return null;
        }else {
            List<ItemList> list = new ArrayList<>();
            System.out.println("-----------cnn_nn_count------------");
            System.out.println(cnn_nn_count);
            if (cnn_nn_count == 10000 && frequency != 3) {
                cnn_nn_count = 0;
            }

//        生成任务，将用户id写入任务数据表表
            int uid = user.getUser_id();
            for (int i = 0; i < 10; i++) {
                ItemList itemList = new ItemList();
                cnn_nn_count++;
                SubtaskCnnNn subtaskCnnTfidf = subtaskCnnNnMapper.selectByPrimaryKey(cnn_nn_count);
                //            uid表示任务分配给了谁
                subtaskCnnTfidf.setDividedId(uid);
//            更新重复次数
                frequency = subtaskCnnTfidf.getFrequency();
                if (frequency < 3) {
                    frequency++;
                }
//            将分配的任务id写入用户数据表
                if (i == 0) {
                    user.setReceived_id(cnn_nn_count);
                    user.setAlgo_id(id);
                    user.setFrequency(frequency);
                    userMapper.updateUser(user);
                }
                    subtaskCnnTfidf.setFrequency(frequency);
                    System.out.println("frequency:" + frequency);
                    subtaskCnnNnMapper.updateByPrimaryKey(subtaskCnnTfidf);
                    itemList.setId(subtaskCnnTfidf.getSubtaskId());
                    itemList.setInputname(subtaskCnnTfidf.getInputName());
                    itemList.setInputdes(subtaskCnnTfidf.getInputDes());
                    itemList.setItema(subtaskCnnTfidf.getItemName1());
                    itemList.setDesa(subtaskCnnTfidf.getItemDes1());
                    itemList.setItemb(subtaskCnnTfidf.getItemName2());
                    itemList.setDesb(subtaskCnnTfidf.getItemDes2());
                    list.add(itemList);

            }
            taskNum.setCurrent_num(cnn_nn_count);
            taskNum.setFrequence(frequency);
            taskNumMapper.update(taskNum);
            return list;
        }
    }

    @Override
    public List<ItemList> tfidf_doc_assignTask(User user,int id) {
        TaskNum taskNum = taskNumMapper.selectById(id);
        int frequency = taskNum.getFrequence();
        tfidf_doc_count = taskNum.getCurrent_num();
        System.out.println("taskNum.getFrequence()"+frequency);
        if (tfidf_doc_count == 10000&&frequency == 3){
            return null;
        }else {
            List<ItemList> list = new ArrayList<>();
            System.out.println("-----------tfidf_doc_count------------");
            System.out.println(tfidf_doc_count);
            if (tfidf_doc_count == 10000 && frequency != 3) {
                tfidf_doc_count = 0;
            }

//        生成任务，将用户id写入任务数据表表
            int uid = user.getUser_id();
            for (int i = 0; i < 10; i++) {
                ItemList itemList = new ItemList();
                tfidf_doc_count++;
                SubtaskTfidfDoc subtaskCnnTfidf = subtaskTfidfDocMapper.selectByPrimaryKey(tfidf_doc_count);
                //            uid表示任务分配给了谁
                subtaskCnnTfidf.setDividedId(uid);
//            更新重复次数
                frequency = subtaskCnnTfidf.getFrequency();
                if (frequency < 3) {
                    frequency++;
                }
//            将分配的任务id写入用户数据表
                if (i == 0) {
                    user.setReceived_id(tfidf_doc_count);
                    user.setAlgo_id(id);
                    user.setFrequency(frequency);
                    userMapper.updateUser(user);
                }

                    subtaskCnnTfidf.setFrequency(frequency);
                    System.out.println("frequency:" + frequency);
                    subtaskTfidfDocMapper.updateByPrimaryKey(subtaskCnnTfidf);
                    itemList.setId(subtaskCnnTfidf.getSubtaskId());
                    itemList.setInputname(subtaskCnnTfidf.getInputName());
                    itemList.setInputdes(subtaskCnnTfidf.getInputDes());
                    itemList.setItema(subtaskCnnTfidf.getItemName1());
                    itemList.setDesa(subtaskCnnTfidf.getItemDes1());
                    itemList.setItemb(subtaskCnnTfidf.getItemName2());
                    itemList.setDesb(subtaskCnnTfidf.getItemDes2());
                    list.add(itemList);
            }
            taskNum.setCurrent_num(tfidf_doc_count);
            taskNum.setFrequence(frequency);
            taskNumMapper.update(taskNum);
            return list;
        }
    }

    @Override
    public List<ItemList> tfidf_index_assignTask(User user,int id) {
        TaskNum taskNum = taskNumMapper.selectById(id);
        int frequency = taskNum.getFrequence();
        tfidf_index_count = taskNum.getCurrent_num();
        System.out.println("taskNum.getFrequence()"+frequency);
        if (tfidf_index_count == 10000&&frequency == 3){
            return null;
        }else {
            List<ItemList> list = new ArrayList<>();
            System.out.println("-----------tfidf_index_count------------");
            System.out.println(tfidf_index_count);
            if (tfidf_index_count == 10000 && frequency != 3) {
                tfidf_index_count = 0;
            }

//        生成任务，将用户id写入任务数据表表
            int uid = user.getUser_id();
            for (int i = 0; i < 10; i++) {
                ItemList itemList = new ItemList();
                tfidf_index_count++;
                SubtaskTfidfIndex subtaskCnnTfidf = subtaskTfidfIndexMapper.selectByPrimaryKey(tfidf_index_count);
                //            uid表示任务分配给了谁
                subtaskCnnTfidf.setDividedId(uid);
//            更新重复次数
                frequency = subtaskCnnTfidf.getFrequency();
                if (frequency < 3) {
                    frequency++;
                }
//            将分配的任务id写入用户数据表
                if (i == 0) {
                    user.setReceived_id(tfidf_index_count);
                    user.setAlgo_id(1);
                    user.setFrequency(frequency);
                    userMapper.updateUser(user);
                }

                    subtaskCnnTfidf.setFrequency(frequency);
                    System.out.println("frequency:" + frequency);
                    subtaskTfidfIndexMapper.updateByPrimaryKey(subtaskCnnTfidf);
                    itemList.setId(subtaskCnnTfidf.getSubtaskId());
                    itemList.setInputname(subtaskCnnTfidf.getInputName());
                    itemList.setInputdes(subtaskCnnTfidf.getInputDes());
                    itemList.setItema(subtaskCnnTfidf.getItemName1());
                    itemList.setDesa(subtaskCnnTfidf.getItemDes1());
                    itemList.setItemb(subtaskCnnTfidf.getItemName2());
                    itemList.setDesb(subtaskCnnTfidf.getItemDes2());
                    list.add(itemList);
            }
            taskNum.setCurrent_num(tfidf_index_count);
            taskNum.setFrequence(frequency);
            taskNumMapper.update(taskNum);
            return list;
        }
    }

    @Override
    public List<ItemList> tfidf_lstm_assignTask(User user,int id) {
        TaskNum taskNum = taskNumMapper.selectById(id);
        int frequency = taskNum.getFrequence();
        tfidf_lstm_count = taskNum.getCurrent_num();
        System.out.println("taskNum.getFrequence()"+frequency);
        if (tfidf_lstm_count == 10000&&frequency == 3){
            return null;
        }else {
            List<ItemList> list = new ArrayList<>();
            System.out.println("-----------tfidf_lstm_count------------");
            System.out.println(tfidf_lstm_count);
            if (tfidf_lstm_count == 10000 && frequency != 3) {
                tfidf_lstm_count = 0;
            }

//        生成任务，将用户id写入任务数据表表
            int uid = user.getUser_id();
            for (int i = 0; i < 10; i++) {
                ItemList itemList = new ItemList();
                tfidf_lstm_count++;
                SubtaskTfidfLstm subtaskCnnTfidf = subtaskTfidfLstmMapper.selectByPrimaryKey(tfidf_lstm_count);
                //            uid表示任务分配给了谁
                subtaskCnnTfidf.setDividedId(uid);
//            更新重复次数
                frequency = subtaskCnnTfidf.getFrequency();
                if (frequency < 3) {
                    frequency++;
                }
//            将分配的任务id写入用户数据表
                if (i == 0) {
                    user.setReceived_id(tfidf_lstm_count);
                    user.setAlgo_id(id);
                    user.setFrequency(frequency);
                    userMapper.updateUser(user);
                }
                    subtaskCnnTfidf.setFrequency(frequency);
                    System.out.println("frequency:" + frequency);
                    subtaskTfidfLstmMapper.updateByPrimaryKey(subtaskCnnTfidf);
                    itemList.setId(subtaskCnnTfidf.getSubtaskId());
                    itemList.setInputname(subtaskCnnTfidf.getInputName());
                    itemList.setInputdes(subtaskCnnTfidf.getInputDes());
                    itemList.setItema(subtaskCnnTfidf.getItemName1());
                    itemList.setDesa(subtaskCnnTfidf.getItemDes1());
                    itemList.setItemb(subtaskCnnTfidf.getItemName2());
                    itemList.setDesb(subtaskCnnTfidf.getItemDes2());
                    list.add(itemList);
            }
            taskNum.setCurrent_num(tfidf_lstm_count);
            taskNum.setFrequence(frequency);
            taskNumMapper.update(taskNum);
            return list;
        }
    }

    @Override
    public List<ItemList> tfidf_nn_assignTask(User user,int id) {
        TaskNum taskNum = taskNumMapper.selectById(id);
        int frequency = taskNum.getFrequence();
        tfidf_nn_count = taskNum.getCurrent_num();
        System.out.println("taskNum.getFrequence()"+frequency);
        if (tfidf_nn_count == 10000&&frequency == 3){
            return null;
        }else {
            List<ItemList> list = new ArrayList<>();
            System.out.println("-----------tfidf_nn_count------------");
            System.out.println(tfidf_nn_count);
            if (tfidf_nn_count == 10000 && frequency != 3) {
                tfidf_nn_count = 0;
            }

//        生成任务，将用户id写入任务数据表表
            int uid = user.getUser_id();
            for (int i = 0; i < 10; i++) {
                ItemList itemList = new ItemList();
                tfidf_nn_count++;
                SubtaskTfidfNn subtaskCnnTfidf = subtaskTfidfNnMapper.selectByPrimaryKey(tfidf_nn_count);
                //            uid表示任务分配给了谁
                subtaskCnnTfidf.setDividedId(uid);
//            更新重复次数
                frequency = subtaskCnnTfidf.getFrequency();
                if (frequency < 3) {
                    frequency++;
                }
//            将分配的任务id写入用户数据表
                if (i == 0) {
                    user.setReceived_id(tfidf_nn_count);
                    user.setAlgo_id(id);
                    user.setFrequency(frequency);
                    userMapper.updateUser(user);
                }
                    subtaskCnnTfidf.setFrequency(frequency);
                    System.out.println("frequency:" + frequency);
                    subtaskTfidfNnMapper.updateByPrimaryKey(subtaskCnnTfidf);
                    itemList.setId(subtaskCnnTfidf.getSubtaskId());
                    itemList.setInputname(subtaskCnnTfidf.getInputName());
                    itemList.setInputdes(subtaskCnnTfidf.getInputDes());
                    itemList.setItema(subtaskCnnTfidf.getItemName1());
                    itemList.setDesa(subtaskCnnTfidf.getItemDes1());
                    itemList.setItemb(subtaskCnnTfidf.getItemName2());
                    itemList.setDesb(subtaskCnnTfidf.getItemDes2());
                    list.add(itemList);
            }

            taskNum.setCurrent_num(tfidf_nn_count);
            taskNum.setFrequence(frequency);
            taskNumMapper.update(taskNum);
            return list;
        }
    }

    @Override
    public List<ItemList> doc_lstm_assignTask(User user,int id) {
        TaskNum taskNum = taskNumMapper.selectById(id);
        int frequency = taskNum.getFrequence();
        doc_lstm_count = taskNum.getCurrent_num();
        System.out.println("taskNum.getFrequence()"+frequency);
        if (doc_lstm_count == 10000&&frequency == 3){
            return null;
        }else {
            List<ItemList> list = new ArrayList<>();
            System.out.println("-----------doc_lstm_count------------");
            System.out.println(doc_lstm_count);
            if (doc_lstm_count == 10000 && frequency != 3) {
                doc_lstm_count = 0;
            }

//        生成任务，将用户id写入任务数据表表
            int uid = user.getUser_id();
            for (int i = 0; i < 10; i++) {
                ItemList itemList = new ItemList();
                doc_lstm_count++;
                SubtaskDocLstm subtaskCnnTfidf = subtaskDocLstmMapper.selectByPrimaryKey(doc_lstm_count);
                //            uid表示任务分配给了谁
                subtaskCnnTfidf.setDividedId(uid);
//            更新重复次数
                frequency = subtaskCnnTfidf.getFrequency();
                if (frequency < 3) {
                    frequency++;
                }
//            将分配的任务id写入用户数据表
                if (i == 0) {
                    user.setReceived_id(doc_lstm_count);
                    user.setAlgo_id(id);
                    user.setFrequency(frequency);
                    userMapper.updateUser(user);
                }

                    subtaskCnnTfidf.setFrequency(frequency);
                    System.out.println("frequency:" + frequency);
                    subtaskDocLstmMapper.updateByPrimaryKey(subtaskCnnTfidf);
                    itemList.setId(subtaskCnnTfidf.getSubtaskId());
                    itemList.setInputname(subtaskCnnTfidf.getInputName());
                    itemList.setInputdes(subtaskCnnTfidf.getInputDes());
                    itemList.setItema(subtaskCnnTfidf.getItemName1());
                    itemList.setDesa(subtaskCnnTfidf.getItemDes1());
                    itemList.setItemb(subtaskCnnTfidf.getItemName2());
                    itemList.setDesb(subtaskCnnTfidf.getItemDes2());
                    list.add(itemList);
            }
            taskNum.setCurrent_num(doc_lstm_count);
            taskNum.setFrequence(frequency);
            taskNumMapper.update(taskNum);
            return list;
        }
    }

    @Override
    public List<ItemList> doc_nn_assignTask(User user,int id) {
        TaskNum taskNum = taskNumMapper.selectById(id);
        int frequency = taskNum.getFrequence();
        doc_nn_count = taskNum.getCurrent_num();
        System.out.println("taskNum.getFrequence()"+frequency);
        if (doc_nn_count == 10000&&frequency == 3){
            return null;
        }else {
            List<ItemList> list = new ArrayList<>();
            System.out.println("-----------cnn_tfidf_count------------");
            System.out.println(doc_nn_count);
            if (doc_nn_count == 10000 && frequency != 3) {
                doc_nn_count = 0;
            }

//        生成任务，将用户id写入任务数据表表
            int uid = user.getUser_id();
            for (int i = 0; i < 10; i++) {
                ItemList itemList = new ItemList();
                doc_nn_count++;
                SubtaskDocNn subtaskCnnTfidf = subtaskDocNnMapper.selectByPrimaryKey(doc_nn_count);
                //            uid表示任务分配给了谁
                subtaskCnnTfidf.setDividedId(uid);
//            更新重复次数
                frequency = subtaskCnnTfidf.getFrequency();
                if (frequency < 3) {
                    frequency++;
                }
//            将分配的任务id写入用户数据表
                if (i == 0) {
                    user.setReceived_id(doc_nn_count);
                    user.setAlgo_id(id);
                    user.setFrequency(frequency);
                    userMapper.updateUser(user);
                }
                    subtaskCnnTfidf.setFrequency(frequency);
                    System.out.println("frequency:" + frequency);
                    subtaskDocNnMapper.updateByPrimaryKey(subtaskCnnTfidf);
                    itemList.setId(subtaskCnnTfidf.getSubtaskId());
                    itemList.setInputname(subtaskCnnTfidf.getInputName());
                    itemList.setInputdes(subtaskCnnTfidf.getInputDes());
                    itemList.setItema(subtaskCnnTfidf.getItemName1());
                    itemList.setDesa(subtaskCnnTfidf.getItemDes1());
                    itemList.setItemb(subtaskCnnTfidf.getItemName2());
                    itemList.setDesb(subtaskCnnTfidf.getItemDes2());
                    list.add(itemList);

            }
            taskNum.setCurrent_num(doc_nn_count);
            taskNum.setFrequence(frequency);
            taskNumMapper.update(taskNum);
            return list;
        }
    }

    @Override
    public List<ItemList> index_lstm_assignTask(User user,int id) {
        TaskNum taskNum = taskNumMapper.selectById(id);
        int frequency = taskNum.getFrequence();
        index_lstm_count = taskNum.getCurrent_num();
        System.out.println("taskNum.getFrequence()"+frequency);
        if (index_lstm_count == 10000&&frequency == 3){
            return null;
        }else {
            List<ItemList> list = new ArrayList<>();
            System.out.println("-----------cnn_tfidf_count------------");
            System.out.println(index_lstm_count);
            if (index_lstm_count == 10000 && frequency != 3) {
                index_lstm_count = 0;
            }

//        生成任务，将用户id写入任务数据表表
            int uid = user.getUser_id();
            for (int i = 0; i < 10; i++) {
                ItemList itemList = new ItemList();
                index_lstm_count++;
                SubtaskIndexLstm subtaskCnnTfidf = subtaskIndexLstmMapper.selectByPrimaryKey(index_lstm_count);
                //            uid表示任务分配给了谁
                subtaskCnnTfidf.setDividedId(uid);
//            更新重复次数
                frequency = subtaskCnnTfidf.getFrequency();
                if (frequency < 3) {
                    frequency++;
                }
//            将分配的任务id写入用户数据表
                if (i == 0) {
                    user.setReceived_id(index_lstm_count);
                    user.setAlgo_id(id);
                    user.setFrequency(frequency);
                    userMapper.updateUser(user);
                }
                    subtaskCnnTfidf.setFrequency(frequency);
                    System.out.println("frequency:" + frequency);
                    subtaskIndexLstmMapper.updateByPrimaryKey(subtaskCnnTfidf);
                    itemList.setId(subtaskCnnTfidf.getSubtaskId());
                    itemList.setInputname(subtaskCnnTfidf.getInputName());
                    itemList.setInputdes(subtaskCnnTfidf.getInputDes());
                    itemList.setItema(subtaskCnnTfidf.getItemName1());
                    itemList.setDesa(subtaskCnnTfidf.getItemDes1());
                    itemList.setItemb(subtaskCnnTfidf.getItemName2());
                    itemList.setDesb(subtaskCnnTfidf.getItemDes2());
                    list.add(itemList);
            }

            taskNum.setCurrent_num(index_lstm_count);
            taskNum.setFrequence(frequency);
            taskNumMapper.update(taskNum);
            return list;
        }
    }

    @Override
    public List<ItemList> index_nn_assignTask(User user,int id) {
        TaskNum taskNum = taskNumMapper.selectById(id);
        int frequency = taskNum.getFrequence();
        index_nn_count = taskNum.getCurrent_num();
        System.out.println("taskNum.getFrequence()"+frequency);
        if (index_nn_count == 10000&&frequency == 3){
            return null;
        }else {
            List<ItemList> list = new ArrayList<>();
            System.out.println("-----------cnn_tfidf_count------------");
            System.out.println(index_nn_count);
            if (index_nn_count == 10000 && frequency != 3) {
                index_nn_count = 0;
            }

//        生成任务，将用户id写入任务数据表表
            int uid = user.getUser_id();
            for (int i = 0; i < 10; i++) {
                ItemList itemList = new ItemList();
                index_nn_count++;
                SubtaskIndexNn subtaskCnnTfidf = subtaskIndexNnMapper.selectByPrimaryKey(index_nn_count);
                //            uid表示任务分配给了谁
                subtaskCnnTfidf.setDividedId(uid);
//            更新重复次数
                frequency = subtaskCnnTfidf.getFrequency();
                if (frequency < 3) {
                    frequency++;
                }
//            将分配的任务id写入用户数据表
                if (i == 0) {
                    user.setReceived_id(index_nn_count);
                    user.setAlgo_id(id);
                    user.setFrequency(frequency);
                    userMapper.updateUser(user);
                }
                    subtaskCnnTfidf.setFrequency(frequency);
                    System.out.println("frequency:" + frequency);
                    subtaskIndexNnMapper.updateByPrimaryKey(subtaskCnnTfidf);
                    itemList.setId(subtaskCnnTfidf.getSubtaskId());
                    itemList.setInputname(subtaskCnnTfidf.getInputName());
                    itemList.setInputdes(subtaskCnnTfidf.getInputDes());
                    itemList.setItema(subtaskCnnTfidf.getItemName1());
                    itemList.setDesa(subtaskCnnTfidf.getItemDes1());
                    itemList.setItemb(subtaskCnnTfidf.getItemName2());
                    itemList.setDesb(subtaskCnnTfidf.getItemDes2());
                    list.add(itemList);
            }
            taskNum.setCurrent_num(index_nn_count);
            taskNum.setFrequence(frequency);
            taskNumMapper.update(taskNum);
            return list;
        }
    }

    @Override
    public void final1_StoreData(User user, List<ItemList> lists) {
        int total = user.getTotal();
        int uid = user.getUser_id();
        int received_id = user.getReceived_id();
        int frequency = user.getFrequency();
        for(int i = 0;i<10;i++){
            if(i != 0){
                received_id++;
            }
            ScoreFinal1 scoreCnnTfidf = new ScoreFinal1();
            scoreCnnTfidf.setScoreId(received_id);
            scoreCnnTfidf.setSubtaskId(received_id);
            if(scoreFinal1Mapper.selectByPrimaryKey(received_id) == null){
                scoreFinal1Mapper.insert(scoreCnnTfidf);
            }else {
                scoreCnnTfidf = scoreFinal1Mapper.selectByPrimaryKey(received_id);
            }
            switch (frequency){
                case 1:
                    scoreCnnTfidf.setUid1(uid);
                    scoreCnnTfidf.setScorea1(lists.get(i).getScorea());
                    scoreCnnTfidf.setScoreb1(lists.get(i).getScoreb());
                    break;
                case 2:
                    scoreCnnTfidf.setUid2(uid);
                    scoreCnnTfidf.setScorea2(lists.get(i).getScorea());
                    scoreCnnTfidf.setScoreb2(lists.get(i).getScoreb());
                    break;
                case 3:
                    scoreCnnTfidf.setUid3(uid);
                    scoreCnnTfidf.setScorea3(lists.get(i).getScorea());
                    scoreCnnTfidf.setScoreb3(lists.get(i).getScoreb());
                    break;
            }
            scoreFinal1Mapper.updateByPrimaryKey(scoreCnnTfidf);
        }
        user.setReceived_id(0);
        user.setAlgo_id(0);
        user.setFrequency(0);
        total++;
        user.setTotal(total);
        userMapper.updateUser(user);
    }

    @Override
    public void final2_StoreData(User user, List<ItemList> lists) {
        int total = user.getTotal();
        int uid = user.getUser_id();
        int received_id = user.getReceived_id();
        for(int i = 0;i<10;i++){
            if(i != 0){
                received_id++;
            }
            ScoreFinal2 scoreCnnTfidf = new ScoreFinal2();
            scoreCnnTfidf.setScoreId(received_id);
            scoreCnnTfidf.setSubtaskId(received_id);
            if(scoreFinal2Mapper.selectByPrimaryKey(received_id) == null){
                scoreFinal2Mapper.insert(scoreCnnTfidf);
            }else {
                scoreCnnTfidf = scoreFinal2Mapper.selectByPrimaryKey(received_id);
            }
            int frequency = user.getFrequency();
            switch (frequency){
                case 1:
                    scoreCnnTfidf.setUid1(uid);
                    scoreCnnTfidf.setScorea1(lists.get(i).getScorea());
                    scoreCnnTfidf.setScoreb1(lists.get(i).getScoreb());
                    break;
                case 2:
                    scoreCnnTfidf.setUid2(uid);
                    scoreCnnTfidf.setScorea2(lists.get(i).getScorea());
                    scoreCnnTfidf.setScoreb2(lists.get(i).getScoreb());
                    break;
                case 3:
                    scoreCnnTfidf.setUid3(uid);
                    scoreCnnTfidf.setScorea3(lists.get(i).getScorea());
                    scoreCnnTfidf.setScoreb3(lists.get(i).getScoreb());
                    break;
            }
            scoreFinal2Mapper.updateByPrimaryKey(scoreCnnTfidf);
        }
        user.setReceived_id(0);
        user.setAlgo_id(0);
        user.setFrequency(0);
        total++;
        user.setTotal(total);
        userMapper.updateUser(user);
    }

    @Override
    public void final3_StoreData(User user, List<ItemList> lists) {
        int total = user.getTotal();
        int uid = user.getUser_id();
        int received_id = user.getReceived_id();
        int frequency = user.getFrequency();
        for(int i = 0;i<10;i++){
            if(i != 0){
                received_id++;
            }
            ScoreFinal3 scoreCnnTfidf = new ScoreFinal3();
            scoreCnnTfidf.setScoreId(received_id);
            scoreCnnTfidf.setSubtaskId(received_id);
            if(scoreFinal3Mapper.selectByPrimaryKey(received_id) == null){
                scoreFinal3Mapper.insert(scoreCnnTfidf);
            }else {
                scoreCnnTfidf = scoreFinal3Mapper.selectByPrimaryKey(received_id);
            }

            switch (frequency){
                case 1:
                    scoreCnnTfidf.setUid1(uid);
                    scoreCnnTfidf.setScorea1(lists.get(i).getScorea());
                    scoreCnnTfidf.setScoreb1(lists.get(i).getScoreb());
                    break;
                case 2:
                    scoreCnnTfidf.setUid2(uid);
                    scoreCnnTfidf.setScorea2(lists.get(i).getScorea());
                    scoreCnnTfidf.setScoreb2(lists.get(i).getScoreb());
                    break;
                case 3:
                    scoreCnnTfidf.setUid3(uid);
                    scoreCnnTfidf.setScorea3(lists.get(i).getScorea());
                    scoreCnnTfidf.setScoreb3(lists.get(i).getScoreb());
                    break;
            }
            scoreFinal3Mapper.updateByPrimaryKey(scoreCnnTfidf);
        }

        user.setReceived_id(0);
        user.setAlgo_id(0);
        user.setFrequency(0);
        total++;
        user.setTotal(total);
        userMapper.updateUser(user);
    }
}
