
create table Aeropuerto (
	nombre varchar(15) primary key,
    ciudad varchar(20)
);
create table Pasaje (
	numero int primary key
);
create table Avion (
    modelo varchar(20),
    matricula varchar(8) primary key,
    aerolinea varchar(25),
	foreign key (aerolinea) references aerolinea(nombre)
);
create table Cliente (
	nombre varchar(15),
    alias varchar(25),
    apellido1 varchar(25),
    apellido2 varchar(25),
    direccion varchar(50),
    email varchar (25),
    dni varchar(9) primary key,
    contraseña varchar(25)
);
create table Asiento (
	nombre varchar(25) primary key,
	ocupado boolean,
	precio float,
    avion varchar(8),
    foreign key (avion) references Avion(matricula)
);
create table Aerolinea (
	nombre varchar(25) primary key
);
create table Aerolinea_aavv (
	aerolinea varchar(25),
    aavv varchar(15),
    foreign key (aerolinea) references aerolinea(nombre),
    foreign key (aavv) references agenciaViajes(nombre)
);
create table Vuelo (
	aerolinea varchar(25),
    fecha datetime,
    codVuelo int primary key,
    aeropuertoOrigen varchar(25),
    aeropuertoDestino varchar(25),
    avion varchar(8),
    foreign key (aerolinea) references Aerolinea(nombre),
    foreign key (avion) references Avion(matricula) 
);
# Prueba con primer usuario
insert into Cliente values('Daniel','Camargo','Pepinosa','Colombianito','Calle 1, pueblo 2','ff@hotmail.com','12345678Z','1234');


# Insertar datos de los vuelos para consultarlos
insert into Vuelo (aerolinea, fecha, codVuelo, aeropuertoOrigen, aeropuertoDestino) values ('Iberia','2021-07-28','508','Málaga','Madrid');
insert into Vuelo (aerolinea, fecha, codVuelo, aeropuertoOrigen, aeropuertoDestino) values ('Iberia','2021-06-01','895','Málaga','París');
insert into Vuelo (aerolinea, fecha, codVuelo, aeropuertoOrigen, aeropuertoDestino) values ('Iberia','2021-10-09','885','Barcelona','Bruselas');
insert into Vuelo (aerolinea, fecha, codVuelo, aeropuertoOrigen, aeropuertoDestino) values ('Level','2021-12-30','484','Madrid','Berlín');
insert into Vuelo (aerolinea, fecha, codVuelo, aeropuertoOrigen, aeropuertoDestino) values ('Iberia','2021-06-09','154','Málaga','Roma');
insert into Vuelo (aerolinea, fecha, codVuelo, aeropuertoOrigen, aeropuertoDestino) values ('Iberia','2021-11-22','784','Málaga','Moscú');
insert into Vuelo (aerolinea, fecha, codVuelo, aeropuertoOrigen, aeropuertoDestino) values ('Level','2021-10-21','598','Gibraltar','Barcelona');
insert into Vuelo (aerolinea, fecha, codVuelo, aeropuertoOrigen, aeropuertoDestino) values ('Vueling','2021-07-11','511','Málaga','Londres');
insert into Vuelo (aerolinea, fecha, codVuelo, aeropuertoOrigen, aeropuertoDestino) values ('Air Europa','2021-06-19','489','Gibraltar','Londres');
insert into Vuelo (aerolinea, fecha, codVuelo, aeropuertoOrigen, aeropuertoDestino) values ('Air Europa','2021-09-13','689','Madrid','Tokio');