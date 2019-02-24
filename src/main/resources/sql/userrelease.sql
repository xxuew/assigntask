drop table if exists `userrelease` ;
CREATE TABLE `userrelease` (
  `id` int auto_increment not null unique,
  `userId` int(11) DEFAULT NULL,
  `releaseId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 auto_increment=1 ;
set @@auto_increment_offset = 1;
SELECT * FROM assigntask.userrelease;