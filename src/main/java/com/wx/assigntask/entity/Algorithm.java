package com.wx.assigntask.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/8 18:17
 * @Version 1.0
 */
public class Algorithm {
    /**
     * 存放算法+算法对应的item_nam，表示该算法是否已被分配？？
     */
    private int algorithmId;
    private String algorithmName;
    private String itemName;
    private String inputName;//输入查询的项目名称
    private String inputDes; //输入查询的项目描述

//    private int divided; //该算法是够已分配

    public int getAlgorithmId() {
        return algorithmId;
    }

    public void setAlgorithmId(int algorithmId) {
        this.algorithmId = algorithmId;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getInputDes() {
        return inputDes;
    }

    public void setInputDes(String inputDes) {
        this.inputDes = inputDes;
    }

    @Override
    public String toString() {
        return "Algorithm{" +
                "algorithmId=" + algorithmId +
                ", algorithmName='" + algorithmName + '\'' +
                ", itemName='" + itemName + '\'' +
                ", inputName='" + inputName + '\'' +
                ", inputDes='" + inputDes + '\'' +
                '}';
    }

    //    public List getItems(){
//       List items = new ArrayList();
//       items.add(algorithm_id);
//       items.add(item_1);
//       items.add(item_2);
//       items.add(item_3);
//       items.add(item_4);
//       items.add(item_5);
//       items.add(item_6);
//       items.add(item_7);
//       items.add(item_8);
//       items.add(item_9);
//       items.add(item_10);
//
//       return items;
//    }
}