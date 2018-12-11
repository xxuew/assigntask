use assigntask;

DROP TABLE IF EXISTS `release`;
CREATE TABLE `release` (
  `releaseid` int(11) NOT NULL AUTO_INCREMENT,
  `inputname` varchar(255) DEFAULT NULL,
  `inputdes` text DEFAULT NULL,
  `alg` varchar(255) DEFAULT NULL,
  `ifdivided` varchar(255) DEFAULT "no",
  `ifcomplete` varchar(255)  DEFAULT "no" ,
  `winalgname` varchar(255)  DEFAULT NULL,
  `result` varchar(255)  DEFAULT NULL,

  PRIMARY KEY (`releaseid`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sub_task
-- ----------------------------
INSERT INTO `release` (inputname,inputdes,alg) VALUES ('QQ', 'QQ describtion','A');
INSERT INTO `release` (inputname,inputdes,alg) VALUES ('QQ', 'QQ describtion','B');
INSERT INTO `release` (inputname,inputdes,alg) VALUES ('QQ', 'QQ describtion','C');