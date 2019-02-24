use assigntask;
drop table if exists `release`;
CREATE TABLE `release` (
  `releaseId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int DEFAULT NULL COMMENT '发布者ID',
  `releaseName` varchar(45) DEFAULT NULL COMMENT '任务名称',
  `plan` varchar(45) DEFAULT NULL COMMENT '选取的生成方案',
  `algNames` varchar(45) DEFAULT NULL,
  `ifDivided` varchar(45) DEFAULT 'no' COMMENT '输入查询算法的描述',
  `ifComplete` varchar(45) DEFAULT 'no' COMMENT '使用的算法',
  `winAlgname` varchar(45) DEFAULT NULL COMMENT '获胜的算法名称',
  `result` varchar(45) DEFAULT NULL COMMENT '比分情况',
  PRIMARY KEY (`releaseId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
SELECT * FROM assigntask.`release`;