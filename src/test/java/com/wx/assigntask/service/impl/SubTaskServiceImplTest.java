package com.wx.assigntask.service.impl;

import com.wx.assigntask.dao.*;
import com.wx.assigntask.service.*;
import com.wx.assigntask.tools.Constant;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Author:wx
 * @Date:Created in 16:38 2019/3/15
 * @Modified by:
 */
@RunWith(SpringJUnit4ClassRunner.class) //整合
@PropertySource("classpath:application.properties")
public class SubTaskServiceImplTest {

    SubTaskServiceImpl subtaskService;

    @Test
    public void geneSubTask() {
        int releaseid =1;
//        SubTaskServiceImpl subTaskService = new SubTaskServiceImpl();
        subtaskService.geneSubTask(releaseid);
    }
}