use assigntask;
drop table if exists `recommend`;
CREATE TABLE `recommend` (
  `id` int(11) NOT NULL AUTO_INCREMENT unique ,
  `inputid` int DEFAULT NULL COMMENT '检索ID',
  `itemname` varchar(45) DEFAULT NULL COMMENT '推荐名称',
  `itemdes` text DEFAULT NULL COMMENT '推荐描述'

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
SELECT * FROM assigntask.`recommend`;

-- insert into assigntask.test1recommand (inputid,itemname,itemdes) select id,name10,des10 from assigntask.lstmrecommand where id=1;
use assigntask;
drop table if exists `test1recommand`;
CREATE TABLE `test1recommand` (
  `id` int(11) NOT NULL AUTO_INCREMENT unique ,
  `inputid` int DEFAULT NULL COMMENT '检索ID',
  `itemname` varchar(45) DEFAULT NULL COMMENT '推荐名称',
  `itemdes` text DEFAULT NULL COMMENT '推荐描述'

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
SELECT * FROM assigntask.`test1recommand`;

use assigntask;
drop table if exists `test2recommand`;
CREATE TABLE `test2recommand` (
  `id` int(11) NOT NULL AUTO_INCREMENT unique ,
  `inputid` int DEFAULT NULL COMMENT '检索ID',
  `itemname` varchar(45) DEFAULT NULL COMMENT '推荐名称',
  `itemdes` text DEFAULT NULL COMMENT '推荐描述'

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
SELECT * FROM assigntask.`test2recommand`;

