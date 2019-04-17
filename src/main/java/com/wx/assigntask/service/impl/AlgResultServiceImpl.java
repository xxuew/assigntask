package com.wx.assigntask.service.impl;

import com.wx.assigntask.dao.AlgresultMapper;
import com.wx.assigntask.dao.DividedMapper;
import com.wx.assigntask.entity.Algresult;
import com.wx.assigntask.entity.Divided;
import com.wx.assigntask.service.AlgResultService;
import com.wx.assigntask.service.DividedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlgResultServiceImpl  implements AlgResultService {
    @Autowired
    AlgresultMapper algresultMapper;
    @Autowired
    DividedService dividedService;

    @Override
    public void insertRecord(int releaseId, String algName1, String algName2) {
        Algresult algresult = new Algresult();
        algresult.setReleaseid(releaseId);
        algresult.setAlgname1(algName1);
        algresult.setAlgname2(algName2);
        algresultMapper.insertRecord(algresult);
    }

    @Override
    public void handleAlgResult() {
        List<Algresult> algresults = algresultMapper.selectNullWinAlgs();
        for (int i=0;i<algresults.size();i++){
            Algresult algresult = algresults.get(i);
            float score1 = dividedService.getAveScore1(algresult.getReleaseid(),algresult.getAlgname1(),algresult.getAlgname2());
            float score2 = dividedService.getAveScore2(algresult.getReleaseid(),algresult.getAlgname1(),algresult.getAlgname2());
            algresult.setScore1(score1);
            algresult.setScore2(score2);
            algresultMapper.updateScore(algresult);
            if (score1 >=score2){
                algresult.setWinalgname(algresult.getAlgname1());
                algresultMapper.updateWinAlg(algresult);
            }else {
                algresult.setWinalgname(algresult.getAlgname2());
                algresultMapper.updateWinAlg(algresult);
            }
        }
    }

    @Override
    public void updateIffinal(int id,String iffinal) {
        Algresult algresult = new Algresult();
        algresult.setId(id);
        algresult.setIffinal(iffinal);
        algresultMapper.updateIffinal(algresult);
    }

    @Override
    public List<String> selectNoFinalAlg(int releaseid) {
        List<String> algs = algresultMapper.selectNoFinalAlg(releaseid); //获取上一轮胜出的algname
        List<Integer> algResultIds = algresultMapper.selectNoFinalIds(releaseid);
        if (algs.size() > 1){
            if (algs.size()/2 == 0 && algs.size() != 2){
                for (int j = 0;j<algs.size();j++){
                    updateIffinal(algResultIds.get(j),"no");
                }
            }
            else{
                for (int j = 0;j<algs.size()-1;j++){
                    updateIffinal(algResultIds.get(j),"no");
                }
            }
        }
        return algs;
    }
}
