package com.wx.assigntask.service.impl;

import com.wx.assigntask.comment.ItemList;
import com.wx.assigntask.dao.SubtaskAhpMapper;
import com.wx.assigntask.dao.UserMapper;
import com.wx.assigntask.entity.SubtaskAhp;
import com.wx.assigntask.entity.OriginalData;
import com.wx.assigntask.entity.User;
import com.wx.assigntask.service.IAHPService;
import com.wx.assigntask.service.IOriginalDataService;
import com.wx.assigntask.subtask.BuildTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Service
public class AHPServiceImpl implements IAHPService {
    @Autowired
    IOriginalDataService originalDataService;
    @Autowired
    SubtaskAhpMapper ahpSubtaskMapper;
    @Autowired
    UserMapper userMapper;

    private int count = 0;
//未乱序分配，后面将subtaskId换成randomNum
//    若用户已经分配了任务则不再分配
    @Override
    public List<ItemList> assignTask(User user) {
        List<ItemList> list = new ArrayList<>();
        System.out.println("-----------count------------");
        System.out.println(count);
//        生成任务，将用户id写入任务数据表表
        int uid = user.getUser_id();
        for(int i = 0;i<10;i++) {
            ItemList itemList = new ItemList();
            count++;
//            将分配的任务id写入用户数据表
            if (i == 0) {
                user.setReceived_id(count);
                user.setAlgo_id(5);
                userMapper.updateUser(user);
            }
            SubtaskAhp ahpSubtask = ahpSubtaskMapper.selectByPrimaryKey(count);
//            id表示任务分配给了谁
            ahpSubtask.setDividedid(uid);
            ahpSubtaskMapper.updateByPrimaryKey(ahpSubtask);
            itemList.setId(ahpSubtask.getSubtaskid());
            itemList.setInputname(ahpSubtask.getInputname());
            itemList.setInputdes(ahpSubtask.getInputdes());
            itemList.setItema(ahpSubtask.getItemname1());
            itemList.setDesa(ahpSubtask.getItemdes1());
            itemList.setItemb(ahpSubtask.getItemname2());
            itemList.setDesb(ahpSubtask.getItemdes2());
            list.add(itemList);
        }
        return list;
    }

//存数数据，并重置received_id
    @Override
    public void StoreData(User user,List<ItemList> lists){
        int received_id = user.getReceived_id();
        for(int i = 0;i<10;i++){
            if(i != 0){
                received_id++;
            }
            SubtaskAhp ahpSubtask = ahpSubtaskMapper.selectByPrimaryKey(received_id);
            ahpSubtask.setScore1((float) lists.get(i).getScorea());
            ahpSubtask.setScore2((float)lists.get(i).getScoreb());
            ahpSubtaskMapper.updateByPrimaryKey(ahpSubtask);
        }
        user.setReceived_id(0);
        user.setAlgo_id(0);
        userMapper.updateUser(user);
    }



    @Override
//    创建任务并存入到数据库
    public List<ItemList> CreatTask() {
        String s;
        List<OriginalData> originalData = originalDataService.selectAll();
        BuildTask buildTask = new BuildTask();
        String[] s1 = new String[42];
        OriginalData o;
        ItemList ll;
        List<ItemList> list = new ArrayList();
        for(int i = 0;i<100;i++){
            o = originalData.get(i);
            s1 = buildTask.OdataToArray(o);
            for(int j = 0;j<10;j++) {
                for(int m = 0;m<5;m++) {
                    for (int n = m;n<5;n++){
                        ll = new ItemList();
                        ll.setInputname(s1[0]);
                        ll.setInputdes(s1[1]);
                        ll.setItema(s1[(20*m+2+2*j)]);
                        ll.setDesa(s1[(20*m+3+2*j)]);
                        ll.setItemb(s1[(20*n+22+2*j)]);
                        ll.setDesb(s1[(20*n+23+2*j)]);
                        list.add(ll);
                    }
                }
            }

        }

//        生成一次就可以了，很耗时间
        int count = 1;
//        for (ItemList i: list) {
//            AhpSubtask as = new AhpSubtask();
////            as.setSubtaskid(count);
//            as.setInputname(i.inputname);
//            as.setInputdes1(i.inputdes);
//            as.setItemname1(i.itema);
//            as.setItemdes1(i.desa);
//            as.setItemname2(i.itemb);
//            as.setItemdes2(i.desb);
//            ahpSubtaskMapper.insert(as);
////            count++;
//        }


        System.out.println();
        return list;
    }


//    public static void main(String[] args) {
//
//        /** a为N*N矩阵 */
//        double[][] a = new double[][] { { 1 ,1.8, 2.2, 1 },
//                { 0.6, 1, 3, 1.7 },
//                { 0.4 ,0.3, 1 ,0.5 }, {  1 ,0.5, 2, 1 }
//        };
//        //
//        int N = a[0].length;
//        double[] weight = new double[N];
//        AHPServiceImpl instance = AHPServiceImpl.getInstance();
//        instance.weight(a, weight, N);
//        System.out.println(Arrays.toString(weight));
//    }

