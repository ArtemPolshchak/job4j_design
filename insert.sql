INSERT INTO users (name, phone) values ('Nick Frolov', '+00099999999');
INSERT INTO users (name, phone) values ('Dan Balan', '+00009111111');

INSERT INTO item (item_name) values ('bug#1');
INSERT INTO item (item_name) values ('bug#2');
INSERT INTO item (item_name) values ('bug#3');

INSERT INTO comment (item_id, comment_text) values ('1', 'comment#1');

INSERT INTO role (role_type, user_id) values ('user', '1');
INSERT INTO role (role_type, user_id) values ('admin', '2');

INSERT INTO rule (rule_type) values ('admin_rules');
INSERT INTO rule (rule_type) values ('user_rules');

INSERT INTO role_rule (role_type, rule_type) values ('user', 'user_rules');
INSERT INTO role_rule (role_type, rule_type) values ('admin', 'admin_rules');

INSERT INTO category (category_name, item_id) values ('bugs', '1');
INSERT INTO category (category_name, item_id) values ('bugs', '2');
INSERT INTO category (category_name, item_id) values ('bugs', '3');

INSERT INTO category (category_name) values ('offers');
INSERT INTO category (category_name) values ('info');

INSERT INTO status (status_name, item_id) values ('accepted', '1');
INSERT INTO status (status_name, item_id) values ('awaiting', '2');
INSERT INTO status (status_name, item_id) values ('awaiting', '3');

INSERT INTO status (status_name) values ('completed');