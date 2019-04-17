package com.wx.assigntask.tools;

import com.wx.assigntask.dao.OrderlistMapper;
import com.wx.assigntask.dao.RecommandMapper;
import com.wx.assigntask.dao.ReleasetablesMapper;
import com.wx.assigntask.dao.SubtaskMapper;
import com.wx.assigntask.entity.Orderlist;
import com.wx.assigntask.entity.Recommend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
    public int compareComplete(int dividedid,int releaseid,String algName1,String algName2,List<Integer> subtaskids){
        String tableName1 = releasetablesMapper.findRecoTab(releaseid,algName1); //查找该算法对应的数据源表名
        String tableName2 = releasetablesMapper.findRecoTab(releaseid,algName2);
        List<Recommend> recoList1 = recommandMapper.selectAll(tableName1); //算法对应的所有推荐结果
        List<Recommend> recoList2 = recommandMapper.selectAll(tableName2);
        int subtaskCount = 0;
        if (recoList1.size() == recoList2.size()){
            for (int i = 0; i < recoList1.size(); i++) {
                //A1对B1-B10，A1不变，B变
                for (int z = 2; z < recoList2.size(); z++) {
                    String itemName1 = recoList1.get(i).getItemname();
                    String itemName2 = recoList2.get(z).getItemname();
                    String itemDes1 = recoList1.get(i).getItemdes();
                    String itemDes2 = recoList2.get(z).getItemdes();
                    //插入subtask
                    int subtaskid = subtaskMapper.inserSubtask( dividedid, itemName1, itemDes1, itemName2, itemDes2);
                    subtaskids.add(subtaskid);
                    subtaskCount++;
                }
            }
        }
        return subtaskCount;
    }

    /**
     * 同层对比剪枝的两两算法对比
     * @return
     */
    public int sameLayerAlg(int dividedid,int releaseid,String algName1,String algName2,List<Integer> subtaskids,int inputid){
        List<Orderlist> orderlist1 = orderlistMapper.selectOrderedReco(releaseid,inputid,algName1);
        List<Orderlist> orderlist2 = orderlistMapper.selectOrderedReco(releaseid,inputid,algName2);
        int subtaskCount = 0;
        if (orderlist1.size() == orderlist2.size()){
            for (int i = 0; i < orderlist1.size(); i++) {
                //A1对B1-B10，A1不变，B变
                for (int z = 2; z < orderlist2.size(); z++) {
                    String itemName1 = orderlist1.get(i).getItemname();
                    String itemName2 = orderlist2.get(z).getItemname();
                    String itemDes1 = orderlist1.get(i).getItemdes();
                    String itemDes2 = orderlist2.get(z).getItemdes();
                    //插入subtask
                    int subtaskid = subtaskMapper.inserSubtask( dividedid, itemName1, itemDes1, itemName2, itemDes2);
                    subtaskids.add(subtaskid);
                    subtaskCount++;
                }
            }
        }
        return subtaskCount;
    }
}
