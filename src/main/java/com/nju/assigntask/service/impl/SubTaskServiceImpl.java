package com.nju.assigntask.service.impl;


import com.nju.assigntask.comment.ItemList;
import com.nju.assigntask.dao.*;
import com.nju.assigntask.entity.*;
import com.nju.assigntask.service.*;
import com.nju.assigntask.tools.*;

import com.nju.assigntask.subtask.BuildTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: wx
 * @Date: 2018/12/9 21:44
 * @Version 1.0
 */
@Service
//@Transactional
public class SubTaskServiceImpl implements SubTaskService {

    @Autowired
    UserService userService;
    @Autowired
    UserReceiveService userReceiveService;
    @Autowired
    OrderListService orderListService;
    @Autowired
    OriginalDataService originalDataService;
    @Autowired
    DividedService dividedService;
    @Autowired
    RecommendService recommendService;
    @Autowired
    AlgResultService algResultService;
    @Autowired
    MyReceiveService myReceiveService;

    @Autowired
    AlgresultMapper algresultMapper;
    @Autowired
    SubtaskMapper subtaskMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserreceiveMapper userreceiveMapper;
    @Autowired
    ReleaseMapper releaseMapper;
    @Autowired
    DividedMapper dividedMapper;
    @Autowired
    ReleasetablesMapper releasetablesMapper;
    @Autowired
    InputsMapper inputsMapper;
    @Autowired
    RecommandMapper recommandMapper;
    @Autowired
    OrderlistMapper orderlistMapper;

    @Autowired
    Constant constant;
    @Autowired
    RandomNum randomNum;
    @Autowired
    GenSubtaskCps genSubtaskCps;
    @Autowired
    HandleData handleData;

    @Autowired
    AHP ahp;

    @Override
    public void geneSubTask(List<Release> releases) {
        //根据releaseID生成subtask
//        List<Release> releases = releaseMapper.selectAllUnComplete(); //所有未完成的项目
//        if (releases.size() == 0) {
//            return;
//        }else {
            for (int i=0;i<releases.size();i++){
                Release release = releases.get(i);
                String ifDivided = releaseMapper.findDivided(release.getReleaseid()); //判断是否分配
                //      Release release = releaseMapper.findReleaseById(releaseId);
                List algs; //待对比的算法名
                if (!ifDivided.equals("yes")) {
                    algs = Arrays.asList(release.getAlgnames().split(",")); //算法名,针对每次input都要进行6种算法的划分以及生成subtask
                }else {
                    algs = algResultService.selectNoFinalAlg(release.getReleaseid()); //获取上一轮胜出的algname
                }
                if (algs.size() > 1) { //若算法数大于1，则需要对比
                    if (release.getPlan().equals(constant.getPLAN_COMPARECOMPLETE())) {
                        //充分对比
                        compareComplete(algs, release);

                    } else if (release.getPlan().equals(constant.getPLAN_SAMELAYER())) {
                        //同层对比
                        compareSameLayer(algs,release);

                    } else if (release.getPlan().equals((constant.getPLAN_AHP()))) {
                        compareAHP(algs,release);
                   //     ahpCompareAlgs(algs,release);
                    }
                }
            }
   //     }
    }

    /**
     * 充分对比
     * @param algs
     * @param release
     */
    public void compareComplete(List algs,Release release){
        while (algs.size()>1){
            //六个算法比五次
            compareAlgs(release.getPlan(),algs,release); //生成某一轮对比任务
            assignTaskToUser(); //将frequency小于设定值得subtask进行分派
            handleData.handleSubtaskData(); //处理subtask表的score
            handleData.handleDividedData(); //处理divided表的score
            handleData.handleAlgResult(); //处理algresult表的score
            if (algs.size() == 2){
                //该项目全部完成
                List<Integer> algResultId = algresultMapper.selectNoFinalIds(release.getReleaseid());
                algResultService.updateIffinal(algResultId.get(algResultId.size()-1),"yes");
                releaseMapper.updateStatus(release.getReleaseid(),constant.getSTATUS_COMPLETE()); //更新release表的status字段为“已完成”
                Algresult algresult = algresultMapper.selectByPrimaryKey(algResultId.get(algResultId.size()-1));
                releaseMapper.updateWinalgname(release.getReleaseid(),algresult.getWinalgname()); //更新release表的winalgname
                return;
            }else {
                algs = algResultService.selectNoFinalAlg(release.getReleaseid()); //获取上一轮胜出的algname
            }
        }
    }

    /**
     * 同层对比
     * @param algs
     * @param release
     */
    public void compareSameLayer(List algs,Release release){

        sameLayer(release.getPlan(), algs, release); //算法内部排序subtask生成分配
        assignTaskToUser();//将frequency小于设定值得subtask进行分派
        handleData.handleSubtaskData(); //处理subtask表的score
        boolean iforder = orderListService.dealData(release); //处理数据，排序插入orderlist表
        if (iforder == true){
            if (algs.size()>1){
//                compareAlgs(release.getPlan(),algs,release);//算法间比较
//                releaseMapper.updateStatus(release.getReleaseid(),constant.getSTATUS_COMPLETE()); //更新release表的status字段为“已完成”
                compareComplete(algs,release);
            }
        }

    }

