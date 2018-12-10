package com.wx.assigntask.service;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/10 19:29
 * @Version 1.0
 */
@Repository
public interface ItemsService {
    public String findDesByItemsName(String itemName);
}
