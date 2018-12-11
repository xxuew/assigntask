package com.wx.assigntask.entity;

/**
 * @Author: wx
 * @Date: 2018/12/9 21:34
 * @Version 1.0
 */
public class SubTask {
    /**
     * 存放子任务、某用户对该子任务的打分、该子任务属于哪个对比组
     */
    private int subtaskId;
    private int dividedId; //所属划分的组，比如A1：B1-B10属于A:B的组
    private int userId; //打分者ID
    private String item1Name;
    private String item1Des;
    private String item2Name;
    private String item2Des;
    private String item1Score;
    private String item2Score;

    public int getSubtaskId() {
        return subtaskId;
    }

    public void setSubtaskId(int subtaskId) {
        this.subtaskId = subtaskId;
    }

    public int getDividedId() {
        return dividedId;
    }

    public void setDividedId(int dividedId) {
        this.dividedId = dividedId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getItem1Name() {
        return item1Name;
    }

    public void setItem1Name(String item1Name) {
        this.item1Name = item1Name;
    }

    public String getItem1Des() {
        return item1Des;
    }

    public void setItem1Des(String item1Des) {
        this.item1Des = item1Des;
    }

    public String getItem2Name() {
        return item2Name;
    }

    public void setItem2Name(String item2Name) {
        this.item2Name = item2Name;
    }

    public String getItem2Des() {
        return item2Des;
    }

    public void setItem2Des(String item2Des) {
        this.item2Des = item2Des;
    }

    public String getItem1Score() {
        return item1Score;
    }

    public void setItem1Score(String item1Score) {
        this.item1Score = item1Score;
    }

    public String getItem2Score() {
        return item2Score;
    }

    public void setItem2Score(String item2Score) {
        this.item2Score = item2Score;
    }

    @Override
    public String toString() {
        return "SubTask{" +
                "subtaskId=" + subtaskId +
                ", dividedId=" + dividedId +
                ", userId=" + userId +
                ", item1Name='" + item1Name + '\'' +
                ", item1Des='" + item1Des + '\'' +
                ", item2Name='" + item2Name + '\'' +
                ", item2Des='" + item2Des + '\'' +
                ", item1Score='" + item1Score + '\'' +
                ", item2Score='" + item2Score + '\'' +
                '}';
    }
}
