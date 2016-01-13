CREATE DATABASE test1 WITH ENCODING = 'UTF-8';

\c test1;

CREATE TABLE classname(
	id SERIAL NOT NULL PRIMARY KEY,
	classname CHARACTER VARYING(150) NOT NULL UNIQUE
);

CREATE TABLE keyword(
	id SERIAL NOT NULL PRIMARY KEY,
	binded_class INT REFERENCES classname(id),
	keyword CHARACTER VARYING(50) NOT NULL UNIQUE
);

INSERT INTO classname(classname) VALUES
('ie.globalcom.Bell'),
('ie.globalcom.Bulb'),
('ie.globalcom.Microwave');


INSERT INTO keyword(keyword, binded_class) VALUES
('ring', 1),
('bell', 1),
('light', 2),
('microwave', 3);