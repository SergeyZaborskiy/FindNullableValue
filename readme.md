# Задание для разбора на собеседовании

-  POJO сервиса состоят из классов Human, Adult(взрослые пользователи), Child(дети),
а так же встроенного справочника HumanEmbeddedDictionary содержащем данные
о некотором списке пользователей

### Задание 1 - Найти пользователя по ID

- Для сервиса HumanListService необходимо реализовать 
метод findById для поиска пользователей по ID среди встроенного справочника HumanEmbeddedDictionary,
при этом необходимо помнить, что переданного в качестве параметра ID может не содержаться в справочнике.

### Задание 2 - Сгруппировать пользователей по именам

- Для сервиса HumanListService необходимо реализовать метод groupByName, 
который будет групировать взрослых пользователей по их именам


### Задание 3 - Провести лотерею среди пользователей

- Для сервиса HumanListService необходимо реализовать два метода getRandomHumanForLottery, который выбирает рандомного
пользователя из списка для участия в лоттерее, и метод checkWinner, который выберет из отобранных пользователей победителя.
Правила лотереи таковы, что раз в 1 секунду выбирается рандомный пользователь, после того как количество пользователей 
достигнет 5 человек, должен запустится выбор победителя среди них. 
После того как выбран победитель лотерея должна возобновиться.


### Задание 4 - Переход в SQL

- Необходимо написать скрипт create_table_human.sql для создания таблицы в которой будут храниться данные,
вместо встроенного справочника. База данных - MsSqlServer. 
Для созданной таблицы необходимо реализовать Entity и Repository в соответствующих подпакетах пакета data

### Задание 5 - Поиск пользователя в SQL базе

- В созданном репозитории необходимо реализовать метод, который будет возвращать пользователей с датой рождения между
1990 и 1992 годом, которые имеют специальность Инженер. У данных пользователей должна быть указана
национальность

