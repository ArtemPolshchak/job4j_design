create table books (
    id serial primary key,
    name varchar(200),
    author_id integer references authors(id)
);

insert into books (name, author_id) values ('Евгений Онегин', 1);
insert into books (name, author_id) values ('Капитанская дочка', 1);
insert into books (name, author_id) values ('Дубровский', 1);
insert into books (name, author_id) values ('Мертвые души', 2);
insert into books (name, author_id) values ('Вий', 2);
insert into books (name, author_id) values ('Преступление и наказание', 3);
insert into books (name, author_id) values ('Бесы', 3);
insert into books (name, author_id) values ('Белые ночи', 3);
insert into books (name, author_id) values ('Война и мир', 4);
insert into books (name, author_id) values ('Анна Каренина', 4);
insert into books (name, author_id) values ('Хамелеон', 5);
insert into books (name, author_id) values ('Пари', 5);
insert into books (name, author_id) values ('Отцы и дети', 6);
insert into books (name, author_id) values ('Муму', 6);
insert into books (name, author_id) values ('Записки охотника', 6);