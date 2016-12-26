<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: manager
  Date: 16.12.2016
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="navbaruser.jsp"/>
<h5>Список Сотрудников</h5>
<a class="waves-effect waves-light btn blue lighten-2" href="/controller?command=addEmployees">Добавить</a>
<table class="highlight responsive-table bordered">

    <thead>
    <tr>
        <th data-field="id" class="grey darken-3 white-text">ID</th>
        <th data-field="name" class="grey darken-3 white-text">Имя</th>
        <th data-field="lastName" class="grey darken-3 white-text">Фамилия</th>
        <th data-field="profession" class="grey darken-3 white-text">Профессия</th>
        <th data-field="remove" class="grey darken-3 white-text"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="employees" items="${employees}">
        <tr>
            <td>${employees.employeesId }</td>
            <td>${employees.firstname}</td>
            <td>${employees.lastname}</td>

            <c:if test="${employees.professionId == 1}">
                <th>Пилот</th>
            </c:if>
            <c:if test="${employees.professionId == 2}">
                <th>Радист</th>
            </c:if>
            <c:if test="${employees.professionId == 4}">
                <th>Стюардесса</th>
            </c:if>
            <c:if test="${employees.professionId == 3}">
                <th>Штурман</th>
            </c:if>

            <td>
                <form action="controller" method="post">
                    <input type="hidden" name="command" value="removeEmployees">
                    <input type="hidden" name="id" value="${employees.employeesId}">
                    <input type="submit" value="удалить" class="button waves-effect waves-light btn purple darken-3">
                </form>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>
<!--<jsp:include page="/footer"/>-->
</body>
</html>
