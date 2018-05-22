-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: myexhibitions
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `expositions`
--

DROP TABLE IF EXISTS `expositions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expositions` (
  `expositionId` int(11) NOT NULL AUTO_INCREMENT,
  `expositionTitle` varchar(45) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `topic` varchar(45) NOT NULL,
  `showroomId` int(11) NOT NULL,
  `startDate` date DEFAULT NULL,
  `finishDate` date DEFAULT NULL,
  PRIMARY KEY (`expositionId`),
  KEY `showroomId_idx` (`showroomId`),
  CONSTRAINT `showroomId` FOREIGN KEY (`showroomId`) REFERENCES `showrooms` (`showroomId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expositions`
--

LOCK TABLES `expositions` WRITE;
/*!40000 ALTER TABLE `expositions` DISABLE KEYS */;
INSERT INTO `expositions` VALUES (1,'Van Gogh',100,'Post-Impressionist',1,'2018-05-01','2018-08-01'),(2,'Rembrandt',120,'Baroque',2,'2018-04-01','2018-05-31'),(3,'Russian  painters',110,'Landscape painters',3,'2018-04-30','2018-05-31'),(4,'Pablo Picasso',125,'Post-Impressionist',2,'2018-04-10','2018-08-30'),(5,'Украинские художники',100,'Современные художники',1,'2018-04-01','2018-09-30'),(7,'Питер Рубенс',90,'Baroque',3,'2017-12-20','2019-01-31');
/*!40000 ALTER TABLE `expositions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payments` (
  `paymentId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `totalPrice` decimal(10,0) NOT NULL,
  `dateTime` datetime NOT NULL,
  PRIMARY KEY (`paymentId`),
  KEY `userId_idx` (`userId`),
  CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payments`
--

LOCK TABLES `payments` WRITE;
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `showrooms`
--

DROP TABLE IF EXISTS `showrooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `showrooms` (
  `showroomId` int(11) NOT NULL AUTO_INCREMENT,
  `showroomTitle` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `openingTime` time NOT NULL,
  `closingTime` time NOT NULL,
  PRIMARY KEY (`showroomId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `showrooms`
--

LOCK TABLES `showrooms` WRITE;
/*!40000 ALTER TABLE `showrooms` DISABLE KEYS */;
INSERT INTO `showrooms` VALUES (1,'Orange Hall','Khreshchatyk 25','08:00:00','21:00:00'),(2,'Мистецткий Арсенал','Лаврская 10-12','10:00:00','22:00:00'),(3,'ART Center','Bessarabska 1','10:00:00','21:00:00');
/*!40000 ALTER TABLE `showrooms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tickets` (
  `ticketId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `paymentId` int(11) NOT NULL,
  `expositionId` int(11) NOT NULL,
  `numberOfPersons` int(11) DEFAULT NULL,
  `eventDate` date DEFAULT NULL,
  PRIMARY KEY (`ticketId`),
  KEY `paymentId_idx` (`paymentId`),
  KEY `expositionId_idx` (`expositionId`),
  CONSTRAINT `expositionId` FOREIGN KEY (`expositionId`) REFERENCES `expositions` (`expositionId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `paymentId` FOREIGN KEY (`paymentId`) REFERENCES `payments` (`paymentId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `fullName` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `account` decimal(10,0) DEFAULT '0',
  PRIMARY KEY (`userId`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'max','2ffe4e77325d9a7152f7086ea7aa5114','Maxim','Kyiv',1395);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-22 18:17:38
