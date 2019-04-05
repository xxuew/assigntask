package com.wx.assigntask.tools;

import java.util.HashMap;

/**
 * @Author:wx
 * @Date:Created in 19:21 2019/3/12
 * @Modified by:
 */
public class ModifiedAHP {
    static int n;//矩阵的阶数
    double cal[][];//层次比较矩阵,归一化后的
    double cal1[][];//层次比较矩阵
    static HashMap RI = null;//将12阶的成对比较矩阵的平均随机一致性指标值保存在哈希映射表里

    //设置平均随机一致性指标值
    public double  getRI(int index) {
        RI = new HashMap();
        RI.put(1, 0);
        RI.put(2, 0);
        RI.put(3, 0.58);
        RI.put(4, 0.89);
        RI.put(5, 1.12);
        RI.put(6, 1.24);
        RI.put(7, 1.32);
        RI.put(8, 1.41);
        RI.put(9, 1.45);
        RI.put(10, 1.49);
        RI.put(11, 1.52);
        RI.put(12, 1.54);

        return (Double) RI.get(index);
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    //原始成对比较矩阵列向量的归一化
    public void colNormalize(double matrix[][])//列向量的归一化
    {
        double arr[] = new double[n];
        System.out.println("*****************每列求加和开始*****************");
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                arr[j] += matrix[i][j];//每列求加和
            }
        }
        System.out.println("*****************每列求加和完毕*****************");


        System.out.println("*****************列向量归一化开始*****************");
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                cal[i][j] = cal[i][j] / arr[j];//列向量归一化
            }
        }
        System.out.println("*****************列向量归一化完毕*****************");

    }

    //得到归一化矩阵各行的行和
    public double[] rowNormalize(double matrix[][])//按行求和,并返回求得的数组
    {
        double arr1[] = new double[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                arr1[j] += matrix[j][i];//每行求加和
            }
        }

        //以下对arr1[]进行归一化
        double sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr1[i];
        }
        System.out.println("*****************向量归一化计算开始*****************");
        for (int i = 0; i < n; i++)//得到权重
        {
            arr1[i] = arr1[i] / sum;
        }
        System.out.println("*****************向量归一化计算结束*****************");

        return arr1;
    }

    //求最大特征值
    public double getMaxLamta(double arr1[],double martrix[][]) {
        double arr2[] = new double[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                arr2[j] += martrix[j][i] * arr1[i];//得到A*w
            }
        }

        double L = 0;//5*maxLamta
        for (int i = 0; i < n; i++) {
            L += arr2[i] / arr1[i];
        }
        double maxLamta = L / n;
        return maxLamta;
    }

    public  double[] calAHP(double matrix[][]) {
        double CI, maxLamta, RI, CR;
        RI = getRI(matrix[0].length);
        colNormalize(matrix);
        double sinLayWeight[] = rowNormalize(matrix);
        maxLamta = getMaxLamta(sinLayWeight,matrix);
        CI = (maxLamta - matrix[0].length) / (matrix[0].length - 1);
        CR = CI / RI;
        if (CR < 0.1) {
            return sinLayWeight;
        } else {
           return new double[1];
        }

//        //组合权向量的计算
//        double comWeightVec[][] = new double[3][3];

//        //构造准则层的权向量矩阵
//        System.out.println("****************构造准则层的权向量矩阵开始****************");
//        for (int j = 0; j < n; j++) {
//            for (int i = 0; i < n; i++) {
//                if (j == 0) {
//                    comWeightVec[i][j] = arr1_1[i];
//                }
//                if (j == 1) {
//                    comWeightVec[i][j] = arr1_2[i];
//                }
//                if (j == 2) {
//                    comWeightVec[i][j] = arr1_3[i];
//                }
//            }
//        }
//        System.out.println("****************构造准则层的权向量矩阵结束****************");


//        //求组合权重
//        System.out.println("****************求组合权重开始****************");
//        double arr3[] = new double[3];//保存组合权重的数据
//        for (int j = 0; j < n; j++) {
//            for (int i = 0; i < n; i++) {
//                arr3[j] += comWeightVec[j][i] * sinLayWeight[i];//得到组合权重
//            }
//        }
//        System.out.println("****************求组合权重结束****************");
    }
}
