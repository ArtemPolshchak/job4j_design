CREATE TABLE departments (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50)
    );

CREATE TABLE employees (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    departments_id INT REFERENCES departments(id)
    );
    
INSERT INTO departments (name) 
VALUES ('surgery'), ('gynaecology'), ('obstetrics'), ('paediatrics'), ('eye'), ('ENT'),
('dental'), ('orthopaedics'), ('neurology'), ('cardiology'), ('psychiatry'), ('skin'), ('plastic surgery'), ('nuclear medicine'), ('infectious disease');

INSERT INTO employees (name, departments_id) 
VALUES ('Стройников И.С.', 1), ('Борисенко Д.С.', 1), ('Странова М.Н.', 3), ('Любенко Д.С.', 5), 
('Костенко Н.А.', 7), ('Кучеренко С.Л', 9), ('Валентинова И.Д', 11);

SELECT * FROM departments;
SELECT * FROM employees;

SELECT e.name, d.name FROM employees e LEFT JOIN departments d
ON e.departments_id = d.id;

SELECT e.name, d.name FROM departments d RIGHT JOIN employee e
ON d.id = e.departments_id;

SELECT e.name, d.name FROM employees e RIGHT JOIN departments d
ON e.departments_id = d.id
WHERE e.name IS NOT NULL;
 
SELECT e.name, d.name FROM employees e RIGHT JOIN departments d
ON e.departments_id = d.id;

SELECT e.name, d.name FROM employees e CROSS JOIN departments d;

SELECT * FROM employees CROSS JOIN departments;

SELECT e.name, d.name FROM employees e LEFT JOIN departments d
ON e.departments_id = d.id
WHERE d.name IS NULL;

SELECT d.name, e.name FROM departments d LEFT JOIN employees e
ON e.departments_id = d.id
WHERE e.name IS NULL;