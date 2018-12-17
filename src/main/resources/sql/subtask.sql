drop table `subtask`;
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
  PRIMARY KEY (`subtaskId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
set @@auto_increment_increment=1;
SELECT * FROM assigntask.subtask;