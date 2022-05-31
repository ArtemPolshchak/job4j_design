CREATE TABLE supply (
    id SERIAL PRIMARY KEY,
    price DECIMAL(8, 2),
    amount INT
    );

CREATE TABLE book (
    id SERIAL PRIMARY KEY,
    title VARCHAR(50),
    author VARCHAR(50),
    price_id INT REFERENCES supply(id)
    );
    

INSERT INTO supply (price, amount) VALUES (518.99, 2);
INSERT INTO supply (price, amount) VALUES (570.20, 6);
INSERT INTO supply (price, amount) VALUES (540.50, 7);
INSERT INTO supply (price, amount) VALUES (360.80, 3);

INSERT INTO book (title, author, price_id) VALUES ('Мастер и Маргарита', 'Булгаков М.А.', 1);
INSERT INTO book (title, author, price_id) VALUES ('Белая гвардия', 'Булгаков М.А.', 2);
INSERT INTO book (title, author, price_id) VALUES ('Идиот', 'Достоевский Ф.М.', 3);
INSERT INTO book (title, author, price_id) VALUES ('Братья Карамазовы', 'Достоевский Ф.М.', 4);
INSERT INTO book (title, author) VALUES ('Стихотворения и поэмы', 'Есенин С.А.');

     SELECT * FROM book b INNER JOIN supply s
     ON b.price_id = s.id;
     
     SELECT b.title, b.author, s.amount
     FROM book b INNER JOIN supply s
     ON b.price_id = s.id;
     
     SELECT b.title, s.price
     FROM book b INNER JOIN supply s
     ON b.price_id = s.id;