SELECT * FROM customers
         WHERE age =
               (SELECT MIN(age) FROM customers);

SELECT *
FROM customers
WHERE id NOT IN (SELECT customer_id FROM orders);
