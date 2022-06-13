
CREATE TABLE Кузов (
    id serial PRIMARY KEY,
    name_of_detail VARCHAR(250)
);

CREATE TABLE Двигатель (
    id serial PRIMARY KEY,
    name_of_detail VARCHAR(250)
);

CREATE TABLE Коробка_передач (
    id serial PRIMARY KEY,
    name_of_detail VARCHAR(250)
);

CREATE TABLE Машина (
id serial PRIMARY KEY,
name VARCHAR(30),
кузов_id INT REFERENCES Кузов(id),
двигатель_id INT REFERENCES Двигатель(id),
коробкаПередач_id INT REFERENCES Коробка_передач(id)
);

INSERT INTO Кузов (name_of_detail) VALUES('Седан'), ('Универсал'), ('Хэтчбек'), ('Лифтбек'), ('Лимузин'),('Внедорожник'),('Кроссовер'),('Стретч'),('Купе'),('Родстер'),('Кабриолет'),('Брогам'),('Тарга'),('Пикап'),('SUV'),('Минивен'),('Микровен'),('Компактвен');

INSERT INTO Двигатель (name_of_detail) VALUES('N12M1'),('L-320'),('TRE211'),('SW22RTM2'),('1.4 K7J'),('ВАЗ‑11182'),('f18d4'),('Carrera 4S'),('ВАЗ-2104'),('BlueHDi 180');

INSERT INTO Коробка_передач (name_of_detail) VALUES('TR3'),('Default transmission'),('TransmissionSP2'),('TS9500'),('RbtTRM');

INSERT INTO Машина (name, кузов_id, двигатель_id, коробкаПередач_id) VALUES('Reno Logan', 1, 1, 1);
INSERT INTO Машина (name, кузов_id, двигатель_id, коробкаПередач_id) VALUES('Lada Granta', 2, 1, 2);
INSERT INTO Машина (name, кузов_id, двигатель_id, коробкаПередач_id) VALUES('Chevrolet Alma', 3, 6, 3);
INSERT INTO Машина (name, кузов_id, двигатель_id) VALUES('Porshe911', 1, 3);
INSERT INTO Машина (name, кузов_id, двигатель_id, коробкаПередач_id) VALUES('Lada Estate', 1, 5, 4);
INSERT INTO Машина (name, кузов_id, двигатель_id, коробкаПередач_id) VALUES('Pejo Sele', 4, 6, 4);
INSERT INTO Машина (name,  двигатель_id, коробкаПередач_id) VALUES('Lada Simple', 7, 7);

SELECT Машина.name AS Автомобиль, Кузов.name_of_detail AS Кузов, Двигатель.name_of_detail AS Двигатель, Коробка_передач.name_of_detail AS Коробка_передач
FROM Машина 
LEFT JOIN Кузов
    ON Машина.кузов_id = Кузов.id
LEFT JOIN Двигатель
    ON Машина.двигатель_id = Двигатель.id
LEFT JOIN Коробка_передач
    ON Машина.коробкаПередач_id = Коробка_передач.id;
    
SELECT Кузов.name_of_detail AS Кузов FROM Кузов 
 LEFT JOIN Машина ON Кузов.id = Машина.кузов_id
WHERE Машина.кузов_id IS NULL;

SELECT Двигатель.name_of_detail AS Двигатель FROM Двигатель 
 LEFT JOIN Машина ON Двигатель.id = Машина.двигатель_id
WHERE Машина.двигатель_id IS NULL;

SELECT Коробка_передач.name_of_detail AS Коробка_передач FROM Коробка_передач 
 LEFT JOIN Машина ON Коробка_передач.id = Машина.коробкаПередач_id
WHERE Машина.коробкаПередач_id IS NULL;