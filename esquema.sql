-- --------------------------------------------------------
-- Host:                         localhost
-- Versión del servidor:         5.7.24 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para clase
DROP DATABASE IF EXISTS `clase`;
CREATE DATABASE IF NOT EXISTS `clase` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci */;
USE `clase`;

-- Volcando estructura para tabla clase.categoria
DROP TABLE IF EXISTS `categoria`;
CREATE TABLE IF NOT EXISTS `categoria` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE latin1_spanish_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla clase.categoria: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;

-- Volcando estructura para tabla clase.hibernate_sequence
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla clase.hibernate_sequence: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- Volcando estructura para tabla clase.person
DROP TABLE IF EXISTS `person`;
CREATE TABLE IF NOT EXISTS `person` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `lastname` varchar(50) COLLATE latin1_spanish_ci NOT NULL DEFAULT '0',
  `name` varchar(50) COLLATE latin1_spanish_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla clase.person: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
/*!40000 ALTER TABLE `person` ENABLE KEYS */;

-- Volcando estructura para tabla clase.product
DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(50) COLLATE latin1_spanish_ci NOT NULL DEFAULT '0',
  `precio` int(10) unsigned NOT NULL DEFAULT '0',
  `stock` int(10) unsigned NOT NULL DEFAULT '1',
  `id_category` int(10) unsigned NOT NULL DEFAULT '1',
  `name` varchar(50) COLLATE latin1_spanish_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_product_categoria` (`id_category`),
  CONSTRAINT `FK_product_categoria` FOREIGN KEY (`id_category`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla clase.product: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- Volcando estructura para tabla clase.producto_variante
DROP TABLE IF EXISTS `producto_variante`;
CREATE TABLE IF NOT EXISTS `producto_variante` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_producto` int(10) unsigned NOT NULL DEFAULT '0',
  `stock` int(10) unsigned NOT NULL DEFAULT '0',
  `precio` int(10) unsigned NOT NULL DEFAULT '0',
  `name` varchar(50) COLLATE latin1_spanish_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_producto_variante_product` (`id_producto`),
  CONSTRAINT `FK_producto_variante_product` FOREIGN KEY (`id_producto`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla clase.producto_variante: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `producto_variante` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto_variante` ENABLE KEYS */;

-- Volcando estructura para tabla clase.usuario
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `pass` varchar(50) COLLATE latin1_spanish_ci NOT NULL DEFAULT '0',
  `edad` int(10) unsigned NOT NULL DEFAULT '0',
  `login` varchar(50) COLLATE latin1_spanish_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla clase.usuario: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
