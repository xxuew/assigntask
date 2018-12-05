package com.wx.assigntask.entity;

import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/5 9:32
 * @Version 1.0
 */
public class ReleaseTask {
    /**
     *发布任务表，记录任务ID、任务名称、任务数据、任务选取方案ID、任务目前进度、任务预计划分子表个数、
     * 已经划分子任务ID、目前参与人数、预计工作量、已完成工作量、发布者ID。
     */
    private int taskID;
    private String taskName;
    private List taskData; //任务原始数据
    private int planID;
    private String status; //任务目前状态（进度）
    private List SubTaskID; //已划分子任务ID
    private int predictSubNum; //预计划分子任务个数，比如ABC分成两个子任务，AB、C
    private int workerNum; //目前参与人数
    private String predictWorkload; //预计工作量
    private String completedWorkload; //已经完成工作量
    private int userID; //发布者ID

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getPlanID() {
        return planID;
    }

    public void setPlanID(int planID) {
        this.planID = planID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List getSubTaskID() {
        return SubTaskID;
    }

    public void addSubTaskID(int subTaskID) {
        this.SubTaskID.add(subTaskID);
    }

    public void removeSubTaskID(int subTaskID) {
        this.SubTaskID.remove(subTaskID);
    }

    public int getPredictSubNum() {
        return predictSubNum;
    }

    public void setPredictSubNum(int predictSubNum) {
        this.predictSubNum = predictSubNum;
    }

    public int getWorkerNum() {
        return workerNum;
    }

    public void setWorkerNum(int workerNum) {
        this.workerNum = workerNum;
    }

    public String getPredictWorkload() {
        return predictWorkload;
    }

    public void setPredictWorkload(String predictWorkload) {
        this.predictWorkload = predictWorkload;
    }

    public String getCompletedWorkload() {
        return completedWorkload;
    }

    public void setCompletedWorkload(String completedWorkload) {
        this.completedWorkload = completedWorkload;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

}
