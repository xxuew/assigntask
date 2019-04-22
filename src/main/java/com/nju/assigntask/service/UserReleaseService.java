package com.nju.assigntask.service;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserReleaseService {
    void insertRecord(int userid,int releaseid);
    List<Integer> selectByUser(int userid);
}
