package com.nju.assigntask.service.impl;

import com.nju.assigntask.dao.DividedMapper;
import com.nju.assigntask.dao.RecommandMapper;
import com.nju.assigntask.dao.ReleaseMapper;
import com.nju.assigntask.entity.Recommend;
import com.nju.assigntask.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendServiceImpl implements RecommendService {

    @Autowired
    RecommandMapper recommandMapper;
    @Autowired
    ReleaseMapper releaseMapper;
    @Autowired
    DividedMapper dividedMapper;

    @Override
    public List selectAllItemsNames(int recommandid, String algName) {
        Recommend recommendNames = new Recommend();

//        if (algName.equals("lstm")) {
//            recommendNames = recommandMapper.selectAllLstmItemsNames(recommandid); //下标0为id，1为inputname，2开始为itemname
//        } else if (algName.equals("nn")) {
//            recommendNames = recommandMapper.selectAllNnItemsNames(recommandid);
//        } else if (algName.equals("cnn")) {
//            recommendNames = recommandMapper.selectAllCnnItemsNames(recommandid);
//        } else if (algName.equals("tfidf")) {
//            recommendNames = recommandMapper.selectAllTfiItemsNames(recommandid);
//        } else if (algName.equals("doc")) {
//            recommendNames = recommandMapper.selectAllDocItemsNames(recommandid);
//        } else if (algName.equals("index")) {
//            recommendNames = recommandMapper.selectAllIndexItemsNames(recommandid);
//        }
        List itemNames = new ArrayList();
//        itemNames.add(recommendNames.getId());
//        itemNames.add(recommendNames.getInputname());
//        itemNames.add(recommendNames.getName1());
//        itemNames.add(recommendNames.getName2());
//        itemNames.add(recommendNames.getName3());
//        itemNames.add(recommendNames.getName4());
//        itemNames.add(recommendNames.getName5());
//        itemNames.add(recommendNames.getName6());
//        itemNames.add(recommendNames.getName7());
//        itemNames.add(recommendNames.getName8());
//        itemNames.add(recommendNames.getName9());
//        itemNames.add(recommendNames.getName10());
        return itemNames;
    }

    @Override
    public List selectAllItemDes(int recommandid, String algName) {
        Recommend recommendDes = new Recommend();
//        if (algName.equals("lstm")) {
//            recommendDes = recommandMapper.selectAllLstmItemDes(recommandid); //下标0为id，1为inputdes，2开始为itemdes
//        } else if (algName.equals("nn")) {
//            recommendDes = recommandMapper.selectAllNnItemDes(recommandid);
//        } else if (algName.equals("cnn")) {
//            recommendDes = recommandMapper.selectAllCnnItemDes(recommandid);
//        } else if (algName.equals("tfidf")) {
//            recommendDes = recommandMapper.selectAllTfiItemDes(recommandid);
//        } else if (algName.equals("doc")) {
//            recommendDes = recommandMapper.selectAllDocItemDes(recommandid);
//        } else if (algName.equals("index")) {
//            recommendDes = recommandMapper.selectAllIndexItemDes(recommandid);
//        }
        List itemDes = new ArrayList();
//        itemDes.add(recommendDes.getId());
//        itemDes.add(recommendDes.getInputdes());
//        itemDes.add(recommendDes.getDes1());
//        itemDes.add(recommendDes.getDes2());
//        itemDes.add(recommendDes.getDes3());
//        itemDes.add(recommendDes.getDes4());
//        itemDes.add(recommendDes.getDes5());
//        itemDes.add(recommendDes.getDes6());
//        itemDes.add(recommendDes.getDes7());
//        itemDes.add(recommendDes.getDes8());
//        itemDes.add(recommendDes.getDes9());
//        itemDes.add(recommendDes.getDes10());
        return itemDes;
    }

    @Override
    public List selectAll(int releaseid) {
        List inputSize = new ArrayList();
        String algNames = releaseMapper.findReleaseById(releaseid).getAlgnames(); //本次release包含的algNames
//        if (algNames.contains("lstm")) {
//            inputSize = recommandMapper.selectAllLstm();
//        } else if (algNames.contains("nn")) {
//            inputSize = recommandMapper.selectAllNn();
//        } else if (algNames.contains("cnn")) {
//            inputSize = recommandMapper.selectAllCnn();
//        } else if (algNames.contains("tfidf")) {
//            inputSize = recommandMapper.selectAllTfidf();
//        } else if (algNames.contains("doc")) {
//            inputSize = recommandMapper.selectAllDoc();
//        } else if (algNames.contains("index")) {
//            inputSize = recommandMapper.selectAllIndex();
//        }
        return inputSize;
    }

//    /**
//     * 获取myreceive中的inputname和inputdes
//     *
//     * @param myreceive
//     * @return
//     */
//    @Override
//    public Recommend selectInputById(Myreceive myreceive) {
//
//        Divided divided = dividedMapper.selectByPrimaryKey(myreceive.getDividedid());
//        int inputid = divided.getInputid();
//        String algName = divided.getAlgname1();//只需一个algName即可，因为alg1和alg2都来自同一个input
//        Recommend recommend = new Recommend();
////        if (algName.equals("lstm")) {
////            recommend = recommandMapper.selectLstmInputById(inputid);
////        } else if (algName.equals("nn")) {
////            recommend = recommandMapper.selectNnInputById(inputid);
////        } else if (algName.equals("cnn")) {
////            recommend = recommandMapper.selectCnnInputById(inputid);
////        } else if (algName.equals("tfidf")) {
////            recommend = recommandMapper.selectTfiInputById(inputid);
////        } else if (algName.equals("doc")) {
////            recommend = recommandMapper.selectDocInputById(inputid);
////        } else if (algName.equals("index")) {
////            recommend = recommandMapper.selectIndexInputById(inputid);
////        }
//
//        return recommend;
//    }
}
