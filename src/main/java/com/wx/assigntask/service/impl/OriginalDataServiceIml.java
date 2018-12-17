package com.wx.assigntask.service.impl;

import com.wx.assigntask.dao.OriginalDataMapper;
import com.wx.assigntask.entity.OriginalData;
import com.wx.assigntask.service.OriginalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/17 16:08
 * @Version 1.0
 */
@Service
public class OriginalDataServiceIml implements OriginalDataService {

    @Autowired
    OriginalDataMapper originalDataMapper;



    @Override
    public List<OriginalData> selectAll() {

        return originalDataMapper.selectAll();
    }
    @Override
    public List selectAllItemDes(int id) {
        OriginalData originalData = originalDataMapper.selectAllItemDes(id);
        List list = new ArrayList();
        list.add(originalData.getLstmDes1());
        list.add(originalData.getLstmDes2());
        list.add(originalData.getLstmDes3());
        list.add(originalData.getLstmDes4());
        list.add(originalData.getLstmDes5());
        list.add(originalData.getLstmDes6());
        list.add(originalData.getLstmDes7());
        list.add(originalData.getLstmDes8());
        list.add(originalData.getLstmDes9());
        list.add(originalData.getLstmDes10());
        list.add(originalData.getNnDes1());
        list.add(originalData.getNnDes2());
        list.add(originalData.getNnDes3());
        list.add(originalData.getNnDes4());
        list.add(originalData.getNnDes5());
        list.add(originalData.getNnDes6());
        list.add(originalData.getNnDes7());
        list.add(originalData.getNnDes8());
        list.add(originalData.getNnDes9());
        list.add(originalData.getNnDes10());
        list.add(originalData.getCnnDes1());
        list.add(originalData.getCnnDes2());
        list.add(originalData.getCnnDes3());
        list.add(originalData.getCnnDes4());
        list.add(originalData.getCnnDes5());
        list.add(originalData.getCnnDes6());
        list.add(originalData.getCnnDes7());
        list.add(originalData.getCnnDes8());
        list.add(originalData.getCnnDes9());
        list.add(originalData.getCnnDes10());
        list.add(originalData.getTfidfDes1());
        list.add(originalData.getTfidfDes2());
        list.add(originalData.getTfidfDes3());
        list.add(originalData.getTfidfDes4());
        list.add(originalData.getTfidfDes5());
        list.add(originalData.getTfidfDes6());
        list.add(originalData.getTfidfDes7());
        list.add(originalData.getTfidfDes8());
        list.add(originalData.getTfidfDes9());
        list.add(originalData.getTfidfDes10());
        list.add(originalData.getDocDes1());
        list.add(originalData.getDocDes2());
        list.add(originalData.getDocDes3());
        list.add(originalData.getDocDes4());
        list.add(originalData.getDocDes5());
        list.add(originalData.getDocDes6());
        list.add(originalData.getDocDes7());
        list.add(originalData.getDocDes8());
        list.add(originalData.getDocDes9());
        list.add(originalData.getDocDes10());
        list.add(originalData.getIndexDes1());
        list.add(originalData.getIndexDes2());
        list.add(originalData.getIndexDes3());
        list.add(originalData.getIndexDes4());
        list.add(originalData.getIndexDes5());
        list.add(originalData.getIndexDes6());
        list.add(originalData.getIndexDes7());
        list.add(originalData.getIndexDes8());
        list.add(originalData.getIndexDes9());
        list.add(originalData.getIndexDes10());
        return list;
    }

    @Override
    public List selectAllItemsNames(int id) {
        //返回itemNames
        OriginalData originalData = originalDataMapper.selectAllItemsNames(id);
        List list = new ArrayList();
        list.add(originalData.getLstmName1());
        list.add(originalData.getLstmName2());
        list.add(originalData.getLstmName3());
        list.add(originalData.getLstmName4());
        list.add(originalData.getLstmName5());
        list.add(originalData.getLstmName6());
        list.add(originalData.getLstmName7());
        list.add(originalData.getLstmName8());
        list.add(originalData.getLstmName9());
        list.add(originalData.getLstmName10());
        list.add(originalData.getNnName1());
        list.add(originalData.getNnName2());
        list.add(originalData.getNnName3());
        list.add(originalData.getNnName4());
        list.add(originalData.getNnName5());
        list.add(originalData.getNnName6());
        list.add(originalData.getNnName7());
        list.add(originalData.getNnName8());
        list.add(originalData.getNnName9());
        list.add(originalData.getNnName10());
        list.add(originalData.getCnnName1());
        list.add(originalData.getCnnName2());
        list.add(originalData.getCnnName3());
        list.add(originalData.getCnnName4());
        list.add(originalData.getCnnName5());
        list.add(originalData.getCnnName6());
        list.add(originalData.getCnnName7());
        list.add(originalData.getCnnName8());
        list.add(originalData.getCnnName9());
        list.add(originalData.getCnnName10());
        list.add(originalData.getTfidfName1());
        list.add(originalData.getTfidfName2());
        list.add(originalData.getTfidfName3());
        list.add(originalData.getTfidfName4());
        list.add(originalData.getTfidfName5());
        list.add(originalData.getTfidfName6());
        list.add(originalData.getTfidfName7());
        list.add(originalData.getTfidfName8());
        list.add(originalData.getTfidfName9());
        list.add(originalData.getTfidfName10());
        list.add(originalData.getDocName1());
        list.add(originalData.getDocName2());
        list.add(originalData.getDocName3());
        list.add(originalData.getDocName4());
        list.add(originalData.getDocName5());
        list.add(originalData.getDocName6());
        list.add(originalData.getDocName7());
        list.add(originalData.getDocName8());
        list.add(originalData.getDocName9());
        list.add(originalData.getDocName10());
        list.add(originalData.getIndexName1());
        list.add(originalData.getIndexName2());
        list.add(originalData.getIndexName3());
        list.add(originalData.getIndexName4());
        list.add(originalData.getIndexName5());
        list.add(originalData.getIndexName6());
        list.add(originalData.getIndexName7());
        list.add(originalData.getIndexName8());
        list.add(originalData.getIndexName9());
        list.add(originalData.getIndexName10());
        return list;
    }
}
