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
-- Table structure for table `prestazione`
--

DROP TABLE IF EXISTS `prestazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `prestazione` (
  `ID` int(11) NOT NULL,
  `Nome` varchar(45) NOT NULL,
  `Costo` float DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestazione`
--

LOCK TABLES `prestazione` WRITE;
/*!40000 ALTER TABLE `prestazione` DISABLE KEYS */;
INSERT INTO `prestazione` VALUES (1,'Anastomosi mesenterica-cava ',5170),(38,'Iniezione di farmaci citotossici',52.53),(90,'Incisione di ghiandola lacrimale',34.67),(208,'Interventi sulla tuba di eustachio',12.87),(391,'Iniezione di anestetico nel canale vertebrale',105.05),(532,'Iniezione di agenti neurolitici',131.3),(600,'Drenaggio ascesso prostatico',27.73),(601,'Aspirazione nella regione tiroidea',99.8),(613,'Biopsia delle paratiroidi',68.28),(787,'Osteoclasia',19.85),(801,'Incisione del margine palpebrale',13.86),(802,'Apertura di blefarorrafia',13.86),(809,'Altra incisione della palpebra',13.86),(811,'Biopsia della palpebra',13.86),(821,'Asportazione di calazio',27.73),(825,'Demolizione di lesione della palpebra',34.67),(891,'Depilazione elettrochirurgica della palpebra',23.11),(892,'Depilazione criochirurgica della palpebra',23.11),(911,'Biopsia della ghiandola lacrimale',57.78),(912,'Biopsia del sacco lacrimale',41.6),(921,'Specillazione del punto lacrimale',13.86),(951,'Incisione del punto lacrimale',34.67),(953,'Incisione del sacco lacrimale',34.67),(971,'Correzione di eversione del punto lacrimale',57.78),(973,'Riparazione dei canalicoli',210.09),(1021,'Biopsia della congiuntiva',16.18),(1371,'Intervento di cataratta',900),(2031,'Elettrococleografia',55.15),(2032,'Biopsia dell\'orecchio medio',22.06),(2039,'Otoemissioni acustiche SOAE',9.19),(2101,'Controllo di epistassi mediante tamponamento',12.87),(2122,'Biopsia del naso',22.06),(2411,'Biopsia della gengiva',14.18),(2412,'Biopsia dell\'alveolo',14.18),(2439,'Levigatura delle radici',23.64),(2470,'Trattamento ortodontico con apparecchi',118.18),(4019,'Agopiopsia linfonoidale eco-guidata',94.54),(4071,'Resezione dei nervi periferici',52),(4111,'Biopsia dei nervi periferici',52),(4224,'Biopsia endoscopica dell\'esofago',46.74),(4229,'Test di Bernstein',14.18),(4523,'Colonoscopia con endoscopio flessibile',63.02),(4829,'Manometria ano-rettale',59.35),(4901,'Incisione di ascesso perianale',35.45),(6111,'Biopsia della tiroide',44.12),(6992,'Inseminazione artificiale',13.13),(7510,'Amniocentesi precoce',78.79),(7534,'Cardiotocografia',16.7),(7900,'Riduzione chiusa di frattura',52.53),(8321,'Biopsia dei tessuti molli',84.03),(8703,'Tomografia computerizzata',159.67),(8827,'Radiografia di Gamba',23.64),(8828,'Radiografia di piede e caviglia',19.96),(8829,'Radiografia completa degli arti inferiori',30.72),(8831,'Radiografia completa del lattante',22.85),(8991,'Infiltrazione di angioma palpebrale',13.86);
/*!40000 ALTER TABLE `prestazione` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-20 18:15:09
