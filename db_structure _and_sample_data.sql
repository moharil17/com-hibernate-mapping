-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.50 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for school_db
DROP DATABASE IF EXISTS `school_db`;
CREATE DATABASE IF NOT EXISTS `school_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `school_db`;

-- Dumping structure for table school_db.hibernate_sequence
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table school_db.hibernate_sequence: ~6 rows (approximately)
DELETE FROM `hibernate_sequence`;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES
	(1),
	(1),
	(1),
	(1),
	(6),
	(6);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- Dumping structure for table school_db.menu_items
DROP TABLE IF EXISTS `menu_items`;

CREATE TABLE IF NOT EXISTS `menu_items` (
  `menu_id` int(11) NOT NULL,
  `menu_name` varchar(50) NOT NULL,
  `menu_url` varchar(50) NOT NULL,
  PRIMARY KEY (`menu_id`),
  UNIQUE KEY `menu_url` (`menu_url`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table school_db.menu_items: ~2 rows (approximately)
DELETE FROM `menu_items`;
/*!40000 ALTER TABLE `menu_items` DISABLE KEYS */;
INSERT INTO `menu_items` (`menu_id`, `menu_name`, `menu_url`) VALUES
	(1, 'users', '/users'),
	(2, 'register', '/register');
/*!40000 ALTER TABLE `menu_items` ENABLE KEYS */;

-- Dumping structure for table school_db.roles_menu_items_mappings
DROP TABLE IF EXISTS `roles_menu_items_mappings`;
CREATE TABLE IF NOT EXISTS `roles_menu_items_mappings` (
  `role_id` int(5) NOT NULL AUTO_INCREMENT,
  `menu_id` int(5) NOT NULL DEFAULT '1',
  PRIMARY KEY (`role_id`,`menu_id`),
  KEY `FKlmvr8nm8bh6wg1id7qen1rblj` (`menu_id`),
  CONSTRAINT `FKn3la1c9hbnojsd002a30cgiuh` FOREIGN KEY (`role_id`) REFERENCES `user_roles` (`role_id`),
  CONSTRAINT `FK3o869o90s82io6ht09l3rrsyl` FOREIGN KEY (`menu_id`) REFERENCES `menu_items` (`menu_id`),
  CONSTRAINT `FK_roles_menu_items_mappings_menu_items` FOREIGN KEY (`menu_id`) REFERENCES `menu_items` (`menu_id`),
  CONSTRAINT `FK_roles_menu_items_mappings_user_roles` FOREIGN KEY (`role_id`) REFERENCES `user_roles` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table school_db.roles_menu_items_mappings: ~2 rows (approximately)
DELETE FROM `roles_menu_items_mappings`;
/*!40000 ALTER TABLE `roles_menu_items_mappings` DISABLE KEYS */;
INSERT INTO `roles_menu_items_mappings` (`role_id`, `menu_id`) VALUES
	(2, 1),
	(2, 2);
/*!40000 ALTER TABLE `roles_menu_items_mappings` ENABLE KEYS */;

-- Dumping structure for table school_db.student
DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `mobile` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `dob` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table school_db.student: ~4 rows (approximately)
DELETE FROM `student`;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`id`, `fname`, `lname`, `mobile`, `email`, `dob`) VALUES
	(2, 'kalyani', 'moharil', '7083913648', 'kalyani92moharil@gmail.com', '1992-02-17'),
	(3, 'renuka', 'moharil', '7083913648', 'renukamoharil09@gmail.com', '1990-09-10'),
	(4, 'anuradha', 'pitle', '34568842', 'anu@gmail.com', '1989-02-12'),
	(5, 'sanyogita', 'wange', '7564493863', 'sanyo@gmail.com', '1993-10-25');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

-- Dumping structure for table school_db.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `user_password` varchar(10) DEFAULT NULL,
  `user_email` varchar(50) DEFAULT NULL,
  `user_username` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_username` (`user_username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table school_db.user: ~3 rows (approximately)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`user_id`, `user_name`, `user_password`, `user_email`, `user_username`) VALUES
	(1, 'kalyani', '1234', 'kal@134.com', 'kal12'),
	(2, 'renu', '34566', 'ren@23.com', 'ren10'),
	(3, 'anu', '67895', 'anu@34.com', 'anu12');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table school_db.user_roles
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE IF NOT EXISTS `user_roles` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This table defines roles';

-- Dumping data for table school_db.user_roles: ~3 rows (approximately)
DELETE FROM `user_roles`;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` (`role_id`, `role_name`) VALUES
	(1, 'ADMIN'),
	(2, 'USER'),
	(3, 'DBA');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;

-- Dumping structure for table school_db.user_roles_mappings
DROP TABLE IF EXISTS `user_roles_mappings`;
CREATE TABLE IF NOT EXISTS `user_roles_mappings` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_user_roles_mappings_user_roles` (`role_id`),
  CONSTRAINT `FKnytnmnh9kgkw6bi6hhcmqs7jr` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKc82uhp2r3j6hqi4errmqfikie` FOREIGN KEY (`role_id`) REFERENCES `user_roles` (`role_id`),
  CONSTRAINT `FK_user_roles_mappings_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_user_roles_mappings_user_roles` FOREIGN KEY (`role_id`) REFERENCES `user_roles` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table school_db.user_roles_mappings: ~5 rows (approximately)
DELETE FROM `user_roles_mappings`;
/*!40000 ALTER TABLE `user_roles_mappings` DISABLE KEYS */;
INSERT INTO `user_roles_mappings` (`user_id`, `role_id`) VALUES
	(1, 1),
	(1, 2),
	(2, 2),
	(1, 3),
	(3, 3);
/*!40000 ALTER TABLE `user_roles_mappings` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
