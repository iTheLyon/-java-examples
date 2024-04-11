-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.27-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.4.0.6659
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para escuela
CREATE DATABASE IF NOT EXISTS `escuela` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `escuela`;

-- Volcando estructura para tabla escuela.alumnos
CREATE TABLE IF NOT EXISTS `alumnos` (
  `Id_Alumno` int(11) NOT NULL AUTO_INCREMENT,
  `Nomb_Alumno` varchar(50) NOT NULL,
  `Apel_Alumno` varchar(60) DEFAULT NULL,
  `Dire_Alumno` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Id_Alumno`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla escuela.alumnos: ~2 rows (aproximadamente)
REPLACE INTO `alumnos` (`Id_Alumno`, `Nomb_Alumno`, `Apel_Alumno`, `Dire_Alumno`) VALUES
	(1, 'Raul', 'Miguel', 'Cercado'),
	(2, 'Jose', 'Miguel', 'Cercado');

-- Volcando estructura para tabla escuela.persona
CREATE TABLE IF NOT EXISTS `persona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clave` varchar(10) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `domicilio` varchar(200) NOT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `correo_electronico` varchar(45) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `genero` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla escuela.persona: ~24 rows (aproximadamente)
REPLACE INTO `persona` (`id`, `clave`, `nombre`, `domicilio`, `telefono`, `correo_electronico`, `fecha_nacimiento`, `genero`) VALUES
	(2, '565231232', 'Pedro Castillo Turrones', 'No mas pobres en un Pais Rico', '987654321', 'ay_papaseto@gob.pe', '1986-10-04', 'Masculino'),
	(5, 'donpollo', 'Erick', 'AV.Corazon tucun tucun', '71457835', 'dondeestasenati@gmail.com', '2006-02-07', 'Masculino'),
	(6, '1234', 'Benjamin Parii', 'Tacna/Tacna/Peru', '92858257', 'b_asdadsa@hotmail.com', '2004-09-27', 'Masculino'),
	(7, '1432', 'julio david', 'av.avenidosa', '923654723', 'julio@senati.com', '1999-02-05', 'Masculino'),
	(8, '00151', 'andres', 'tacna', '456789123', 'sadas@senati.pe', '1888-02-01', 'masculino'),
	(9, '4567', 'Ste Jeimy Bryan Chucuya Ticona', 'Avenida Baluarte', '123456789', 'senatino@gmail.com', '2005-12-20', 'Masculino'),
	(10, '17785', 'ALTO_DE_ALIANZA', 'Gandy', '998832442', 'GANDY@SENATI.PE', '2004-03-02', 'Masculino '),
	(12, '113', 'Roger', 'tacnacity', '980101043', 'nidea@senati.pe', '2003-03-03', 'Masculino'),
	(13, '00005', 'prueba 02', 'prueba', '789456125', 'iTzswat@gmail;com', '2021-04-02', 'masculino'),
	(14, '6549', 'Wendy Ramos', 'Lima', '987654321', 'pataclaun_0@gmail.com', '2000-10-05', 'Femenino'),
	(15, '0011', 'Gandy', 'tacna/tacna/la_curva', '988134789', 'gandy@senati.pe', '2006-02-03', 'Masculino '),
	(16, '123456726', 'Jonu', 'ddsa', '4546465', 'dsdsd', '2002-12-20', 'Masculino'),
	(18, '6124', 'Don pollo', 'Un video mas mi gente', '986572132', 'Pollo_k@gmail.com', '2000-12-31', 'Femenino'),
	(19, '12', 'Hulk', 'Avenida Narnia', '123456789', 'JHONNN??¡¡@gmail.com', '1001-12-20', 'Masculino'),
	(20, '151515', 'NICKY', 'TACNA2', '980148719', 'enriquez.net@gmail.com', '1989-01-01', 'Masculino'),
	(21, '', 'roger', 'tacnacity', '999999999', 'senati@gmail.com', '2003-01-01', 'Masculino'),
	(22, '1111', 'tarzan', 'jungla', '66666', 'senatianfoaj@senati.com', '2006-06-06', 'Masculino'),
	(23, '114114', 'ROGER', 'tacnacityyork', '901918213', 'senati@com.com', '2003-01-01', 'Masculino'),
	(24, '2000', 'Gianella', 'Calle Paragua', '802648100', 'Funcionaemail', '2020-10-12', 'Femenino'),
	(25, '1111', 'Jhon Acero', 'TacnaCity', '969027717', 'jhonacero@gmail.com', '2006-02-02', 'Masculino'),
	(26, '2023', 'Celestino', 'Alto de la Alianza', '936990438', 'Celes80@hotmail.com', '2004-10-01', 'Masculino'),
	(27, '2000', 'Gianella', 'Calle Pan', '800204816', 'Ayudaemail', '2020-10-12', 'Femenino'),
	(28, '33353', 'Alan Garcia ', 'El cielito', '987654321', 'demuestrenlo_pes@hotmail.com', '2000-04-21', 'Masculino'),
	(29, '114114', 'ROGERRRR', 'tacnacityyork', '901918213', 'senati@com.com', '2003-01-01', 'Masculino');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
