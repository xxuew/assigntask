package com.nju.assigntask.service.impl;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
     //   subtaskService.geneSubTask(releaseid);
    }

//    @Test
//    public void assignTaskToUser() {
//        subtaskService.assignTaskToUser();
//    }
}