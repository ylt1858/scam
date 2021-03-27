-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: fruitstore
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `apply`
--

DROP TABLE IF EXISTS `apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `apply` (
  `id` int NOT NULL,
  `eventName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `teamNumber` int NOT NULL,
  `teamName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `sno` varchar(20) NOT NULL,
  PRIMARY KEY (`sno`,`eventName`,`teamNumber`,`id`) USING BTREE,
  KEY `eventname` (`eventName`),
  KEY `teamNumber` (`teamNumber`),
  KEY `id` (`id`),
  CONSTRAINT `apply_ibfk_1` FOREIGN KEY (`sno`) REFERENCES `student` (`sno`) ON UPDATE CASCADE,
  CONSTRAINT `apply_ibfk_3` FOREIGN KEY (`eventName`) REFERENCES `matchs` (`raceName`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apply`
--

LOCK TABLES `apply` WRITE;
/*!40000 ALTER TABLE `apply` DISABLE KEYS */;
INSERT INTO `apply` VALUES (1,'2020数学竞赛',1,'team_1','1001'),(2,'2020数学竞赛',2,'team_2','1002'),(4,'2020数学竞赛',3,'team_3','1003'),(3,'2020算法竞赛',4,'team_4','1004'),(5,'test',10,'test-team','1004');
/*!40000 ALTER TABLE `apply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `awardwinning`
--

DROP TABLE IF EXISTS `awardwinning`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `awardwinning` (
  `id` int NOT NULL,
  `grade` int DEFAULT NULL,
  `total` int DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `ids` FOREIGN KEY (`id`) REFERENCES `apply` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `awardwinning`
--

LOCK TABLES `awardwinning` WRITE;
/*!40000 ALTER TABLE `awardwinning` DISABLE KEYS */;
INSERT INTO `awardwinning` VALUES (1,1,10000),(2,2,8000),(3,1,11000);
/*!40000 ALTER TABLE `awardwinning` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fruit`
--

DROP TABLE IF EXISTS `fruit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fruit` (
  `ID` smallint NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `price` decimal(65,1) DEFAULT NULL,
  `unit` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fruit`
--

LOCK TABLES `fruit` WRITE;
/*!40000 ALTER TABLE `fruit` DISABLE KEYS */;
INSERT INTO `fruit` VALUES (1,'苹果',7.0,'kg'),(2,'香蕉',6.0,'kg'),(3,'草莓',8.0,'kg'),(4,'橘子',4.0,'kg'),(5,'火龙果',12.0,'kg'),(6,'甘蔗',3.0,'kg'),(7,'猕猴桃',10.0,'kg'),(8,'樱桃',9.0,'kg'),(9,'雪梨',4.0,'kg'),(10,'葡萄',6.5,'kg'),(11,'水蜜桃',6.0,'kg'),(12,'水蜜桃',6.0,'kg'),(13,'菠萝蜜',20.0,'kg'),(14,'西瓜',6.0,'kg');
/*!40000 ALTER TABLE `fruit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor`
--

DROP TABLE IF EXISTS `instructor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instructor` (
  `tno` varchar(20) NOT NULL,
  `grade` int DEFAULT NULL,
  `teamNumber` int NOT NULL,
  PRIMARY KEY (`tno`,`teamNumber`) USING BTREE,
  KEY `teamNumber` (`teamNumber`),
  CONSTRAINT `instructor_ibfk_1` FOREIGN KEY (`teamNumber`) REFERENCES `apply` (`teamNumber`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor`
--

LOCK TABLES `instructor` WRITE;
/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
INSERT INTO `instructor` VALUES ('2001',1,3),('2002',1,1),('2003',3,1),('2003',2,2);
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matchs`
--

DROP TABLE IF EXISTS `matchs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `matchs` (
  `times` date DEFAULT NULL,
  `raceName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `organizer` varchar(255) DEFAULT NULL,
  `profession` varchar(255) DEFAULT NULL,
  `rank` int DEFAULT NULL,
  `category` int DEFAULT NULL,
  PRIMARY KEY (`raceName`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matchs`
--

LOCK TABLES `matchs` WRITE;
/*!40000 ALTER TABLE `matchs` DISABLE KEYS */;
INSERT INTO `matchs` VALUES ('2020-12-09','2020数学竞赛','数学社','理科系',2,1),('2021-02-02','2020算法竞赛','社会大学','计算机',3,0),('2021-02-25','2021书法竞赛','书法社','书法系',1,1),('2021-02-02','test','测试单位','测试专业',3,1);
/*!40000 ALTER TABLE `matchs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `sno` varchar(20) NOT NULL,
  `s_name` varchar(50) DEFAULT NULL,
  `grade` int DEFAULT NULL,
  `s_class` varchar(20) DEFAULT NULL,
  `ID_card` char(18) DEFAULT NULL,
  `Bank_card` varchar(255) DEFAULT NULL,
  `team` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('1001','张三',1,'水产1班','430522200012032256','6580365236984560','team_1'),('1002','王二',2,'计算机','430524200201202234','5632256336515225','team_2'),('1003','online',3,'水产','432622199906053621','523654785214566','team_3'),('1004','秦清',4,'电商1班','430524200110102223','536256398742563526','team_4'),('1005','test',1,'化材','430524200010102237','5362563987425635264','testteams');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `tno` varchar(20) NOT NULL,
  `t_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `e_mail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES ('2001','李老师','13456237854','6985236@163.com'),('2002','张老师','15856239856','16542155@qq.com'),('2003','刘老师','13335467568','86542358@163.com'),('2004','吴老师','13135112831','15152525@qq.com'),('2005','苏老师','15143566589','44554455@163.com');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `id` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('update1','update1',1),('fasfds','asdf',2),('add3','password3',3),('asdf','fasf',4),('root','123456',5),('admin','123456',6),('admin','asdasd',1001),('xiaomi','asdfgh',1002);
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

-- Dump completed on 2021-03-27 11:56:56
