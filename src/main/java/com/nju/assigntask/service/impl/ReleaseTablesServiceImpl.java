package com.nju.assigntask.service.impl;

import com.nju.assigntask.entity.Releasetables;
import com.nju.assigntask.service.ReleaseTablesService;
import com.nju.assigntask.dao.ReleasetablesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:wx
 * @Date:Created in 16:07 2019/4/4
 * @Modified by:
 */
@Service
public class ReleaseTablesServiceImpl implements ReleaseTablesService {
    @Autowired
    ReleasetablesMapper releasetablesMapper;

    /**
     * 插入记录
     * @param request
     * @param recommandTableNames
     * @param releaseid
     */
    @Override
    public void insertRecord(HttpServletRequest request,String[] recommandTableNames,String [] recommandAlgNames,int releaseid) {
        Releasetables releasetables = new Releasetables();

        releasetables.setReleaseid(releaseid);
        releasetables.setInputtable(request.getParameter("input_tablename"));//文本检索数据表名

        for (int i=0;i<recommandTableNames.length;i++){
            //遍历插入推荐结果表名
            releasetables.setRecommandtable(recommandTableNames[i]);
            releasetables.setAlgname(recommandAlgNames[i]);
            releasetablesMapper.insert(releasetables);
        }
    }
//
//    @Override
//    public Releasetables findRecoTab(int releaseid, String algname) {
//        Releasetables releasetables = new Releasetables();
//        releasetables.setAlgname(algname);
//        releasetables.setReleaseid(releaseid);
//        releasetables = releasetablesMapper.findByIdAlg(releasetables);
//        return releasetables;
//    }
}
