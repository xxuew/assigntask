use assigntask;
drop table if exists `plan`;
CREATE TABLE `plan` (
  `planId` int(11) NOT NULL AUTO_INCREMENT,
  `planname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`planId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
set @auto_increment_increment = 1;
insert into  assigntask.plan (planname) values("两两对比排除");
insert into  assigntask.plan (planname) values("先纵再横，算法内排序");
insert into  assigntask.plan (planname) values("层次分析法");

