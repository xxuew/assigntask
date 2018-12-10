use assigntask;

DROP TABLE IF EXISTS `divided`;
CREATE TABLE `divided` (
  `divided_id` int(11) NOT NULL AUTO_INCREMENT,
  `alg1_name` varchar(255) DEFAULT NULL,
  `alg2_name` varchar(255) DEFAULT NULL,
  `win_algname` varchar(255)  DEFAULT NULL,
  `result` varchar(255)  DEFAULT NULL,
  `if_final` int  DEFAULT NULL,
  `if_divided` int  DEFAULT NULL,
  PRIMARY KEY (`divided_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sub_task
-- ----------------------------
