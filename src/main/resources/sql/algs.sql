use assigntask;
drop table if exists `algs`;
CREATE TABLE `algs` (
  `algId` int(11) NOT NULL AUTO_INCREMENT,
  `algname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`algId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
set @auto_increment_increment = 1;
