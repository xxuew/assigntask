package com.nju.assigntask.service;

import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:wx
 * @Date:Created in 15:59 2019/4/4
 * @Modified by:
 */
@Repository
public interface ReleaseTablesService {
    void insertRecord(HttpServletRequest request,String[] recommandTableNames,String [] recommandAlgNames,int releaseid);
//    Releasetables findRecoTab(int releaseid,String algname);
}
