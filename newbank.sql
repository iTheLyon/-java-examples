-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.28-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para newbank
CREATE DATABASE IF NOT EXISTS `newbank` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `newbank`;

-- Volcando estructura para tabla newbank.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(8) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `direccion` varchar(70) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla newbank.cliente: ~0 rows (aproximadamente)

-- Volcando estructura para tabla newbank.compania
CREATE TABLE IF NOT EXISTS `compania` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Nro` varchar(10) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla newbank.compania: ~3 rows (aproximadamente)
INSERT INTO `compania` (`Id`, `Nro`, `Nombre`) VALUES
	(1, '808', 'SCOTIABANK'),
	(2, '806', 'BCP'),
	(3, '805', 'INTERBANK');

-- Volcando estructura para tabla newbank.comprabillete
CREATE TABLE IF NOT EXISTS `comprabillete` (
  `NroBillete` int(11) NOT NULL,
  `IdCliente` int(11) NOT NULL,
  `IdCompania` int(11) NOT NULL,
  `Fecha` date NOT NULL,
  `Hora` varchar(5) NOT NULL,
  PRIMARY KEY (`NroBillete`,`IdCliente`,`IdCompania`,`Fecha`,`Hora`),
  KEY `comprabillete_cliente_fk` (`IdCliente`),
  KEY `comprabillete_compania_fk` (`IdCompania`),
  CONSTRAINT `comprabillete_cliente_fk` FOREIGN KEY (`IdCliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `comprabillete_compania_fk` FOREIGN KEY (`IdCompania`) REFERENCES `compania` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla newbank.comprabillete: ~0 rows (aproximadamente)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
