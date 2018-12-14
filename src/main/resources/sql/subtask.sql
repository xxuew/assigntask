CREATE TABLE `assigntask`.`sub_task` (
  `subtaskId` INT NOT NULL AUTO_INCREMENT,
  `dividedId` INT NULL COMMENT '该任务属于对比组ID',
  `itemName1` VARCHAR(45) NULL COMMENT '项目1名称',
  `itemName2` VARCHAR(45) NULL,
  `score1` VARCHAR(45) NULL COMMENT 'Item1的得分',
  `score2` VARCHAR(45) NULL,
  `randomNum` INT NULL COMMENT '乱序分配',
  PRIMARY KEY (`subtaskId`));
