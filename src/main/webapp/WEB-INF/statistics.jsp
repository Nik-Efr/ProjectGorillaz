<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Статистика пользователей</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@5.3.3/dist/superhero/bootstrap.min.css">
</head>
<body>
<jsp:include page="/WEB-INF/parts/header.jsp"/>
<div class="container mt-5">
    <h2>Статистика пользователей</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Логин</th>
            <th>Победы</th>
            <th>Поражения</th>
            <th>Всего игр</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="stat" items="${statistics}">
            <tr>
                <td>${stat.login}</td>
                <td>${stat.wins}</td>
                <td>${stat.losses}</td>
                <td>${stat.wins + stat.losses}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<jsp:include page="/WEB-INF/parts/footer.jsp"/>
</body>
</html>