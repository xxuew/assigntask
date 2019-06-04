package com.nju.assigntask.service;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * algresult表业务相关处理
 */
@Repository
public interface AlgResultService {
   /**
    * 插入记录
    * @param releaseId
    * @param algName1
    * @param algName2
    */
   void insertRecord(int releaseId,String algName1,String algName2);
//   void handleAlgResult();

   /**
    * 更新iffinal字段
    * @param id
    * @param iffinal
    */
   void updateIffinal(int id,String iffinal);

   /**
    * 获取上一轮的优胜算法
    * @param releaseid
    * @return
    */
   List<String> selectNoFinalAlg(int releaseid);
}
