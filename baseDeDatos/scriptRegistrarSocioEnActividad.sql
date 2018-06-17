-- tabla provincia
Insert Into Provincia (Nombre) Values ('Buenos Aires');
Insert Into Provincia (Nombre) Values ('Capital Federal');

-- ciudad
Insert Into Ciudad (Nombre, provincia_id) Values ('12 de Agosto', 1);
Insert Into Ciudad (Nombre, provincia_id) Values ('12 de Octubre', 1);

-- tabla sucursal
insert into Sucursal(calle, codPostal, nombre, numcalle, pais, ciudad_id, provincia_id)
values('avenida de mayo', '1704','Sucursal Ramos Mejia','1800','Argentina', 2, 1);
insert into Sucursal(calle, codPostal, nombre, numcalle, pais, ciudad_id, provincia_id)
values('Maipu', '1005','Sucursal Centro','850','Argentina', 2, 1);

-- tabla socio
insert into Socio(apellido, dni, domicilioCalle, domicilioDepto, domicilioNumero, mail, nombre, pais, telefono, ciudad_id, pase_id, provincia_id, sucursal_id)
values('Suarez', '29941591','oro',null,'1813', 'matisuarez@gmail.com', 'Matias', 'Argentina', '1544896790',1, null, 1, 1);
insert into Socio(apellido, dni, domicilioCalle, domicilioDepto, domicilioNumero, mail, nombre, pais, telefono, ciudad_id, pase_id, provincia_id, sucursal_id)
values('Lopez', '40345678','suipacha',null,'300', 'jlopez@gmail.com', 'Julieta', 'Argentina','1593457123', 1, null, 1, 2);

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