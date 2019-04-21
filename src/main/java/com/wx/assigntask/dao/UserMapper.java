package com.wx.assigntask.dao;

import com.wx.assigntask.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    int insert(User record);
    List<User> selectAll();
    User findUserByUserName(String username);
    int updateUser(User user);
}