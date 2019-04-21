package com.wx.assigntask.service;

import org.springframework.stereotype.Service;

@Service
public interface IBuildTaskService {
    void cnn_docbuildtask();
    void cnn_indexbuildtask();
    void cnn_lstmbuildtask();
    void cnn_nnbuildtask();
    void cnn_tfidfbuildtask();
    void tfidf_docbuildtask();
    void tfidf_indexbuildtask();
    void tfidf_lstmbuildtask();
    void tfidf_nnbuildtask();
    void doc_indexbuildtask();
    void doc_lstmbuildtask();
    void doc_nnbuildtask();
    void index_lstmbuildtask();
    void index_nnbuildtask();
    void lstm_nnbuildtask();

}
