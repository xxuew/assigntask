package com.wx.assigntask.service.impl;

import com.wx.assigntask.dao.RecommanddesMapper;
import com.wx.assigntask.dao.RecommandnameMapper;
import com.wx.assigntask.entity.Recommanddes;
import com.wx.assigntask.entity.Recommandname;
import com.wx.assigntask.service.RecommandNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/16 19:36
 * @Version 1.0
 */
@Service
public class RecommandNameServiceImpl implements RecommandNameService {
    @Autowired
    RecommandnameMapper recommandnameMapper;
    @Autowired
    RecommanddesMapper recommanddesMapper;

    @Override
    public void generateSubTask() {

        //获取所有inputNames，应该根据releaseID获取该次发布所涉及的inputName
//        List recoNames = recommandnameMapper.selectAllInputName();
//        //获取所有inputName对应的itemDes
//        HashMap<String,String> itemNameDes = new HashMap<String, String>();
//        for (int i=0;i<recoNames.size();i++)
//        {
//            String inputName = recoNames.get(i).toString();
//            Recommandname itemNames = recommandnameMapper.selectByPrimaryKey(inputName);
//            Recommanddes  itemDess = recommanddesMapper.selectByPrimaryKey(inputName);
//        }


    }

}
