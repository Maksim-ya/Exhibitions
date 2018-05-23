**Вариант 7.**
Система Календарь выставок. Существует список Выставочных залов в
каждом из которых есть перечень Экспозиций. Посетитель покупает
Билеты оформив Платёж и выбрав Тему выставки.




**Общие требования**

Необходимо построить веб-приложение, поддерживающую следующую
функциональность:
1. На основе сущностей предметной области создать классы их
описывающие.
2. Классы и методы должны иметь отражающую их функциональность
названия и должны быть грамотно структурированы по пакетам
3. Информацию о предметной области хранить в БД, для доступа
использовать API JDBC с использованием пула соединений,
стандартного или разработанного самостоятельно. В качестве СУБД
рекомендуется MySQL.
4. Приложение должно поддерживать работу с кириллицей (быть
многоязычной), в том числе и при хранении информации в БД.
5. Код должен быть документирован.
6. Приложение должно быть покрытоЮнит-тестами
7. При разработке бизнес логики использовать сессии и фильтры, и
события в системе обрабатывать с помощью Log4j.
8. В приложении необходимо реализовать Pagination, Transaction в
зависимости от Вашего проекта
9. Используя сервлеты и JSP, реализовать функциональности,
предложенные в постановке конкретной задачи.
10 . В страницах JSP применять библиотеку JSTL
11 . Приложение должно корректно реагировать на ошибки и исключения
разного рода (Пользователь никогда не должен видеть stack-trace на
стороне front-end).
12 . В приложении должна быть реализована система Авторизации и
Аутентификации

**Инструкция по установке и запуску**

1.Приложение работает с базой данных MySQL (логин и пароль задаются
 в файле в папке приложения /web/META-IHF/context.xml). Дамп базы
 данных находится в папке приложения /dumps
 
2.WAR файл приложения необходимо развернуть в контейнере сервлетов
Tomcat в папке Сервер /webapps

3.Запустить Tomcat

