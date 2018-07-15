use gimnasio;

-- tabla provincia
Insert Into Provincia (Nombre) Values ('Buenos Aires');

-- tabla ciudad
Insert Into Ciudad (Nombre, provincia_id) Values ('Buenos Aires', 1);
Insert Into Ciudad (Nombre, provincia_id) Values ('Ramos Mejia', 1);
Insert Into Ciudad (Nombre, provincia_id) Values ('San Justo', 1);

-- tabla usuario select * from usuario;
insert into usuario(nick, password,rol)
value('admin','admin','admin');
insert into usuario(nick, password, rol)
value('mati', 'mati', 'socio');
insert into usuario(nick, password, rol)
value('lopez', 'lopez', 'socio');
insert into usuario(nick, password, rol)
value('ale', 'ale', 'socio');
insert into usuario(nick, password, rol)
value('op1', 'op1', 'operador');
insert into usuario(nick, password, rol)
value('op2', 'op2', 'operador');
insert into usuario(nick, password, rol)
value('op3', 'op3', 'operador');

-- tabla Operador
insert into Operador(apellido, nombre, usuario_id)
values('Alvarez', 'Miguel', 5);
insert into Operador(apellido, nombre, usuario_id)
values('Martinez', 'Veronica', 6);
insert into Operador(apellido, nombre, usuario_id)
values('Emma', 'Lee', 7);

-- tabla sucursal
insert into Sucursal(calle, codPostal, nombre, numcalle, pais, ciudad_id, operador_id, provincia_id, lat, lng)
values('Avenida de mayo', '1704','Sucursal Ramos Mejia','1800','Argentina', 2, 1, 1, -34.65915,-58.5643008);
insert into Sucursal(calle, codPostal, nombre, numcalle, pais, ciudad_id, operador_id, provincia_id, lat, lng)
values('Maipu', '1006','Sucursal Centro','850','Argentina', 1, 2, 1,-34.5981557,-58.3790881);
insert into Sucursal(calle, codPostal, nombre, numcalle, pais, ciudad_id, operador_id, provincia_id, lat, lng)
values('Alvarado', '1704','Sucursal Alvarado','900','Argentina', 2, null, 1, -34.654, -58.5695);
insert into Sucursal(calle, codPostal, nombre, numcalle, pais, ciudad_id, operador_id, provincia_id, lat, lng)
values('Florencio Varela', '1704','Sucursal Florencio Varela','1903','Argentina', 3, null, 1, -34.6699, -58.5626);



-- tabla pase
insert into Pase(cantidadActividades, nombre, precio)
values(2,'Plan Inicial', 700);
insert into Pase(cantidadActividades, nombre, precio)
values(3,'Plan Basico', 800);
insert into Pase(cantidadActividades, nombre, precio)
values(10,'Plan Plus', 1200);
insert into Pase(cantidadActividades, nombre, precio)
values(null,'Plan Premiun', 1700);
insert into Pase(cantidadActividades, nombre, precio)
values(0,'Vacio', 0);

-- tabla socio
insert into Socio(apellido, dni, domicilioCalle, domicilioDepto, domicilioNumero, mail, nombre, telefono, ciudad_id, pase_id,sucursal_id, usuario_id)
values('Suarez', '29941591','oro',null,'1813', 'matisuarez@gmail.com', 'Matias', '1544896790',1, 1, 1, 2);
insert into Socio(apellido, dni, domicilioCalle, domicilioDepto, domicilioNumero, mail, nombre, telefono, ciudad_id, pase_id, sucursal_id, usuario_id)
values('Lopez', '40345678','suipacha',null,'300', 'jlopez@gmail.com', 'Julieta','1593457123',1, 4, 2, 3);
insert into Socio(apellido, dni, domicilioCalle, domicilioDepto, domicilioNumero, mail, nombre, telefono, ciudad_id, pase_id,sucursal_id, usuario_id)
values('Casus', '29941591','coro',null,'813', 'ale@gmail.com', 'Alejandra', '1544833390',1, 1, 1, 4);

-- tabla beneficio
insert into Beneficio (descripcion, descuento, nombre, pase_id)
values('En cualquier producto de nuestra tienda','20% OFF','Adidas',4);
insert into Beneficio (descripcion, descuento, nombre, pase_id)
values('Valido unicamente para indumentaria (no zapatillas)','20% OFF','Nike',4);
insert into Beneficio (descripcion, descuento, nombre, pase_id)
values('En todos los productos exceptuando lentes de contacto descartables y soluciones','30% OFF','Lof',4);
insert into Beneficio (descripcion, descuento, nombre, pase_id)
values('En mesas restaurante y sobre cubierto en salones privados para eventos','25% OFF','America Resto',4);
insert into Beneficio (descripcion, descuento, nombre, pase_id)
values('En plan de salud plata','15% OFF','Medife',4);

insert into Beneficio (descripcion, descuento, nombre, pase_id)
values('En cualquier producto de nuestra tienda','10% OFF','Adidas',3);
insert into Beneficio (descripcion, descuento, nombre, pase_id)
values('En mesas restaurante y sobre cubierto en salones privados para eventos','15% OFF','America Resto',3);
insert into Beneficio (descripcion, descuento, nombre, pase_id)
values('En plan de salud clasico','10% OFF','Medife',3);

