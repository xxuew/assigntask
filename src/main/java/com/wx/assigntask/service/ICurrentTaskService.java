package com.wx.assigntask.service;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ICurrentTaskService {
    List<Integer> currenttasknum();
}
