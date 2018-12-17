package com.wx.assigntask.controller;


import com.wx.assigntask.dao.DividedMapper;
import com.wx.assigntask.dao.OriginalDataMapper;
import com.wx.assigntask.dao.ReleaseMapper;
import com.wx.assigntask.dao.SubtaskMapper;
import com.wx.assigntask.entity.OriginalData;
import com.wx.assigntask.entity.Release;
import com.wx.assigntask.entity.User;
import com.wx.assigntask.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;


/**
 * @Author: wx
 * @Date: 2018/12/4 17:20
 * @Version 1.0
 */
//证明是controller层并返回json
@Controller
public class UserController {
    //依赖注入
    @Autowired
    UserService userService;

    @Autowired
    ReleaseService releaseService;

    @Autowired
    ReleaseMapper releaseMapper;

    @Autowired
    OriginalDataService originalDataService;

    @Autowired
    DividedService dividedService;

    @Autowired
    SubTaskService subTaskService;


    @PostMapping("loginjudge")
    @ResponseBody
    public String loginJudge(HttpServletRequest request,String username,String password){
        User user = userService.findUserByUserName(username);
        if (user.getPassword().equals(password)){
            HttpSession session = request.getSession();

            session.setAttribute("currentUser",user);

            return "OK";
        }
        else {
            return "用户名或密码错误";
        }

    }

    @RequestMapping(value = "/home")
    public String home( HttpSession httpSession){
//        User user = (User) httpSession.getAttribute("currentUser");
//        request.setAttribute("userInfo",user);
        return "user/home";
    }

    //返回数据库数据传给jsp
    @RequestMapping(value = "/myreleasetask")
    public String releaseInfo(){
            //TODO
            // 这里写死了

            int releaseId = releaseService.insertRelease("两两对比排除"); //发布即插入
            if (releaseId == -1)
                return "user/myreleasetask";
            else {
                // releaseService.updateIfDivided(releaseId,"yes");
                String ifDivided = releaseMapper.findDivided(releaseId); //判断刚插入的是否分配
                int count = 0; //subtask个数
                List<Integer> subtaskids = new ArrayList<Integer>();
                if (!ifDivided.equals("yes")){
                    //完整步骤是去releaseInput关联表查找本次inputID，再去original_data查找相关数据
                    //目前没有关联表，直接去original_data查找相关数据
                    List inputs = originalDataService.selectAll();
                    for (int i = 0;i<inputs.size();i++){
                        //还没有分配，把releaseID、inputName和相关算法划分写进divided表
                        OriginalData originalData = (OriginalData) inputs.get(i);
                        List itemNames = originalDataService.selectAllItemsNames(originalData.getOid());
                        List itemDes = originalDataService.selectAllItemDes(originalData.getOid());
                        //TODO  这里算法名称已经写死了
                        List algs = new ArrayList();
                        algs.add("lstm");
                        algs.add("nn");
                        algs.add("cnn");
                        algs.add("tfidf");
                        algs.add("doc");
                        algs.add("index");
                        //针对每次input都要进行6种算法的划分以及生成subtask

                        for (int k = 0;k<algs.size()-1;){
                            String alg1 = algs.get(k).toString();
                            String alg2 = algs.get(k+1).toString();
                            int dividedId = dividedService.insertDivided(releaseId,originalData.getName(),alg1,alg2);
                            dividedService.selectAll();
                            //写进divided即划分subtask写进subtask表
                            String diIfDiv = dividedService.findIfDivided(dividedId);

                            if (!diIfDiv.equals("yes") || diIfDiv.isEmpty()){

                                //若没有分配则分配写入subtask
                                for (int j = 0; j<10 ;j++){
                                    String itemName1 = itemNames.get(j).toString();
                                    String itemName2 = itemNames.get(j+10).toString();
                                    String itemDes1 = itemDes.get(j).toString();
                                    String itemDes2 = itemDes.get(j+10).toString();
                                    int subtaskid = subTaskService.insertSubTask(dividedId,itemName1,itemDes1,itemName2,itemDes2);
                                    subtaskids.add(subtaskid);
                                    count++;
                                }
                                dividedService.updataDivided("yes",dividedId);
                            }
                            k = k+2;
                        }
                        int []randoms = getNumber(count);
                        for (int z=0; z<subtaskids.size()&&z<randoms.length;z++){
                            //更新每个subtask的randomNum
                            subTaskService.updateRandom(randoms[z],subtaskids.get(z).intValue());
                        }
                    }
                }
                return  "user/myreleasetask";
            }

//        ReleaseTask releaseTask =releaseService.findReleaseById(1);
//        request.setAttribute("releaseInfos",releaseTask);


    }

    public static int[] getNumber(int total){
        int[] NumberBox = new int[total];           //容器A
        int[] rtnNumber = new int[total];           //容器B

        for (int i = 0; i < total; i++){
            NumberBox[i] = i;     //先把N个数放入容器A中
        }
        int end = total - 1;

        for (int j = 0; j < total; j++){
            int num = new Random().nextInt(end + 1);  //取随机数
            rtnNumber[j] = NumberBox[num];            //把随机数放入容器B
            NumberBox[num] = NumberBox[end];          //把容器A中最后一个数覆盖所取的随机数
            end--;                                    //缩小随机数所取范围
        }
        return rtnNumber;                           //返回int型数组
    }

}
