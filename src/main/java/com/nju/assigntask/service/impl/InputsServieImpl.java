package com.nju.assigntask.service.impl;

import com.nju.assigntask.entity.Divided;
import com.nju.assigntask.entity.Inputs;
import com.nju.assigntask.entity.Myreceive;
import com.nju.assigntask.entity.Release;
import com.nju.assigntask.service.InputsService;
import com.nju.assigntask.dao.DividedMapper;
import com.nju.assigntask.dao.InputsMapper;
import com.nju.assigntask.dao.ReleaseMapper;
import com.nju.assigntask.dao.ReleasetablesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:wx
 * @Date:Created in 19:28 2019/4/15
 * @Modified by:
 */
@Service
public class InputsServieImpl implements InputsService {

    @Autowired
    DividedMapper dividedMapper;
    @Autowired
    InputsMapper inputsMapper;
    @Autowired
    ReleaseMapper releaseMapper;
    @Autowired
    ReleasetablesMapper releasetablesMapper;

    /**
     * 获取myreceive中的inputname和inputdes
     *
     * @param myreceive
     * @return
     */
    @Override
    public Inputs selectInputById(Myreceive myreceive) {

        Divided divided = dividedMapper.selectByPrimaryKey(myreceive.getDividedid());
        Release release = releaseMapper.findReleaseById(divided.getReleaseid());
        String inputtable = releasetablesMapper.findInputTab(release.getReleaseid(),divided.getAlgname1());
        int inputid = divided.getInputid();
     //   String algName = divided.getAlgname1();//只需一个algName即可，因为alg1和alg2都来自同一个input
        Inputs inputs = inputsMapper.selectByInputid(inputtable,inputid);

        return inputs;
    }
}
