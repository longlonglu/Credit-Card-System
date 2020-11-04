-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: credit_card_system
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactions` (
  `transactionID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cost` double NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `cardNumber` int(10) NOT NULL,
  `paidTo` varchar(45) DEFAULT 'UNKNOWN',
  PRIMARY KEY (`transactionID`),
  UNIQUE KEY `transactionID_UNIQUE` (`transactionID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES (1,501.5,'2019-08-04 00:00:00',1,'thehousedepot'),(2,39.5,'2019-08-08 00:00:00',7,'valmart'),(3,52,'2019-08-09 00:00:00',7,'thehousedepot'),(4,100.73999999999998,'2019-08-13 00:00:00',8,'bananabees'),(5,103,'2019-08-14 00:00:00',8,'valmart'),(6,-50,'2019-08-14 00:00:00',7,'Payment'),(7,52,'2019-08-15 00:00:00',8,'thehousedepot'),(8,42.5,'2019-08-16 00:00:00',8,'valmart'),(9,20.99,'2019-08-16 00:00:00',8,'bananabees'),(10,57.5,'2019-08-16 00:00:00',8,'valmart'),(11,-111,'2019-08-17 00:00:00',8,'Payment'),(12,86,'2019-08-06 00:00:00',7,'thehousedepot'),(13,74.75999999999999,'2019-08-07 00:00:00',8,'bananabees'),(14,35.98,'2019-08-08 00:00:00',7,'bananabees'),(15,334,'2019-08-09 00:00:00',8,'thehousedepot'),(16,-45,'2019-08-10 00:00:00',7,'Payment'),(17,-200,'2019-08-10 00:00:00',8,'Payment'),(18,-118.47999999999999,'2019-08-13 00:00:00',7,'Payment'),(19,4.56,'2019-08-05 00:00:00',7,'groundfood'),(20,4.9399999999999995,'2019-08-06 00:00:00',7,'groundfood'),(21,85,'2019-08-06 00:00:00',1,'valmart');
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-06 10:14:06
