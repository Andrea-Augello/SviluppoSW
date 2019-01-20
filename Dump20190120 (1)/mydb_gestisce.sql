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
-- Table structure for table `gestisce`
--

DROP TABLE IF EXISTS `gestisce`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `gestisce` (
  `Prenotazione_ID` int(11) NOT NULL,
  `PersonaleAmministrativo_ID` int(11) NOT NULL,
  KEY `fk_Prenotazione_has_PersonaleAmministrativo_PersonaleAmmini_idx` (`PersonaleAmministrativo_ID`),
  KEY `fk_Prenotazione_has_PersonaleAmministrativo_Prenotazione1_idx` (`Prenotazione_ID`),
  CONSTRAINT `fk_Prenotazione_has_PersonaleAmministrativo_PersonaleAmminist1` FOREIGN KEY (`PersonaleAmministrativo_ID`) REFERENCES `personaleamministrativo` (`id`),
  CONSTRAINT `fk_Prenotazione_has_PersonaleAmministrativo_Prenotazione1` FOREIGN KEY (`Prenotazione_ID`) REFERENCES `prenotazione` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gestisce`
--

LOCK TABLES `gestisce` WRITE;
/*!40000 ALTER TABLE `gestisce` DISABLE KEYS */;
INSERT INTO `gestisce` VALUES (1,1);
/*!40000 ALTER TABLE `gestisce` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-20 18:15:10
