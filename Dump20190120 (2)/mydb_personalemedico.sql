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
-- Table structure for table `personalemedico`
--

DROP TABLE IF EXISTS `personalemedico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `personalemedico` (
  `ID` int(11) NOT NULL,
  `Nome` varchar(20) NOT NULL,
  `Cognome` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Ambulatorio_Nome` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_PersonaleMedico_Ambulatorio1_idx` (`Ambulatorio_Nome`),
  CONSTRAINT `fk_PersonaleMedico_Ambulatorio1` FOREIGN KEY (`Ambulatorio_Nome`) REFERENCES `ambulatorio` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personalemedico`
--

LOCK TABLES `personalemedico` WRITE;
/*!40000 ALTER TABLE `personalemedico` DISABLE KEYS */;
INSERT INTO `personalemedico` VALUES (1,'Marco','Blasi','password','Cardiochirurgia'),(2,'Carlo','Conti','password','Oculistica generale'),(3,'Pippo','Baudo','password','Foniatria'),(4,'Antonella ','Clerici','password','Amb.Odontoiatria'),(5,'Luisa','Siragusi','password','Medicina nucleare'),(6,'Giuseppe','Verdi','password','Colposcopia'),(7,'Luigi','Bossa','password','Ostetricia'),(8,'Matilde','Guglielmi','password','Amb. Ecografia'),(9,'Giovanni','Romani','password','Neuro. per adulti'),(10,'Clelia','Esposito','password','Chirurgia bariatrica'),(11,'Ciro','Russo','password','Endocrinologia gen.'),(12,'Paola','Dentini','password','Traumatologia');
/*!40000 ALTER TABLE `personalemedico` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-20 20:21:33
