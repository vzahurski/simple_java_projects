<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Reservation Query</title>
</head>

<body>

<form method="post">
    Court Name
    <input type="text" name="courtName" value="${courtName}"/>
    <input type="submit" value="Query"/>
</form>

<table border="1">
    <tr>
        <th>Court Name</th>
        <th>Date</th>
        <th>Hour</th>
        <th>Player</th>
    </tr>
    <c:forEach items="${reservations}" var="reservation">
        <tr>
            <td>${reservation.courtName}</td>
            <td><fmt:formatDate value="${reservation.dateAsUtilDate}" pattern="yyyy-MM-dd"/></td>
            <td>${reservation.hour}</td>
            <td>${reservation.player.name}</td>
        </tr>
    </c:forEach>
</table>

<%-- Почему как путь к странице отображения бронирований я использую welcome? --%>

<%--
Почему как путь к странице отображения бронирований я использую
href="welcome"> работает
href="court/welcome"> работает
href="/welcome"> не работает

Случай href="welcome">
в jsp указывается http-ссылка(html)
В html когда кликаешь по ссылке приннцип такой. Если ссылка не начинается со /, она берет от текущего пути
Текущий путь до последнего /
В браузере в адресной строке этой страницы Welcome вижу http://localhost:8080/court/reservationQuery
Значит текущий путь http://localhost:8080/court
К этому пути html добавляет то что находится в href через /
Получаем http://localhost:8080/court/welcome

Случай href="/welcome"> т.е. в начале есть /, то html генерирует путь от сервера
http://localhost:8080/welcome
Ну и такой путь соответственно не находится, т.е. сервлет контейнер не находит приложения ContextPath = /welcome
? --%>

<br><br><a href="welcome"> Go to welcome<a>
</body>
</html>
