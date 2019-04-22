package com.nju.assigntask.service.impl;

import com.nju.assigntask.dao.*;
import com.nju.assigntask.entity.*;
import com.nju.assigntask.service.DividedService;
import com.nju.assigntask.service.OrderListService;
import com.nju.assigntask.service.RecommendService;
import com.nju.assigntask.tools.HandleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    RecommendService recommendService;
    @Autowired
    DividedService dividedService;
    @Autowired
    RecommandMapper recommandMapper;
    @Autowired
    ReleasetablesMapper releasetablesMapper;
    @Autowired
    ReleaseMapper releaseMapper;

    @Autowired
    HandleData handleData;

//    @Override
//    public void insertRecord(Orderlist orderlist,String algName) {
//        if (algName.equals("lstm")){
//        orderlistMapper.insertLstmRecord(orderlist);
//        }
//        else if (algName.equals("nn")){
//            orderlistMapper.insertNnRecord(orderlist);
//        }
//        else if (algName.equals("cnn")){
//            orderlistMapper.insertCnnRecord(orderlist);
//        }
//        else if (algName.equals("tfidf")){
//            orderlistMapper.insertTfidfRecord(orderlist);
//        }
//        else if (algName.equals("doc")){
//            orderlistMapper.insertDocRecord(orderlist);
//        }
//        else if (algName.equals("index")){
//            orderlistMapper.insertIndexRecord(orderlist);
//        }
//    }

//    @Override
//    public List<Orderlist> selectByDividedIdOrderScore(int dividedid,String algName) {
//        List<Orderlist> orderlists = new ArrayList<>();
//        if (algName.equals("lstm")){
//            orderlists = orderlistMapper.selectLstmByDividedid(dividedid);
//        }
//        else if (algName.equals("nn")){
//            orderlists = orderlistMapper.selectNnByDividedid(dividedid);
//        }
//        else if (algName.equals("cnn")){
//            orderlists = orderlistMapper.selectCnnByDividedid(dividedid);
//        }
//        else if (algName.equals("tfidf")){
//            orderlists = orderlistMapper.selectTfiByDividedid(dividedid);
//        }
//        else if (algName.equals("doc")){
//            orderlists = orderlistMapper.selectDocByDividedid(dividedid);
//        }
//        else if (algName.equals("index")){
//            orderlists = orderlistMapper.selectIndexByDividedid(dividedid);
//        }
//        return orderlists;
//    }

//    @Override
//    public List<Orderlist> selectRecord(int inputid,int releaseid,String algName) {
//        List<Orderlist> orderlists = new ArrayList<>();
//        Orderlist orderlist = new Orderlist();
//        orderlist.setInputid(inputid);
//        orderlist.setReleaseid(releaseid);
//        if (algName.equals("lstm")){
//            orderlists = orderlistMapper.selectLstmRecord(orderlist);
//        }
//        else if (algName.equals("nn")){
//            orderlists = orderlistMapper.selectNnRecord(orderlist);
//        }
//        else if (algName.equals("cnn")){
//            orderlists = orderlistMapper.selectCnnRecord(orderlist);
//        }
//        else if (algName.equals("tfidf")){
//            orderlists = orderlistMapper.selectTfiRecord(orderlist);
//        }
//        else if (algName.equals("doc")){
//            orderlists = orderlistMapper.selectDocRecord(orderlist);
//        }
//        else if (algName.equals("index")){
//            orderlists = orderlistMapper.selectIndexRecord(orderlist);
//        }
//        return orderlists;
//    }

//    @Override
//    public List selectItemNames(int inputid,int releaseid, String algName) {
//        List<Orderlist> orderlists = selectRecord(inputid,releaseid,algName);
//        List<String> itemNames = new ArrayList<String>();
//        for (int i = 0;i<orderlists.size();i++){
//            itemNames.add(orderlists.get(i).getItemname());
//        }
//        return itemNames;
//    }
//
//    @Override
//    public List selectItemDes(int inputid,int releaseid, String algName) {
//        List<Orderlist> orderlists = selectRecord(inputid,releaseid,algName);
//        List<String> itemDes = new ArrayList<String>();
//        for (int i = 0;i<orderlists.size();i++){
//            itemDes.add(orderlists.get(i).getItemdes());
//        }
//        return itemDes;
//    }

//    @Override
//    public void updateById(Orderlist orderlist,String algName) {
//        if (algName.equals("lstm")){
//            orderlistMapper.updateLstmById(orderlist);
//        }
//        else if (algName.equals("nn")){
//            orderlistMapper.updateNnById(orderlist);
//        }
//        else if (algName.equals("cnn")){
//            orderlistMapper.updateCnnById(orderlist);
//        }
//        else if (algName.equals("tfidf")){
//            orderlistMapper.updateTfidfById(orderlist);
//        }
//        else if (algName.equals("doc")){
//            orderlistMapper.updateDocById(orderlist);
//        }
//        else if (algName.equals("index")){
//            orderlistMapper.updateIndexById(orderlist);
//        }
//    }

