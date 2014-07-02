<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:bundle basename="i18n.messages">

    <html>
    <head>
        <title></title>
    </head>
    <body>
    <form action="${pageContext.request.contextPath}/strings" method="post">
        <textarea name="text" rows="30" cols="100">
        <%@include file="WEB-INF/text.txt"%>
        </textarea>
        <input type="submit" value="<fmt:message key="index.submit"/>"/>
    </form>

    </body>
    </html>
</fmt:bundle>