-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
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
-- Table structure for table `esercita_durante`
--

DROP TABLE IF EXISTS `esercita_durante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `esercita_durante` (
  `FasciaOraria_Data_e_ora` datetime NOT NULL,
  `PersonaleMedico_ID` int(11) NOT NULL,
  KEY `fk_FasciaOraria_has_PersonaleMedico_PersonaleMedico1_idx` (`PersonaleMedico_ID`),
  KEY `fk_FasciaOraria_has_PersonaleMedico_FasciaOraria1_idx` (`FasciaOraria_Data_e_ora`),
  CONSTRAINT `fk_FasciaOraria_has_PersonaleMedico_FasciaOraria1` FOREIGN KEY (`FasciaOraria_Data_e_ora`) REFERENCES `fasciaoraria` (`data_e_ora`),
  CONSTRAINT `fk_FasciaOraria_has_PersonaleMedico_PersonaleMedico1` FOREIGN KEY (`PersonaleMedico_ID`) REFERENCES `personalemedico` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `esercita_durante`
--

LOCK TABLES `esercita_durante` WRITE;
/*!40000 ALTER TABLE `esercita_durante` DISABLE KEYS */;
INSERT INTO `esercita_durante` VALUES ('2019-01-17 09:00:00',1),('2019-01-19 10:00:00',1),('2019-01-29 12:30:00',1),('2019-02-11 08:00:00',1);
/*!40000 ALTER TABLE `esercita_durante` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-18  8:17:30
