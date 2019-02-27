package com.wx.assigntask.tools;

/**
 * @Author:wx
 * @Date:Created in 10:53 2019/2/25
 * @Modified by:
 */

import org.springframework.stereotype.Component;

/**
 * 用来保存一些常量
 */
@Component
public class Constant {
    String PLAN1 = "两两对比排除";
    String PLAN2 = "先纵再横，算法内排序";
    String PLAN3 = "层次分析法";
    int USER_TASKING = 3;//用户未完成任务只能有三个
    int SUBTASK_FRE = 5;//subtask被分配次数，即被评价次数

    public String getPLAN1() {
        return PLAN1;
    }

    public void setPLAN1(String PLAN1) {
        this.PLAN1 = PLAN1;
    }

    public String getPLAN2() {
        return PLAN2;
    }

    public void setPLAN2(String PLAN2) {
        this.PLAN2 = PLAN2;
    }

    public String getPLAN3() {
        return PLAN3;
    }

    public void setPLAN3(String PLAN3) {
        this.PLAN3 = PLAN3;
    }

    public int getUSER_TASKING() {
        return USER_TASKING;
    }

    public void setUSER_TASKING(int USER_TASKING) {
        this.USER_TASKING = USER_TASKING;
    }

    public int getSUBTASK_FRE() {
        return SUBTASK_FRE;
    }

    public void setSUBTASK_FRE(int SUBTASK_FRE) {
        this.SUBTASK_FRE = SUBTASK_FRE;
    }
}
