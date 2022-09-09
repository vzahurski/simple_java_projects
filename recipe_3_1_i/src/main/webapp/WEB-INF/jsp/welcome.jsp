<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Welcome</title>
</head>

<body>
<h2>Welcome to Court Reservation System</h2>
Today is <fmt:formatDate value="${today}" pattern="yyyy-MM-dd"/>.

<%--
Почему как путь к странице отображения бронирований я использую
href="reservationQuery"> работает
href="court/reservationQuery"> работает
href="/reservationQuery"> не работает

Случай href="reservationQuery">
в jsp указывается http-ссылка(html)
В html когда кликаешь по ссылке приннцип такой. Если ссылка не начинается со /, она берет от текущего пути
Текущий путь до последнего /
В браузере в адресной строке этой страницы Welcome вижу http://localhost:8080/court/welcome
Значит текущий путь http://localhost:8080/court
К этому пути html добавляет то что находится в href через /
Получаем http://localhost:8080/court/reservationQuery

Случай href="/reservationQuery"> т.е. в начале есть /, то html генерирует путь от сервера
http://localhost:8080/reservationQuery
Ну и такой путь соответственно не находится, т.е. сервлет контейнер не находит приложения ContextPath = /reservationQuery

? --%>
<br><br><a href="reservationQuery"> Go to query<a>

</body>
</html>
