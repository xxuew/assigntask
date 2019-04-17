use assigntask;
drop table if exists `inputs`;
CREATE TABLE `inputs` (
  `inputid` int(11) NOT NULL AUTO_INCREMENT unique COMMENT '检索ID',
  `inputname` varchar(45) DEFAULT NULL COMMENT '检索内容',
  `inputdes` text DEFAULT NULL COMMENT '检索描述'
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
SELECT * FROM assigntask.`inputs`;

-- insert into assigntask.inputs (inputname,inputdes) select inputname,inputdes from assigntask.cnnrecommand;
INSERT INTO `inputs`(`inputid`, `inputname`, `inputdes`) VALUES (1, '\"Virtual Town\" project', 'This is a map internet web service based on a huge raster maps or satellite images for tracking and monitoring the mobile objects (cars etc) using GPS.');
INSERT INTO `inputs`(`inputid`, `inputname`, `inputdes`) VALUES (2, '#3SAT Solver: Model Listing', '#3SAT finds all satisfiable solutions to a 3CNF Formula. This particular solver can count or return all solutions or a hash of them in binary or Ascii format.');
