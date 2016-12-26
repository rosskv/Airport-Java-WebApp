<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>
    <link rel="stylesheet" type="text/css" href="../../css/materialize.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<div class="slider fullscreen">
    <ul class="slides">
        <li>
            <img class="responsive-img" src="img/background.jpg" />
            <div class="caption center-align">
                <h4>Введите логин и пароль чтобы <br> войти в систему</h4>
                <form name="LoginForm" method="POST" action="controller" class="col s8">
                        <input name="command" type="hidden" value="login">
                        <div class="row">
                            <div class="input-field col s6">
                                <i class="material-icons prefix">account_circle</i>
                                 <input id="login" name="login" type="text">
                                <label for="login">Логин</label>
                            </div>
                            <div class="input-field col s6">
                                <i class="material-icons prefix">lock_outline</i>
                                <input id="pas" name="password" type="password" class="validate" length="15">
                                <label for="pas"> Пароль</label>
                            </div>
                        </div>
                        ${errorLoginOrPassMessage}
                        ${wrongAction}
                        ${nullPage}
                        <button type="submit" class="waves-effect waves-light btn pink darken-4">Войти</button>
                    </form>
                 </div>
        </li>
    </ul>
</div>


<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/materialize.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/materialize.js"></script>
<script> $(document).ready(function(){
    $('.slider').slider({full_width: true});
});
</script>
</body>
</html>
