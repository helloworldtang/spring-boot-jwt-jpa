DROP TABLE IF EXISTS `USER`;
CREATE TABLE `USER` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(80) DEFAULT NULL,
  `FIRST_NAME` varchar(20) DEFAULT NULL,
  `LAST_NAME` varchar(20) DEFAULT NULL,
  `EMAIL` varchar(20) DEFAULT NULL,
  `ENABLED` smallint(2) DEFAULT '1',
  `LAST_PASSWORD_RESET_DATE` datetime ,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

drop TABLE if EXISTS `AUTHORITY`;
CREATE TABLE `AUTHORITY` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO `AUTHORITY` (ID, NAME) VALUES (1, 'ROLE_USER');
INSERT INTO `AUTHORITY` (ID, NAME) VALUES (2, 'ROLE_ADMIN');

drop TABLE if EXISTS USER_AUTHORITY;
CREATE TABLE `USER_AUTHORITY` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_ID` bigint(20) NOT NULL,
  `AUTHORITY_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
INSERT INTO tb_daily_news (title,media_url,source,created_time,updated_time)VALUES ('揭秘比特币和区块链（五）：深入理解比特币交易的脚本','http://www.infoq.com/cn/articles/deep-understanding-of-bitcoin-transaction-script','InfoQ',now(),now());
INSERT INTO tb_daily_news (title,media_url,source,created_time,updated_time)VALUES ('阿里云、Amazon、Google云数据库方案架构与技术分析','http://www.infoq.com/cn/articles/cloud-database-schema-and-technical-analysis','InfoQ',now(),now());
INSERT INTO tb_daily_news (title,media_url,source,created_time,updated_time)VALUES ('大数据挖掘更多时间都在于清洗数据','http://www.infoq.com/cn/articles/more-time-of-big-data-mining-is-used-to-clean-the-data','InfoQ',now(),now());
INSERT INTO tb_daily_news (title,media_url,source,created_time,updated_time)VALUES ('一篇文章全面解析大数据批处理框架Spring Batch','http://www.infoq.com/cn/articles/analysis-of-large-data-batch-framework-spring-batch','InfoQ',now(),now());
INSERT INTO tb_daily_news (title,media_url,source,status,created_time,updated_time)VALUES ('error','error','InfoQ',1,now(),now());
