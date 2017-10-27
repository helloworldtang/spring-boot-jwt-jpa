DROP TABLE IF EXISTS `tb_sys_user`;
CREATE TABLE `tb_sys_user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(80) DEFAULT NULL,
  `FIRST_NAME` varchar(20) DEFAULT NULL,
  `LAST_NAME` varchar(20) DEFAULT NULL,
  `EMAIL` varchar(20) DEFAULT NULL,
  `ENABLED` tinyint(1) DEFAULT '1',
  `LAST_PASSWORD_RESET_DATE` datetime ,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO tb_sys_user (`ID`, `USERNAME`, `PASSWORD`, `FIRST_NAME`, `LAST_NAME`, `EMAIL`, `ENABLED`, `LAST_PASSWORD_RESET_DATE`) VALUES ('1', 'admin', '$2a$10$THH.Q1RfZanbGG9cY40AM.FevYW4nt4oyRlmKpn3J0236EmZLoCVW', 'Chen', 'Tang', '793059909@qq.com', '1', '2017-01-15 17:16:33');

DROP TABLE if EXISTS `tb_sys_authority`;
CREATE TABLE `tb_sys_authority` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO `tb_sys_authority` (ID, NAME) VALUES (1, 'ROLE_ADMIN');
INSERT INTO `tb_sys_authority` (ID, NAME) VALUES (2, 'ROLE_USER');

DROP TABLE if EXISTS tb_sys_user_authority;
CREATE TABLE `tb_sys_user_authority` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `SYS_USER_ID` bigint(20) NOT NULL,
  `SYS_AUTHORITY_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO tb_sys_user_authority (SYS_USER_ID, SYS_AUTHORITY_ID) VALUES (1, 1);

DROP TABLE if EXISTS tb_daily_category;
CREATE TABLE `tb_daily_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `media_url` varchar(100) NOT NULL,
  `status` smallint(1) DEFAULT '0' COMMENT '0. normal 1. deleted',
  `created_time` datetime DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;