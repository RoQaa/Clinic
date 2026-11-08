create table Doctors(
id int primary key identity(1,1),
full_name nvarchar(150) not null,
email nvarchar(150) not null unique,
phone nvarchar(20) not null unique,
birth_date date,
gender char(1) not null,
address nvarchar(250),
hire_date date default getdate() not null,
salary DECIMAL(10,2) not null,
is_active BIT not null default 1,
created_at DateTime2 default SYSUTCDATETIME(),
updated_at DateTime2 default SYSUTCDATETIME(),
specialty_id int not null,
constraint check_gender check(gender in ('F','M')),
constraint check_activity check(is_active in (1,0)),
constraint FK_Doctor_Specialties foreign key (specialty_id)
references Specialties(id)
)
alter table  Doctors add  CONSTRAINT CK_Doctors_Salary
        CHECK (salary >= 0)

alter table Doctors add  license_number NVARCHAR(50)
not null unique


create table Specialties
(
id int unique not null identity(1,1),
name nvarchar(150) not null unique
)


EXEC sp_help 'Doctors';

EXEC sp_help 'Specialties';


INSERT INTO dbo.Specialties (name)
VALUES
('Cardiology'),
('Dermatology'),
('Pediatrics'),
('Neurology'),
('Orthopedics'),
('Ophthalmology'),
('Dentistry'),
('General Surgery');

INSERT INTO dbo.Doctors
(
    full_name,
    email,
    phone,
    license_number,
    birth_date,
    gender,
    address,
    hire_date,
    salary,
    is_active,
    specialty_id
)
VALUES
-- Cardiology (1)
('Ahmed Mohamed', 'ahmed.mohamed@clinic.com', '01010000001', 'LIC1001', '1985-04-12', 'M', 'Cairo', '2018-01-15', 18000, 1, 1),
('Mohamed Ali', 'mohamed.ali@clinic.com', '01010000002', 'LIC1002', '1979-09-23', 'M', 'Giza', '2015-06-10', 25000, 1, 1),
('Sara Hassan', 'sara.hassan@clinic.com', '01010000003', 'LIC1003', '1990-02-18', 'F', 'Nasr City', '2022-03-01', 14000, 0, 1),

-- Dermatology (2)
('Mona Ibrahim', 'mona.ibrahim@clinic.com', '01010000004', 'LIC1004', '1988-07-30', 'F', 'Dokki', '2019-11-20', 16000, 1, 2),
('Ahmed Samir', 'ahmed.samir@clinic.com', '01010000005', 'LIC1005', '1982-12-05', 'M', 'Maadi', '2016-04-12', 22000, 1, 2),
('Nour Adel', 'nour.adel@clinic.com', '01010000006', 'LIC1006', '1995-05-14', 'F', 'Giza', '2023-08-01', 11000, 1, 2),

-- Pediatrics (3)
('Hany Mostafa', 'hany.mostafa@clinic.com', '01010000007', 'LIC1007', '1978-03-19', 'M', 'Cairo', '2012-09-01', 28000, 1, 3),
('Mai Khaled', 'mai.khaled@clinic.com', '01010000008', 'LIC1008', '1992-08-22', 'F', 'Heliopolis', '2021-02-15', 13000, 1, 3),
('Omar Tarek', 'omar.tarek@clinic.com', '01010000009', 'LIC1009', '1987-11-11', 'M', 'Giza', '2017-07-10', 19000, 0, 3),

-- Neurology (4)
('Khaled Nabil', 'khaled.nabil@clinic.com', '01010000010', 'LIC1010', '1980-01-25', 'M', 'Nasr City', '2014-05-20', 30000, 1, 4),
('Dina Ashraf', 'dina.ashraf@clinic.com', '01010000011', 'LIC1011', '1991-06-17', 'F', 'Dokki', '2020-10-01', 17000, 1, 4),

-- Orthopedics (5)
('Youssef Adel', 'youssef.adel@clinic.com', '01010000012', 'LIC1012', '1983-10-08', 'M', 'Cairo', '2016-01-05', 24000, 1, 5),
('Amr Fathy', 'amr.fathy@clinic.com', '01010000013', 'LIC1013', '1976-04-29', 'M', 'Giza', '2010-03-15', 32000, 1, 5),
('Salma Wael', 'salma.wael@clinic.com', '01010000014', 'LIC1014', '1994-09-12', 'F', 'Maadi', '2023-01-10', 12000, 0, 5),

-- Ophthalmology (6)
('Rania Mahmoud', 'rania.mahmoud@clinic.com', '01010000015', 'LIC1015', '1986-02-14', 'F', 'Heliopolis', '2018-07-01', 20000, 1, 6),
('Mostafa Sameh', 'mostafa.sameh@clinic.com', '01010000016', 'LIC1016', '1989-12-20', 'M', 'Cairo', '2020-06-15', 15000, 1, 6),

-- Dentistry (7)
('Ahmed Fawzy', 'ahmed.fawzy@clinic.com', '01010000017', 'LIC1017', '1984-05-09', 'M', 'Dokki', '2015-02-01', 21000, 1, 7),
('Laila Hossam', 'laila.hossam@clinic.com', '01010000018', 'LIC1018', '1993-03-27', 'F', 'Giza', '2022-09-12', 12500, 1, 7),

-- General Surgery (8)
('Tamer Hassan', 'tamer.hassan@clinic.com', '01010000019', 'LIC1019', '1977-08-16', 'M', 'Cairo', '2009-11-01', 35000, 1, 8),
('Farida Emad', 'farida.emad@clinic.com', '01010000020', 'LIC1020', '1996-01-30', 'F', 'Nasr City', '2024-02-01', 10000, 0, 8);

select * from Doctors

create table Patients(
    id int primary key identity(1,1),
    full_name nvarchar(150) not null,
    email nvarchar(150) unique  null,
    phone nvarchar(20) not null unique,
    birth_date DATE not null,

    gender char(1) not null,
    constraint check_gender check(gender in ('M','F')),

    address nvarchar(250),
    blood_type varchar(3),
    emergency_contact nvarchar(20),
    create_at DateTime2 default SYSUTCDATETIME() not null,
    updated_at DateTime2 default SYSUTCDATETIME()
)
alter table Patients 
add constraint check_blood_type 
check(blood_type in ('O-','O+','A-','A+','B-','B+','AB-','AB+'))


exec sp_help 'Patients'

