package com.wx.assigntask.service.impl;

import com.wx.assigntask.dao.DividedMapper;
import com.wx.assigntask.dao.OrderlistMapper;
import com.wx.assigntask.dao.SubtaskMapper;
import com.wx.assigntask.entity.Divided;
import com.wx.assigntask.entity.Orderlist;
import com.wx.assigntask.entity.Recommand;
import com.wx.assigntask.entity.Subtask;
import com.wx.assigntask.service.DividedService;
import com.wx.assigntask.service.OrderListService;
import com.wx.assigntask.service.RecommandService;
import com.wx.assigntask.service.SubTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: wx
 * @Date: 2019/1/2 11:27
 * @Version 1.0
 */
@Service
public class OrderListServiceImpl implements OrderListService {

    @Autowired
    DividedMapper dividedMapper;
    @Autowired
    OrderlistMapper orderlistMapper;
    @Autowired
    SubtaskMapper subtaskMapper;
    @Autowired
    RecommandService recommandService;
    @Autowired
    DividedService dividedService;

    @Override
    public void insertRecord(Orderlist orderlist,String algName) {
        if (algName.equals("lstm")){
        orderlistMapper.insertLstmRecord(orderlist);
        }
        else if (algName.equals("nn")){
            orderlistMapper.insertNnRecord(orderlist);
        }
        else if (algName.equals("cnn")){
            orderlistMapper.insertCnnRecord(orderlist);
        }
        else if (algName.equals("tfidf")){
            orderlistMapper.insertTfidfRecord(orderlist);
        }
        else if (algName.equals("doc")){
            orderlistMapper.insertDocRecord(orderlist);
        }
        else if (algName.equals("index")){
            orderlistMapper.insertIndexRecord(orderlist);
        }
    }

    @Override
    public List<Orderlist> selectByDividedIdOrderScore(int dividedid,String algName) {
        List<Orderlist> orderlists = new ArrayList<>();
        if (algName.equals("lstm")){
            orderlists = orderlistMapper.selectLstmByDividedid(dividedid);
        }
        else if (algName.equals("nn")){
            orderlists = orderlistMapper.selectNnByDividedid(dividedid);
        }
        else if (algName.equals("cnn")){
            orderlists = orderlistMapper.selectCnnByDividedid(dividedid);
        }
        else if (algName.equals("tfidf")){
            orderlists = orderlistMapper.selectTfiByDividedid(dividedid);
        }
        else if (algName.equals("doc")){
            orderlists = orderlistMapper.selectDocByDividedid(dividedid);
        }
        else if (algName.equals("index")){
            orderlists = orderlistMapper.selectIndexByDividedid(dividedid);
        }
        return orderlists;
    }

    @Override
    public List<Orderlist> selectRecord(int inputid,int releaseid,String algName) {
        List<Orderlist> orderlists = new ArrayList<>();
        Orderlist orderlist = new Orderlist();
        orderlist.setInputid(inputid);
        orderlist.setReleaseid(releaseid);
        if (algName.equals("lstm")){
            orderlists = orderlistMapper.selectLstmRecord(orderlist);
        }
        else if (algName.equals("nn")){
            orderlists = orderlistMapper.selectNnRecord(orderlist);
        }
        else if (algName.equals("cnn")){
            orderlists = orderlistMapper.selectCnnRecord(orderlist);
        }
        else if (algName.equals("tfidf")){
            orderlists = orderlistMapper.selectTfiRecord(orderlist);
        }
        else if (algName.equals("doc")){
            orderlists = orderlistMapper.selectDocRecord(orderlist);
        }
        else if (algName.equals("index")){
            orderlists = orderlistMapper.selectIndexRecord(orderlist);
        }
        return orderlists;
    }

    @Override
    public List selectItemNames(int inputid,int releaseid, String algName) {
        List<Orderlist> orderlists = selectRecord(inputid,releaseid,algName);
        List<String> itemNames = new ArrayList<String>();
        for (int i = 0;i<orderlists.size();i++){
            itemNames.add(orderlists.get(i).getItemname());
        }
        return itemNames;
    }

