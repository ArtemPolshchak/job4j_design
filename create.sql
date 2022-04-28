CREATE TABLE users (
user_id serial primary key,
name character varying(100),
phone character varying(15)
);

CREATE TABLE item (
item_id serial primary key,
item_name character varying(100),
item_date timestamp not null default now()
);

CREATE TABLE user_item (
item_id int REFERENCES item(item_id),
user_id int REFERENCES users(user_id)
);

CREATE TABLE role (
role_type character varying(20) primary key,
user_id int REFERENCES users(user_id),
role_description character varying(160)
);

CREATE TABLE rule (
rule_type character varying(20) primary key,
rule_description character varying(160)
);

CREATE TABLE role_rule (
role_type character varying(20) REFERENCES role(role_type),
rule_type character varying(20) REFERENCES rule(rule_type)
);

CREATE TABLE category (
category_name character varying(20),
item_id int REFERENCES item(item_id)
);

CREATE TABLE status (
status_name character varying(20),
item_id int REFERENCES item(item_id)
);

CREATE TABLE comment (
comment_id serial primary key,
item_id int REFERENCES item(item_id),
comment_text character varying(6000),
comment_date timestamp not null default now()
);

CREATE TABLE attach (
attach_id serial primary key,
item_id int REFERENCES item(item_id),
attach_file bytea
);