-- Crear Base de datos
CREATE DATABASE `dbalmacen` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `dbalmacen`;

-- Creacion de las tablas
CREATE TABLE `usuarios` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Usuario` varchar(140) NOT NULL,
  `Nombre` varchar(140) NOT NULL,
  `Apellido` varchar(140) NOT NULL,
  `Telefono` varchar(140) NOT NULL,
  `Correo` varchar(140) NOT NULL,
  `Contraseña` varchar(140) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `productos` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NombreProducto` varchar(140) NOT NULL,
  `MarcaProducto` varchar(140) NOT NULL,
  `CategoriaProducto` varchar(140) NOT NULL,
  `PrecioProducto` int NOT NULL,
  `StockProducto` int NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- Registros de prueba
INSERT INTO `dbalmacen`.`usuarios`
(`Usuario`,
`Nombre`,
`Apellido`,
`Telefono`,
`Correo`,
`Contraseña`)
VALUES
('Admin','Admin','Admin','809-333-4444','admin@local.com','admin'),
('Ultimate', 'Ultimate', 'Ultimate','809-888-9999','ultimate@local.com','ultimate');

INSERT INTO `dbalmacen`.`productos`
(`NombreProducto`,
`MarcaProducto`,
`CategoriaProducto`,
`PrecioProducto`,
`StockProducto`)
VALUES
('Iphone x', 'Apple','Celular',25000,250),
('Sansumg s10', 'Sansumg','Celular',23000,250);



