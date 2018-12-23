package com.wx.assigntask.subtask;

import com.wx.assigntask.dao.OriginalDataMapper;
import com.wx.assigntask.dao.SubtaskMapper;
import com.wx.assigntask.entity.OriginalData;
import com.wx.assigntask.entity.Subtask;
import com.wx.assigntask.service.OriginalDataService;
import com.wx.assigntask.service.SubTaskService;
import com.wx.assigntask.service.UserService;
import com.wx.assigntask.service.impl.OriginalDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

public class BuildTask {

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

    public String[] OdataToArray(OriginalData o){
        String[] s = new String[42];
        s[0] = (String)o.getName();
        s[1] = o.getDes();
        s[2] = o.getLstmName1();
        s[3] = o.getLstmDes1();
        s[4] = o.getLstmName2();
        s[5] = o.getLstmDes2();
        s[6] = o.getLstmName3();
        s[7] = o.getLstmDes3();
        s[8] = o.getLstmName4();
        s[9] = o.getLstmDes4();
        s[10] = o.getLstmName5();
        s[11] = o.getLstmDes5();
        s[12] = o.getLstmName6();
        s[13] = o.getLstmDes6();
        s[14] = o.getLstmName7();
        s[15] = o.getLstmDes7();
        s[16] = o.getLstmName8();
        s[17] = o.getLstmDes8();
        s[18] = o.getLstmName9();
        s[19] = o.getLstmDes9();
        s[20] = o.getLstmName10();
        s[21] = o.getLstmDes10();
        s[22] = o.getNnName1();
        s[23] = o.getNnDes1();
        s[24] = o.getNnName2();
        s[25] = o.getNnDes2();
        s[26] = o.getNnName3();
        s[27] = o.getNnDes3();
        s[28] = o.getNnName4();
        s[29] = o.getNnDes4();
        s[30] = o.getNnName5();
        s[31] = o.getNnDes5();
        s[32] = o.getNnName6();
        s[33] = o.getNnDes6();
        s[34] = o.getNnName7();
        s[35] = o.getNnDes7();
        s[36] = o.getNnName8();
        s[37] = o.getNnDes8();
        s[38] = o.getNnName9();
        s[39] = o.getNnDes9();
        s[40] = o.getNnName10();
        s[41] = o.getNnDes10();
        return s;
    }



}
