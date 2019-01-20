-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ambulatorio`
--

DROP TABLE IF EXISTS `ambulatorio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ambulatorio` (
  `Nome` varchar(20) NOT NULL,
  `Reparto_Nome` varchar(20) NOT NULL,
  PRIMARY KEY (`Nome`),
  KEY `fk_Ambulatorio_Reparto1_idx` (`Reparto_Nome`),
  CONSTRAINT `fk_Ambulatorio_Reparto1` FOREIGN KEY (`Reparto_Nome`) REFERENCES `reparto` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ambulatorio`
--

LOCK TABLES `ambulatorio` WRITE;
/*!40000 ALTER TABLE `ambulatorio` DISABLE KEYS */;
INSERT INTO `ambulatorio` VALUES ('Cardiochirurgia','Cardiologia'),('Endocrinologia gen.','Endocrinologia'),('Chirurgia bariatrica','Gastroenterologia'),('Colposcopia','Ginecologia'),('Neuro. per adulti','Neurochirurgia'),('Amb.Odontoiatria','Odontoiatria'),('Oculistica generale','Oftalmologia'),('Traumatologia','Ortopedia'),('Ostetricia','Ostetricia'),('Foniatria','Otorinolaringoiatria'),('Amb. Ecografia','Radiologia'),('Medicina nucleare','Radiologia');
/*!40000 ALTER TABLE `ambulatorio` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-20 20:21:35
