use assigntask;

DROP TABLE IF EXISTS `release`;
CREATE TABLE `release` (
  `release_id` int(11) NOT NULL AUTO_INCREMENT,
  `input_name` varchar(255) DEFAULT NULL,
  `input_des` text DEFAULT NULL,
  `algs` varchar(255) DEFAULT NULL,
  `if_complete` int  DEFAULT NULL,
  `win_algname` varchar(255)  DEFAULT NULL,
  `result` varchar(255)  DEFAULT NULL,

  PRIMARY KEY (`release_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sub_task
-- ----------------------------
INSERT INTO `release` (input_name,input_des,algs) VALUES ('QQ', 'QQ describtion','A,B,C');