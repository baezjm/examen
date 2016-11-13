INSERT INTO currency(id, name,symbol) values (1,'Dollar','U$D');
INSERT INTO currency(id, name,symbol) values (2,'Peso','$');

INSERT INTO menu(id, name, description, price, currency, from_valid_date, to_valid_date, from_hour, from_minute, to_hour, to_minute, ranking, picture_file)
VALUES (1, 'Tostada Tijuana', 'Black Beans, Lettuce and others', 4.25, 1, DATE '2015-04-01', DATE '2015-12-31', 8, 10, 12, 30, 3.5, 'food-picture-01.jpg');

INSERT INTO menu_day(menu_id, day) VALUES(1, 'monday');
INSERT INTO menu_day(menu_id, day) VALUES(1, 'tuesday');
INSERT INTO menu_day(menu_id, day) VALUES(1, 'wednesday');
INSERT INTO menu_day(menu_id, day) VALUES(1, 'thursday');
INSERT INTO menu_day(menu_id, day) VALUES(1, 'friday');

INSERT INTO menu(id, name, description, price, currency, from_valid_date, to_valid_date, from_hour, from_minute, to_hour, to_minute, ranking, picture_file)
VALUES (2, 'Classic Burger', 'A fresh meat burger with lettuce, tommato and onion', 7.50, 1, DATE '2015-08-15', DATE '2016-08-15', 12, 0, 22, 0, 4.5, 'food-picture-02.jpg');

INSERT INTO menu_day(menu_id, day) VALUES(2, 'saturday');
INSERT INTO menu_day(menu_id, day) VALUES(2, 'sunday');

INSERT INTO menu(id, name, description, price, currency, from_valid_date, to_valid_date, from_hour, from_minute, to_hour, to_minute, ranking, picture_file)
VALUES (3, 'Agnolottis', 'Original italian agnolottis with ham and cheese', 55.0, 2, DATE '2015-10-05', DATE '2016-04-10', 11, 0, 16, 0, 4.3, 'food-picture-03.jpg');

INSERT INTO menu_day(menu_id, day) VALUES(3, 'thursday');
INSERT INTO menu_day(menu_id, day) VALUES(3, 'friday');
INSERT INTO menu_day(menu_id, day) VALUES(3, 'saturday');
INSERT INTO menu_day(menu_id, day) VALUES(3, 'sunday');

INSERT INTO menu(id, name, description, price, currency, from_valid_date, to_valid_date, from_hour, from_minute, to_hour, to_minute, ranking, picture_file)
VALUES (4, 'Risotto', 'An Italian rice with a creamy consistence', 42.0, 2, DATE '2014-07-01', DATE '2015-11-01', 11, 30, 16, 0, 3.8, 'food-picture-04.jpg');

INSERT INTO menu_day(menu_id, day) VALUES(4, 'saturday');
INSERT INTO menu_day(menu_id, day) VALUES(4, 'sunday');