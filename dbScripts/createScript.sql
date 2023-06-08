
-- Dumping structure for table deltagroup.jobs
CREATE TABLE IF NOT EXISTS deltagroup.jobs
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
CREATE TABLE IF NOT EXISTS deltagroup.news
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
CREATE TABLE IF NOT EXISTS deltagroup.users
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