insert into Beneficio (descripcion, descuento, nombre, pase_id)
values('Solo valido para mesas restaurante','10% OFF','America Resto',2);
insert into Beneficio (descripcion, descuento, nombre, pase_id)
values('En planes de salud basico','5% OFF','Medife',2);

insert into Beneficio (descripcion, descuento, nombre, pase_id)
values('En mesas restaurante','5% OFF','America Resto',1);

-- tabla actividad
insert into actividad(nombre, descripcion) values ('Pilates', 'El método Pilates es un sistema de ejercicios apto para todas las edades y condiciones físicas, orientado a la flexibilidad y tonificación corporal, modelando la figura y estilizando la musculatura.');
insert into actividad(nombre, descripcion) values ('Natacion', 'Genera un importante fortalecimiento cordiopulmonar, reduciendo el riesgo de enfermedades cardiovasculares y estimulando la circulación sanguínea.');
insert into actividad(nombre, descripcion) values ('Yoga','Esta clase basada en la disciplina india, incluye posturas de yoga, ejercicios de respiración y relajación con el objetivo de brindarle atención a tu cuerpo y a tu mente.');
insert into actividad(nombre, descripcion) values ('Spinning','Mejora el sistema cardiovascular y pulmonar. Disminuye la grasa corporal, ya que ayuda a quemar muchas calorías.');
insert into Actividad(nombre, descripcion) values ('Crossfit', 'Preparate para romper tus límites. Crossfit es el entrenamiento diseñado a la medida de tu cuerpo: +Agilidad +Fuerza +Resistencia +Coordinación');
insert into Actividad(nombre, descripcion) values ('Cardio Funcional' ,'Mejora la salud del corazón, aumenta la capacidad de usar oxígeno y la capacidad pulmonar.');
insert into Actividad(nombre, descripcion) values ('Boxeo','Orientado a mejorar las capacidades físicas para lograr un mejor rendimiento. Tiene como principal objetivo el entrenamiento del movimiento del cuerpo en todos sus ejes y en sus rangos de movimiento natural.');
insert into Actividad(nombre, descripcion) values ('Fitness', 'Brinda mayor elasticidad a la musculatura, mejorando la postura y aliviando dolores musculares, de espalda, al fortalecer el anillo muscular a nivel de la columna lumbar.');
insert into Actividad(nombre, descripcion) values ('Zumba','Esta entretenida clase propone distintos ritmos bailables latinos como el axé, brasilero, etc.');
insert into Actividad(nombre, descripcion) values ('Musculacion', 'Mejora la fuerza y resistencia, desarrollando armónicamente todos los grupos musculares, previniendo lesiones.');

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
insert into sucursalactividad (cupo, cupoActual, dia, horaDesde, horaHasta, actividad_id,profesor_id, sucursal_id)
values (5, 0,'Lunes','10','11',1,1,2);
insert into sucursalactividad (cupo, cupoActual, dia, horaDesde, horaHasta, actividad_id,profesor_id, sucursal_id)
values (2, 0,'Martes','8','9',2,2,2);

insert into sucursalactividad (cupo, cupoActual, dia, horaDesde, horaHasta, actividad_id,profesor_id, sucursal_id)
values (5, 0,'Miercoles','20','21',1,3,1);
insert into sucursalactividad (cupo, cupoActual, dia, horaDesde, horaHasta, actividad_id,profesor_id, sucursal_id)
values (2, 0,'Lunes','9','10',2,4,1);
insert into sucursalactividad (cupo, cupoActual, dia, horaDesde, horaHasta, actividad_id,profesor_id, sucursal_id)
values (10, 0,'Viernes','15','16',3,5,1);
insert into sucursalactividad (cupo, cupoActual, dia, horaDesde, horaHasta, actividad_id,profesor_id, sucursal_id)
values (15, 0,'Sabado','11','12',4,1,1);

-- tabla pago
insert into pago(fecha,importe,socio_idSocio,fechaVencimiento)
values('20180502', 1200.00,1,'20180602');
insert into pago(fecha,importe,socio_idSocio,fechaVencimiento)
values('20180505', 800.00,1,'20180605');
insert into pago(fecha,importe,socio_idSocio,fechaVencimiento)
values('20180615', 500.00,2,'20180715');
insert into pago(fecha,importe,socio_idSocio,fechaVencimiento)
values('20180625', 400.00,1,'20180725');
insert into pago(fecha,importe,socio_idSocio,fechaVencimiento)
values('20180425', 400.00,3,'20180525');



-- tabla pase_beneficio (ingreso para cuando se corre script a mano)
insert into pase_beneficio (pase_id, listaBeneficios_id)
values(1,11);
insert into pase_beneficio (pase_id, listaBeneficios_id)
values(2,9), (2,10);
insert into pase_beneficio (pase_id, listaBeneficios_id)
values(3,6),(3,7),(3,8);
insert into pase_beneficio (pase_id, listaBeneficios_id)
values(4,1),(4,2),(4,3),(4,4),(4,5);

-- table sucursal_socio(ingreso para cuando se corre script a mano)
insert into sucursal_socio (sucursal_id, listaSocios_idSocio)
value (1,1),(2,2);

-- Descuentos
insert into descuento (meses,descuento,porcentaje)
value(1,0,0.0);
insert into descuento (meses,descuento,porcentaje)
value(3,5,0.95);
insert into descuento (meses,descuento,porcentaje)
value(6,10,0.90);
insert into descuento (meses,descuento,porcentaje)
value(12,15,0.85);



