-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.32-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.7.0.6850
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for teretana_db
DROP DATABASE IF EXISTS `teretana_db`;
CREATE DATABASE IF NOT EXISTS `teretana_db` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `teretana_db`;

-- Dumping structure for table teretana_db.clanovi
DROP TABLE IF EXISTS `clanovi`;
CREATE TABLE IF NOT EXISTS `clanovi` (
  `clan_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) NOT NULL,
  `prezime` varchar(50) NOT NULL,
  `broj_telefona` varchar(20) NOT NULL,
  `planovi_id` int(10) unsigned NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`clan_id`) USING BTREE,
  KEY `fk_clanovi_planovi` (`planovi_id`),
  CONSTRAINT `fk_clanovi_planovi` FOREIGN KEY (`planovi_id`) REFERENCES `planovi` (`planovi_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table teretana_db.clanovi: ~15 rows (approximately)
INSERT INTO `clanovi` (`clan_id`, `ime`, `prezime`, `broj_telefona`, `planovi_id`, `updated_at`, `deleted_at`, `end_date`) VALUES
	(1, 'SvIlija', 'Nikolic', '0645567564', 1, NULL, '2024-06-11 10:31:23', NULL),
	(2, 'Niksa', 'Krivokapic', '0645567564', 5, '2024-06-17 21:36:13', NULL, '2024-06-18'),
	(3, 'kjbkj', 'hobjl', '463566', 1, NULL, '2024-06-11 12:41:07', NULL),
	(4, 'Sfghhdfghfgha', 'Nikolic', '0645567564', 1, NULL, NULL, '2024-09-15'),
	(5, 'SvIlija', 'Nikolic', '0645567564', 1, '2024-06-17 17:55:57', NULL, '2024-09-15'),
	(6, 'Tijana', 'Pesic', '252525', 1, '2024-06-11 10:20:27', '2024-06-11 10:32:03', NULL),
	(7, 'Tica', 'Ticicw', '064989453', 1, '2024-06-11 10:32:39', NULL, '2024-09-15'),
	(8, 'Milan ', 'Milanovic', '0649054255', 3, '2024-06-16 21:19:46', NULL, '2024-06-29'),
	(9, '', '', '', 1, NULL, '2024-06-16 18:52:55', NULL),
	(10, 'fasfasf', 'asfasf', '312312', 5, NULL, '2024-06-16 21:18:51', NULL),
	(11, 'QQQ', 'QQQ', '123123', 1, NULL, '2024-06-17 17:55:34', NULL),
	(12, 'Niksici', 'ASfasfasf', '2131212312', 1, NULL, NULL, '2024-09-15'),
	(13, 'Djordje', 'Zivkovic', '123123123123123', 1, NULL, '2024-06-17 18:43:54', '2024-07-17'),
	(14, 'Niksa', 'Minic', '1031646', 1, '2024-06-17 18:43:51', NULL, '2024-09-15'),
	(15, 'Zoran', 'Mihajlovic', '0649054255', 9, NULL, '2024-06-17 21:36:18', '2033-05-01');

-- Dumping structure for table teretana_db.placanja
DROP TABLE IF EXISTS `placanja`;
CREATE TABLE IF NOT EXISTS `placanja` (
  `placanja_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `clan_id` int(11) unsigned NOT NULL,
  `iznos` decimal(10,2) unsigned NOT NULL,
  `datum_uplate` date NOT NULL,
  PRIMARY KEY (`placanja_id`) USING BTREE,
  KEY `fk_placanja_clanovi_clan_id` (`clan_id`),
  CONSTRAINT `fk_placanja_clanovi_clan_id` FOREIGN KEY (`clan_id`) REFERENCES `clanovi` (`clan_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table teretana_db.placanja: ~4 rows (approximately)
INSERT INTO `placanja` (`placanja_id`, `clan_id`, `iznos`, `datum_uplate`) VALUES
	(1, 1, 6500.00, '2024-06-19'),
	(2, 2, 10000.00, '2024-06-20'),
	(3, 3, 5500.00, '2024-06-19'),
	(4, 4, 5695.00, '2024-06-20');

-- Dumping structure for table teretana_db.planovi
DROP TABLE IF EXISTS `planovi`;
CREATE TABLE IF NOT EXISTS `planovi` (
  `planovi_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(100) NOT NULL,
  `cena` decimal(10,2) unsigned NOT NULL,
  `trajanje` int(11) NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`planovi_id`) USING BTREE,
  UNIQUE KEY `uq_planovi_naziv` (`naziv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table teretana_db.planovi: ~9 rows (approximately)
INSERT INTO `planovi` (`planovi_id`, `naziv`, `cena`, `trajanje`, `created_at`, `updated_at`, `deleted_at`) VALUES
	(1, '3 meseca', 6400.00, 90, '2024-06-11 16:54:04', NULL, NULL),
	(2, 'mesec dana', 3200.00, 30, '2024-06-11 16:54:04', NULL, NULL),
	(3, '12 termina', 2500.00, 12, '2024-06-11 16:54:04', NULL, NULL),
	(4, '8 termina', 2200.00, 8, '2024-06-11 16:54:04', NULL, NULL),
	(5, '1 termin', 1000.00, 1, '2024-06-11 16:54:04', NULL, NULL),
	(6, 'Milan ', 950.00, 0, '2024-06-16 08:23:00', NULL, '2024-06-16 18:15:24'),
	(7, 'godinu dana', 25000.00, 360, '2024-06-16 17:43:54', '2024-06-16 18:29:28', '2024-06-16 18:29:37'),
	(8, '8 meseci', 9500.00, 240, '2024-06-16 21:07:37', NULL, NULL),
	(9, '9 godina', 100000.00, 3240, '2024-06-17 15:18:00', '2024-06-17 15:21:10', NULL);



/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
