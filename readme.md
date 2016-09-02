## Using H2DB -MySQL- in Spring Boot via Spring Data JPA and Hibernate

See here for more informations:
http://blog.netgloo.com/2014/10/27/using-mysql-in-spring-boot-via-spring-data-jpa-and-hibernate/

### Build and run

#### Configurations

Open the `application.properties` file and set your own configurations.

#### Prerequisites

- Java 8
- Maven > 3.0

#### From terminal

Go on the project's root folder, then type:

    $ mvn spring-boot:run

#### From Eclipse (Spring Tool Suite)

Import as *Existing Maven Project* and run it as *Spring Boot App*.


### Usage

- Run the application and go on http://localhost:8080/
- Use the following urls to invoke controllers methods and see the interactions
  with the database:
    * `/create?email=[email]&name=[name]`: create a new user with an auto-generated id and email and name as passed values.
    * `/delete?id=[id]`: delete the user with the passed id.
    * `/get-by-email?email=[email]`: retrieve the id for the user with the passed email address.
    * `/update?id=[id]&email=[email]&name=[name]`: update the email and the name for the user indentified by the passed id.

ортал обмена подарками 

Написать портал обмена подарками через соц. сети.
 Есть некий список заведений и товаров в них. 
У пользователя должны возможности:
1) Просмотреть список ЗАВЕДЕНИЕ магазинов/баров/ресторанов/закусочных. Выбрать один из них.
(Должно быть описание магазина, телефон, адрес, условия доставки, ФИО владельца,картинка)

2) В выбраном заведении просмотреть список товаров по категориям.? ???????????????????????  
(Категории - отедельная сущность)
Выбрать один из них (товаров) .
(Обязательно, должна быть информация о товаре: картинка,название, цена, страна производитель, штрихкод) 

3) Далее в списке друзей(подгружается из соц. сетей) 
 
 выбрать друга и нажать кнопку "Подарить". 
 Кнопка "Подарить" может быть и на самом товаре, для быстрого доступа.
 
После нажатия на кнопку "подарить" мы должны направить пользователя на страницу выбора формы оплаты(картой, через ПриватБанк,ВебМани)

4) Логин в приложение обязательно делается через одну из соц. сетей (ВК, ФБ, Твитер, Г+)(на этом этапе запрашиваются у соц. сети 
публичные данные о пользователе)


5) На странице "Друзья" подтягиваются из соц. сети друзья.

6) После логина попадаешь на страницу со своим фото, краткими данными, и последним другом с которым ты обменивался подарками.
7) Механизм оплаты

Список страниц:
1)Логин.
2)Главная страница.
3)страница со списокм друзей.
4)Список магазинов.
5)Список товаров в магазине.
6)Страница с описанием товара.
7)Страница с выбором системы оплаты.