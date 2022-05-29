CREATE DATABASE fauna_animals;

CREATE TABLE fauna (
    id SERIAL PRIMARY KEY,
    name TEXT,
    avg_age INT,
    discovery_date DATE
    );

INSERT INTO fauna (name, avg_age)
    VALUES ('Медведь', 10800);
INSERT INTO fauna (name, avg_age, discovery_date)
    VALUES ('Волк', 5400, DATE '1836-04-01');
INSERT INTO fauna (name, avg_age, discovery_date)
    VALUES ('Лисица', 2500, DATE '1950-09-01');
INSERT INTO fauna (name, avg_age, discovery_date)
    VALUES ('Заяц', 2200, DATE '1900-06-01');
INSERT INTO fauna (name, avg_age, discovery_date)
    VALUES ('Олень', 3600, DATE '1961-02-01');
INSERT INTO fauna (name, avg_age, discovery_date)
    VALUES ('Лось', 3300, DATE '1949-08-01');
INSERT INTO fauna (name, avg_age)
    VALUES ('Бобер', 3600);
INSERT INTO fauna (name, avg_age, discovery_date)
    VALUES ('Белка', 2200, DATE '1811-04-01');

SELECT * 
FROM fauna
WHERE name LIKE '%сиц%';

SELECT * 
FROM fauna
WHERE avg_age BETWEEN 10000 AND 21000;

SELECT * 
FROM fauna
WHERE discovery_date IS NULL;

SELECT * 
FROM fauna
WHERE discovery_date < '1950-01-01';