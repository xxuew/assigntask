package com.nju.assigntask.service;

import com.nju.assigntask.entity.Release;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * orderlist表业务相关处理
 * @Author: wx
 * @Date: 2019/1/2 11:26
 * @Version 1.0
 */
@Repository
public interface OrderListService {
    /**
     * 处理算法内部排序得分
     * @param release
     * @return
     */
    boolean dealData(Release release);

    /**
     * 求某个推荐结果平均得分
     * @param sumscore1
     * @param sumscore2
     * @return
     */
    double aveScore(List<Double> sumscore1,List<Double> sumscore2);


    //  void insertRecord(Orderlist orderlist,String algName);

 //   List<Orderlist> selectByDividedIdOrderScore(int dividedid,String algName);
  //  List<Orderlist> selectRecord(int inputid,int releaseid,String algName);
//    List selectItemNames(int inputid,int releaseid,String algName);
//    List selectItemDes(int inputid,int releaseid,String algName);

//    void getOrdered(int dividedid,String algName);

//    void updateById(Orderlist orderlist,String algName);

}
