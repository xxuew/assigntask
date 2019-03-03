package com.wx.assigntask.service.impl;

import com.wx.assigntask.dao.MyreceiveMapper;
import com.wx.assigntask.entity.Myreceive;
import com.wx.assigntask.service.MyReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:wx
 * @Date:Created in 19:00 2019/2/24
 * @Modified by:
 */
@Service
public class MyreceivedServiceImpl implements MyReceiveService {
    @Autowired
    MyreceiveMapper myreceiveMapper;

    @Override
    public void insertRecord(List<Integer> subtaskids, int userid,int releaseid, int divided) {
        Myreceive myreceive = new Myreceive();
        myreceive.setUserid(userid);
        myreceive.setReleaseid(releaseid);
        myreceive.setDividedid(divided);
        for (int i=0;i<subtaskids.size();i++){
            switch (i+1){
                case 1:myreceive.setSubtaskid_1(subtaskids.get(i));break;
                case 2:myreceive.setSubtaskid_2(subtaskids.get(i));break;
                case 3:myreceive.setSubtaskid_3(subtaskids.get(i));break;
                case 4:myreceive.setSubtaskid_4(subtaskids.get(i));break;
                case 5:myreceive.setSubtaskid_5(subtaskids.get(i));break;
                case 6:myreceive.setSubtaskid_6(subtaskids.get(i));break;
                case 7:myreceive.setSubtaskid_7(subtaskids.get(i));break;
                case 8:myreceive.setSubtaskid_8(subtaskids.get(i));break;
                case 9:myreceive.setSubtaskid_9(subtaskids.get(i));break;
                case 10:myreceive.setSubtaskid_10(subtaskids.get(i));break;
            }
        }
        myreceiveMapper.insert(myreceive);
    }

    @Override
    public List<Myreceive> selectByUser(int userid) {
        List<Myreceive> myreceives = myreceiveMapper.selectByUser(userid);
        return myreceives;
    }

    /**
     * 选取未完成或已完成
     * @param userid
     * @param ifComplete
     * @return
     */
    @Override
    public List<Myreceive> selectIfcomByUser(int userid, String ifComplete) {
        Myreceive myreceive = new Myreceive();
        myreceive.setUserid(userid);
        myreceive.setIfcomplete(ifComplete);
        List<Myreceive> myreceives = myreceiveMapper.selectIfcomByUser(myreceive);
        return myreceives;
    }

    /**
     * 选取打分者正在打分的myreceive
     * @param userid
     * @param count
     * @return
     */
    @Override
    public Myreceive selectByUser(int userid,int count) {
        List<Myreceive> myreceives = myreceiveMapper.selectByUser(userid);
        if (count<=myreceives.size()){
            return myreceives.get(count-1);
        }
        else return null;
    }

    @Override
    public void updateIfcomple(int id,String ifComplete) {
        Myreceive myreceive = new Myreceive();
        myreceive.setId(id);
        myreceive.setIfcomplete(ifComplete);
        myreceiveMapper.updateIfcomple(myreceive);
    }
}
