<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:bundle basename="i18n.messages">

    <html>
    <head>
        <link rel="stylesheet" href="webjars/bootstrap/3.2.0/css/bootstrap.css">
        <title></title>
    </head>
    <body>
    <form action="${pageContext.request.contextPath}/strings" method="post">
        <textarea name="text" rows="30" cols="100">
        <%@include file="WEB-INF/text.txt"%>
        </textarea>
        <input type="submit" value="<fmt:message key="index.submit"/>"/>
        <button type="button" class="btn btn-default btn-lg">
            <span class="glyphicon glyphicon-star"></span> Star
        </button>
    </form>
    </body>
    </html>
</fmt:bundle>