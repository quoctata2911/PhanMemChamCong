create database PMChamCong
go
use PMChamCong
go
create table calamviec (
	idca int primary key identity(1,1),
	tenca nvarchar(20),
)
create table giolamviec(
	idgio int primary key identity(1,1),
	tengio nvarchar(30),
	thoigianbatdau time,
	thoigianketthuc time
)
create table Worker(
	id int primary key identity(1,1),
	macongnhan nvarchar(255) ,
	tencongnhan nvarchar(255),
	donvi nvarchar(255),
	ngaylam date,
	checkin time,
	checkout time,
	thoigianlam time,
	idca int,
	FOREIGN KEY (idca) REFERENCES calamviec(idca),
	password nvarchar(255)
)
create table Officer(
	id int primary key identity(1,1),
	manhanvien nvarchar(255),
	tennhanvien nvarchar(255),
	donvi nvarchar(255),
	ngaylamviec date,
	checkin time, 
	checkout time,
	dimuon time, 
	vesom time,
	idgio int,
	FOREIGN KEY (idgio) REFERENCES giolamviec(idgio),
	status int,
	password nvarchar(255)
)
create table quanly(
	id int primary key identity(1,1),
	username nvarchar(255) not null,
	password nvarchar(255) not null
)
-- Insert into calamviec table
INSERT INTO calamviec (tenca) VALUES ('Ca 1'), ('Ca 2'), ('Ca 3');

-- Insert into giolamviec table
INSERT INTO giolamviec (tengio, thoigianbatdau, thoigianketthuc) 
VALUES ('Sáng', '08:00:00', '12:00:00'),
       ('Chiều', '13:00:00', '17:00:00');
     

-- Insert into Worker table
INSERT INTO Worker (macongnhan, tencongnhan, donvi, ngaylam, checkin, checkout, thoigianlam, idca, password) 
VALUES ('CN001', 'Nguyen Van A', 'Phòng A', '2023-01-01', '08:30:00', '17:00:00', '08:30:00', 1, 'password1'),
       ('CN002', 'Nguyen Thi B', 'Phòng B', '2023-01-02', '09:00:00', '18:00:00', '09:00:00', 2, 'password2'),
       ('CN003', 'Tran Van C', 'Phòng C', '2023-01-03', '08:00:00', '16:30:00', '08:30:00', 3, 'password3');

-- Insert into Officer table
INSERT INTO Officer (manhanvien, tennhanvien, donvi, ngaylamviec, checkin, checkout, dimuon, vesom, idgio, status, password) 
VALUES ('NV001', 'Le Van X', 'Phòng A', '2023-01-01', '08:00:00', '17:00:00', '00:15:00', '00:10:00', 1, 1, 'password4'),
       ('NV002', 'Tran Thi Y', 'Phòng B', '2023-01-02', '09:30:00', '18:30:00', '00:30:00', '00:20:00', 2, 0, 'password5');
INSERT INTO quanly(username, password)
VALUES ('a', '1')