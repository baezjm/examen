INSERT INTO currency(id, name,symbol) values (1,'Dollar','U$D');
INSERT INTO currency(id, name,symbol) values (2,'Peso','$');

INSERT INTO menu(id, name, description, price, currency, from_valid_date, to_valid_date, from_hour, from_minute, to_hour, to_minute, ranking, picture_file)
VALUES (1, 'Spaguetti con salsa Bolognesa', 'Fideos acompañados por una suave salsa bolgnesa.', 89.50, 2, DATE '2016-01-01', DATE '2016-06-30', 12, 20, 16, 00, 4.9, 'food-picture-01.jpg');

INSERT INTO menu_day(menu_id, day) VALUES(1, 'monday');
INSERT INTO menu_day(menu_id, day) VALUES(1, 'tuesday');
INSERT INTO menu_day(menu_id, day) VALUES(1, 'wednesday');
INSERT INTO menu_day(menu_id, day) VALUES(1, 'thursday');
INSERT INTO menu_day(menu_id, day) VALUES(1, 'friday');

INSERT INTO menu(id, name, description, price, currency, from_valid_date, to_valid_date, from_hour, from_minute, to_hour, to_minute, ranking, picture_file)
VALUES (2, 'Hamburguesa casera', 'Hamburguesa fresca con tomates, lechiga y huevo', 15.50, 1, DATE '2016-07-01', DATE '2016-12-31', 12, 0, 22, 0, 4.2, 'food-picture-02.jpg');

INSERT INTO menu_day(menu_id, day) VALUES(2, 'saturday');
INSERT INTO menu_day(menu_id, day) VALUES(2, 'sunday');

INSERT INTO menu(id, name, description, price, currency, from_valid_date, to_valid_date, from_hour, from_minute, to_hour, to_minute, ranking, picture_file)
VALUES (3, 'Ravioles', 'Ravioles clásicos italianos', 96.0, 2, DATE '2016-02-01', DATE '2016-03-01', 11, 0, 16, 0, 4.3, 'food-picture-03.jpg');

INSERT INTO menu_day(menu_id, day) VALUES(3, 'thursday');
INSERT INTO menu_day(menu_id, day) VALUES(3, 'friday');
INSERT INTO menu_day(menu_id, day) VALUES(3, 'saturday');
INSERT INTO menu_day(menu_id, day) VALUES(3, 'sunday');

INSERT INTO menu(id, name, description, price, currency, from_valid_date, to_valid_date, from_hour, from_minute, to_hour, to_minute, ranking, picture_file)
VALUES (4, 'Empanadas', 'Empandas caseras riquisimas', 20.0, 2, DATE '2016-01-01', DATE '2016-12-31', 11, 30, 23, 0, 3.8, 'food-picture-04.jpg');

INSERT INTO menu_day(menu_id, day) VALUES(4, 'saturday');
INSERT INTO menu_day(menu_id, day) VALUES(4, 'sunday');

INSERT INTO menu(id, name, description, price, currency, from_valid_date, to_valid_date, from_hour, from_minute, to_hour, to_minute, ranking, picture_file)
VALUES (5, 'Asado', 'Asado clásico argentino (no hay mejor)', 150.0, 2, DATE '2016-12-01', DATE '2016-12-31', 11, 30, 23, 0, 5.0, 'food-picture-04.jpg');

INSERT INTO menu_day(menu_id, day) VALUES(5, 'monday');
INSERT INTO menu_day(menu_id, day) VALUES(5, 'tuesday');
INSERT INTO menu_day(menu_id, day) VALUES(5, 'wednesday');
INSERT INTO menu_day(menu_id, day) VALUES(5, 'thursday');
INSERT INTO menu_day(menu_id, day) VALUES(5, 'friday');
INSERT INTO menu_day(menu_id, day) VALUES(5, 'saturday');
INSERT INTO menu_day(menu_id, day) VALUES(5, 'sunday');