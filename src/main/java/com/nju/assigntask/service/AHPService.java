package com.nju.assigntask.service;

import com.nju.assigntask.comment.ItemList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AHPService {
    List<ItemList> CreatTask();
}
