use assigntask;
drop table if exists`algresult`;
CREATE TABLE `algresult` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `releaseId` int(11) DEFAULT NULL COMMENT '发布任务ID，假设本次发布有100个input',
  `algName1` varchar(45) DEFAULT NULL COMMENT '算法1名称',
  `algName2` varchar(45) DEFAULT NULL,
  `score1` float DEFAULT NULL COMMENT 'Alg1的得分',
  `score2` float DEFAULT NULL,
  `winAlgname` varchar(45) DEFAULT NULL COMMENT '所有input的AB最后赢的算法名称',
  `iffinal` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ;
set @@auto_increment_increment=1;