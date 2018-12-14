CREATE TABLE `assigntask`.`sub_data` (
  `subdataId` INT NOT NULL AUTO_INCREMENT,
  `subtaskId` INT NULL COMMENT '对应的子任务ID，有必要加，因为randomNum不唯一，再发布任务的时候会再次生成randomNum',
  `userId` INT NULL COMMENT '对应的打分者ID',
  `randomNum` INT NULL COMMENT '对应sub_task的randomNum',
  `score1` INT NULL COMMENT 'Item1得分',
  `score2` INT NULL,
  PRIMARY KEY (`subdataId`));