//    @Override
//    public void getOrdered(int dividedid,String algName) {
//        List<Orderlist> orderlists = selectByDividedIdOrderScore(dividedid,algName); //order by score
//        List<Integer> orderId = new ArrayList<>();
//        for (int i = 0;i<orderlists.size();i++){
//            int id = orderlists.get(i).getId();
//            orderId.add(id);
//        }
//        arraySort(orderId);//把orderid排序
//
//        for (int i = 0;i<orderlists.size();i++){
//            Orderlist orderlist = orderlists.get(i);
//            orderlist.setId(orderId.get(i));
//            updateById(orderlist,algName);
//        }
//    }
//    void arraySort(List<Integer> datas){
//        //冒泡排序
//        for (int i=0;i<datas.size();i++){
//            int changeCount = 0;
//            for (int j=0;j<datas.size()-1-i;j++){
//                if (datas.get(j)>datas.get(j+1)){
//                    int temp = datas.get(j);
//                    datas.set(j,datas.get(j+1));
//                    datas.set(j+1,temp);
//                    changeCount++;
//                }
//            }
//            if (changeCount == 0) break;
//        }
//    }

    @Override
    public boolean dealData(Release release) {
        //从subtask获取score平均值，order by score返回，A1 score 可能是score1也可能是score2
        List<Integer> nullOrderedIds = dividedMapper.selectNullOrdered(release.getReleaseid());//orderde=null的dividedid
        //itemName从lstmrecommand表获取，给原始数据表加上
        int count = 0;
        for (int i = 0; i < nullOrderedIds.size(); i++) {
            //进入divided表的一行记录
            int dividedid = nullOrderedIds.get(i);
            Divided divided = dividedMapper.selectByPrimaryKey(dividedid);
            List<Double> score1 = subtaskMapper.selectScore1ByDividedid(dividedid);
            List<Double> score2 = subtaskMapper.selectScore2ByDividedid(dividedid);
            boolean handleScore1 = handleData.judgeIfHandle(score1);
            boolean handleScore2 = handleData.judgeIfHandle(score2);
            if (handleScore1 == true && handleScore2 == true) {
                //若subtask表的score已经充分，则开始处理
                String algName = divided.getAlgname1();
                String tablename = releasetablesMapper.findRecoTab(divided.getReleaseid(), algName);
                List<Recommend> recommendList = recommandMapper.selectByInputid(tablename, divided.getInputid());

                for (int z = 0; z < recommendList.size(); z++) {
                    //有10个itemNames
                    String itemName = recommendList.get(z).getItemname();
                    String itemDes = recommendList.get(z).getItemdes();
                    Subtask subtask = new Subtask();
                    subtask.setDividedid(dividedid);
                    subtask.setItemname1(itemName);
                    subtask.setItemname2(itemName);
                    List<Double> sumscore1 = subtaskMapper.selectItem1Score(subtask);
                    List<Double> sumscore2 = subtaskMapper.selectItem2Score(subtask);

                    double avescore = aveScore(sumscore1, sumscore2); //每个item的得分

                    Orderlist orderlist = new Orderlist();
                    orderlist.setDividedid(dividedid);
                    orderlist.setReleaseid(divided.getReleaseid());
                    orderlist.setInputid(recommendList.get(z).getInputid());
                    orderlist.setItemname(itemName);
                    orderlist.setItemdes(itemDes);
                    orderlist.setAlgname(algName);
                    orderlist.setScore(avescore);
//                insertRecord(orderlist, algName);//先无序插入
                    orderlistMapper.insertRecord(orderlist);//先无序插入
                }
                //               getOrdered(dividedid, algName);//排序
                dividedService.updateOrdered(dividedid, "yes"); //更新divided表的ordered字段
            }
            count++;
        }
        if (count == nullOrderedIds.size()){
            //说明全部有序
        //    releaseMapper.updateStatus(release.getReleaseid(),"内部排序已完成");
            return  true;
        }else {
            return false;
        }
    }

    @Override
    public double aveScore(List<Double> score1,List<Double> score2){
        double avescore = 0;
        double sumscore1 = 0;
        double sumscore2 = 0;
        for (int i=0;i<score1.size();i++){
            sumscore1 = sumscore1 + score1.get(i);
        }
        for (int i=0;i<score2.size();i++){
            sumscore2 = sumscore2 +score2.get(i);
        }
        if (score1.size() != 0 && score2.size() != 0){
            avescore =  (sumscore1+sumscore2)/(score1.size()+score2.size());
        }else if (score1.size() == 0) {
            avescore = sumscore2/score2.size();
        }else if (sumscore2 == 0){
            avescore = sumscore1/score1.size();
        }
        return avescore;
    }

}