    /**
     * AHP总接口
     * @param algs
     * @param release
     */
    public void compareAHP(List algs,Release release){
        sameLayer(release.getPlan(), algs, release); //算法内部排序subtask生成分配
        assignTaskToUser();//将frequency小于设定值得subtask进行分派
        handleData.handleSubtaskData(); //处理subtask表的score
        boolean iforder = orderListService.dealData(release); //处理数据，排序插入orderlist表
        if (iforder == true){
            if (algs.size()>1){
                ahpCompareAlgs(algs,release); //各算法间对比
                handleData.handleSubtaskData(); //处理subtask得分
                List<List<double [][]>> discriminantMatrix = ahp.getDiscriminantMatrix(release,algs);//根据subtask得分构造判别矩阵
               if (discriminantMatrix != null){
                   //若判别矩阵已经构造完成
                   List<double[]> comWeight = ahp.getComWeight(discriminantMatrix,algs); //求组合权重
                   String winAgname = handleData.getWinalgName(comWeight,algs); //最优算法名
                   algresultMapper.insertRecordAhp(release.getReleaseid(),winAgname,"yes"); //插入algresu表
                   releaseMapper.updateStatus(release.getReleaseid(),constant.getSTATUS_COMPLETE()); //更新release表的status
               }
               //调用ahp的方法生成组合权重插入数据库，要注意若存在该releaseID的部分inputID，要避免重复插入，处理其他inputID
                //查询数据库，releaseID对应的inputID个数是否和inputs的个数相同，若相同，更新status字段为已完成，
                // 按照releaseID和algname查找，去平均值，最大为最优
            }
        }
    }

    /**
     * AHP算法间对比
     */
    public void ahpCompareAlgs(List algs,Release release){

        String inputTable = releasetablesMapper.findInputTab(release.getReleaseid(),algs.get(0).toString());//查找检索数据源表
        List<Inputs> inputs = inputsMapper.selectAllInput(inputTable);//查找检索数据源
        int dividedId = 0;
        //按照input循环。将某次input获得的推荐结果都对比后，对比下一次input
        for (int k = 0; k < inputs.size(); k++) {
            Inputs input = inputs.get(k); //一次检索内容
        for (int i=0;i<algs.size()-1;i++){
            String algname1 = algs.get(i).toString();
            for (int j=1+1;j<algs.size();j++){
                String algname2 = algs.get(j).toString();

                    dividedId = dividedService.insertDivided(release.getReleaseid(), input.getInputid(), algname1, algname2);//写进divided即划分subtask写进subtask表
                    String diIfDiv = dividedService.findIfDivided(dividedId);
                    if (!diIfDiv.equals("yes") || diIfDiv.isEmpty()) {
                            genSubtaskCps.sameLayerAlg(dividedId,release.getReleaseid(),algname1,algname2,input.getInputid()); //两两算法对比
                        }

                        dividedService.updataDivided("yes", dividedId);
                        updateRandom();//algName1,algName2
                    }
                }
                    updateStatus(release.getReleaseid()); //更新status字段；
       //         algResultService.insertRecord(releaseId,algName1,algName2);
            }
            releaseMapper.updateIfDivided(release.getReleaseid(),"yes"); //更新ifdivided字段
//        algResultService.handleAlgResult();

    }


    //TODO DEV
    @Override
//    将两种算法的十个item两两配对
    public List<ItemList> insertSubTask(List<OriginalData> originalData) {
        String s;
        BuildTask buildTask = new BuildTask();
        String[] s1 = new String[42];
        OriginalData o;
        ItemList ll;
        List<ItemList> list = new ArrayList();
        for(int i = 0;i<100;i++){
            o = originalData.get(i);
            s1 = buildTask.OdataToArray(o);
//            for (String a:s1) {
//                System.out.println(a);
//            }
            for(int n = 0;n<10;n++) {
                for(int m = 0;m<10;m++) {
                    ll = new ItemList();
                    ll.setInputname(s1[0]);
                    ll.setInputdes(s1[1]);
                    ll.setItema(s1[(2*n+2)]);
                    ll.setDesa(s1[(2*n+3)]);
                    ll.setItemb(s1[(2*m+22)]);
                    ll.setDesb(s1[(2*m+23)]);
                    list.add(ll);
                }
            }

        }

//测试看是否生成任务
//        for (ItemList itemList:list){
//            System.out.println(itemList.itema);
//            System.out.println(itemList.itemb);
//        }

        System.out.println("------------------------------------------");
//        for (OriginalData o: originalData) {
//            System.out.println(o.getName()+" "+o.getDes());
//        }
        return list;
    }

//TODO DEV

    @Override
    public void updateRandom() {
        List<Subtask> subtasks = subtaskMapper.selectNullRandomnum();

        int[] randoms = randomNum.getNumber(subtasks.size());
        for (int z = 0; z < subtasks.size() && z < randoms.length; z++) {
            //更新每个subtask的randomNum
            Subtask subtask = subtasks.get(z);
            subtask.setRandomnum(randoms[z]);
            subtaskMapper.updateSubtaskRandom(subtask);

            //todo delete 2019.4.19
//            if (algName1.equals(algName2)){
//                subtaskMapper.updateSubtaskRandom(subtask);
//            }
//            else {
//                if (algName1.equals("lstm") && algName2.equals("nn")) {
//                    //lstm和nn对比
//                    subtaskMapper.updateLstmNnRandom(subtask);
//                } else if (algName1.equals("cnn") && algName2.equals("tfidf")) {
//                    //cnn和tfidf对比
//                    subtaskMapper.updateCnnTfidfRandom(subtask);
//                } else if (algName1.equals("doc") && algName2.equals("index")) {
//                    //doc和index对比
//                    subtaskMapper.updateDocIndexRandom(subtask);
//                }else if ((algName1.equals("lstm") || algName1.equals("nn"))&& (algName2.equals("cnn")||algName2.equals("tfidf"))) {
//                    //第二轮对比，lstm、nn胜出方和cnn、tfidf胜出方对比
//                    subtaskMapper.updateFinal1Random(subtask);
//                }else if ((algName2.equals("cnn") || algName2.equals("tfidf")||algName2.equals("lstm") || algName2.equals("nn"))&& (algName1.equals("doc")||algName1.equals("index"))) {
//                    //第三轮对比，最后的对比
//                    subtaskMapper.updateFinal2Random(subtask);
//                }
//            }
        }
    }

