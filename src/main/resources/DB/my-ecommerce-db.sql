-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: my_e-commerce
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `discount`
--

DROP TABLE IF EXISTS `discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discount` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `desc` text,
  `discount_percent` decimal(10,0) DEFAULT NULL,
  `active` tinyint DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `modified_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount`
--

LOCK TABLES `discount` WRITE;
/*!40000 ALTER TABLE `discount` DISABLE KEYS */;
INSERT INTO `discount` VALUES (2,'iphone discount','nenenenenenen',200,0,'2023-04-09 12:13:27','2023-04-09 12:13:27',NULL),(3,'iphone discount','nenenenenenen',200,0,'2023-04-09 12:48:51','2023-04-09 12:48:51',NULL),(4,'iphone discount','nenenenenenen',200,0,'2023-04-09 12:51:31','2023-04-09 13:14:04',NULL),(5,'iphone discount 2','nenenenenenen',500,1,'2023-04-09 13:14:04','2023-04-09 13:14:04',NULL);
/*!40000 ALTER TABLE `discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_details`
--

DROP TABLE IF EXISTS `order_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `payment_id` int DEFAULT NULL,
  `user_id` bigint NOT NULL,
  `total` decimal(10,0) unsigned DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `modified_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `user_id_idx` (`user_id`),
  KEY `payment_id_idx` (`payment_id`),
  CONSTRAINT `payment_id` FOREIGN KEY (`payment_id`) REFERENCES `payment_details` (`id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_details`
--

LOCK TABLES `order_details` WRITE;
/*!40000 ALTER TABLE `order_details` DISABLE KEYS */;
INSERT INTO `order_details` VALUES (5,NULL,3,155,'2023-04-13 11:46:19','2023-04-13 11:46:19'),(6,NULL,3,155,'2023-04-13 11:50:03','2023-04-13 11:50:03'),(7,NULL,3,155,'2023-04-13 11:51:39','2023-04-13 11:51:39'),(8,NULL,3,155,'2023-04-13 11:56:02','2023-04-13 11:56:02');
/*!40000 ALTER TABLE `order_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_items`
--

DROP TABLE IF EXISTS `order_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_items` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `product_id` int NOT NULL,
  `quantity` int DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `modified_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id_idx` (`order_id`),
  KEY `product_id_idx` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_items`
--

LOCK TABLES `order_items` WRITE;
/*!40000 ALTER TABLE `order_items` DISABLE KEYS */;
INSERT INTO `order_items` VALUES (1,5,3,10,'2023-04-13 11:46:19','2023-04-13 11:46:19'),(2,6,3,10,'2023-04-13 11:50:03','2023-04-13 11:50:03'),(3,7,3,10,'2023-04-13 11:51:39','2023-04-13 11:51:39'),(4,8,3,10,'2023-04-13 11:56:02','2023-04-13 11:56:02');
/*!40000 ALTER TABLE `order_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_details`
--

DROP TABLE IF EXISTS `payment_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `provider` varchar(45) DEFAULT NULL,
  `status` tinyint DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `modified_at` timestamp NULL DEFAULT NULL,
  `order_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id_idx` (`order_id`),
  CONSTRAINT `order_id` FOREIGN KEY (`order_id`) REFERENCES `order_details` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_details`
--

LOCK TABLES `payment_details` WRITE;
/*!40000 ALTER TABLE `payment_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `desc` text,
  `category_id` int DEFAULT NULL,
  `inventory_id` int DEFAULT NULL,
  `discount_id` int DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `modified_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id_idx` (`category_id`),
  KEY `inventory_id_idx` (`inventory_id`),
  KEY `discount_id_idx` (`discount_id`),
  CONSTRAINT `category_id` FOREIGN KEY (`category_id`) REFERENCES `product_category` (`id`),
  CONSTRAINT `discount_id` FOREIGN KEY (`discount_id`) REFERENCES `discount` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `inventory_id` FOREIGN KEY (`inventory_id`) REFERENCES `product_inventory` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (2,'Burger','A Big dilsouc Burger sandwich',NULL,NULL,NULL,20,'2023-04-06 12:42:24','2023-04-06 12:42:24',NULL),(3,'Burger','A Big dilsouc Burger sandwich',NULL,1,NULL,20,'2023-04-06 12:55:31','2023-04-06 12:55:31',NULL),(4,'Cheese','A Big dilsouc Cheese sandwich',NULL,2,NULL,25,'2023-04-06 12:59:52','2023-04-06 12:59:52',NULL),(5,'Cheese','A Big dilsouc Cheese sandwich',1,3,NULL,25,'2023-04-06 13:08:28','2023-04-06 13:08:28',NULL),(6,'iphone 12','iphone item',2,4,5,700,'2023-04-06 14:11:49','2023-04-09 13:14:04',NULL),(7,'laptop','laptop item',2,5,NULL,850,'2023-04-06 14:11:49','2023-04-06 14:11:49',NULL),(8,'FIFA 2023','Games item',3,6,NULL,99,'2023-04-06 14:11:49','2023-04-06 14:11:49',NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_category`
--

DROP TABLE IF EXISTS `product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `desc` text,
  `created_at` timestamp NULL DEFAULT NULL,
  `modified_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_category`
--

LOCK TABLES `product_category` WRITE;
/*!40000 ALTER TABLE `product_category` DISABLE KEYS */;
INSERT INTO `product_category` VALUES (1,'Food','Food','2023-04-05 17:49:08','2023-04-05 17:49:08',NULL),(2,'Electronics','Electronics','2023-04-05 17:49:08','2023-04-05 17:49:08',NULL),(3,'Games','Games','2023-04-05 17:49:08','2023-04-05 17:49:08',NULL),(4,'Healthcare','Healthcare','2023-04-05 17:49:08','2023-04-05 17:49:08',NULL),(5,'Sport','items the used in perparing Sport ','2023-04-05 17:49:08','2023-04-05 17:49:08',NULL),(6,'Furneture','Furneture','2023-04-05 17:49:08','2023-04-05 17:49:08',NULL),(7,'kids','items for kids','2023-04-05 18:25:38','2023-04-05 18:25:38',NULL),(8,'gym','gym items for building body','2023-04-13 10:27:28','2023-04-13 10:27:28',NULL),(9,'sweets','candles and sweets food','2023-04-13 10:28:11','2023-04-13 10:28:11',NULL);
/*!40000 ALTER TABLE `product_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_inventory`
--

DROP TABLE IF EXISTS `product_inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_inventory` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `quantity` int unsigned DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `modified_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_inventory`
--

LOCK TABLES `product_inventory` WRITE;
/*!40000 ALTER TABLE `product_inventory` DISABLE KEYS */;
INSERT INTO `product_inventory` VALUES (1,'burger item',0,'2023-04-06 12:55:31','2023-04-13 11:56:02',NULL),(2,'Cheese item',99,'2023-04-06 12:59:52','2023-04-06 12:59:52',NULL),(3,'Cheese item',99,'2023-04-06 13:08:28','2023-04-06 13:08:28',NULL),(4,'iphone item',50,'2023-04-06 14:11:49','2023-04-06 14:11:49',NULL),(5,'laptop item',100,'2023-04-06 14:11:49','2023-04-06 14:11:49',NULL),(6,'Games item',60,'2023-04-06 14:11:49','2023-04-06 14:11:49',NULL);
/*!40000 ALTER TABLE `product_inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` smallint NOT NULL AUTO_INCREMENT,
  `role_type` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN'),(2,'CUSTOMER'),(3,'MERCHANT');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `token` (
  `id` int NOT NULL AUTO_INCREMENT,
  `expire_date` datetime(6) DEFAULT NULL,
  `expired` bit(1) NOT NULL,
  `revoked` bit(1) NOT NULL,
  `token` varchar(255) DEFAULT NULL,
  `token_type` varchar(30) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKe32ek7ixanakfqsdaokm4q9y2` (`user_id`),
  CONSTRAINT `FKe32ek7ixanakfqsdaokm4q9y2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,'2023-04-08 15:09:28.000000',_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjdXN0b21lciIsImlhdCI6MTY4MDcwMDE2OCwiZXhwIjoxNjgwOTU5MzY4fQ.9C8Akww1RlgtWox4r8-eL26_PEVpMzLPvj3wF3qUXys','BEARER',3),(2,'2023-04-08 15:29:03.000000',_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY4MDcwMTM0MywiZXhwIjoxNjgwOTYwNTQzfQ.0zCHR3RXjGPDC2tIFrYoVyiS0QCMp5-jleNMV0Pkr7Q','BEARER',1),(3,'2023-04-08 15:38:37.000000',_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjdXN0b21lciIsImlhdCI6MTY4MDcwMTkxNywiZXhwIjoxNjgwOTYxMTE3fQ.X4KxycvOEx_AtZbeSX07GSiD9T_m1uAQq3tESPTZ7Xc','BEARER',3),(4,'2023-04-08 15:39:58.000000',_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY4MDcwMTk5OCwiZXhwIjoxNjgwOTYxMTk4fQ.9ItKA9lCoF4mEHH45lpjLy9L8IWQxnwM35_QE6YtoJs','BEARER',1),(5,'2023-04-08 20:13:59.000000',_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjdXN0b21lciIsImlhdCI6MTY4MDcxODQzOSwiZXhwIjoxNjgwOTc3NjM5fQ.YV32h33yBssCD_UgfbgQh_ot16nu5dj1EuFwV-eS6S0','BEARER',3),(6,'2023-04-08 20:16:47.000000',_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY4MDcxODYwNywiZXhwIjoxNjgwOTc3ODA3fQ.WymETZmDP-MlpS6CbT4bNjt3l6QKqlCXAESleNzY1xo','BEARER',1),(7,'2023-04-08 20:26:07.000000',_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjdXN0b21lciIsImlhdCI6MTY4MDcxOTE2NywiZXhwIjoxNjgwOTc4MzY3fQ.gA2qjib7OUP8gx2LMXAgZWl5gsDi6HH4D3u_q3v2xBI','BEARER',3),(8,'2023-04-09 10:41:37.000000',_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjdXN0b21lciIsImlhdCI6MTY4MDc3MDQ5NywiZXhwIjoxNjgxMDI5Njk3fQ.Lkcjzzzyr8FXhln8UUKrAhFnTCJoVEPSq1aRJtDMzbE','BEARER',3),(9,'2023-04-09 14:33:20.000000',_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtZXJjaGFudCIsImlhdCI6MTY4MDc4NDQwMCwiZXhwIjoxNjgxMDQzNjAwfQ.K-ZC4BwmKuYeYmtWwXeuqV-dqB6KDmpibIb78CHRt6s','BEARER',2),(10,'2023-04-12 14:47:18.000000',_binary '\0',_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtZXJjaGFudCIsImlhdCI6MTY4MTA0NDQzOCwiZXhwIjoxNjgxMzAzNjM4fQ.Lij1iUGyIS1B2HW3pKsULpnOPpnub7C76oKms1OIEAA','BEARER',2),(11,'2023-04-16 12:06:53.000000',_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjdXN0b21lciIsImlhdCI6MTY4MTM4MDQxMywiZXhwIjoxNjgxNjM5NjEzfQ.KA6ZxYEYX7o9WoC3fhu1keuSdibutNPOeeO5t6wcvg0','BEARER',3),(12,'2023-04-16 12:13:51.000000',_binary '\0',_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY4MTM4MDgzMSwiZXhwIjoxNjgxNjQwMDMxfQ.aLszJo0eXdDO0XcxvUxBYVzkjjq21i_CWxvO6JAFve0','BEARER',1),(13,'2023-04-16 12:22:26.000000',_binary '\0',_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjdXN0b21lciIsImlhdCI6MTY4MTM4MTM0NiwiZXhwIjoxNjgxNjQwNTQ2fQ.VcYZfd_uiisJ6GX1n1nkYXXjGLqQMi2WODpjg8Hvof0','BEARER',3);
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(30) NOT NULL,
  `date_of_birth` date NOT NULL,
  `email` varchar(50) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `join_date` date NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone1` varchar(11) NOT NULL,
  `phone2` varchar(11) DEFAULT NULL,
  `username` varchar(30) NOT NULL,
  `role_id` smallint NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`),
  CONSTRAINT `FKn82ha3ccdebhokx3a8fgdqeyy` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Nasr City','1999-03-01','r2.n@gmail.com','ADMIN','2023-03-23','MANAGER','$2a$10$j6VIp9wEHWiTv1InGwheXeVS13reBPe/czACuWkZYGKRts7Y5ClO2','01123167225',NULL,'admin',1),(2,'Nasr City','1999-03-01','merchant.n@gmail.com','MERCHANT','2023-03-23','TRADER','$2a$10$X0.30o6WwG3bn5a94viVz.q.2xv8d2bNhbvceMIAdGDO50t52PKnu','01123167225',NULL,'merchant',3),(3,'Nasr City','1999-03-01','customer.n@gmail.com','CUSTOMER','2023-03-23','CUSTOMER','$2a$10$tVkTbH7fbpAke.xb2Z11IeqqlsLG/0bUMjBLB7h./JL2w/ChTf2wO','01123167225',NULL,'customer',2);
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

-- Dump completed on 2023-04-13 15:07:23
