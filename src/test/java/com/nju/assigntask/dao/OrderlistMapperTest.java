package com.nju.assigntask.dao;

import com.nju.assigntask.entity.Orderlist;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author:wx
 * @Date:Created in 18:20 2019/4/21
 * @Modified by:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class OrderlistMapperTest {
    @Autowired
    OrderlistMapper orderlistMapper;

    @Test
    public void selectOrderedReco(){
        List<Orderlist> list = orderlistMapper.selectOrderedReco(1,1,"lstm");
        System.out.println(list);
        //--     order by score desc;
    }

}