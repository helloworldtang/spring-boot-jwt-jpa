DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
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
INSERT INTO tb_user (`ID`, `USERNAME`, `PASSWORD`, `FIRST_NAME`, `LAST_NAME`, `EMAIL`, `ENABLED`, `LAST_PASSWORD_RESET_DATE`) VALUES ('1', 'admin', '$2a$10$THH.Q1RfZanbGG9cY40AM.FevYW4nt4oyRlmKpn3J0236EmZLoCVW', 'Chen', 'Tang', '793059909@qq.com', '1', '2017-01-15 17:16:33');

drop TABLE if EXISTS `tb_authority`;
CREATE TABLE `tb_authority` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO `tb_authority` (ID, NAME) VALUES (1, 'ROLE_ADMIN');
INSERT INTO `tb_authority` (ID, NAME) VALUES (2, 'ROLE_USER');

drop TABLE if EXISTS tb_user_authority;
CREATE TABLE `tb_user_authority` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_ID` bigint(20) NOT NULL,
  `AUTHORITY_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO tb_user_authority (USER_ID, AUTHORITY_ID) VALUES (1, 2);


drop TABLE if EXISTS tb_daily_news;
create table tb_daily_news(
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `media_url` varchar(100) NOT NULL,
  `source` varchar(50) NOT NULL,
  `status` smallint(1) DEFAULT '0' COMMENT '0. normal 1. deleted',
  `created_time` datetime DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO `tb_daily_news` (`id`, `title`, `media_url`, `source`, `status`, `created_time`, `updated_time`) VALUES ('1', '揭秘比特币和区块链（五）：深入理解比特币交易的脚本', 'http://www.infoq.com/cn/articles/deep-understanding-of-bitcoin-transaction-script', 'InfoQ', '0', '2017-01-15 19:08:41', '2017-01-15 19:08:41');
INSERT INTO `tb_daily_news` (`id`, `title`, `media_url`, `source`, `status`, `created_time`, `updated_time`) VALUES ('2', '阿里云、Amazon、Google云数据库方案架构与技术分析', 'http://www.infoq.com/cn/articles/cloud-database-schema-and-technical-analysis', 'InfoQ', '0', '2017-01-15 19:10:41', '2017-01-15 19:10:41');
INSERT INTO `tb_daily_news` (`id`, `title`, `media_url`, `source`, `status`, `created_time`, `updated_time`) VALUES ('3', '大数据挖掘更多时间都在于清洗数据', 'http://www.infoq.com/cn/articles/more-time-of-big-data-mining-is-used-to-clean-the-data', 'InfoQ', '0', '2017-01-15 19:15:41', '2017-01-15 19:15:41');
INSERT INTO `tb_daily_news` (`id`, `title`, `media_url`, `source`, `status`, `created_time`, `updated_time`) VALUES ('4', '一篇文章全面解析大数据批处理框架Spring Batch', 'http://www.infoq.com/cn/articles/analysis-of-large-data-batch-framework-spring-batch', 'InfoQ', '0', '2017-01-15 19:20:41', '2017-01-15 19:20:41');
INSERT INTO `tb_daily_news` (`id`, `title`, `media_url`, `source`, `status`, `created_time`, `updated_time`) VALUES ('5', 'error', 'error', 'InfoQ', '1', '2017-01-15 19:22:41', '2017-01-15 19:22:41');