    @Override
    public List<Subtask> selectAllSubTask(String plan,String algName1,String algName2) {
        //返回所有frequency小于5的subtask
        List<Subtask> subtasks = new ArrayList<>();
//        if (plan.equals(constant.getPLAN_COMPARECOMPLETE())){
//            if (algName1.equals("lstm") && algName2.equals("nn")) {
//                //algNum=0对应lstm和nn对比
//                subtasks = subtaskMapper.selectAllLstmNn();
//            } else if (algName1.equals("cnn") && algName2.equals("tfidf")) {
//                //algNum=0对应cnn和tfidf对比
//                subtasks = subtaskMapper.selectAllCnnTfidf();
//            } else if (algName1.equals("doc") && algName2.equals("index")) {
//                //algNum=0对应doc和index对比
//                subtasks = subtaskMapper.selectAllDocIndex();
//            }else if ((algName1.equals("lstm") || algName1.equals("nn"))&& (algName2.equals("cnn")||algName2.equals("tfidf"))) {
//                //第二轮对比，lstm、nn胜出方和cnn、tfidf胜出方对比
//                subtasks = subtaskMapper.selectAllFinal1();
//            }else if ((algName2.equals("cnn") || algName2.equals("tfidf")||algName2.equals("lstm") || algName2.equals("nn"))&& (algName1.equals("doc")||algName1.equals("index"))) {
//                //第三轮对比，最后的对比
//                subtasks = subtaskMapper.selectAllFinal2();
//            }
//        }
//        else if (plan.equals(constant.getPLAN_SAMELAYER())){
            subtasks = subtaskMapper.selectAllSubtask();
     //   }
        return subtasks;
    }

    @Override
    public Subtask selectSubBySubId(int subtaskid,int plan,String algName1,String algName2) {
        Subtask subtask = new Subtask();

//        if (plan == 1){
//            if (algName1.equals("lstm")&&algName2.equals("nn")) {
//                //algNum=0对应lstm和nn对比
//                subtask = subtaskMapper.selectLstmNnBySubid(subtaskid);
//            } else if (algName1.equals("cnn")&&algName2.equals("tfidf")) {
//                //algNum=0对应cnn和tfidf对比
//                subtask = subtaskMapper.selectCnnTfidfBySubid(subtaskid);
//            } else if (algName1.equals("doc")&&algName2.equals("index")) {
//                //algNum=0对应doc和index对比
//                subtask = subtaskMapper.selectDocIndexBySubid(subtaskid);
//            }else if ((algName1.equals("lstm") || algName1.equals("nn"))&& (algName2.equals("cnn")||algName2.equals("tfidf"))) {
//                //第二轮对比，lstm、nn胜出方和cnn、tfidf胜出方对比
//                subtask = subtaskMapper.selectFinal1BySubid(subtaskid);
//            }else if ((algName2.equals("cnn") || algName2.equals("tfidf")||algName2.equals("lstm") || algName2.equals("nn"))&& (algName1.equals("doc")||algName1.equals("index"))) {
//                //第三轮对比，最后的对比
//                subtask = subtaskMapper.selectFinal2BySubid(subtaskid);
//            }
//        }
//        else if (plan == 2){
            subtask = subtaskMapper.selectSubtaskBySubid(subtaskid);
      //  }
        return subtask;
    }

