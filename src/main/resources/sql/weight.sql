use assigntask;
drop table if exists`weight`;
CREATE TABLE `weight` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `releaseid` int(11) DEFAULT NULL COMMENT '发布任务ID，假设本次发布有100个input',
  `inputid` int(11) DEFAULT NULL COMMENT '检索内容id',
  `algname` varchar(45) DEFAULT NULL COMMENT '算法名称',
  `score` double DEFAULT NULL COMMENT 'Alg的得分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ;
set @@auto_increment_increment=1;
select *from weight;