package com.nju.assigntask.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author:wx
 * @Date:Created in 11:05 2019/4/20
 * @Modified by:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class SubtaskMapperTest {
    @Autowired
    SubtaskMapper subtaskMapper;

    @Test
   public void insertSubtask(){
        int dividedId =0;
        String itemName1 = "itemname1";
        String itemDes1 = "itemdes1";
        String itemName2 = "itemname2";
        String itemDes2 = "itemdes2";
        subtaskMapper.insertSubtask(dividedId,itemName1,itemDes1,itemName2,itemDes2);
    }

    @Test
    public void updateFre(){
        subtaskMapper.updateFre(1,1);
    }

    @Test
    public void updateScore1(){
        subtaskMapper.updateScore1(1,1);
    }

    @Test
    public void updateScore2(){
        subtaskMapper.updateScore2(1,1);
    }

}