use assigntask;

DROP TABLE IF EXISTS `divided`;
CREATE TABLE `divided` (
  `dividedid` int(11) NOT NULL AUTO_INCREMENT,
  `alg1name` varchar(255) DEFAULT NULL,
  `alg2name` varchar(255) DEFAULT NULL,
  `winalgname` varchar(255)  DEFAULT NULL,
  `result` varchar(255)  DEFAULT NULL,
  `iffinal` varchar(255)  DEFAULT "no",
  `ifdivided` varchar(255)  DEFAULT "no",
  PRIMARY KEY (`dividedid`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sub_task
-- ----------------------------
