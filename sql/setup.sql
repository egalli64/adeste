-- this script should run on postgres
--
-- psql -U postgres postgres
-- # \i setup.sql


drop database if exists adeste;
drop user if exists adeste;

create user adeste with password 'd?gYay5r8Npv';
create database adeste owner=adeste;