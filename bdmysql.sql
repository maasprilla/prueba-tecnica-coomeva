CREATE TABLE TEST_CLIENTE(
id_cliente int(11) auto_increment primary key,
identifiacion int(11) not null,
nombres varchar(100) not null,
apellidos varchar(100) not null,
direccion varchar(300) not null,
telefono varchar(50),
email varchar(100)
);


CREATE TABLE TEST_PRODUCTO(
id_producto int(11) auto_increment primary key,
codigo varchar(30) not null,
nombre varchar(100) not null,
valor_unidad int(11) not null,
stock int not null
);


CREATE TABLE TEST_FACTURA(
id_factura int(11) auto_increment primary key,
id_cliente int(11) not null,
fecha_venta datetime(3) not null,
valor_total int(11) not null,
foreign key(id_cliente) references TEST_CLIENTE(id_cliente)
);



CREATE TABLE TEST_FACTURA_DETALLE(
id_factura_detalle int(11) auto_increment primary key,
id_factura int(11) not null,
id_producto int(11) not null,
cantidad int not null,
valor_unidad int(11) not null,
valor_total int(11) not null,
foreign key(id_factura) references TEST_FACTURA(id_factura),
foreign key(id_producto) references TEST_PRODUCTO(id_producto)
);


INSERT INTO TEST_CLIENTE(identifiacion,nombres,apellidos,direccion,telefono,email) VALUES('11223344','CLIENTE','BAJO','CALLE 1 # 2-1','3210099','CL01@YAHOO.ES');
INSERT INTO TEST_CLIENTE(identifiacion,nombres,apellidos,direccion,telefono,email) VALUES('789456','PETER','ROJO','CALLE 11 # 21-11',NULL,NULL);
INSERT INTO TEST_CLIENTE(identifiacion,nombres,apellidos,direccion,telefono,email) VALUES('66995522','JAIR','RUIZ','CALLE 63 # 55-1','3669955','JAIR@YAHOO.ES');
INSERT INTO TEST_CLIENTE(identifiacion,nombres,apellidos,direccion,telefono,email) VALUES('2255448','VICTOR','BARCO','CALLE 19 # 21','7410022','VICTOR@YAHOO.ES');
INSERT INTO TEST_CLIENTE(identifiacion,nombres,apellidos,direccion,telefono,email) VALUES('123456789','MARIA','CALLE','CALLE 61 # 77D-96','6660005','CALLE@YAHOO.ES');
INSERT INTO TEST_CLIENTE(identifiacion,nombres,apellidos,direccion,telefono,email) VALUES('41000333','LUIS','CORREO','CALLE 45 # 32-11','4444444','LCORREO@YAHOO.ES');
 
INSERT INTO TEST_PRODUCTO(codigo,nombre,valor_unidad,stock) VALUES('0001','TOSTACOS',950,15);
INSERT INTO TEST_PRODUCTO(codigo,nombre,valor_unidad,stock) VALUES('0002','LECHE',2350,40);
INSERT INTO TEST_PRODUCTO(codigo,nombre,valor_unidad,stock) VALUES('0003','PLATANO',1500,20);
INSERT INTO TEST_PRODUCTO(codigo,nombre,valor_unidad,stock) VALUES('0004','PAÑALES',36500,4);
INSERT INTO TEST_PRODUCTO(codigo,nombre,valor_unidad,stock) VALUES('0005','BULTO DE MANDARINAS',156800,9);
INSERT INTO TEST_PRODUCTO(codigo,nombre,valor_unidad,stock) VALUES('0006','ARROZ',6450,60);
INSERT INTO TEST_PRODUCTO(codigo,nombre,valor_unidad,stock) VALUES('0007','PESCADO',99000,45);
INSERT INTO TEST_PRODUCTO(codigo,nombre,valor_unidad,stock) VALUES('0008','HUEVOS',11500,20);
INSERT INTO TEST_PRODUCTO(codigo,nombre,valor_unidad,stock) VALUES('0009','PAPAS JAJAJAJA',6600,1);
INSERT INTO TEST_PRODUCTO(codigo,nombre,valor_unidad,stock) VALUES('0010','DETERGENTE',5001000,3)
