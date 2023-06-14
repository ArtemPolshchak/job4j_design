create table orders (
    id serial primary key,
    active boolean default true,
    book_id integer references books(id),
    student_id integer references students(id)
);

insert into orders (book_id, student_id) values (1, 1);
insert into orders (book_id, student_id) values (3, 1);
insert into orders (book_id, student_id) values (5, 2);
insert into orders (book_id, student_id) values (4, 1);
insert into orders (book_id, student_id) values (2, 2);
insert into orders (book_id, student_id) values (15, 2);
insert into orders (book_id, student_id) values (9, 7);
insert into orders (book_id, student_id) values (12, 3);
insert into orders (book_id, student_id) values (4, 6);
insert into orders (book_id, student_id) values (8, 8);
insert into orders (book_id, student_id) values (14, 3);
insert into orders (book_id, student_id) values (7, 5);
insert into orders (book_id, student_id) values (6, 4);
insert into orders (book_id, student_id) values (10, 7);
insert into orders (book_id, student_id) values (5, 6);
insert into orders (book_id, student_id) values (8, 9);
insert into orders (book_id, student_id) values (13, 8);
insert into orders (book_id, student_id) values (11, 10);