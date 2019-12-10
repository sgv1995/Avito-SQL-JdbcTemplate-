CREATE TABLE houses
(
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    price       INTEGER CHECK ( price > 0 ),
    rooms       INTEGER CHECK ( rooms > 0 ),
    district    TEXT,
    underground TEXT
);

INSERT INTO houses (id, price, rooms, district, underground)
VALUES (1, 1750000, 1, 'Ново-Cавиновский', 'Козья слобода');

INSERT INTO houses (id, price, rooms, district, underground)
VALUES (2, 2200000, 2,'Авиастороительный', 'Авиастроительная');

INSERT INTO houses (id, price, rooms, district, underground)
VALUES (3, 1650000, 2, 'Азино', 'Проспект Победы');

INSERT INTO houses (id, price, rooms, district, underground)
VALUES (4, 3000000, 3, 'Азино', 'Проспект Победы');