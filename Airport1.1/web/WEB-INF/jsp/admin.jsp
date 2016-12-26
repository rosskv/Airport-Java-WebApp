<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
  <link rel="stylesheet" type="text/css" href="../../css/materialize.css">
</head>
<body>
<c:import url="/navbar"/>
<%--<jsp:include page="/navbar"/>--%>

  <div class="row">
    <div class="col s12">
      <div class="card card-content white-text caption col m6 push-m3 pull-m3 center-align grey darken-4">
          <h4>Добавить рейс</h4>
    <form  class="card-content white-text caption center-align" name="AddFlightForm" action="controller" method="POST" class="col s8">
    <input name="command" type="hidden" value="addflight">
      <div class="row">
        <div class="input-field col s12">
           <input required name="name" type="text">
            <label>Имя</label>
         </div>
      </div>
      <div class="row">
         <div class="input-field col s6">
             <input required name="fromPort" type="text">
              <label>Откуда</label>
         </div>
         <div class="input-field col s6">
              <input required name="toPort" type="text" class="validate" length="15">
              <label>Куда</label>
          </div>
      </div>
      <div class="row">
      <div class="input-field col s6">
        <input required name="dateFlight" type="date">
      </div>
      <div class="input-field col s6">
        <input required name="timeFlight" type="time">
      </div>
        <div class="row">
      <div class="col s12">

        <select  size="1" name="brigadeId">
          <option selected="selected" disabled>Выберите бригаду</option>
          <c:forEach var="user" items="${brigades}">
            <option name="driver_id" value="${user.brigdeId}"> ${user.name}</option>
          </c:forEach>
        </select>
      </div>
     </div>
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
