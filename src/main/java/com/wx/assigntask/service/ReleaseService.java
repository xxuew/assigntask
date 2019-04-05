package com.wx.assigntask.service;

import com.wx.assigntask.entity.Release;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/7 18:29
 * @Version 1.0
 */
@Repository
public interface ReleaseService {
    /**
     * 插入记录
     * @param userid
     * @param releasename
     * @param plan
     * @param algnames
     * @return
     */
    int insertRelease(int userid,String releasename,String plan,String algnames);
    int insertRelease(HttpServletRequest request,int userid,String[] recommandAlgNames);

    String findDivided(int id);

    /**
     * 根据releaseid查找
     * @param releaseid
     * @return
     */
    Release findReleaseById(int releaseid);

    List<Release> selectByUserid(int userid);

    public void updateIfDivided(int releaseid,String ifDivided);

}
