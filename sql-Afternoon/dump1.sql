-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: company_sales
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `category_code` varchar(20) NOT NULL,
  `category_name` varchar(255) NOT NULL,
  PRIMARY KEY (`category_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('a','food'),('b','electronics'),('c','household');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `cust_id` int NOT NULL,
  `cust_name` varchar(255) DEFAULT NULL,
  `cust_dob` date DEFAULT NULL,
  `cust_gender` char(6) DEFAULT NULL,
  `cust_location_id` int DEFAULT NULL,
  PRIMARY KEY (`cust_id`),
  KEY `location_fk` (`cust_location_id`),
  CONSTRAINT `location_fk` FOREIGN KEY (`cust_location_id`) REFERENCES `location` (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'aadarsh','1998-01-10','male',1),(2,'aishwary','1999-09-07','female',2),(3,'durga','1999-09-09','male',1),(4,'kalivani','1998-03-17','female',2),(5,'sharat','1999-03-22','male',3),(6,'shelva','1999-07-26','male',3),(7,'thamana','1999-07-26','female',5),(8,'thilak','1999-03-05','male',6),(9,'vaishnavi','1999-06-26','female',4),(10,'yuvraj','1999-03-05','male',3);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `location_id` int NOT NULL,
  `location_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'chennai'),(2,'banglore'),(3,'delhi'),(4,'hyderabad'),(5,'gurgon'),(6,'mumbai');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_code` varchar(20) NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `unit_price` float NOT NULL,
  `category_code` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`product_code`),
  KEY `fk_product` (`category_code`),
  CONSTRAINT `fk_product` FOREIGN KEY (`category_code`) REFERENCES `category` (`category_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('101','apple',30,'a'),('102','milk',25,'a'),('103','meat',100,'a'),('201','tv',1000,'b'),('202','laptop',2000,'b'),('203','fridge',1500,'b'),('301','knife',10,'c'),('302','sheet',25,'c'),('303','mop',15,'c');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale`
--

DROP TABLE IF EXISTS `sale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sale` (
  `cust_id` int NOT NULL,
  `ex_id` int NOT NULL,
  `prod_code` varchar(20) NOT NULL,
  `date_purchase` date NOT NULL,
  `units` int DEFAULT NULL,
  PRIMARY KEY (`cust_id`,`ex_id`,`prod_code`,`date_purchase`),
  KEY `ex_id` (`ex_id`),
  KEY `prod_code` (`prod_code`),
  CONSTRAINT `sale_ibfk_1` FOREIGN KEY (`cust_id`) REFERENCES `customer` (`cust_id`),
  CONSTRAINT `sale_ibfk_2` FOREIGN KEY (`ex_id`) REFERENCES `sales_ex` (`ex_id`),
  CONSTRAINT `sale_ibfk_3` FOREIGN KEY (`prod_code`) REFERENCES `product` (`product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale`
--

LOCK TABLES `sale` WRITE;
/*!40000 ALTER TABLE `sale` DISABLE KEYS */;
INSERT INTO `sale` VALUES (1,2,'102','2020-12-01',4),(3,6,'202','2020-12-05',1),(3,7,'102','2020-12-01',6),(3,8,'201','2020-12-01',1),(3,8,'202','2020-12-02',1),(4,2,'101','2020-12-01',3),(5,5,'301','2020-12-03',2),(6,7,'203','2020-12-03',2),(6,7,'203','2020-12-05',2),(9,4,'301','2020-12-06',2),(10,4,'302','2020-12-01',4);
/*!40000 ALTER TABLE `sale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales_ex`
--

DROP TABLE IF EXISTS `sales_ex`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales_ex` (
  `ex_id` int NOT NULL,
  `ex_name` varchar(255) DEFAULT NULL,
  `ex_dob` date DEFAULT NULL,
  `ex_gender` char(6) DEFAULT NULL,
  PRIMARY KEY (`ex_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_ex`
--

LOCK TABLES `sales_ex` WRITE;
/*!40000 ALTER TABLE `sales_ex` DISABLE KEYS */;
INSERT INTO `sales_ex` VALUES (1,'ashwin','1998-10-10','male'),(2,'arthi','1998-09-07','female'),(3,'guru','1999-09-07','male'),(4,'kaviya','1998-09-17','female'),(5,'sanjay','1999-03-26','male'),(6,'santhosh','1999-05-26','male'),(7,'sankari','1999-07-16','female'),(8,'varshini','1999-03-05','female');
/*!40000 ALTER TABLE `sales_ex` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-10 14:23:08
