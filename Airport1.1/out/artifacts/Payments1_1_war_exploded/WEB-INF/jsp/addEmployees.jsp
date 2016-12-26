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
<div class="row">
    <div class="col s12">
        <div class="card card-content white-text caption col m4 push-m4 pull-m4 center-align grey darken-4">
            <h5 class="card-title">Заполните поля, чтобы добавить сотрудника</h5>
                <form name="AddFlightForm" action="controller" method="POST" class="col s12 caption">
                      <input name="command" type="hidden" value="addEmployeesForm">
                          <div class="row">
                            <div class="input-field">
                            <input required  name="firstName" type="text">
                            <label>Имя</label>
                            </div>
                          </div>
                            <div class="row">
                             <div class="input-field">
                                    <input required  name="lastName" type="text">
                                      <label>Фаимилия</label>
                              </div>
                            </div>
                    <div class="row">
                           <select required  size="1" name="professionId">
                            <option disabled>Выберите профессию</option>
                        <c:forEach var="professions" items="${professions}">
                        <option name="profession_id" value="${professions.professionId}">
                                ${professions.profession}
                         </option>
                        </c:forEach>
                        </select>
                    </div>
                   <button type="submit" class="waves-effect waves-light btn pink darken-4">Добавить</button>
                </form>
        </div>
    </div>
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
