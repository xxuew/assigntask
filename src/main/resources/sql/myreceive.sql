drop table if exists `myreceive` ;
CREATE TABLE `myreceive` (
  `id` int auto_increment not null unique,
  `userId` int(11) DEFAULT NULL,
  `releaseid` int DEFAULT NULL,
  `dividedid` int DEFAULT NULL,
  `subtaskId_1` int(11) DEFAULT NULL,
  `subtaskId_2` int(11) DEFAULT NULL,
  `subtaskId_3` int(11) DEFAULT NULL,
  `subtaskId_4` int(11) DEFAULT NULL,
  `subtaskId_5` int(11) DEFAULT NULL,
  `subtaskId_6` int(11) DEFAULT NULL,
  `subtaskId_7` int(11) DEFAULT NULL,
  `subtaskId_8` int(11) DEFAULT NULL,
  `subtaskId_9` int(11) DEFAULT NULL,
  `subtaskId_10` int(11) DEFAULT NULL,
  `ifComplete` varchar(45) DEFAULT "未完成"
) ENGINE=InnoDB DEFAULT CHARSET=utf8 auto_increment=1 ;
set @@auto_increment_offset = 1;
SELECT * FROM assigntask.myreceive;