    /**
     * 根据myreceive的subtask_1--subtask_10查询
     * @param myreceive
     * @return
     */
    @Override
    public List<Subtask> selectSubBySubId(Myreceive myreceive) {

            Divided divided = dividedMapper.selectByPrimaryKey(myreceive.getDividedid());
            String algName1 = divided.getAlgname1(); //对比的算法1名称
            String algName2 = divided.getAlgname2(); //对比的算法2名称
            Release release = releaseMapper.findReleaseById(divided.getReleaseid());
            int plan = 0;
            if (release.getPlan().equals(constant.getPLAN_AHP())) {
                plan = 1;
            } else if (release.getPlan().equals(constant.getPLAN_COMPARECOMPLETE())) {
                plan = 2;
            } else if (release.getPlan().equals(constant.getPLAN_SAMELAYER())) {
                plan = 3;
            }
            List<Subtask> subtasks = new ArrayList<>();
            for (int j=1;j<=10;j++){
                //todo 可以list嵌套list,list里再放对象吗，比如List<List> list;list.add(subtask)
                Subtask subtask = new Subtask();
                switch (j){
                    case 1:subtask = selectSubBySubId(myreceive.getSubtaskid_1(),plan,algName1,algName2);break;
                    case 2:subtask = selectSubBySubId(myreceive.getSubtaskid_2(),plan,algName1,algName2);break;
                    case 3:subtask = selectSubBySubId(myreceive.getSubtaskid_3(),plan,algName1,algName2);break;
                    case 4:subtask = selectSubBySubId(myreceive.getSubtaskid_4(),plan,algName1,algName2);break;
                    case 5:subtask = selectSubBySubId(myreceive.getSubtaskid_5(),plan,algName1,algName2);break;
                    case 6:subtask = selectSubBySubId(myreceive.getSubtaskid_6(),plan,algName1,algName2);break;
                    case 7:subtask = selectSubBySubId(myreceive.getSubtaskid_7(),plan,algName1,algName2);break;
                    case 8:subtask = selectSubBySubId(myreceive.getSubtaskid_8(),plan,algName1,algName2);break;
                    case 9:subtask = selectSubBySubId(myreceive.getSubtaskid_9(),plan,algName1,algName2);break;
                    case 10:subtask = selectSubBySubId(myreceive.getSubtaskid_10(),plan,algName1,algName2);break;
                }
                if (subtask == null) {
                    break; //如果该subtask已为空，则说明用户该组任务不足十个，break
                }
                subtasks.add(subtask);
            }

        return subtasks;
    }

//    @Override
//    public void updateFre(String  plan,String algName1,String algName2, Subtask subtask) {
//      //  if (plan.equals(constant.getPLAN_COMPARECOMPLETE())){
//            subtaskMapper.updateFre(subtask);
////        }
////        else {
////            if (algName1.equals("lstm")&&algName2.equals("nn")) {
////                //algNum=0对应lstm和nn对比
////                subtaskMapper.updateFreLstmNn(subtask);
////            } else if (algName1.equals("cnn")&&algName2.equals("tfidf")) {
////                //algNum=0对应cnn和tfidf对比
////                subtaskMapper.updateFreCnnTfidf(subtask);
////            } else if (algName1.equals("doc")&&algName2.equals("index")) {
////                //algNum=0对应doc和index对比
////                subtaskMapper.updateFreDocIndex(subtask);
////            }else if ((algName1.equals("lstm") || algName1.equals("nn"))&& (algName2.equals("cnn")||algName2.equals("tfidf"))) {
////                //第二轮对比，lstm、nn胜出方和cnn、tfidf胜出方对比
////                subtaskMapper.updateFreFinal1(subtask);
////            }else if ((algName2.equals("cnn") || algName2.equals("tfidf")||algName2.equals("lstm") || algName2.equals("nn"))&& (algName1.equals("doc")||algName1.equals("index"))) {
////                //第三轮对比，最后的对比
////                subtaskMapper.updateFreFinal2(subtask);
////            }
// //       }
//    }

//    @Override
//    public int selectSumScore1(int dividedid,int plan,String algName1,String algName2) {
//        int aveScore = 0;
////        if (plan == 1){
////            if (algName1.equals("lstm")&&algName2.equals("nn")) {
////                //对应lstm和nn对比
////                aveScore = subtaskMapper.selectLstmNnSumScore1(dividedid);
////            } else if (algName1.equals("cnn")&&algName2.equals("tfidf")) {
////                //对应cnn和tfidf对比
////                aveScore = subtaskMapper.selectCnnTfidfSumScore1(dividedid);
////            } else if (algName1.equals("doc")&&algName2.equals("index")) {
////                //对应doc和index对比
////                aveScore = subtaskMapper.selectDocIndexSumScore1(dividedid);
////            }else if ((algName1.equals("lstm") || algName1.equals("nn"))&& (algName2.equals("cnn")||algName2.equals("tfidf"))) {
////                //第二轮对比，lstm、nn胜出方和cnn、tfidf胜出方对比
////                aveScore = subtaskMapper.selectFinal1SumScore1(dividedid);
////            }else if ((algName2.equals("cnn") || algName2.equals("tfidf")||algName2.equals("lstm") || algName2.equals("nn"))&& (algName1.equals("doc")||algName1.equals("index"))) {
////                //第三轮对比，最后的对比
////                aveScore = subtaskMapper.selectFinal2SumScore1(dividedid);
////            }
////        }else if (plan == 2){
//            aveScore = subtaskMapper.selectSumScore1(dividedid);
// //       }
//        return aveScore;
//    }
//
//    @Override
//    public int selectSumScore2(int dividedid,int plan,String algName1,String algName2) {
//        int aveScore = 0;
////        if (plan == 1){
////            if (algName1.equals("lstm")&&algName2.equals("nn")) {
////                //对应lstm和nn对比
////                aveScore = subtaskMapper.selectLstmNnSumScore2(dividedid);
////            } else if (algName1.equals("cnn")&&algName2.equals("tfidf")) {
////                //对应cnn和tfidf对比
////                aveScore = subtaskMapper.selectCnnTfidfSumScore2(dividedid);
////            } else if (algName1.equals("doc")&&algName2.equals("index")) {
////                //对应doc和index对比
////                aveScore = subtaskMapper.selectDocIndexSumScore2(dividedid);
////            }else if ((algName1.equals("lstm") || algName1.equals("nn"))&& (algName2.equals("cnn")||algName2.equals("tfidf"))) {
////                //第二轮对比，lstm、nn胜出方和cnn、tfidf胜出方对比
////                aveScore = subtaskMapper.selectFinal1SumScore2(dividedid);
////            }else if ((algName2.equals("cnn") || algName2.equals("tfidf")||algName2.equals("lstm") || algName2.equals("nn"))&& (algName1.equals("doc")||algName1.equals("index"))) {
////                //第三轮对比，最后的对比
////                aveScore = subtaskMapper.selectFinal2SumScore2(dividedid);
////            }
////        } else if (plan == 2){
//            aveScore = subtaskMapper.selectSumScore2(dividedid);
//   //     }
//        return aveScore;
//    }

//    @Override
//    public void updateScore1(int score1,int subtaskid,int plan,String algName1,String algName2) {
//
//        //把从usertask获取的用户打分平均值插入subtask相应ID
//        Subtask subtask = new Subtask();
//        subtask.setScore1(score1);
//        subtask.setSubtaskid(subtaskid);
////        if (plan == 1){
////            if (algName1.equals("lstm")&&algName2.equals("nn")) {
////                //对应lstm和nn对比
////                subtaskMapper.updateLstmNnScore1(subtask);
////            } else if (algName1.equals("cnn")&&algName2.equals("tfidf")) {
////                //对应cnn和tfidf对比
////                subtaskMapper.updateCnnTfiScore1(subtask);
////            } else if (algName1.equals("doc")&&algName2.equals("index")) {
////                //对应doc和index对比
////                subtaskMapper.updateDocIndexScore1(subtask);
////            }else if ((algName1.equals("lstm") || algName1.equals("nn"))&& (algName2.equals("cnn")||algName2.equals("tfidf"))) {
////                //第二轮对比，lstm、nn胜出方和cnn、tfidf胜出方对比
////                subtaskMapper.updateFinal1Score1(subtask);
////            }else if ((algName2.equals("cnn") || algName2.equals("tfidf")||algName2.equals("lstm") || algName2.equals("nn"))&& (algName1.equals("doc")||algName1.equals("index"))) {
////                //第三轮对比，最后的对比
////                subtaskMapper.updateFinal2Score1(subtask);
////            }
////        }else if (plan == 2){
//            subtaskMapper.updateScore1(subtask);
// //       }
//    }

//    @Override
//    public void updateScore2(int score2, int subtaskid,int plan,String algName1,String algName2) {
//        //把从usertask获取的用户打分平均值插入subtask相应ID
//        Subtask subtask = new Subtask();
//        subtask.setScore2(score2);
//        subtask.setSubtaskid(subtaskid);
////        if (plan == 1){
////            if (algName1.equals("lstm")&&algName2.equals("nn")) {
////                //对应lstm和nn对比
////                subtaskMapper.updateLstmNnScore2(subtask);
////            } else if (algName1.equals("cnn")&&algName2.equals("tfidf")) {
////                //对应cnn和tfidf对比
////                subtaskMapper.updateCnnTfiScore2(subtask);
////            } else if (algName1.equals("doc")&&algName2.equals("index")) {
////                //对应doc和index对比
////                subtaskMapper.updateDocIndexScore2(subtask);
////            }else if ((algName1.equals("lstm") || algName1.equals("nn"))&& (algName2.equals("cnn")||algName2.equals("tfidf"))) {
////                //第二轮对比，lstm、nn胜出方和cnn、tfidf胜出方对比
////                subtaskMapper.updateFinal1Score2(subtask);
////            }else if ((algName2.equals("cnn") || algName2.equals("tfidf")||algName2.equals("lstm") || algName2.equals("nn"))&& (algName1.equals("doc")||algName1.equals("index"))) {
////                //第三轮对比，最后的对比
////                subtaskMapper.updateFinal2Score2(subtask);
////            }
////        }else if (plan == 2){
//            subtaskMapper.updateScore2(subtask);
////        }
//    }



