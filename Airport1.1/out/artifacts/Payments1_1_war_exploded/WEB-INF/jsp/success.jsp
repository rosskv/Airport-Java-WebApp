<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="../../css/materialize.css">
</head>
<body>
<body>
<div class="slider fullscreen">
    <ul class="slides">
        <li>
            <img class="responsive-img" src="img/background.jpg" />
            <div class="caption center-align">
                <h3>Спасибо за регистрацию!</h3>
                <a class="waves-effect waves-light btn purple darken-3" href="/login">Войти</a>
            </div>
        </li>
    </ul>
</div>

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/materialize.js"></script>
<script> $(document).ready(function(){
    $('.slider').slider({full_width: true});
});
</script>
</body>
</html>
