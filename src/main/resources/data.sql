-- person
INSERT INTO person (name, age, address_id, job, time) VALUES ('hainet', 24, 1, 'programmer', CURRENT_TIMESTAMP);

-- address
INSERT INTO address (zip_code, state) VALUES ('1111111', 'JAPAN');

-- skill
INSERT INTO skill (job, name) VALUES ('programmer', 'java');
INSERT INTO skill (job, name) VALUES ('programmer', 'spring');
INSERT INTO skill (job, name) VALUES ('programmer', 'mybatis');

-- user
INSERT INTO constructor_person (name) VALUES ('hainet');
