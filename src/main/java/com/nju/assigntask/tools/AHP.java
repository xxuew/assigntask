package com.nju.assigntask.tools;

import com.nju.assigntask.dao.*;
import com.nju.assigntask.entity.Divided;
import com.nju.assigntask.entity.Inputs;
import com.nju.assigntask.entity.Recommend;
import com.nju.assigntask.entity.Release;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author:wx
 * @Date:Created in 19:21 2019/3/12
 * @Modified by:
 */
@Component
public class AHP {

    @Autowired
    DividedMapper dividedMapper;
    @Autowired
    ReleasetablesMapper releasetablesMapper;
    @Autowired
    InputsMapper inputsMapper;
    @Autowired
    RecommandMapper recommandMapper;
    @Autowired
    SubtaskMapper subtaskMapper;

    @Autowired
    HandleData handleData;

//    static int n;//矩阵的阶数
    double cal[][];//层次比较矩阵,归一化后的
    double cal1[][];//层次比较矩阵
    static HashMap RI = null;//将12阶的成对比较矩阵的平均随机一致性指标值保存在哈希映射表里



//    public int getN() {
//        return n;
//    }
//
//    public void setN(int n) {
//        this.n = n;
//    }

    //原始成对比较矩阵列向量的归一化
    public void colNormalize(double matrix[][])//列向量的归一化
    {
        double arr[] = new double[matrix[0].length];
 //       System.out.println("*****************每列求加和开始*****************");
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix[0].length; i++) {
                arr[j] += matrix[i][j];//每列求加和
            }
        }
//        System.out.println("*****************每列求加和完毕*****************");


//        System.out.println("*****************列向量归一化开始*****************");
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix[0].length; i++) {
                cal[i][j] = cal[i][j] / arr[j];//列向量归一化
            }
        }
 //       System.out.println("*****************列向量归一化完毕*****************");

    }

    //得到归一化矩阵各行的行和
    public double[] rowNormalize(double matrix[][])//按行求和,并返回求得的数组
    {
        double arr1[] = new double[matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix[0].length; i++) {
                arr1[j] += matrix[j][i];//每行求加和
            }
        }
        //以下对arr1[]进行归一化
        double sum = 0;

        for (int i = 0; i < matrix[0].length; i++) {
            sum += arr1[i];
        }
//        System.out.println("*****************向量归一化计算开始*****************");
        for (int i = 0; i < matrix[0].length; i++)//得到权重
        {
            arr1[i] = arr1[i] / sum;
        }
//        System.out.println("*****************向量归一化计算结束*****************");

        return arr1;
    }

//    //求最大特征值
//    public double getMaxLamta(double arr1[],double martrix[][]) {
//        double arr2[] = new double[n];
//        for (int j = 0; j < n; j++) {
//            for (int i = 0; i < n; i++) {
//                arr2[j] += martrix[j][i] * arr1[i];//得到A*w
//            }
//        }

