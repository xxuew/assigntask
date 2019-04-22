package com.nju.assigntask.tools;

import com.nju.assigntask.dao.RecommandMapper;
import com.nju.assigntask.dao.OrderlistMapper;
import com.nju.assigntask.dao.ReleasetablesMapper;
import com.nju.assigntask.dao.SubtaskMapper;
import com.nju.assigntask.entity.Inputs;
import com.nju.assigntask.entity.Orderlist;
import com.nju.assigntask.entity.Recommend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:wx
 * @Date:Created in 15:16 2019/4/6
 * @Modified by:
 */
@Component
public class GenSubtaskCps {

    @Autowired
    ReleasetablesMapper releasetablesMapper;
    @Autowired
    RecommandMapper recommandMapper;
    @Autowired
    SubtaskMapper subtaskMapper;
    @Autowired
    OrderlistMapper orderlistMapper;

    /**
     * 充分对比剪枝的两两算法对比
     * @return
     */
    public void compareComplete(int dividedid, int releaseid, Inputs inputs,String algName1, String algName2){
        String tableName1 = releasetablesMapper.findRecoTab(releaseid,algName1); //查找该算法对应的数据源表名
        String tableName2 = releasetablesMapper.findRecoTab(releaseid,algName2);

        List<Recommend> recoList1 = recommandMapper.selectByInputid(tableName1,inputs.getInputid()); //算法对应的所有推荐结果
        List<Recommend> recoList2 = recommandMapper.selectByInputid(tableName2,inputs.getInputid());
//        int subtaskCount = 0;
        if (recoList1.size() == recoList2.size()){
            for (int i = 0; i < recoList1.size(); i++) {
                //A1对B1-B10，A1不变，B变
                for (int z = 0; z < recoList2.size(); z++) {
                    String itemName1 = recoList1.get(i).getItemname();
                    String itemName2 = recoList2.get(z).getItemname();
                    String itemDes1 = recoList1.get(i).getItemdes();
                    String itemDes2 = recoList2.get(z).getItemdes();
                    //插入subtask
                    subtaskMapper.insertSubtask( dividedid,itemName1,itemDes1,itemName2,itemDes2);
            //        int subtaskid = subtaskMapper.inserSubtask( subtask);
           //         subtaskids.add(subtaskid);
           //         subtaskCount++;
                }
            }
        }
   //     return subtaskCount;
    }

    /**
     * 同层对比剪枝的两两算法对比
     * @return
     */
    public void sameLayerAlg(int dividedid,int releaseid,String algName1,String algName2,int inputid){
//        List<Orderlist> orderlist1 = new ArrayList<>();
//        try{
//            orderlist1 = orderlistMapper.selectOrderedReco(releaseid,inputid,algName1);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        List<Orderlist> orderlist1 = orderlistMapper.selectOrderedReco(releaseid,inputid,algName1);
        List<Orderlist> orderlist2 = orderlistMapper.selectOrderedReco(releaseid,inputid,algName2);
   //     int subtaskCount = 0;
        if (orderlist1.size() == orderlist2.size()) {

            for (int i = 0; i < orderlist1.size(); i++) {
                String itemName1 = orderlist1.get(i).getItemname();
                String itemName2 = orderlist2.get(i).getItemname();
                String itemDes1 = orderlist1.get(i).getItemdes();
                String itemDes2 = orderlist2.get(i).getItemdes();
                //插入subtask
                subtaskMapper.insertSubtask(dividedid, itemName1, itemDes1, itemName2, itemDes2);
//            int subtaskid = insertSubTask(plan,algName1,algName2,dividedId, itemName1, itemDes1, itemName2, itemDes2);
//            subtaskids.add(subtaskid);
//            subtaskCount++;
            }
        }

    }

    /**
     * 内部排序
     * @param algName
     * @param releaseid
     * @param dividedid
     * @param input
     */
    public void intraGroup( String algName,int releaseid,int dividedid,Inputs input) {
//        System.out.println("生成算法内排序子任务 :"+Class.class.getName());
        //从recommend表获取itemNames和itemDes
        String tableName = releasetablesMapper.findRecoTab(releaseid,algName); //查找该算法对应的数据源表名

        List<Recommend> recoList = recommandMapper.selectByInputid(tableName,input.getInputid()); //算法对应的所有推荐结果try{

        int subtaskCount = 0; //subtask个数
        //算法内部排序
        for (int j = 0; j < recoList.size(); j++) {
            //A1对A2-A10
            String itemName1 = recoList.get(j).getItemname();
            String itemDes1 = recoList.get(j).getItemdes();

            for (int z = j+1; z < recoList.size(); z++) {
                String itemName2 = recoList.get(z).getItemname();
                String itemDes2 = recoList.get(z).getItemdes();
                //插入subtask
                subtaskMapper.insertSubtask(dividedid,itemName1,itemDes1, itemName2,itemDes2);
//                int subtaskid = subtaskMapper.insertSubtask(dividedId,itemName1,itemDes1, itemName2,itemDes2);
//                subtaskids.add(subtaskid);
//                subtaskCount++;
            }
        }
   //     return subtaskCount;
    }

    public void ahpCompareCps(int dividedid,int releaseid,List algs,Inputs input){
        Map<String,List> map = new HashMap<>(); //k:algname,orderlist
        for (int i=0;i<algs.size();i++){
            String algname = algs.get(i).toString();
            List<Orderlist> orderlists = orderlistMapper.selectOrderedReco(releaseid,input.getInputid(),algname);
            map.put(algname,orderlists);
        }


    }
}
