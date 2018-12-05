use assigntask;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `releaseId` varchar(255) DEFAULT NULL,
  `receivedId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'xx', '123456', '', '');
INSERT INTO `user` VALUES ('33', 'xxx', '123456', '', '');
INSERT INTO `user` VALUES ('34', 'xxxx', '123456', '', '');
INSERT INTO `user` VALUES ('35', 'xxxxx', '123456', '', '');
INSERT INTO `user` VALUES ('37', 'xxxxxx', '123456', '', '');

