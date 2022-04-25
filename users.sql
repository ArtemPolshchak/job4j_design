create table users(
id serial primary key,
name varchar(255),
age integer,
address text
);
insert into users(name, age, address) values('Artem', '30', 'Poland');
select * from users;
update users set name = 'Nick';
select * from users;
delete from users;
select * from users;