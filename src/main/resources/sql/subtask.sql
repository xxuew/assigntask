use assigntask;
drop table if exists `subtask`;
CREATE TABLE `subtask` (
  `subtaskid` int(11) NOT NULL AUTO_INCREMENT,
  `dividedid` int(11) DEFAULT NULL COMMENT '该任务属于对比组ID',
  `itemname1` varchar(45) DEFAULT NULL COMMENT '项目1名称',
  `itemname2` varchar(45) DEFAULT NULL,
  `itemdes1` text,
  `itemdes2` text,
  `score1` double DEFAULT NULL COMMENT 'Item1的得分',
  `score2` double DEFAULT NULL,
  `randomnum` int(11) DEFAULT NULL COMMENT '乱序分配',
  `frequency` int(11) DEFAULT '0' COMMENT '分配次数',
  PRIMARY KEY (`subtaskId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
set @@auto_increment_increment=1;

