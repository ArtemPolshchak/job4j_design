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
    
CREATE TABLE people (
    id SERIAL PRIMARY KEY,
    name VARCHAR(20),
    book_id INT REFERENCES book(id)
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

INSERT INTO people(name, book_id) VALUES ('Васильев В.Л', 1), ('Сорока А. М.', 1), ('Батрудинов Д. И.', 2), ('Костенко Н. Ф', 3), ('Мушилин С. А', 4);

     SELECT * FROM book b INNER JOIN supply s
     ON b.price_id = s.id;
     
     SELECT * FROM people p INNER JOIN book b
     ON p.book_id = b.id
     INNER JOIN supply AS s
     ON b.price_id = s.id;