    /**
     * 处理usertask表的用户打分，得到subtask表的score
     */
//    @Override
//    public void handleSubtaskData(int plan) {
//        List<Integer> nullScore1Ids = subtaskMapper.selectNullScore1();//从subtask表获取score为null的subtaskid
//        List<Integer> nullScore2Ids = subtaskMapper.selectNullScore2();
//        for (int i=0;i<nullScore1Ids.size();i++){
//            int subtaskid = nullScore1Ids.get(i);
//            Divided divided = dividedMapper.selectByPrimaryKey(subtaskMapper.selectByPrimaryKey(subtaskid).getDividedid());
//            int score1 = userReceiveService.selectAveScore1(subtaskid);//根据subtaskid从usertask表获取score平均值
//            updateScore1(score1,subtaskid,plan,divided.getAlgname1(),divided.getAlgname2());
//        }
//        for (int i=0;i<nullScore2Ids.size();i++){
//            int subtaskid = nullScore2Ids.get(i);
//            Divided divided = dividedMapper.selectByPrimaryKey(subtaskMapper.selectByPrimaryKey(subtaskid).getDividedid());
//            int score2 = userReceiveService.selectAveScore2(subtaskid);//从usertask表获取score平均值
//            updateScore2(score2,subtaskid,plan,divided.getAlgname1(),divided.getAlgname2());
//        }
//    }

//    @Override
//    public void handleSubtaskData(int plan, String algName1, String algName2) {
//        List<Integer> nullScore1Ids = new ArrayList<>();
//        List<Integer> nullScore2Ids =new ArrayList<>();
////        if (algName1.equals("lstm")&&algName2.equals("nn")) {
////            //对应lstm和nn对比
////            nullScore1Ids = subtaskMapper.selectNullLstmNnScore1();//从subtask表获取score为null的subtaskid
////            nullScore2Ids = subtaskMapper.selectNullLstmNnScore2();
////        } else if (algName1.equals("cnn")&&algName2.equals("tfidf")) {
////            //对应cnn和tfidf对比
////            nullScore1Ids = subtaskMapper.selectNullCnnTfiScore1();
////            nullScore2Ids = subtaskMapper.selectNullCnnTfiScore2();
////        } else if (algName1.equals("doc")&&algName2.equals("index")) {
////            //对应doc和index对比
////            nullScore1Ids = subtaskMapper.selectNullDocIndexScore1();
////            nullScore2Ids = subtaskMapper.selectNullDocIndexScore2();
////        }else if ((algName1.equals("lstm") || algName1.equals("nn"))&& (algName2.equals("cnn")||algName2.equals("tfidf"))) {
////            //第二轮对比，lstm、nn胜出方和cnn、tfidf胜出方对比
////            nullScore1Ids = subtaskMapper.selectNullFinal1Score1();
////            nullScore2Ids = subtaskMapper.selectNullFinal1Score2();
////        }else if ((algName2.equals("cnn") || algName2.equals("tfidf")||algName2.equals("lstm") || algName2.equals("nn"))&& (algName1.equals("doc")||algName1.equals("index"))) {
////            //第三轮对比，最后的对比
////            nullScore1Ids = subtaskMapper.selectNullFinal2Score1();
////            nullScore2Ids = subtaskMapper.selectNullFinal2Score2();
////        }
//
//        for (int i=0;i<nullScore1Ids.size();i++){
//            int subtaskid = nullScore1Ids.get(i);
//            int score1 = userReceiveService.selectAveScore1(subtaskid);//根据subtaskid从usertask表获取score平均值
//            updateScore1(score1,subtaskid,plan,algName1,algName2);
//        }
//        for (int i=0;i<nullScore2Ids.size();i++){
//            int subtaskid = nullScore2Ids.get(i);
//            int score2 = userReceiveService.selectAveScore2(subtaskid);//从usertask表获取score平均值
//            updateScore2(score2,subtaskid,plan,algName1,algName2);
//        }
//    }

