<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error page</title>
</head>
<body>
    Request from ${pageContext.errorData.requestURI} is failed <br/>
    Servlet name or type : ${pageContext.errorData.servletName} <br>
    Status code: ${pageContext.errorData.statusCode} <br/>
    Exception^ ${pageContext.errorData.throwable}
    <a href="/index">На главную</a>
</body>
</html>
