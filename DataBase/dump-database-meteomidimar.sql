-- MySQL dump 10.16  Distrib 10.1.26-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: meteomidmarp
-- ------------------------------------------------------
-- Server version	10.1.26-MariaDB-0+deb9u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alert`
--

DROP TABLE IF EXISTS `alert`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alert` (
  `alert_id` int(25) NOT NULL AUTO_INCREMENT,
  `sector_id` int(25) NOT NULL,
  `content` varchar(500) NOT NULL,
  `max_temp` double NOT NULL,
  `rain_volume` double NOT NULL,
  `wind_direction` varchar(50) NOT NULL,
  `wind_speed` double NOT NULL,
  `condition_id` int(25) NOT NULL,
  `date` date NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`alert_id`),
  KEY `sector_id` (`sector_id`),
  KEY `condition_id` (`condition_id`),
  CONSTRAINT `alert_ibfk_1` FOREIGN KEY (`sector_id`) REFERENCES `sector` (`sector_id`),
  CONSTRAINT `alert_ibfk_2` FOREIGN KEY (`condition_id`) REFERENCES `conditionn` (`condition_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alert`
--

LOCK TABLES `alert` WRITE;
/*!40000 ALTER TABLE `alert` DISABLE KEYS */;
INSERT INTO `alert` VALUES (1,17,'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Et, consequuntur, modi mollitia corporis ipsa voluptate corrupti eum ratione ex ea praesentium quibusdam',15,12,'South-West',32,3,'2018-07-31',1),(2,5,'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Et, consequuntur, modi mollitia corporis ipsa voluptate corrupti eum ratione ex ea praesentium quibusdam',24,8000,'North-West-South',140,2,'2018-07-22',1),(3,4,'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Et, consequuntur, modi mollitia corporis ipsa voluptate corrupti eum ratione ex ea praesentium quibusdam',24,8000,'North-West-South',140,2,'2018-07-22',1),(4,19,'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Et, consequuntur, modi mollitia corporis ipsa voluptate corrupti eum ratione ex ea praesentium quibusdam\r\n',24,8000,'North-West-South',140,1,'2018-07-22',1),(5,2,'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Et, consequuntur, modi mollitia corporis ipsa voluptate corrupti eum ratione ex ea praesentium quibusdam',24,8000,'North-West-South',140,1,'2018-07-23',1),(6,2,'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Et, consequuntur, modi mollitia corporis ipsa voluptate corrupti eum ratione ex ea praesentium quibusdam',25,8000,'North-West-South',140,1,'2018-07-23',1),(7,1,'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Et, consequuntur, modi mollitia corporis ipsa voluptate corrupti eum ratione ex ea praesentium quibusdam',24,8000,'North-West-South',140,1,'2018-07-23',1),(8,19,'muri iki cyumweru hateganyijwe ubushyuhe buringaniye nibicu byiganje mugihugu hose. kubindi bisobanuro mwihangane mwegere abayobozi  nabakozi babegereye. murakoze',25,8000,'North-West-South',140,1,'2018-07-23',1),(9,26,'Muri Iki cyumweru hateganyijwe imvura nyinshi mu karere close',25,8000,'North-West-South',140,3,'2018-07-23',1),(10,16,'Muri Iki cyumweru hateganyijwe imvura nyinshi mu karere close',25,8000,'North-West-South',140,3,'2018-07-23',1),(11,3,'muri iki cyumweru hateganyijwe ubushyuhe buringaniye nibicu byiganje mugihugu hose. kubindi bisobanuro mwihangane mwegere abayobozi  nabakozi babegereye. murakoze.',25,8000,'North-West-South',140,3,'2018-07-24',1);
/*!40000 ALTER TABLE `alert` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `category_id` int(25) NOT NULL AUTO_INCREMENT,
  `category` varchar(25) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (7,'meteo_user'),(8,'midimar_user'),(9,'general_public'),(10,'Gvt_officials');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conditionn`
--

DROP TABLE IF EXISTS `conditionn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conditionn` (
  `condition_id` int(25) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `symbol` varchar(50) NOT NULL,
  PRIMARY KEY (`condition_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conditionn`
--

LOCK TABLES `conditionn` WRITE;
/*!40000 ALTER TABLE `conditionn` DISABLE KEYS */;
INSERT INTO `conditionn` VALUES (1,'Mostly Cloudy','  ()    ()\r\n (  )  (  )\r\n(    )  ()\r\n (  ) \r\n  () '),(2,'Lightning','   / \r\n  /__\r\n     /\r\n    /__\r\n       /\r\n      /\r\n'),(3,'Heavy Rain','\\\\\\\\\\\\\\\\ \r\n \\\\\\\\\\\\ \r\n  \\\\\\\\\r\n    \\\\'),(5,'Landslide','       _\r\n . * _/ \\\r\n. *_/\r\n* / ');
/*!40000 ALTER TABLE `conditionn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `district`
--

DROP TABLE IF EXISTS `district`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `district` (
  `district_id` int(25) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  PRIMARY KEY (`district_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `district`
--

LOCK TABLES `district` WRITE;
/*!40000 ALTER TABLE `district` DISABLE KEYS */;
INSERT INTO `district` VALUES (1,'Bugesera'),(2,'Burera'),(3,'Gakenke'),(4,'Gasabo'),(5,'Gatsibo'),(6,'Gicumbi'),(7,'Gisagara'),(8,'Huye'),(9,'Kamonyi'),(10,'Karongi'),(11,'Kayonza'),(12,'Kicukiro'),(13,'Kirehe'),(14,'Muhanga'),(15,'Musanze'),(16,'Ngoma'),(17,'Ngororero'),(18,'Nyabihu'),(19,'Nyagatare'),(20,'Nyamagabe'),(21,'Nyamasheke'),(22,'Nyanza'),(23,'Nyarugenge'),(24,'Nyaruguru'),(25,'Rubavu'),(26,'Ruhango'),(27,'Rulindo'),(28,'Rusizi'),(29,'Rutsiro'),(30,'Rwamagana');
/*!40000 ALTER TABLE `district` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedback` (
  `feedback_id` int(25) NOT NULL AUTO_INCREMENT,
  `user_id` int(25) NOT NULL,
  `sector_id` int(25) NOT NULL,
  `content` varchar(200) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`feedback_id`),
  KEY `user_id` (`user_id`),
  KEY `sector_id` (`sector_id`),
  CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`userid`),
  CONSTRAINT `feedback_ibfk_2` FOREIGN KEY (`sector_id`) REFERENCES `sector` (`sector_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,1,10,'THE INFORMATION YOU SENT WAS WELL RECEIVED AND WE REACTED ON TIME','2018-07-21'),(3,3,1,'bla','0000-00-00'),(4,3,9,'\"adasdasasdas\"','0000-00-00'),(5,3,9,'adasdasasdas','0000-00-00'),(6,3,9,'babuska','0000-00-00'),(7,3,9,'cellphone','0000-00-00'),(8,3,9,'','0000-00-00'),(9,3,9,'vamos','0000-00-00'),(10,3,9,'again','0000-00-00'),(11,3,9,'yes','0000-00-00'),(12,3,9,'cellphone','0000-00-00'),(13,3,9,'acknowledged','0000-00-00'),(14,3,9,'acknowledged','0000-00-00'),(15,3,9,'acknowledged','0000-00-00'),(16,3,9,'acknowledged','0000-00-00'),(17,3,9,'babuska','0000-00-00');
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forecast`
--

DROP TABLE IF EXISTS `forecast`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forecast` (
  `forecast_id` int(25) NOT NULL AUTO_INCREMENT,
  `district_id` int(25) NOT NULL,
  `max_temp` double NOT NULL,
  `min_temp` double NOT NULL,
  `condition_id` int(25) NOT NULL,
  `morning` int(11) NOT NULL,
  `afternoon` int(11) NOT NULL,
  `evening` int(11) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`forecast_id`),
  KEY `condition_id` (`condition_id`),
  KEY `district_id` (`district_id`),
  CONSTRAINT `forecast_ibfk_1` FOREIGN KEY (`district_id`) REFERENCES `district` (`district_id`),
  CONSTRAINT `forecast_ibfk_2` FOREIGN KEY (`condition_id`) REFERENCES `conditionn` (`condition_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forecast`
--

LOCK TABLES `forecast` WRITE;
/*!40000 ALTER TABLE `forecast` DISABLE KEYS */;
INSERT INTO `forecast` VALUES (1,15,27,13,1,2,3,2,'2018-07-22'),(2,22,27,13,1,3,3,2,'2018-07-22'),(3,2,40,5,1,2,3,2,'2018-07-22'),(4,1,44,0,1,1,3,2,'2018-07-22'),(5,3,45,2,1,1,2,2,'2018-07-24'),(6,4,45,2,1,1,1,2,'2018-07-23');
/*!40000 ALTER TABLE `forecast` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forum`
--

DROP TABLE IF EXISTS `forum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forum` (
  `forum_id` int(25) NOT NULL AUTO_INCREMENT,
  `alert_id` int(25) NOT NULL,
  `user_id` int(25) NOT NULL,
  `content` varchar(600) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`forum_id`),
  KEY `alert_id` (`alert_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `forum_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`userid`),
  CONSTRAINT `forum_ibfk_2` FOREIGN KEY (`alert_id`) REFERENCES `alert` (`alert_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forum`
--

LOCK TABLES `forum` WRITE;
/*!40000 ALTER TABLE `forum` DISABLE KEYS */;
INSERT INTO `forum` VALUES (1,1,2,'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Et, consequuntur, modi mollitia corporis ipsa voluptate corrupti eum ratione ex ea praesentium quibusdam','2018-07-31'),(2,1,2,'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Et, consequuntur, modi mollitia corporis ipsa voluptate corrupti eum ratione ex ea praesentium quibusdam','2018-07-22'),(3,1,1,'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Et, consequuntur, modi mollitia corporis ipsa voluptate corrupti eum ratione ex ea praesentium quibusdam','2018-07-22'),(4,1,2,'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Et, consequuntur, modi mollitia corporis ipsa voluptate corrupti eum ratione ex ea praesentium quibusdam','2018-07-22'),(5,4,1,'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Et, consequuntur, modi mollitia corporis ipsa voluptate corrupti eum ratione ex ea praesentium quibusdam','2018-07-22'),(6,4,2,'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Et, consequuntur, modi mollitia corporis ipsa voluptate corrupti eum ratione ex ea praesentium quibusdam','2018-07-22'),(7,4,2,'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Et, consequuntur, modi mollitia corporis ipsa voluptate corrupti eum ratione ex ea praesentium quibusdam','2018-07-22'),(8,4,1,'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Et, consequuntur, modi mollitia corporis ipsa voluptate corrupti eum ratione ex ea praesentium quibusdam','2018-07-22'),(9,3,1,'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Et, consequuntur, modi mollitia corporis ipsa voluptate corrupti eum ratione ex ea praesentium quibusdam','2018-07-22'),(10,2,1,'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Et, consequuntur, modi mollitia corporis ipsa voluptate corrupti eum ratione ex ea praesentium quibusdam','2018-07-22'),(11,3,1,'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Et, consequuntur, modi mollitia corporis ipsa voluptate corrupti eum ratione ex ea praesentium quibusdam','2018-07-22'),(12,2,1,'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Et, consequuntur, modi mollitia corporis ipsa voluptate corrupti eum ratione ex ea praesentium quibusdam','2018-07-22'),(13,10,2,'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Et, consequuntur, modi mollitia corporis ipsa voluptate corrupti eum ratione ex ea praesentium quibusdam','2018-07-23'),(14,10,1,'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Et, consequuntur, modi mollitia corporis ipsa voluptate corrupti eum ratione ex ea praesentium quibusdam','2018-07-23');
/*!40000 ALTER TABLE `forum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sector`
--

DROP TABLE IF EXISTS `sector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sector` (
  `sector_id` int(25) NOT NULL AUTO_INCREMENT,
  `district_id` int(25) NOT NULL,
  `name` varchar(25) NOT NULL,
  PRIMARY KEY (`sector_id`),
  KEY `district_id` (`district_id`),
  CONSTRAINT `sector_ibfk_1` FOREIGN KEY (`district_id`) REFERENCES `district` (`district_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sector`
--

LOCK TABLES `sector` WRITE;
/*!40000 ALTER TABLE `sector` DISABLE KEYS */;
INSERT INTO `sector` VALUES (1,1,'Gikomero'),(2,2,'Gasogororo'),(3,3,'Kayonza'),(4,4,'Gasave'),(5,5,'Gasogororo'),(6,6,'Kimihurura'),(7,7,'Nyakabanda'),(8,8,'Gisozi'),(9,9,'Kimironko'),(10,10,'Ngenda'),(11,11,'Nyamata'),(12,12,'Nyabimata'),(13,13,'Rugerero'),(14,14,'Niboye'),(15,15,'Kagarama'),(16,16,'Ndera'),(17,17,'Mulindi'),(18,18,'Muhoza'),(19,19,'Kimonyi'),(20,20,'Mageragere'),(21,21,'Nyamyumba'),(22,22,'Bugeshi'),(23,23,'Gatsata'),(24,24,'Kagitumba'),(25,25,'Gasogi'),(26,26,'Mayange'),(27,27,'Rubavu'),(28,28,'Rwankuba');
/*!40000 ALTER TABLE `sector` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms`
--

DROP TABLE IF EXISTS `sms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms` (
  `sms_id` int(25) NOT NULL AUTO_INCREMENT,
  `condition_id` int(25) DEFAULT NULL,
  `messagebody` varchar(500) NOT NULL,
  `sector_id` int(25) NOT NULL,
  `source` varchar(25) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`sms_id`),
  KEY `condition_id` (`condition_id`),
  KEY `sector_id` (`sector_id`),
  CONSTRAINT `sms_ibfk_1` FOREIGN KEY (`condition_id`) REFERENCES `conditionn` (`condition_id`),
  CONSTRAINT `sms_ibfk_2` FOREIGN KEY (`sector_id`) REFERENCES `sector` (`sector_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms`
--

LOCK TABLES `sms` WRITE;
/*!40000 ALTER TABLE `sms` DISABLE KEYS */;
INSERT INTO `sms` VALUES (16,2,'muminsi ishano toza bona invura yakomeye cane, metea ibasaba ku mbara imwenza ya mbeyo, indi info amaga dvc',3,'meteo','2018-07-22 16:46:02'),(17,2,'muminsi ishano toza bona invura yakomeye cane, metea ibasaba ku mbara imwenza ya mbeyo, indi info amaga dvc',2,'meteo','2018-07-22 16:46:05'),(18,2,'muminsi ishano toza bona invura yakomeye cane, metea ibasaba ku mbara imwenza ya mbeyo, indi info amaga dvc',1,'meteo','2018-07-22 16:46:08'),(19,2,'muminsi ishatu tuza bona invura, mumbaye imipire na boomboom',3,'meteo','2018-07-23 00:37:15'),(22,2,'invura ',3,'meteo','2018-07-23 01:20:31'),(23,2,'Muri Iki cyumweru hateganyijwe imvura nyinshi mu karere close',3,'meteo','2018-07-23 12:14:36'),(24,2,'Birihutirwa gukurwa aha hantu biturutse kwiteganyagihe rigaragaza ko hari aringombwa kwimurwa.',3,'midimar','2018-07-23 12:59:12'),(25,2,'muri iki cyumweru hateganyijwe ubushyuhe buringaniye nibicu byiganje mugihugu hose. kubindi bisobanuro mwihangane mweger',3,'meteo','2018-07-23 13:09:57'),(26,1,'This is just a humble test',1,'midimar','0000-00-00 00:00:00'),(27,3,'Last but not the least',3,'midimar','0000-00-00 00:00:00');
/*!40000 ALTER TABLE `sms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userid` int(25) NOT NULL AUTO_INCREMENT,
  `names` varchar(25) NOT NULL,
  `telephone` varchar(25) NOT NULL,
  `sector_id` int(25) NOT NULL,
  `category_id` int(25) NOT NULL,
  `email` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  PRIMARY KEY (`userid`),
  KEY `sector_id` (`sector_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`),
  CONSTRAINT `user_ibfk_2` FOREIGN KEY (`sector_id`) REFERENCES `sector` (`sector_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Mick','250788293922',1,7,'em@ail.com','123456'),(2,'Boniface','250783349772',2,8,'em@gm.com','789456'),(3,'Rodrigo','250783349772',3,9,'r@g.br','123456'),(4,'Vinicius','250783349772',2,10,'zuolo@bojos.br','bojosss');
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

-- Dump completed on 2018-07-28 11:38:45
