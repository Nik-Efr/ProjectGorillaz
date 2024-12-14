<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Квест - Начало</title>
</head>
<body>
<h1>Добро пожаловать в квест!</h1>

<c:if test="${empty content}">
    <p>Готовы начать приключение?</p>
    <form action="start-page" method="get">
        <input type="hidden" name="action" value="start">
        <input type="submit" value="Начать квест">
    </form>
</c:if>

<c:if test="${not empty content}">
    <p>${content}</p>
    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>
    <form action="start-page" method="get">
        <input type="hidden" name="action" value="setName">
        <label for="playerName">Ваше имя:</label>
        <input type="text" id="playerName" name="playerName" required>
        <input type="submit" value="Продолжить">
    </form>
</c:if>
</body>
</html>