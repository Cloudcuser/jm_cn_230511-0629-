<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h3>값 설정 방식</h3>
<c:set var="username1" value="홍길동"/>
<c:set var="username2">임꺽정</c:set>
1 ${username1}<br/>
2 ${username2}<br/>

<h3>기본 보관소 - page</h3>
3 ${pageScope.username1}<br/>
4 ${requestScope.username2}<br/>

<h3>보관소 지정 - scope 속성</h3>
<c:set var="username3" scope="request">일지매</c:set>
5 ${pageScope.username3}<br/>
6 ${requestScope.username3}<br/>

<h3>기존의 값 덮어씀</h3>
<% pageContext.setAttribute("username4", "똘이장군"); %>
7 기존 값=${username4}<br>
<c:set var="username4" value="주먹대장"/>
8 덮어쓴 값 = ${username4}<br/>
</body>
</html>