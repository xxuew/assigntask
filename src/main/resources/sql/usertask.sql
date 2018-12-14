use assigntask;

DROP TABLE IF EXISTS `usertask`;
CREATE TABLE `usertask` (
  `user_id` int(11) DEFAULT NULL ,
  `subtask_id` int DEFAULT NULL

) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


