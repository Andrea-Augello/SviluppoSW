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
-- Table structure for table `prenotazione`
--

DROP TABLE IF EXISTS `prenotazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `prenotazione` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Regime` varchar(20) NOT NULL,
  `Limite_massimo` date NOT NULL,
  `Paziente_CF` varchar(16) NOT NULL,
  `FasciaOraria_Data_e_ora` datetime NOT NULL,
  `Prestazione_ID` int(11) NOT NULL,
  `Ricetta_Numero_ricetta` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_Prenotazione_Paziente1_idx` (`Paziente_CF`),
  KEY `fk_Prenotazione_FasciaOraria1_idx` (`FasciaOraria_Data_e_ora`),
  KEY `fk_Prenotazione_Prestazione1_idx` (`Prestazione_ID`),
  KEY `fk_Prenotazione_Ricetta1_idx` (`Ricetta_Numero_ricetta`),
  CONSTRAINT `fk_Prenotazione_FasciaOraria1` FOREIGN KEY (`FasciaOraria_Data_e_ora`) REFERENCES `fasciaoraria` (`data_e_ora`),
  CONSTRAINT `fk_Prenotazione_Paziente1` FOREIGN KEY (`Paziente_CF`) REFERENCES `paziente` (`cf`),
  CONSTRAINT `fk_Prenotazione_Prestazione1` FOREIGN KEY (`Prestazione_ID`) REFERENCES `prestazione` (`id`),
  CONSTRAINT `fk_Prenotazione_Ricetta1` FOREIGN KEY (`Ricetta_Numero_ricetta`) REFERENCES `ricetta` (`numero_ricetta`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenotazione`
--

LOCK TABLES `prenotazione` WRITE;
/*!40000 ALTER TABLE `prenotazione` DISABLE KEYS */;
INSERT INTO `prenotazione` VALUES (1,'SSN','2019-02-02','GLLNDR98R05G273M','1000-01-01 00:00:00',104,'000000000000000000');
/*!40000 ALTER TABLE `prenotazione` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-09 14:46:29
