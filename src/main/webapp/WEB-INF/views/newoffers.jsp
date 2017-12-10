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
	희망하는 수강신청 내역입니다.
	<table class="formtable">

		<tr>
			<td>년도</td>
			<td>학기</td>
			<td>교과목명</td>
		</tr>
	</table>
	<table class="formtable">
		<c:forEach var="newoffer" items="${newoffers}">
			<tr>
				<td>${newoffer.year}</td>
				<td>${newoffer.semester}</td>
				<td>${newoffer.classname}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>