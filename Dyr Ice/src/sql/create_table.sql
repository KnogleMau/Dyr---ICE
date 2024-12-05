DROP TABLE IF EXISTS Dog;

CREATE TABLE Dog
(
    name varchar(20) not null,
    lifespan INTEGER default 0,
    allergies Boolean default false,
    price INTEGER default 0
);
