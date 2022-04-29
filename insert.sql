INSERT INTO role (role_type) values ('admin');
INSERT INTO role (role_type) values ('user');

INSERT INTO state (status_name) values ('accepted');
INSERT INTO state (status_name) values ('awaiting');

INSERT INTO item (id, item_name) values ('1','bug#1');
INSERT INTO item (id, item_name) values ('2', 'bug#2');
INSERT INTO item (id, item_name) values ('3', 'bug#3');

INSERT INTO comment (item_id, comment_text) values ('1', 'comment#1');

INSERT INTO users (login, password, role_type) values ('Nick_Frolov', 'qwerty1', 'admin');
INSERT INTO users (login, password, role_type) values ('Dan_Balan', 'qwerty2', 'user');

INSERT INTO rule (rule_type) values ('admin_rules');
INSERT INTO rule (rule_type) values ('user_rules');

INSERT INTO role_rule (role_type, rule_type) values ('user', 'user_rules');
INSERT INTO role_rule (role_type, rule_type) values ('admin', 'admin_rules');

INSERT INTO category (category_name) values ('bugs1');
INSERT INTO category (category_name) values ('bugs2');
INSERT INTO category (category_name) values ('bugs3');

INSERT INTO category (category_name) values ('offers');
INSERT INTO category (category_name) values ('info');

INSERT INTO state (status_name) values ('accepted');
INSERT INTO state (status_name) values ('awaiting');