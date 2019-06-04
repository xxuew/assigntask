package com.nju.assigntask.tools;

/**
 * @Author:wx
 * @Date:Created in 10:53 2019/2/25
 * @Modified by:
 */

import org.springframework.stereotype.Component;

/**
 * 统一管理项目中出现的常量
 */
@Component
public class Constant {
    private String PLAN_AHP = "层次分析法";
    private String PLAN_COMPARECOMPLETE = "充分对比剪枝法";
    private String PLAN_SAMELAYER = "同层对比剪枝法";
    private String AHP_subtaskFormula = "K*L(L+K-2)/2,(K=推荐算法数，L=每个算法推荐的结果数)";
    private String COMPARECOMPLETE_subtaskFormula = "L^2*(K-1),(K为推荐算法个数，L为每个算法推荐的结果数)";
    private String SAMELAYER_subtaskFormula = "1+(KL-2)*(L+1)/2,(K为推荐算法个数，L为每个算法推荐的结果数)";
    private int USER_TASKING = 3;//用户未完成任务只能有三个
    private int SUBTASK_FRE = 5;//subtask被分配次数，即被评价次数
    private int TASK_COUNT = 10;//用户一次性任务包含十个subtask
    private String TABLENAME_INPUT = "inputs"; //文本检索内容表，接口表名
    private String TABLENAME_RECOMMEND = "recommend"; //推荐结果表，接口表名
    private String STATUS_UNCOMPLETE = "未完成";
    private String STATUS_COMPLETE = "已完成";
    private String INSIDE_ORDER = "推荐结果内部内部排序中";
    private int REPEAT_RATE = 90; //一组数中某个数的重复率不超过90%


    public String getPLAN_AHP() {
        return PLAN_AHP;
    }

    public String getPLAN_COMPARECOMPLETE() {
        return PLAN_COMPARECOMPLETE;
    }

    public String getPLAN_SAMELAYER() {
        return PLAN_SAMELAYER;
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

    public String getAHP_subtaskFormula() {
        return AHP_subtaskFormula;
    }

    public String getCOMPARECOMPLETE_subtaskFormula() {
        return COMPARECOMPLETE_subtaskFormula;
    }

    public String getSAMELAYER_subtaskFormula() {
        return SAMELAYER_subtaskFormula;
    }

    public String getTABLENAME_INPUT() {
        return TABLENAME_INPUT;
    }

    public String getTABLENAME_RECOMMEND() {
        return TABLENAME_RECOMMEND;
    }

    public String getSTATUS_UNCOMPLETE() {
        return STATUS_UNCOMPLETE;
    }

    public String getSTATUS_COMPLETE() {
        return STATUS_COMPLETE;
    }

    public String getINSIDE_ORDER() {
        return INSIDE_ORDER;
    }

    public int getREPEAT_RATE() {
        return REPEAT_RATE;
    }
}
