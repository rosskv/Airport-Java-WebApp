<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: manager
  Date: 15.12.2016
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="../../css/materialize.css">
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:import url="/navbar"/>

<table class="highlight responsive-table bordered">
<h5>Список всех рейсов</h5>
    <thead>
    <tr>
        <th data-field="id" class="grey darken-3 white-text">ID</th>
        <th data-field="name" class="grey darken-3 white-text">Имя рейса</th>
        <th data-field="fromPort" class="grey darken-3 white-text">Откуда</th>
        <th data-field="toPort" class="grey darken-3 white-text">Куда</th>
        <th data-field="date" class="grey darken-3 white-text">Дата</th>
        <th data-field="time" class="grey darken-3 white-text">Время</th>
        <th data-field="brigade" class="grey darken-3 white-text">Номер бригады</th>
        <th data-field="remove" class="grey darken-3 white-text"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="flights" items="${flights}">
        <tr>
            <td>${flights.flightId }</td>
            <td>${flights.name}</td>
            <td>${flights.fromPort }</td>
            <td>${flights.toPort }</td>
            <td>${flights.dateFlight}</td>
            <td>${flights.timeFlight}</td>
            <td> ${flights.brigade}</td>
           <!-- <c:if test="${flights.flown == true}">
                <th>Завершен</th>
            </c:if>
            <c:if test="${flights.flown == false}">
                <th>В полете</th>
            </c:if>
            -->
        <td>
            <form action="controller" method="post">
                <input type="hidden" name="command" value="removeFlights">
                <input type="hidden" name="id" value="${flights.flightId }">
                <input type="submit" value="Удалить" class="button waves-effect waves-light btn purple darken-3">
            </form>
        </td>

        </tr>
    </c:forEach>
    </tbody>
</table>
<!--<jsp:include page="/footer"/>-->
</body>
</html>
