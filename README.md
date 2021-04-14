# TestSimbirsoft
Тест на junit с использованием Selenium, Selenium GRID и Allure.
Тест совершает следующие действия:
С помощью Selenium открывает браузер, открывает страницу выше указанной почты(yandex.ru) и авторизовывается;
С помощью Selenium определяет сколько во входящих нашлось писем с темой «Simbirsoft Тестовое задание»;
С помощью Selenium и интерфейса почты пишет и отправляет письмо на этот же почтовый ящик с темой письма «Simbirsoft Тестовое задание. <Фамилия>» 
и результатом поиска входящих писем.

Инструкция по запуску Selenium GRID:
1.	Скачать chromedriver (версия драйвера браузера должна соответствовать имеющемуся браузеру Chrome).
2.	Скачать selenium-server-standalone-3.141.59 для поднятия хаба Selenium GRID.
3.	Поднимаем хаб Selenium GRID с помощью команды прописанной в командной строке –  
[ java -jar selenium-server-standalone-3.141.59.jar -role hub ]. По адресу http://localhost:4444/grid/console можно убедиться, что хаб поднят.
4.	Далее командой – [ java -Dwebdriver.chrome.driver="Путь до файла драйвера браузера" -jar selenium-server-standalone-3.141.59.jar -role webdriver -hub http://00.00.000.00:4444/grid/register -port 4546 ] мы поднимаем Node и задаем ему порт 4546, который укажем в программе. Адрес с портом 4444 это полученный адрес при поднятии хаба.
5.	По адресу http://localhost:4444/grid/console можно убедиться, что поднята и Node.
