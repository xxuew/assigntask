use assigntask;
drop table if exists `releasetables`;
CREATE TABLE `releasetables` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `releaseId` int(11) DEFAULT NULL COMMENT '项目id',
  `inputtable` varchar(45) DEFAULT NULL COMMENT '文本检索内容表',
  `recommandtable` varchar(45) DEFAULT NULL COMMENT '推荐结果表',
  `algname` varchar(45) DEFAULT NULL COMMENT '算法名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
SELECT * FROM assigntask.`releasetables`;