<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: manager
  Date: 16.12.2016
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="navbaruser.jsp"/>
<div class="row">
    <h5 class="center">Добавить нового сотрудника в бриагаду</h5>
    <div class="card grey darken-4 col m4 push-m4 pull-m4 center ">
        <div class="card-content white-text">
            <span class="card-title">Выберите сотрудника</span>
            <form action="controller" method="post">
                <input type="hidden" name="command" value="addEmployeesIntoBrigade">
                <input type="hidden" name="brigadeId" value="${brigades.brigdeId}">
                <select name="idEmp">
                    <option selected="selected" disabled>Сотрудники</option>
                    <c:forEach var="employees" items="${empl}">
                        <option value="${employees.employeesId}">${employees.firstname } ${employees.lastname }   <c:if test="${employees.professionId == 1}">
                            Пилот
                        </c:if>
                            <c:if test="${employees.professionId == 2}">
                                Радист
                            </c:if>
                            <c:if test="${employees.professionId == 4}">
                                Стюардесса
                            </c:if>
                            <c:if test="${employees.professionId == 3}">
                                Штурман
                            </c:if> </option>
                    </c:forEach>
                </select>
                <button type="submit" class="waves-effect waves-light btn blue lighten-2">добавить</button>
            </form>
        </div>
    </div>
</div>
<h5> Сотрудники бригады "${brigades.name}"</h5>
<div class="row">
<c:forEach var="employees" items="${employees}">
    <div class="col m3">
    <div class="card grey darken-4">
             <div class="card-content white-text">
                <span class="card-title">Номер сотрудника: ${employees.employeesId} </span>
                <p>${employees.lastname} ${employees.firstname} </p>
                <h6 class="pink-text">  <c:if test="${employees.professionId == 1}">
                    ПИЛОТ
                </c:if>
                    <c:if test="${employees.professionId == 2}">
                        РАДИСТ
                    </c:if>
                    <c:if test="${employees.professionId == 4}">
                        СТЮАРДЕССА
                    </c:if>
                    <c:if test="${employees.professionId == 3}">
                        ШТУРМАН
                    </c:if> </h6>
            </div>
        <div class="card-action">
                        <form action="controller" method="post" class="center">
                        <input type="hidden" name="command" value="RemoveEmployeesIntoBrigade">
                        <input type="hidden" name="id" value="${employees.employeesId}">
                        <button type="submit" class="waves-effect waves-light btn pink darken-4">удалить</button>
                    </form>

            </div>
        </div>
    </div>
</c:forEach>
</div>

<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../js/materialize.js"></script>
<script>
    $(document).ready(function() {
        $('select').material_select();
    });
</script>
</body>
</html>
