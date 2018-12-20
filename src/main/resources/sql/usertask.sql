drop table if exists `usertask` ;
CREATE TABLE `usertask` (
  `id` int auto_increment not null unique,
  `userId` int(11) DEFAULT NULL,
  `taskId` int(11) DEFAULT NULL,
  `score1` varchar(45) DEFAULT NULL,
  `score2` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 auto_increment=1 ;
set @@auto_increment_offset = 1;
SELECT * FROM assigntask.usertask;