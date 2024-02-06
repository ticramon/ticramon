-- MariaDB dump 10.19  Distrib 10.6.16-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: ticramon
-- ------------------------------------------------------
-- Server version	10.6.16-MariaDB-0ubuntu0.22.04.1

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
-- Temporary table structure for view `contarTotalEmpleados`
--

DROP TABLE IF EXISTS `contarTotalEmpleados`;
/*!50001 DROP VIEW IF EXISTS `contarTotalEmpleados`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `contarTotalEmpleados` AS SELECT
 1 AS `Empleados` */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `continentes`
--

DROP TABLE IF EXISTS `continentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `continentes` (
  `idContinente` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `siglasContinente` char(2) NOT NULL,
  `nombreContinente` varchar(20) NOT NULL,
  PRIMARY KEY (`idContinente`),
  UNIQUE KEY `continentes_unique` (`siglasContinente`,`nombreContinente`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `continentes`
--

LOCK TABLES `continentes` WRITE;
/*!40000 ALTER TABLE `continentes` DISABLE KEYS */;
INSERT INTO `continentes` VALUES (1,'AF','Africa'),(2,'AM','America'),(5,'AS','Asia'),(3,'EU','Europa'),(4,'OC','Oceania');
/*!40000 ALTER TABLE `continentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `domicilios`
--

DROP TABLE IF EXISTS `domicilios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `domicilios` (
  `idDomicilios` int(10) unsigned NOT NULL,
  `tipoCalle` varchar(30) NOT NULL,
  `nombreCalle` varchar(50) NOT NULL,
  `numeroExterior` smallint(5) unsigned NOT NULL,
  `letra` char(1) DEFAULT NULL,
  `numeroInterior` smallint(5) unsigned DEFAULT NULL,
  `tipoPoblado` varchar(40) NOT NULL,
  `nombrePoblado` varchar(100) DEFAULT NULL,
  `ciudad` varchar(50) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  `pais` varchar(50) DEFAULT NULL,
  `codigoPostal` varchar(10) NOT NULL,
  PRIMARY KEY (`idDomicilios`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domicilios`
--

LOCK TABLES `domicilios` WRITE;
/*!40000 ALTER TABLE `domicilios` DISABLE KEYS */;
/*!40000 ALTER TABLE `domicilios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleados` (
  `idEmpleados` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombreEmpleados` varchar(100) NOT NULL,
  `fechaIngreso` date NOT NULL,
  `idPersona` smallint(5) unsigned NOT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`idEmpleados`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,'Sofia','2023-07-03',0,1),(2,'Frida','2023-07-03',0,1),(3,'Ramon','2023-07-03',0,1);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estados`
--

DROP TABLE IF EXISTS `estados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estados` (
  `idEstado` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `nombreEstado` varchar(50) NOT NULL,
  `idPais` tinyint(3) unsigned NOT NULL DEFAULT 0,
  PRIMARY KEY (`idEstado`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estados`
--

LOCK TABLES `estados` WRITE;
/*!40000 ALTER TABLE `estados` DISABLE KEYS */;
INSERT INTO `estados` VALUES (1,'Antioquia',2),(2,'Atlantico',2),(3,'Bogota',2),(4,'Bolivar',2),(5,'Valle de Cauca',2),(6,'Guanajuato',6),(7,'Chihuahua',6),(8,'Jalisco',6),(9,'Nuevo Leon',6),(10,'Michoacan',6),(11,'Veracruz',6),(12,'Sinaloa',6),(13,'Texas',7),(14,'California',7),(15,'Michigan',7),(16,'Oregon',7);
/*!40000 ALTER TABLE `estados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paises`
--

DROP TABLE IF EXISTS `paises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paises` (
  `idPais` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `nombrePais` varchar(50) NOT NULL,
  `idContinente` tinyint(3) unsigned NOT NULL DEFAULT 0,
  PRIMARY KEY (`idPais`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paises`
--

LOCK TABLES `paises` WRITE;
/*!40000 ALTER TABLE `paises` DISABLE KEYS */;
INSERT INTO `paises` VALUES (1,'Angola',1),(2,'Colombia',2),(3,'Italia',3),(4,'Fiji',4),(5,'Pakistan',5),(6,'Mexico',2),(7,'Estados Unidos',2);
/*!40000 ALTER TABLE `paises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personas`
--

DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personas` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellidoPaterno` varchar(50) NOT NULL DEFAULT 'X',
  `apellidoMaterno` varchar(100) NOT NULL DEFAULT 'X',
  `sexo` varchar(20) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `domicilio` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productos` (
  `idProducto` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `tipoProducto` varchar(20) NOT NULL,
  `marcaProducto` varchar(20) NOT NULL,
  `precioProducto` float NOT NULL,
  `cantidadProducto` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Computadora','Acteck',9000,1),(2,'Aro de luz ','Desconocido',350,1),(3,'Control vg','Desconocido',100,3),(4,'Laptop','HP',6000,1),(5,'Computadora','Acteck',5500,1),(6,'Webcam','Acteck',100,1),(7,'wifi USB','TPLink',250,1),(8,'Mouse Inal','Steren',220,1),(9,'Mouse inal','HP',100,1),(10,'Cable HDMI','Desconocido',200,1),(11,'Cable VGA','Desconocido',200,1),(12,'Conector RJ45','Desconocido',10,5);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicios`
--

DROP TABLE IF EXISTS `servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servicios` (
  `idServicios` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `nombreServicio` varchar(100) NOT NULL,
  `precio` float NOT NULL,
  PRIMARY KEY (`idServicios`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicios`
--

LOCK TABLES `servicios` WRITE;
/*!40000 ALTER TABLE `servicios` DISABLE KEYS */;
INSERT INTO `servicios` VALUES (1,'Formateo de equipo de computo',500),(2,'Revision de dispositivo',50),(3,'Instalacion de software basico',100),(4,'Instalacion de software especializado',120),(5,'Mantenimiento preventivo completo a equipo de computo',500),(6,'Respaldo de informacion',100),(7,'asistencia tecnica remota',200),(8,'Eliminacion de virus',150),(9,'Soporte a servidor',700),(10,'Edicion de video',2000),(11,'Desarrollo de sitio web',2000),(12,'Clases de informatica / computacion',100),(13,'Venta de producto',10);
/*!40000 ALTER TABLE `servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `nombreUsuario` varchar(20) NOT NULL,
  `contraseña` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'ticramon','sox2tcnico');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'ticramon'
--

--
-- Final view structure for view `contarTotalEmpleados`
--

/*!50001 DROP VIEW IF EXISTS `contarTotalEmpleados`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`ramonmg`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `contarTotalEmpleados` AS select count(`empleados`.`idEmpleados`) AS `Empleados` from `empleados` where `empleados`.`activo` = 1 */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-05 22:08:33
