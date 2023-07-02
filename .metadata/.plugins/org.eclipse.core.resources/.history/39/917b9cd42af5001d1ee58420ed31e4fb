<%@page import="java.util.ArrayList"%>
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
<%
ArrayList<String> nameList3 = new ArrayList<String>();
nameList3.add("홍길동");
nameList3.add("임꺽정");
nameList3.add("일지매");
nameList3.add("주먹대장");
nameList3.add("똘이장군");
pageContext.setAttribute("nameList3", nameList3);
%>
<ul>
<c:forEach var="name" items="${nameList3}">
	<li>${name}</li>
</c:forEach>
</ul>
</body>
</html>