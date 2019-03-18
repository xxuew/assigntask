package com.wx.assigntask.service.impl;

import com.wx.assigntask.comment.ItemList;
import com.wx.assigntask.dao.AlgresultMapper;
import com.wx.assigntask.dao.UserMapper;
import com.wx.assigntask.entity.Algresult;
import com.wx.assigntask.entity.User;
import com.wx.assigntask.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements ITaskService {
    @Autowired
    IAHPService ahpService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    IMutualService iMutualService;
    @Autowired
    IHorizonService iHorizonService;
    @Autowired
    ISecondPartService secondPartService;
    @Autowired
    AlgresultMapper algresultMapper;
    @Override
    public List<ItemList> assignTask(int id, User user) {
        List<ItemList> lists = new ArrayList<>();
        User currentuser = userMapper.findUserByUserName(user.getUsername());
        switch (id){
            case 1:
                System.out.println("任务1");
                lists = iMutualService.cnn_tfidf_assignTask(currentuser);
                break;
            case 2:
                System.out.println("任务2");
                lists = iMutualService.doc_index_assignTask(currentuser);
                break;
            case 3:
                System.out.println("任务3");
                lists = iMutualService.lstm_nn_assignTask(currentuser);
                break;
            case 4:
                System.out.println("任务4");
                String result11 = algresultMapper.selectByPrimaryKey(1).getWinAlgname();
                String result12 = algresultMapper.selectByPrimaryKey(2).getWinAlgname();
                System.out.println(result11 == "cnn");
                System.out.println(result11.equals("cnn"));
                if (result11.equals("cnn")&&result12.equals("doc")){
                    lists = secondPartService.cnn_doc_assignTask(currentuser,4);
                }else if (result11.equals("cnn")&&result12.equals("index")){
                    lists = secondPartService.cnn_index_assignTask(currentuser,4);
                }else if (result11.equals("tfidf")&&result12.equals("doc")){
                    lists = secondPartService.tfidf_doc_assignTask(currentuser,4);
                }else if (result11.equals("tfidf")&&result12.equals("index")){
                    lists = secondPartService.tfidf_index_assignTask(currentuser,4);
                }
                break;
            case 5:
                System.out.println("任务5");
                String result21 = algresultMapper.selectByPrimaryKey(1).getWinAlgname();
                String result22 = algresultMapper.selectByPrimaryKey(3).getWinAlgname();
                if (result21.equals("cnn")&&result22.equals("lstm")){
                    lists = secondPartService.cnn_lstm_assignTask(currentuser,5);
                }else if (result21.equals("cnn")&&result22.equals("nn")){
                    lists = secondPartService.cnn_nn_assignTask(currentuser,5);
                }else if (result21.equals("tfidf")&&result22.equals("lstm")){
                    lists = secondPartService.tfidf_lstm_assignTask(currentuser,5);
                }else if (result21.equals("tfidf")&&result22.equals("nn")){
                    lists = secondPartService.tfidf_nn_assignTask(currentuser,5);
                }
                break;
            case 6:
                System.out.println("任务6");
                String result31 = algresultMapper.selectByPrimaryKey(2).getWinAlgname();
                String result32 = algresultMapper.selectByPrimaryKey(3).getWinAlgname();
                if (result31.equals("doc")&&result32.equals("lstm")){
                    lists = secondPartService.doc_lstm_assignTask(currentuser,6);
                }else if (result31.equals("doc")&&result32.equals("nn")){
                    lists = secondPartService.doc_nn_assignTask(currentuser,6);
                }else if (result31.equals("index")&&result32.equals("lstm")){
                    lists = secondPartService.index_lstm_assignTask(currentuser,6);
                }else if (result31.equals("index")&&result32.equals("nn")){
                    lists = secondPartService.index_nn_assignTask(currentuser,6);
                }
                break;
        }
        return lists;
    }

    @Override
    public void StoreData(int id, User user, List<ItemList> lists) {
        User currentuser = userMapper.findUserByUserName(user.getUsername());
        System.out.println("-----存储了-------"+id);
        switch (id){
            case 1:
                System.out.println("任务1");
                iMutualService.cnn_tfidf_StoreData(currentuser,lists);
                break;
            case 2:
                System.out.println("任务2");
                iMutualService.doc_index_StoreData(currentuser,lists);
                break;
            case 3:
                System.out.println("任务3");
                iMutualService.lstm_nn_StoreData(currentuser,lists);
                break;
            case 4:
                System.out.println("任务4");
                secondPartService.final1_StoreData(currentuser,lists);
                break;
            case 5:
                System.out.println("任务5");
                secondPartService.final2_StoreData(currentuser,lists);
                break;
            case 6:
                System.out.println("任务6");
                secondPartService.final3_StoreData(currentuser,lists);
                break;
        }
    }
}
