-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: clinica
-- ------------------------------------------------------
-- Server version	9.0.1

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
-- Table structure for table `citas`
--

DROP TABLE IF EXISTS `citas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `citas` (
  `id_cita` bigint NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `duracion` int DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `fk_id_paciente` int DEFAULT NULL,
  `fk_id_doctor` int DEFAULT NULL,
  `fk_id_encargado` int DEFAULT NULL,
  PRIMARY KEY (`id_cita`),
  KEY `fk_id_paciente` (`fk_id_paciente`),
  KEY `fk_id_doctor` (`fk_id_doctor`),
  KEY `fk_id_encargado` (`fk_id_encargado`),
  CONSTRAINT `citas_ibfk_1` FOREIGN KEY (`fk_id_paciente`) REFERENCES `paciente` (`id_paciente`),
  CONSTRAINT `citas_ibfk_2` FOREIGN KEY (`fk_id_doctor`) REFERENCES `doctor` (`id_doctor`),
  CONSTRAINT `citas_ibfk_3` FOREIGN KEY (`fk_id_encargado`) REFERENCES `encargado` (`id_encargado`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citas`
--

LOCK TABLES `citas` WRITE;
/*!40000 ALTER TABLE `citas` DISABLE KEYS */;
INSERT INTO `citas` VALUES (11,'2025-11-07','14:00:00','Consulta general',30,'pendiente',6,12,7),(12,'2025-11-27','08:15:00','Control',30,'pendiente',46,13,3),(13,'2025-11-28','15:45:00','Toma de muestra',15,'completada',18,30,10),(14,'2025-11-07','08:45:00','Consulta general',30,'pendiente',19,29,3),(15,'2025-11-26','11:30:00','Reconsulta',45,'pendiente',44,21,2),(16,'2025-11-07','08:30:00','Consulta general',60,'pendiente',23,19,1),(17,'2025-11-23','14:30:00','Emergencia',45,'completada',28,8,7),(18,'2025-11-23','14:00:00','Consulta general',30,'pendiente',16,8,7),(19,'2025-11-20','08:30:00','Control',30,'completada',47,13,2),(20,'2025-11-16','14:00:00','Consulta general',30,'pendiente',31,16,6),(21,'2025-11-08','08:45:00','Control',30,'pendiente',40,25,3),(22,'2025-11-11','14:00:00','Reconsulta',30,'pendiente',29,2,7),(23,'2025-11-21','08:00:00','Consulta general',30,'pendiente',20,3,1),(24,'2025-11-17','14:45:00','Consulta general',30,'completada',11,30,8),(25,'2025-11-10','08:00:00','Consulta general',30,'pendiente',21,1,1),(26,'2025-11-29','14:30:00','Consulta general',30,'pendiente',50,16,6),(27,'2025-11-19','08:00:00','Reconsulta',15,'pendiente',10,21,2),(28,'2025-11-21','08:45:00','Toma de muestra',15,'pendiente',38,9,1),(29,'2025-11-04','08:15:00','Consulta general',30,'pendiente',7,5,3),(30,'2025-11-09','14:15:00','Control',30,'completada',2,26,7),(31,'2025-11-05','08:00:00','Consulta general',30,'pendiente',12,3,2),(32,'2025-11-09','08:00:00','Consulta general',30,'pendiente',27,11,3),(33,'2025-11-24','14:00:00','Consulta general',30,'pendiente',34,24,6),(34,'2025-11-17','08:00:00','Control',30,'pendiente',4,13,1),(35,'2025-11-25','14:45:00','Consulta general',30,'pendiente',37,20,7),(36,'2025-11-25','14:30:00','Consulta general',30,'completada',13,30,8),(37,'2025-11-09','14:45:00','Control',30,'pendiente',33,14,7),(38,'2025-11-06','08:00:00','Consulta general',30,'pendiente',39,1,2),(39,'2025-11-12','08:30:00','Reconsulta',30,'completada',40,3,1),(40,'2025-11-19','14:00:00','Consulta general',30,'pendiente',43,18,6),(41,'2025-11-18','08:15:00','Consulta general',30,'pendiente',15,17,2),(42,'2025-11-23','08:00:00','Consulta general',30,'pendiente',35,13,3),(43,'2025-11-14','14:30:00','Reconsulta',30,'pendiente',24,4,7),(44,'2025-11-21','14:30:00','Consulta general',30,'completada',5,16,6),(45,'2025-11-02','08:00:00','Consulta general',30,'pendiente',9,3,1),(46,'2025-11-04','14:00:00','Reconsulta',30,'pendiente',32,8,6),(47,'2025-11-13','08:15:00','Consulta general',30,'pendiente',17,25,3),(48,'2025-11-24','08:30:00','Consulta general',30,'pendiente',26,21,1),(49,'2025-11-20','14:45:00','Control',15,'pendiente',41,28,8),(50,'2025-11-29','08:00:00','Toma de muestra',15,'pendiente',27,19,2),(51,'2025-11-02','14:00:00','Consulta general',30,'pendiente',45,6,6),(52,'2025-11-27','14:15:00','Consulta general',30,'pendiente',36,18,6),(53,'2025-11-11','08:15:00','Consulta general',30,'completada',8,13,3),(54,'2025-11-15','14:15:00','Consulta general',30,'pendiente',49,12,7),(55,'2025-11-03','14:30:00','Consulta general',30,'pendiente',14,8,7),(56,'2025-11-18','14:30:00','Consulta general',30,'pendiente',1,16,6),(57,'2025-11-01','08:00:00','Consulta general',30,'pendiente',4,1,1),(58,'2025-11-05','14:15:00','Toma de muestra',15,'pendiente',30,26,7),(59,'2025-11-10','08:30:00','Consulta general',30,'completada',11,13,1),(60,'2025-11-12','14:15:00','Consulta general',30,'pendiente',2,20,6),(61,'2025-11-26','08:15:00','Consulta general',45,'pendiente',48,15,3),(62,'2025-11-08','14:45:00','Reconsulta',30,'completada',38,4,7),(63,'2025-11-19','14:30:00','Consulta general',30,'pendiente',17,20,6),(64,'2025-11-01','14:30:00','Control',15,'pendiente',3,2,6),(65,'2025-11-22','08:15:00','Consulta general',30,'pendiente',22,11,1),(66,'2025-11-30','14:00:00','Consulta general',30,'pendiente',42,26,8),(67,'2025-11-28','08:30:00','Consulta general',30,'pendiente',7,9,3),(68,'2025-11-27','14:00:00','Consulta general',30,'pendiente',19,20,6),(69,'2025-11-02','08:15:00','Toma de muestra',15,'pendiente',35,25,3),(70,'2025-11-20','08:45:00','Consulta general',30,'pendiente',49,21,2),(71,'2025-11-11','14:00:00','Consulta general',30,'pendiente',12,24,6),(72,'2025-11-04','08:15:00','Consulta general',30,'completada',20,11,1),(73,'2025-11-13','14:45:00','Consulta general',30,'pendiente',6,22,6),(74,'2025-11-06','14:00:00','Consulta general',30,'pendiente',44,8,6),(75,'2025-11-02','08:30:00','Control',30,'completada',9,1,2),(76,'2025-11-15','08:15:00','Consulta general',30,'pendiente',14,13,3),(77,'2025-11-23','14:45:00','Consulta general',30,'pendiente',2,16,6),(78,'2025-11-10','14:30:00','Toma de muestra',15,'pendiente',45,26,8),(79,'2025-11-29','08:15:00','Consulta general',30,'pendiente',32,3,1),(80,'2025-11-28','14:15:00','Reconsulta',30,'completada',26,30,10),(81,'2025-11-16','08:30:00','Consulta general',30,'pendiente',17,5,3),(82,'2025-11-18','14:00:00','Consulta general',30,'pendiente',11,16,6),(83,'2025-11-14','08:45:00','Consulta general',30,'pendiente',39,17,2),(84,'2025-11-26','14:30:00','Consulta general',30,'pendiente',8,24,6),(85,'2025-11-25','08:30:00','Consulta general',30,'pendiente',15,7,3),(86,'2025-11-12','14:45:00','Reconsulta',30,'completada',4,30,9),(87,'2025-11-08','08:00:00','Consulta general',30,'pendiente',37,1,1),(88,'2025-11-03','08:30:00','Consulta general',30,'pendiente',25,5,3),(89,'2025-11-27','08:45:00','Consulta general',30,'pendiente',43,13,2),(90,'2025-11-15','14:30:00','Consulta general',30,'pendiente',30,4,7),(91,'2025-11-22','14:00:00','Consulta general',30,'pendiente',19,28,8),(92,'2025-11-06','08:15:00','Consulta general',30,'completada',33,13,3),(93,'2025-11-01','08:15:00','Consulta general',30,'pendiente',2,1,1),(94,'2025-11-05','08:45:00','Consulta general',30,'pendiente',18,11,3),(95,'2025-11-20','14:15:00','Consulta general',30,'pendiente',12,26,8),(96,'2025-11-04','08:30:00','Consulta general',30,'pendiente',29,9,3),(97,'2025-11-09','14:00:00','Consulta general',30,'pendiente',34,20,6),(98,'2025-11-30','08:15:00','Consulta general',30,'pendiente',16,11,2),(99,'2025-11-13','14:15:00','Consulta general',30,'completada',14,30,10),(100,'2025-11-08','08:15:00','Toma de muestra',15,'pendiente',24,3,1),(101,'2025-11-26','14:45:00','Consulta general',30,'pendiente',21,20,6),(102,'2025-11-02','14:15:00','Consulta general',30,'pendiente',39,2,6),(103,'2025-11-17','08:15:00','Control',30,'pendiente',13,13,3),(104,'2025-11-11','08:00:00','Consulta general',30,'pendiente',28,1,1),(105,'2025-11-24','14:45:00','Consulta general',30,'completada',10,26,9),(106,'2025-11-16','14:30:00','Consulta general',30,'pendiente',44,16,6),(107,'2025-11-27','08:30:00','Control',30,'pendiente',31,13,2),(108,'2025-11-10','08:15:00','Consulta general',30,'pendiente',5,11,1),(109,'2025-11-18','08:00:00','Consulta general',30,'pendiente',2,7,3),(110,'2025-11-19','08:30:00','Consulta general',30,'pendiente',17,9,2),(111,'2025-11-13','08:00:00','Consulta general',30,'pendiente',26,5,3);
/*!40000 ALTER TABLE `citas` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `log_insert_citas` AFTER INSERT ON `citas` FOR EACH ROW BEGIN
    INSERT INTO log_actividad (accion, tabla_afectada, descripcion)
    VALUES ('INSERT', 'citas', CONCAT('Nueva cita creada con ID: ', NEW.id_cita, 
           ', Paciente ID: ', NEW.fk_id_paciente, ', Doctor ID: ', NEW.fk_id_doctor));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `log_update_citas` AFTER UPDATE ON `citas` FOR EACH ROW BEGIN
    INSERT INTO log_actividad (accion, tabla_afectada, descripcion)
    VALUES ('UPDATE', 'citas', CONCAT('Cita ID: ', NEW.id_cita, ' actualizada. Estado anterior: ', OLD.estado, ', nuevo estado: ', NEW.estado));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `log_delete_citas` AFTER DELETE ON `citas` FOR EACH ROW BEGIN
    INSERT INTO log_actividad (accion, tabla_afectada, descripcion)
    VALUES ('DELETE', 'citas', CONCAT('Cita eliminada con ID: ', OLD.id_cita));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor` (
  `id_doctor` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `especialidad` varchar(255) DEFAULT NULL,
  `horario_disponible` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_doctor`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (1,'Dr1','Especialidad','Matutino','9513000001','dr1@clinic.com'),(2,'Dr2','Especialidad','Vespertino','9513000002','dr2@clinic.com'),(3,'Dr3','Especialidad','Matutino','9513000003','dr3@clinic.com'),(4,'Dr4','Especialidad','Vespertino','9513000004','dr4@clinic.com'),(5,'Dr5','Especialidad','Matutino','9513000005','dr5@clinic.com'),(6,'Dr6','Especialidad','Vespertino','9513000006','dr6@clinic.com'),(7,'Dr7','Especialidad','Matutino','9513000007','dr7@clinic.com'),(8,'Dr8','Especialidad','Vespertino','9513000008','dr8@clinic.com'),(9,'Dr9','Especialidad','Matutino','9513000009','dr9@clinic.com'),(10,'Dr10','Especialidad','Vespertino','9513000010','dr10@clinic.com'),(11,'Dr11','Especialidad','Matutino','9513000011','dr11@clinic.com'),(12,'Dr12','Especialidad','Vespertino','9513000012','dr12@clinic.com'),(13,'Dr13','Especialidad','Matutino','9513000013','dr13@clinic.com'),(14,'Dr14','Especialidad','Vespertino','9513000014','dr14@clinic.com'),(15,'Dr15','Especialidad','Matutino','9513000015','dr15@clinic.com'),(16,'Dr16','Especialidad','Vespertino','9513000016','dr16@clinic.com'),(17,'Dr17','Especialidad','Matutino','9513000017','dr17@clinic.com'),(18,'Dr18','Especialidad','Vespertino','9513000018','dr18@clinic.com'),(19,'Dr19','Especialidad','Matutino','9513000019','dr19@clinic.com'),(20,'Dr20','Especialidad','Vespertino','9513000020','dr20@clinic.com'),(21,'Dr21','Especialidad','Matutino','9513000021','dr21@clinic.com'),(22,'Dr22','Especialidad','Vespertino','9513000022','dr22@clinic.com'),(23,'Dr23','Especialidad','Matutino','9513000023','dr23@clinic.com'),(24,'Dr24','Especialidad','Vespertino','9513000024','dr24@clinic.com'),(25,'Dr25','Especialidad','Matutino','9513000025','dr25@clinic.com'),(26,'Dr26','Especialidad','Vespertino','9513000026','dr26@clinic.com'),(27,'Dr27','Especialidad','Matutino','9513000027','dr27@clinic.com'),(28,'Dr28','Especialidad','Vespertino','9513000028','dr28@clinic.com'),(29,'Dr29','Especialidad','Matutino','9513000029','dr29@clinic.com'),(30,'Dr30','Especialidad','Vespertino','9513000030','dr30@clinic.com');
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `encargado`
--

DROP TABLE IF EXISTS `encargado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `encargado` (
  `id_encargado` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `turno` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_encargado`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `encargado`
--

LOCK TABLES `encargado` WRITE;
/*!40000 ALTER TABLE `encargado` DISABLE KEYS */;
INSERT INTO `encargado` VALUES (1,'Encargado1','9512000001','Matutino'),(2,'Encargado2','9512000002','Matutino'),(3,'Encargado3','9512000003','Matutino'),(4,'Encargado4','9512000004','Matutino'),(5,'Encargado5','9512000005','Matutino'),(6,'Encargado6','9512000006','Vespertino'),(7,'Encargado7','9512000007','Vespertino'),(8,'Encargado8','9512000008','Vespertino'),(9,'Encargado9','9512000009','Vespertino'),(10,'Encargado10','9512000010','Vespertino');
/*!40000 ALTER TABLE `encargado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expediente`
--

DROP TABLE IF EXISTS `expediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expediente` (
  `id_expediente` bigint NOT NULL AUTO_INCREMENT,
  `diagnosticos` text,
  `recetas` varchar(255) DEFAULT NULL,
  `tratamientos` varchar(255) DEFAULT NULL,
  `observaciones` varchar(255) DEFAULT NULL,
  `estado_expediente` varchar(255) DEFAULT NULL,
  `fk_id_doctor` int DEFAULT NULL,
  `fk_id_paciente` int DEFAULT NULL,
  PRIMARY KEY (`id_expediente`),
  KEY `fk_id_doctor` (`fk_id_doctor`),
  KEY `fk_id_paciente` (`fk_id_paciente`),
  CONSTRAINT `expediente_ibfk_1` FOREIGN KEY (`fk_id_paciente`) REFERENCES `paciente` (`id_paciente`),
  CONSTRAINT `expediente_ibfk_2` FOREIGN KEY (`fk_id_doctor`) REFERENCES `doctor` (`id_doctor`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expediente`
--

LOCK TABLES `expediente` WRITE;
/*!40000 ALTER TABLE `expediente` DISABLE KEYS */;
INSERT INTO `expediente` VALUES (1,'Diagnostico de prueba 1','Receta1','Tratamiento1','Observaciones1','aprobado',30,18),(2,'Diagnostico de prueba 2','Receta2','Tratamiento2','Observaciones2','aprobado',8,28),(3,'Diagnostico de prueba 3','Receta3','Tratamiento3','Observaciones3','aprobado',13,47),(4,'Diagnostico de prueba 4','Receta4','Tratamiento4','Observaciones4','aprobado',30,11),(5,'Diagnostico de prueba 5','Receta5','Tratamiento5','Observaciones5','aprobado',26,2),(6,'Diagnostico de prueba 6','Receta6','Tratamiento6','Observaciones6','aprobado',30,4),(7,'Diagnostico de prueba 7','Receta7','Tratamiento7','Observaciones7','aprobado',13,33),(8,'Diagnostico de prueba 8','Receta8','Tratamiento8','Observaciones8','aprobado',26,10),(9,'Diagnostico de prueba 9','Receta9','Tratamiento9','Observaciones9','aprobado',30,14),(10,'Diagnostico de prueba 10','Receta10','Tratamiento10','Observaciones10','aprobado',11,20),(11,'Diagnostico de prueba 11','Receta11','Tratamiento11','Observaciones11','aprobado',30,13),(12,'Diagnostico de prueba 12','Receta12','Tratamiento12','Observaciones12','aprobado',4,38),(13,'Diagnostico de prueba 13','Receta13','Tratamiento13','Observaciones13','aprobado',30,24),(14,'Diagnostico de prueba 14','Receta14','Tratamiento14','Observaciones14','aprobado',26,10),(15,'Diagnostico de prueba 15','Receta15','Tratamiento15','Observaciones15','aprobado',30,4),(16,'Diagnostico de prueba 16','Receta16','Tratamiento16','Observaciones16','aprobado',13,33),(17,'Diagnostico de prueba 17','Receta17','Tratamiento17','Observaciones17','aprobado',26,10),(18,'Diagnostico de prueba 18','Receta18','Tratamiento18','Observaciones18','aprobado',30,14),(19,'Diagnostico de prueba 19','Receta19','Tratamiento19','Observaciones19','aprobado',11,20),(20,'Diagnostico de prueba 20','Receta20','Tratamiento20','Observaciones20','aprobado',30,13),(21,'Diagnostico de prueba 21','Receta21','Tratamiento21','Observaciones21','aprobado',26,2),(22,'Diagnostico de prueba 22','Receta22','Tratamiento22','Observaciones22','aprobado',30,4),(23,'Diagnostico de prueba 23','Receta23','Tratamiento23','Observaciones23','aprobado',13,33),(24,'Diagnostico de prueba 24','Receta24','Tratamiento24','Observaciones24','aprobado',26,10),(25,'Diagnostico de prueba 25','Receta25','Tratamiento25','Observaciones25','aprobado',30,14),(26,'Diagnostico de prueba 26','Receta26','Tratamiento26','Observaciones26','aprobado',11,20),(27,'Diagnostico de prueba 27','Receta27','Tratamiento27','Observaciones27','aprobado',30,13),(28,'Diagnostico de prueba 28','Receta28','Tratamiento28','Observaciones28','aprobado',4,38),(29,'Diagnostico de prueba 29','Receta29','Tratamiento29','Observaciones29','aprobado',30,24),(30,'Diagnostico de prueba 30','Receta30','Tratamiento30','Observaciones30','aprobado',26,10),(31,'Diagnostico de prueba 31','Receta31','Tratamiento31','Observaciones31','aprobado',30,4),(32,'Diagnostico de prueba 32','Receta32','Tratamiento32','Observaciones32','aprobado',13,33),(33,'Diagnostico de prueba 33','Receta33','Tratamiento33','Observaciones33','aprobado',26,10),(34,'Diagnostico de prueba 34','Receta34','Tratamiento34','Observaciones34','aprobado',30,14),(35,'Diagnostico de prueba 35','Receta35','Tratamiento35','Observaciones35','aprobado',11,20);
/*!40000 ALTER TABLE `expediente` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `log_insert_expediente` AFTER INSERT ON `expediente` FOR EACH ROW BEGIN
    INSERT INTO log_actividad (accion, tabla_afectada, descripcion)
    VALUES ('INSERT', 'expediente', CONCAT('Expediente creado para paciente ID: ', NEW.fk_id_paciente));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `log_update_expediente` AFTER UPDATE ON `expediente` FOR EACH ROW BEGIN
    INSERT INTO log_actividad (accion, tabla_afectada, descripcion)
    VALUES ('UPDATE', 'expediente', CONCAT('Expediente ID: ', NEW.id_expediente, ' actualizado.'));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `log_actividad`
--

DROP TABLE IF EXISTS `log_actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log_actividad` (
  `id_log` bigint NOT NULL AUTO_INCREMENT,
  `accion` varchar(255) DEFAULT NULL,
  `tabla_afectada` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_log`)
) ENGINE=InnoDB AUTO_INCREMENT=237 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_actividad`
--

LOCK TABLES `log_actividad` WRITE;
/*!40000 ALTER TABLE `log_actividad` DISABLE KEYS */;
INSERT INTO `log_actividad` VALUES (21,'DELETE','citas','Cita eliminada con ID: 1','2025-11-02 21:53:18'),(22,'DELETE','citas','Cita eliminada con ID: 2','2025-11-02 21:53:18'),(23,'DELETE','citas','Cita eliminada con ID: 3','2025-11-02 21:53:18'),(24,'DELETE','citas','Cita eliminada con ID: 4','2025-11-02 21:53:18'),(25,'DELETE','citas','Cita eliminada con ID: 5','2025-11-02 21:53:18'),(26,'DELETE','citas','Cita eliminada con ID: 6','2025-11-02 21:53:18'),(27,'DELETE','citas','Cita eliminada con ID: 7','2025-11-02 21:53:18'),(28,'DELETE','citas','Cita eliminada con ID: 8','2025-11-02 21:53:18'),(29,'DELETE','citas','Cita eliminada con ID: 9','2025-11-02 21:53:18'),(30,'DELETE','citas','Cita eliminada con ID: 10','2025-11-02 21:53:18'),(31,'DELETE','paciente','Paciente eliminado: Ana Ramírez','2025-11-02 21:53:26'),(32,'DELETE','paciente','Paciente eliminado: Carlos Mendoza','2025-11-02 21:53:26'),(33,'DELETE','paciente','Paciente eliminado: Lucía Pérez','2025-11-02 21:53:26'),(34,'DELETE','paciente','Paciente eliminado: Miguel García','2025-11-02 21:53:26'),(35,'DELETE','paciente','Paciente eliminado: Laura Santos','2025-11-02 21:53:26'),(36,'DELETE','paciente','Paciente eliminado: Ernesto Flores','2025-11-02 21:53:26'),(37,'DELETE','paciente','Paciente eliminado: Rosa Torres','2025-11-02 21:53:26'),(38,'DELETE','paciente','Paciente eliminado: Jorge Núñez','2025-11-02 21:53:26'),(39,'DELETE','paciente','Paciente eliminado: Patricia  Díaz','2025-11-02 21:53:26'),(40,'DELETE','paciente','Paciente eliminado: Luis Ortega','2025-11-02 21:53:26'),(41,'INSERT','paciente','Paciente registrado: Paciente1','2025-11-02 22:24:56'),(42,'INSERT','paciente','Paciente registrado: Paciente2','2025-11-02 22:24:56'),(43,'INSERT','paciente','Paciente registrado: Paciente3','2025-11-02 22:24:56'),(44,'INSERT','paciente','Paciente registrado: Paciente4','2025-11-02 22:24:56'),(45,'INSERT','paciente','Paciente registrado: Paciente5','2025-11-02 22:24:56'),(46,'INSERT','paciente','Paciente registrado: Paciente6','2025-11-02 22:24:56'),(47,'INSERT','paciente','Paciente registrado: Paciente7','2025-11-02 22:24:56'),(48,'INSERT','paciente','Paciente registrado: Paciente8','2025-11-02 22:24:56'),(49,'INSERT','paciente','Paciente registrado: Paciente9','2025-11-02 22:24:56'),(50,'INSERT','paciente','Paciente registrado: Paciente10','2025-11-02 22:24:56'),(51,'INSERT','paciente','Paciente registrado: Paciente11','2025-11-02 22:24:56'),(52,'INSERT','paciente','Paciente registrado: Paciente12','2025-11-02 22:24:56'),(53,'INSERT','paciente','Paciente registrado: Paciente13','2025-11-02 22:24:56'),(54,'INSERT','paciente','Paciente registrado: Paciente14','2025-11-02 22:24:56'),(55,'INSERT','paciente','Paciente registrado: Paciente15','2025-11-02 22:24:56'),(56,'INSERT','paciente','Paciente registrado: Paciente16','2025-11-02 22:24:56'),(57,'INSERT','paciente','Paciente registrado: Paciente17','2025-11-02 22:24:56'),(58,'INSERT','paciente','Paciente registrado: Paciente18','2025-11-02 22:24:56'),(59,'INSERT','paciente','Paciente registrado: Paciente19','2025-11-02 22:24:56'),(60,'INSERT','paciente','Paciente registrado: Paciente20','2025-11-02 22:24:56'),(61,'INSERT','paciente','Paciente registrado: Paciente21','2025-11-02 22:24:56'),(62,'INSERT','paciente','Paciente registrado: Paciente22','2025-11-02 22:24:56'),(63,'INSERT','paciente','Paciente registrado: Paciente23','2025-11-02 22:24:56'),(64,'INSERT','paciente','Paciente registrado: Paciente24','2025-11-02 22:24:56'),(65,'INSERT','paciente','Paciente registrado: Paciente25','2025-11-02 22:24:56'),(66,'INSERT','paciente','Paciente registrado: Paciente26','2025-11-02 22:24:56'),(67,'INSERT','paciente','Paciente registrado: Paciente27','2025-11-02 22:24:56'),(68,'INSERT','paciente','Paciente registrado: Paciente28','2025-11-02 22:24:56'),(69,'INSERT','paciente','Paciente registrado: Paciente29','2025-11-02 22:24:56'),(70,'INSERT','paciente','Paciente registrado: Paciente30','2025-11-02 22:24:56'),(71,'INSERT','paciente','Paciente registrado: Paciente31','2025-11-02 22:24:56'),(72,'INSERT','paciente','Paciente registrado: Paciente32','2025-11-02 22:24:56'),(73,'INSERT','paciente','Paciente registrado: Paciente33','2025-11-02 22:24:56'),(74,'INSERT','paciente','Paciente registrado: Paciente34','2025-11-02 22:24:56'),(75,'INSERT','paciente','Paciente registrado: Paciente35','2025-11-02 22:24:56'),(76,'INSERT','paciente','Paciente registrado: Paciente36','2025-11-02 22:24:56'),(77,'INSERT','paciente','Paciente registrado: Paciente37','2025-11-02 22:24:56'),(78,'INSERT','paciente','Paciente registrado: Paciente38','2025-11-02 22:24:56'),(79,'INSERT','paciente','Paciente registrado: Paciente39','2025-11-02 22:24:56'),(80,'INSERT','paciente','Paciente registrado: Paciente40','2025-11-02 22:24:56'),(81,'INSERT','paciente','Paciente registrado: Paciente41','2025-11-02 22:24:56'),(82,'INSERT','paciente','Paciente registrado: Paciente42','2025-11-02 22:24:56'),(83,'INSERT','paciente','Paciente registrado: Paciente43','2025-11-02 22:24:56'),(84,'INSERT','paciente','Paciente registrado: Paciente44','2025-11-02 22:24:56'),(85,'INSERT','paciente','Paciente registrado: Paciente45','2025-11-02 22:24:56'),(86,'INSERT','paciente','Paciente registrado: Paciente46','2025-11-02 22:24:56'),(87,'INSERT','paciente','Paciente registrado: Paciente47','2025-11-02 22:24:56'),(88,'INSERT','paciente','Paciente registrado: Paciente48','2025-11-02 22:24:56'),(89,'INSERT','paciente','Paciente registrado: Paciente49','2025-11-02 22:24:56'),(90,'INSERT','paciente','Paciente registrado: Paciente50','2025-11-02 22:24:56'),(91,'INSERT','citas','Nueva cita creada con ID: 11, Paciente ID: 6, Doctor ID: 12','2025-11-02 22:24:56'),(92,'INSERT','citas','Nueva cita creada con ID: 12, Paciente ID: 46, Doctor ID: 13','2025-11-02 22:24:56'),(93,'INSERT','citas','Nueva cita creada con ID: 13, Paciente ID: 18, Doctor ID: 30','2025-11-02 22:24:56'),(94,'INSERT','citas','Nueva cita creada con ID: 14, Paciente ID: 19, Doctor ID: 29','2025-11-02 22:24:56'),(95,'INSERT','citas','Nueva cita creada con ID: 15, Paciente ID: 44, Doctor ID: 21','2025-11-02 22:24:56'),(96,'INSERT','citas','Nueva cita creada con ID: 16, Paciente ID: 23, Doctor ID: 19','2025-11-02 22:24:56'),(97,'INSERT','citas','Nueva cita creada con ID: 17, Paciente ID: 28, Doctor ID: 8','2025-11-02 22:24:56'),(98,'INSERT','citas','Nueva cita creada con ID: 18, Paciente ID: 16, Doctor ID: 8','2025-11-02 22:24:56'),(99,'INSERT','citas','Nueva cita creada con ID: 19, Paciente ID: 47, Doctor ID: 13','2025-11-02 22:24:56'),(100,'INSERT','citas','Nueva cita creada con ID: 20, Paciente ID: 31, Doctor ID: 16','2025-11-02 22:24:56'),(101,'INSERT','citas','Nueva cita creada con ID: 21, Paciente ID: 40, Doctor ID: 25','2025-11-02 22:24:56'),(102,'INSERT','citas','Nueva cita creada con ID: 22, Paciente ID: 29, Doctor ID: 2','2025-11-02 22:24:56'),(103,'INSERT','citas','Nueva cita creada con ID: 23, Paciente ID: 20, Doctor ID: 3','2025-11-02 22:24:56'),(104,'INSERT','citas','Nueva cita creada con ID: 24, Paciente ID: 11, Doctor ID: 30','2025-11-02 22:24:56'),(105,'INSERT','citas','Nueva cita creada con ID: 25, Paciente ID: 21, Doctor ID: 1','2025-11-02 22:24:56'),(106,'INSERT','citas','Nueva cita creada con ID: 26, Paciente ID: 50, Doctor ID: 16','2025-11-02 22:24:56'),(107,'INSERT','citas','Nueva cita creada con ID: 27, Paciente ID: 10, Doctor ID: 21','2025-11-02 22:24:56'),(108,'INSERT','citas','Nueva cita creada con ID: 28, Paciente ID: 38, Doctor ID: 9','2025-11-02 22:24:56'),(109,'INSERT','citas','Nueva cita creada con ID: 29, Paciente ID: 7, Doctor ID: 5','2025-11-02 22:24:56'),(110,'INSERT','citas','Nueva cita creada con ID: 30, Paciente ID: 2, Doctor ID: 26','2025-11-02 22:24:56'),(111,'INSERT','citas','Nueva cita creada con ID: 31, Paciente ID: 12, Doctor ID: 3','2025-11-02 22:24:56'),(112,'INSERT','citas','Nueva cita creada con ID: 32, Paciente ID: 27, Doctor ID: 11','2025-11-02 22:24:56'),(113,'INSERT','citas','Nueva cita creada con ID: 33, Paciente ID: 34, Doctor ID: 24','2025-11-02 22:24:56'),(114,'INSERT','citas','Nueva cita creada con ID: 34, Paciente ID: 4, Doctor ID: 13','2025-11-02 22:24:56'),(115,'INSERT','citas','Nueva cita creada con ID: 35, Paciente ID: 37, Doctor ID: 20','2025-11-02 22:24:56'),(116,'INSERT','citas','Nueva cita creada con ID: 36, Paciente ID: 13, Doctor ID: 30','2025-11-02 22:24:56'),(117,'INSERT','citas','Nueva cita creada con ID: 37, Paciente ID: 33, Doctor ID: 14','2025-11-02 22:24:56'),(118,'INSERT','citas','Nueva cita creada con ID: 38, Paciente ID: 39, Doctor ID: 1','2025-11-02 22:24:56'),(119,'INSERT','citas','Nueva cita creada con ID: 39, Paciente ID: 40, Doctor ID: 3','2025-11-02 22:24:56'),(120,'INSERT','citas','Nueva cita creada con ID: 40, Paciente ID: 43, Doctor ID: 18','2025-11-02 22:24:56'),(121,'INSERT','citas','Nueva cita creada con ID: 41, Paciente ID: 15, Doctor ID: 17','2025-11-02 22:24:56'),(122,'INSERT','citas','Nueva cita creada con ID: 42, Paciente ID: 35, Doctor ID: 13','2025-11-02 22:24:56'),(123,'INSERT','citas','Nueva cita creada con ID: 43, Paciente ID: 24, Doctor ID: 4','2025-11-02 22:24:56'),(124,'INSERT','citas','Nueva cita creada con ID: 44, Paciente ID: 5, Doctor ID: 16','2025-11-02 22:24:56'),(125,'INSERT','citas','Nueva cita creada con ID: 45, Paciente ID: 9, Doctor ID: 3','2025-11-02 22:24:56'),(126,'INSERT','citas','Nueva cita creada con ID: 46, Paciente ID: 32, Doctor ID: 8','2025-11-02 22:24:56'),(127,'INSERT','citas','Nueva cita creada con ID: 47, Paciente ID: 17, Doctor ID: 25','2025-11-02 22:24:56'),(128,'INSERT','citas','Nueva cita creada con ID: 48, Paciente ID: 26, Doctor ID: 21','2025-11-02 22:24:56'),(129,'INSERT','citas','Nueva cita creada con ID: 49, Paciente ID: 41, Doctor ID: 28','2025-11-02 22:24:56'),(130,'INSERT','citas','Nueva cita creada con ID: 50, Paciente ID: 27, Doctor ID: 19','2025-11-02 22:24:56'),(131,'INSERT','citas','Nueva cita creada con ID: 51, Paciente ID: 45, Doctor ID: 6','2025-11-02 22:24:56'),(132,'INSERT','citas','Nueva cita creada con ID: 52, Paciente ID: 36, Doctor ID: 18','2025-11-02 22:24:56'),(133,'INSERT','citas','Nueva cita creada con ID: 53, Paciente ID: 8, Doctor ID: 13','2025-11-02 22:24:56'),(134,'INSERT','citas','Nueva cita creada con ID: 54, Paciente ID: 49, Doctor ID: 12','2025-11-02 22:24:56'),(135,'INSERT','citas','Nueva cita creada con ID: 55, Paciente ID: 14, Doctor ID: 8','2025-11-02 22:24:56'),(136,'INSERT','citas','Nueva cita creada con ID: 56, Paciente ID: 1, Doctor ID: 16','2025-11-02 22:24:56'),(137,'INSERT','citas','Nueva cita creada con ID: 57, Paciente ID: 4, Doctor ID: 1','2025-11-02 22:24:56'),(138,'INSERT','citas','Nueva cita creada con ID: 58, Paciente ID: 30, Doctor ID: 26','2025-11-02 22:24:56'),(139,'INSERT','citas','Nueva cita creada con ID: 59, Paciente ID: 11, Doctor ID: 13','2025-11-02 22:24:56'),(140,'INSERT','citas','Nueva cita creada con ID: 60, Paciente ID: 2, Doctor ID: 20','2025-11-02 22:24:56'),(141,'INSERT','citas','Nueva cita creada con ID: 61, Paciente ID: 48, Doctor ID: 15','2025-11-02 22:24:56'),(142,'INSERT','citas','Nueva cita creada con ID: 62, Paciente ID: 38, Doctor ID: 4','2025-11-02 22:24:56'),(143,'INSERT','citas','Nueva cita creada con ID: 63, Paciente ID: 17, Doctor ID: 20','2025-11-02 22:24:56'),(144,'INSERT','citas','Nueva cita creada con ID: 64, Paciente ID: 3, Doctor ID: 2','2025-11-02 22:24:56'),(145,'INSERT','citas','Nueva cita creada con ID: 65, Paciente ID: 22, Doctor ID: 11','2025-11-02 22:24:56'),(146,'INSERT','citas','Nueva cita creada con ID: 66, Paciente ID: 42, Doctor ID: 26','2025-11-02 22:24:56'),(147,'INSERT','citas','Nueva cita creada con ID: 67, Paciente ID: 7, Doctor ID: 9','2025-11-02 22:24:56'),(148,'INSERT','citas','Nueva cita creada con ID: 68, Paciente ID: 19, Doctor ID: 20','2025-11-02 22:24:56'),(149,'INSERT','citas','Nueva cita creada con ID: 69, Paciente ID: 35, Doctor ID: 25','2025-11-02 22:24:56'),(150,'INSERT','citas','Nueva cita creada con ID: 70, Paciente ID: 49, Doctor ID: 21','2025-11-02 22:24:56'),(151,'INSERT','citas','Nueva cita creada con ID: 71, Paciente ID: 12, Doctor ID: 24','2025-11-02 22:24:56'),(152,'INSERT','citas','Nueva cita creada con ID: 72, Paciente ID: 20, Doctor ID: 11','2025-11-02 22:24:56'),(153,'INSERT','citas','Nueva cita creada con ID: 73, Paciente ID: 6, Doctor ID: 22','2025-11-02 22:24:56'),(154,'INSERT','citas','Nueva cita creada con ID: 74, Paciente ID: 44, Doctor ID: 8','2025-11-02 22:24:56'),(155,'INSERT','citas','Nueva cita creada con ID: 75, Paciente ID: 9, Doctor ID: 1','2025-11-02 22:24:56'),(156,'INSERT','citas','Nueva cita creada con ID: 76, Paciente ID: 14, Doctor ID: 13','2025-11-02 22:24:56'),(157,'INSERT','citas','Nueva cita creada con ID: 77, Paciente ID: 2, Doctor ID: 16','2025-11-02 22:24:56'),(158,'INSERT','citas','Nueva cita creada con ID: 78, Paciente ID: 45, Doctor ID: 26','2025-11-02 22:24:56'),(159,'INSERT','citas','Nueva cita creada con ID: 79, Paciente ID: 32, Doctor ID: 3','2025-11-02 22:24:56'),(160,'INSERT','citas','Nueva cita creada con ID: 80, Paciente ID: 26, Doctor ID: 30','2025-11-02 22:24:56'),(161,'INSERT','citas','Nueva cita creada con ID: 81, Paciente ID: 17, Doctor ID: 5','2025-11-02 22:24:56'),(162,'INSERT','citas','Nueva cita creada con ID: 82, Paciente ID: 11, Doctor ID: 16','2025-11-02 22:24:56'),(163,'INSERT','citas','Nueva cita creada con ID: 83, Paciente ID: 39, Doctor ID: 17','2025-11-02 22:24:56'),(164,'INSERT','citas','Nueva cita creada con ID: 84, Paciente ID: 8, Doctor ID: 24','2025-11-02 22:24:56'),(165,'INSERT','citas','Nueva cita creada con ID: 85, Paciente ID: 15, Doctor ID: 7','2025-11-02 22:24:56'),(166,'INSERT','citas','Nueva cita creada con ID: 86, Paciente ID: 4, Doctor ID: 30','2025-11-02 22:24:56'),(167,'INSERT','citas','Nueva cita creada con ID: 87, Paciente ID: 37, Doctor ID: 1','2025-11-02 22:24:56'),(168,'INSERT','citas','Nueva cita creada con ID: 88, Paciente ID: 25, Doctor ID: 5','2025-11-02 22:24:56'),(169,'INSERT','citas','Nueva cita creada con ID: 89, Paciente ID: 43, Doctor ID: 13','2025-11-02 22:24:56'),(170,'INSERT','citas','Nueva cita creada con ID: 90, Paciente ID: 30, Doctor ID: 4','2025-11-02 22:24:56'),(171,'INSERT','citas','Nueva cita creada con ID: 91, Paciente ID: 19, Doctor ID: 28','2025-11-02 22:24:56'),(172,'INSERT','citas','Nueva cita creada con ID: 92, Paciente ID: 33, Doctor ID: 13','2025-11-02 22:24:56'),(173,'INSERT','citas','Nueva cita creada con ID: 93, Paciente ID: 2, Doctor ID: 1','2025-11-02 22:24:56'),(174,'INSERT','citas','Nueva cita creada con ID: 94, Paciente ID: 18, Doctor ID: 11','2025-11-02 22:24:56'),(175,'INSERT','citas','Nueva cita creada con ID: 95, Paciente ID: 12, Doctor ID: 26','2025-11-02 22:24:56'),(176,'INSERT','citas','Nueva cita creada con ID: 96, Paciente ID: 29, Doctor ID: 9','2025-11-02 22:24:56'),(177,'INSERT','citas','Nueva cita creada con ID: 97, Paciente ID: 34, Doctor ID: 20','2025-11-02 22:24:56'),(178,'INSERT','citas','Nueva cita creada con ID: 98, Paciente ID: 16, Doctor ID: 11','2025-11-02 22:24:56'),(179,'INSERT','citas','Nueva cita creada con ID: 99, Paciente ID: 14, Doctor ID: 30','2025-11-02 22:24:56'),(180,'INSERT','citas','Nueva cita creada con ID: 100, Paciente ID: 24, Doctor ID: 3','2025-11-02 22:24:56'),(181,'INSERT','citas','Nueva cita creada con ID: 101, Paciente ID: 21, Doctor ID: 20','2025-11-02 22:24:56'),(182,'INSERT','citas','Nueva cita creada con ID: 102, Paciente ID: 39, Doctor ID: 2','2025-11-02 22:24:56'),(183,'INSERT','citas','Nueva cita creada con ID: 103, Paciente ID: 13, Doctor ID: 13','2025-11-02 22:24:56'),(184,'INSERT','citas','Nueva cita creada con ID: 104, Paciente ID: 28, Doctor ID: 1','2025-11-02 22:24:56'),(185,'INSERT','citas','Nueva cita creada con ID: 105, Paciente ID: 10, Doctor ID: 26','2025-11-02 22:24:56'),(186,'INSERT','citas','Nueva cita creada con ID: 106, Paciente ID: 44, Doctor ID: 16','2025-11-02 22:24:56'),(187,'INSERT','citas','Nueva cita creada con ID: 107, Paciente ID: 31, Doctor ID: 13','2025-11-02 22:24:56'),(188,'INSERT','citas','Nueva cita creada con ID: 108, Paciente ID: 5, Doctor ID: 11','2025-11-02 22:24:56'),(189,'INSERT','citas','Nueva cita creada con ID: 109, Paciente ID: 2, Doctor ID: 7','2025-11-02 22:24:56'),(190,'INSERT','citas','Nueva cita creada con ID: 110, Paciente ID: 17, Doctor ID: 9','2025-11-02 22:24:56'),(191,'INSERT','citas','Nueva cita creada con ID: 111, Paciente ID: 26, Doctor ID: 5','2025-11-02 22:24:56'),(192,'INSERT','expediente','Expediente creado para paciente ID: 20','2025-11-02 22:25:47'),(193,'INSERT','expediente','Expediente creado para paciente ID: 18','2025-11-02 22:26:30'),(194,'INSERT','expediente','Expediente creado para paciente ID: 28','2025-11-02 22:26:30'),(195,'INSERT','expediente','Expediente creado para paciente ID: 47','2025-11-02 22:26:30'),(196,'INSERT','expediente','Expediente creado para paciente ID: 11','2025-11-02 22:26:30'),(197,'INSERT','expediente','Expediente creado para paciente ID: 2','2025-11-02 22:26:30'),(198,'INSERT','expediente','Expediente creado para paciente ID: 4','2025-11-02 22:26:30'),(199,'INSERT','expediente','Expediente creado para paciente ID: 33','2025-11-02 22:26:30'),(200,'INSERT','expediente','Expediente creado para paciente ID: 10','2025-11-02 22:26:30'),(201,'INSERT','expediente','Expediente creado para paciente ID: 14','2025-11-02 22:26:30'),(202,'INSERT','expediente','Expediente creado para paciente ID: 18','2025-11-02 22:39:12'),(203,'INSERT','expediente','Expediente creado para paciente ID: 28','2025-11-02 22:39:12'),(204,'INSERT','expediente','Expediente creado para paciente ID: 47','2025-11-02 22:39:12'),(205,'INSERT','expediente','Expediente creado para paciente ID: 11','2025-11-02 22:39:12'),(206,'INSERT','expediente','Expediente creado para paciente ID: 2','2025-11-02 22:39:12'),(207,'INSERT','expediente','Expediente creado para paciente ID: 4','2025-11-02 22:39:12'),(208,'INSERT','expediente','Expediente creado para paciente ID: 33','2025-11-02 22:39:12'),(209,'INSERT','expediente','Expediente creado para paciente ID: 10','2025-11-02 22:39:12'),(210,'INSERT','expediente','Expediente creado para paciente ID: 14','2025-11-02 22:39:12'),(211,'INSERT','expediente','Expediente creado para paciente ID: 20','2025-11-02 22:39:12'),(212,'INSERT','expediente','Expediente creado para paciente ID: 13','2025-11-02 22:39:12'),(213,'INSERT','expediente','Expediente creado para paciente ID: 38','2025-11-02 22:39:12'),(214,'INSERT','expediente','Expediente creado para paciente ID: 24','2025-11-02 22:39:12'),(215,'INSERT','expediente','Expediente creado para paciente ID: 10','2025-11-02 22:39:12'),(216,'INSERT','expediente','Expediente creado para paciente ID: 4','2025-11-02 22:39:12'),(217,'INSERT','expediente','Expediente creado para paciente ID: 33','2025-11-02 22:39:12'),(218,'INSERT','expediente','Expediente creado para paciente ID: 10','2025-11-02 22:39:12'),(219,'INSERT','expediente','Expediente creado para paciente ID: 14','2025-11-02 22:39:12'),(220,'INSERT','expediente','Expediente creado para paciente ID: 20','2025-11-02 22:39:12'),(221,'INSERT','expediente','Expediente creado para paciente ID: 13','2025-11-02 22:39:12'),(222,'INSERT','expediente','Expediente creado para paciente ID: 2','2025-11-02 22:39:12'),(223,'INSERT','expediente','Expediente creado para paciente ID: 4','2025-11-02 22:39:12'),(224,'INSERT','expediente','Expediente creado para paciente ID: 33','2025-11-02 22:39:12'),(225,'INSERT','expediente','Expediente creado para paciente ID: 10','2025-11-02 22:39:12'),(226,'INSERT','expediente','Expediente creado para paciente ID: 14','2025-11-02 22:39:12'),(227,'INSERT','expediente','Expediente creado para paciente ID: 20','2025-11-02 22:39:12'),(228,'INSERT','expediente','Expediente creado para paciente ID: 13','2025-11-02 22:39:12'),(229,'INSERT','expediente','Expediente creado para paciente ID: 38','2025-11-02 22:39:12'),(230,'INSERT','expediente','Expediente creado para paciente ID: 24','2025-11-02 22:39:12'),(231,'INSERT','expediente','Expediente creado para paciente ID: 10','2025-11-02 22:39:12'),(232,'INSERT','expediente','Expediente creado para paciente ID: 4','2025-11-02 22:39:12'),(233,'INSERT','expediente','Expediente creado para paciente ID: 33','2025-11-02 22:39:12'),(234,'INSERT','expediente','Expediente creado para paciente ID: 10','2025-11-02 22:39:12'),(235,'INSERT','expediente','Expediente creado para paciente ID: 14','2025-11-02 22:39:12'),(236,'INSERT','expediente','Expediente creado para paciente ID: 20','2025-11-02 22:39:12');
/*!40000 ALTER TABLE `log_actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paciente` (
  `id_paciente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_paciente`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
INSERT INTO `paciente` VALUES (1,'Paciente1',21,'9511000001','paciente1@example.com'),(2,'Paciente2',22,'9511000002','paciente2@example.com'),(3,'Paciente3',23,'9511000003','paciente3@example.com'),(4,'Paciente4',24,'9511000004','paciente4@example.com'),(5,'Paciente5',25,'9511000005','paciente5@example.com'),(6,'Paciente6',26,'9511000006','paciente6@example.com'),(7,'Paciente7',27,'9511000007','paciente7@example.com'),(8,'Paciente8',28,'9511000008','paciente8@example.com'),(9,'Paciente9',29,'9511000009','paciente9@example.com'),(10,'Paciente10',30,'9511000010','paciente10@example.com'),(11,'Paciente11',31,'9511000011','paciente11@example.com'),(12,'Paciente12',32,'9511000012','paciente12@example.com'),(13,'Paciente13',33,'9511000013','paciente13@example.com'),(14,'Paciente14',34,'9511000014','paciente14@example.com'),(15,'Paciente15',35,'9511000015','paciente15@example.com'),(16,'Paciente16',36,'9511000016','paciente16@example.com'),(17,'Paciente17',37,'9511000017','paciente17@example.com'),(18,'Paciente18',38,'9511000018','paciente18@example.com'),(19,'Paciente19',39,'9511000019','paciente19@example.com'),(20,'Paciente20',40,'9511000020','paciente20@example.com'),(21,'Paciente21',41,'9511000021','paciente21@example.com'),(22,'Paciente22',42,'9511000022','paciente22@example.com'),(23,'Paciente23',43,'9511000023','paciente23@example.com'),(24,'Paciente24',44,'9511000024','paciente24@example.com'),(25,'Paciente25',45,'9511000025','paciente25@example.com'),(26,'Paciente26',46,'9511000026','paciente26@example.com'),(27,'Paciente27',47,'9511000027','paciente27@example.com'),(28,'Paciente28',48,'9511000028','paciente28@example.com'),(29,'Paciente29',49,'9511000029','paciente29@example.com'),(30,'Paciente30',50,'9511000030','paciente30@example.com'),(31,'Paciente31',51,'9511000031','paciente31@example.com'),(32,'Paciente32',52,'9511000032','paciente32@example.com'),(33,'Paciente33',53,'9511000033','paciente33@example.com'),(34,'Paciente34',54,'9511000034','paciente34@example.com'),(35,'Paciente35',55,'9511000035','paciente35@example.com'),(36,'Paciente36',56,'9511000036','paciente36@example.com'),(37,'Paciente37',57,'9511000037','paciente37@example.com'),(38,'Paciente38',58,'9511000038','paciente38@example.com'),(39,'Paciente39',59,'9511000039','paciente39@example.com'),(40,'Paciente40',60,'9511000040','paciente40@example.com'),(41,'Paciente41',61,'9511000041','paciente41@example.com'),(42,'Paciente42',62,'9511000042','paciente42@example.com'),(43,'Paciente43',63,'9511000043','paciente43@example.com'),(44,'Paciente44',64,'9511000044','paciente44@example.com'),(45,'Paciente45',65,'9511000045','paciente45@example.com'),(46,'Paciente46',66,'9511000046','paciente46@example.com'),(47,'Paciente47',67,'9511000047','paciente47@example.com'),(48,'Paciente48',68,'9511000048','paciente48@example.com'),(49,'Paciente49',69,'9511000049','paciente49@example.com'),(50,'Paciente50',70,'9511000050','paciente50@example.com');
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `log_insert_paciente` AFTER INSERT ON `paciente` FOR EACH ROW BEGIN
    INSERT INTO log_actividad (accion, tabla_afectada, descripcion)
    VALUES ('INSERT', 'paciente', CONCAT('Paciente registrado: ', NEW.nombre));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `log_delete_paciente` AFTER DELETE ON `paciente` FOR EACH ROW BEGIN
    INSERT INTO log_actividad (accion, tabla_afectada, descripcion)
    VALUES ('DELETE', 'paciente', CONCAT('Paciente eliminado: ', OLD.nombre));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` bigint NOT NULL AUTO_INCREMENT,
  `correo` varchar(255) NOT NULL,
  `contraseña` varchar(255) NOT NULL,
  `rol` varchar(255) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `correo` (`correo`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (11,'admin@clinica.com','$2a$10$URZim3eHBRuK3H/dDGQNo.ZGDj2guGLUVBoRNFypGeM4iayCI4Rfu','ADMIN'),(12,'encargado@clinica.com','$2a$10$URZim3eHBRuK3H/dDGQNo.ZGDj2guGLUVBoRNFypGeM4iayCI4Rfu','ENCARGADO'),(13,'doctor@clinica.com','$2a$10$URZim3eHBRuK3H/dDGQNo.ZGDj2guGLUVBoRNFypGeM4iayCI4Rfu','DOCTOR');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'clinica'
--

--
-- Dumping routines for database 'clinica'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-02 16:52:23
