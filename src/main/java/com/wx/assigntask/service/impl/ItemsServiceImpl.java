package com.wx.assigntask.service.impl;

import com.wx.assigntask.dao.ItemsDao;
import com.wx.assigntask.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/10 19:30
 * @Version 1.0
 */
@Service
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    ItemsDao itemsDao;

    @Override
    public String findDesByItemsName(String itemName) {
        String des = itemsDao.findDesByItemName(itemName);
        return des;
    }
}
