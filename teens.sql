CREATE TABLE gender (
    id SERIAL PRIMARY KEY,
    gender VARCHAR(50)
    );
    
    CREATE TABLE teens (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    gender_id INT REFERENCES gender(id)
    );
    
INSERT INTO gender (gender) 
VALUES ('male'), ('female');

INSERT INTO teens (name, gender_id) 
VALUES ('мальчик 1', 1), ('девочка 1', 2), ('мальчик 2', 1), ('мальчик 3', 1), 
('мальчик 4', 1), ('девочка 2', 2), ('девочка 3', 2);

SELECT * FROM teens CROSS JOIN gender;