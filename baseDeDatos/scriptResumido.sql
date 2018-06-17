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

-- tabla socio
insert into Socio(apellido, dni, domicilioCalle, domicilioDepto, domicilioNumero, mail, nombre, pais, telefono, ciudad_id, pase_id, provincia_id, sucursal_id)
values('Suarez', '29941591','oro',null,'1813', 'matisuarez@gmail.com', 'Matias', 'Argentina', '1544896790',1, null, 1, 1);
insert into Socio(apellido, dni, domicilioCalle, domicilioDepto, domicilioNumero, mail, nombre, pais, telefono, ciudad_id, pase_id, provincia_id, sucursal_id)
values('Lopez', '40345678','suipacha',null,'300', 'jlopez@gmail.com', 'Julieta', 'Argentina','1593457123', null, null, 2, 2);

-- tabla pase
insert into Pase(cantidadActividades, nombre, precio)
values(null,'Plan Premiun', 1600);
insert into Pase(cantidadActividades, nombre, precio)
values(10,'Plan Estandar', 1200);
insert into Pase(cantidadActividades, nombre, precio)
values(3,'Plan Basico', 800);

-- tabla beneficio
insert into Beneficio (descripcion, nombre, pase_id)
values('Descuento del 20% en tu compra','Adidas',1);
insert into Beneficio (descripcion, nombre, pase_id)
values('Descuento del 20% en tu compra','Nike',1);
insert into Beneficio (descripcion, nombre, pase_id)
values('20% de Descuento en todos los productos exceptuando lentes de contacto descartables y soluciones','Lof',1);
insert into Beneficio (descripcion, nombre, pase_id)
values('20% de descuento en mesas restaurante y
10% de descuento sobre cubierto en salones privados para eventos','Rodizio',1);
insert into Beneficio (descripcion, nombre, pase_id)
values('15% de descuento en planes de salud','Medife',1);

insert into Beneficio (descripcion, nombre, pase_id)
values('Descuento del 10% en tu compra','Adidas',2);
insert into Beneficio (descripcion, nombre, pase_id)
values('15% de descuento en mesas restaurante y
10% de descuento sobre cubierto en salones privados para eventos','Rodizio',2);
insert into Beneficio (descripcion, nombre, pase_id)
values('10% de descuento en planes de salud','Medife',2);

insert into Beneficio (descripcion, nombre, pase_id)
values('10% de descuento en mesas restaurante','Rodizio',3);
insert into Beneficio (descripcion, nombre, pase_id)
values('5% de descuento en planes de salud','Medife',3);

-- tabla actividad
insert into actividad(nombre)
values ('Pilates');
insert into actividad(nombre)
values ('Natacion');

-- tabla sucursal actividad
insert into sucursalactividad (cupo, dia, horaDesde, horaHasta, actividad_id, sucursal_id)
values (5,null,null,null,1,2);
insert into sucursalactividad (cupo, dia, horaDesde, horaHasta, actividad_id, sucursal_id)
values (2,null,null,null,2,2);
