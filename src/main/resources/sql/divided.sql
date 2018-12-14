CREATE TABLE `assigntask`.`divided` (
  `dividedId` INT NOT NULL AUTO_INCREMENT,
  `releaseId` INT NULL COMMENT '发布任务ID，假设本次发布有100个input',
  `inputName` VARCHAR(45) NULL COMMENT '输入项目的名称',
  `algName1` VARCHAR(45) NULL COMMENT '算法1名称',
  `algName2` VARCHAR(45) NULL,
  `ifDivided` VARCHAR(45) NULL DEFAULT 'no' COMMENT '是否已经分发出去',
  `score1` VARCHAR(45) NULL COMMENT 'Alg1的得分',
  `score2` VARCHAR(45) NULL,
  `ifLatest` VARCHAR(45) NULL DEFAULT 'no' COMMENT '是否是算法AB相比的最后一组input',
  `winAlgname` VARCHAR(45) NULL COMMENT '如果是最后一组，算出所有input的AB最后赢的算法名称',
  `ifFinal` VARCHAR(45) NULL DEFAULT 'no' COMMENT '是否是本次发布的100个input的最终结果',
  PRIMARY KEY (`dividedId`));
