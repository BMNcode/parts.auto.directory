# Необходимо разработать CRUD backend сервис "справочник автозапчастей".  

### Сервис состоит из Rest приложения и базы данных.

#### Сервис хранит следующую информацию:


 1. Запчасть (артикул, наименование , категория, модели автомобилей)  
 2. Модели автомобилей  
 3. Марки автомобилей  
 4. Категории (например, кузов, двигатель, ходовая часть, тормозная система, салон)  

#### Сервис должен выполнять следующие функции:

 1. Добавление запчасти  
 2. Редактирование запчасти  
 3. Получение полного списка запчастей  
 4. Поиск запчасти по артикулу и/или наименованию и/или марке и/или модели и/или категории  
 5. Получение полного списка марок  
 6. Получение полного списка моделей  

#### Приложение должно быть разработано с использованием Spring Boot, в качестве базы можно использовать Postgres  
Код необходимо сдать в репозиторий:  
https://git.digital.rt.ru/java_school_test/bulenkovmaksim89


#### cd Docker : docker-compose up  
#### mvn flyway:clean
#### mvn flyway:migrate  


 - Добавление запчасти  

```sh

POST : localhost:8080/part

{
    "article":"000000001",
    "partName": "Ремень поликлиновый",
    "categoryId":"2",
    "modelId":[1, 3, 4, 5, 7, 8]
}
```
```sh
{
    "article":"000000002",
    "partName": "РАДИАТОР AT/MT +/-AC 08-",
    "categoryId":"1",
    "modelId":[1, 5, 6, 10, 11, 12]
}
```
```sh
{
    "article":"000000003",
    "partName": "Обивка салона",
    "categoryId":"5",
    "modelId":[9, 10, 11]
}
```
```sh
{
    "article":"000000004",
    "partName": "Диск тормозной BREMBO",
    "categoryId":"5",
    "modelId":[9, 10, 11]
}

```  
 - Редактирование запчасти  

```sh

PUT : localhost:8080/part

{
    "id":"17",
    "article":"000001152",
    "partName": "Диск тормозной RECARO",
    "categoryId":"5",
    "modelId":[1, 2, 3]
}

```

 - Получение полного списка запчастей  

```sh

GET : localhost:8080/part/all

```

 - Поиск запчасти по артикулу и/или наименованию и/или марке и/или модели и/или категории
 
 По умолчанию поиск работает по предикату AND, можно изменить поиск и включать все варианты  
 с использованием оператора OR   
 
 ```sh
 
 GET : localhost:8080/part/?article=000000004

 GET : localhost:8080/part/?partName=Ремень поликлиновый

 GET : localhost:8080/part/?category=body

 GET : localhost:8080/part/?model=X5

 GET : localhost:8080/part/?brand=BMW

 GET : localhost:8080/part/?article=000000002&category=body

 GET : localhost:8080/part/?article=000000001&partName=ремень поликлиновый&category=body&model=X5&brand=BMW

 GET : localhost:8080/part/?article=000000004&partName=ремень поликлиновый&brand=BMW&operation=OR
 
 ```

 - Получение полного списка марок  
 
  ```sh
  
 GET : localhost:8080/brand/all

 ```

 - Получение полного списка моделей    
 
  ```sh
   
 GET : localhost:8080/model/all
 
  ```