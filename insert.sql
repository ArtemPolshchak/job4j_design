INSERT INTO role (id, role_type) values ('1', 'admin');
INSERT INTO role (id, role_type) values ('2', 'user');

INSERT INTO rule (id, rule_type) values ('1', 'admin_rules');
INSERT INTO rule (id, rule_type) values ('2', 'user_rules');

INSERT INTO role_rule (role_id, rule_id) values ('1', '1');
INSERT INTO role_rule (role_id, rule_id) values ('2', '2');

INSERT INTO state (id, status_name) values ('1', 'accepted');
INSERT INTO state (id, status_name) values ('2', 'awaiting');
INSERT INTO state (id, status_name) values ('3', 'complited');

INSERT INTO category (id, category_name) values ('1', 'bugs1');
INSERT INTO category (id, category_name) values ('2', 'bugs2');
INSERT INTO category (id, category_name) values ('3', 'bugs3');

INSERT INTO category (id, category_name) values ('4', 'offers');
INSERT INTO category (id, category_name) values ('5', 'info');


INSERT INTO users (id, login, password, role_id) values ('1', 'Nick_Frolov', 'qwerty1', '1');
INSERT INTO users (id, login, password, role_id) values ('2', 'Dan_Balan', 'qwerty2', '2');

INSERT INTO item (id, item_name, users_id, category_id, state_id) values ('1','bug#1', '1', '1', '2');
INSERT INTO item (id, item_name, users_id, category_id, state_id) values ('2','bug#2', '2', '5', '3');
INSERT INTO item (id, item_name, users_id, category_id, state_id) values ('3', 'bug#3', '2', '1', '1');

INSERT INTO comment (id, item_id, comment_text) values ('1', '1', 'comment#1');