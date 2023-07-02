<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% pageContext.setAttribute("nameList4", "홍길동, 임꺽정, 일지매, 주먹대장, 똘이장군"); %>
<ul>
<c:forEach var="name" items="${nameList4}">
	<li>${name}</li>
</c:forEach>
</ul>
</body>
</html>