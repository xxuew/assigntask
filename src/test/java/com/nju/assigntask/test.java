package com.nju.assigntask;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.apache.xerces.impl.xpath.regex.Match;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:wx
 * @Date:Created in 20:37 2019/4/19
 * @Modified by:
 */
public class test {
    public static void main(String args[]){
//        String str = "第1轮2剪枝";
//        //String regex = ("[一-四]");
//
//        String num = str.replaceAll("[^0-9]","");
//        System.out.println(num);
        List list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        List list2 = new ArrayList();
        list2.add(3);
        list2.add(4);
        List list3 = new ArrayList();
        list3.add(list1);
        list3.add(list2);
//        list3.addAll(list1);
//        list3.addAll(list2);
        System.out.println(list3);
//        List<Double> scoreData = new ArrayList();
//        scoreData.add(1.0);
//        scoreData.add(2.0);
//        scoreData.add(3.0);
//        scoreData.add(4.0);
//        int count =2;
//        List<Double> resultData = new ArrayList<>();//存放grubbs处理后的所有数据
//        for (int j=0;j<count;j++){
//            List<Double> data = new ArrayList<>();
//            for (int z=j*2;data.size()<2;z++){
//                data.add(scoreData.get(z));  //每24个数一组去可疑值
//            }
//         //   data = grubbs.judgeGrubbs(data); //去可疑值
//            resultData.addAll(data); //汇总到resultData
//            System.out.println(resultData);
     //   }
    }
}



