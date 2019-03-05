package com.wx.assigntask.entity;

import java.io.Serializable;

public class Usertask implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column usertask.user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column usertask.subtask_id
     *
     * @mbg.generated
     */
    private Integer subtaskId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table usertask
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column usertask.user_id
     *
     * @return the value of usertask.user_id
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column usertask.user_id
     *
     * @param userId the value for usertask.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column usertask.subtask_id
     *
     * @return the value of usertask.subtask_id
     *
     * @mbg.generated
     */
    public Integer getSubtaskId() {
        return subtaskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column usertask.subtask_id
     *
     * @param subtaskId the value for usertask.subtask_id
     *
     * @mbg.generated
     */
    public void setSubtaskId(Integer subtaskId) {
        this.subtaskId = subtaskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usertask
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", subtaskId=").append(subtaskId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}