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
    id integer primary key,
    username varchar(25) not null,
    description TEXT not null,
    salaryHour INTEGER default 0,
    location varchar(50) not null,
    takerName varchar(25)

);