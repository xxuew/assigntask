package com.wx.assigntask.entity;

/**
 * @Author: wx
 * @Date: 2018/12/10 10:27
 * @Version 1.0
 */
public class Release {
    /**
     * 用户发布任务表，记录发布ID，该项任务包含哪些算法ID，任务最终比分和胜出的算法名称
     */
    private int releaseId;
    private String inputName;
    private String inputDes;
    private String alg;
    private String ifDivided;
    private String ifComplete; //是否结束
    private String winAlgName; //胜出的算法
    private String result;

    public int getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(int releaseId) {
        this.releaseId = releaseId;
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

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }

    public String getIfDivided() {
        return ifDivided;
    }

    public void setIfDivided(String ifDivided) {
        this.ifDivided = ifDivided;
    }

    public String getIfComplete() {
        return ifComplete;
    }

    public void setIfComplete(String ifComplete) {
        this.ifComplete = ifComplete;
    }

    public String getWinAlgName() {
        return winAlgName;
    }

    public void setWinAlgName(String winAlgName) {
        this.winAlgName = winAlgName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Release{" +
                "releaseId=" + releaseId +
                ", inputName='" + inputName + '\'' +
                ", inputDes='" + inputDes + '\'' +
                ", alg='" + alg + '\'' +
                ", ifDivided='" + ifDivided + '\'' +
                ", ifComplete='" + ifComplete + '\'' +
                ", winAlgName='" + winAlgName + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
