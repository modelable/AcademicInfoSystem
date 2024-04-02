<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show registrations</title>
</head>
<body>
<table>
    <thead>
        <tr>
            <th>수강년도</th>
            <th>학기</th>
            <th>교과목명</th>
            <th>교과구분</th>
            <th>담당교수</th>
            <th>학점</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="registration" items="${id_registrations}">
        <tr>
            <td><c:out value="${registration.courseYear}"/></td>
            <td><c:out value="${registration.semester}"/></td>
            <td><c:out value="${registration.courseName}"/></td>
            <td><c:out value="${registration.courseType}"/></td>
            <td><c:out value="${registration.professor}"/></td>
            <td><c:out value="${registration.credit}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
