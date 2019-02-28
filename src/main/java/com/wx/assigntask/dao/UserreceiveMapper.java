package com.wx.assigntask.dao;

import com.wx.assigntask.entity.User;
import com.wx.assigntask.entity.Userreceive;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface UserreceiveMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usertask
     *
     * @mbg.generated
     */
    int insert(Userreceive record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usertask
     *
     * @mbg.generated
     */
    List<Userreceive> selectAll();

    User findUserByUserName(String username);

    List<Userreceive> findByUserId(int userId);

    int selectAveScore1(Userreceive userreceive);
    int selectAveScore2(Userreceive userreceive);
    List<Integer> selectReleaseIdByUser(int userid);

    int insertSubTask(Userreceive userreceive);

    void updateScore(Userreceive userreceive);

}