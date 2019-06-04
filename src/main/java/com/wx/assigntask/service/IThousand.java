package com.wx.assigntask.service;

import com.wx.assigntask.entity.Cnn302000;
import org.springframework.stereotype.Service;

@Service
public interface IThousand {
    public void insert();
    Cnn302000 SelectByName(String record);
    void insertlstmscore();
    void ScoreSort();
}
