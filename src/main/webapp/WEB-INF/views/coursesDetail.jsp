<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table>
    <thead>
    <tr>
        <th>수강년도</th>
        <th>학기</th>
        <th>교과코드</th>
        <th>교과목명</th>
        <th>교과구분</th>
        <th>담당교수</th>
        <th>학점</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="course" items="${id_courses}">
        <tr>
            <td><c:out value="${course.courseYear}"/></td>
            <td><c:out value="${course.semester}"/></td>
            <td><c:out value="${course.courseCode}"/></td>
            <td><c:out value="${course.courseName}"/></td>
            <td><c:out value="${course.courseType}"/></td>
            <td><c:out value="${course.professor}"/></td>
            <td><c:out value="${course.credit}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

