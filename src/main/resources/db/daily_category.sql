DROP TABLE if EXISTS tb_daily_news;
CREATE TABLE `tb_daily_news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` smallint(1) NOT NULL,
  `title` varchar(50) NOT NULL,
  `media_url` varchar(100) NOT NULL,
  `source` varchar(50) NOT NULL,
  `status` smallint(1) DEFAULT '0' COMMENT '0. normal 1. deleted',
  `created_time` datetime DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
ALTER TABLE `tb_daily_news`
ADD COLUMN `category_id`  smallint(1) NOT NULL AFTER `id`;
INSERT INTO `tb_daily_news` (`id`, `title`, `media_url`, `source`, `status`, `created_time`, `updated_time`) VALUES ('1', '揭秘比特币和区块链（五）：深入理解比特币交易的脚本', 'http://www.infoq.com/cn/articles/deep-understanding-of-bitcoin-transaction-script', 'InfoQ', '0', '2017-01-15 19:08:41', '2017-01-15 19:08:41');
INSERT INTO `tb_daily_news` (`id`, `title`, `media_url`, `source`, `status`, `created_time`, `updated_time`) VALUES ('2', '阿里云、Amazon、Google云数据库方案架构与技术分析', 'http://www.infoq.com/cn/articles/cloud-database-schema-and-technical-analysis', 'InfoQ', '0', '2017-01-15 19:10:41', '2017-01-15 19:10:41');
INSERT INTO `tb_daily_news` (`id`, `title`, `media_url`, `source`, `status`, `created_time`, `updated_time`) VALUES ('3', '大数据挖掘更多时间都在于清洗数据', 'http://www.infoq.com/cn/articles/more-time-of-big-data-mining-is-used-to-clean-the-data', 'InfoQ', '0', '2017-01-15 19:15:41', '2017-01-15 19:15:41');
INSERT INTO `tb_daily_news` (`id`, `title`, `media_url`, `source`, `status`, `created_time`, `updated_time`) VALUES ('4', '一篇文章全面解析大数据批处理框架Spring Batch', 'http://www.infoq.com/cn/articles/analysis-of-large-data-batch-framework-spring-batch', 'InfoQ', '0', '2017-01-15 19:20:41', '2017-01-15 19:20:41');
INSERT INTO `tb_daily_news` (`id`, `title`, `media_url`, `source`, `status`, `created_time`, `updated_time`) VALUES ('5', 'error', 'error', 'InfoQ', '1', '2017-01-15 19:22:41', '2017-01-15 19:22:41');
