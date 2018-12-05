package com.wx.assigntask.entity;

/**
 * @Author: wx
 * @Date: 2018/12/5 9:35
 * @Version 1.0
 */
public class Plan {
    /**
     * 方案表，记录发布者可选择的方案，方案ID、方案名称、方案相关描述、预计参与人数
     */
    private int planID;
    private String planName;
    private String planDescribe; //应该包括预计完成天数、准确可信度
    private int predictWorkerNum; //预计参与人数

    public int getPlanID() {
        return planID;
    }

    public void setPlanID(int planID) {
        this.planID = planID;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanDescribe() {
        return planDescribe;
    }

    public void setPlanDescribe(String planDescribe) {
        this.planDescribe = planDescribe;
    }

    public int getPredictWorkerNum() {
        return predictWorkerNum;
    }

    public void setPredictWorkerNum(int predictWorkerNum) {
        this.predictWorkerNum = predictWorkerNum;
    }
}
