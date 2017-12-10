<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css?ver=1">

</head>
<body>

	<table class="formtable">
		<tr>
			<td >교필</td>
			<td >핵A</td>
			<td >핵B</td>
			<td>전지</td>
			<td>전기</td>
			<td >전선</td>
			<td>총학점</td>
		</tr>
	</table>
	<table class="formtable">
		<c:forEach var="offer2" items="${offers2}">
			<tr>
				<td>${offer2.necessary}</td>
				<td>${offer2.mainpointA}</td>
				<td>${offer2.mainpointB}</td>
				<td>${offer2.major_appointed}</td>
				<td>${offer2.major_foundation}</td>
				<td>${offer2.major_select}</td>
				<td>${offer2.total_grade}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>