//        double L = 0;//5*maxLamta
//        for (int i = 0; i < n; i++) {
//            L += arr2[i] / arr1[i];
//        }
//        double maxLamta = L / n;
//        return maxLamta;
//    }

    /**
     * 构造判别矩阵
     */
    public  List<List<double[][]>> getDiscriminantMatrix(Release release, List algs){
        String inputTable = releasetablesMapper.findInputTab(release.getReleaseid(),algs.get(0).toString());//查找检索数据源表
        List<Inputs> inputs = inputsMapper.selectAllInput(inputTable);//查找检索数据源
        String tableName1 = releasetablesMapper.findRecoTab(release.getReleaseid(),algs.get(0).toString()); //查找该算法对应的数据源表名
        List<List<double[][]>> result = new ArrayList<>(); //多个input的矩阵

        for (int j=0;j<inputs.size();j++){
            Inputs input = inputs.get(j);
            List<Recommend> recommendList = recommandMapper.selectByInputid(tableName1,input.getInputid()); //算法对应的所有推荐结果try{
            List<double[][]> inputresult = new ArrayList<>();//一个input措施层至准则层有L个矩阵（L=推荐结果数）

            double[][] ceriResult =new double[recommendList.size()][recommendList.size()]; //措施层至某一个准则层的判别矩阵
            for (int i = 0;i<algs.size();i++){
                //每个矩阵中的算法A:算法A=1
                ceriResult[i][i] = 1;
            }
            for (int i=0;i<recommendList.size();i++){
                //一个input有L个矩阵
                inputresult.add(ceriResult);
            }

            //根据算法名查找相应的divided
            for (int i=0;i<algs.size()-1;i++) {
                String algname1 = algs.get(i).toString();
                for (int k = 1 + 1; k < algs.size(); k++) {
                    String algname2 = algs.get(k).toString();
                    //该releaseID对应的inputID相关的divided对比组
                    Divided divided = dividedMapper.selectByReelaseid(release.getReleaseid(),input.getInputid(),algname1,algname2);
                    List<Double> score1 = subtaskMapper.selectScore1ByDividedid(divided.getDividedid());
                    List<Double> score2 = subtaskMapper.selectScore2ByDividedid(divided.getDividedid());
                    boolean ifhandleScore1 = handleData.judgeIfHandle(score1);
                    boolean ifhandleScore2 = handleData.judgeIfHandle(score2);
                    if (ifhandleScore1 ==true && ifhandleScore2 == true){
                        for (int z=0;z<score1.size();z++){
                            inputresult.get(z)[i][k] = score1.get(z)/score2.get(z); //algname1的第Z名与algname2的第Z名相对重要性
                        }
                    }else {
                        return null;
                    }
                }
            }
            result.add(inputresult);
        }
    return result;
    }

    /**
     * 求取权向量，考虑不通过一致性检验需要重新生成子任务，此处没有进行一致性检验
     * @param matrix
     * @return
     */
    public  double[] calAHP(double matrix[][]) {
        double CI, maxLamta, RI, CR;
        RI = getRI(matrix[0].length);
        colNormalize(matrix);//列归一化
        double sinLayWeight[] = rowNormalize(matrix); //行归一化，返回值为各准则权重
        return sinLayWeight;
//        maxLamta = getMaxLamta(sinLayWeight,matrix); //最大特征值
//        CI = (maxLamta - matrix[0].length) / (matrix[0].length - 1);
//        CR = CI / RI;
//        if (CR < 0.1) { //检验一致性
//            return sinLayWeight;
//        } else {
//           return new double[1];
//        }


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

    /**
     * 获取组合权重，即措施层相对目标层权重,有多次input
     * @param subCriterionMatrixs，措施层相对准则层判别矩阵
     * @return
     */
    public List<double[]> getComWeight( List<List<double[][]>> subCriterionMatrixs, List algs) {
        double[][] criterionMatrix = getCriterionMatrix();//准则层相对目标层判别矩阵
        double[] criterionWeight = calAHP(criterionMatrix);
        List<double[]> resultWeight = new ArrayList<>();

        for (int k =0;k<subCriterionMatrixs.size();k++){
            double[] inputWeight = new double[algs.size()];
            List<double[][]> subCriterionMatrix = subCriterionMatrixs.get(k);
            List<double[]> subCriterionWeight = new ArrayList<>();
            for (int i = 0; i < subCriterionMatrix.size(); i++) {
                subCriterionWeight.add(calAHP(subCriterionMatrix.get(i)));
            }
            for (int i = 0; i < algs.size(); i++) {
                double algWeight = 0;
                for (int j = 0; j < subCriterionMatrix.size(); j++) {
                    algWeight = algWeight + criterionWeight[j] * subCriterionWeight.get(j)[i];
                }
                //todo 插入weight表，releaseid,inputid,algname,weight

                inputWeight[i] = algWeight;
            }
            resultWeight.add(inputWeight);
        }
        return resultWeight;
    }

    /**
     * 准则层权重，目前默认推荐结果有10个，因此只构造了阶数为10的判别矩阵
     * @return
     */
    public double[][] getCriterionMatrix(){
        double[][] criterionWeight = {{1,2,3,4,5,6,7,8,9,9},
                {1/2,1,2,3,4,5,6,7,8,9},
                {1/3,1/2,1,2,3,4,5,6,7,8},
                {1/4,1/3,1/2,1,2,3,4,5,6,7},
                {1/5,1/4,1/3,1/2,1,2,3,4,5,6},
                {1/6,1/5,1/4,1/3,1/2,1,2,3,4,5},
                {1/7,1/6,1/5,1/4,1/3,1/2,1,2,3,4},
                {1/8,1/7,1/6,1/5,1/4,1/3,1/2,1,2,3},
                {1/9,1/8,1/7,1/6,1/5,1/4,1/3,1/2,1,2},
                {1/9,1/9,1/8,1/7,1/6,1/5,1/4,1/3,1/2,1}};

        return criterionWeight;
    }
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
}
