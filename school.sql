 create table students(
     id serial primary key,
     First_name varchar(255),
	Last_name varchar(255)
 );
 
 create table classes(
     id serial primary key,
     Title varchar(255),
	description varchar(255)
 );
 
 create table enrollments(
     id serial primary key,
     student_id int references students(id),
     classes_id int references classes(id)
 );



insert into students(First_name, Last_name) values ('Ivan', 'Wownik');
insert into students(First_name, Last_name) values ('Kirill', 'Strugatsky');
insert into students(First_name, Last_name) values ('Roman', 'Fedorov');

insert into classes(Title, description) values ('mathematics', 'Monday 12:00');
insert into classes(Title, description) values ('history', 'Tuesday, Thursday 11:00');
insert into classes(Title, description) values ('chemistry', 'Tuesday, Wednesday, Friday 15:00');

insert into enrollments(student_id, classes_id) values (1, 2);
insert into enrollments(student_id, classes_id) values (2, 1);
insert into enrollments(student_id, classes_id) values (3, 3);
