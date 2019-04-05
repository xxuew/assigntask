package com.wx.assigntask.service.impl;

import com.wx.assigntask.dao.DividedMapper;
import com.wx.assigntask.dao.RecommandMapper;
import com.wx.assigntask.dao.ReleaseMapper;
import com.wx.assigntask.entity.Divided;
import com.wx.assigntask.entity.Myreceive;
import com.wx.assigntask.entity.Recommand;
import com.wx.assigntask.service.RecommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommandServiceImpl implements RecommandService {

    @Autowired
    RecommandMapper recommandMapper;
    @Autowired
    ReleaseMapper releaseMapper;
    @Autowired
    DividedMapper dividedMapper;

    @Override
    public List selectAllItemsNames(int recommandid, String algName) {
        Recommand recommandNames = new Recommand();

        if (algName.equals("lstm")) {
            recommandNames = recommandMapper.selectAllLstmItemsNames(recommandid); //下标0为id，1为inputname，2开始为itemname
        } else if (algName.equals("nn")) {
            recommandNames = recommandMapper.selectAllNnItemsNames(recommandid);
        } else if (algName.equals("cnn")) {
            recommandNames = recommandMapper.selectAllCnnItemsNames(recommandid);
        } else if (algName.equals("tfidf")) {
            recommandNames = recommandMapper.selectAllTfiItemsNames(recommandid);
        } else if (algName.equals("doc")) {
            recommandNames = recommandMapper.selectAllDocItemsNames(recommandid);
        } else if (algName.equals("index")) {
            recommandNames = recommandMapper.selectAllIndexItemsNames(recommandid);
        }
        List itemNames = new ArrayList();
        itemNames.add(recommandNames.getId());
        itemNames.add(recommandNames.getInputname());
        itemNames.add(recommandNames.getName1());
        itemNames.add(recommandNames.getName2());
        itemNames.add(recommandNames.getName3());
        itemNames.add(recommandNames.getName4());
        itemNames.add(recommandNames.getName5());
        itemNames.add(recommandNames.getName6());
        itemNames.add(recommandNames.getName7());
        itemNames.add(recommandNames.getName8());
        itemNames.add(recommandNames.getName9());
        itemNames.add(recommandNames.getName10());
        return itemNames;
    }

    @Override
    public List selectAllItemDes(int recommandid, String algName) {
        Recommand recommandDes = new Recommand();
        if (algName.equals("lstm")) {
            recommandDes = recommandMapper.selectAllLstmItemDes(recommandid); //下标0为id，1为inputdes，2开始为itemdes
        } else if (algName.equals("nn")) {
            recommandDes = recommandMapper.selectAllNnItemDes(recommandid);
        } else if (algName.equals("cnn")) {
            recommandDes = recommandMapper.selectAllCnnItemDes(recommandid);
        } else if (algName.equals("tfidf")) {
            recommandDes = recommandMapper.selectAllTfiItemDes(recommandid);
        } else if (algName.equals("doc")) {
            recommandDes = recommandMapper.selectAllDocItemDes(recommandid);
        } else if (algName.equals("index")) {
            recommandDes = recommandMapper.selectAllIndexItemDes(recommandid);
        }
        List itemDes = new ArrayList();
        itemDes.add(recommandDes.getId());
        itemDes.add(recommandDes.getInputdes());
        itemDes.add(recommandDes.getDes1());
        itemDes.add(recommandDes.getDes2());
        itemDes.add(recommandDes.getDes3());
        itemDes.add(recommandDes.getDes4());
        itemDes.add(recommandDes.getDes5());
        itemDes.add(recommandDes.getDes6());
        itemDes.add(recommandDes.getDes7());
        itemDes.add(recommandDes.getDes8());
        itemDes.add(recommandDes.getDes9());
        itemDes.add(recommandDes.getDes10());
        return itemDes;
    }

    @Override
    public List selectAll(int releaseid) {
        List inputSize = new ArrayList();
        String algNames = releaseMapper.findReleaseById(releaseid).getAlgnames(); //本次release包含的algNames
        if (algNames.contains("lstm")) {
            inputSize = recommandMapper.selectAllLstm();
        } else if (algNames.contains("nn")) {
            inputSize = recommandMapper.selectAllNn();
        } else if (algNames.contains("cnn")) {
            inputSize = recommandMapper.selectAllCnn();
        } else if (algNames.contains("tfidf")) {
            inputSize = recommandMapper.selectAllTfidf();
        } else if (algNames.contains("doc")) {
            inputSize = recommandMapper.selectAllDoc();
        } else if (algNames.contains("index")) {
            inputSize = recommandMapper.selectAllIndex();
        }
        return inputSize;
    }

    /**
     * 获取myreceive中的inputname和inputdes
     *
     * @param myreceive
     * @return
     */
    @Override
    public Recommand selectInputById(Myreceive myreceive) {

        Divided divided = dividedMapper.selectByPrimaryKey(myreceive.getDividedid());
        int inputid = divided.getInputid();
        String algName = divided.getAlgname1();//只需一个algName即可，因为alg1和alg2都来自同一个input
        Recommand recommand = new Recommand();
        if (algName.equals("lstm")) {
            recommand = recommandMapper.selectLstmInputById(inputid);
        } else if (algName.equals("nn")) {
            recommand = recommandMapper.selectNnInputById(inputid);
        } else if (algName.equals("cnn")) {
            recommand = recommandMapper.selectCnnInputById(inputid);
        } else if (algName.equals("tfidf")) {
            recommand = recommandMapper.selectTfiInputById(inputid);
        } else if (algName.equals("doc")) {
            recommand = recommandMapper.selectDocInputById(inputid);
        } else if (algName.equals("index")) {
            recommand = recommandMapper.selectIndexInputById(inputid);
        }

        return recommand;
    }
}
