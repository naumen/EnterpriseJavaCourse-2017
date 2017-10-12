#EnterpriseJavaCourse Demo
Простой пример web-ориентированного приложения на Java с использованием [spring-boot](https://projects.spring.io/spring-boot/)

Функции приложения:
* вывод всех сообщений
* создание сообщения
* хранение сообщений в [H2](http://www.h2database.com/html/main.html) 
* доступ к созданию сообщения только администратору (_пользователь_ **admin** _пароль_ **password**)

Комманда для запуска сервера
```bash
./mvnw spring-boot:run
```
для сборки приложения и последующего запуска jar файла
```bash
./mvnw package
java -jar ./target/EnterpriseJavaCourse-1.0.0.jar 
```
Для доступа к приложению по умолчанию использовать адрес [http://127.0.0.1:8080/](http://127.0.0.1:8080/)