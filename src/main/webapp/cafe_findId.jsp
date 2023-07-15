<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���̵� ã��</title>
    <link rel="stylesheet" type="text/css" href="./css/cafe_findId.css">
</head>
<body>

<section class="whole">  
        <div>     
            <img id="backgroundImage" alt="#" src="./image_src/joinToCafe/beach-ga885d0fde_1920.jpg" />
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
			<form action="findIdOrPw?mode=1" method="post" name="findIdForm" accept-charset="utf-8">
			<table id="findIdTable">
				<caption>���̵� ã��</caption>	
				<tr>
					<td>����</td>
					<td><input type="text" name="nName" id="nName" placeholder="����" required /></td>
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
					<td><input type="text" name="answer" id="answer" placeholder="������ �Է����ּ���" required /></td>
				</tr>			
				<tr>
					
					<td colspan="2">
						<a href="cafe_findPw.jsp"><input type="button" value="��й�ȣ ã��" /></a>
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