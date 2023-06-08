-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.5.18-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;


-- Dumping database structure for deltagroup
CREATE DATABASE IF NOT EXISTS `deltagroup` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;
USE `deltagroup`;

-- Dumping structure for table deltagroup.jobs
CREATE TABLE IF NOT EXISTS `jobs`
(
    `job_id`      int(11)       NOT NULL AUTO_INCREMENT,
    `name`        varchar(100)  NOT NULL,
    `is_active`   tinyint(1) DEFAULT 0,
    `description` varchar(3000) NOT NULL,
    PRIMARY KEY (`job_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 12
  DEFAULT CHARSET = latin1
  COLLATE = latin1_swedish_ci;

-- Data exporting was unselected.

-- Dumping structure for table deltagroup.news
CREATE TABLE IF NOT EXISTS `news`
(
    `name`        varchar(200) NOT NULL,
    `description` varchar(3000)         DEFAULT NULL,
    `small_name`  varchar(23)           DEFAULT NULL,
    `photos`      varchar(200)          DEFAULT NULL,
    `news_id`     int(11)      NOT NULL AUTO_INCREMENT,
    `date`        timestamp    NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
    PRIMARY KEY (`news_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = latin1
  COLLATE = latin1_swedish_ci;

-- Data exporting was unselected.

-- Dumping structure for table deltagroup.users
CREATE TABLE IF NOT EXISTS `users`
(
    `username`  varchar(32) NOT NULL,
    `password`  varchar(32) NOT NULL,
    `isAdmin`   tinyint(1) DEFAULT 0,
    `user_id`   int(11)     NOT NULL,
    `email`     varchar(30) NOT NULL,
    `isBlocked` tinyint(1) DEFAULT 0,
    PRIMARY KEY (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1
  COLLATE = latin1_swedish_ci;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE = IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS = IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES = IFNULL(@OLD_SQL_NOTES, 1) */;
