package com.wx.assigntask.service.impl;

import com.wx.assigntask.comment.ItemList;
import com.wx.assigntask.dao.*;
import com.wx.assigntask.entity.*;
import com.wx.assigntask.service.IBuildTaskService;
import com.wx.assigntask.subtask.BuildTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuildTaskServiceImpl implements IBuildTaskService {
    @Autowired
    Cnnrecommand100Mapper cnnrecommandMapper;
    @Autowired
    Docrecommand100Mapper docrecommandMapper;
    @Autowired
    Indexrecommand100Mapper indexrecommandMapper;
    @Autowired
    Lstmrecommand100Mapper lstmrecommandMapper;
    @Autowired
    Nnrecommand100Mapper nnrecommandMapper;
    @Autowired
    Tfidfrecommand100Mapper tfidfrecommandMapper;
    @Autowired
    SubtaskCnnDocMapper subtaskCnnDocMapper;
    @Autowired
    SubtaskCnnIndexMapper subtaskCnnIndexMapper;
    @Autowired
    SubtaskCnnLstmMapper subtaskCnnLstmMapper;
    @Autowired
    SubtaskCnnTfidfMapper subtaskCnnTfidfMapper;
    @Autowired
    SubtaskCnnNnMapper subtaskCnnNnMapper;
    @Autowired
    SubtaskTfidfDocMapper subtaskTfidfDocMapper;
    @Autowired
    SubtaskTfidfIndexMapper subtaskTfidfIndexMapper;
    @Autowired
    SubtaskTfidfLstmMapper subtaskTfidfLstmMapper;
    @Autowired
    SubtaskTfidfNnMapper subtaskTfidfNnMapper;
    @Autowired
    SubtaskDocIndexMapper subtaskDocIndexMapper;
    @Autowired
    SubtaskDocLstmMapper subtaskDocLstmMapper;
    @Autowired
    SubtaskDocNnMapper subtaskDocNnMapper;
    @Autowired
    SubtaskIndexLstmMapper subtaskIndexLstmMapper;
    @Autowired
    SubtaskIndexNnMapper subtaskIndexNnMapper;
    @Autowired
    SubtaskLstmNnMapper subtaskLstmNnMapper;
    @Override
    public void cnn_docbuildtask() {
        BuildTask buildTask = new BuildTask();
        String[] s1 = new String[23];
        String[] s2 = new String[23];
        List<ItemList> list = new ArrayList();
        for (int i = 1;i<=100;i++){
            Cnnrecommand100 cnnrecommand = cnnrecommandMapper.select(i);
            Docrecommand100 docrecommand = docrecommandMapper.select(i);
            s1 = buildTask.cnnToArray(cnnrecommand);
            s2 = buildTask.docToArray(docrecommand);
            for (int m = 0;m<10;m++){
                for (int n = 0;n<10;n++){
                    ItemList itemList = new ItemList();
                    itemList.setInputname(s1[1]);
                    itemList.setInputdes(s1[2]);
                    itemList.setItema(s1[m+3]);
                    itemList.setDesa(s1[m+13]);
                    itemList.setItemb(s2[n+3]);
                    itemList.setDesb(s2[n+13]);
                    list.add(itemList);
                }
            }
        }
        //        生成一次就可以了，很耗时间
        int count = 1;
        for (ItemList i: list) {
            SubtaskCnnDoc as = new SubtaskCnnDoc();
            as.setSubtaskId(count);
            as.setInputName(i.inputname);
            as.setInputDes(i.inputdes);
            as.setItemName1(i.itema);
            as.setItemDes1(i.desa);
            as.setItemName2(i.itemb);
            as.setItemDes2(i.desb);
            as.setFrequency(0);
            subtaskCnnDocMapper.insert(as);
            count++;
        }
        System.out.println("cnn_doc生成完毕");
    }

    @Override
    public void cnn_indexbuildtask() {
        BuildTask buildTask = new BuildTask();
        String[] s1 = new String[23];
        String[] s2 = new String[23];
        List<ItemList> list = new ArrayList();
        for (int i = 1;i<=100;i++){
            Cnnrecommand100 cnnrecommand = cnnrecommandMapper.select(i);
            Indexrecommand100 indexrecommand = indexrecommandMapper.select(i);
            s1 = buildTask.cnnToArray(cnnrecommand);
            s2 = buildTask.indexToArray(indexrecommand);
            for (int m = 0;m<10;m++){
                for (int n = 0;n<10;n++){
                    ItemList itemList = new ItemList();
                    itemList.setInputname(s1[1]);
                    itemList.setInputdes(s1[2]);
                    itemList.setItema(s1[m+3]);
                    itemList.setDesa(s1[m+13]);
                    itemList.setItemb(s2[n+3]);
                    itemList.setDesb(s2[n+13]);
                    list.add(itemList);
                }
            }
        }
        //        生成一次就可以了，很耗时间
        int count = 1;
        for (ItemList i: list) {
            SubtaskCnnIndex as = new SubtaskCnnIndex();
            as.setSubtaskId(count);
            as.setInputName(i.inputname);
            as.setInputDes(i.inputdes);
            as.setItemName1(i.itema);
            as.setItemDes1(i.desa);
            as.setItemName2(i.itemb);
            as.setItemDes2(i.desb);
            as.setFrequency(0);
            subtaskCnnIndexMapper.insert(as);
            count++;
        }
        System.out.println("cnn_index生成完毕");
    }

    @Override
    public void cnn_lstmbuildtask() {
        BuildTask buildTask = new BuildTask();
        String[] s1 = new String[23];
        String[] s2 = new String[23];
        List<ItemList> list = new ArrayList();
        for (int i = 1;i<=100;i++){
            Cnnrecommand100 cnnrecommand = cnnrecommandMapper.select(i);
            Lstmrecommand100 lstmrecommand = lstmrecommandMapper.select(i);
            s1 = buildTask.cnnToArray(cnnrecommand);
            s2 = buildTask.lstmToArray(lstmrecommand);
            for (int m = 0;m<10;m++){
                for (int n = 0;n<10;n++){
                    ItemList itemList = new ItemList();
                    itemList.setInputname(s1[1]);
                    itemList.setInputdes(s1[2]);
                    itemList.setItema(s1[m+3]);
                    itemList.setDesa(s1[m+13]);
                    itemList.setItemb(s2[n+3]);
                    itemList.setDesb(s2[n+13]);
                    list.add(itemList);
                }
            }
        }
        //        生成一次就可以了，很耗时间
        int count = 1;
        for (ItemList i: list) {
            SubtaskCnnLstm as = new SubtaskCnnLstm();
            as.setSubtaskId(count);
            as.setInputName(i.inputname);
            as.setInputDes(i.inputdes);
            as.setItemName1(i.itema);
            as.setItemDes1(i.desa);
            as.setItemName2(i.itemb);
            as.setItemDes2(i.desb);
            as.setFrequency(0);
            subtaskCnnLstmMapper.insert(as);
            count++;
        }
        System.out.println("cnn_lstm生成完毕");
    }

    @Override
    public void cnn_nnbuildtask() {
        BuildTask buildTask = new BuildTask();
        String[] s1 = new String[23];
        String[] s2 = new String[23];
        List<ItemList> list = new ArrayList();
        for (int i = 1;i<=100;i++){
            Cnnrecommand100 cnnrecommand = cnnrecommandMapper.select(i);
            Nnrecommand100 nnrecommand = nnrecommandMapper.select(i);
            s1 = buildTask.cnnToArray(cnnrecommand);
            s2 = buildTask.nnToArray(nnrecommand);
            for (int m = 0;m<10;m++){
                for (int n = 0;n<10;n++){
                    ItemList itemList = new ItemList();
                    itemList.setInputname(s1[1]);
                    itemList.setInputdes(s1[2]);
                    itemList.setItema(s1[m+3]);
                    itemList.setDesa(s1[m+13]);
                    itemList.setItemb(s2[n+3]);
                    itemList.setDesb(s2[n+13]);
                    list.add(itemList);
                }
            }
        }
        //        生成一次就可以了，很耗时间
        int count = 1;
        for (ItemList i: list) {
            SubtaskCnnNn as = new SubtaskCnnNn();
            as.setSubtaskId(count);
            as.setInputName(i.inputname);
            as.setInputDes(i.inputdes);
            as.setItemName1(i.itema);
            as.setItemDes1(i.desa);
            as.setItemName2(i.itemb);
            as.setItemDes2(i.desb);
            as.setFrequency(0);
            subtaskCnnNnMapper.insert(as);
            count++;
        }
        System.out.println("cnn_nn生成完毕");
    }

    @Override
    public void cnn_tfidfbuildtask() {
        BuildTask buildTask = new BuildTask();
        String[] s1 = new String[23];
        String[] s2 = new String[23];
        List<ItemList> list = new ArrayList();
        for (int i = 1;i<=100;i++){
            Cnnrecommand100 cnnrecommand = cnnrecommandMapper.select(i);
            Tfidfrecommand100 tfidfrecommand = tfidfrecommandMapper.select(i);
            s1 = buildTask.cnnToArray(cnnrecommand);
            s2 = buildTask.tfidfToArray(tfidfrecommand);
            for (int m = 0;m<10;m++){
                for (int n = 0;n<10;n++){
                    ItemList itemList = new ItemList();
                    itemList.setInputname(s1[1]);
                    itemList.setInputdes(s1[2]);
                    itemList.setItema(s1[m+3]);
                    itemList.setDesa(s1[m+13]);
                    itemList.setItemb(s2[n+3]);
                    itemList.setDesb(s2[n+13]);
                    list.add(itemList);
                }
            }
        }
        //        生成一次就可以了，很耗时间
        int count = 1;
        for (ItemList i: list) {
            SubtaskCnnTfidf as = new SubtaskCnnTfidf();
            as.setSubtaskId(count);
            as.setInputName(i.inputname);
            as.setInputDes(i.inputdes);
            as.setItemName1(i.itema);
            as.setItemDes1(i.desa);
            as.setItemName2(i.itemb);
            as.setItemDes2(i.desb);
            as.setFrequency(0);
            subtaskCnnTfidfMapper.insert(as);
            count++;
        }
        System.out.println("cnn_tfidf生成完毕");
    }

    @Override
    public void tfidf_docbuildtask() {
        BuildTask buildTask = new BuildTask();
        String[] s1 = new String[23];
        String[] s2 = new String[23];
        List<ItemList> list = new ArrayList();
        for (int i = 1;i<=100;i++){
            Tfidfrecommand100 tfidfrecommand = tfidfrecommandMapper.select(i);
            Docrecommand100 docrecommand = docrecommandMapper.select(i);
            s1 = buildTask.tfidfToArray(tfidfrecommand);
            s2 = buildTask.docToArray(docrecommand);
            for (int m = 0;m<10;m++){
                for (int n = 0;n<10;n++){
                    ItemList itemList = new ItemList();
                    itemList.setInputname(s1[1]);
                    itemList.setInputdes(s1[2]);
                    itemList.setItema(s1[m+3]);
                    itemList.setDesa(s1[m+13]);
                    itemList.setItemb(s2[n+3]);
                    itemList.setDesb(s2[n+13]);
                    list.add(itemList);
                }
            }
        }
        //        生成一次就可以了，很耗时间
        int count = 1;
        for (ItemList i: list) {
            SubtaskTfidfDoc as = new SubtaskTfidfDoc();
            as.setSubtaskId(count);
            as.setInputName(i.inputname);
            as.setInputDes(i.inputdes);
            as.setItemName1(i.itema);
            as.setItemDes1(i.desa);
            as.setItemName2(i.itemb);
            as.setItemDes2(i.desb);
            as.setFrequency(0);
            subtaskTfidfDocMapper.insert(as);
            count++;
        }
        System.out.println("Tfidf_doc生成完毕");
    }

    @Override
    public void tfidf_indexbuildtask() {
        BuildTask buildTask = new BuildTask();
        String[] s1 = new String[23];
        String[] s2 = new String[23];
        List<ItemList> list = new ArrayList();
        for (int i = 1;i<=100;i++){
            Tfidfrecommand100 tfidfrecommand = tfidfrecommandMapper.select(i);
            Indexrecommand100 indexrecommand = indexrecommandMapper.select(i);
            s1 = buildTask.tfidfToArray(tfidfrecommand);
            s2 = buildTask.indexToArray(indexrecommand);
            for (int m = 0;m<10;m++){
                for (int n = 0;n<10;n++){
                    ItemList itemList = new ItemList();
                    itemList.setInputname(s1[1]);
                    itemList.setInputdes(s1[2]);
                    itemList.setItema(s1[m+3]);
                    itemList.setDesa(s1[m+13]);
                    itemList.setItemb(s2[n+3]);
                    itemList.setDesb(s2[n+13]);
                    list.add(itemList);
                }
            }
        }
        //        生成一次就可以了，很耗时间
        int count = 1;
        for (ItemList i: list) {
            SubtaskTfidfIndex as = new SubtaskTfidfIndex();
            as.setSubtaskId(count);
            as.setInputName(i.inputname);
            as.setInputDes(i.inputdes);
            as.setItemName1(i.itema);
            as.setItemDes1(i.desa);
            as.setItemName2(i.itemb);
            as.setItemDes2(i.desb);
            as.setFrequency(0);
            subtaskTfidfIndexMapper.insert(as);
            count++;
        }
        System.out.println("Tfidf_index生成完毕");
    }

    @Override
    public void tfidf_lstmbuildtask() {
        BuildTask buildTask = new BuildTask();
        String[] s1 = new String[23];
        String[] s2 = new String[23];
        List<ItemList> list = new ArrayList();
        for (int i = 1;i<=100;i++){
            Tfidfrecommand100 tfidfrecommand = tfidfrecommandMapper.select(i);
            Lstmrecommand100 lstmrecommand = lstmrecommandMapper.select(i);
            s1 = buildTask.tfidfToArray(tfidfrecommand);
            s2 = buildTask.lstmToArray(lstmrecommand);
            for (int m = 0;m<10;m++){
                for (int n = 0;n<10;n++){
                    ItemList itemList = new ItemList();
                    itemList.setInputname(s1[1]);
                    itemList.setInputdes(s1[2]);
                    itemList.setItema(s1[m+3]);
                    itemList.setDesa(s1[m+13]);
                    itemList.setItemb(s2[n+3]);
                    itemList.setDesb(s2[n+13]);
                    list.add(itemList);
                }
            }
        }
        //        生成一次就可以了，很耗时间
        int count = 1;
        for (ItemList i: list) {
            SubtaskTfidfLstm as = new SubtaskTfidfLstm();
            as.setSubtaskId(count);
            as.setInputName(i.inputname);
            as.setInputDes(i.inputdes);
            as.setItemName1(i.itema);
            as.setItemDes1(i.desa);
            as.setItemName2(i.itemb);
            as.setItemDes2(i.desb);
            as.setFrequency(0);
            subtaskTfidfLstmMapper.insert(as);
            count++;
        }
        System.out.println("Tfidf_lstm生成完毕");

    }

    @Override
    public void tfidf_nnbuildtask() {

        BuildTask buildTask = new BuildTask();
        String[] s1 = new String[23];
        String[] s2 = new String[23];
        List<ItemList> list = new ArrayList();
        for (int i = 1;i<=100;i++){
            Tfidfrecommand100 tfidfrecommand = tfidfrecommandMapper.select(i);
            Nnrecommand100 nnrecommand = nnrecommandMapper.select(i);
            s1 = buildTask.tfidfToArray(tfidfrecommand);
            s2 = buildTask.nnToArray(nnrecommand);
            for (int m = 0;m<10;m++){
                for (int n = 0;n<10;n++){
                    ItemList itemList = new ItemList();
                    itemList.setInputname(s1[1]);
                    itemList.setInputdes(s1[2]);
                    itemList.setItema(s1[m+3]);
                    itemList.setDesa(s1[m+13]);
                    itemList.setItemb(s2[n+3]);
                    itemList.setDesb(s2[n+13]);
                    list.add(itemList);
                }
            }
        }
        //        生成一次就可以了，很耗时间
        int count = 1;
        for (ItemList i: list) {
            SubtaskTfidfNn as = new SubtaskTfidfNn();
            as.setSubtaskId(count);
            as.setInputName(i.inputname);
            as.setInputDes(i.inputdes);
            as.setItemName1(i.itema);
            as.setItemDes1(i.desa);
            as.setItemName2(i.itemb);
            as.setItemDes2(i.desb);
            as.setFrequency(0);
            subtaskTfidfNnMapper.insert(as);
            count++;
        }
        System.out.println("Tfidf_nn生成完毕");
    }

    @Override
    public void doc_indexbuildtask() {
        BuildTask buildTask = new BuildTask();
        String[] s1 = new String[23];
        String[] s2 = new String[23];
        List<ItemList> list = new ArrayList();
        for (int i = 1;i<=100;i++){
            Docrecommand100 docrecommand = docrecommandMapper.select(i);
            Indexrecommand100 indexrecommand = indexrecommandMapper.select(i);
            s1 = buildTask.docToArray(docrecommand);
            s2 = buildTask.indexToArray(indexrecommand);
            for (int m = 0;m<10;m++){
                for (int n = 0;n<10;n++){
                    ItemList itemList = new ItemList();
                    itemList.setInputname(s1[1]);
                    itemList.setInputdes(s1[2]);
                    itemList.setItema(s1[m+3]);
                    itemList.setDesa(s1[m+13]);
                    itemList.setItemb(s2[n+3]);
                    itemList.setDesb(s2[n+13]);
                    list.add(itemList);
                }
            }
        }
        //        生成一次就可以了，很耗时间
        int count = 1;
        for (ItemList i: list) {
            SubtaskDocIndex as = new SubtaskDocIndex();
            as.setSubtaskId(count);
            as.setInputName(i.inputname);
            as.setInputDes(i.inputdes);
            as.setItemName1(i.itema);
            as.setItemDes1(i.desa);
            as.setItemName2(i.itemb);
            as.setItemDes2(i.desb);
            as.setFrequency(0);
            subtaskDocIndexMapper.insert(as);
            count++;
        }
        System.out.println("doc_index生成完毕");
    }

    @Override
    public void doc_lstmbuildtask() {
        BuildTask buildTask = new BuildTask();
        String[] s1 = new String[23];
        String[] s2 = new String[23];
        List<ItemList> list = new ArrayList();
        for (int i = 1;i<=100;i++){
            Docrecommand100 docrecommand = docrecommandMapper.select(i);
            Lstmrecommand100 lstmrecommand = lstmrecommandMapper.select(i);
            s1 = buildTask.docToArray(docrecommand);
            s2 = buildTask.lstmToArray(lstmrecommand);
            for (int m = 0;m<10;m++){
                for (int n = 0;n<10;n++){
                    ItemList itemList = new ItemList();
                    itemList.setInputname(s1[1]);
                    itemList.setInputdes(s1[2]);
                    itemList.setItema(s1[m+3]);
                    itemList.setDesa(s1[m+13]);
                    itemList.setItemb(s2[n+3]);
                    itemList.setDesb(s2[n+13]);
                    list.add(itemList);
                }
            }
        }
        //        生成一次就可以了，很耗时间
        int count = 1;
        for (ItemList i: list) {
            SubtaskDocLstm as = new SubtaskDocLstm();
            as.setSubtaskId(count);
            as.setInputName(i.inputname);
            as.setInputDes(i.inputdes);
            as.setItemName1(i.itema);
            as.setItemDes1(i.desa);
            as.setItemName2(i.itemb);
            as.setItemDes2(i.desb);
            as.setFrequency(0);
            subtaskDocLstmMapper.insert(as);
            count++;
        }
        System.out.println("doc_lstm生成完毕");
    }

    @Override
    public void doc_nnbuildtask() {
        BuildTask buildTask = new BuildTask();
        String[] s1 = new String[23];
        String[] s2 = new String[23];
        List<ItemList> list = new ArrayList();
        for (int i = 1;i<=100;i++){
            Docrecommand100 docrecommand = docrecommandMapper.select(i);
            Nnrecommand100 nnrecommand = nnrecommandMapper.select(i);
            s1 = buildTask.docToArray(docrecommand);
            s2 = buildTask.nnToArray(nnrecommand);
            for (int m = 0;m<10;m++){
                for (int n = 0;n<10;n++){
                    ItemList itemList = new ItemList();
                    itemList.setInputname(s1[1]);
                    itemList.setInputdes(s1[2]);
                    itemList.setItema(s1[m+3]);
                    itemList.setDesa(s1[m+13]);
                    itemList.setItemb(s2[n+3]);
                    itemList.setDesb(s2[n+13]);
                    list.add(itemList);
                }
            }
        }
        //        生成一次就可以了，很耗时间
        int count = 1;
        for (ItemList i: list) {
            SubtaskDocNn as = new SubtaskDocNn();
            as.setSubtaskId(count);
            as.setInputName(i.inputname);
            as.setInputDes(i.inputdes);
            as.setItemName1(i.itema);
            as.setItemDes1(i.desa);
            as.setItemName2(i.itemb);
            as.setItemDes2(i.desb);
            as.setFrequency(0);
            subtaskDocNnMapper.insert(as);
            count++;
        }
        System.out.println("doc_nn生成完毕");
    }

    @Override
    public void index_lstmbuildtask() {
        BuildTask buildTask = new BuildTask();
        String[] s1 = new String[23];
        String[] s2 = new String[23];
        List<ItemList> list = new ArrayList();
        for (int i = 1;i<=100;i++){
            Indexrecommand100 indexrecommand = indexrecommandMapper.select(i);
            Lstmrecommand100 lstmrecommand = lstmrecommandMapper.select(i);
            s1 = buildTask.indexToArray(indexrecommand);
            s2 = buildTask.lstmToArray(lstmrecommand);
            for (int m = 0;m<10;m++){
                for (int n = 0;n<10;n++){
                    ItemList itemList = new ItemList();
                    itemList.setInputname(s1[1]);
                    itemList.setInputdes(s1[2]);
                    itemList.setItema(s1[m+3]);
                    itemList.setDesa(s1[m+13]);
                    itemList.setItemb(s2[n+3]);
                    itemList.setDesb(s2[n+13]);
                    list.add(itemList);
                }
            }
        }
        //        生成一次就可以了，很耗时间
        int count = 1;
        for (ItemList i: list) {
            SubtaskIndexLstm as = new SubtaskIndexLstm();
            as.setSubtaskId(count);
            as.setInputName(i.inputname);
            as.setInputDes(i.inputdes);
            as.setItemName1(i.itema);
            as.setItemDes1(i.desa);
            as.setItemName2(i.itemb);
            as.setItemDes2(i.desb);
            as.setFrequency(0);
            subtaskIndexLstmMapper.insert(as);
            count++;
        }
        System.out.println("index_lstm生成完毕");
    }

    @Override
    public void index_nnbuildtask() {
        BuildTask buildTask = new BuildTask();
        String[] s1 = new String[23];
        String[] s2 = new String[23];
        List<ItemList> list = new ArrayList();
        for (int i = 1;i<=100;i++){
            Indexrecommand100 indexrecommand = indexrecommandMapper.select(i);
            Nnrecommand100 nnrecommand = nnrecommandMapper.select(i);
            s1 = buildTask.indexToArray(indexrecommand);
            s2 = buildTask.nnToArray(nnrecommand);
            for (int m = 0;m<10;m++){
                for (int n = 0;n<10;n++){
                    ItemList itemList = new ItemList();
                    itemList.setInputname(s1[1]);
                    itemList.setInputdes(s1[2]);
                    itemList.setItema(s1[m+3]);
                    itemList.setDesa(s1[m+13]);
                    itemList.setItemb(s2[n+3]);
                    itemList.setDesb(s2[n+13]);
                    list.add(itemList);
                }
            }
        }
        //        生成一次就可以了，很耗时间
        int count = 1;
        for (ItemList i: list) {
            SubtaskIndexNn as = new SubtaskIndexNn();
            as.setSubtaskId(count);
            as.setInputName(i.inputname);
            as.setInputDes(i.inputdes);
            as.setItemName1(i.itema);
            as.setItemDes1(i.desa);
            as.setItemName2(i.itemb);
            as.setItemDes2(i.desb);
            as.setFrequency(0);
            subtaskIndexNnMapper.insert(as);
            count++;
        }
        System.out.println("index_nn生成完毕");
    }

    @Override
    public void lstm_nnbuildtask() {
        BuildTask buildTask = new BuildTask();
        String[] s1 = new String[23];
        String[] s2 = new String[23];
        List<ItemList> list = new ArrayList();
        for (int i = 1;i<=100;i++){
            Lstmrecommand100 lstmrecommand = lstmrecommandMapper.select(i);
            Nnrecommand100 nnrecommand = nnrecommandMapper.select(i);
            s1 = buildTask.lstmToArray(lstmrecommand);
            s2 = buildTask.nnToArray(nnrecommand);
            for (int m = 0;m<10;m++){
                for (int n = 0;n<10;n++){
                    ItemList itemList = new ItemList();
                    itemList.setInputname(s1[1]);
                    itemList.setInputdes(s1[2]);
                    itemList.setItema(s1[m+3]);
                    itemList.setDesa(s1[m+13]);
                    itemList.setItemb(s2[n+3]);
                    itemList.setDesb(s2[n+13]);
                    list.add(itemList);
                }
            }
        }
        //        生成一次就可以了，很耗时间
        int count = 1;
        for (ItemList i: list) {
            SubtaskLstmNn as = new SubtaskLstmNn();
            as.setSubtaskId(count);
            as.setInputName(i.inputname);
            as.setInputDes(i.inputdes);
            as.setItemName1(i.itema);
            as.setItemDes1(i.desa);
            as.setItemName2(i.itemb);
            as.setItemDes2(i.desb);
            as.setFrequency(0);
            subtaskLstmNnMapper.insert(as);
            count++;
        }
        System.out.println("lstm_nn生成完毕");
    }
}
