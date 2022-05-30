CREATE TABLE devices (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    price FLOAT
    );
    
CREATE TABLE people (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
    );

CREATE TABLE devices_people (
    id SERIAL PRIMARY KEY,
    device_id INT REFERENCES devices (id),
    people_id INT REFERENCES people (id)
    );
    
INSERT INTO devices (name, price) 
VALUES ('телефон', 3200), ('клавиатура', 5580), ('комп мышь', 4500), ('наушники', 6700), ('монитор', 2900);

INSERT INTO people (name) 
VALUES ('Петров Д. С'), ('Сидоров А. Ш'), ('Прокопенко, Д. С.'), ('Гришин Е. Д'), ('Костенко А. Р');

INSERT INTO devices_people (device_id, people_id) 
VALUES (1, 1), (2, 2), (3, 2), (4, 2), (4, 3), (4, 4), (2, 5), (3, 5);

SELECT AVG(price) FROM devices;

SELECT p.name, AVG(dev.price)
FROM people AS p INNER JOIN devices_people AS dp
ON p.id = dp.people_id
INNER JOIN devices AS dev 
ON dp.device_id = dev.id

GROUP BY p.name
HAVING AVG(dev.price) > 5000;