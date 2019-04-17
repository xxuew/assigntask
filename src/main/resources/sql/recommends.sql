--------
--该表字段和lstmrecommand、nnrecomand等六个数据源表的字段完全相同，只要这一个entity
--------
use assigntask;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cnnrecommand
-- ----------------------------
DROP TABLE IF EXISTS `recommands`;
CREATE TABLE `recommands` (
  `id` int not null auto_increment unique,
  `inputname` varchar(255) DEFAULT NULL,
  `inputdes` text,
  `des1` text,
  `des2` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `des3` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `des4` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `des5` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `des6` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `des7` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `des8` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `des9` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `des10` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `name1` varchar(255) DEFAULT NULL,
  `name2` varchar(255) DEFAULT NULL,
  `name3` varchar(255) DEFAULT NULL,
  `name4` varchar(255) DEFAULT NULL,
  `name5` varchar(255) DEFAULT NULL,
  `name6` varchar(255) DEFAULT NULL,
  `name7` varchar(255) DEFAULT NULL,
  `name8` varchar(255) DEFAULT NULL,
  `name9` varchar(255) DEFAULT NULL,
  `name10` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 auto_increment=1;
set @auto_increment_offset=1;

alter table assigntask.indexrecommand add id int not null auto_increment unique first;
set @auto_increment_offset=1;
set @auto_increment=1;
alter table assigntask.indexrecommand add releaseid int default null after id;

alter table assigntask.indexrecommand change name inputname varchar(255);
alter table assigntask.indexrecommand change des inputdes text;