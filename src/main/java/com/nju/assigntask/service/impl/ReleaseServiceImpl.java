package com.nju.assigntask.service.impl;


import com.nju.assigntask.dao.ReleaseMapper;
import com.nju.assigntask.dao.SubtaskMapper;
import com.nju.assigntask.dao.UserreceiveMapper;
import com.nju.assigntask.entity.Release;
import com.nju.assigntask.service.ReleaseService;
import com.nju.assigntask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.lang.String;
import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/7 18:30
 * @Version 1.0
 */
@Service
public class ReleaseServiceImpl implements ReleaseService {

    @Autowired
    ReleaseMapper releaseMapper;

    @Autowired
    UserreceiveMapper userreceiveMapper;
    @Autowired
    SubtaskMapper subtaskMapper;
    @Autowired
    UserService userService;


    @Override
    public void updateIfDivided(int releaseid, String ifDivided) {
        releaseMapper.updateIfDivided(releaseid,ifDivided);
    }

    @Override
    public int insertRelease(int userid,String releasename,String plan,String algnames) {
        Release release = new Release();
        release.setUserid(userid);
        release.setReleasename(releasename);
        release.setPlan(plan);
        release.setAlgnames(algnames);
        releaseMapper.insertRelease(release);
        int id = release.getReleaseid();
        return id;
    }

    @Override
    public int insertRelease(HttpServletRequest request, int userid,String[] recommandAlgNames) {
        Release release = new Release();
        release.setUserid(userid);
        release.setReleasename(request.getParameter("release_name")); //项目名称
        release.setPlan(request.getParameter("release_plan")); //生成方案
        String recommandAlgName = "";
        for (int i=0;i<recommandAlgNames.length-1;i++){
            recommandAlgName = recommandAlgName + recommandAlgNames[i] + ",";
        }
        recommandAlgName = recommandAlgName + recommandAlgNames[recommandAlgNames.length-1];
        release.setAlgnames(recommandAlgName); // 算法名
        releaseMapper.insertRelease(release);
        int id = release.getReleaseid();
        return id;
    }

    @Override
    public String findDivided(int id) {
        String ifDivided = releaseMapper.findDivided(id);
        return ifDivided;
    }

    /**
     * 根据releaseid查找已发布项目
     * @param releaseid
     * @return
     */
    @Override
    public Release findReleaseById(int releaseid) {
        Release release = releaseMapper.findReleaseById(releaseid);
        return release;
    }

    /**
     * 根据userid查找已发布项目
     * @param userid
     * @return
     */
    @Override
    public List<Release> selectByUserid(int userid) {
        List<Release> releaseList= releaseMapper.findByUserid(userid);
        return releaseList;
    }
}
