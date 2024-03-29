<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css?ver=1">
</head>
<body>
<h3> 수강 신청할 예상 교과목</h3>
<sf:form method="post"
		action="${pageContext.request.contextPath}/docreate"
		modelAttribute="newoffer">
		<table class="formtable">
			<tr>
				<td class="label">수강년도</td>
				<td><sf:input class="control" type="text" path="year" /> 
					<sf:errors path="year" class="error" />
				</td>
			</tr>

			<tr>
				<td class="label">학기:</td>
				<td><sf:input class="control" type="text" path="semester" />
					<sf:errors path="semester" class="error" />
				</td>
			</tr>
			<tr>
				<td class="label">교과목명:</td>
				<td><sf:input class="control" type="text" path="classname" />
					<sf:errors path="classname" class="error" />
				</td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input class="control" type="submit" value="저장" /></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>