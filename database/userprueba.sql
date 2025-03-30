-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-03-2025 a las 16:51:18
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `userprueba`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registroprueba`
--

CREATE TABLE `registroprueba` (
  `id` int(11) NOT NULL,
  `NombrePagina` varchar(250) NOT NULL,
  `urlPagina` varchar(250) NOT NULL,
  `nombreUserPagina` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  `id_usuarioPassword` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `registroprueba`
--

INSERT INTO `registroprueba` (`id`, `NombrePagina`, `urlPagina`, `nombreUserPagina`, `password`, `id_usuarioPassword`) VALUES
(16, 'salesforce test', 'www.test.salesforce.com', 'ramoncin@mail.com', 'HfJ+QwihOjCxVJAdwY67KQ==', 22),
(17, 'hotmail', 'www.hotmail.com', 'javi@mail.com', 'bxbox5gO9UtpAYk1+MQCLQ==', 22),
(18, 'salesforce Test ', 'www.test.salesforce.com', 'pedro@mail.com', 'Op303TJNY40prL8rjJ2PGg==', 23),
(20, 'fitness deportes', 'www.fitness.com', 'pedrodeportesfuertes@mail.com', 'LCrajejglxFjGbrNJBPp0Q==', 23);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuariopassword`
--

CREATE TABLE `usuariopassword` (
  `id` int(11) NOT NULL,
  `usuario` varchar(250) NOT NULL,
  `email` varchar(250) NOT NULL,
  `contrasena` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuariopassword`
--

INSERT INTO `usuariopassword` (`id`, `usuario`, `email`, `contrasena`) VALUES
(22, 'Javier Blanco', 'javi@mail.com', 'mdSm0RmB+xAKrTah3DG31A=='),
(23, 'Pedro Lopez', 'pedro@mail.com', 'mdSm0RmB+xAKrTah3DG31A=='),
(24, 'Javier Blanco', 'javi@mail.com', 'mdSm0RmB+xAKrTah3DG31A=='),
(25, 'Heidy', 'heidy@mail.com', 'mdSm0RmB+xAKrTah3DG31A==');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `registroprueba`
--
ALTER TABLE `registroprueba`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_usuarioPassword` (`id_usuarioPassword`);

--
-- Indices de la tabla `usuariopassword`
--
ALTER TABLE `usuariopassword`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `registroprueba`
--
ALTER TABLE `registroprueba`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `usuariopassword`
--
ALTER TABLE `usuariopassword`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `registroprueba`
--
ALTER TABLE `registroprueba`
  ADD CONSTRAINT `registroprueba_ibfk_1` FOREIGN KEY (`id_usuarioPassword`) REFERENCES `usuariopassword` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
