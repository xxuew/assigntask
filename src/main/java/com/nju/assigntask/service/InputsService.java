package com.nju.assigntask.service;

import com.nju.assigntask.entity.Inputs;
import com.nju.assigntask.entity.Myreceive;
import org.springframework.stereotype.Repository;

/**
 * @Author:wx
 * @Date:Created in 19:28 2019/4/15
 * @Modified by:
 */
@Repository
public interface InputsService {

    /**
     * 获取myreceive中的inputname和inputdes
     * @param myreceive
     * @return
     */
    public Inputs selectInputById(Myreceive myreceive);

}
