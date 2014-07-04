<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:bundle basename="i18n.messages">
    <html>
    <head>
        <link rel="stylesheet" href="webjars/bootstrap/3.2.0/css/bootstrap.css">
        <style>
            body {
                background-color: #B2FF99;
            }

            textarea {
                padding: 20px;
                margin: 20px;
            }
        </style>
        <title></title>
    </head>
    <body>
    <div class="container" style="width: 50%; margin: auto; text-align: center">
        <h1><fmt:message key="index.puttext"/></h1>

        <form action="${pageContext.request.contextPath}/strings" method="post">
            <textarea name="text" rows="20" cols="100"></textarea>

            <p><input type="submit" value="<fmt:message key="index.submit"/>" class="btn btn-default"/></p>
        </form>
    </div>
    </body>
    </html>
</fmt:bundle>