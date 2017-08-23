DROP TABLE IF EXISTS person;
CREATE TABLE person (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name CHAR,
  age INT,
  address_id INT,
  job CHAR,
  time TIMESTAMP
);

DROP TABLE IF EXISTS address;
CREATE TABLE address (
  id INT AUTO_INCREMENT PRIMARY KEY,
  zip_code CHAR
);

DROP TABLE IF EXISTS skill;
CREATE TABLE skill (
  id INT AUTO_INCREMENT PRIMARY KEY,
  job CHAR,
  name CHAR
);

DROP TABLE IF EXISTS constructor_person;
CREATE TABLE constructor_person (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name CHAR
);
