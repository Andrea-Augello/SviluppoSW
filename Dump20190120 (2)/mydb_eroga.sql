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
-- Table structure for table `eroga`
--

DROP TABLE IF EXISTS `eroga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `eroga` (
  `PersonaleMedico_ID` int(11) NOT NULL,
  `Prestazione_ID` int(11) NOT NULL,
  KEY `fk_PersonaleMedico_has_Prestazione_Prestazione1_idx` (`Prestazione_ID`),
  KEY `fk_PersonaleMedico_has_Prestazione_PersonaleMedico1_idx` (`PersonaleMedico_ID`),
  CONSTRAINT `fk_PersonaleMedico_has_Prestazione_PersonaleMedico1` FOREIGN KEY (`PersonaleMedico_ID`) REFERENCES `personalemedico` (`id`),
  CONSTRAINT `fk_PersonaleMedico_has_Prestazione_Prestazione1` FOREIGN KEY (`Prestazione_ID`) REFERENCES `prestazione` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eroga`
--

LOCK TABLES `eroga` WRITE;
/*!40000 ALTER TABLE `eroga` DISABLE KEYS */;
INSERT INTO `eroga` VALUES (1,1),(2,801),(2,802),(2,809),(2,811),(2,821),(2,825),(2,891),(2,892),(2,911),(2,912),(2,921),(2,951),(2,953),(2,971),(2,973),(2,1021),(2,1371),(3,2031),(3,2032),(3,2039),(3,2101),(3,2122),(4,2411),(4,2412),(4,2439),(4,2470),(8,4019),(9,4071),(9,4111),(10,4224),(10,4229),(10,4523),(10,4829),(10,4901),(11,6111),(7,7510),(7,7534),(12,7900),(8,8321),(8,8703),(5,8703),(5,8827),(5,8828),(5,8829),(5,8831),(2,8991),(9,38),(2,90),(3,208),(9,391),(9,532),(11,601),(11,613),(12,787),(7,6992);
/*!40000 ALTER TABLE `eroga` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-20 20:21:32
