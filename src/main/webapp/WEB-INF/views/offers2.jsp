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
			<td width=100>교필</td>
			<td width=100>핵A</td>
			<td width=100>핵B</td>
			<td width=100>전지</td>
			<td width=100>전기</td>
			<td width=100>전선</td>
			<td width=100>총학점</td>
		</tr>
	</table>
	<table class="formtable">
		<c:forEach var="offer2" items="${offers2}">
			<tr>
				<td width=100>${offer2.necessary}</td>
				<td width=100>${offer2.mainpointA}</td>
				<td width=100>${offer2.mainpointB}</td>
				<td width=100>${offer2.major_appointed}</td>
				<td width=100>${offer2.major_foundation}</td>
				<td width=100>${offer2.major_select}</td>
				<td width=100>${offer2.total_grade}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>