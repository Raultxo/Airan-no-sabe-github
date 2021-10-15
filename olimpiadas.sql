-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 01-11-2019 a las 11:59:22
-- Versión del servidor: 10.4.8-MariaDB
-- Versión de PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


CREATE DATABASE IF NOT EXISTS `olimpiadas` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `olimpiadas`;
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `olimpiadas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Deporte`
--

CREATE TABLE `Deporte` (
  `id_deporte` int(11) NOT NULL,
  `nombre` varchar(100) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `Deporte`
--

INSERT INTO `Deporte` (`id_deporte`, `nombre`) VALUES
(1, 'Basketball'),
(2, 'Judo'),
(3, 'Football');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Deportista`
--

CREATE TABLE `Deportista` (
  `id_deportista` int(11) NOT NULL,
  `nombre` varchar(150) COLLATE latin1_spanish_ci NOT NULL,
  `sexo` enum('M','F') COLLATE latin1_spanish_ci NOT NULL,
  `peso` int(11) DEFAULT NULL,
  `altura` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `Deportista`
--

INSERT INTO `Deportista` (`id_deportista`, `nombre`, `sexo`, `peso`, `altura`) VALUES
(1, 'A Dijiang', 'M', 80, 180),
(2, 'A Lamusi', 'M', 60, 170);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Equipo`
--

CREATE TABLE `Equipo` (
  `id_equipo` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `iniciales` varchar(3) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `Equipo`
--

INSERT INTO `Equipo` (`id_equipo`, `nombre`, `iniciales`) VALUES
(1, 'China', 'CHN'),
(2, 'Denmark', 'DEN');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Evento`
--

CREATE TABLE `Evento` (
  `id_evento` int(11) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `id_olimpiada` int(11) NOT NULL,
  `id_deporte` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Olimpiada`
--

CREATE TABLE `Olimpiada` (
  `id_olimpiada` int(11) NOT NULL,
  `nombre` varchar(11) COLLATE latin1_spanish_ci NOT NULL,
  `anio` smallint(6) NOT NULL,
  `temporada` enum('Summer','Winter') COLLATE latin1_spanish_ci NOT NULL,
  `ciudad` varchar(50) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `Olimpiada`
--

INSERT INTO `Olimpiada` (`id_olimpiada`, `nombre`, `anio`, `temporada`, `ciudad`) VALUES
(1, '1992 Summer', 1992, 'Summer', 'Barcelona'),
(2, '2012 Summer', 2012, 'Summer', 'London'),
(3, '1920 Summer', 1920, 'Summer', 'Antwerpen');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Participacion`
--

CREATE TABLE `Participacion` (
  `id_deportista` int(11) NOT NULL,
  `id_evento` int(11) NOT NULL,
  `id_equipo` int(11) NOT NULL,
  `edad` tinyint(4) DEFAULT NULL,
  `medalla` varchar(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Deporte`
--
ALTER TABLE `Deporte`
  ADD PRIMARY KEY (`id_deporte`);

--
-- Indices de la tabla `Deportista`
--
ALTER TABLE `Deportista`
  ADD PRIMARY KEY (`id_deportista`);

--
-- Indices de la tabla `Equipo`
--
ALTER TABLE `Equipo`
  ADD PRIMARY KEY (`id_equipo`);

--
-- Indices de la tabla `Evento`
--
ALTER TABLE `Evento`
  ADD PRIMARY KEY (`id_evento`),
  ADD KEY `FK_Evento_Olimpiada` (`id_olimpiada`),
  ADD KEY `FK_Evento_Deporte` (`id_deporte`);

--
-- Indices de la tabla `Olimpiada`
--
ALTER TABLE `Olimpiada`
  ADD PRIMARY KEY (`id_olimpiada`);

--
-- Indices de la tabla `Participacion`
--
ALTER TABLE `Participacion`
  ADD PRIMARY KEY (`id_deportista`,`id_evento`),
  ADD KEY `FK_Participacion_Evento` (`id_evento`),
  ADD KEY `FK_Participacion_Equipo` (`id_equipo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Deporte`
--
ALTER TABLE `Deporte`
  MODIFY `id_deporte` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `Equipo`
--
ALTER TABLE `Equipo`
  MODIFY `id_equipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `Evento`
--
ALTER TABLE `Evento`
  MODIFY `id_evento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Olimpiada`
--
ALTER TABLE `Olimpiada`
  MODIFY `id_olimpiada` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
ALTER TABLE `Deportista`
  MODIFY `id_deportista` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Evento`
--
ALTER TABLE `Evento`
  ADD CONSTRAINT `FK_Eventoolimpiadas_Deporte` FOREIGN KEY (`id_deporte`) REFERENCES `Deporte` (`id_deporte`),
  ADD CONSTRAINT `FK_Evento_Olimpiada` FOREIGN KEY (`id_olimpiada`) REFERENCES `Olimpiada` (`id_olimpiada`);

--
-- Filtros para la tabla `Participacion`
--
ALTER TABLE `Participacion`
  ADD CONSTRAINT `FK_Participacion_Deportista` FOREIGN KEY (`id_deportista`) REFERENCES `Deportista` (`id_deportista`),
  ADD CONSTRAINT `FK_Participacion_Equipo` FOREIGN KEY (`id_equipo`) REFERENCES `Equipo` (`id_equipo`),
  ADD CONSTRAINT `FK_Participacion_Evento` FOREIGN KEY (`id_evento`) REFERENCES `Evento` (`id_evento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;