    // 单例
    private static final AHPServiceImpl acw = new AHPServiceImpl();

    // 平均随机一致性指针
    private double[] RI = { 0.00, 0.00, 0.58, 0.90, 1.12, 1.21, 1.32, 1.41,
            1.45, 1.49 };

    // 随机一致性比率
    private double CR = 0.0;

    // 最大特征值
    private double lamta = 0.0;

    /**
     * 私有构造
     */
    private AHPServiceImpl() {

    }

    /**
     * 返回单例
     *
     * @return
     */
    public static AHPServiceImpl getInstance() {
        return acw;
    }

    /**
     * 计算权重
     *
     * @param a 数组
     * @param weight
     * @param N
     */
    public void weight(double[][] a, double[] weight, int N) {
        // 初始向量Wk
        double[] w0 = new double[N];
        for (int i = 0; i < N; i++) {
            w0[i] = 1.0 / N;
        }

        // 一般向量W（k+1）
        double[] w1 = new double[N];

        // W（k+1）的归一化向量
        double[] w2 = new double[N];

        double sum = 1.0;

        double d = 1.0;

        // 误差
        double delt = 0.00001;

        while (d > delt) {
            d = 0.0;
            sum = 0;

            // 获取向量
            //int index = 0;
            for (int j = 0; j < N; j++) {
                double t = 0.0;
                for (int l = 0; l < N; l++)
                    t += a[j][l] * w0[l];
                // w1[j] = a[j][0] * w0[0] + a[j][1] * w0[1] + a[j][2] * w0[2];
                w1[j] = t;
                sum += w1[j];
            }

            // 向量归一化
            for (int k = 0; k < N; k++) {
                w2[k] = w1[k] / sum;

                // 最大差值
                d = Math.max(Math.abs(w2[k] - w0[k]), d);

                // 用于下次迭代使用
                w0[k] = w2[k];
            }
        }

        // 计算矩阵最大特征值lamta，CI，RI
        lamta = 0.0;

        for (int k = 0; k < N; k++) {
            lamta += w1[k] / (N * w0[k]);
        }

        double CI = (lamta - N) / (N - 1);

        if (RI[N - 1] != 0) {
            CR = CI / RI[N - 1];
        }

        // 四舍五入处理
        lamta = round(lamta, 3);
        CI = round(CI, 3);
        CR = round(CR, 3);

        for (int i = 0; i < N; i++) {
            w0[i] = round(w0[i], 4);
            w1[i] = round(w1[i], 4);
            w2[i] = round(w2[i], 4);
        }
        // 控制台打印输出

        System.out.println("lamta=" + lamta);
        System.out.println("CI=" + CI);
        System.out.println("CR=" + CR);

        // 控制台打印第一次归一化权重
        System.out.print("w0[]=");
        for (int i = 0; i < N; i++) {
            System.out.print(w0[i] + " ");
        }
        System.out.println("");

        System.out.print("w1[]=");
        for (int i = 0; i < N; i++) {
            System.out.print(w1[i] + " ");
        }
        System.out.println("");

        System.out.print("w2[]=");
        for (int i = 0; i < N; i++) {
            weight[i] = w2[i];
            System.out.print(w2[i] + " ");
        }
        System.out.println("");
    }

    /**
     * 四舍五入
     *
     * @param v
     * @param scale
     * @return
     */
    public double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 返回随机一致性比率
     *
     * @return
     */
    public double getCR() {
        return CR;
    }


}
