--schema sql

DROP TABLE Foodstores IF EXISTS;

CREATE TABLE Foodstores (
  id         INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(30),
 email VARCHAR(30),

 description VARCHAR(255),

  ownerName VARCHAR(30),
  ownerSurname  VARCHAR(30),
ownerPatronymic  VARCHAR(30),

  address    VARCHAR(255),
  phone  VARCHAR(20)
);

CREATE INDEX foodstores_name ON foodstores (name);