<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Web Framework HW1</title>
</head>
<body>
<table border="1">
  <tr>
    <th colspan="3">메뉴</th>
  </tr>
  <tr>
    <td>
      <form action="${pageContext.request.contextPath}/courses" method="get">
        학년별 이수 학점 조회<br>
        <button type="submit">submit</button>
      </form>
    </td>
    <td>
      <form action="${pageContext.request.contextPath}/registcourse" method="get">
        수강 신청하기<br>
        <button type="submit">submit</button>
      </form>
    </td>
    <td>
      <form action="${pageContext.request.contextPath}/registrations" method="get">
        수강 신청 조회<br>
        <button type="submit">submit</button>
      </form>
    </td>
  </tr>
</table>

<!-- login button -->
<c:if test="${pageContext.request.userPrincipal.name == null}">
  <form action="${pageContext.request.contextPath}/login" method="get">
    <button type="submit">Login</button>
  </form>
</c:if>

<!-- logout button -->
<c:if test="${pageContext.request.userPrincipal.name != null}">
  <form id="logout" action="${pageContext.request.contextPath}/logout" method="post">
    <button type="submit">Logout</button>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  </form>
</c:if>

</body>
</html>
