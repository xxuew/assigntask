use assigntask;

DROP TABLE IF EXISTS `sub_task`;
CREATE TABLE `sub_task` (
  `subtask_id` int NOT NULL AUTO_INCREMENT,
  `divided_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `item1_name` varchar(255) DEFAULT NULL,
  `item1_des` varchar(255) DEFAULT NULL,
  `item2_name` varchar(255) DEFAULT NULL,
  `item2_des` varchar(255) DEFAULT NULL,
  `item1_score` varchar(255) DEFAULT NULL,
  `item2_score` varchar(255) DEFAULT NULL,


  PRIMARY KEY (`subtask_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;
