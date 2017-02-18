DROP TABLE IF EXISTS `reviews`;
CREATE TABLE IF NOT EXISTS `reviews` (
  `id` int(11) unsigned NOT NULL,
  `author` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `version` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rate` tinyint(1) DEFAULT NULL,
  `title` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `comment` text COLLATE utf8_unicode_ci,
  `country` varchar(2) COLLATE utf8_unicode_ci DEFAULT '',
  `app` int(11) DEFAULT NULL,
  `retrieved_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `emailed` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `apps`;
CREATE TABLE IF NOT EXISTS `apps` (
  `id` int(11) unsigned NOT NULL COMMENT 'ID from the app store',
  `name` varchar(60) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `countries` text COLLATE utf8_unicode_ci COMMENT 'Comma separated countries or null for all',
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `iphone` tinyint(1) NOT NULL DEFAULT '0',
  `ipad` tinyint(1) NOT NULL DEFAULT '0',
  `osx` tinyint(1) NOT NULL DEFAULT '0',
  `image_url` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `app_store_url` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


