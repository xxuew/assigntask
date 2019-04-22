package com.nju.assigntask.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author:wx
 * @Date:Created in 21:56 2019/4/19
 * @Modified by:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class ReleaseMapperTest {
    @Autowired
    ReleaseMapper releaseMapper;

    @Test
    public void updateStatus(){
        int releaseid = 1;
        String status = "第1次剪枝";
        releaseMapper.updateStatus(releaseid,status);
    }

}