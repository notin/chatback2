CREATE TABLE conversation(
   type  VARCHAR(8) NOT NULL PRIMARY KEY
  ,gui_1 VARCHAR(4) NOT NULL
  ,gui_2 VARCHAR(3) NOT NULL
);
INSERT INTO conversation(type,gui_1,gui_2) VALUES ('starting','good','bad');
INSERT INTO conversation(type,gui_1,gui_2) VALUES ('starting','good','bad');
