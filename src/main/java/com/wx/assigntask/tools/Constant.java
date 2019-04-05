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
    String PLAN1 = "层次分析法";
    String PLAN2 = "充分对比剪枝法";
    String PLAN3 = "同层对比剪枝法";
    String PLAN1_subtaskFormula = "K*L(L+K-2)/2,(K为推荐算法个数，L为每个算法推荐的结果数)";
    String PLAN2_subtaskFormula = "L^2*(K-1),(K为推荐算法个数，L为每个算法推荐的结果数)";
    String PLAN3_subtaskFormula = "1+(KL-2)*(L+1)/2,(K为推荐算法个数，L为每个算法推荐的结果数)";
    int USER_TASKING = 3;//用户未完成任务只能有三个
    int SUBTASK_FRE = 5;//subtask被分配次数，即被评价次数
    int TASK_COUNT = 10;//用户一次性任务包含十个subtask

    public String getPLAN1() {
        return PLAN1;
    }

    public String getPLAN2() {
        return PLAN2;
    }

    public String getPLAN3() {
        return PLAN3;
    }

    public int getUSER_TASKING() {
        return USER_TASKING;
    }

    public int getSUBTASK_FRE() {
        return SUBTASK_FRE;
    }

    public int getTASK_COUNT() {
        return TASK_COUNT;
    }

    public String getPLAN1_subtaskFormula() {
        return PLAN1_subtaskFormula;
    }

    public String getPLAN2_subtaskFormula() {
        return PLAN2_subtaskFormula;
    }

    public String getPLAN3_subtaskFormula() {
        return PLAN3_subtaskFormula;
    }
}
