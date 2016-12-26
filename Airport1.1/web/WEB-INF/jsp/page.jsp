<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="../../css/materialize.css">
</head>
<body>
<jsp:include page="navbaruser.jsp"/>
<div class="row">
    <div class="card grey darken-4 col m4 push-m1 ">
        <div class="card-content white-text">
            <span class="card-title">Введите название бригады</span>
            <form name="AddFlightForm" action="controller" method="POST" class="col s12 caption">
                <input name="command" type="hidden" value="addBrigade">
                <div class="row">
                    <div class="input-field">
                        <input name="name" type="text">
                        <label></label>
                    </div>
                </div>
                <button type="submit" href="controller?command=viewBrigade" class="waves-effect waves-light btn pink darken-4">Добавить</button>

            </form>
        </div>
    </div>

    <ul class="collection with-header right col m5  pull-m1">
        <li class="collection-header"><h4>Доступные бригады</h4>
          <!--  <form name="Restart" method="POST" action="controller">
                <input name="command" type="hidden" value="viewBrigade">
                <input type="submit" class="waves-effect waves-light btn indigo darken-4" href="controller?command=viewBrigade" value="Обновить"/>
            </form> -->
        </li>
        <c:forEach var="brigades" items="${brigades}">
            <li class="collection-item">
                <div> ${brigades.brigdeId}. ${brigades.name}
                    <form action="controller" method="post" class="secondary-content">
                        <input type="hidden" name="command" value="removeBrigade">
                        <input type="hidden" name="id" value="${brigades.brigdeId}">
                        <input type="submit" value="Удалить" class="white-text purple darken-3">
                    </form>
                   <form action="controller" method="post" class="secondary-content">
                        <input type="hidden" name="command" value="viewEmployeesBrigade">
                        <input type="hidden" name="id" value="${brigades.brigdeId}">
                        <input  type="submit" value="Посмотреть" class=" white-text pink darken-4">
                   </form>
                </div>
            </li>
        </c:forEach>
    </ul>

    <!-- <h4>Добавить рейс</h4>
     <form name="AddFlightForm" action="controller" method="POST" class="col s6">
         <input name="command" type="hidden" value="addBrigade">
         <div class="row">
             <div class="input-field col s4">
                 <input name="name" type="text">
                 <label>Имя</label>
             </div>
         </div>
         <input type="submit" value="Добавить" class="waves-effect waves-light btn indigo darken-4"/>
     </form>-->
</div>

<!--<jsp:include page="footer.jsp"/>-->
</body>
</html>
