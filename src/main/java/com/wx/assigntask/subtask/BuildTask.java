package com.wx.assigntask.subtask;

import com.wx.assigntask.dao.SubtaskMapper;
import com.wx.assigntask.entity.Subtask;
import com.wx.assigntask.service.SubTaskService;
import com.wx.assigntask.service.UserService;

import java.util.List;
import java.util.Random;

public class BuildTask {

    public static void main(String[] args) {
        BuildTask buildTask = new BuildTask();
//        buildTask.ramdom();
        buildTask.findAll();
    }
    public void BuildTask(){}

    public int[] ramdom(){
        int[] arr = new int[10000];
        for (int i = 0; i < 10000; i++) {
            arr[i] = i + 1;
        }

        for (int i = 0; i < 10000; i++) {
            int num = new Random().nextInt(10000);
            int temp = arr[num];
            arr[num] = arr[i];
            arr[i] = temp;
            System.out.println(arr[i]);
        }
        return arr;
    }

    SubTaskService subTaskService;
    public String findAll() {

        System.out.println("PageController:page()");
        Subtask list = subTaskService.findSubBySubId(1);
        System.out.println(list.getItemname1()+" "+list.getItemname2());


        return "listall";
    }

}
