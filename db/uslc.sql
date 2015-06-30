-- MySQL dump 10.13  Distrib 5.5.28, for Linux (i686)
--
-- Host: localhost    Database: uslc
-- ------------------------------------------------------
-- Server version	5.5.28

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
-- Table structure for table `carton`
--

DROP TABLE IF EXISTS `carton`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carton` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `COMPLETED` tinyint(1) DEFAULT '0',
  `DELETED` tinyint(1) DEFAULT '0',
  `ITEMS` int(11) DEFAULT NULL,
  `reference_number` int(11) DEFAULT NULL,
  `upc_code` varchar(255) DEFAULT NULL,
  `packing_detail_id` int(11) DEFAULT NULL,
  `user_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_carton_packing_detail_id` (`packing_detail_id`),
  CONSTRAINT `FK_carton_packing_detail_id` FOREIGN KEY (`packing_detail_id`) REFERENCES `packing_detail` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carton`
--

LOCK TABLES `carton` WRITE;
/*!40000 ALTER TABLE `carton` DISABLE KEYS */;
/*!40000 ALTER TABLE `carton` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `color`
--

DROP TABLE IF EXISTS `color`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `color` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `NUMBER` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color`
--

LOCK TABLES `color` WRITE;
/*!40000 ALTER TABLE `color` DISABLE KEYS */;
INSERT INTO `color` VALUES (1,'ONYX','100');
/*!40000 ALTER TABLE `color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CODE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,4772);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `action_id` int(11) DEFAULT NULL,
  `DESCRIPTION` text,
  `form_id` int(11) DEFAULT NULL,
  `TIMESTAMP` datetime DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_log_USER_ID` (`USER_ID`),
  CONSTRAINT `FK_log_USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES (1,1,'user log in success',1,'2014-01-29 16:19:45',1),(2,2,'application exits',2,'2014-01-29 16:23:54',4),(3,1,'user log in success',1,'2014-01-29 16:26:12',1),(4,2,'application exits',2,'2014-01-29 16:27:11',1),(5,1,'user log in success',1,'2014-01-29 16:36:51',1),(6,1,'user log in success',1,'2014-01-29 16:41:48',1),(7,2,'application exits',2,'2014-01-29 16:43:41',1),(8,1,'user log in success',1,'2014-02-04 18:54:15',1),(9,1,'user log in success',1,'2014-02-04 19:09:55',1),(10,2,'application exits',2,'2014-02-04 19:10:33',1),(11,1,'user log in success',1,'2014-02-05 03:13:13',1),(12,2,'application exits',2,'2014-02-05 03:18:32',1),(13,1,'user log in success',1,'2014-02-05 03:28:52',1),(14,2,'application exits',2,'2014-02-05 03:35:57',1),(15,1,'user log in success',1,'2014-02-05 03:36:52',1),(16,2,'application exits',2,'2014-02-05 03:40:45',1),(17,1,'user log in success',1,'2014-02-05 03:40:51',1),(18,2,'application exits',2,'2014-02-05 03:44:18',1),(19,1,'user log in success',1,'2014-02-05 03:44:24',1),(20,2,'application exits',2,'2014-02-05 03:51:54',1),(21,1,'user log in success',1,'2014-02-05 03:53:27',1),(22,1,'user log in success',1,'2014-02-05 04:14:47',1),(23,2,'application exits',2,'2014-02-05 04:16:23',1),(24,1,'user log in success',1,'2014-02-05 04:21:12',1),(25,2,'application exits',2,'2014-02-05 04:23:03',1),(26,2,'application exits',2,'2014-02-05 04:23:07',1),(27,1,'user log in success',1,'2014-02-05 04:23:13',1),(28,2,'application exits',2,'2014-02-05 04:24:42',1),(29,1,'user log in success',1,'2014-02-05 04:24:50',1),(30,2,'application exits',2,'2014-02-05 11:28:39',1);
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `packing_detail`
--

DROP TABLE IF EXISTS `packing_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `packing_detail` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DELETED` tinyint(1) DEFAULT '0',
  `QUANTITY` int(11) DEFAULT NULL,
  `SKU` int(11) DEFAULT NULL,
  `purchase_order_detail_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_packing_detail_purchase_order_detail_id` (`purchase_order_detail_id`),
  CONSTRAINT `FK_packing_detail_purchase_order_detail_id` FOREIGN KEY (`purchase_order_detail_id`) REFERENCES `purchase_order_detail` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `packing_detail`
--

LOCK TABLES `packing_detail` WRITE;
/*!40000 ALTER TABLE `packing_detail` DISABLE KEYS */;
INSERT INTO `packing_detail` VALUES (1,0,12,3,3),(2,0,3,2,2),(3,0,12,1,2),(4,0,12,5,1),(5,0,3,4,3),(6,0,3,6,1);
/*!40000 ALTER TABLE `packing_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_order`
--

DROP TABLE IF EXISTS `purchase_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_order` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DELETED` tinyint(1) DEFAULT '0',
  `department_number` varchar(255) DEFAULT NULL,
  `reference_number` varchar(255) DEFAULT NULL,
  `ship_from` longtext,
  `ship_to` longtext,
  `TIMESTAMP` datetime DEFAULT NULL,
  `total_cartons` int(11) DEFAULT NULL,
  `total_items` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_order`
--

LOCK TABLES `purchase_order` WRITE;
/*!40000 ALTER TABLE `purchase_order` DISABLE KEYS */;
INSERT INTO `purchase_order` VALUES (1,0,'003','E0444332-0001','USLC APPAREL S.A.\nCARRETERA NORTE ANTIGUA PEPSI 2C\nAL NORTE\nMANAGUA, A 49\nNICARAGUA','ED 6755 ROAD\nGROVEPORT OH 43125','2014-01-29 16:26:20',6,45);
/*!40000 ALTER TABLE `purchase_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_order_detail`
--

DROP TABLE IF EXISTS `purchase_order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_order_detail` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DELETED` tinyint(1) DEFAULT '0',
  `PRETICKETED` tinyint(1) DEFAULT '0',
  `TIMESTAMP` datetime DEFAULT NULL,
  `TOTAL` int(11) DEFAULT NULL,
  `purchase_order_id` int(11) DEFAULT NULL,
  `UPC_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_purchase_order_detail_purchase_order_id` (`purchase_order_id`),
  KEY `FK_purchase_order_detail_UPC_ID` (`UPC_ID`),
  CONSTRAINT `FK_purchase_order_detail_purchase_order_id` FOREIGN KEY (`purchase_order_id`) REFERENCES `purchase_order` (`ID`),
  CONSTRAINT `FK_purchase_order_detail_UPC_ID` FOREIGN KEY (`UPC_ID`) REFERENCES `upc` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_order_detail`
--

LOCK TABLES `purchase_order_detail` WRITE;
/*!40000 ALTER TABLE `purchase_order_detail` DISABLE KEYS */;
INSERT INTO `purchase_order_detail` VALUES (1,0,1,'2014-01-29 16:26:20',15,1,3),(2,0,1,'2014-01-29 16:26:20',15,1,2),(3,0,1,'2014-01-29 16:26:20',15,1,1);
/*!40000 ALTER TABLE `purchase_order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scan_detail`
--

DROP TABLE IF EXISTS `scan_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scan_detail` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TIMESTAMP` datetime DEFAULT NULL,
  `upc_id` int(11) DEFAULT NULL,
  `upc_reference_number` int(11) DEFAULT NULL,
  `CARTON_ID` int(11) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_scan_detail_CARTON_ID` (`CARTON_ID`),
  CONSTRAINT `FK_scan_detail_CARTON_ID` FOREIGN KEY (`CARTON_ID`) REFERENCES `carton` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scan_detail`
--

LOCK TABLES `scan_detail` WRITE;
/*!40000 ALTER TABLE `scan_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `scan_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `size`
--

DROP TABLE IF EXISTS `size`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `size` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `HIP` int(11) DEFAULT NULL,
  `INSEAM` int(11) DEFAULT NULL,
  `WAIST` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `size`
--

LOCK TABLES `size` WRITE;
/*!40000 ALTER TABLE `size` DISABLE KEYS */;
INSERT INTO `size` VALUES (1,30,30,32),(2,30,32,32),(3,30,34,32);
/*!40000 ALTER TABLE `size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `upc`
--

DROP TABLE IF EXISTS `upc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `upc` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `color_item_code` varchar(255) DEFAULT NULL,
  `DELETED` tinyint(1) DEFAULT '0',
  `TIMESTAMP` datetime DEFAULT NULL,
  `upc_code` varchar(255) DEFAULT NULL,
  `COLOR_ID` int(11) DEFAULT NULL,
  `ITEM_ID` int(11) DEFAULT NULL,
  `SIZE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_upc_COLOR_ID` (`COLOR_ID`),
  KEY `FK_upc_ITEM_ID` (`ITEM_ID`),
  KEY `FK_upc_SIZE_ID` (`SIZE_ID`),
  CONSTRAINT `FK_upc_COLOR_ID` FOREIGN KEY (`COLOR_ID`) REFERENCES `color` (`ID`),
  CONSTRAINT `FK_upc_ITEM_ID` FOREIGN KEY (`ITEM_ID`) REFERENCES `item` (`ID`),
  CONSTRAINT `FK_upc_SIZE_ID` FOREIGN KEY (`SIZE_ID`) REFERENCES `size` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `upc`
--

LOCK TABLES `upc` WRITE;
/*!40000 ALTER TABLE `upc` DISABLE KEYS */;
INSERT INTO `upc` VALUES (1,'ONYX-4772',0,'2014-01-29 16:21:23','410013940963',1,1,2),(2,'ONYX-4772',0,'2014-01-29 16:21:23','410013940956',1,1,1),(3,'ONYX-4772',0,'2014-01-29 16:21:23','410013940970',1,1,3);
/*!40000 ALTER TABLE `upc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `active` tinyint(1) DEFAULT '0',
  `enabled` tinyint(1) DEFAULT '0',
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `TIMESTAMP` datetime DEFAULT NULL,
  `user_type` int(11) DEFAULT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,0,1,'admin','uslc','QtoGVZsBx8F+qyZTWR4b0w==','2014-01-29 16:19:45',0,'Admin'),(2,1,1,'admin','uslc','QtoGVZsBx8F+qyZTWR4b0w==','2014-01-29 16:19:45',0,'Admin'),(3,0,1,'admin','uslc','QtoGVZsBx8F+qyZTWR4b0w==','2014-01-29 16:19:45',0,'Admin'),(4,0,1,'admin','uslc','QtoGVZsBx8F+qyZTWR4b0w==','2014-01-29 16:19:45',0,'Admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-10 21:40:08
