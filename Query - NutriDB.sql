create database Nutricion
use Nutricion

create table Nutriologos(
	Id_nutriologo char(4) not null primary key,
	Nombre_nutriologo varchar(50) not null,
	Cedula_profesional varchar(10) not null
)

create table Plan_Alimenticio(
Id_plan char(4) not null primary key,
Calorias_plan int,
Proteinas_plan int,
Carbohidratos_plan int,
Grasas_plan int
)

create table Citas(
	Id_citas char(4) not null primary key,
	Persona varchar(20),
	Dia_cita int,
	Mes_cita int,
	Anio_cita int,
	Hora_cita int,
	Motivo_cita Varchar(255)
)

create table Pacientes(
Id_paciente char(4) not null primary key,
Nombre_paciente Varchar(50) not null,
Dom_paciente varchar(80),
Tel_paciente int,
Ocupacion_paciente varchar(30),
Motivo_consulta varchar(255),
Sexo_paciente char(1),
Edad_paciente int
)



create table Antropometria(
Id_antropometria char(4) not null,
Id_paciente char(4) not null foreign key references Pacientes (Id_paciente),
Peso float(20),
Circunferencia_cintura float(20),
Kg_musculo float(20),
Circunferencia_cadera float(20),
Porcentaje_graso float(20),
primary key(Id_antropometria, Id_paciente)
)


create table Asignar(
Id_plan char(4) not null foreign key references Plan_alimenticio(Id_plan),
Id_paciente char(4) not null foreign key references Pacientes(Id_paciente),
Fecha_asignacion date
primary key(Id_plan, Id_paciente)
)


create table Consulta(
Id_cita char(4) not null foreign key references Citas(Id_cita),
Id_paciente char(4) not null foreign key references Pacientes(Id_paciente),
Id_nutriologo char(4) not null foreign key references Nutriologos(Id_nutriologo),
Id_consulta char(4) not null,
Fecha_consulta date,
primary key(Id_cita,Id_paciente,Id_nutriologo,Id_consulta)
)
alter table Antropometria alter column Id_paciente char(4) not null foreign key references Pacientes(Id_paciente)
alter table Asignar alter column Id_plan char(4) not null foreign key references Plan_alimenticio(Id_plan)
alter table Citas alter column Id_ci
alter table Antropometria add primary key(Id_antropometria,Id_paciente)
alter table Pacientes alter Column Tel_paciente varchar(20)
alter table Citas alter Column Hora_cita Varchar(12)
alter table Citas alter Column Dia_cita Varchar(12)
alter table Citas alter Column Mes_cita Varchar(12)
alter table Citas alter Column Anio_cita Varchar(12)

/*
--insert into Consulta values('0000','0000','MC78','0000','2021-06-05')

--select * from Pacientes Where Id_paciente = '0001'

--insert into Asignar values('0000','0000','2021-06-01')

--insert into Antropometria values('0000', '0000','82','90','65','112','17')

--insert into Pacientes values('0001', 'Oscar Ronaldo Vega Rodriguez', 'Donato Guerra #360, Cd. Guzmán, Jal. México','3411066471','Estudiante y mesero', 'Aumentar músculo', 'M', '22')
*/
--insert into Plan_alimenticio values('0000','2000','200','132','75')
--select * from Nutriologos
--insert into Nutriologos values('MC78','Magdalena Contreras Águilar', '12345678')
--insert into Citas values('0000','SI','01','06','2021','7:00','Personales')
/*


select * from Consulta
select * from Asignar
select * from Antropometria
select * from Plan_alimenticio
select * from Nutriologos
select * from Citas
select * from Pacientes
