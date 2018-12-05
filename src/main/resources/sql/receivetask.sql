use assigntask;

DROP TABLE IF EXISTS `receivetask`;
CREATE TABLE `receivetask` (
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
