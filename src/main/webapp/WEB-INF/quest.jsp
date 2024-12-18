<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="parts/header.jsp" %>
<body>
<h1>Квест</h1>
<p>${question}</p>
<c:if test="${not empty imageUrl}">
<img src="${imageUrl}" alt="Quest Image" class="img-fluid mb-3" style="width: 700px; height: auto;">
</c:if>
<form action="quest" method="post">
  <c:forEach items="${options}" var="option" varStatus="status">
    <input type="radio" name="answer" value="${option}" ${status.index == 0 ? 'checked' : ''}>${option}<br>
  </c:forEach>
  <input type="submit" value="Ответить">
</form>
<%@include file="parts/footer.jsp" %>