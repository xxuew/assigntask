use assigntask;
drop table if exists `subtask`;
CREATE TABLE `subtask` (
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

drop table if exists `subtask_lstm_nn`;
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


drop table if exists `subtask_cnn_tfidf`;
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


drop table if exists `subtask_doc_index`;
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

drop table if exists `subtaskfinal_1`;
CREATE TABLE `subtaskfinal_1` (
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

drop table if exists `subtaskfinal_2`;
CREATE TABLE `subtaskfinal_2` (
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

