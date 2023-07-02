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
<% pageContext.setAttribute("nameList", new String[] {"홍길동", "임꺽정", "일지매"}); %>
<ul>
<c:forEach var="name" items="${nameList}">
	<li>${name}</li>
</c:forEach>
</ul>
</body>
</html>