-- --------------------------------------------------------
-- Host:                         localhost
-- Versione server:              10.10.3-MariaDB - mariadb.org binary distribution
-- S.O. server:                  Win64
-- HeidiSQL Versione:            12.4.0.6659
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dump della struttura del database simulazionef1
CREATE DATABASE IF NOT EXISTS `simulazionef1` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;
USE `simulazionef1`;

-- Dump della struttura di tabella simulazionef1.costructors
CREATE TABLE IF NOT EXISTS `costructors` (
  `ID` int(11) DEFAULT NULL,
  `Nome` varchar(50) DEFAULT NULL,
  `Tag` varchar(50) DEFAULT NULL,
  `Pilota1ID` int(11) DEFAULT NULL,
  `Pilota2ID` int(11) DEFAULT NULL,
  `RaceEngineer Value` double DEFAULT NULL,
  `TechincalChief Value` double DEFAULT NULL,
  `HeadOfAerodynamics Value` double DEFAULT NULL,
  `SportingDircetor Value` double DEFAULT NULL,
  `PitCrew Value` double DEFAULT NULL,
  `PitCrew Time` double DEFAULT NULL,
  `Durability` double DEFAULT NULL,
  `Chassis` double DEFAULT NULL,
  `Aerodynamics` double DEFAULT NULL,
  `Powertrain` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci COMMENT='Tabella delle scuderie partecipanti alla stagione 2024 di F1\r\n';

-- Dump dei dati della tabella simulazionef1.costructors: ~10 rows (circa)
REPLACE INTO `costructors` (`ID`, `Nome`, `Tag`, `Pilota1ID`, `Pilota2ID`, `RaceEngineer Value`, `TechincalChief Value`, `HeadOfAerodynamics Value`, `SportingDircetor Value`, `PitCrew Value`, `PitCrew Time`, `Durability`, `Chassis`, `Aerodynamics`, `Powertrain`) VALUES
	(1, 'Red Bull Racing', 'RBR', 1, 11, 87.17, 94, 95, 95.25, 61.5, 2.625, 0.436, 0.478, 0.556, 0.542),
	(2, 'Mercedes', 'MER', 44, 63, 88.67, 87.83, 88.13, 94, 54.67, 2.741, 0.409, 0.414, 0.441, 0.549),
	(3, 'Ferrari', 'FER', 16, 55, 87, 94, 90, 94, 58.17, 2.654, 0.392, 0.36, 0.512, 0.588),
	(5, 'Aston Martin', 'ASM', 14, 18, 84.84, 85.17, 83, 86, 55.5, 2.711, 0.412, 0.353, 0.51, 0.549),
	(8, 'AlphaTauri', 'ATH', 3, 22, 81.83, 80, 76.88, 84.25, 58, 2.654, 0.385, 0.333, 0.311, 0.542),
	(6, 'Alpine', 'ALP', 10, 31, 82.33, 78.83, 86.88, 89.25, 57.5, 2.682, 0.402, 0.338, 0.424, 0.515),
	(4, 'McLaren', 'MCL', 4, 81, 82.17, 77, 83.88, 88.5, 59.5, 2.597, 0.434, 0.358, 0.309, 0.549),
	(7, 'Williams', 'WIL', 23, 2, 75.83, 79.17, 71.38, 82.75, 54, 2.711, 0.404, 0.319, 0.355, 0.549),
	(9, 'Alfa Romeo', 'AFR', 77, 24, 80.84, 78, 79, 79.75, 53, 2.768, 0.397, 0.326, 0.306, 0.588),
	(10, 'Haas', 'HAS', 27, 22, 81.34, 82, 78, 76.25, 52.33, 2.796, 0.419, 0.257, 0.382, 0.588);

-- Dump della struttura di tabella simulazionef1.drivers
CREATE TABLE IF NOT EXISTS `drivers` (
  `Numero` int(11) DEFAULT NULL,
  `Nome` varchar(50) DEFAULT NULL,
  `Cognome` varchar(50) DEFAULT NULL,
  `Nazionalità` varchar(50) DEFAULT NULL,
  `ScuderiaID` int(11) unsigned DEFAULT NULL,
  `GPs` int(11) DEFAULT NULL,
  `Overall` double DEFAULT NULL,
  `Reactions` double DEFAULT NULL,
  `Control` double DEFAULT NULL,
  `Smoothness` double DEFAULT NULL,
  `Adaptabity` double DEFAULT NULL,
  `Overtaking` double DEFAULT NULL,
  `Defending` double DEFAULT NULL,
  `Aggressivity` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci COMMENT='Tabella in cui vengono riportati i piloti partecipanti alla stagione 2024 di F1';

-- Dump dei dati della tabella simulazionef1.drivers: ~20 rows (circa)
REPLACE INTO `drivers` (`Numero`, `Nome`, `Cognome`, `Nazionalità`, `ScuderiaID`, `GPs`, `Overall`, `Reactions`, `Control`, `Smoothness`, `Adaptabity`, `Overtaking`, `Defending`, `Aggressivity`) VALUES
	(1, 'Max', 'Verstappen', 'Olanda', 1, 185, 90.75, 88, 89, 88, 88, 91, 97, 70),
	(11, 'Sergio', 'Perez', 'Messico', 1, 257, 88.45, 93, 92, 84, 76, 92, 93, 53),
	(44, 'Lewis', 'Hamilton', 'Regno Unito', 2, 332, 89.85, 86, 92, 86, 87, 90, 94, 57),
	(16, 'Charles', 'Leclerc', 'Monaco', 3, 123, 89, 86, 89, 83, 81, 89, 91, 48),
	(14, 'Fernando', 'Alonso', 'Spagna', 5, 378, 89.65, 86, 94, 87, 86, 91, 91, 67),
	(22, 'Yuki', 'Tsunoda', 'Giappone', 8, 63, 78.95, 81, 73, 78, 74, 81, 79, 85),
	(10, 'Pierre', 'Gasly', 'Francia', 6, 130, 86.15, 82, 93, 90, 95, 85, 84, 53),
	(55, 'Carlos', 'Sainz', 'Spagna', 3, 183, 86.75, 86, 85, 79, 80, 89, 93, 38),
	(4, 'Lando', 'Norris', 'Regno Unito', 4, 104, 87.3, 84, 95, 94, 77, 85, 86, 57),
	(63, 'George', 'Russell', 'Regno Unito', 2, 104, 87.4, 87, 88, 85, 96, 81, 88, 65),
	(18, 'Lance', 'Stroll', 'Canada', 5, 143, 83.05, 80, 85, 81, 93, 84, 85, 75),
	(31, 'Esteban', 'Ocon', 'Francia', 6, 133, 83.8, 82, 84, 83, 81, 83, 84, 51),
	(23, 'Alexander', 'Albon', 'Thailandia', 7, 81, 80.55, 85, 83, 78, 83, 82, 85, 77),
	(77, 'Valtteri', 'Bottas', 'Finlandia', 9, 222, 86.25, 83, 91, 76, 73, 82, 88, 25),
	(3, 'Daniel', 'Ricciardo', 'Australia', 8, 239, 83.05, 82, 87, 87, 79, 85, 83, 67),
	(20, 'Kevin', 'Magnussen', 'Danimarca', 10, 163, 80.6, 83, 83, 78, 91, 79, 76, 53),
	(27, 'Nico', 'Hülkenberg', 'Germania', 10, 203, 79.2, 84, 81, 77, 92, 75, 75, 26),
	(81, 'Oscar', 'Piastri', 'Australia', 4, 22, 75.65, 76, 82, 69, 80, 73, 75, 54),
	(24, 'Guanyu ', 'Zhou', 'Cina', 9, 44, 79.65, 80, 84, 79, 78, 81, 75, 67),
	(2, 'Logan', 'Sargeant', 'USA', 7, 22, 73.1, 76, 74, 69, 75, 66, 71, 24);

-- Dump della struttura di tabella simulazionef1.overtake
CREATE TABLE IF NOT EXISTS `overtake` (
  `Anno` int(11) DEFAULT NULL,
  `1` int(11) DEFAULT NULL,
  `2` int(11) DEFAULT NULL,
  `3` int(11) DEFAULT NULL,
  `4` int(11) DEFAULT NULL,
  `5` int(11) DEFAULT NULL,
  `6` int(11) DEFAULT NULL,
  `7` int(11) DEFAULT NULL,
  `8` int(11) DEFAULT NULL,
  `9` int(11) DEFAULT NULL,
  `10` int(11) DEFAULT NULL,
  `11` int(11) DEFAULT NULL,
  `12` int(11) DEFAULT NULL,
  `13` int(11) DEFAULT NULL,
  `14` int(11) DEFAULT NULL,
  `15` int(11) DEFAULT NULL,
  `16` int(11) DEFAULT NULL,
  `17` int(11) DEFAULT NULL,
  `18` int(11) DEFAULT NULL,
  `19` int(11) DEFAULT NULL,
  `20` int(11) DEFAULT NULL,
  `21` int(11) DEFAULT NULL,
  `22` int(11) DEFAULT NULL,
  `23` int(11) DEFAULT NULL,
  `24` int(11) DEFAULT NULL,
  `Totale` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dump dei dati della tabella simulazionef1.overtake: ~14 rows (circa)
REPLACE INTO `overtake` (`Anno`, `1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `10`, `11`, `12`, `13`, `14`, `15`, `16`, `17`, `18`, `19`, `20`, `21`, `22`, `23`, `24`, `Totale`) VALUES
	(2023, 37, 36, 29, 29, NULL, 62, NULL, 22, 20, 65, 63, 26, 16, 75, 188, 31, 23, 42, 47, 48, 25, 99, 48, 70, 1101),
	(2022, 78, 32, 34, 28, NULL, 52, 18, 13, 35, 48, 67, 31, 61, 74, 23, 58, 23, 16, 85, 24, 77, NULL, NULL, 79, 994),
	(2021, 75, 27, NULL, NULL, NULL, NULL, 42, 0, NULL, 51, 38, 29, 17, NULL, 24, 23, 27, NULL, 32, 23, 65, NULL, 49, 36, 807),
	(2020, 54, NULL, NULL, NULL, NULL, NULL, 10, NULL, NULL, 32, 29, 26, 44, 32, NULL, 36, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 34, 628),
	(2019, 73, NULL, 12, 58, 40, NULL, NULL, 2, 30, 26, 50, 33, 31, 63, NULL, 45, 62, 59, 61, 46, 71, NULL, NULL, 37, 949),
	(2018, 62, NULL, 5, 60, 53, NULL, NULL, 4, 15, 13, 30, 33, 21, 30, NULL, 44, 58, 13, 31, 36, 52, NULL, NULL, 38, 749),
	(2017, 38, NULL, NULL, 19, NULL, NULL, NULL, 3, 34, 20, 13, 39, 9, 42, NULL, 38, 48, 16, 44, 26, 37, NULL, NULL, 12, 509),
	(2016, 90, NULL, 37, 50, 170, NULL, NULL, 14, 33, 54, 78, 16, 12, 50, NULL, 49, NULL, 40, 57, 26, 65, NULL, NULL, 43, 1097),
	(2015, 45, NULL, 11, 37, 32, NULL, NULL, 10, 38, 30, 21, 22, 35, 30, NULL, 33, NULL, 15, 63, 33, 38, NULL, NULL, 31, 629),
	(2014, 74, NULL, 30, 37, 42, NULL, NULL, 10, 32, 43, 43, 43, 52, 62, NULL, 45, NULL, 52, 40, NULL, 41, NULL, NULL, 56, 871),
	(2013, 89, NULL, 59, 34, 84, NULL, NULL, 17, 48, 74, NULL, 92, 28, 64, NULL, 28, NULL, 39, 23, NULL, 68, NULL, NULL, 47, 1029),
	(2012, 81, NULL, 43, 44, 97, NULL, NULL, 13, 48, 56, NULL, 49, 18, 61, NULL, 66, NULL, 64, 69, NULL, 158, NULL, NULL, 56, 1229),
	(2011, NULL, NULL, 31, 80, 98, NULL, NULL, 28, 129, 94, NULL, 30, 75, 99, NULL, 51, NULL, 54, NULL, NULL, 31, NULL, NULL, 68, 1249),
	(2010, 27, NULL, 51, 10, 93, NULL, NULL, 6, 72, 11, NULL, 34, 9, 71, NULL, 19, NULL, 33, NULL, NULL, 36, NULL, NULL, 16, 615);

-- Dump della struttura di tabella simulazionef1.tracks
CREATE TABLE IF NOT EXISTS `tracks` (
  `TrackID` int(11) DEFAULT NULL,
  `Nome` varchar(50) DEFAULT NULL,
  `Nazione` varchar(50) DEFAULT NULL,
  `Località` varchar(50) DEFAULT NULL,
  `Power Index` double DEFAULT NULL,
  `Aero Index` double DEFAULT NULL,
  `Chassis Index` double DEFAULT NULL,
  `AC Index` double DEFAULT NULL,
  `AP Index` double DEFAULT NULL,
  `CP Index` double DEFAULT NULL,
  `Tyre Index` double DEFAULT NULL,
  `Rain Probability` double DEFAULT NULL,
  `NGiri` int(11) DEFAULT NULL,
  `Tempo Giro` double DEFAULT NULL,
  `TempoPitLane` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dump dei dati della tabella simulazionef1.tracks: ~24 rows (circa)
REPLACE INTO `tracks` (`TrackID`, `Nome`, `Nazione`, `Località`, `Power Index`, `Aero Index`, `Chassis Index`, `AC Index`, `AP Index`, `CP Index`, `Tyre Index`, `Rain Probability`, `NGiri`, `Tempo Giro`, `TempoPitLane`) VALUES
	(3, 'Albert Park Grand Prix Circuit', 'Australia', 'Melbourne', 0.41, 0.3, 0.365, 0.165, 0.205, 0.24, 48, 0.05, 58, 80.235, 17),
	(1, 'Bahrain International Circuit', 'Bahrain', 'Sakhir', 0.55, 0.205, 0.335, 0.145, 0.195, 0.26, 70, 0.015, 57, 93.996, 18),
	(10, 'Circuit de Barcelona-Catalunya', 'Spain', 'Montmeló', 0.445, 0.28, 0.395, 0.195, 0.13, 0.235, 57, 0, 66, 76.33, 17),
	(8, 'Circuit de Monaco', 'Monaco', 'Monte-Carlo', 0.315, 0.735, 0.16, 0.08, 0.18, 0.095, 24, 0.2, 78, 75.65, 16),
	(9, 'Circuit Gilles Villeneuve', 'Canada', 'Montreal', 0.47, 0.38, 0.28, 0.13, 0.24, 0.19, 54, 0.05, 70, 74.481, 14),
	(12, 'Silverstone Circuit', 'UK', 'Silverstone', 0.45, 0.275, 0.435, 0.15, 0.2, 0.19, 62, 0.15, 52, 90.275, 22),
	(13, 'Hungaroring', 'Hungary', 'Budapest', 0.345, 0.685, 0.15, 0.11, 0.205, 0.065, 38, 0.2, 70, 80.504, 19),
	(14, 'Circuit de Spa-Francorchamps', 'Belgium', 'Spa', 0.535, 0.185, 0.485, 0.155, 0.105, 0.215, 60, 0.15, 44, 107.305, 16),
	(16, 'Autodromo Nazionale di Monza', 'Italy', 'Monza', 0.695, 0.185, 0.295, 0.3, 0.145, 0.3, 50, 0.1, 51, 85.072, 18),
	(18, 'Marina Bay Street Circuit', 'Singapore', 'Marina Bay', 0.38, 0.705, 0.125, 0.09, 0.19, 0.02, 30, 0.143, 62, 95.867, 17),
	(5, 'Shanghai International Circuit', 'China', 'Shanghai', 0.49, 0.36, 0.305, 0.155, 0.125, 0.185, 40, 0.25, 56, 94.742, 25),
	(21, 'Autódromo José Carlos Pace', 'Brazil', 'São Paulo', 0.535, 0.405, 0.24, 0.8, 0.165, 0.26, 83, 0.25, 71, 72.486, 19),
	(7, 'Autodromo Enzo e Dino Ferrari', 'Italy', 'Imola', 0.455, 0.365, 0.28, 0.195, 0.22, 0.155, 36, 0.25, 63, 78.446, 19),
	(4, 'Suzuka Circuit', 'Japan', 'Suzuka', 0.385, 0.255, 0.515, 0.15, 0.1, 0.27, 56, 0.15, 53, 94.183, 19),
	(24, 'Yas Marina Circuit', 'UAE', 'Abu Dhabi', 0.49, 0.345, 0.28, 0.115, 0.23, 0.21, 80, 0, 58, 86.993, 18),
	(20, 'Autódromo Hermanos Rodríguez', 'Mexico', 'Mexico City', 0.615, 0.225, 0.34, 0.065, 0.17, 0.265, 84, 0, 71, 81.334, 20),
	(15, 'Circuit Park Zandvoort', 'Netherlands', 'Zandvoort', 0.39, 0.515, 0.225, 0.21, 0.205, 0.035, 50, 0.2, 72, 73.837, 19),
	(22, 'Las Vegas Street Circuit', 'USA', 'Nevada', 0.555, 0.3, 0.28, 0.3, 0.19, 0.29, 50, 0.1, 50, 85.921, 19),
	(19, 'Circuit of the Americas', 'USA', 'Austin', 0.43, 0.29, 0.51, 0.175, 0.11, 0.12, 89, 0, 56, 98.139, 19),
	(11, 'Red Bull Ring', 'Austria', 'Spielburg', 0.535, 0.305, 0.315, 0.1, 0.24, 0.19, 52, 0.0526, 71, 67.012, 20),
	(17, 'Baku City Circuit', 'Azerbaijan', 'Baku', 0.54, 0.395, 0.205, 0.12, 0.33, 0.18, 48, 0.025, 51, 103.37, 23),
	(2, 'Jeddah Corniche Circuit', 'Arabia Saudita', 'Gedda', 0.465, 0.235, 0.41, 0.135, 0.165, 0.275, 82, 0.02, 50, 91.906, 19),
	(6, 'Miami International Autodrome', 'USA', 'Miami', 0.47, 0.34, 0.315, 0.2, 0.225, 0.165, 48, 0.075, 57, 89.708, 19),
	(23, 'Lusail International Circuit', 'Qatar', 'Doha', 0.545, 0.185, 0.42, 0.155, 0.22, 0.145, 45, 0.12, 57, 84.319, 19);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
