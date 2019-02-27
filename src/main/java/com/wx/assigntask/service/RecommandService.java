package com.wx.assigntask.service;

import com.wx.assigntask.entity.Myreceive;
import com.wx.assigntask.entity.Recommand;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommandService {
    List selectAllItemsNames(int recommandid, String algName);
    List selectAllItemDes(int recommandid,String algName);
    List selectAll(int releaseid);

    /**
     * 获取myreceive中的inputname和inputdes
     * @param myreceives
     * @return
     */
    Recommand selectInputById(Myreceive myreceives);
}
