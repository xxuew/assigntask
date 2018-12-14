use assigntask;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `release_id` varchar(255) DEFAULT NULL,
  `received_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` (username, password)VALUES ('xx', '123456');
INSERT INTO `user` (username, password)VALUES ('xxx', '123456');
INSERT INTO `user` (username,password)VALUES ('xxxx', '123456');
INSERT INTO `user` (username, password)VALUES ('xxxxx', '123456');
INSERT INTO `user` (username, password)VALUES ('xxxxxx', '123456');

