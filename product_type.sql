CREATE TABLE type (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50)
    );

CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    expiried_date DATE,
    price DECIMAL(8, 2),
    type_id INT REFERENCES type(id)
    );

INSERT INTO type (name) VALUES ('мясо и мясопродукты');
INSERT INTO type (name) VALUES ('рыба и рыбопродукты');
INSERT INTO type (name) VALUES ('яйца');
INSERT INTO type (name) VALUES ('молочные и сырные продукты');
INSERT INTO type (name) VALUES ('хлеб и хлебобулочные изделия');
INSERT INTO type (name) VALUES ('крупы');
INSERT INTO type (name) VALUES ('макаронные изделия');
INSERT INTO type (name) VALUES ('бобовые');
INSERT INTO type (name) VALUES ('овощи');
INSERT INTO type (name) VALUES ('фрукты и ягоды');
INSERT INTO type (name) VALUES ('орехи и грибы');
INSERT INTO type (name) VALUES ('кондитерские изделия');
INSERT INTO type (name) VALUES ('пищевые жиры');
INSERT INTO type (name) VALUES ('напитки');
 
INSERT INTO product (name, expiried_date, price, type_id) VALUES ('Сыр Hochland Proffesoinal', '2022-05-05', 4, 4);
INSERT INTO product (name, expiried_date, price, type_id) VALUES ('Торт наполеон', '2022-05-31', 10, 12);
INSERT INTO product (name, expiried_date, price, type_id) VALUES ('Пряник Молодежный', '2022-06-20', 3, 12);
INSERT INTO product (name, expiried_date, price, type_id) VALUES ('Сок ФОРЕВЕР СВОБОДА', '2022-08-15', 3, 14);
INSERT INTO product (name, expiried_date, price, type_id) VALUES ('Молоко Ферма', '2022-06-05', 4, 4);
INSERT INTO product (name, expiried_date, price, type_id) VALUES ('Селедка', '2022-05-31', 6, 2);
INSERT INTO product (name, expiried_date, price, type_id) VALUES ('Куриный Окорок', '2022-06-05', 3, 1);
INSERT INTO product (name, expiried_date, price, type_id) VALUES ('яйца', '2022-06-10', 2, 3);
INSERT INTO product (name, expiried_date, price, type_id) VALUES ('Олия', '2022-12-01', 7, 13);
INSERT INTO product (name, expiried_date, price, type_id) VALUES ('Макароны', '2022-12-25', 4, 7);

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
WHERE p.expiried_date < CURRENT_DATE;

SELECT name, (SELECT MAX(price)) AS max_price
FROM product
WHERE price >= ALL(SELECT MAX(price) FROM product)
GROUP BY name;

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