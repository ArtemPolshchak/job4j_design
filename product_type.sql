CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    expiried_date DATE,
    price DECIMAL(8, 2),
    type_id INT REFERENCES type(id)
    );

CREATE TABLE type (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50)
    );
    
INSERT INTO product (name, expiried_date, price, type_id) 
VALUES ('Сыр Hochland Proffesoinal', '2022-05-05', 4, 4),
('Торт наполеон', '2022-05-31', 10, 12),
('Пряник Молодежный', '2022-06-20', 3, 12),
('Сок ФОРЕВЕР СВОБОДА', '2022-08-15', 3, 14),
('Молоко Ферма', '2022-06-05', 4, 4),
('Селедка', '2022-05-31', 6, 2),
('Куриный Окорок', '2022-06-05', 3, 1),
('яйца', '2022-06-10', 2, 3),
('Олия', '2022-12-01', 7, 13),
('Макароны', '2022-12-25', 4, 7);

INSERT INTO type (name) 
VALUES ('мясо и мясопродукты'),
('рыба и рыбопродукты'), 
('яйца'),
('молочные и сырные продукты'),
('хлеб и хлебобулочные изделия'),
('крупы'),('макаронные изделия'),
('бобовые'),('овощи'),
('фрукты и ягоды'),
('орехи и грибы'),
('кондитерские изделия'),
('пищевые жиры'),
('напитки');

SELECT * FROM product;
SELECT * FROM type;
  
SELECT p.name, p.expiried_date, p.price, t.name FROM product p INNER JOIN type t
ON p.type_id = t.id
WHERE t.name LIKE '%сыр%';

SELECT p.name, p.expiried_date, p.price, t.name FROM product p INNER JOIN type t
ON p.type_id = t.id
WHERE p.name LIKE '%Мороженое%';

SELECT p.name, p.expiried_date, p.price, t.name FROM product p INNER JOIN type t
ON p.type_id = t.id
WHERE p.expiried_date < '2022-06-01';

SELECT name, MAX(price) AS max_price
FROM product
GROUP BY name
ORDER BY max_price DESC
LIMIT 1;

SELECT t.name, COUNT(t.name) as Количество FROM product p INNER JOIN type t
ON p.type_id = t.id
GROUP BY t.name;

SELECT p.name, p.expiried_date, p.price, t.name FROM product p INNER JOIN type t
ON p.type_id = t.id
WHERE t.name LIKE '%сыр%' OR t.name LIKE '%молоко%';

SELECT t.name, COUNT(t.name) as Количество FROM product p INNER JOIN type t
ON p.type_id = t.id
GROUP BY t.name
HAVING COUNT(t.name) > 1;

SELECT p.name, t.name FROM product p INNER JOIN type t
     ON p.type_id = t.id
     ORDER BY t.name;