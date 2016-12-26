<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
    <link rel="stylesheet" type="text/css" href="../../css/materialize.css">
</head>
<body>
  <!--  <div class="row">
        <form name="SigninForm" action="controller" method="POST" class="col s8">
            <input name="command" type="hidden" value="signin">
            <div class="row">
                <div class="input-field col s4">
                    <input name="fio" type="text">
                    <label>Имя</label>
                </div>
                <div class="input-field col s4">
                    <input name="fio1" type="text">
                    <label>Фамилия</label>
                </div>
                <div class="input-field col s4">
                    <input name="login" type="text" class="validate" length="15">
                    <label>Логин</label>
                </div>
                <div class="col s4"><p>${errorInLogin}</p></div>
            </div>
            <div class="row">
                <div class="input-field col s4">
                    <input id="password" type="password" name="password" class="validate" length="15">
                    <label for="password">Пароль</label>
                </div>
                <div class="input-field col s4">
                    <input name="passwordRepeat" id="passwordRepeat" type="password" class="validate" length="15">
                    <label for="passwordRepeat">Повторите пароль</label>
                </div>
                <div class="col s4"><p>${errorInPass}</p></div>
                <div class="col s4"><p>${errorSIGNIN}</p></div>
            </div>
            <input type="submit" value="Sign in" class="waves-effect waves-light btn indigo darken-4"/>

        </form>
    </div>
-->

    <div class="slider fullscreen">
        <ul class="slides">
            <li>
                <img class="responsive-img" src="img/background.jpg" />
                <div class="caption">
                    <h4>Регистрация</h4>
                    <form name="SigninForm" action="controller" method="POST" class="col s8">
                        <input name="command" type="hidden" value="signin">
                        <div class="row">
                        <div class="input-field col s6">
                            <input  required  id="login" name="login" type="text">
                            <label for="login">Логин</label>
                            <div class="col s4"><p>${errorInLogin}</p></div>
                        </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
                                <input required  id="fio" name="fio" type="text">
                                <label for="fio">Имя</label>
                            </div>
                            <div class="input-field col s6">
                                <input  required id="fio1" name="fio1" type="text" class="validate" length="15">
                                <label for="fio1">Фамилия</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
                                <input required  id="password" name="password" type="password" class="validate" length="15">
                                <label for="password">Пароль</label>
                            </div>
                            <div class="input-field col s6">
                                <input  required id="passwordRepeat" name="passwordRepeat" type="password">
                                <label for="passwordRepeat">Повторите пароль</label>
                                <div class="col s4"><p>${errorInPass}</p></div>
                                <div class="col s4"><p>${errorSIGNIN}</p></div>
                            </div>
                        </div>
                        <button type="submit" class="waves-effect waves-light btn pink darken-4">Подтвердить</button>
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
