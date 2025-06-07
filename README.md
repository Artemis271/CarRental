# CarRental
Приложение для бронирование автомобилей


## Используемые технологии
![](https://skillicons.dev/icons?i=java,idea,spring,mysql)

![](https://skillicons.dev/icons?i=docker,postman,maven,angular)

![](https://skillicons.dev/icons?i=vscode,css,typescript)



## Старт
### Локальный старт подразумевает, что на компьютере уже установлен Mysql
1) #### ***Локальный старт***
* Клонировать репозиторий `git clone https://github.com/Artemis271/CarRental`
* Открыть через IDE
* Скачать необходимые сервисы с помощью команды `docker-compose up --build`
* Установить все необходимые для каждого сервиса переменные окружения
* Настроить схему БД (схема к каждому сервису есть в директории resources)
* Запустить клиентскую часть, перейдя в директорию **Angular** и 
ввести команду `ng serve start`
* Запустить все бэкенд сервисы на Java Spring Boot
* Перейти на **localhost:4200**

2) #### ***Старт через Docker***
* Клонировать репозиторий `git clone https://github.com/Artemis271/CarRental`
* Скачать необходимые сервисы с помощью команды `docker-compose up --build`
* Перейти на **localhost:4200**

## Демо
1) Главная страница  
   ![](github/main-page.png)
2) Страница логина  
   ![](github/login-page.png)
3) Страница регистрации  
   ![](github/register-page.png)
4) Страница профиля пользователя  
   ![](github/account-page.png)
5) Страница группового веб-чата  
   ![](github/web-chat-page.png)
6) Страница проектов  
   ![](github/project-page.png)
7) Страница задач  
   ![](github/tasks-page.png)
8) Кастомное модальное окно  
   ![](github/modal-window-page.png)
9) Инфографика по задачам и проектам  
   ![](github/charts-page.png)
10) Документация эндпоинтов через openAPI  
    ![](github/open-api-1.png)  
    ![](github/open-api-2.png)
