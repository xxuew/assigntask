package com.nju.assigntask.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author:wx
 * @Date:Created in 20:25 2019/4/20
 * @Modified by:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class UserreceiveMapperTest {
    @Autowired
    UserreceiveMapper userreceiveMapper;

    @Test
    public void insertSubTask(){

        userreceiveMapper.insertSubTask(1,1,1);
    }

}