    /**
     * 处理subtask表的score，得到divided表的score
     */
//    @Override
//    public void handleDividedData(int plan,String algName1,String algName2) {
//        List<Integer> nullScore1Ids = dividedMapper.selectNullScore1();//从divided表获取score为null的dividedid
//        List<Integer> nullScore2Ids = dividedMapper.selectNullScore2();
//        for (int i=0;i<nullScore1Ids.size();i++){
//            int dividedid = nullScore1Ids.get(i);
//            int score1 = selectSumScore1(dividedid,plan,algName1,algName2);//根据subtaskid从usertask表获取score平均值
//            dividedService.updateScore1(score1,dividedid);
//        }
//        for (int i=0;i<nullScore2Ids.size();i++){
//            int dividedid = nullScore1Ids.get(i);
//            int score2 = selectSumScore2(dividedid,plan,algName1,algName2);//从usertask表获取score平均值
//            dividedService.updateScore2(score2,dividedid);
//        }
//    }



    /**
     * 剪枝
     */
    //todo
//    public void prune(String plan,List algs,int releaseId){
//        int subtaskCount = 0;
//        List subtaskids = new ArrayList();
//        for (int k = 0; k < algs.size() - 1; ) {
//            String algName1 = algs.get(k).toString();
//            String algName2 = algs.get(k + 1).toString();
//            updateRandom(algName1, algName2, subtaskCount, subtaskids);
//          //  assignTaskToUser(plan, dividedId, releaseId, algName1, algName2);//分派任务，将userID和subtaskid写进usertask表
//            k = k + 2;
//            handleSubtaskData(plan, algName1, algName2);
//            handleDividedData(plan, algName1, algName2);
//            algResultService.insertRecord(releaseId, algName1, algName2);
//        }
//        releaseMapper.updateIfDivided(releaseId, "yes");
//        algResultService.handleAlgResult();
//        algs = algResultService.selectNoFinalAlg(releaseId,plan); //获取上一轮胜出的algname
//    }

    /**
     * 同层对比、充分对比，算法间对比
     * @param plan
     * @param algs
     * @param release
     * @return
     */
    public int compareAlgs(String plan,List algs,Release release){//两两对比排除
        int dividedId = 0;
        int releaseId = release.getReleaseid();
        for (int k = 0; k < algs.size() - 1; ) {
            String algName1 = algs.get(k).toString();
            String algName2 = algs.get(k + 1).toString();
            if (algName1.equals(algName2)) {
                //该项目全部完成
                List<Integer> algResultId = algresultMapper.selectNoFinalIds(releaseId);
                algResultService.updateIffinal(algResultId.get(0),"yes");
                break;
            }

            String inputTable = releasetablesMapper.findInputTab(releaseId,algName1);//查找检索数据源表
            List<Inputs> inputs = inputsMapper.selectAllInput(inputTable);//查找检索数据源

            //把100次input关于该对比组的subtask都生成并分发
            for (int i = 0; i < inputs.size(); i++) {
                 Inputs input = inputs.get(i); //一次检索内容
                 dividedId = dividedService.insertDivided(releaseId, input.getInputid(), algName1, algName2);//写进divided即划分subtask写进subtask表
                 String diIfDiv = dividedService.findIfDivided(dividedId);
                 if (!diIfDiv.equals("yes") || diIfDiv.isEmpty()) {

                    //充分对比剪枝的items从recommand取，同层对比剪枝从order取,写入subtask
                //     int subtaskCount = 0;
                    if (plan.equals(constant.getPLAN_COMPARECOMPLETE())){
                        genSubtaskCps.compareComplete(dividedId,releaseId,input,algName1,algName2); //两两算法对比
                    }else if (plan.equals(constant.getPLAN_SAMELAYER())){
                        genSubtaskCps.sameLayerAlg(dividedId,releaseId,algName1,algName2,input.getInputid()); //两两算法对比
                    }
//                    //若没有分配则分配
//                     subtaskCount = subTaskCpPlan1(plan,algName1,algName2, subtaskids, dividedId);
                    //TODO
                    //这里subtaskcount只有10，还是重复？或许可以提到input循环外，100次的lstm都生成后再分配
                    dividedService.updataDivided("yes", dividedId);
                    updateRandom();//algName1,algName2
                //    assignTaskToUser(plan,dividedId,releaseId,algName1,algName2);//分派任务，将userID和subtaskid写进usertask表
                }
            }
            //todo
            //插入algresult记录
            k = k + 2;
//            handleSubtaskData(plan,algName1,algName2);
//            handleDividedData(plan,algName1,algName2);
            algResultService.insertRecord(releaseId,algName1,algName2);
        }
        releaseMapper.updateIfDivided(releaseId,"yes"); //更新ifdivided字段
        updateStatus(releaseId); //更新status字段；
//        algResultService.handleAlgResult();
        return dividedId;
    }

