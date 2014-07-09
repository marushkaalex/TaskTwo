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
            <button name="home" type="button" class="btn btn-default">home</button>
        </a>

        <h1><fmt:message key="result.original"/></h1>

        <div class="original_text"><p><c:forEach items="${text.getParagraphs()}" var="item"><c:out
                value="${item.toOriginal()}"/><br>
        </c:forEach>
        </p>
        </div>
        <h1><fmt:message key="result.parsed.text"/></h1>
        <pre><c:out value="${text.toString()}"/></pre>
        <h1>sortSentencesByWordsCount</h1>
        <pre><c:out value="${logic.sortSentencesByWordsCount(text).toString()}"/></pre>
        <h1>findNonRecurringWords</h1>
        <pre><c:out value="${logic.findNonRecurringWords(text).toString()}"/></pre>
        <h1>findWordsByLength(text, 2, 5)</h1>
        <pre><c:out value="${logic.findWordsByLength(text, 2, 5).toString()}"/></pre>
        <h1>swapSentencesFirstAndLastWord</h1>
        <pre><c:out value="${logic.swapSentencesFirstAndLastWord(text).toOriginal()}"/></pre>
        <h1>getWordsSortedByLettersAsParagraph</h1>
        <pre><c:out value="${logic.getWordsSortedByLettersAsParagraph(text)}"/></pre>
        <h1>sortWordsByVowelsCount</h1>
        <c:set var="words" value="${logic.getWords(text)}" scope="session"/>
        <c:set var="vowelWords" value="${logic.getWordsBeginningWith(true, words)}" scope="session"/>
    ${logic.sortWordsByVowelsCount(words)}
            ${logic.sortWordsAlphabeticallyBySecondLetter(true, vowelWords)}
        <pre><c:out value="${words}"/></pre>
        <h1>sortWordsAlphabeticallyBySecondLetter</h1>
        <pre><c:out value="${vowelWords}"/></pre>
        <h1>sortByLetterPerWord('а')</h1>
            ${logic.sortByLetterPerWord('а', words)}
        <pre><c:out value="${words}"/></pre>
        <h1>countWordsUsages</h1>
        <pre><c:out value="${logic.countWordsUsages(text, \"не\", \"о\", \"по\")}"/></pre>

    </div>
    </body>
    </html>
</fmt:bundle>
