use gimnasio;

-- tabla provincia
Insert Into Provincia (Nombre) Values ('Buenos Aires');
Insert Into Provincia (Nombre) Values ('Capital Federal');

-- tabla ciudad
Insert Into Ciudad (Nombre, provincia_id) Values ('Ramos Mejia', 1);

-- tabla sucursal
insert into Sucursal(calle, codPostal, nombre, numcalle, pais, ciudad_id, provincia_id)
values('avenida de mayo', '1704','Sucursal Ramos Mejia','1800','Argentina', 1, 1);
insert into Sucursal(calle, codPostal, nombre, numcalle, pais, ciudad_id, provincia_id)
values('Maipu', '1005','Sucursal Centro','850','Argentina', null, 2);

-- tabla usuario
insert into usuario(email,password,rol)
value('admin@stamina.com','admin','admin');
insert into usuario(email, password, rol)
value('matisuarez@gmail.com', '123456', null);
insert into usuario(email, password, rol)
value('jlopez@gmail.com', '123456', null);


-- tabla pase
insert into Pase(cantidadActividades, nombre, precio)
values(2,'Plan Inicial', 700);
insert into Pase(cantidadActividades, nombre, precio)
values(3,'Plan Basico', 800);
insert into Pase(cantidadActividades, nombre, precio)
values(10,'Plan Plus', 1200);
insert into Pase(cantidadActividades, nombre, precio)
values(null,'Plan Premiun', 1700);

-- tabla socio
insert into Socio(apellido, dni, domicilioCalle, domicilioDepto, domicilioNumero, mail, nombre, pais, telefono, ciudad_id, pase_id, provincia_id, sucursal_id, usuario_id)
values('Suarez', '29941591','oro',null,'1813', 'matisuarez@gmail.com', 'Matias', 'Argentina', '1544896790',1, 1, 1, 1, 1);
insert into Socio(apellido, dni, domicilioCalle, domicilioDepto, domicilioNumero, mail, nombre, pais, telefono, ciudad_id, pase_id, provincia_id, sucursal_id, usuario_id)
values('Lopez', '40345678','suipacha',null,'300', 'jlopez@gmail.com', 'Julieta', 'Argentina','1593457123', null, 4, 2, 2, 2);






-- tabla beneficio
insert into Beneficio (descripcion, descuento, nombre, pase_id)
values('En cualquier producto de nuestra tienda','20% OFF','Adidas',4);
insert into Beneficio (descripcion, descuento, nombre, pase_id)
values('Valido unicamente para indumentaria (no zapatillas)','20% OFF','Nike',4);
insert into Beneficio (descripcion, descuento, nombre, pase_id)
values('En todos los productos exceptuando lentes de contacto descartables y soluciones','30% OFF','Lof',4);
insert into Beneficio (descripcion, descuento, nombre, pase_id)
values('En mesas restaurante y sobre cubierto en salones privados para eventos','25% OFF','America Restó',4);
insert into Beneficio (descripcion, descuento, nombre, pase_id)
values('En plan de salud plata','15% OFF','Medife',4);

insert into Beneficio (descripcion, descuento, nombre, pase_id)
values('En cualquier producto de nuestra tienda','10% OFF','Adidas',3);
insert into Beneficio (descripcion, descuento, nombre, pase_id)
values('En mesas restaurante y sobre cubierto en salones privados para eventos','15% OFF','America Restó',3);
insert into Beneficio (descripcion, descuento, nombre, pase_id)
values('En plan de salud clasico','10% OFF','Medife',3);

insert into Beneficio (descripcion, descuento, nombre, pase_id)
values('Solo valido para mesas restaurante','10% OFF','America Restó',2);
insert into Beneficio (descripcion, descuento, nombre, pase_id)
values('En planes de salud basico','5% OFF','Medife',2);

insert into Beneficio (descripcion, descuento, nombre, pase_id)
values('En mesas restaurante','5% OFF','America Restó',1);


-- tabla actividad
insert into actividad(nombre) values ('Pilates');
insert into actividad(nombre) values ('Natacion');
insert into actividad(nombre) values ('Yoga');
insert into actividad(nombre) values ('Spinning');
insert into Actividad(nombre) values ('Kick Boxing');
insert into Actividad(nombre) values ('Crossfit');
insert into Actividad(nombre) values ('Cardio Funcional');
insert into Actividad(nombre) values ('Boxeo');
insert into Actividad(nombre) values ('Fitness');
insert into Actividad(nombre) values ('Zumba');
insert into Actividad(nombre) values ('Body Pump');
insert into Actividad(nombre) values ('Power Plate');

-- tabla profesor
insert into profesor(apellido, nombre)
values('Lopez','Maria');
insert into profesor(apellido, nombre)
values('Fernandez','Juan');
insert into profesor(apellido, nombre)
values('Rodriguez','Laura');
insert into profesor(apellido, nombre)
values('Castro','Diego');
insert into profesor(apellido, nombre)
values('Diaz','Luciano');


-- tabla sucursal actividad
insert into sucursalactividad (cupo, dia, horaDesde, horaHasta, actividad_id,profesor_id, sucursal_id)
values (5,'Lunes','10','11',1,1,2);
insert into sucursalactividad (cupo, dia, horaDesde, horaHasta, actividad_id,profesor_id, sucursal_id)
values (2,'Martes','8','9',2,2,2);

insert into sucursalactividad (cupo, dia, horaDesde, horaHasta, actividad_id,profesor_id, sucursal_id)
values (5,'Miercoles','20','21',1,3,1);
insert into sucursalactividad (cupo, dia, horaDesde, horaHasta, actividad_id,profesor_id, sucursal_id)
values (2,'Lunes','9','10',2,4,1);
insert into sucursalactividad (cupo, dia, horaDesde, horaHasta, actividad_id,profesor_id, sucursal_id)
values (10,'Viernes','15','16',3,5,1);
insert into sucursalactividad (cupo, dia, horaDesde, horaHasta, actividad_id,profesor_id, sucursal_id)
values (15,'Sabado','11','12',4,1,1);



