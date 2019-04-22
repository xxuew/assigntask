package com.nju.assigntask.service;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendService {
    List selectAllItemsNames(int recommandid, String algName);
    List selectAllItemDes(int recommandid,String algName);
    List selectAll(int releaseid);

    /**
     * 获取myreceive中的inputname和inputdes
     * @param myreceives
     * @return
     */
 //   Recommend selectInputById(Myreceive myreceives);
}
