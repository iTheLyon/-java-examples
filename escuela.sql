CREATE TABLE persona (

id int(11) not null  AUTO_INCREMENT,
clave varchar(10) not null,
nombre varchar(50) not null,
domicilio varchar(200) not null,
telefono varchar(15) default null,
correo_electronico varchar(45) default null,
fecha_nacimiento date default null,
genero varchar(10) default null,
primary key(id)

) ENGINE=InnoDB ;