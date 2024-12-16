DROP TABLE IF EXISTS Dog;
CREATE TABLE Dog

(
    id integer primary key,
    species varchar(50) not null,
    cost INTEGER default 0,
    lifespan INTEGER default 0,
    temper text (100),
    allergyFriendly boolean not null

);

DROP TABLE IF EXISTS Cat;
create table Cat
(
   id integer primary key,
   species varchar(50) not null ,
   origin varchar(50) not null,
   lifeSpan integer not null,
   temper text not null,
   allergyFriendly boolean not null
);

DROP TABLE IF EXISTS Job;
CREATE TABLE Job
(
    id          INTEGER primary key,
    headline    varchar(50),
    description TEXT not null,
    salaryHour  INTEGER default 0,
    location    varchar(50),
    username    varchar(25),
    takerName   varchar(25)

);


DROP TABLE IF EXISTS LogIn;
CREATE TABLE LogIn
(
    id integer default 0 primary key,
    username varchar(30) ,
    password varchar(30) not null


);

