package com.nju.assigntask.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author:wx
 * @Date:Created in 10:59 2019/4/21
 * @Modified by:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class DividedMapperTest {
    @Autowired
    DividedMapper dividedMapper;

    @Test
    public void selectScore1Data(){
        List<Double> score1Data = dividedMapper.selectScore1Data(1,"lstm","nn");
        System.out.println(score1Data);
    }

}