
-- Creating the MusicStore DB, if it does not exist in DB
CREATE DATABASE  IF NOT EXISTS `musicstore` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `musicstore`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: musicstore
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accounts` (
  `Firstname` varchar(20) NOT NULL,
  `Lastname` varchar(20) NOT NULL,
  `Username` varchar(8) NOT NULL,
  `Pswrd` varchar(20) NOT NULL,
  `Email` varchar(30) DEFAULT NULL,
  `address_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`Username`),
  KEY `address_id` (`address_id`),
  CONSTRAINT `accounts_ibfk_1` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES ('p','s','pachava','123','ps@gmaial.com',5),('p','i','pi','123','pi@gmail.com',6),('efdg','dfg','sdf','sdf','dfgdfg@sdfs.ss',15),('Shobhna','Bhatia','Shobhna','129','s.b@gmail.com',2),('Sowjanya','Pachava','Sowjanya','123','s.p@gmail.com',1),('s','p','sowji','12345','sp@gmail.com',4),('rony','tony','tony','123','tony@tony.com',13),('t','s','ts','123','ts@gmail.com',14);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `street` varchar(100) NOT NULL,
  `province` varchar(20) NOT NULL,
  `country` varchar(20) NOT NULL,
  `zip` varchar(20) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'123 King adward','ON','Canada','K1E 6T5','613-123-4567',NULL),(2,'34 Rue St-Dominiqu','QC','Canada','K2E 6K5','514-123-8569',NULL),(3,'99 Main ave.','ON','Canada','K6E 9T5','613-123-9568',NULL),(4,'st','on','canada','50000','45555','ottawa'),(5,'e','on','canada','k8989','37964','canada'),(6,'e','Ontario','Canada','k2b7t4','8888888','ottawa'),(7,'?','?','?','?','?','?'),(8,'richmund','ON','canada','y4y 4y4','123123','ottawa'),(9,'richmund','ON','canada','y4y 4y4','123123','ottawa'),(10,'richmund','ON','canada','y4y 4y4','123123','ottawa'),(11,'richmund','ON','canada','y4y 4y4','123123','ottawa'),(12,'richmund','ON','canada','y4y 4y4','123123','ottawa'),(13,'richmund','ON','canada','y4y 4y4','123123','ottawa'),(14,'t','ts','ts','123','123','s'),(15,'dfs','sdf','sdf','sdf','d','sdf');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cd`
--

DROP TABLE IF EXISTS `cd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cd` (
  `cdid` varchar(20) NOT NULL,
  `title` varchar(60) NOT NULL,
  `price` int(10) unsigned NOT NULL,
  `availability` int(11) NOT NULL,
  `category` enum('COUNTRY','POP','ROCK') NOT NULL,
  PRIMARY KEY (`cdid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cd`
--

LOCK TABLES `cd` WRITE;
/*!40000 ALTER TABLE `cd` DISABLE KEYS */;
INSERT INTO `cd` VALUES ('cd001','Johnny Cash Greatest Hits',1599,10,'COUNTRY'),('cd002','Willy Nelson Greatest',1599,10,'COUNTRY'),('cd003','Patsy Cline Im So Lonely',1599,10,'COUNTRY'),('cd004','Tragically Hip Fully Completely',2000,10,'ROCK'),('cd005','Beatles White Album',2000,10,'ROCK'),('cd006','Rolling Stones Forty Licks',2000,10,'ROCK'),('cd007','Madonna Greatest Hits',1799,10,'POP'),('cd008','Alannis Morissette Jagged Little Pill',1799,10,'POP'),('cd009','Video Killed the Radio Star',1799,10,'POP'),('cd010','Americana',1599,10,'COUNTRY'),('cd011','Honky Tonk',1799,10,'COUNTRY'),('cd012','Traditional Country',1699,10,'COUNTRY'),('cd013','Urban Cowboy',1569,10,'COUNTRY'),('cd014','Outlaw Country',1299,10,'COUNTRY'),('cd015','Jukebox Collection',1099,10,'COUNTRY'),('cd016','Life of Country Romance',1989,10,'COUNTRY'),('cd017','Love for Levon',1329,10,'COUNTRY'),('cd018','The Legend Begins',1099,10,'COUNTRY'),('cd019','Corb Lund',1099,10,'COUNTRY'),('cd020','Thirty One',1569,10,'COUNTRY'),('cd021','Acid Rock',2400,10,'ROCK'),('cd022','Blues Rock',2100,10,'ROCK'),('cd023','Surf',1200,10,'ROCK'),('cd024','Metal',2080,10,'ROCK'),('cd025','Rock and Roll',1800,10,'ROCK'),('cd026','Rap Rock',1230,10,'ROCK'),('cd027','Latin Rock',2100,10,'ROCK'),('cd028','Hard Rock',1200,10,'ROCK'),('cd029','Jam Rock',1100,10,'ROCK'),('cd030','Rogressive',1000,10,'ROCK'),('cd031','Oldies and retro',900,10,'ROCK'),('cd032','Roots Rock',2200,10,'ROCK'),('cd033','Silence in the Snow',2100,10,'ROCK'),('cd034','Adult Contemporary',1799,10,'POP'),('cd035','Brit pop',1299,10,'POP'),('cd036','Dance Pop',1199,10,'POP'),('cd037','Power Pop',1099,10,'POP'),('cd038','Team Pop',999,10,'POP'),('cd039','Euro Pop',1399,10,'POP'),('cd040','Easy Listening',1729,10,'POP'),('cd041','New Wave',1739,10,'POP'),('cd042','Latin Pop',1299,10,'POP'),('cd043','Oldies',799,10,'POP'),('cd044','Soft Rock',1099,10,'POP'),('cd045','Tributes',999,10,'POP'),('cd046','Soft Rock',1399,10,'POP'),('cd047','Vocal Pop',1729,10,'POP'),('cd048','Todays Country',1739,10,'COUNTRY'),('cd049','Road House',1299,10,'COUNTRY'),('cd050','Blue Grass',799,10,'COUNTRY');
/*!40000 ALTER TABLE `cd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `po`
--

