CREATE TABLE orders
(
    id          serial primary key,
    amount      int,
    customer_id int references customers (id)
);