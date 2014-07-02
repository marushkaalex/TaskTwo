<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 02.07.14
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<pre>
    <c:forEach items="${par.getSentences()}" var="item">
        <c:out value="${item.toString()}"/>
    </c:forEach>
</pre>
</body>
</html>
