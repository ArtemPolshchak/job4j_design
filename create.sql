CREATE TABLE role (
id serial primary key,
role_type character varying(20),
role_description character varying(160)
);

CREATE TABLE rule (
id serial primary key,
rule_type character varying(20),
rule_description character varying(160)
);

CREATE TABLE category (
id serial primary key,
category_name character varying(20)
);

CREATE TABLE state (
id serial primary key,
status_name character varying(20)
);

CREATE TABLE role_rule (
role_id  int REFERENCES role(id),
rule_id  int REFERENCES rule(id)
);

CREATE TABLE users (
id serial primary key,
login character varying(20),
password character varying(15),
role_id int REFERENCES role(id)
);

CREATE TABLE item (
id serial primary key,
item_name character varying(100),
item_date timestamp not null default now(),
users_id int REFERENCES users(id),
category_id int REFERENCES category(id),
state_id int REFERENCES state(id)
);


CREATE TABLE comment (
id serial primary key,
item_id int REFERENCES item(id),
comment_text character varying(6000),
comment_date timestamp not null default now()
);

CREATE TABLE attach (
id serial primary key,
item_id int REFERENCES item(id),
attach_file bytea
);