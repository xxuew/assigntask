package com.wx.assigntask.service.impl;


import com.wx.assigntask.comment.ItemList;
import com.wx.assigntask.dao.*;
import com.wx.assigntask.entity.*;
import com.wx.assigntask.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/4 19:01
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    SubtaskAhpMapper ahpSubtaskMapper;
    @Autowired
    SubtaskHorizonMapper subtaskMapper;
    @Autowired
    SubtaskCnnTfidfMapper subtaskCnnTfidfMapper;
    @Autowired
    SubtaskDocIndexMapper subtaskDocIndexMapper;
    @Autowired
    SubtaskLstmNnMapper subtaskLstmNnMapper;
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
    AlgresultMapper algresultMapper;

    @Override
    public int addUser(User user) {
        user.setReceived_id(0);
        user.setAlgo_id(0);
        user.setTotal(0);
        return userMapper.insert(user);
    }

    @Override
    public List<ItemList> checkUser(User user) {
        List<ItemList> list = new ArrayList<>();
        User currentuser = userMapper.findUserByUserName(user.getUsername());
        int id = currentuser.getAlgo_id();
        int received_id = currentuser.getReceived_id();
        switch (id){
            case 1:
                System.out.println("任务1被分配过了");
                for(int i = 0;i<10;i++){
                    if(i!=0){
                        received_id++;
                    }
                    ItemList itemList = new ItemList();
                    SubtaskCnnTfidf subtaskCnnTfidf = subtaskCnnTfidfMapper.selectByPrimaryKey(received_id);
                    itemList.setId(subtaskCnnTfidf.getSubtaskId());
                    itemList.setInputname(subtaskCnnTfidf.getInputName());
                    itemList.setInputdes(subtaskCnnTfidf.getInputDes());
                    itemList.setItema(subtaskCnnTfidf.getItemName1());
                    itemList.setDesa(subtaskCnnTfidf.getItemDes1());
                    itemList.setItemb(subtaskCnnTfidf.getItemName2());
                    itemList.setDesb(subtaskCnnTfidf.getItemDes2());
                    list.add(itemList);
                }
                break;
            case 2:
                System.out.println("任务2被分配过了");
                for(int i = 0;i<10;i++){
                    if(i!=0){
                        received_id++;
                    }
                    ItemList itemList = new ItemList();
                    SubtaskDocIndex subtaskDocIndex = subtaskDocIndexMapper.selectByPrimaryKey(received_id);
                    itemList.setId(subtaskDocIndex.getSubtaskId());
                    itemList.setInputname(subtaskDocIndex.getInputName());
                    itemList.setInputdes(subtaskDocIndex.getInputDes());
                    itemList.setItema(subtaskDocIndex.getItemName1());
                    itemList.setDesa(subtaskDocIndex.getItemDes1());
                    itemList.setItemb(subtaskDocIndex.getItemName2());
                    itemList.setDesb(subtaskDocIndex.getItemDes2());
                    list.add(itemList);
                }
                break;
            case 3:
                System.out.println("任务3被分配过了");
                for(int i = 0;i<10;i++){
                    if(i!=0){
                        received_id++;
                    }
                    ItemList itemList = new ItemList();
                    SubtaskLstmNn subtaskLstmNn = subtaskLstmNnMapper.selectByPrimaryKey(received_id);
                    itemList.setId(subtaskLstmNn.getSubtaskId());
                    itemList.setInputname(subtaskLstmNn.getInputName());
                    itemList.setInputdes(subtaskLstmNn.getInputDes());
                    itemList.setItema(subtaskLstmNn.getItemName1());
                    itemList.setDesa(subtaskLstmNn.getItemDes1());
                    itemList.setItemb(subtaskLstmNn.getItemName2());
                    itemList.setDesb(subtaskLstmNn.getItemDes2());
                    list.add(itemList);
                }
                break;
            case 4:
                System.out.println("任务4被分配过了");
                for(int i = 0;i<10;i++){
                    if(i!=0){
                        received_id++;
                    }
                    ItemList itemList = new ItemList();
                    String result11 = algresultMapper.selectByPrimaryKey(1).getWinAlgname();
                    String result12 = algresultMapper.selectByPrimaryKey(2).getWinAlgname();
                    if (result11.equals("cnn")&&result12.equals("doc")){
                        SubtaskCnnDoc subtask = subtaskCnnDocMapper.selectByPrimaryKey(received_id);
                        itemList.setId(subtask.getSubtaskId());
                        itemList.setInputname(subtask.getInputName());
                        itemList.setInputdes(subtask.getInputDes());
                        itemList.setItema(subtask.getItemName1());
                        itemList.setDesa(subtask.getItemDes1());
                        itemList.setItemb(subtask.getItemName2());
                        itemList.setDesb(subtask.getItemDes2());
                    }else if (result11.equals("cnn")&&result12.equals("index")){
                        SubtaskCnnIndex subtask = subtaskCnnIndexMapper.selectByPrimaryKey(received_id);
                        itemList.setId(subtask.getSubtaskId());
                        itemList.setInputname(subtask.getInputName());
                        itemList.setInputdes(subtask.getInputDes());
                        itemList.setItema(subtask.getItemName1());
                        itemList.setDesa(subtask.getItemDes1());
                        itemList.setItemb(subtask.getItemName2());
                        itemList.setDesb(subtask.getItemDes2());
                    }else if (result11.equals("tfidf")&&result12.equals("doc")){
                        SubtaskTfidfDoc subtask = subtaskTfidfDocMapper.selectByPrimaryKey(received_id);
                        itemList.setId(subtask.getSubtaskId());
                        itemList.setInputname(subtask.getInputName());
                        itemList.setInputdes(subtask.getInputDes());
                        itemList.setItema(subtask.getItemName1());
                        itemList.setDesa(subtask.getItemDes1());
                        itemList.setItemb(subtask.getItemName2());
                        itemList.setDesb(subtask.getItemDes2());
                    }else if (result11.equals("tfidf")&&result12.equals("index")){
                        SubtaskTfidfIndex subtask = subtaskTfidfIndexMapper.selectByPrimaryKey(received_id);
                        itemList.setId(subtask.getSubtaskId());
                        itemList.setInputname(subtask.getInputName());
                        itemList.setInputdes(subtask.getInputDes());
                        itemList.setItema(subtask.getItemName1());
                        itemList.setDesa(subtask.getItemDes1());
                        itemList.setItemb(subtask.getItemName2());
                        itemList.setDesb(subtask.getItemDes2());
                    }
                    list.add(itemList);
                }
                break;
            case 5:
                System.out.println("任务5被分配过了");
                for(int i = 0;i<10;i++){
                    if(i!=0){
                        received_id++;
                    }
                    String result21 = algresultMapper.selectByPrimaryKey(1).getWinAlgname();
                    String result22 = algresultMapper.selectByPrimaryKey(3).getWinAlgname();
                    ItemList itemList = new ItemList();
                    if (result21.equals("cnn")&&result22.equals("lstm")){
                        SubtaskCnnLstm subtask = subtaskCnnLstmMapper.selectByPrimaryKey(received_id);
                        itemList.setId(subtask.getSubtaskId());
                        itemList.setInputname(subtask.getInputName());
                        itemList.setInputdes(subtask.getInputDes());
                        itemList.setItema(subtask.getItemName1());
                        itemList.setDesa(subtask.getItemDes1());
                        itemList.setItemb(subtask.getItemName2());
                        itemList.setDesb(subtask.getItemDes2());
                    }else if (result21.equals("cnn")&&result22.equals("nn")){
                        SubtaskCnnNn subtask = subtaskCnnNnMapper.selectByPrimaryKey(received_id);
                        itemList.setId(subtask.getSubtaskId());
                        itemList.setInputname(subtask.getInputName());
                        itemList.setInputdes(subtask.getInputDes());
                        itemList.setItema(subtask.getItemName1());
                        itemList.setDesa(subtask.getItemDes1());
                        itemList.setItemb(subtask.getItemName2());
                        itemList.setDesb(subtask.getItemDes2());
                    }else if (result21.equals("tfidf")&&result22.equals("lstm")){
                        SubtaskTfidfLstm subtask = subtaskTfidfLstmMapper.selectByPrimaryKey(received_id);
                        itemList.setId(subtask.getSubtaskId());
                        itemList.setInputname(subtask.getInputName());
                        itemList.setInputdes(subtask.getInputDes());
                        itemList.setItema(subtask.getItemName1());
                        itemList.setDesa(subtask.getItemDes1());
                        itemList.setItemb(subtask.getItemName2());
                        itemList.setDesb(subtask.getItemDes2());
                    }else if (result21.equals("tfidf")&&result22.equals("nn")){
                        SubtaskTfidfNn subtask = subtaskTfidfNnMapper.selectByPrimaryKey(received_id);
                        itemList.setId(subtask.getSubtaskId());
                        itemList.setInputname(subtask.getInputName());
                        itemList.setInputdes(subtask.getInputDes());
                        itemList.setItema(subtask.getItemName1());
                        itemList.setDesa(subtask.getItemDes1());
                        itemList.setItemb(subtask.getItemName2());
                        itemList.setDesb(subtask.getItemDes2());
                    }
                    list.add(itemList);
                }
                break;
            case 6:
                System.out.println("任务6");
                for(int i = 0;i<10;i++){
                    if(i!=0){
                        received_id++;
                    }
                    ItemList itemList = new ItemList();
                    String result31 = algresultMapper.selectByPrimaryKey(2).getWinAlgname();
                    String result32 = algresultMapper.selectByPrimaryKey(3).getWinAlgname();
                    if (result31.equals("doc")&&result32.equals("lstm")){
                        SubtaskDocLstm subtask = subtaskDocLstmMapper.selectByPrimaryKey(received_id);
                        itemList.setId(subtask.getSubtaskId());
                        itemList.setInputname(subtask.getInputName());
                        itemList.setInputdes(subtask.getInputDes());
                        itemList.setItema(subtask.getItemName1());
                        itemList.setDesa(subtask.getItemDes1());
                        itemList.setItemb(subtask.getItemName2());
                        itemList.setDesb(subtask.getItemDes2());
                    }else if (result31.equals("doc")&&result32.equals("nn")){
                        SubtaskDocNn subtask = subtaskDocNnMapper.selectByPrimaryKey(received_id);
                        itemList.setId(subtask.getSubtaskId());
                        itemList.setInputname(subtask.getInputName());
                        itemList.setInputdes(subtask.getInputDes());
                        itemList.setItema(subtask.getItemName1());
                        itemList.setDesa(subtask.getItemDes1());
                        itemList.setItemb(subtask.getItemName2());
                        itemList.setDesb(subtask.getItemDes2());
                    }else if (result31.equals("index")&&result32.equals("lstm")){
                        SubtaskIndexLstm subtask = subtaskIndexLstmMapper.selectByPrimaryKey(received_id);
                        itemList.setId(subtask.getSubtaskId());
                        itemList.setInputname(subtask.getInputName());
                        itemList.setInputdes(subtask.getInputDes());
                        itemList.setItema(subtask.getItemName1());
                        itemList.setDesa(subtask.getItemDes1());
                        itemList.setItemb(subtask.getItemName2());
                        itemList.setDesb(subtask.getItemDes2());
                    }else if (result31.equals("index")&&result32.equals("nn")){
                        SubtaskIndexNn subtask = subtaskIndexNnMapper.selectByPrimaryKey(received_id);
                        itemList.setId(subtask.getSubtaskId());
                        itemList.setInputname(subtask.getInputName());
                        itemList.setInputdes(subtask.getInputDes());
                        itemList.setItema(subtask.getItemName1());
                        itemList.setDesa(subtask.getItemDes1());
                        itemList.setItemb(subtask.getItemName2());
                        itemList.setDesb(subtask.getItemDes2());
                    }

                    list.add(itemList);
                }
                break;
        }
        return list;
    }

    @Override
    public User findUserByUserName(String username) {
        User user = userMapper.findUserByUserName(username);
        return user;
    }



}
