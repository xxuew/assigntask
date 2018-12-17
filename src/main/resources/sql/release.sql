drop table `release`;
CREATE TABLE `release` (
  `releaseId` int(11) NOT NULL AUTO_INCREMENT,
  `plan` varchar(255) DEFAULT NULL COMMENT '输入查询算法的名称',
  `ifDivided` varchar(45) DEFAULT 'no' COMMENT '输入查询算法的描述',
  `ifComplete` varchar(45) DEFAULT 'no' COMMENT '使用的算法',
  `winAlgname` varchar(45) DEFAULT NULL COMMENT '获胜的算法名称',
  `result` varchar(45) DEFAULT NULL COMMENT '比分情况',
  PRIMARY KEY (`releaseId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
set @@auto_increment_increment=1;
select * from `release`;
