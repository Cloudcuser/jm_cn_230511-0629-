<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	RequestDispatcher dispatcher = request.getRequestDispatcher("InitDataTocafeMain");
	System.out.println("start:"+session.getAttribute("cNickname"));
	
	dispatcher.forward(request, response);
%>
</body>
</html>