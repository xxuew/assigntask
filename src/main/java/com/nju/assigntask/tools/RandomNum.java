package com.nju.assigntask.tools;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Author:wx
 * @Date:Created in 11:28 2019/4/6
 * @Modified by:
 */
/**
 * 根据subtask数量生成不重复的随机数
 * @return
 */
@Component
public class RandomNum {
    public int[] getNumber(int total) {
        int[] NumberBox = new int[total];           //容器A
        int[] rtnNumber = new int[total];           //容器B
        for (int i = 0; i < total; i++) {
            NumberBox[i] = i;     //先把N个数放入容器A中
        }
        int end = total - 1;
        for (int j = 0; j < total; j++) {
            int num = new Random().nextInt(end + 1);  //取随机数
            rtnNumber[j] = NumberBox[num];            //把随机数放入容器B
            NumberBox[num] = NumberBox[end];          //把容器A中最后一个数覆盖所取的随机数
            end--;                                    //缩小随机数所取范围
        }
        return rtnNumber;                           //返回int型数组
    }
}
