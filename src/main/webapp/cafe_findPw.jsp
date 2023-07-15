<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��й�ȣ ã��</title>
<link rel="stylesheet" type="text/css" href="./css/cafe_findPw.css">
 
</head>
 	<c:set var="id" value="${sessionScope.id }" />

<c:choose>
 	<c:when test="${not empty id}">
		<c:when test="${empty question}">
			<script>
				alert('���� ã��� ������ �����ϴ�. �����ڿ��� �������ּ���.')
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
                <!-- ��� ���� �޴� ���� -->
                <ul>
                    <li id="goToCafeHome"><a href="cafe_proj_cafeMain.jsp">ī�� Ȩ</a> </li>
                    <li id="goToMainSite"><a href="#">���� ���� ����Ʈ</a> </li>               
                </ul>
            </div>
    </div>
    <section>
    <section class="join_window">
	<form action="findIdOrPw?mode=2" method="post" name="findPwForm" accept-charset="utf-8">
		<table id="findPwTable">
			<caption>��й�ȣ ã��</caption>
			<tr>
				<td>���̵�</td><td><input type="text" name="id" id="id" placeholder="���̵�" value="${id }" required /></td>
				
			</tr>
			<tr>
				<td>���� ã�� ����</td>
				<td>			
					<select name="question" required id="questionSelect">
						<option value="������ �ʵ��б���?">������ �ʵ��б���?</option>
						<option value="���� ���� ������ ������?">���� ���� ������ ������?</option>
						<option value="���� �����ϴ� ������?">���� �����ϴ� ������?</option>
					</select>
				</td>
				
			</tr>
			<tr>
				<td>���� ã�� ���� &nbsp;</td>
				<td><input type="text" name="answer" id="answer" placeholder="������ �Է����ּ���" required/></td>
			</tr>			
			<tr>
				
				<td colspan="2">
					<a href="cafe_findId.jsp"><input type="button" value="���̵� ã��" /></a>
					<a href="startMain.jsp"><input type="button" value="��������" /></a>
					<input type="submit" value="Ȯ��" />
				</td>
			</tr>
				
		</table>
		</form>
	 </section>
	</section>
</body>
</html>