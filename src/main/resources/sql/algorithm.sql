use assigntask;

DROP TABLE IF EXISTS `algorithm`;
CREATE TABLE `algorithm` (
  `algorithm_id` int(11) NOT NULL AUTO_INCREMENT,
  `algorithm_name` varchar(255) DEFAULT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `input_name` varchar(255) DEFAULT NULL,
  `input_des` text DEFAULT NULL,

  PRIMARY KEY (`algorithm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `algorithm` (algorithm_name,item_num,item_1,item_2,item_3,item_4,item_5,item_6,item_7,item_8,item_9,item_10) VALUES ('A', '10','A1,QQ相似软件', 'A2,QQ相似软件', 'A3,QQ相似软件','A4,QQ相似软件','A5,QQ相似软件','A6,QQ相似软件','A7,QQ相似软件','A8,QQ相似软件','A9,QQ相似软件','A10,QQ相似软件');
INSERT INTO `algorithm` (algorithm_name,item_num,item_1,item_2,item_3,item_4,item_5,item_6,item_7,item_8,item_9,item_10) VALUES ('B','10', 'B1,QQ相似软件', 'B2,QQ相似软件', 'B3,QQ相似软件','B4,QQ相似软件','B5,QQ相似软件','B6,QQ相似软件','B7,QQ相似软件','B8,QQ相似软件','B9,QQ相似软件','B10,QQ相似软件');
INSERT INTO `algorithm` (algorithm_name,item_num,item_1,item_2,item_3,item_4,item_5,item_6,item_7,item_8,item_9,item_10) VALUES ('C','10', 'C1,QQ相似软件', 'C2,QQ相似软件', 'C3,QQ相似软件','C4,QQ相似软件','C5,QQ相似软件','C6,QQ相似软件','C7,QQ相似软件','C8,QQ相似软件','C9,QQ相似软件','C10,QQ相似软件');

USE assigntask;

INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('A', 'A1','QQ', 'QQ describtion');
INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('A', 'A2','QQ', 'QQ describtion');
INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('A', 'A3','QQ', 'QQ describtion');
INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('A', 'A4','QQ', 'QQ describtion');
INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('A', 'A5','QQ', 'QQ describtion');
INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('A', 'A6','QQ', 'QQ describtion');
INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('A', 'A7','QQ', 'QQ describtion');
INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('A', 'A8','QQ', 'QQ describtion');
INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('A', 'A9','QQ', 'QQ describtion');
INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('A', 'A10','QQ', 'QQ describtion');
INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('B', 'B1','QQ', 'QQ describtion');
INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('B', 'B2','QQ', 'QQ describtion');
INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('B', 'B3','QQ', 'QQ describtion');
INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('B', 'B4','QQ', 'QQ describtion');
INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('B', 'B5','QQ', 'QQ describtion');
INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('B', 'B6','QQ', 'QQ describtion');
INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('B', 'B7','QQ', 'QQ describtion');
INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('B', 'B8','QQ', 'QQ describtion');
INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('B', 'B9','QQ', 'QQ describtion');
INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('B', 'B10','QQ', 'QQ describtion');
INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('C', 'C1','QQ', 'QQ describtion');
INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('C', 'C2','QQ', 'QQ describtion');
INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('C', 'C3','QQ', 'QQ describtion');
INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('C', 'C4','QQ', 'QQ describtion');
INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('C', 'C5','QQ', 'QQ describtion');
INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('C', 'C6','QQ', 'QQ describtion');
INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('C', 'C7','QQ', 'QQ describtion');
INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('C', 'C8','QQ', 'QQ describtion');
INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('C', 'C9','QQ', 'QQ describtion');
INSERT INTO `algorithm` (algorithm_name,item_name,input_name,input_des) VALUES ('C', 'C10','QQ', 'QQ describtion');