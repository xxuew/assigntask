package com.wx.assigntask.tools;

/**
 * @Author:wx
 * @Date:Created in 19:08 2019/3/12
 * @Modified by:
 */
import java.util.HashMap;
public class AHP {
    static int n;//矩阵的阶数
    double cal[][];//层次比较矩阵,归一化后的
    double cal1[][];//层次比较矩阵
    static HashMap hm = null;//将12阶的成对比较矩阵的平均随机一致性指标值保存在哈希映射表里

    //设置平均随机一致性指标值
    public static void setHm() {
        hm = new HashMap();
        hm.put(1, 0);
        hm.put(2, 0);
        hm.put(3, 0.58);
        hm.put(4, 0.89);
        hm.put(5, 1.12);
        hm.put(6, 1.24);
        hm.put(7, 1.32);
        hm.put(8, 1.41);
        hm.put(9, 1.45);
        hm.put(10, 1.49);
        hm.put(11, 1.52);
        hm.put(12, 1.54);
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    //原始成对比较矩阵列向量的归一化
    public void colvectortoone(double arr[])//列向量的归一化
    {
        arr = new double[n];
        System.out.println("*****************每列求加和开始*****************");
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                arr[j] += cal[i][j];//每列求加和
            }
        }
        System.out.println("*****************每列求加和完毕*****************");
        System.out.println("*****************打印行值和进行验证开始*****************");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);//打印行值和进行验证
        }
        System.out.println("*****************打印行值和进行验证完毕*****************");
        System.out.println("*****************列向量归一化开始*****************");
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                cal[i][j] = cal[i][j] / arr[j];//列向量归一化
            }
        }
        System.out.println("*****************列向量归一化完毕*****************");
        System.out.println("*****************打印归一化后的数组开始*****************");
        for (int j = 0; j < n; j++)//打印归一化后的数组
        {
            for (int i = 0; i < n; i++) {
                System.out.print(cal[j][i] + "\t");//列向量归一化
            }
            System.out.println();
        }
        System.out.println("*****************打印归一化后的数组结束*****************");
    }

    //得到归一化矩阵各行的行和
    public double[] rowsum(double arr1[])//按行求和,并返回求得的数组
    {
        arr1 = new double[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                arr1[j] += cal[j][i];//每行求加和
            }
        }
        System.out.println("*****************行和打印验证开始*****************");
        for (int j = 0; j < n; j++) {
            System.out.println(arr1[j]);
        }
        System.out.println("*****************行和打印验证结束*****************");
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
        System.out.println("*****************打印权重开始*****************");
        for (int j = 0; j < n; j++) {
            System.out.println(arr1[j]);
        }
        System.out.println("*****************打印权重结束*****************");
        return arr1;
    }

    //求最大特征值
    public double getnamda(double arr1[], double arr2[]) {
        arr2 = new double[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                arr2[j] += cal1[j][i] * arr1[i];//得到A*w
            }
        }
        System.out.println("*****************打印A*w开始*****************");
        for (int i = 0; i < n; i++) {
            System.out.println(arr2[i]);//打印权重向量
        }
        System.out.println("*****************打印A*w结束*****************");
        double L = 0;//5*namda
        for (int i = 0; i < n; i++) {
            L += arr2[i] / arr1[i];
        }
        double namda = L / n;
        return namda;
    }

    public static void main(String args[])
    {
        AHP ct=new AHP();
        AHP ct1=new AHP();
        AHP ct2=new AHP();
        AHP ct3=new AHP();
        //目标层比较矩阵
        double Cal[][]={{1,4,3},{0.25,1,2},{0.33333333,0.5,1}};
        double Cal1[][]={{1,4,3},{0.25,1,2},{0.33333333,0.5,1}};
        //准则层（元素1）比较矩阵
        double Cal2[][]={{1,5,2},{0.2,1,0.5},{0.5,2,1}};
        double Cal3[][]={{1,5,2},{0.2,1,0.5},{0.5,2,1}};
        //准则层（元素2）比较矩阵
        double Cal4[][]={{1,0.2,0.5},{5,1,2},{2,0.5,1}};
        double Cal5[][]={{1,0.2,0.5},{5,1,2},{2,0.5,1}};
        //准则层（元素3）比较矩阵
        double Cal6[][]={{1,2,0.25},{0.5,1,0.125},{4,8,1}};
        double Cal7[][]={{1,2,0.25},{0.5,1,0.125},{4,8,1}};

        ct.setN(3);//矩阵的阶数，共享
        int n=ct.getN();

        double arr[]=new double[n];//原始比较矩阵的每列和，目标层
        double arr1[]=new double[n];//单层权重，目标层
        double arr2[]=new double[n];//A*w，目标层

        double arr11[]=new double[n];//原始比较矩阵的每列和，准则层（元素一）
        double arr1_1[]=new double[n];//单层权重，准则层（元素一）
        double arr2_1[]=new double[n];//A*w，准则层（元素一）

        double arr22[]=new double[n];//原始比较矩阵的每列和，准则层（元素二）
        double arr1_2[]=new double[n];//单层权重，准则层（元素二）
        double arr2_2[]=new double[n];//A*w，准则层（元素二）

        double arr33[]=new double[n];//原始比较矩阵的每列和，准则层（元素三）
        double arr1_3[]=new double[n];//单层权重，准则层（元素三）
        double arr2_3[]=new double[n];//A*w，准则层（元素三）

        ct.cal=Cal;
        ct.cal1=Cal1;

        ct1.cal=Cal2;
        ct1.cal1=Cal3;

        ct2.cal=Cal4;
        ct2.cal1=Cal5;

        ct3.cal=Cal6;
        ct3.cal1=Cal7;

        AHP.setHm();//各矩阵共享

        double CI,nameda,RI,CR;
        double CI1,nameda1,CR1;
        double CI2,nameda2,CR2;
        double CI3,nameda3,CR3;

        Double ri=new Double(0);
        ri=(Double)ct.hm.get(3);//ct.RI.get(3)返回的是一个对象
        RI=ri.doubleValue();//得到RI,共享

        //计算目标层相关系数
        ct.colvectortoone(arr);
        arr1=ct.rowsum(arr1);
        nameda=ct.getnamda(arr1, arr2);
        System.out.println("最大特征值是 ："+nameda);//打印最大特征值
        CI=(nameda-n)/(n-1);
        System.out.println("计算的一致性指标CI："+CI);
        System.out.println("查出的平均随机一致性指标RI："+RI);
        CR=CI/RI;
        System.out.println("一致性比率CR ："+CR);
        if(CR<0.1)
        {
            System.out.println("比较矩阵不一致程度在容许范围内，可用其特征向量作为权向量");
        }
        else
        {
            System.out.println("请重新构造比较矩阵");
        }

        //计算准则层元素一相关系数
        ct1.colvectortoone(arr11);
        arr1_1=ct1.rowsum(arr1_1);
        nameda1=ct1.getnamda(arr1_1, arr2_1);
        System.out.println("最大特征值是 ："+nameda1);//打印最大特征值
        CI1=(nameda1-n)/(n-1);
        System.out.println("计算的一致性指标CI1 ："+CI1);
        System.out.println("查出的平均随机一致性指标RI ："+RI);
        CR1=CI1/RI;
        System.out.println("一致性比率CR1 ："+CR1);
        if(CR1<0.1)
        {
            System.out.println("比较矩阵不一致程度在容许范围内，可用其特征向量作为权向量");
        }
        else
        {
            System.out.println("请重新构造比较矩阵");
        }

        //计算准则层元素二相关系数
        ct2.colvectortoone(arr22);
        arr1_2=ct2.rowsum(arr1_2);
        nameda2=ct2.getnamda(arr1_2, arr2_2);
        System.out.println("最大特征值是 ："+nameda2);//打印最大特征值
        CI2=(nameda2-n)/(n-1);
        System.out.println("计算的一致性指标CI2 ："+CI2);
        System.out.println("查出的平均随机一致性指标RI ："+RI);
        CR2=CI2/RI;
        System.out.println("一致性比率是CR2 ："+CR2);
        if(CR2<0.1)
        {
            System.out.println("比较矩阵不一致程度在容许范围内，可用其特征向量作为权向量");
        }
        else
        {
            System.out.println("请重新构造比较矩阵");
        }

        //计算准则层元素三相关系数
        ct3.colvectortoone(arr33);
        arr1_3=ct3.rowsum(arr1_3);
        nameda3=ct3.getnamda(arr1_3, arr2_3);
        System.out.println("最大特征值是 ："+nameda3);//打印最大特征值
        CI3=(nameda3-n)/(n-1);
        System.out.println("计算的一致性指标CI3 ："+CI3);
        System.out.println("查出的平均随机一致性指标RI ："+RI);
        CR3=CI3/RI;
        System.out.println("一致性比率CR3 ："+CR3);
        if(CR3<0.1)
        {
            System.out.println("比较矩阵不一致程度在容许范围内，可用其特征向量作为权向量");
        }
        else
        {
            System.out.println("请重新构造比较矩阵");
        }

        //组合权向量的计算
        double corvector[][] = new double[3][3];

        //构造准则层的权向量矩阵
        System.out.println("****************构造准则层的权向量矩阵开始****************");
        for(int j=0;j<n;j++)
        {
            for(int i=0;i<n;i++)
            {
                if(j==0)
                {
                    corvector[i][j]=arr1_1[i];
                }
                if(j==1)
                {
                    corvector[i][j]=arr1_2[i];
                }
                if(j==2)
                {
                    corvector[i][j]=arr1_3[i];
                }
            }
        }
        System.out.println("****************构造准则层的权向量矩阵结束****************");

        //打印准则层矩阵
        System.out.println("****************打印准则层的权向量矩阵开始****************");
        for(int j=0;j<n;j++)
        {
            for(int i=0;i<n;i++)
            {
                System.out.print(corvector[j][i]+"\t");
            }
            System.out.println();
        }
        System.out.println("****************打印准则层的权向量矩阵结束****************");

        //打印目标层矩阵
        System.out.println("****************打印目标层的权向量矩阵开始****************");
        for(int j=0;j<n;j++)
        {
            System.out.println(arr1[j]);
        }
        System.out.println("****************打印目标层的权向量矩阵结束****************");

        //求组合权重
        System.out.println("****************求组合权重开始****************");
        double arr3[]=new double[3];//保存组合权重的数据
        for(int j=0;j<n;j++)
        {
            for(int i=0;i<n;i++)
            {
                arr3[j]+=corvector[j][i]*arr1[i];//得到组合权重
            }
        }
        System.out.println("****************求组合权重结束****************");

        //打印组合权重
        System.out.println("****************打印组合权重开始****************");
        for(int j=0;j<n;j++)
        {
            System.out.println(arr3[j]);
        }
        System.out.println("****************打印组合权重结束****************");
    }
}
