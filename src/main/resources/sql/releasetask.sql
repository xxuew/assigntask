use assigntask;

DROP TABLE IF EXISTS `releasetask`;
CREATE TABLE `releasetask` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `taskname` varchar(255) DEFAULT NULL,
  `task_data` varchar(255) DEFAULT NULL,
  `plan_id` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `subtask_id` varchar(255) DEFAULT NULL,
  `predict_subnum` varchar(255) DEFAULT NULL,
  `worker_num` varchar(255) DEFAULT NULL,
  `predict_workload` varchar(255) DEFAULT NULL,
  `comple_workload` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `releasetask` VALUES ('1','A', '', '', '','','','','','','');
INSERT INTO `releasetask` VALUES ('3', 'B', '', '', '','','','','','','');
INSERT INTO `releasetask` VALUES ('4', 'C', '', '', '','','','','','','');
INSERT INTO `releasetask` VALUES ('5', 'D', '', '', '','','','','','','');
INSERT INTO `releasetask` VALUES ('7', 'E', '', '', '','','','','','','');

