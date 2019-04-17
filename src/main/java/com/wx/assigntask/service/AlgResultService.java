package com.wx.assigntask.service;

import com.wx.assigntask.entity.Algresult;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlgResultService {
   void insertRecord(int releaseId,String algName1,String algName2);
   void handleAlgResult();
   void updateIffinal(int id,String iffinal);
   List<String> selectNoFinalAlg(int releaseid);
}
