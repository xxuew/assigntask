package com.wx.assigntask.service.impl;


import com.wx.assigntask.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/7 18:30
 * @Version 1.0
 */
@Service
public class ReleaseServiceImpl implements ReleaseService {
    @Override
    public List finAlgsByInputName(String inputName) {
        return null;
    }

    @Override
    public void updateDivided(String divided, String inputName, String algName) {

    }

    @Override
    public String findDivided(String inputName, String algName) {
        return null;
    }

}
