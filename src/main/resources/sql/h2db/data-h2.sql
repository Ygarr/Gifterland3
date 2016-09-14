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
INSERT INTO foodstores VALUES (3, 'Точный адрес', 'описание', 'email@service.com', 'Заведение №71', 'Хозяй','Хозяевич','Хозяйнов','095-87878-1023');
INSERT INTO foodstores VALUES (4, 'ул. Центральная 23a-45', 'Быстро и доступно', '1@m-m.com', 'Ресторация №1', 'Виктор','Глебович','Симов','095-87878-2222');

INSERT INTO meal(id, barcode, manufacturer, name, price, category_id, foodstore_id) VALUES (1, 897243425, 'China', 'Цезарь', 25.99 ,7, null);  --TODO generate data
INSERT INTO meal(id, barcode, manufacturer, name, price, category_id, foodstore_id) VALUES (2, 897243425, 'Poland', 'Multivitamin', 5.99 ,8, 3);
INSERT INTO meal(
id
, barcode
, manufacturer
, name
, price
, category_id
, foodstore_id)
VALUES (
3
, 823243425
, 'Ukraine'
, 'Маргарита'
, 25.99
, 1
, 3 -- foodstore_id
);

INSERT INTO meal (
id
, barcode
, manufacturer
, name
, price
, category_id
, foodstore_id)
VALUES (
4
, 823288825
, 'Ukraine' -- TODO справочник
, 'Греческий'
, 22.99
, 7
, 4 -- foodstore_id
);



/*
INSERT INTO foodstores VALUES (1, 'Super Grocery Store', 'whatsyour@ml.eu', 'Поставляем свежакъ', 'Madison', 'Deputat','Deputatovich','Конча Заспа, 23-567','608-555-1023');
INSERT INTO foodstores VALUES (2, 'Great Name', 'whatsyour@mylo.com', 'Быстро, скоро, дешево', 'Иван', 'Иванов','Сергеевич','Николаев, Космонавтов, 34','095-1023');
INSERT INTO foodstores VALUES (3, 'Точный адрес', 'описание', 'email@service.com', 'Заведение №71', 'Хозяй','Хозяевич','Хозяйнов','095-87878-1023');
*/


/*
SELECT
productcategory.name as категория

, meal.name as наименование
, meal.manufacturer as производитель
, meal.price as цена
, meal.barcode as код

,foodstores.name as Магазин

 FROM productcategory
join meal
on productcategory.id = meal.category_id
left join foodstores
on foodstores.id = meal.foodstore_id
;
*/

-- show columns from users;

--for DEBUG ONLY
 update MEAL SET  image = FILE_READ('~/icecream.jpg') WHERE ID=4;