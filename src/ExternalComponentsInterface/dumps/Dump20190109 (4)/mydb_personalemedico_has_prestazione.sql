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
-- Table structure for table `personalemedico_has_prestazione`
--

DROP TABLE IF EXISTS `personalemedico_has_prestazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `personalemedico_has_prestazione` (
  `PersonaleMedico_ID` int(11) NOT NULL,
  `Prestazione_ID` int(11) NOT NULL,
  KEY `fk_PersonaleMedico_has_Prestazione_Prestazione1_idx` (`Prestazione_ID`),
  KEY `fk_PersonaleMedico_has_Prestazione_PersonaleMedico1_idx` (`PersonaleMedico_ID`),
  CONSTRAINT `fk_PersonaleMedico_has_Prestazione_PersonaleMedico1` FOREIGN KEY (`PersonaleMedico_ID`) REFERENCES `personalemedico` (`id`),
  CONSTRAINT `fk_PersonaleMedico_has_Prestazione_Prestazione1` FOREIGN KEY (`Prestazione_ID`) REFERENCES `prestazione` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personalemedico_has_prestazione`
--

LOCK TABLES `personalemedico_has_prestazione` WRITE;
/*!40000 ALTER TABLE `personalemedico_has_prestazione` DISABLE KEYS */;
/*!40000 ALTER TABLE `personalemedico_has_prestazione` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-09 14:46:30
