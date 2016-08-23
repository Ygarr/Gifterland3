--data.sql

INSERT INTO productcategory VALUES (1,'Pizza');
INSERT INTO productcategory VALUES (2,'Sushi');
INSERT INTO productcategory VALUES (3,'Kebab');
INSERT INTO productcategory VALUES (4,'Garnish');
INSERT INTO productcategory VALUES (5,'Burger');
INSERT INTO productcategory VALUES (6,'Sandwich');
INSERT INTO productcategory VALUES (7,'Salad');
INSERT INTO productcategory VALUES (8,'Drinks');
INSERT INTO productcategory VALUES (9,'Deserts');


INSERT INTO foodstores VALUES (1, 'Super Grocery Store', 'whatsyour@ml.eu', 'Поставляем свежакъ', 'Madison', 'Deputat','Deputatovich','Конча Заспа, 23-567','608-555-1023');
INSERT INTO foodstores VALUES (2, 'Great Name', 'whatsyour@mylo.com', 'Быстро, скоро, дешево', 'Иван', 'Иванов','Сергеевич','Николаев, Космонавтов, 34','095-1023');
INSERT INTO foodstores VALUES (3, 'Тосный адрес', 'описание', 'email@service.com', 'Заведение №71', 'Хозяй','Хозяевич','Хозяйнов','095-87878-1023');

INSERT INTO meal VALUES (1, 897243425, 'China', 'Цезарь', 25.99 ,7);  --TODO generate data

/*
SELECT
productcategory.name as категория
, meal.name as наименование
, meal.manufacturer as производитель
, meal.price as цена
, meal.barcode as код

 FROM productcategory
join meal
on productcategory.id = meal.category_id;
*/