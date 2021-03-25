-- this script should run on adeste
-- pre requisite: setup.sql
--
-- psql -U adeste
-- > \i migration.sql

drop table if exists trainees;
drop table if exists courses;
drop table if exists users;
drop table if exists u_roles;

-- 
create table u_roles(
	role_id serial primary key,
	name varchar(10) unique not null
);

start transaction;

insert into u_roles (name) values ('admin');
insert into u_roles (name) values ('plain');

commit;

-- FK on LEVELS
create table users(
	user_id serial primary key,
	name varchar(20) unique not null,
	password varchar(20) not null,
	role_id integer not null,
	expire date,

	constraint users_role_fk foreign key(role_id) references u_roles(role_id)
);

start transaction;

insert into users (name, password, role_id) values ('admin', 'password', 1);

commit;

--
create table courses(
	course_id serial primary key,
	name varchar(40) not null,
	first date not null,
	last date not null
);

start transaction;

insert into courses (name, first, last) values ('Java Web Accenture Overnet 401', '2021-01-25', '2021-03-05');
insert into courses (name, first, last) values ('Java Web Accenture Overnet 376', '2020-11-11', '2020-12-22');
insert into courses (name, first, last) values ('C TMS 5457 Accenture', '2010-11-15', '2010-11-26');

commit;

-- FK on COURSES
create table trainees(
	trainee_id serial primary key,
	name varchar(15) not null,
	course_id integer not null,

	constraint trainees_course_fk foreign key(course_id) references courses(course_id)
);

start transaction;

insert into trainees (name, course_id) values ('Alberto', 1);
insert into trainees (name, course_id) values ('Andrea', 1);
insert into trainees (name, course_id) values ('Daniele', 1);
insert into trainees (name, course_id) values ('Dylan', 1);
insert into trainees (name, course_id) values ('Emanuele', 1);
insert into trainees (name, course_id) values ('Marco', 1);
insert into trainees (name, course_id) values ('Marika', 1);
insert into trainees (name, course_id) values ('Morgana', 1);
insert into trainees (name, course_id) values ('Riccardo', 1);
insert into trainees (name, course_id) values ('Rosanna', 1);
insert into trainees (name, course_id) values ('Simona', 1);
insert into trainees (name, course_id) values ('Tommaso', 1);

insert into trainees (name, course_id) values ('Alberto', 2);
insert into trainees (name, course_id) values ('Davide', 2);
insert into trainees (name, course_id) values ('Elisa', 2);
insert into trainees (name, course_id) values ('Ilaria', 2);
insert into trainees (name, course_id) values ('Laerte', 2);
insert into trainees (name, course_id) values ('Luca', 2);
insert into trainees (name, course_id) values ('Luigi', 2);
insert into trainees (name, course_id) values ('Manuel', 2);
insert into trainees (name, course_id) values ('Michele C', 2);
insert into trainees (name, course_id) values ('Michele R', 2);
insert into trainees (name, course_id) values ('Raffaele', 2);
insert into trainees (name, course_id) values ('Roberta', 2);
insert into trainees (name, course_id) values ('Vittorio', 2);
insert into trainees (name, course_id) values ('Yuri', 2);

commit;
