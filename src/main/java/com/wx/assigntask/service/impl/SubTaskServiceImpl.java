package com.wx.assigntask.service.impl;


import com.wx.assigntask.comment.ItemList;
import com.wx.assigntask.entity.OriginalData;
import com.wx.assigntask.entity.Subtask;
import com.wx.assigntask.service.OriginalDataService;
import com.wx.assigntask.service.SubTaskService;
import com.wx.assigntask.subtask.BuildTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/9 21:44
 * @Version 1.0
 */
@Service
public class SubTaskServiceImpl implements SubTaskService {
    OriginalDataService originalDataService;

    @Override
    public Subtask findSubBySubId(int id) {
        return null;
    }

    @Override
    public List<ItemList> insertSubTask(List<OriginalData> originalData) {
        String s;
        BuildTask buildTask = new BuildTask();
        String[] s1 = new String[42];
        OriginalData o;
        ItemList ll;
        List<ItemList> list = new ArrayList();
        for(int i = 0;i<100;i++){
            o = originalData.get(i);
            s1 = buildTask.OdataToArray(o);
//            for (String a:s1) {
//                System.out.println(a);
//            }
            for(int n = 0;n<10;n++) {
                for(int m = 0;m<10;m++) {
                    ll = new ItemList();
                    ll.setInputname(s1[0]);
                    ll.setInputdes(s1[1]);
                    ll.setItema(s1[(2*n+2)]);
                    ll.setDesa(s1[(2*n+3)]);
                    ll.setItemb(s1[(2*m+22)]);
                    ll.setDesb(s1[(2*m+23)]);
                    list.add(ll);
                }
            }

        }

        for (ItemList itemList:list){
            System.out.println(itemList.itema);
            System.out.println(itemList.itemb);
        }

        System.out.println("------------------------------------------");
//        for (OriginalData o: originalData) {
//            System.out.println(o.getName()+" "+o.getDes());
//        }
        return list;
    }

    @Override
    public Subtask selectByPrimaryKey(int id) {
        return null;
    }
}
