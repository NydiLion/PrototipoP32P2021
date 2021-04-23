-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `LabFM3` DEFAULT CHARACTER SET utf8 ;
USE `LabFM3` ;


-- -----------------------------------------------------
-- Table `LabFM3`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LabFM3`.`usuario` (
  `id_usuario` int AUTO_INCREMENT ,
  `username` VARCHAR(100),
  `password` VARCHAR(100),
  PRIMARY KEY (`id_usuario`))
  ENGINE = InnoDB 
  CHARACTER SET = utf8;



-- -----------------------------------------------------
-- Table `LabFM3`.`Clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LabFM3`.`Clientes` (
  `Numero_Tarjeta` VARCHAR(100),
  `Nombre_Cliente` VARCHAR(100),
  `Dpi_Cliente` VARCHAR(100),
  `Telefono_Cliente` VARCHAR(100),
  `Dirreccion_Cliente` VARCHAR(100),
  `Correo_Cliente` VARCHAR(100),
  PRIMARY KEY (`Numero_Tarjeta`))
  ENGINE = InnoDB 
  CHARACTER SET = utf8;


  
  
  
  

  

  

      -- -----------------------------------------------------
-- Table `LabFM3`.`Tiendas`
-- -----------------------------------------------------
  
  CREATE TABLE IF NOT EXISTS `LabFM3`.`Tiendas` (
  `Codigo_Tienda` VARCHAR(100),
  `Nombre_Tienda` VARCHAR(100),
  `Ubicacion_Tienda` VARCHAR(100),
  `Estado_Tienda` VARCHAR(100),
  PRIMARY KEY (`Codigo_Tienda`))
  ENGINE = InnoDB 
  CHARACTER SET = utf8;
  


        -- -----------------------------------------------------
-- Table `LabFM3`.`Empleados`
-- -----------------------------------------------------
  
  
    CREATE TABLE IF NOT EXISTS `LabFM3`.`Empleados` (
  `Codigo_Empleado` VARCHAR(100),
  `Codigo_Tienda` VARCHAR(100),
  `Nombre_Empleado` VARCHAR(100),
  `Estado_Empleado` VARCHAR(100),
  PRIMARY KEY (`Codigo_Empleado`),
CONSTRAINT `fkEmpleadosTiendas1`
FOREIGN KEY (`Codigo_Tienda`)
REFERENCES `LabFM2`.`Tiendas` (`Codigo_Tienda`))
  ENGINE = InnoDB 
  CHARACTER SET = utf8;
  
  
     -- -----------------------------------------------------
-- Table `LabFM3`.`Peliculas`
-- -----------------------------------------------------
  
  
    CREATE TABLE IF NOT EXISTS `LabFM3`.`Pelicula` (
  `Codigo_Pelicula` VARCHAR(100),
  `Nombre_Pelicula` VARCHAR(100),
  `Autor_Pelicula` VARCHAR(100),
  `Genero_Pelicula` VARCHAR(100),
`Clasificacion_Pelicula` VARCHAR(100),
  `Duracion_Pelicula` VARCHAR(100),
  `Precio_Pelicula` VARCHAR(100),
  `Existencias` VARCHAR(100),
  `Tienda` VARCHAR(100),
  PRIMARY KEY (`Codigo_Pelicula`),
CONSTRAINT `fkPeliculaTiendas1`
FOREIGN KEY (`Tienda`)
REFERENCES `LabFM2`.`Tiendas` (`Codigo_Tienda`))
  ENGINE = InnoDB 
  CHARACTER SET = utf8;
       -- -----------------------------------------------------
-- Table `LabFM3`.`rentas`
-- -----------------------------------------------------
  
  CREATE TABLE IF NOT EXISTS `LabFM3`.`Rentas` (
`Codigo_Renta` VARCHAR(100),
`Codigo_Tienda` VARCHAR(100),
`Codigo_Tarjeta` VARCHAR(100),
`Codigo_Pelicula` VARCHAR(100),
`Cantidad_Peliculas` VARCHAR(100),
`Total_Renta` VARCHAR(100),
`Fecha_Inicio` VARCHAR(100),
`Fecha_Vencimiento` VARCHAR(100),
  PRIMARY KEY (`Codigo_Renta`),
CONSTRAINT `fkRentasClientes1`
FOREIGN KEY (`Codigo_Tarjeta`)
REFERENCES `LabFM2`.`Clientes` (`Numero_Tarjeta`),
CONSTRAINT `fkRentasPelicula1`
FOREIGN KEY (`Codigo_Pelicula`)
REFERENCES `LabFM2`.`Pelicula` (`Codigo_Pelicula`),
CONSTRAINT `fkRentasTiendas1`
FOREIGN KEY (`Codigo_Tienda`)
REFERENCES `LabFM2`.`Tiendas` (`Codigo_Tienda`))
  ENGINE = InnoDB 
  CHARACTER SET = utf8;
  
  
  
       -- -----------------------------------------------------
-- Table `LabFM3`.`Devoluacionnes`
-- -----------------------------------------------------
  
  
    CREATE TABLE IF NOT EXISTS `LabFM3`.`Devoluciones` (
  `Codigo_Devolucion` VARCHAR(100),
  `Codigo_Renta` VARCHAR(100),
  `Fecha_Devolucion` VARCHAR(100),
  PRIMARY KEY (`Codigo_Devolucion`),
CONSTRAINT `fkDevolucionesRentas1`
FOREIGN KEY (`Codigo_Renta`)
REFERENCES `LabFM2`.`Rentas` (`Codigo_Renta`))
  ENGINE = InnoDB 
  CHARACTER SET = utf8;
  

Select * from Pelicula;

Select * from Clientes;

Select * from Empleados;

Select * from Tiendas;

Select * from Rentas;