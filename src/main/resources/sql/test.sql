use assigntask;

DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `algorithm_id` int(11) NOT NULL AUTO_INCREMENT,
  `algorithm_name` varchar(255) DEFAULT NULL,
  `item_num` int DEFAULT NULL,
  `item_1` varchar(255) DEFAULT NULL,
  `item_2` varchar(255) DEFAULT NULL,
  `item_3` varchar(255) DEFAULT NULL,
  `item_4` varchar(255) DEFAULT NULL,
  `item_5` varchar(255) DEFAULT NULL,
  `item_6` varchar(255) DEFAULT NULL,
  `item_7` varchar(255) DEFAULT NULL,
  `item_8` varchar(255) DEFAULT NULL,
  `item_9` varchar(255) DEFAULT NULL,
  `item_10` varchar(255) DEFAULT NULL,

  PRIMARY KEY (`algorithm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` (algorithm_name,item_num,item_1,item_2,item_3,item_4,item_5,item_6,item_7,item_8,item_9,item_10) VALUES ('A', '10','A1,QQ相似软件', 'A2,QQ相似软件', 'A3,QQ相似软件','A4,QQ相似软件','A5,QQ相似软件','A6,QQ相似软件','A7,QQ相似软件','A8,QQ相似软件','A9,QQ相似软件','A10,QQ相似软件');
INSERT INTO `test` (algorithm_name,item_num,item_1,item_2,item_3,item_4,item_5,item_6,item_7,item_8,item_9,item_10) VALUES ('B','10', 'B1,QQ相似软件', 'B2,QQ相似软件', 'B3,QQ相似软件','B4,QQ相似软件','B5,QQ相似软件','B6,QQ相似软件','B7,QQ相似软件','B8,QQ相似软件','B9,QQ相似软件','B10,QQ相似软件');
INSERT INTO `test` (algorithm_name,item_num,item_1,item_2,item_3,item_4,item_5,item_6,item_7,item_8,item_9,item_10) VALUES ('C','10', 'C1,QQ相似软件', 'C2,QQ相似软件', 'C3,QQ相似软件','C4,QQ相似软件','C5,QQ相似软件','C6,QQ相似软件','C7,QQ相似软件','C8,QQ相似软件','C9,QQ相似软件','C10,QQ相似软件');
