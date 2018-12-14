CREATE TABLE `assigntask`.`release` (
  `releaseId` INT NOT NULL AUTO_INCREMENT,
  `inputName` VARCHAR(45) NULL DEFAULT NULL COMMENT '输入查询算法的名称',
  `inputDes` VARCHAR(45) NULL DEFAULT NULL COMMENT '输入查询算法的描述',
  `algs` VARCHAR(45) NULL DEFAULT NULL COMMENT '使用的算法',
  `ifComplete` VARCHAR(45) NULL DEFAULT 'no' COMMENT '是否完成',
  `winAlgname` VARCHAR(45) NULL COMMENT '获胜的算法名称',
  `result` VARCHAR(45) NULL COMMENT '比分情况',
  PRIMARY KEY (`releaseId`));

-- ----------------------------
-- Records of sub_task
-- ----------------------------
INSERT INTO `release` (inputname,inputdes,alg) VALUES ('QQ', 'QQ describtion','A');
INSERT INTO `release` (inputname,inputdes,alg) VALUES ('QQ', 'QQ describtion','B');
INSERT INTO `release` (inputname,inputdes,alg) VALUES ('QQ', 'QQ describtion','C');