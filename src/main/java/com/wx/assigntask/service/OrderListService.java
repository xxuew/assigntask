package com.wx.assigntask.service;

import com.wx.assigntask.entity.Orderlist;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: wx
 * @Date: 2019/1/2 11:26
 * @Version 1.0
 */
@Repository
public interface OrderListService {
    void dealData();

    void insertRecord(Orderlist orderlist,String algName);

    List<Orderlist> selectByDividedIdOrderScore(int dividedid,String algName);
    List<Orderlist> selectRecord(int inputid,int releaseid,String algName);
    List selectItemNames(int inputid,int releaseid,String algName);
    List selectItemDes(int inputid,int releaseid,String algName);

    void getOrdered(int dividedid,String algName);

    void updateById(Orderlist orderlist,String algName);
    float aveScore(int avescore1,int avescore2);

}
