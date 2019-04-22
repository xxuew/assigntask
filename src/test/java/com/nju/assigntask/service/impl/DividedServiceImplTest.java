package com.nju.assigntask.service.impl;

import com.nju.assigntask.entity.Divided;
import com.nju.assigntask.service.DividedService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author:wx
 * @Date:Created in 20:03 2019/4/20
 * @Modified by:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class DividedServiceImplTest {

    @Autowired
    DividedService dividedService;

    @Test
    public void insertDivided() {

        Divided divided = new Divided();
        divided.setReleaseid(1);
        divided.setAlgname1("algname1");
        divided.setAlgname2("algname2");
        divided.setInputid(1);
        int dividedid = dividedService.insertDivided(1,1,"algname1","algname2");
        System.out.println(dividedid);
        divided.setInputid(2);
        int dividedid2 = dividedService.insertDivided(1,2,"algname1","algname2");
        System.out.println(dividedid2);
    }
}