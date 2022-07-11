CREATE DATABASE supermark ;
USE supermark;
CREATE TABLE tipo_usuario (
  id_tipo_usuario int NOT NULL AUTO_INCREMENT,
  nombre_tipo varchar(10) NOT NULL,
  rol varchar(40) DEFAULT NULL,
  PRIMARY KEY (id_tipo_usuario)
) ;
CREATE TABLE usuario (
  id_usuario int NOT NULL AUTO_INCREMENT,
  nombre_usuario varchar(15) DEFAULT NULL,
  apellido_usuario varchar(15) DEFAULT NULL,
  email_usuario varchar(20) DEFAULT NULL,
  telefono_usuario int DEFAULT NULL,
  contrasenia_usuario varchar(8) DEFAULT NULL,
  id_tipo_usuario int DEFAULT NULL,
  tiene_tarjeta_usuario tinyint(1) DEFAULT NULL,
  PRIMARY KEY (id_usuario),
  KEY fk_id_tipo_usuario (id_tipo_usuario),
  CONSTRAINT fk_id_tipo_usuario FOREIGN KEY (id_tipo_usuario) REFERENCES tipo_usuario (id_tipo_usuario) 
  ON DELETE CASCADE ON UPDATE CASCADE
) ;
CREATE TABLE ventas (
  id_venta int NOT NULL AUTO_INCREMENT,
  fecha date DEFAULT NULL,
  detalle varchar(400) DEFAULT NULL,
  total double DEFAULT NULL,
  id_usuario int DEFAULT NULL,
  PRIMARY KEY (id_venta),
  KEY fk_id_usuario_idx (id_usuario),
  CONSTRAINT fk_id_usuario FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario) 
  ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE categoria (
  id_categoria int NOT NULL AUTO_INCREMENT,
  nombre_categoria varchar(30) DEFAULT NULL,
  PRIMARY KEY (id_categoria)) ;

CREATE TABLE producto (
  id_producto int NOT NULL AUTO_INCREMENT,
  nombre_producto varchar(30) DEFAULT NULL,
   stock_producto int DEFAULT NULL,
  precio_unit_producto double DEFAULT NULL,
  id_categoria int DEFAULT NULL,
  PRIMARY KEY (id_producto),
  KEY fk_id_categoria_idx (id_categoria),
  CONSTRAINT fk_id_categoria FOREIGN KEY (id_categoria) REFERENCES categoria (id_categoria) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE detallepxv (
  id_detalle int NOT NULL AUTO_INCREMENT,
  id_venta int DEFAULT NULL,
  id_producto int DEFAULT NULL,
  PRIMARY KEY (id_detalle),
  KEY fk_id_venta_idx (id_venta),
  KEY fk_id_producto_idx (id_producto),
  CONSTRAINT fk_id_producto FOREIGN KEY (id_producto) REFERENCES producto (id_producto) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_id_venta FOREIGN KEY (id_venta) REFERENCES ventas (id_venta) ON DELETE CASCADE ON UPDATE CASCADE
) ;






