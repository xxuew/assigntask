use assigntask;
drop table if exists `orderlist` ;
CREATE TABLE `orderlist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dividedid` int(11) DEFAULT NULL,
  `inputid` int(11) DEFAULT NULL,
  `releaseid` int(11) DEFAULT NULL,
  `algname` varchar(45) DEFAULT NULL,
  `itemname` varchar(45) DEFAULT NULL,
  `itemdes` text,
  `score` double DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='算法组内排序表' auto_increment=1;
set @auto_increment_increment=1;

drop tables if exists `orderlstm`;
CREATE TABLE `orderlstm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dividedid` int(11) DEFAULT NULL,
  `inputid` int(11) DEFAULT NULL,
  `releaseid` int(11) DEFAULT NULL,
  `algname` varchar(45) DEFAULT NULL,
  `itemname` varchar(45) DEFAULT NULL,
  `itemdes` text,
  `score` float DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='算法组内排序表' auto_increment=1;
set @auto_increment_increment=1;

drop tables if exists `ordernn`;
CREATE TABLE `ordernn` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dividedid` int(11) DEFAULT NULL,
  `inputid` int(11) DEFAULT NULL,
  `releaseid` int(11) DEFAULT NULL,
  `algname` varchar(45) DEFAULT NULL,
  `itemname` varchar(45) DEFAULT NULL,
  `itemdes` text,
  `score` float DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='算法组内排序表' auto_increment=1;
set @auto_increment_increment=1;

drop tables if exists `ordercnn`;
CREATE TABLE `ordercnn` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dividedid` int(11) DEFAULT NULL,
  `inputid` int(11) DEFAULT NULL,
  `releaseid` int(11) DEFAULT NULL,
  `algname` varchar(45) DEFAULT NULL,
  `itemname` varchar(45) DEFAULT NULL,
  `itemdes` text,
  `score` float DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='算法组内排序表' auto_increment=1;
set @auto_increment_increment=1;

drop tables if exists `ordertfidf`;
CREATE TABLE `ordertfidf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dividedid` int(11) DEFAULT NULL,
  `inputid` int(11) DEFAULT NULL,
  `releaseid` int(11) DEFAULT NULL,
  `algname` varchar(45) DEFAULT NULL,
  `itemname` varchar(45) DEFAULT NULL,
  `itemdes` text,
  `score` float DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='算法组内排序表' auto_increment=1;
set @auto_increment_increment=1;

drop tables if exists `orderindex`;
CREATE TABLE `orderindex` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dividedid` int(11) DEFAULT NULL,
  `inputid` int(11) DEFAULT NULL,
  `releaseid` int(11) DEFAULT NULL,
  `algname` varchar(45) DEFAULT NULL,
  `itemname` varchar(45) DEFAULT NULL,
  `itemdes` text,
  `score` float DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='算法组内排序表' auto_increment=1;
set @auto_increment_increment=1;

drop tables if exists `orderdoc`;
CREATE TABLE `orderdoc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dividedid` int(11) DEFAULT NULL,
  `inputid` int(11) DEFAULT NULL,
  `releaseid` int(11) DEFAULT NULL,
  `algname` varchar(45) DEFAULT NULL,
  `itemname` varchar(45) DEFAULT NULL,
  `itemdes` text,
  `score` float DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='算法组内排序表' auto_increment=1;
set @auto_increment_increment=1;
