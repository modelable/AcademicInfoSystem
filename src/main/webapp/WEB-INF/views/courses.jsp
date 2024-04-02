<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table>
    <thead>
    <tr>
        <th>년도</th>
        <th>학기</th>
        <th>취득 학점</th>
        <th>상세보기</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="ysc" items="${id_yearsemestercredit}">
        <tr>
            <td style="text-align: center;"><c:out value="${ysc[0]}"/></td>
            <td style="text-align: center;"><c:out value="${ysc[1]}"/></td>
            <td style="text-align: center;"><c:out value="${ysc[2]}"/></td>
            <td style="text-align: center;">
                <a href="${pageContext.request.contextPath}/courses/${ysc[0]}/${ysc[1]}">상세보기</a>
            </td>
        </tr>
    </c:forEach>
        <tr>
            <th>총계</th>
            <th></th>
            <th>${id_totalcredit}</th>
            <th></th>
        </tr>
    </tbody>
</table>
