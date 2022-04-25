create table customer(
    id serial primary key,
    name varchar(255)
);

create table orders(
    id serial primary key,
    order_customer varchar(255),
    customer_id int references customer(id)
);

insert into customer(name) values ('Bob');
insert into orders(order_customer, customer_id) VALUES ('Pizza', 1);
insert into orders(order_customer, customer_id) VALUES ('Cola', 1);