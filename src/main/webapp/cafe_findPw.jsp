<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>비밀번호 찾기</title>
<link rel="stylesheet" type="text/css" href="./css/cafe_findPw.css">
 
</head>
 	<c:set var="id" value="${sessionScope.id }" />

<c:choose>
 	<c:when test="${not empty id}">
		<c:when test="${empty question}">
			<script>
				alert('계정 찾기용 질문이 없습니다. 관리자에게 문의해주세요.')
				location.href="cafe_proj_cafeMain.jsp";
			</script>
		</c:when>
	</c:when>
</c:choose>

<body>
 	<section class="whole">  
        <div>     
			<img id="backgroundImg" alt="#" src="./image_src/joinToCafe/beach-ga885d0fde.jpg" />
        </div>
  	</section>
    <div class="top">        
            <div id="gnl">
                <!-- 상단 통합 메뉴 공간 -->
                <ul>
                    <li id="goToCafeHome"><a href="cafe_proj_cafeMain.jsp">카페 홈</a> </li>
                    <li id="goToMainSite"><a href="#">메인 포털 사이트</a> </li>               
                </ul>
            </div>
    </div>
    <section>
    <section class="join_window">
	<form action="findIdOrPw?mode=2" method="post" name="findPwForm" accept-charset="utf-8">
		<table id="findPwTable">
			<caption>비밀번호 찾기</caption>
			<tr>
				<td>아이디</td><td><input type="text" name="id" id="id" placeholder="아이디" value="${id }" required /></td>
				
			</tr>
			<tr>
				<td>계정 찾기 질문</td>
				<td>			
					<select name="question" required id="questionSelect">
						<option value="졸업한 초등학교는?">졸업한 초등학교는?</option>
						<option value="내게 가장 소중한 보물은?">내게 가장 소중한 보물은?</option>
						<option value="가장 좋아하는 동물은?">가장 좋아하는 동물은?</option>
					</select>
				</td>
				
			</tr>
			<tr>
				<td>계정 찾기 정답 &nbsp;</td>
				<td><input type="text" name="answer" id="answer" placeholder="정답을 입력해주세요" required/></td>
			</tr>			
			<tr>
				
				<td colspan="2">
					<a href="cafe_findId.jsp"><input type="button" value="아이디 찾기" /></a>
					<a href="startMain.jsp"><input type="button" value="메인으로" /></a>
					<input type="submit" value="확인" />
				</td>
			</tr>
				
		</table>
		</form>
	 </section>
	</section>
</body>
</html>