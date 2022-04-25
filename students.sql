 create table student(
     id serial primary key,
     First_name varchar(255),
     Last_name varchar(255)
 );
 
 create table contact_info(
     id serial primary key,
     City varchar(255),
     Phone int,
     Stident_ID int references student(id) unique
 );

insert into student(First_name, Last_name) values ('Ivan', 'Petronov');
insert into student(First_name, Last_name) values ('Kirill', 'Korchenko');

insert into contact_info(Stident_ID, City, Phone) values (1, 'Poland', '212321');
insert into contact_info(Stident_ID, City, Phone) values (2, 'Latvia', '231424');