    /**
     * 更新项目状态
     * @param releaseid
     */
    @Override
    public void updateStatus(int releaseid) {
        Release release = releaseMapper.findReleaseById(releaseid);
        String releaseStatus = release.getStatus();
        String plan = release.getPlan();
        String resultStatus;

            if (releaseStatus.equals(constant.getSTATUS_UNCOMPLETE())){ //未完成
                if (plan.equals(constant.getPLAN_COMPARECOMPLETE())) { //充分对比剪枝
                    resultStatus = "第1轮剪枝"; //第一轮剪枝
                } else if (plan.equals(constant.getPLAN_SAMELAYER())) { //同层对比
                    resultStatus = constant.getINSIDE_ORDER(); //内部排序中
                }else {  //OriginalAHP
                    resultStatus = "对第1次检索评估";
                }
            }else if (releaseStatus.equals(constant.getINSIDE_ORDER())){
                resultStatus = "第1一轮剪枝";
            }else if ( releaseStatus.equals(constant.getSTATUS_COMPLETE())){ //已完成
                return;
            }else {
                String statusnum = releaseStatus.replaceAll("[^0-9]","");
                int status = Integer.parseInt(statusnum) +1;
                if (plan.equals(constant.getPLAN_COMPARECOMPLETE()) || plan.equals(constant.getPLAN_SAMELAYER())){
                    resultStatus = "第"+status+"轮剪枝";
                }else {
                    resultStatus = "对第" + status + "检索评估";
                }
            }
            releaseMapper.updateStatus(releaseid,resultStatus); //更新status字段
    }

    /**
     * 算法内排序
     * @param plan
     * @param algs
     * @param release
     */
    public void sameLayer(String plan, List algs,Release release){
        //先判断该次发布是否已排序
    //    List intraAlgs = new ArrayList();
   //     intraAlgs.addAll(algs); //参与内部排序的算法
        for (int i=0;i<algs.size();i++){
            String algname = algs.get(i).toString();
            Divided divided = dividedMapper.selectByReleaseAlgs(release.getReleaseid(),algname,algname);
            if (divided == null){
                continue;
            }else if (divided.getOrdered().equals("yes")){
//                intraAlgs.remove(i); //若已有序则不参与内部排序
                algs.remove(i); //若已有序则不参与内部排序
            }
        }

        int releaseid = release.getReleaseid();
            //先纵再横，算法内排序
        for (int k = 0; k < algs.size();k++ ) {
            //把100次input关于该对比组的subtask都生成并分发
            String algName = algs.get(k).toString();
            String inputTable = releasetablesMapper.findInputTab(releaseid,algName);//查找检索数据源表

            List<Inputs> inputs = inputsMapper.selectAllInput(inputTable);//查找检索数据源
            for (int i = 0; i < inputs.size(); i++) {

                Inputs input = inputs.get(i);
                int dividedId = dividedService.insertDivided(releaseid, input.getInputid(), algName, algName);

                //划分subtask写进subtask表
                String diIfDiv = dividedService.findIfDivided(dividedId);
                if (!diIfDiv.equals("yes") || diIfDiv.isEmpty()) {
//                    List<Integer> subtaskids = new ArrayList<Integer>();

                    //若没有分配则先组内排序分配写入subtask
                    genSubtaskCps.intraGroup(algName,releaseid,dividedId,input);
                   // int subtaskCount = intraGroup(plan,itemNames, itemDes, algName, subtaskids, dividedId);//subtask个数
                    dividedService.updataDivided("yes", dividedId);
                    //TODO
                    //这里subtaskcount只有45，可能还是重复？或许可以提到input循环外，100次的lstm都生成后再分配
                    updateRandom();//algName,algName
        //            assignTaskToUser(plan,dividedId,releaseId,algName,algName);//分派任务，将userID和subtaskid写进usertask表
                }
            }
        }
    }


//    public int subTaskCp(int plan, String algName1,String algName2, List subtaskids, int dividedId) {
//         int subtaskCount = 0;
//         if (plan == 1){
//             for (int j = 2; j < itemNames1.size(); j++) {
//                 //A1对B1-B10，A1不变，B变
//                 for (int z = 2; z < itemNames2.size(); z++) {
//                     String itemName1 = itemNames1.get(j).toString();
//                     String itemName2 = itemNames2.get(z).toString();
//                     String itemDes1 = itemDess1.get(j).toString();
//                     String itemDes2 = itemDess2.get(z).toString();
//                     //插入subtask
//                     int subtaskid = insertSubTask(plan,algName1,algName2,dividedId, itemName1, itemDes1, itemName2, itemDes2);
//                     subtaskids.add(subtaskid);
//                     subtaskCount++;
//                 }
//             }
//         }
//         else if (plan == 2){
//             for (int i = 0;i<itemNames1.size();i++){
//                 String itemName1 = itemNames1.get(i).toString();
//                 String itemName2 = itemNames2.get(i).toString();
//                 String itemDes1 = itemDess1.get(i).toString();
//                 String itemDes2 = itemDess2.get(i).toString();
//                 //插入subtask
//                 int subtaskid = insertSubTask(plan,algName1,algName2,dividedId, itemName1, itemDes1, itemName2, itemDes2);
//                 subtaskids.add(subtaskid);
//                 subtaskCount++;
//             }
//         }
//        return subtaskCount;
//    }

//    public int intraGroup(String plan,List itemNames, List itemDes, String algName, List subtaskids, int dividedId) {
//        System.out.println("生成算法内排序子任务 :"+Class.class.getName());
//        int subtaskCount = 0; //subtask个数
//        //算法内部排序
//        for (int j = 2; j < 12; j++) {
//            //A1对A2-A10
//            for (int z = j+1; z < 12; z++) {
//                String itemName1 = itemNames.get(j).toString();
//                String itemName2 = itemNames.get(z).toString();
//                String itemDes1 = itemDes.get(j).toString();
//                String itemDes2 = itemDes.get(z).toString();
//
//                //插入subtask
//                int subtaskid = insertSubTask(plan,algName,algName, dividedId, itemName1, itemDes1, itemName2, itemDes2);
//                subtaskids.add(subtaskid);
//                subtaskCount++;
//            }
//        }
//        return subtaskCount;
//    }


//    @Override
//    public int insertSubTask(String plan,String algName1,String algName2, int dividedId, String itemName1, String itemDes1, String itemName2, String itemDes2) {
//        Subtask subtask = new Subtask();
//        subtask.setDividedid(dividedId);
//        subtask.setItemname1(itemName1);
//        subtask.setItemdes1(itemDes1);
//        subtask.setItemname2(itemName2);
//        subtask.setItemdes2(itemDes2);
////        if (plan.equals(constant.getPLAN_COMPARECOMPLETE())){
////            if (algName1.equals("lstm") && algName2.equals("nn")) {
////                //lstm和nn对比
////                subtaskMapper.inserToLstmNn(subtask);
////            } else if (algName1.equals("cnn") && algName2.equals("tfidf")) {
////                //cnn和tfidf对比
////                subtaskMapper.insertToCnnTfidf(subtask);
////            } else if (algName1.equals("doc") && algName2.equals("index")) {
////                //doc和index对比
////                subtaskMapper.insertToDocIndex(subtask);
////            }else if ((algName1.equals("lstm") || algName1.equals("nn"))&& (algName2.equals("cnn")||algName2.equals("tfidf"))) {
////                //第二轮对比，lstm、nn胜出方和cnn、tfidf胜出方对比
////                subtaskMapper.insertToFinal1(subtask);
////            }else if ((algName2.equals("cnn") || algName2.equals("tfidf")||algName2.equals("lstm") || algName2.equals("nn"))&& (algName1.equals("doc")||algName1.equals("index"))) {
////                //第三轮对比，最后的对比
////                subtaskMapper.insertToFinal2(subtask);
////            }
////        }
////        else if (plan.equals(constant.getPLAN_SAMELAYER())){
//            subtaskMapper.insertSubtask(dividedId,itemName1,itemDes1,itemName2,itemDes2);
// //       }
//
//        int subtaskid = subtask.getSubtaskid();
//        return subtaskid;
//    }



