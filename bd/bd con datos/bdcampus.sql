-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-10-2017 a las 04:06:04
-- Versión del servidor: 10.1.16-MariaDB
-- Versión de PHP: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdcampus`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actividad`
--

CREATE TABLE `actividad` (
  `idActividad` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `estado` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `actividad`
--

INSERT INTO `actividad` (`idActividad`, `nombre`, `estado`) VALUES
(1, 'Ver Pelicula', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `idadministrador` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `sexo` int(11) NOT NULL,
  `edad` int(11) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `clave` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`idadministrador`, `nombre`, `apellido`, `sexo`, `edad`, `correo`, `usuario`, `clave`) VALUES
(1, 'jhon', 'vilchez', 1, 19, 'nose@gmail.com', 'jhonk', '1111');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `idalumno` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `sexo` int(11) NOT NULL,
  `edad` int(11) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `clave` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`idalumno`, `nombre`, `apellido`, `sexo`, `edad`, `correo`, `usuario`, `clave`) VALUES
(1, 'luis', 'mozombite', 1, 21, 'nose@gmail.com', 'luis', '1111');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `anuncios`
--

CREATE TABLE `anuncios` (
  `idanuncios` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `horario_idhorario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `anuncios`
--

INSERT INTO `anuncios` (`idanuncios`, `nombre`, `horario_idhorario`) VALUES
(1, 'hola mundo', 1),
(2, 'hey', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistencia`
--

CREATE TABLE `asistencia` (
  `idasistencia` int(11) NOT NULL,
  `asistencia` varchar(45) NOT NULL,
  `matricula_has_curso_matricula_idmatricula` int(11) NOT NULL,
  `matricula_has_curso_curso_idcurso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `asistencia`
--

INSERT INTO `asistencia` (`idasistencia`, `asistencia`, `matricula_has_curso_matricula_idmatricula`, `matricula_has_curso_curso_idcurso`) VALUES
(1, 'asistio', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--

CREATE TABLE `curso` (
  `idcurso` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `curso`
--

INSERT INTO `curso` (`idcurso`, `nombre`) VALUES
(1, 'programacion');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horario`
--

CREATE TABLE `horario` (
  `idhorario` int(11) NOT NULL,
  `fechainicio` varchar(45) NOT NULL,
  `fechafin` varchar(45) NOT NULL,
  `horainicio` varchar(30) NOT NULL,
  `horafin` varchar(45) NOT NULL,
  `profesor_idprofesor` int(11) NOT NULL,
  `curso_idcurso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `horario`
--

INSERT INTO `horario` (`idhorario`, `fechainicio`, `fechafin`, `horainicio`, `horafin`, `profesor_idprofesor`, `curso_idcurso`) VALUES
(1, '19/07/17', '19/12/17', '7:30', '12:30', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `laboratorio`
--

CREATE TABLE `laboratorio` (
  `idLaboratorio` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `estado` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `idLibro` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `autor` varchar(45) NOT NULL,
  `ejemplares` int(11) NOT NULL,
  `estado` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`idLibro`, `nombre`, `autor`, `ejemplares`, `estado`) VALUES
(1, 'Programacion', 'Nose', 12, '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `matricula`
--

CREATE TABLE `matricula` (
  `idmatricula` int(11) NOT NULL,
  `ciclo` varchar(45) NOT NULL,
  `seccion` varchar(45) NOT NULL,
  `administrador_idadministrador` int(11) NOT NULL,
  `alumno_idalumno` int(11) NOT NULL,
  `Pagos_idPagos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `matricula`
--

INSERT INTO `matricula` (`idmatricula`, `ciclo`, `seccion`, `administrador_idadministrador`, `alumno_idalumno`, `Pagos_idPagos`) VALUES
(1, 'V', 'A', 1, 1, 1),
(2, 'AA', 'BB', 1, 1, 1),
(3, 'AA', 'BB', 1, 1, 1),
(4, 'AA', 'BB', 1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `matricula_has_curso`
--

CREATE TABLE `matricula_has_curso` (
  `matricula_idmatricula` int(11) NOT NULL,
  `curso_idcurso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `matricula_has_curso`
--

INSERT INTO `matricula_has_curso` (`matricula_idmatricula`, `curso_idcurso`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notas`
--

CREATE TABLE `notas` (
  `idnotas` int(11) NOT NULL,
  `nota` double NOT NULL,
  `tiponota` varchar(45) NOT NULL,
  `matricula_has_curso_matricula_idmatricula` int(11) NOT NULL,
  `matricula_has_curso_curso_idcurso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `notas`
--

INSERT INTO `notas` (`idnotas`, `nota`, `tiponota`, `matricula_has_curso_matricula_idmatricula`, `matricula_has_curso_curso_idcurso`) VALUES
(1, 20, 'Bien', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pagos`
--

CREATE TABLE `pagos` (
  `idPagos` int(11) NOT NULL,
  `nombrepago` varchar(45) NOT NULL,
  `monto` double NOT NULL,
  `tipomoneda` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `pagos`
--

INSERT INTO `pagos` (`idPagos`, `nombrepago`, `monto`, `tipomoneda`) VALUES
(1, 'pension 1', 500, 'soles');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

CREATE TABLE `profesor` (
  `idprofesor` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `sexo` int(11) NOT NULL,
  `edad` int(11) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `clave` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`idprofesor`, `nombre`, `apellido`, `sexo`, `edad`, `correo`, `usuario`, `clave`) VALUES
(1, 'juan', 'vera', 1, 56, 'nose@gmail.com', 'vera', '1111');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recursos`
--

CREATE TABLE `recursos` (
  `idrecursos` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `contenido` varchar(45) NOT NULL,
  `horario_idhorario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `recursos`
--

INSERT INTO `recursos` (`idrecursos`, `nombre`, `contenido`, `horario_idhorario`) VALUES
(1, 'Examen', 'Examen', 1),
(2, 'Examen', 'Examen', 1),
(3, 'Examen', 'Examen', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservaactividad`
--

CREATE TABLE `reservaactividad` (
  `idReservaActividad` int(11) NOT NULL,
  `dia` varchar(45) NOT NULL,
  `hora` varchar(45) NOT NULL,
  `alumno_idalumno` int(11) NOT NULL,
  `Actividad_idActividad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservalaboratorio`
--

CREATE TABLE `reservalaboratorio` (
  `idReservaLaboratorio` int(11) NOT NULL,
  `horainicio` varchar(45) NOT NULL,
  `horafin` varchar(45) NOT NULL,
  `alumno_idalumno` int(11) NOT NULL,
  `Laboratorio_idLaboratorio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservalibro`
--

CREATE TABLE `reservalibro` (
  `idReservaLibro` int(11) NOT NULL,
  `fechaentrega` varchar(45) NOT NULL,
  `fechadevolucion` varchar(45) NOT NULL,
  `alumno_idalumno` int(11) NOT NULL,
  `Libro_idLibro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actividad`
--
ALTER TABLE `actividad`
  ADD PRIMARY KEY (`idActividad`);

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`idadministrador`);

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`idalumno`);

--
-- Indices de la tabla `anuncios`
--
ALTER TABLE `anuncios`
  ADD PRIMARY KEY (`idanuncios`),
  ADD KEY `fk_anuncios_horario1_idx` (`horario_idhorario`);

--
-- Indices de la tabla `asistencia`
--
ALTER TABLE `asistencia`
  ADD PRIMARY KEY (`idasistencia`),
  ADD KEY `fk_asistencia_matricula_has_curso1_idx` (`matricula_has_curso_matricula_idmatricula`,`matricula_has_curso_curso_idcurso`);

--
-- Indices de la tabla `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`idcurso`);

--
-- Indices de la tabla `horario`
--
ALTER TABLE `horario`
  ADD PRIMARY KEY (`idhorario`),
  ADD KEY `fk_horario_profesor1_idx` (`profesor_idprofesor`),
  ADD KEY `fk_horario_curso1_idx` (`curso_idcurso`);

--
-- Indices de la tabla `laboratorio`
--
ALTER TABLE `laboratorio`
  ADD PRIMARY KEY (`idLaboratorio`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`idLibro`);

--
-- Indices de la tabla `matricula`
--
ALTER TABLE `matricula`
  ADD PRIMARY KEY (`idmatricula`),
  ADD KEY `fk_matricula_administrador_idx` (`administrador_idadministrador`),
  ADD KEY `fk_matricula_alumno1_idx` (`alumno_idalumno`),
  ADD KEY `fk_matricula_Pagos1_idx` (`Pagos_idPagos`);

--
-- Indices de la tabla `matricula_has_curso`
--
ALTER TABLE `matricula_has_curso`
  ADD PRIMARY KEY (`matricula_idmatricula`,`curso_idcurso`),
  ADD KEY `fk_matricula_has_curso_curso1_idx` (`curso_idcurso`),
  ADD KEY `fk_matricula_has_curso_matricula1_idx` (`matricula_idmatricula`);

--
-- Indices de la tabla `notas`
--
ALTER TABLE `notas`
  ADD PRIMARY KEY (`idnotas`),
  ADD KEY `fk_notas_matricula_has_curso1_idx` (`matricula_has_curso_matricula_idmatricula`,`matricula_has_curso_curso_idcurso`);

--
-- Indices de la tabla `pagos`
--
ALTER TABLE `pagos`
  ADD PRIMARY KEY (`idPagos`);

--
-- Indices de la tabla `profesor`
--
ALTER TABLE `profesor`
  ADD PRIMARY KEY (`idprofesor`);

--
-- Indices de la tabla `recursos`
--
ALTER TABLE `recursos`
  ADD PRIMARY KEY (`idrecursos`),
  ADD KEY `fk_recursos_horario1_idx` (`horario_idhorario`);

--
-- Indices de la tabla `reservaactividad`
--
ALTER TABLE `reservaactividad`
  ADD PRIMARY KEY (`idReservaActividad`),
  ADD KEY `fk_ReservaActividad_alumno1_idx` (`alumno_idalumno`),
  ADD KEY `fk_ReservaActividad_Actividad1_idx` (`Actividad_idActividad`);

--
-- Indices de la tabla `reservalaboratorio`
--
ALTER TABLE `reservalaboratorio`
  ADD PRIMARY KEY (`idReservaLaboratorio`),
  ADD KEY `fk_ReservaLaboratorio_alumno1_idx` (`alumno_idalumno`),
  ADD KEY `fk_ReservaLaboratorio_Laboratorio1_idx` (`Laboratorio_idLaboratorio`);

--
-- Indices de la tabla `reservalibro`
--
ALTER TABLE `reservalibro`
  ADD PRIMARY KEY (`idReservaLibro`),
  ADD KEY `fk_ReservaLibro_alumno1_idx` (`alumno_idalumno`),
  ADD KEY `fk_ReservaLibro_Libro1_idx` (`Libro_idLibro`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `anuncios`
--
ALTER TABLE `anuncios`
  ADD CONSTRAINT `fk_anuncios_horario1` FOREIGN KEY (`horario_idhorario`) REFERENCES `horario` (`idhorario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `asistencia`
--
ALTER TABLE `asistencia`
  ADD CONSTRAINT `fk_asistencia_matricula_has_curso1` FOREIGN KEY (`matricula_has_curso_matricula_idmatricula`,`matricula_has_curso_curso_idcurso`) REFERENCES `matricula_has_curso` (`matricula_idmatricula`, `curso_idcurso`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `horario`
--
ALTER TABLE `horario`
  ADD CONSTRAINT `fk_horario_curso1` FOREIGN KEY (`curso_idcurso`) REFERENCES `curso` (`idcurso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_horario_profesor1` FOREIGN KEY (`profesor_idprofesor`) REFERENCES `profesor` (`idprofesor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `matricula`
--
ALTER TABLE `matricula`
  ADD CONSTRAINT `fk_matricula_Pagos1` FOREIGN KEY (`Pagos_idPagos`) REFERENCES `pagos` (`idPagos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_matricula_administrador` FOREIGN KEY (`administrador_idadministrador`) REFERENCES `administrador` (`idadministrador`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_matricula_alumno1` FOREIGN KEY (`alumno_idalumno`) REFERENCES `alumno` (`idalumno`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `matricula_has_curso`
--
ALTER TABLE `matricula_has_curso`
  ADD CONSTRAINT `fk_matricula_has_curso_curso1` FOREIGN KEY (`curso_idcurso`) REFERENCES `curso` (`idcurso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_matricula_has_curso_matricula1` FOREIGN KEY (`matricula_idmatricula`) REFERENCES `matricula` (`idmatricula`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `notas`
--
ALTER TABLE `notas`
  ADD CONSTRAINT `fk_notas_matricula_has_curso1` FOREIGN KEY (`matricula_has_curso_matricula_idmatricula`,`matricula_has_curso_curso_idcurso`) REFERENCES `matricula_has_curso` (`matricula_idmatricula`, `curso_idcurso`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `recursos`
--
ALTER TABLE `recursos`
  ADD CONSTRAINT `fk_recursos_horario1` FOREIGN KEY (`horario_idhorario`) REFERENCES `horario` (`idhorario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `reservaactividad`
--
ALTER TABLE `reservaactividad`
  ADD CONSTRAINT `fk_ReservaActividad_Actividad1` FOREIGN KEY (`Actividad_idActividad`) REFERENCES `actividad` (`idActividad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_ReservaActividad_alumno1` FOREIGN KEY (`alumno_idalumno`) REFERENCES `alumno` (`idalumno`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `reservalaboratorio`
--
ALTER TABLE `reservalaboratorio`
  ADD CONSTRAINT `fk_ReservaLaboratorio_Laboratorio1` FOREIGN KEY (`Laboratorio_idLaboratorio`) REFERENCES `laboratorio` (`idLaboratorio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_ReservaLaboratorio_alumno1` FOREIGN KEY (`alumno_idalumno`) REFERENCES `alumno` (`idalumno`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `reservalibro`
--
ALTER TABLE `reservalibro`
  ADD CONSTRAINT `fk_ReservaLibro_Libro1` FOREIGN KEY (`Libro_idLibro`) REFERENCES `libro` (`idLibro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_ReservaLibro_alumno1` FOREIGN KEY (`alumno_idalumno`) REFERENCES `alumno` (`idalumno`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
