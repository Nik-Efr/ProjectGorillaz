<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="head.jsp"%>
<body>
<h1>Квест</h1>
<p>${question}</p>
<form action="quest" method="post">
  <c:forEach items="${options}" var="option" varStatus="status">
    <input type="radio" name="answer" value="${option}" ${status.index == 0 ? 'checked' : ''}>${option}<br>
  </c:forEach>
  <input type="submit" value="Ответить">
</form>
</body>
</html>