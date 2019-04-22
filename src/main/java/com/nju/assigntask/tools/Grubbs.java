package com.nju.assigntask.tools;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:wx
 * @Date:Created in 15:26 2019/3/12
 * @Modified by:
 */
@Component
public class Grubbs {
//        private ArrayList<Double> judgeData;
//        private int length;
        private final double alpha = 0.05;
        //传入一组数据，我们要做的是剔除最大或最小的异常值
//        public ModifiedGrubbs() {
//            this.judgeData = arrayList;
//            this.length = arrayList.size();
//        }


    public List<Double> judgeGrubbs(List<Double> judgeData) {
        if (judgeData.size() < 3) {
            return judgeData;
        }
        judgeData = bubbleSort(judgeData);
        double aveVal = calcAverage(judgeData);
        double stanDeviation = calcStanDeviation(judgeData, aveVal);
        double minAbs = aveVal - judgeData.get(0);
        double maxAbs = judgeData.get(judgeData.size() - 1) - aveVal;
        double minG = minAbs / stanDeviation;
        double maxG = maxAbs / stanDeviation;
        if (minG > calcGrubbs(alpha, judgeData.size())) {
            judgeData.remove(0);
            if (maxG > calcGrubbs(alpha, judgeData.size())) {
                judgeData.remove(judgeData.size() - 2);
            }
        } else if (maxG > calcGrubbs(alpha, judgeData.size())) {
            judgeData.remove(judgeData.size() - 1);
        }
        return judgeData;
    }

    //冒泡排序
        private List<Double> bubbleSort(List<Double> arr) {
            // TODO Auto-generated method stub
            double temp = 0;
            for (int i = 0; i < arr.size(); i++) {
                for (int j = 0; j < arr.size() - i - 1; j++) {
                    if (arr.get(j) > arr.get(j + 1)) {
                        temp = arr.get(j);
                        arr.set(j, arr.get(j + 1));
                        arr.set(j + 1, temp);
                    }
                }
            }
            return arr;
        }
        //求平均
        public double calcAverage(List<Double> sample) {
            // TODO Auto-generated method stub
            double sum = 0;
            int cnt = 0;
            for (int i = 0; i < sample.size(); i++) {
                sum += sample.get(i);
                cnt++;
            }

            return (double) sum / cnt;
        }
        //求标准差
        private double calcStanDeviation(List<Double> array, double average) {
            // TODO Auto-generated method stub
            double sum = 0;
            for (int i = 0; i < array.size(); i++) {
                sum += ((double) array.get(i) - average)
                        * ((double) array.get(i) - average);
            }
            return (double) Math.sqrt((sum / (array.size() - 1)));
        }
        //算临界值的表，这里alpha为0.05
        private double calcGrubbs(double alpha, int n) {
        //这是99%的置信水平
//            double[] N = { 1.1546847100299753, 1.4962499999999703,
//                    1.763678479497787, 1.9728167175443088, 2.1391059896012203,
//                    2.2743651271139984, 2.386809875078279, 2.4820832497170997,
//                    2.564121252001767, 2.6357330437346365, 2.698971864039854,
//                    2.755372404941574, 2.8061052912205966, 2.8520798130619083,
//                    2.894013795424427, 2.932482154393285, 2.9679513293748547,
//                    3.0008041587489247, 3.031358153993366, 3.0598791335206963,
//                    3.086591582831163, 3.1116865231590722, 3.135327688211162,
//                    3.157656337622164, 3.178795077984819, 3.198850919445483,
//                    3.2179177419513314, 3.2360783011390764, 3.2534058719727748,
//                    3.26996560491852, 3.2858156522011304, 3.301008108808857,
//                    3.31558980320037, 3.329602965279218, 3.3430857935316243,
//                    3.356072938839107, 3.368595919061223, 3.3806834758032323,
//                    3.3923618826659503, 3.403655212591846, 3.41458557057518,
//                    3.4251732969213213, 3.435437145364717, 3.4453944396432576,
//                    3.4550612115453876, 3.464452322969104, 3.4735815741386,
//                    3.482461799798589, 3.491104954935569, 3.4995221913492585,
//                    3.507723926208097, 3.5157199035634887, 3.5235192496631433,
//                    3.5311305227901078, 3.5385617582575746, 3.5458205091071684,
//                    3.5529138829882037, 3.5598485756350797 };

            double[] N = {1.15,1.48,1.71,1.89,2.02,2.13,2.21,2.29,2.36,2.41,
                          2.46,2.51,2.55,2.59,2.62,2.65,2.68,2.71,2.74,2.76,
                          2.80,2.82};
            return N[n - 3];

        }
}
