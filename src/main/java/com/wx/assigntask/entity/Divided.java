package com.wx.assigntask.entity;

/**
 * @Author: wx
 * @Date: 2018/12/10 10:11
 * @Version 1.0
 */
public class Divided {
    /**
     * 存放划分的对比组，假设有三个算法，那么AB先比，AB就是被划分的一组
     */
    private int dividedId;
    private String alg1Name; //算法1名称
    private String alg2Name; //算法2名称

    public int getDividedId() {
        return dividedId;
    }

    public void setDividedId(int dividedId) {
        this.dividedId = dividedId;
    }

    public String getAlg1Name() {
        return alg1Name;
    }

    public void setAlg1Name(String alg1Name) {
        this.alg1Name = alg1Name;
    }

    public String getAlg2Name() {
        return alg2Name;
    }

    public void setAlg2Name(String alg2Name) {
        this.alg2Name = alg2Name;
    }

    @Override
    public String toString() {
        return "Divided{" +
                "dividedId=" + dividedId +
                ", alg1Name='" + alg1Name + '\'' +
                ", alg2Name='" + alg2Name + '\'' +
                '}';
    }
}
