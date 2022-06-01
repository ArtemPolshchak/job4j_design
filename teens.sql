CREATE TABLE gender_teens (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    gender VARCHAR(50)
    );
   
INSERT INTO gender_teens (name, gender) 
VALUES ('мальчик 1', 'male'), ('девочка 1', 'female'), ('мальчик 2', 'male'), ('мальчик 3', 'male'), 
('мальчик 4', 'male'), ('девочка 2', 'female'), ('девочка 3', 'female');

SELECT gt.name, gt.gender, g.name, g.gender FROM gender_teens gt CROSS JOIN gender_teens g;