<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- Map 선언 -->
<c:set var="mapTest" value="<%=new HashMap<String, String>()%>" />

<!-- Map 에 값 넣기 -->
<c:set target="${mapTest}" property="key1" value="value1" />
<c:set target="${mapTest}" property="key2" value="value2" />

${mapTest.key1}<!-- value1 이 출력됨 -->
${mapTest.key2}<!-- value2 이 출력됨 -->
<c:forEach var="mapTest" items="${mapTest}">
${mapTest.key}<!--  key1, key2 ... 이 출력됨 -->
${mapTest.value}<!--  value1, value2 ... 이 출력됨 -->
</c:forEach>
</body>
</html>