    @Override
    public List selectItemDes(int inputid,int releaseid, String algName) {
        List<Orderlist> orderlists = selectRecord(inputid,releaseid,algName);
        List<String> itemDes = new ArrayList<String>();
        for (int i = 0;i<orderlists.size();i++){
            itemDes.add(orderlists.get(i).getItemdes());
        }
        return itemDes;
    }

    @Override
    public void updateById(Orderlist orderlist,String algName) {
        if (algName.equals("lstm")){
            orderlistMapper.updateLstmById(orderlist);
        }
        else if (algName.equals("nn")){
            orderlistMapper.updateNnById(orderlist);
        }
        else if (algName.equals("cnn")){
            orderlistMapper.updateCnnById(orderlist);
        }
        else if (algName.equals("tfidf")){
            orderlistMapper.updateTfidfById(orderlist);
        }
        else if (algName.equals("doc")){
            orderlistMapper.updateDocById(orderlist);
        }
        else if (algName.equals("index")){
            orderlistMapper.updateIndexById(orderlist);
        }
    }

    @Override
    public void getOrdered(int dividedid,String algName) {
        List<Orderlist> orderlists = selectByDividedIdOrderScore(dividedid,algName); //order by score
        List<Integer> orderId = new ArrayList<>();
        for (int i = 0;i<orderlists.size();i++){
            int id = orderlists.get(i).getId();
            orderId.add(id);
        }
        arraySort(orderId);//把orderid排序

        for (int i = 0;i<orderlists.size();i++){
            Orderlist orderlist = orderlists.get(i);
            orderlist.setId(orderId.get(i));
            updateById(orderlist,algName);
        }
    }
    void arraySort(List<Integer> datas){
        //冒泡排序
        for (int i=0;i<datas.size();i++){
            int changeCount = 0;
            for (int j=0;j<datas.size()-1-i;j++){
                if (datas.get(j)>datas.get(j+1)){
                    int temp = datas.get(j);
                    datas.set(j,datas.get(j+1));
                    datas.set(j+1,temp);
                    changeCount++;
                }
            }
            if (changeCount == 0) break;
        }
    }

    @Override
    public void dealData() {
        //从subtask获取score平均值，order by score返回，A1 score 可能是score1也可能是score2
        List<Integer> nullOrderedIds=dividedMapper.selectNullOrdered();//orderde=null的dividedid
        //itemName从lstmrecommand表获取，给原始数据表加上
        for (int i = 0; i<nullOrderedIds.size();i++){
            //进入divided表的一行记录
            int dividedid = nullOrderedIds.get(i);
            Divided divided = dividedMapper.selectByPrimaryKey(dividedid);
            String algName = divided.getAlgname1();
            List itemNames = recommandService.selectAllItemsNames(divided.getInputid(), algName);
            List itemDess = recommandService.selectAllItemDes(divided.getInputid(), algName);
            for (int z = 2; z < itemNames.size(); z++) {
                //有10个itemNames
                String itemName = itemNames.get(z).toString();
                String itemDes = itemDess.get(z).toString();
                Subtask subtask = new Subtask();
                subtask.setDividedid(dividedid);
                subtask.setItemname1(itemName);
                subtask.setItemname2(itemName);
                int sumscore1 = subtaskMapper.selectItem1SumScore(subtask);
                int sumscore2 = subtaskMapper.selectItem2SumScore(subtask);
                float avescore = aveScore(sumscore1, sumscore2);

                Orderlist orderlist = new Orderlist();
                orderlist.setDividedid(dividedid);
                orderlist.setReleaseid(divided.getReleaseid());
                orderlist.setInputid(Integer.parseInt(itemNames.get(0).toString()));
                orderlist.setItemname(itemName);
                orderlist.setItemdes(itemDes);
                orderlist.setAlgname(algName);
                orderlist.setScore(avescore);
                insertRecord(orderlist, algName);//先无序插入
            }
            getOrdered(dividedid, algName);//排序
            dividedService.updateOrdered(dividedid,"yes");
        }
    }

    @Override
    public float aveScore(int sumscore1,int sumscore2){
        float avescore = 0;
        if (sumscore1 != 0 && sumscore2 != 0){
            avescore = (float) (sumscore1+sumscore2)/9;
        }else if (sumscore1 == 0) {
            avescore = sumscore2;
        }else if (sumscore2 == 0){
            avescore = sumscore1;
        }
        return avescore;
    }

}
