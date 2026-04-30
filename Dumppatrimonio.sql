CREATE DATABASE  IF NOT EXISTS `bd_patrimonio` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `bd_patrimonio`;
-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bd_patrimonio
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamento` (
  `id_departamento` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `andar` int(11) NOT NULL,
  PRIMARY KEY (`id_departamento`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'Recursos Humanos',1),(2,'Tecnologia da Informação',2),(3,'Vendas',3),(4,'Diretoria',5),(5,'Marketing',4),(6,'Financeiro',6);
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipamento`
--

DROP TABLE IF EXISTS `equipamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_patrimonio` varchar(45) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `marca` varchar(50) NOT NULL,
  `id_departamento` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_departamento` (`id_departamento`),
  CONSTRAINT `equipamento_ibfk_1` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id_departamento`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipamento`
--

LOCK TABLES `equipamento` WRITE;
/*!40000 ALTER TABLE `equipamento` DISABLE KEYS */;
INSERT INTO `equipamento` VALUES (1,'PAT-1001','Desktop','Dell',1),(2,'PAT-1002','Monitor','Dell',1),(3,'PAT-1003','Monitor','Dell',1),(4,'PAT-1004','Notebook','Lenovo',1),(5,'PAT-1005','Impressora','HP',1),(6,'PAT-1006','Telefone IP','Cisco',1),(7,'PAT-2001','Notebook','Apple',2),(8,'PAT-2002','Notebook','Dell',2),(9,'PAT-2003','Notebook','Lenovo',2),(10,'PAT-2004','Monitor Ultrawide','LG',2),(11,'PAT-2005','Monitor Ultrawide','LG',2),(12,'PAT-2006','Monitor Ultrawide','Samsung',2),(13,'PAT-2007','Servidor Rack','HP',2),(14,'PAT-2008','Servidor Rack','Dell',2),(15,'PAT-2009','Nobreak','APC',2),(16,'PAT-2010','Switch 48 portas','Cisco',2),(17,'PAT-3001','Notebook','Dell',3),(18,'PAT-3002','Notebook','Dell',3),(19,'PAT-3003','Notebook','HP',3),(20,'PAT-3004','Notebook','Lenovo',3),(21,'PAT-3005','Tablet','Samsung',3),(22,'PAT-3006','Tablet','Samsung',3),(23,'PAT-3007','Tablet','Apple',3),(24,'PAT-3008','Monitor','LG',3),(25,'PAT-3009','Monitor','LG',3),(26,'PAT-3010','Projetor','Epson',3),(27,'PAT-4001','Notebook','Apple',4),(28,'PAT-4002','Notebook','Apple',4),(29,'PAT-4003','Monitor 4K','Dell',4),(30,'PAT-4004','Tablet','Apple',4),(31,'PAT-4005','TV Smart 75\"','Samsung',4),(32,'PAT-5001','Desktop Workstation','Apple',5),(33,'PAT-5002','Desktop Workstation','Apple',5),(34,'PAT-5003','Monitor 4K','LG',5),(35,'PAT-5004','Monitor 4K','LG',5),(36,'PAT-5005','Notebook','Apple',5),(37,'PAT-5006','Mesa Digitalizadora','Wacom',5),(38,'PAT-5007','Mesa Digitalizadora','Wacom',5),(39,'PAT-5008','Projetor','Sony',5),(40,'PAT-6001','Desktop','Lenovo',6),(41,'PAT-6002','Desktop','Lenovo',6),(42,'PAT-6003','Desktop','HP',6),(43,'PAT-6004','Monitor','Samsung',6),(44,'PAT-6005','Monitor','Samsung',6),(45,'PAT-6006','Monitor','Samsung',6),(46,'PAT-6007','Impressora Multifuncional','Brother',6),(47,'PAT-6008','Calculadora de Mesa','Casio',6);
/*!40000 ALTER TABLE `equipamento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-04-30 14:54:13
