package com.nju.assigntask.dao;

import com.nju.assigntask.entity.Myreceive;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MyreceiveMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table myreceive
     *
     * @mbg.generated
     */
    int insert(Myreceive record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table myreceive
     *
     * @mbg.generated
     */
    List<Myreceive> selectAll();

    /**
     * 根据用户查询
     * @param userid
     * @return
     */
    List<Myreceive> selectByUser(int userid);

    /**
     * 根据用户及任务状态查询
     * @param myreceive
     * @return
     */
    List<Myreceive> selectIfcomByUser(Myreceive myreceive);

    /**
     * 更新ifcomplete字段
     * @param myreceive
     */
    void updateIfcomple(Myreceive myreceive);

    /**
     * 查找符合条件的记录
     * @param userid
     * @param id
     * @return
     */
    Myreceive selectByIDs(int userid, int id);
}
