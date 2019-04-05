package com.wx.assigntask.tools;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author:wx
 * @Date:Created in 16:21 2019/3/15
 * @Modified by:
 */
public class ModifiedGrubbsTest {

    @Test
    public void judgeGrubbs() {
        ModifiedGrubbs modifiedGrubbs = new ModifiedGrubbs();
        List<Double> matrix = new ArrayList<>();
        matrix.add(1.0);
//        matrix.add(6.0);
        matrix.add(7.0);
        matrix.add(8.0);
        matrix.add(9.0);
        matrix.add(10.0);
        matrix.add(10.0);
        System.out.println("初始数据  ："+matrix);

        List result = modifiedGrubbs.judgeGrubbs(matrix);

        System.out.println("处理后数据：" +result);
    }

    @Test
    public void calcAverage() {
    }
}