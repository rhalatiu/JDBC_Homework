CREATE DATABASE JDBC_Homework;

create table accomodation (
    id  SERIAL PRIMARY KEY,
    type varchar(32),
    bed_type varchar(32),
    max_guests int,
	description varchar(512)
);

create table room_fair (
	id SERIAL PRIMARY KEY,
	value double precision,
	season varchar(32)
);

create table accomodation_fair_relation (
	id  SERIAL PRIMARY KEY,
	id_accomodation int,
	id_room_fair int,
	FOREIGN KEY(id_accomodation) references accomodation(id),
	FOREIGN KEY(id_room_fair) references room_fair(id)
);