drop table if exists departments;

create table departments (
	id integer	auto_increment primary key,
	name		varchar(255)
);

insert into departments (name) values ('Computer Science');
insert into departments (name) values ('Electrical and Computer Engineering');

drop table if exists faculties;

create table faculties (
	id integer	auto_increment primary key,
	department_name	varchar(255),
	name		varchar(255),
	isChair		bit
);

insert into faculties (department_name, name, isChair) values ('Computer Science', 'Pamula', 1);
insert into faculties (department_name, name, isChair) values ('Computer Science', 'Sun', 0);
insert into faculties (department_name, name, isChair) values ('Electrical and Computer Engineering', 'Agarwal', 0);