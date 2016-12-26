<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="../../css/materialize.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<nav>
    <div class="nav-wrapper pink darken-4">
        <c:if test="${isSignedIn == true}">
        <a href="controller?command=viewPage" class="brand-logo"><i class="material-icons medium">local_airport</i>Dreamfly</a>
            <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
                            <ul id="nav-mobile" class="right hide-on-med-and-down">
                                <li><a href="controller?command=viewEmployees">Сотрудники</a></li>
                                 <li><a href="controller?command=logout">Выйти</a></li>
                </c:if>
            </ul>
            <ul class="side-nav" id="mobile-demo">
                <li><a href="controller?command=viewEmployees">Сотрудники</a></li>
                <li><a href="controller?command=logout">Выйти</a></li>

            </ul>
    </div>
</nav>
<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../js/materialize.js"></script>
<script>
    $(".button-collapse").sideNav();
</script>
</body>
</html>
