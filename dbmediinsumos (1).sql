-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-07-2025 a las 16:54:41
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dbmediinsumos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actividades`
--

CREATE TABLE `actividades` (
  `registro` int(11) NOT NULL,
  `idPaciente` int(11) NOT NULL,
  `idEspecialista` int(11) NOT NULL,
  `idProveedor` int(11) NOT NULL,
  `idClinica` int(11) NOT NULL,
  `fechaProgramada` date NOT NULL,
  `descripcion` text NOT NULL,
  `idEstado` int(1) NOT NULL,
  `ruta` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargo`
--

CREATE TABLE `cargo` (
  `idCargo` int(1) NOT NULL,
  `cargo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cargo`
--

INSERT INTO `cargo` (`idCargo`, `cargo`) VALUES
(1, 'Gerente General'),
(2, 'Gerente Técnico'),
(3, 'Almacenista'),
(4, 'Auxiliar Contable'),
(5, 'Auxiliar de Almacén'),
(6, 'Soporte Técnico');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `idCategoria` int(2) NOT NULL,
  `nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudad`
--

CREATE TABLE `ciudad` (
  `idCiudad` int(4) NOT NULL,
  `ciudad` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  `idDepartamento` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ciudad`
--

INSERT INTO `ciudad` (`idCiudad`, `ciudad`, `idDepartamento`) VALUES
(1, 'Bogotá D.C.', 5),
(2, 'Leticia', 1),
(3, 'El Encanto', 1),
(4, 'La Chorrera', 1),
(5, 'La Pedrera', 1),
(6, 'La Victoria', 1),
(7, 'Puerto Arica', 1),
(8, 'Puerto Nariño', 1),
(9, 'Puerto Santander', 1),
(10, 'Tarapacá', 1),
(11, 'Achí', 6),
(12, 'Arenal', 6),
(13, 'Arjona', 6),
(14, 'Arroyohondo', 6),
(15, 'Cartagena de Indias DT y C', 6),
(16, 'Calamar', 6),
(17, 'Cantagallo', 6),
(18, 'Cicuco', 6),
(19, 'Córdoba', 6),
(20, 'Clemencia', 6),
(21, 'El Guamo', 6),
(22, 'Magangué', 6),
(23, 'Mahates', 6),
(24, 'Margarita', 6),
(25, 'Montecristo', 6),
(26, 'Mompós', 6),
(27, 'Morales', 6),
(28, 'Norosí', 6),
(29, 'Pinillos', 6),
(30, 'Regidor', 6),
(31, 'Río Viejo', 6),
(32, 'San Estanislao', 6),
(33, 'San Fernando', 6),
(34, 'San Juan Nepomuceno', 6),
(35, 'Santa Catalina', 6),
(36, 'Santa Rosa', 6),
(37, 'Simití', 6),
(38, 'Soplaviento', 6),
(39, 'Talaigua Nuevo', 6),
(40, 'Tiquisio', 6),
(41, 'Turbaco', 6),
(42, 'Turbaná', 6),
(43, 'Villanueva', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clinica`
--

CREATE TABLE `clinica` (
  `nit` int(10) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `idCiudad` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clinica`
--

INSERT INTO `clinica` (`nit`, `nombre`, `direccion`, `idCiudad`) VALUES
(830066626, 'CLINICA MEDIHELP SERVICE', 'Cra 6 # 5-101 Bocagrande', 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `colaborador`
--

CREATE TABLE `colaborador` (
  `identificacion` int(10) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `telefono` varchar(14) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `rh` varchar(3) NOT NULL,
  `idCiudad` int(4) NOT NULL,
  `idCargo` int(1) NOT NULL,
  `nacimiento` date NOT NULL,
  `ingreso` date NOT NULL,
  `salida` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `colaborador`
--

INSERT INTO `colaborador` (`identificacion`, `nombre`, `correo`, `telefono`, `direccion`, `rh`, `idCiudad`, `idCargo`, `nacimiento`, `ingreso`, `salida`) VALUES
(23154879, 'Mariana Rubiano', 'mariana.rubiano@gmai.com', '+573203712166', 'Cra 6 # 5-101 Bocagrande', '3', 15, 1, '2014-01-04', '2025-01-02', NULL),
(86066225, 'Alvaro Augusto Rubiano Guarnizo', 'rubiano124@gmail.com', '+573203712166', 'Calle 6 Sur No. 23-137', '1', 1, 3, '1980-11-08', '2025-02-15', NULL),
(860662251, 'Alvaro Augusto Rubiano Guarnizo', 'rubiano124@gmail.com', '+573203712166', 'Cra 6 # 5-101 Bocagrande', '1', 1, 4, '1980-01-01', '2025-01-01', NULL),
(1043652510, 'Andres Felipe Rubiano Marrugo', 'andres.rubiano@gmail.com', '+573203712166', 'Diagonal 40A 8-37', '2', 15, 6, '2004-02-08', '2025-01-01', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento`
--

CREATE TABLE `departamento` (
  `idDepartamento` int(2) NOT NULL,
  `departamento` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `departamento`
--

INSERT INTO `departamento` (`idDepartamento`, `departamento`) VALUES
(1, 'Amazonas'),
(2, 'Antioquia'),
(3, 'Arauca'),
(4, 'Atlántico'),
(5, 'Bogotá D.C.'),
(6, 'Bolívar'),
(7, 'Boyacá'),
(8, 'Caldas'),
(9, 'Caquetá'),
(10, 'Casanare'),
(11, 'Cauca'),
(12, 'Cesar'),
(13, 'Chocó'),
(14, 'Córdoba'),
(15, 'Cundinamarca'),
(16, 'Guainía'),
(17, 'Guaviare'),
(18, 'Huila'),
(19, 'La Guajira'),
(20, 'Magdalena'),
(21, 'Meta'),
(22, 'Nariño'),
(23, 'Norte de Santander'),
(24, 'Putumayo'),
(25, 'Quindío'),
(26, 'Risaralda'),
(27, 'San Andrés y Providencia'),
(28, 'Santander'),
(29, 'Sucre'),
(30, 'Tolima'),
(31, 'Valle del Cauca'),
(32, 'Vaupés'),
(33, 'Vichada');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialista`
--

CREATE TABLE `especialista` (
  `registro` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `idCiudad` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `especialista`
--

INSERT INTO `especialista` (`registro`, `nombre`, `idCiudad`) VALUES
(1001803621, 'ANDERSON BERRIO HERRERA', 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

CREATE TABLE `estado` (
  `idRegistro` int(1) NOT NULL,
  `estado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `estado`
--

INSERT INTO `estado` (`idRegistro`, `estado`) VALUES
(1, 'Activo'),
(2, 'Inactivo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `indicativo`
--

CREATE TABLE `indicativo` (
  `indicativo` varchar(5) NOT NULL,
  `pais` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `indicativo`
--

INSERT INTO `indicativo` (`indicativo`, `pais`) VALUES
('+57', 'Colombia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `origen`
--

CREATE TABLE `origen` (
  `idOrigen` int(1) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `cedula` int(10) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `idCiudad` int(4) NOT NULL,
  `idClinica` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `referencia` varchar(25) NOT NULL,
  `elemento` varchar(200) NOT NULL,
  `costo` decimal(10,2) NOT NULL,
  `stock` int(5) NOT NULL DEFAULT 0,
  `idCategoria` int(2) NOT NULL,
  `idProveedor` int(10) NOT NULL,
  `idOrigen` int(1) NOT NULL,
  `invima` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `nit` int(10) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `idCiudad` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`nit`, `nombre`, `direccion`, `idCiudad`) VALUES
(804010334, 'MEDIIMPLANTES', 'Parque industrial Manzana C Bodega 10', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rh`
--

CREATE TABLE `rh` (
  `identificador` int(1) NOT NULL,
  `tipoSangre` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `rh`
--

INSERT INTO `rh` (`identificador`, `tipoSangre`) VALUES
(1, 'A+'),
(2, 'A-'),
(3, 'B+'),
(4, 'B-'),
(5, 'AB+'),
(6, 'AB-'),
(7, 'O+'),
(8, 'O-');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `identificacion` int(10) NOT NULL,
  `usuario` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `idEstado` int(1) NOT NULL,
  `idCargo` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`identificacion`, `usuario`, `password`, `idEstado`, `idCargo`) VALUES
(86066225, 'alvaro.rubiano', 'alvaro.rubiano', 1, 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actividades`
--
ALTER TABLE `actividades`
  ADD PRIMARY KEY (`registro`),
  ADD KEY `idPaciente` (`idPaciente`),
  ADD KEY `IdEspecialista` (`idEspecialista`),
  ADD KEY `idProveedor` (`idProveedor`),
  ADD KEY `idClinica` (`idClinica`);

--
-- Indices de la tabla `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`idCargo`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`idCategoria`);

--
-- Indices de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  ADD PRIMARY KEY (`idCiudad`),
  ADD KEY `idDepartamento` (`idDepartamento`);

--
-- Indices de la tabla `clinica`
--
ALTER TABLE `clinica`
  ADD PRIMARY KEY (`nit`),
  ADD KEY `idCiudad` (`idCiudad`);

--
-- Indices de la tabla `colaborador`
--
ALTER TABLE `colaborador`
  ADD PRIMARY KEY (`identificacion`),
  ADD KEY `idCiudad` (`idCiudad`),
  ADD KEY `idCargo` (`idCargo`);

--
-- Indices de la tabla `departamento`
--
ALTER TABLE `departamento`
  ADD PRIMARY KEY (`idDepartamento`);

--
-- Indices de la tabla `especialista`
--
ALTER TABLE `especialista`
  ADD PRIMARY KEY (`registro`),
  ADD KEY `idCiudad` (`idCiudad`);

--
-- Indices de la tabla `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`idRegistro`);

--
-- Indices de la tabla `indicativo`
--
ALTER TABLE `indicativo`
  ADD PRIMARY KEY (`indicativo`);

--
-- Indices de la tabla `origen`
--
ALTER TABLE `origen`
  ADD PRIMARY KEY (`idOrigen`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`cedula`),
  ADD KEY `idCiudad` (`idCiudad`),
  ADD KEY `idClinica` (`idClinica`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`referencia`),
  ADD KEY `idCategoria` (`idCategoria`),
  ADD KEY `idProveedor` (`idProveedor`),
  ADD KEY `idOrigen` (`idOrigen`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`nit`),
  ADD KEY `idCiudad` (`idCiudad`);

--
-- Indices de la tabla `rh`
--
ALTER TABLE `rh`
  ADD PRIMARY KEY (`identificador`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`identificacion`),
  ADD KEY `idEstado` (`idEstado`),
  ADD KEY `idCargo` (`idCargo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `actividades`
--
ALTER TABLE `actividades`
  MODIFY `registro` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cargo`
--
ALTER TABLE `cargo`
  MODIFY `idCargo` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `idCategoria` int(2) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  MODIFY `idCiudad` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT de la tabla `departamento`
--
ALTER TABLE `departamento`
  MODIFY `idDepartamento` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT de la tabla `estado`
--
ALTER TABLE `estado`
  MODIFY `idRegistro` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `origen`
--
ALTER TABLE `origen`
  MODIFY `idOrigen` int(1) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `rh`
--
ALTER TABLE `rh`
  MODIFY `identificador` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `colaborador`
--
ALTER TABLE `colaborador`
  ADD CONSTRAINT `colaborador_ibfk_1` FOREIGN KEY (`idCargo`) REFERENCES `cargo` (`idCargo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `colaborador_ibfk_2` FOREIGN KEY (`idCiudad`) REFERENCES `ciudad` (`idCiudad`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`idProveedor`) REFERENCES `proveedor` (`nit`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `producto_ibfk_2` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`),
  ADD CONSTRAINT `producto_ibfk_3` FOREIGN KEY (`idOrigen`) REFERENCES `origen` (`idOrigen`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`idCargo`) REFERENCES `cargo` (`idCargo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`idEstado`) REFERENCES `estado` (`idRegistro`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
