drop table `divided`;
CREATE TABLE `divided` (
  `dividedId` int(11) NOT NULL AUTO_INCREMENT,
  `releaseId` int(11) DEFAULT NULL COMMENT '发布任务ID，假设本次发布有100个input',
  `inputName` varchar(45) DEFAULT NULL COMMENT '输入项目的名称',
  `algName1` varchar(45) DEFAULT NULL COMMENT '算法1名称',
  `algName2` varchar(45) DEFAULT NULL,
  `ifDivided` varchar(45) DEFAULT 'no' COMMENT '是否已经分发出去',
  `score1` varchar(45) DEFAULT NULL COMMENT 'Alg1的得分',
  `score2` varchar(45) DEFAULT NULL,
  `ifLatest` varchar(45) DEFAULT 'no' COMMENT '是否是算法AB相比的最后一组input',
  `winAlgname` varchar(45) DEFAULT NULL COMMENT '如果是最后一组，算出所有input的AB最后赢的算法名称',
  `ifFinal` varchar(45) DEFAULT 'no' COMMENT '是否是本次发布的100个input的最终结果',
  PRIMARY KEY (`dividedId`)
) ENGINE=InnoDB AUTO_INCREMENT=1  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ;
set @@auto_increment_increment=1;
SELECT * FROM assigntask.divided;