DROP TABLE IF EXISTS `po`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `po` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `lname` varchar(20) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `status` enum('ORDERED','PROCESSED','DENIED') NOT NULL,
  `address` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `address` (`address`),
  CONSTRAINT `po_ibfk_1` FOREIGN KEY (`address`) REFERENCES `address` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `po`
--

LOCK TABLES `po` WRITE;
/*!40000 ALTER TABLE `po` DISABLE KEYS */;
INSERT INTO `po` VALUES (1,'Liam','Peyton','PROCESSED',1),(2,'Peter','White','DENIED',2),(3,'Andy','ADLER','ORDERED',3),(4,'p','s','ORDERED',4),(5,'s','p','ORDERED',5),(6,'s','p','DENIED',5),(7,'s','p','ORDERED',5),(8,'i','p','ORDERED',6),(9,'i','p','ORDERED',6),(10,'i','p','ORDERED',6),(11,'i','p','DENIED',6),(12,'i','p','ORDERED',6),(13,'i','p','ORDERED',6),(14,'i','p','ORDERED',6),(15,'i','p','ORDERED',6),(16,'i','p','DENIED',6),(17,'i','p','DENIED',6),(18,'i','p','ORDERED',6),(19,'i','p','ORDERED',6);
/*!40000 ALTER TABLE `po` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `poitem`
--

DROP TABLE IF EXISTS `poitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `poitem` (
  `id` int(10) unsigned NOT NULL,
  `cdid` varchar(20) NOT NULL,
  `price` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`,`cdid`),
  KEY `id` (`id`),
  KEY `cdid` (`cdid`),
  CONSTRAINT `poitem_ibfk_1` FOREIGN KEY (`id`) REFERENCES `po` (`id`) ON DELETE CASCADE,
  CONSTRAINT `poitem_ibfk_2` FOREIGN KEY (`cdid`) REFERENCES `cd` (`cdid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poitem`
--

LOCK TABLES `poitem` WRITE;
/*!40000 ALTER TABLE `poitem` DISABLE KEYS */;
INSERT INTO `poitem` VALUES (1,'cd001',1599),(2,'cd002',2000),(3,'cd003',1799),(4,'cd001',1599),(5,'cd001',1599),(6,'cd001',1599),(7,'cd007',1799),(8,'cd001',1599),(8,'cd004',2000),(8,'cd005',2000),(9,'cd001',1599),(9,'cd005',2000),(10,'cd001',1599),(10,'cd008',1799),(10,'cd014',1299),(10,'cd021',2400),(11,'cd004',2000),(11,'cd005',2000),(11,'cd009',1799),(11,'cd012',1699),(12,'cd001',1599),(13,'cd001',1599),(14,'cd001',1599),(15,'cd001',1599),(16,'cd001',1599),(17,'cd001',1599),(18,'cd001',1599),(19,'cd001',1599);
/*!40000 ALTER TABLE `poitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visitevent`
--

DROP TABLE IF EXISTS `visitevent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `visitevent` (
  `day` varchar(8) NOT NULL,
  `cdid` varchar(20) NOT NULL,
  `eventtype` enum('VIEW','CART','PURCHASE') NOT NULL,
  KEY `cdid` (`cdid`),
  CONSTRAINT `visitevent_ibfk_1` FOREIGN KEY (`cdid`) REFERENCES `cd` (`cdid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visitevent`
--

LOCK TABLES `visitevent` WRITE;
/*!40000 ALTER TABLE `visitevent` DISABLE KEYS */;
INSERT INTO `visitevent` VALUES ('12202002','cd001','VIEW'),('12242002','cd001','CART'),('12252002','cd001','PURCHASE'),('10202002','cd002','VIEW'),('12242002','cd002','CART'),('12252002','cd002','PURCHASE'),('01202002','cd003','VIEW'),('01242002','cd003','CART'),('02252002','cd003','PURCHASE');
/*!40000 ALTER TABLE `visitevent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'musicstore'
--

--
-- Dumping routines for database 'musicstore'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-01 19:09:45
