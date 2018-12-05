package com.wx.assigntask.entity;

import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/4 17:22
 * @Version 1.0
 */
public class User {
    private Integer id;
    private String username;
    private Integer password;
    private List releaseId;
    private List receiveId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List getReleaseId() {
        return releaseId;
    }

    public void addReleaseId(Integer releaseId) {
        this.releaseId.add(releaseId);
    }

    public void removeReleaseId(Integer releaseId){
        this.releaseId.remove(releaseId);
    }

    public List getReceiveId() {
        return receiveId;
    }

    public void addReceiveId(Integer receiveId) {
        this.receiveId.add(receiveId);
    }

    public void removeReceiveId(Integer receiveId){
        this.receiveId.remove(receiveId);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password=" + password +
                ", releaseId=" + releaseId +
                ", receiveId=" + receiveId +
                '}';
    }
}
