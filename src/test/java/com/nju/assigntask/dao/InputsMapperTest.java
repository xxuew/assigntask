package com.nju.assigntask.dao;

import com.nju.assigntask.entity.Inputs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author:wx
 * @Date:Created in 15:29 2019/4/21
 * @Modified by:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class InputsMapperTest {
    @Autowired
    InputsMapper inputsMapper;

    @Test
    public void selectByInputid(){
        Inputs inputs = inputsMapper.selectByInputid("inputtest",1);
        System.out.println(inputs);
    }

}