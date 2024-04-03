CREATE TABLE users (
                       user_id SERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL,
                       email VARCHAR(100) NOT NULL,
                       age INT,
                       city VARCHAR(50)
);



CREATE TABLE categories (
                            category_id SERIAL PRIMARY KEY,
                            category_name VARCHAR(50) NOT NULL
);



CREATE TABLE manufacturers (
                               manufacturer_id SERIAL PRIMARY KEY,
                               manufacturer_name VARCHAR(50) NOT NULL
);


CREATE TABLE products (
                          product_id SERIAL PRIMARY KEY,
                          product_name VARCHAR(100) NOT NULL,
                          price DECIMAL(10, 2) NOT NULL,
                          category_id INT,
                          manufacturer_id INT,
                          FOREIGN KEY (category_id) REFERENCES categories(category_id),
                          FOREIGN KEY (manufacturer_id) REFERENCES manufacturers(manufacturer_id)
);


CREATE TABLE orders (
                        order_id SERIAL PRIMARY KEY,
                        user_id INT NOT NULL,
                        order_date DATE NOT NULL,
                        total_amount DECIMAL(10, 2) NOT NULL,
                        FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE order_details (
                               detail_id SERIAL PRIMARY KEY,
                               order_id INT NOT NULL,
                               product_id INT NOT NULL,
                               quantity INT NOT NULL,
                               total_price DECIMAL(10, 2) NOT NULL,
                               FOREIGN KEY (order_id) REFERENCES orders(order_id),
                               FOREIGN KEY (product_id) REFERENCES products(product_id)
);


CREATE VIEW user_order_info AS
SELECT u.user_id, u.username, u.email, u.age, u.city,
       o.order_id, o.order_date, o.total_amount,
       od.product_id, p.product_name, p.price,
       c.category_id, c.category_name,
       m.manufacturer_id, m.manufacturer_name
FROM users u
         JOIN orders o ON u.user_id = o.user_id
         JOIN order_details od ON o.order_id = od.order_id
         JOIN products p ON od.product_id = p.product_id
         JOIN categories c ON p.category_id = c.category_id
         JOIN manufacturers m ON p.manufacturer_id = m.manufacturer_id;
