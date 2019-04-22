drop table if exists `userreceive` ;
CREATE TABLE `userreceive` (
  `id` int auto_increment not null unique,
  `dividedid` int DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `subtaskId` int(11) DEFAULT NULL,
  `score1` double DEFAULT '6',
  `score2` double DEFAULT '7'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 auto_increment=1 ;
set @@auto_increment_offset = 1;
SELECT * FROM assigntask.userreceive;