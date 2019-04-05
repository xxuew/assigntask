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
        String[] s = new String[122];
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

        s[42] = o.getCnnName1();
        s[43] = o.getCnnDes1();
        s[44] = o.getCnnName2();
        s[45] = o.getCnnDes2();
        s[46] = o.getCnnName3();
        s[47] = o.getCnnDes3();
        s[48] = o.getCnnName4();
        s[49] = o.getCnnDes4();
        s[40] = o.getCnnName5();
        s[51] = o.getCnnDes5();
        s[52] = o.getCnnName6();
        s[53] = o.getCnnDes6();
        s[54] = o.getCnnName7();
        s[55] = o.getCnnDes7();
        s[56] = o.getCnnName8();
        s[57] = o.getCnnDes8();
        s[58] = o.getCnnName9();
        s[59] = o.getCnnDes9();
        s[60] = o.getCnnName10();
        s[61] = o.getCnnDes10();

        s[62] = o.getTfidfName1();
        s[63] = o.getTfidfDes1();
        s[64] = o.getTfidfName2();
        s[65] = o.getTfidfDes2();
        s[66] = o.getTfidfName3();
        s[67] = o.getTfidfDes3();
        s[68] = o.getTfidfName4();
        s[69] = o.getTfidfDes4();
        s[70] = o.getTfidfName5();
        s[71] = o.getTfidfDes5();
        s[72] = o.getTfidfName6();
        s[73] = o.getTfidfDes6();
        s[74] = o.getTfidfName7();
        s[75] = o.getTfidfDes7();
        s[76] = o.getTfidfName8();
        s[77] = o.getTfidfDes8();
        s[78] = o.getTfidfName9();
        s[79] = o.getTfidfDes9();
        s[80] = o.getTfidfName10();
        s[81] = o.getTfidfDes10();

        s[82] = o.getDocName1();
        s[83] = o.getDocDes1();
        s[84] = o.getDocName2();
        s[85] = o.getDocDes2();
        s[86] = o.getDocName3();
        s[87] = o.getDocDes3();
        s[88] = o.getDocName4();
        s[89] = o.getDocDes4();
        s[90] = o.getDocName5();
        s[91] = o.getDocDes5();
        s[92] = o.getDocName6();
        s[93] = o.getDocDes6();
        s[94] = o.getDocName7();
        s[95] = o.getDocDes7();
        s[96] = o.getDocName8();
        s[97] = o.getDocDes8();
        s[98] = o.getDocName9();
        s[99] = o.getDocDes9();
        s[100] = o.getDocName10();
        s[101] = o.getDocDes10();

        s[102] = o.getIndexName1();
        s[103] = o.getIndexDes1();
        s[104] = o.getIndexName2();
        s[105] = o.getIndexDes2();
        s[106] = o.getIndexName3();
        s[107] = o.getIndexDes3();
        s[108] = o.getIndexName4();
        s[109] = o.getIndexDes4();
        s[110] = o.getIndexName5();
        s[111] = o.getIndexDes5();
        s[112] = o.getIndexName6();
        s[113] = o.getIndexDes6();
        s[114] = o.getIndexName7();
        s[115] = o.getIndexDes7();
        s[116] = o.getIndexName8();
        s[117] = o.getIndexDes8();
        s[118] = o.getIndexName9();
        s[119] = o.getIndexDes9();
        s[120] = o.getIndexName10();
        s[121] = o.getIndexDes10();
        return s;
    }



}
