-- borra la bd si existe
DROP DATABASE IF EXISTS DbSofia;
CREATE DATABASE DbSofia;
USE DbSofia;

create table tb_number(
idnumber int primary Key,
prefij varchar(5) not null,
numeracion int not null
);

create table tb_tipoproductos(
idtipo int primary key,
descripcion varchar(45) not null
);

create table tb_proveedor(
idproveedor int  AUTO_INCREMENT primary key,
rucdni varchar(15) unique,
razonsocial varchar(100) not null,
celular varchar(15) not null,
correo varchar(50) not null,
estado bit default 1
);

create table tb_productos(
idprod int not null primary key,
tipo int,
descripcion varchar(100),
precio decimal(8,2),
stock_min int,
stock_max int,
proveedor int,
estado bit default 1
);
ALTER TABLE tb_productos ADD foreign key (tipo) references tb_tipoproductos(idtipo);
ALTER TABLE tb_productos ADD foreign key (proveedor) references tb_proveedor(idproveedor);

create table tb_clientes(
idcliente int  AUTO_INCREMENT primary key,
rucdni varchar(15) unique,
razonsocial varchar(100) not null,
direccion  varchar(100) not null,
celular varchar(15) not null,
estado bit default 1
);



create table tb_operaciones(
operaciones int AUTO_INCREMENT primary key,
proceso varchar(10) not null,
tipo tinyint not null,                      -- 1 = REPOSICION / 2 = VENTA
producto int NOT NULL,
cantidad int not null,
preciocpa decimal(8,2),
fechacpa timestamp default now(),
estado tinyint not null default 1
);

ALTER TABLE tb_operaciones ADD foreign key (producto) references tb_productos(idprod);

create table tb_ventas(
ventas varchar(10) primary key,
cliente int NOT NULL,
precio decimal(8,2),
fecha datetime,
estado bit default 1
);
ALTER TABLE tb_ventas ADD foreign key (cliente) references tb_clientes(idcliente);

create table tb_usuarios(
idusuario int primary key,
nombre varchar(80) not null,
usuario varchar(15) NOT NULL,
clave varchar(15) NOT NULL,
estado bit default 1
);

insert into tb_number VALUES (1,'VTA-',1);
insert into tb_number VALUES (2,'PDT-',11);
insert into tb_tipoproductos values (1,"Gaseosas y Bebidas");
insert into tb_tipoproductos values (2,"Convervas");
insert into tb_tipoproductos values (3,"Golosinas");
insert into tb_tipoproductos values (4,"Abarrotes");
insert into tb_tipoproductos values (5,"Aseo Personal");
insert into tb_tipoproductos values (6,"Productos de Limpieza");
insert into tb_tipoproductos values (7,"Menestras y Especias");
insert into tb_proveedor values (default,"20070321659","COMERCIAL LA GOLOCINA E.I.R.L.","998521445","ventas@lagolocina.com",default);
insert into tb_proveedor values (default,"25544458225","CORDIAL CORPORACION DISTRIBUIDORA DE ALIMENTOS S.R.L.","988589452","ventas@cocodist.com.pe",default);
insert into tb_proveedor values (default,"43322581","JULIO MARIO PEREZ MIRANDA","999251255","jperez@gmail.com",default);
insert into tb_productos values (1,1,"COCA COLA 600 ML X UND",2.50,6,48,1,default);
insert into tb_productos values (2,1,"INKA KOLA 600 ML X UND",2.50,6,48,1,default);
insert into tb_productos values (3,1,"FANTA 500 ML X UND",2.00,6,48,1,default);
insert into tb_productos values (4,1,"SPRITE 500 ML X UND",2.00,6,48,1,default);
insert into tb_productos values (5,4,"FILETE DE ATUN GLORIA X UND",4.50,6,24,2,default);
insert into tb_productos values (6,4,"FILETE DE ATUN SAN FERNANDO X UND",5.00,6,24,2,default);
insert into tb_productos values (7,4,"ATUN EN TROZOS ALAMAR X UND",4.80,6,24,2,default);
insert into tb_productos values (8,4,"ATUN EN TROZOS PRIMOR X UND",4.70,6,24,2,default);
insert into tb_productos values (9,4,"ARROZ LA CACERITA AÑEJO X KILO",4.20,20,50,3,default);
insert into tb_productos values (10,4,"ARROZ COSTEÑO GRANEADITO X KILO",4.50,20,50,3,default);
insert into tb_clientes values (default,"45525645","JUAN JOSE MEDINA CACERES","LAS ALMENDRAS 136 - SURCO","990584475",DEFAULT);
insert into tb_clientes values (default,"20054212559","BODEGA LUIS FELIPE","VILLA ATAÑO 342 INT A - COMAS","990682222",DEFAULT);
insert into tb_usuarios values (1,"Usuario ROOT","root","root",default);
insert into tb_operaciones values (1,"PR001",1,1,20,5.00,default,default);
insert into tb_operaciones values (2,"PR002",1,1,-5,5.00,default,default);

/*

use dbsofia
select * from tb_number
select * from tb_proveedor

update tb_productos set estado=0 where idprod=2;
*/