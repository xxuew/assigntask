package com.wx.assigntask.entity;

import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/4 17:22
 * @Version 1.0
 */
public class User {
    private Integer userId;
    private String username;
    private Integer password;
//    private List releaseId;
//    private List receiveId;
    private String releaseId;
    private String receiveId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public String getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(String releaseId) {
        this.releaseId = releaseId;
    }

    public String getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password=" + password +
                ", releaseId=" + releaseId +
                ", receiveId=" + receiveId +
                '}';
    }
}
