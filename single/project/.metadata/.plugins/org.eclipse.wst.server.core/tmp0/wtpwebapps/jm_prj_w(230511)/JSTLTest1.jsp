<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:out value="안녕하세요!"/><br/>
<c:out value="${null}">반갑습니다.</c:out><br/>
<c:out value="안녕하세요!">반갑습니다.</c:out><br/>
<c:out value="${null }" default="디폴트 값"/><br/>
<c:out value="${null}"/><br/>
</body>
</html>