<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:bundle basename="i18n.messages">
    <html>
    <head>
        <title></title>
        <link rel="stylesheet" href="webjars/bootstrap/3.2.0/css/bootstrap.css">
        <style>
            .original_text {
                margin: 5px;
                padding: 15px;
                border-radius: 10px;
                background-color: #efefef;
            }

            h1 {
                margin-left: 20px;
            }

            #wrapper {
                width: 500px;
                margin: 0 auto;
            }
        </style>
    </head>
    <body>
    <div class="container">
        <a href="index.jsp">
            <button type="button" class="btn btn-default">home</button>
        </a>

        <h1><fmt:message key="result.original"/></h1>

        <div class="original_text">
            <p>
                <c:forEach items="${par.getSentences()}" var="item">
                    <c:out value="${item.toOriginal()}"/>
                </c:forEach>
            </p>
        </div>
        <h1><fmt:message key="result.parsed.text"/></h1>

        <div>
<pre>
    <c:forEach items="${par.getSentences()}" var="item">
        <c:out value="${item.toString()}"/>
    </c:forEach>
</pre>
        </div>
    </div>
    </body>
    </html>
</fmt:bundle>