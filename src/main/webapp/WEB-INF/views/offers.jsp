<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
	<table class="formtable">
		<tr>
			<td width=100>년도</td>
			<td width=100>학기</td>
			<td>이수학점</td>
			<td>상세보기</td>
		</tr>
	</table>
	<table class="formtable">
		<c:forEach var="offer" items="${offers}">
			<tr>
				<td width=100>${offer.year}</td>
				<td width=100>${offer.semester}</td>
				<td width=100>${offer.grade}</td>
				<td width=100><a href="${pageContext.request.contextPath}/link">링크</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>