-- this script should run on adeste
-- pre requisite: setup.sql
--
-- psql -U adeste
-- > \i migration.sql

drop table if exists courses;

create table courses(
	course_id serial primary key,
	name varchar(40) not null,
	first date not null,
	last date not null
);

start transaction;

insert into courses (name, first, last) values ('Java Web Accenture Overnet 401', '2021-01-25', '2021-03-05');
insert into courses (name, first, last) values ('C TMS 5457 Accenture', '2010-11-15', '2010-11-26');

commit;