    public void assignTaskToUser() {
        List<Integer> userIDs = userService.selectAllId(); //所有用户ID

        //根据algs存放顺序分配
        List<Subtask> subtasks = subtaskMapper.selectAssignSubtask(constant.getSUBTASK_FRE()); //所有frequency小于设定值的subtask
        if (subtasks.size() > 0) {
            int userCount = 0;//用来记录用户ID移动
            int taskCount = 0;//记录subtask的移动
            while (userCount < userIDs.size() && taskCount < subtasks.size()) {
                //分配任务插入对应的usertask表
      //          Userreceive userreceive = new Userreceive();
                int userId = userIDs.get(userCount);

                Divided divided = new Divided();
                List<Integer> userOnceJob = new ArrayList<>(); //存储用户一次任务，即10个subtask一组，不足10个仍为一组
                while (userMapper.findUserById(userId).getTasking() >= constant.getUSER_TASKING()) {
                    // 判断当前用户的tasking是否小于3selectAllSubTask(plan,algNum);
                    userCount++;
                    if (userCount >= userIDs.size()) {
                        //如果用户都做满了3组任务，那么重新生成新的用户
                        userIDs = userService.selectAllId();
                        userCount = 0;
                    }
                    userId = userIDs.get(userCount);
                }
                int userTaskCount = 0;
                for (int i = 0; i < constant.getTASK_COUNT(); i++) {
                    //先保证每个用户分到了10个subtask
                    Subtask subtask = subtasks.get(taskCount);
                    divided = dividedMapper.selectByPrimaryKey(subtask.getDividedid());
                    if (subtask.getFrequency() >= constant.getSUBTASK_FRE()) {
                        //TODO
                        //最先进来的应该是random=0的subtask，若random=0的fre=5，说明剩下的都达到了5，直接break
                        if (taskCount == 0) break;
//                            else {
//                                while (subtask.getFrequency() >= 5){
//                                    taskCount++;
//                                    if (taskCount >= subtasks.size()){
//                                        //如果每个subtask都被分配一遍，重新获取分配频率小于5的subtask
//                                        subtasks = selectAllSubTask(plan,algName1,algName2);
//                                        if (subtasks.size()>0){
//                                            taskCount = 0;
//                                            subtask = subtasks.get(taskCount);
//                                        }
//                                        else break;
//                                    }
//                                    else {
//                                        subtask = subtasks.get(taskCount);
//                                    }
//                                }
//                                }
                    }
                    int subTaskId = subtask.getSubtaskid();
                    userreceiveMapper.insertSubTask(userId,subTaskId,subtask.getDividedid());
                    userOnceJob.add(subTaskId);
                    userTaskCount++;
                    subtask.setFrequency(subtask.getFrequency() + 1);//修改subtask的frequency
                    subtaskMapper.updateFre(subTaskId,subtask.getFrequency());//修改subtask的frequency
                    if (taskCount + 1 >= subtasks.size()) {
                        taskCount = -1;
                    }
                    taskCount++;
                }
                if (userTaskCount == 0) break;  //userTaskCount=10，说明已经不分配任务了
                else if (userTaskCount <= 10) {
                    myReceiveService.insertRecord(userOnceJob,userId,divided.getReleaseid(),divided.getDividedid()); //插入一个用户的一次任务（10个subtask）
                    userMapper.updateTaking(userId, userMapper.findUserById(userId).getTasking() + 1);//用户目前任务+1
                    if (userCount + 1 >= userIDs.size() && taskCount < subtasks.size()) {
                        //当用户都分配过一次，subtask还没分配完，就将用户从头再分配一次
                        userCount = -1;
                    }
                    userCount++;
                }
            }
        }
    }
}
