<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: manager
  Date: 14.12.2016
  Time: 21:47
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
<script type="text/javascript">

    function show(state, id) {

        document.getElementById('window').style.display = state;
        document.getElementById('wrap').style.display = state;

    }

</script>
<div onclick="show('none',-1)" id="wrap"></div>
<div id="window"></div>
<table class="highlight responsive-table bordered">
    <h5>Список всех диспетчеров</h5>
    <thead>
    <tr>
        <th data-field="id" class="grey darken-3 white-text">ID</th>
        <th data-field="login" class="grey darken-3 white-text">Логин</th>
        <th data-field="password" class="grey darken-3 white-text">Пароль</th>
        <th data-field="name" class="grey darken-3 white-text">Имя</th>
        <th data-field="lastname" class="grey darken-3 white-text">Фамилия</th>
        <th data-field="remove" class="grey darken-3 white-text"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.userId }</td>
            <td>${user.login }</td>
            <td>${user.password }</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>

            <td>
        <form action="controller" method="post">
            <input type="hidden" name="command" value="removeUser">
            <input type="hidden" name="id" value="${user.userId}">
            <input type="submit" value="Удалить" class="button waves-effect waves-light btn purple darken-3">
        </form>
        </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
