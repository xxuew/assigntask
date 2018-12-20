drop table `subtask_lstm_nn`;
CREATE TABLE `subtask_lstm_nn` (
  `subtaskId` int(11) NOT NULL AUTO_INCREMENT,
  `dividedId` int(11) DEFAULT NULL COMMENT '该任务属于对比组ID',
  `itemName1` varchar(45) DEFAULT NULL COMMENT '项目1名称',
  `itemName2` varchar(45) DEFAULT NULL,
  `itemDes1` text,
  `itemDes2` text,
  `score1` varchar(45) DEFAULT NULL COMMENT 'Item1的得分',
  `score2` varchar(45) DEFAULT NULL,
  `randomNum` int(11) DEFAULT NULL COMMENT '乱序分配',
  `frequency` int(11) DEFAULT '0' COMMENT '分配次数',
  PRIMARY KEY (`subtaskId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
set @@auto_increment_increment=1;
SELECT * FROM assigntask.subtask_lstm_nn;
SELECT * FROM assigntask.subtask_lstm_nn;


drop table `subtask_cnn_tfidf`;
CREATE TABLE `subtask_cnn_tfidf` (
  `subtaskId` int(11) NOT NULL AUTO_INCREMENT,
  `dividedId` int(11) DEFAULT NULL COMMENT '该任务属于对比组ID',
  `itemName1` varchar(45) DEFAULT NULL COMMENT '项目1名称',
  `itemName2` varchar(45) DEFAULT NULL,
  `itemDes1` text,
  `itemDes2` text,
  `score1` varchar(45) DEFAULT NULL COMMENT 'Item1的得分',
  `score2` varchar(45) DEFAULT NULL,
  `randomNum` int(11) DEFAULT NULL COMMENT '乱序分配',
  `frequency` int(11) DEFAULT '0' COMMENT '分配次数',
  PRIMARY KEY (`subtaskId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
set @@auto_increment_increment=1;
SELECT * FROM assigntask.subtask_cnn_tfidf;
SELECT * FROM assigntask.subtask_cnn_tfidf;

drop table `subtask_doc_index`;
CREATE TABLE `subtask_doc_index` (
  `subtaskId` int(11) NOT NULL AUTO_INCREMENT,
  `dividedId` int(11) DEFAULT NULL COMMENT '该任务属于对比组ID',
  `itemName1` varchar(45) DEFAULT NULL COMMENT '项目1名称',
  `itemName2` varchar(45) DEFAULT NULL,
  `itemDes1` text,
  `itemDes2` text,
  `score1` varchar(45) DEFAULT NULL COMMENT 'Item1的得分',
  `score2` varchar(45) DEFAULT NULL,
  `randomNum` int(11) DEFAULT NULL COMMENT '乱序分配',
  `frequency` int(11) DEFAULT '0' COMMENT '分配次数',
  PRIMARY KEY (`subtaskId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
set @@auto_increment_increment=1;
SELECT * FROM assigntask.subtask_doc_index;
SELECT * FROM assigntask.subtask_doc_index;