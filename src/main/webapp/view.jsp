<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%		
	String mCnt = (String)session.getAttribute("mCnt");
	String adminName = (String)session.getAttribute("adminName");
			
	System.out.println("==========");
	System.out.println("listMain");
%>

<c:set var="aId" value="${sessionScope.id }"/>
<c:set var="aNickname" value="${sessionScope.nickname }"/>
<c:set var="chName" value="${sessionScope.cNickname }" />
<c:set var="isStaff" value="${priv }" />

<c:choose>
	<c:when test="${empty groupNo }">
		<c:set var="groupNo" value="${0}" scope="session" />
	</c:when>
	<c:when test="${empty subNo }">
		<c:set var="subNo" value="${0}" scope="session" />
	</c:when>
	<c:when test="${empty indentNo }">
		<c:set var="indentNo" value="${0}" scope="session" />
	</c:when>
</c:choose>
<c:choose>
	<c:when test="${empty isStaff}">
		<c:set var="isStaff" value="0"/>
	</c:when>
	<c:when test="${isStaff eq 1 }">
		<c:set var="isStaff" value="${no}"/>
	</c:when>
	<c:when test="${isStaff eq 2 }">
		<c:set var="isStaff" value="staff"/>
	</c:when>	
</c:choose>
<c:if test="${empty hitCount}">
	<c:set var="hitCount" value="-3"/>
</c:if>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"><meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>ShowPostList</title>
	
	<script src="./js/jquery-3.6.4.js"></script>
	<script src="./js/view.js"></script>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

	<link rel="stylesheet" type=text/css href="./css/view.css">
	<link href="https://fonts.googleapis.com/css2?family=Alkatra&display=swap" rel="stylesheet">
	
<title>view post</title>
<style>
	a{
		text-decoration: none;
	}
</style>
</head>

<body>



    <div class="top">
        <div id="music_player">
            <audio src="audio_src/Kalimba.mp3" controls></audio>
            <!-- 오디오 플레이어 -->
           </div>
            <div id="gnl">
                <!-- 상단 통합 메뉴 공간 -->
                <ul>
                    <li id="goToCafeHome"><a href="startMain.jsp">카페 홈</a> </li>
                    <li id="goToMainSite"><a href="#">메인 포털 사이트</a> </li>               
                </ul>
            </div>
    </div>
    <header>
        <!-- 맨 윗부분 -->
       
        <div id="title">
            <!-- 로고 타이틀-->
            <!-- 누르면 메인 홈으로 이동 -->
            <div id="title_text"> All Animals World</div>
            <a href="cafe_proj_cafeMain.jsp" id="logo" title="home"></a>
            
        </div>
    </header>
    <nav>
        <!-- 왼쪽 부분 메뉴 공간 -->
        <div class="cafe_mainMenu">
            <!--카페 프로필 & 카페 관리 & 회원가입 & 글쓰기  -->
            <div class="cafe_profile">                
                <!-- 카페 프로필 공간 -->
                <div id="cafeName">카페 이름: All Animals Worlds</div> 
                <!-- 카페 등급 이미지 -->
                <!-- 누르면 현재 등급 전체 카페 등급 화면 표시 -->
                <div id="curCafeGrade">카페 등급</div>
                <!-- 회원 등급 이미지 -->
                <!-- 누르면 현재 등급 전체 회원 등급 화면 표시 -->
                <div id="managersName">매니저 : ${adminName}</div>
                <!-- 왼쪽에 사람 아이콘 이미지 -->
                <div id="countMembers">회원 수 : ${mCnt}명</div>
                <!-- 설정 아이콘 이미지 -->
<c:choose>
	<c:when test="${isStaff eq 'staff' }">
		<a href="cafe_pro_cafeAdmin.html" id="admin_Cafe">카페 관리 </a> 
	</c:when>	
	<c:otherwise>
		<a href="cafe_pro_cafeAdmin.html" id="admin_Cafe"> </a> 
	</c:otherwise>
</c:choose>
               

                <!-- 카페 대표 이미지 설정 기능 -->
                <!-- 카페 도메인 변경 기능 -->
                <!-- 카페 활동, 회원별, 게시판별 활동 추이 화면 -->
                <!-- 게시판 추가 삭제 수정 등 편집 기능 -->
                <!-- 회원 등급 조정 기능 / 스탭 권한 편집 기능  -->
                <!-- 카페 디자인 편집 기능(템플릿 저장 기능 포함) -->
                <!-- 카페 레이아웃 편집-->
                <!-- <a href="cafe_pro_cafeChatting.html" id="CafeChat">카페 채팅 </a>
                채팅방 설정(개설 & 편집 & 인원 수 설정)
                <a href="cafe_pro_InviteToCafe.html" id="InviteToCafe">카페 초대</a>  -->
            	<div id="profile_menubar">
            </div>
                <ul class="memberMenu">
<c:choose>
	<c:when test="${empty aId}">
					<li>
                    	<a href="cafe_pro_logIn.html" id="logIn">로그인</a>
                    </li>                                    	
                    <li>
                        <a href="cafe_pro_joinToCafe.html" id=joinToCafe>회원 가입</a>
                    </li>
	</c:when>
	<c:when test="${not empty chName}" >
	<li id="markNickname" style="text-align:center">
						${chName}님 환영합니다.
					</li><br>					
					<li>
						<a href="cafe_logOut" id="logOut">로그아웃</a>
					</li>
					<li>
						<a href="cafe_pro_PWPass_info.jsp?mode=editInfo" id="infoEdit">회원 정보 수정</a>
					</li>
					
					
	</c:when>
	<c:when test="${not empty aId || empty chName }">
					<li id="markNickname" style="text-align:center">
						${aNickname}님 환영합니다.
					</li><br>					
					<li>
						<a href="cafe_logOut" id="logOut">로그아웃</a>
					</li>
					<li>
						<a href="cafe_pro_PWPass_info.jsp?mode=editInfo" id="infoEdit">회원 정보 수정</a>
					</li>
					<br>					
					<li>
						<a href="myInfoOK" id="myInfo">내 정보 보기</a>
					</li>
	</c:when>
	
</c:choose>      
                </ul>                                
                <!-- 펜 이미지 -->
<c:choose>
	<c:when test="${not empty aId}">
		<div><a href="cafe_pro_newPosting.jsp" id="newPosting">카페 글쓰기</a> </div>
	</c:when>
	<c:when test="${empty aId}">
		<div><a href="cafe_pro_newPosting.jsp" id="newPosting"></a> </div>
	</c:when>
	
</c:choose>
               <!--  <div><a href="cafe_pro_newPosting.jsp" id="newPosting">카페 글쓰기</a> </div> -->
                <!-- 게시글 레이아웃 편집 기능 필요(템플릿 저장 기능 포함) -->                            
            </div>       
        <div class="table_menu">
            <!-- 게시판 메뉴 공간 -->           
            <!-- 게시판 그룹 접기 열기 기능 필요 -->
            <!-- 구분 선 넣기 필요 -->
            <!-- 상위 게시판, 하위 게시판, 게시판 순서 편집 기능 -->
            <div id="showAllPost"><a href="showList.do">전체 글 보기</a>   </div>
            <div id='table_menubar'></div>
            <ul id="opearateMenu"> 
				<li id="opearateMenu_head"><c:out value="운영 메뉴" /><br></li>
                <li id="notice_boardSet" value="공지" class="tableMenuBtn"><img src="./image_src/showAllPost/black-circle-g15db91f27_640.png" alt="#" id="listImg" />공지 게시판<br></li>
                <li id="report_boardSet" value="신고" class="tableMenuBtn"><img src="./image_src/showAllPost/black-circle-g15db91f27_640.png" alt="#" id="listImg" />신고 게시판<br></li>                    
                <li id="warning_boardSet" value="경고" class="tableMenuBtn"><img src="./image_src/showAllPost/black-circle-g15db91f27_640.png" alt="#" id="listImg" />경고 게시판 <br></li>
            </ul>
            <ul id="active_boardMenu"> 
				<li id="active_boardMenu_head"><c:out value="게시판 메뉴"/><br></li>      
                <li id="normal_boardSet" value="일반" class="tableMenuBtn"><img src="./image_src/showAllPost/black-circle-g15db91f27_640.png" alt="#" id="listImg" />일반 게시판 <br></li>                
                <li id="memo_boardSet" value="메모" class="tableMenuBtn"><img src="./image_src/showAllPost/black-circle-g15db91f27_640.png" alt="#" id="listImg" />메모 게시판 <br></li>
                    <!-- 글 양식 편집 기능 -->
            </ul>               
                <!-- 게시판 추가 기능은 자바스크립트 함수로 구현하기 -->            
        </div>        
        <!-- <aside>
            <div style="text-align: center;">(wiget place)</div> 
            추가 메뉴 혹은 위젯 공간(레이아웃 편집 기능으로 변경 가능)
            시계 위젯
            방문자 집계 위젯
            최근 게시글 목록
            visitor / calender / clock / etc..
            <form action="searchData">
            	<div class="search">
                	검색 <input type="text" placeholder="검색할 내용을 입력하세요">
            		<input type="submit" value="검색" id="searchBtn" />
            	</div>
            </form>
        </aside> -->
        <div>
			<c:choose>
        		<c:when test="${not empty aId}">
		            <button id="QuitToCafe">카페 탈퇴</button>		            
        		</c:when>
				<c:when test="${empty aId }">
					<button id="QuitToCafe" style="display:none">카페 탈퇴</button>
				</c:when>
        	 </c:choose>
        </div>
    </nav>
	<section class="showAllPost_window">
	<div class="tableWindow">
	<c:choose>
		<c:when test="${contentNo eq contentFirstNo }">
			<a href="view.do?no=${contentLastNo}"><button id="movePrivPostBtn" >이전 글</button></a>
		</c:when>
		<c:otherwise>
			<a href="view.do?no=${contentNo-1}"><button id="movePrivPostBtn" >이전 글</button></a>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${contentNo eq contentLastNo }">
			<a href="view.do?no=${contentFirstNo}"><button id="moveNextPostBtn" >다음 글</button></a>
		</c:when>
		<c:otherwise>
			<a href="view.do?no=${contentNo+1}"><button id="moveNextPostBtn" >다음 글</button></a>
		</c:otherwise>
	</c:choose>
	<a href="#"><button id="rePlyPostBtn">답글 달기</button></a>
		<hr />
			<div id="tableRemote">		
					<img src="./image_src/showAllPost/dolphin-g4b22bff55_1920-removebg-preview.png" alt="#" id="titleImage" />
					<a href="#" id="remoteMilestone"><c:out value="${subTableTag }"></c:out> 게시판</a>
					<c:choose>
						<c:when test="${ id eq table_id}">
							<a href="#"><input type="button" value="수정" onclick="isOK(1)" id="remoteBtn"/></a>
							<a href="#"><input type="button" value="삭제" onclick="isOK(2)" id="remoteBtn"/></a>
						</c:when>
					</c:choose>
					
					<!-- <a href="#"> <input type="button" value="삭제" id="remoteBtn"></a>	
					<a href="#"> <input type="button" value="수정" id="remoteBtn"></a> -->
					<a href="startMain.jsp"> <input type="button" value="메인" id="remoteBtn"></a>	
					<a href="showList.do"> <input type="button" value="목록" id="remoteBtn"></a>
			</div>
			<hr/>	
			<div id="postInfoBox">
				&nbsp; ${ contentNo }번 &nbsp; |	
				&nbsp; 작성자: <a href="#" id="postWriter"> ${writer }</a>  <!--  누르면 작성자가 쓴 글 목록으로.-->
				| &nbsp; 작성일: <c:out value="${writtenDate }" />
				<c:if test="${empty readCnt }" >
					&nbsp; | &nbsp; 조회수: <c:out value="1"/>
				</c:if>
				<c:if test="${not empty readCnt }">
					&nbsp; | &nbsp; 조회수: <c:out value="${readCnt+1 }"/>
					<!-- 업데이트 전 조회수를 가져옴. 게시글을 봄으로써 조회수 1이 증가했다는 걸 표시-->
				</c:if>
			</div>
			<hr />
			<div id="postTitle">
				<ul>
					<li id="postTitleBox">[${extraTag}] ${ title}</li>
						<c:choose>
							<c:when test="${priv eq 2 }">
									<li><a href="#"><input type="button" value="스탭용 삭제" onclick="isOK(3)" id="staff_delBtn"/></a>
							</c:when>
						</c:choose>
					<!-- <a href="#"><input type="button" value="스탭용 삭제" id="staff_delBtn"></a></li> -->
				</ul>
			</div>
			<hr />
			<div id="postTexts">
				<textarea rows="40" cols="85"  id="postTextsArea" readonly="readonly" > ${ texts}</textarea>
			</div>
			<hr/>
			
			
			<div id="hitAndCommentBar">
				<c:choose>
					<c:when test="${isHit ne 0}">
						<div id="hitBox"> 
							<ul>
								<li>&nbsp;<input type="checkbox" value="공감버튼" id="hitBtn" /></li>
								
								<li><label for="hitBtn" id="hitBtnLabel"><img src="./image_src/showAllPost/lama-g8860e410c_1280-removebg-preview_bw.png" alt="Good" id="hitImg" /></label></li>
								<c:choose>
									<c:when test="${hitCount eq -1}">
										<li id="hitCountBox">공감 수 : <c:out value="${hitCount+1}"/></li>
									</c:when>
									<c:otherwise>
										<li id="hitCountBox">공감 수 : <c:out value="${hitCount}"/></li>
									</c:otherwise>
								</c:choose>
								
							</ul> 	
						</div>
					</c:when>
					<c:otherwise>
						<ul>
							<li id="disabledHitBox"><c:out value="공감 기능이 비활성화된 글입니다."/></li>
						</ul>
					</c:otherwise>
				</c:choose>
				<c:choose>
				
					<c:when test="${comment ne 0}">
						<div id="commentBar">
							<img src="./image_src/showAllPost/diversity-ga9847333f_1280.jpg" alt="Com" id="commentImg"/>
							<ul>
								<c:set var="comCount" value="0" scope="page"></c:set>
								<c:forEach var="boxdto" items="${boxList }">
									<c:set var="comCount" value="${comCount+1}"></c:set>
								</c:forEach>
								<li id="commentCountBox">댓글 수 : <c:out value="${comCount }"/>
								<!-- 댓글 박스 - comment_writer의 수만큼 댓글 수가 됨. -->
								</li>
							</ul>
						</div>
					</c:when>
					<c:otherwise>
						<ul>
							<li id="disabledCommentBox"><c:out value="댓글 기능이 비활성화된 글입니다."/></li>
						</ul>
					</c:otherwise>
				</c:choose>
				<hr/>
				<c:choose>
					<c:when test="${isHit eq 1}">
						<div id="hitListBox">
						<ul>
							<li id="hitListBox">공감한 사람 </li>							
								<c:forEach var="name" items="${hitList }">								
									<c:if test="${name eq 'null'}">										
										
									</c:if>
									<c:if test="${name ne 'null'}">
										<li>${name}</li>
									</c:if>
									<c:set var="items" value="${items}${name}" scope="request" />
								</c:forEach>
						</ul>
						</div>
					</c:when>
					<c:otherwise>
						<ul>
							<li id="disabledHitBox"><c:out value="공감 기능 해제로 비표시"/></li>
						</ul>
					</c:otherwise>
				</c:choose>	
			</div>
			<hr/>
			
			
			<div id="commentList">
				<ul>
					<c:set var="lastGroupNo" value="0"/>
					<c:if test="${not empty boxList }"> <!-- 댓글 리스트 확인 -->
					<c:set var="tempSubNo" value="${boxdto.comment_subNo+1}"/>
						<c:forEach var="boxdto" items="${boxList }">	<!-- 전체 리스트-한 줄씩. -->
							 									
											
											<c:if test="${boxdto.comment_subNo eq 0 }">
												<ul id="commentUl" class="group${boxdto.comment_groupNo}_sub${boxdto.comment_subNo}">
													<c:set var="indCount" value="0" />
													<c:forEach begin="1" end="${boxdto.comment_subNo}" >
																<li><img src="./image_src/showAllPost/app-g05cc8e105_640.png" alt="#" id="subImg" /></li>
													</c:forEach>
													
													<c:choose>
														<c:when test="${boxdto.comment_writer eq writer}">
															<li> ${boxdto.comment_writer} | </li>
															<li id="writerEqCW">작성자 </li>
														</c:when>
														<c:otherwise>
															<li> ${boxdto.comment_writer} | </li>
														</c:otherwise>
	
													</c:choose>											
															<!-- onclick="inputMake('reply')"		 
																onclick="inputMake('modify')" -->									
														<li id="commentDate"> ${boxdto.comment_date}</li>
														<li><input type="button"  value="답글 달기" onclick="inputMake(event)" id="comReplyBtn"></li>
														<c:if test="${boxdto.comment_writer eq nickname }">
															<li><input type="button"  value="수정하기" id="comModifyBtn" onclick="inputModify(event)"></li>
															<li><input type="button"  value="삭제하기" id="comDelBtn" onclick="isDeleteCommentOK(event)"></li>
														</c:if>
														
												</ul>
											</c:if>
											<!-- <script>
														function a(){console.log(""+${tempSubNo}+"/"+${indCount});}
														a();
											</script> -->
											<c:if test="${boxdto.comment_subNo gt 0 }">											
												<c:if test="${boxdto.comment_subNo eq tempSubNo }">													
													<c:set var="tempSubNo" value="${tempSubNo+1}"/>
													<c:set var="indCount" value="0" />
												</c:if>
												
												<c:set var="indCount" value="${indCount+1}" />
												<ul id="commentUl" class="group${boxdto.comment_groupNo}_sub${boxdto.comment_subNo}_${indCount}">													
													<c:forEach begin="1" end="${boxdto.comment_subNo}" >
																<li><img src="./image_src/showAllPost/app-g05cc8e105_640.png" alt="#" id="subImg" /></li>
													</c:forEach>
													
													<c:choose>
														<c:when test="${boxdto.comment_writer eq writer}">
															<li> ${boxdto.comment_writer} | </li>
															<li id="writerEqCW">작성자 </li>
														</c:when>
														<c:otherwise>
															<li> ${boxdto.comment_writer} | </li>
														</c:otherwise>
	
													</c:choose>											
														<li id="commentDate"> ${boxdto.comment_date}</li>
														<li><input type="button"  value="답글 달기" onclick="inputMake(event)" id="comReplyBtn"></li>
														<c:if test="${boxdto.comment_writer eq nickname }">
															<li><input type="button"  value="수정하기" id="comModifyBtn" onclick="inputModify(event)"></li>
															<li><input type="button"  value="삭제하기" id="comDelBtn" onclick="isDeleteCommentOK(event)"></li>
														</c:if>
														
												</ul>
											</c:if>

											
												<c:choose>
													<c:when test="${boxdto.comment_subNo gt 0 }">
														<c:set var="blankLeft" value="${53+(boxdto.comment_subNo*37)}" />
														<ul id="commentSubText" style="margin-left:${blankLeft}px">
															<li> ${boxdto.comment_texts }</li>
														</ul>
														</c:when>
													<c:otherwise>
														<ul id="commentText">
															<li> ${boxdto.comment_texts }</li>
														</ul>
													</c:otherwise>
												</c:choose>
												
													<hr/>
												
													
													<%-- <c:set var="indentLen" value="1" /> --%>
									<c:if test="${boxdto.comment_groupNo gt lastGroupNo }">
										<c:set var="lastGroupNo" value="${lastGroupNo+1 }"/>
										<!-- 마지막 그룹 넘버 계산되는지 출력해볼 것 -->
										<%-- <c:out value="lastNo:${lastGroupNo }" /> --%>
									</c:if>
								</c:forEach> 
							</c:if>									
						<ul id="newCommentBox">
							
						</ul>
						<ul id="newCommentTexts">
						
						</ul>
						
				
				</ul>
				
			</div>
					
				
				<c:choose>
					<c:when test="${comment ne 0}">
					<div>
						<hr/>
					
						${nickname }님<br> <%-- <c:out value="${newBoxdto }" /> --%>	
						<!-- <textarea rows="3" cols="98"  id="postTextsArea"id="commentInputBox" ></textarea> -->				
						<!-- <input type="text" placeholder="댓글을 달아보세요." id="commentInputBox"/> -->
						<textarea rows="3" cols="98"  id="commentInputBox"></textarea>
						<input type="submit" value="등록" id="commentInputBtn"/>
					</div>	
					</c:when>
					<c:otherwise>
						<div>
							
						</div>
					</c:otherwise>
				</c:choose>
				
							
			<img src="./image_src/showAllPost/ladybug-g4d07e2ff5_1280-removebg-preview.png" id="ladybug" alt="#" />
		</div>
			
	</section>
	
	<section class="bottom">
		<img src="./image_src/showAllPost/owl-g7a1ed8deb_1280-removebg-preview.png" alt="#" id="owlPic"/>
	</section>
	
	<!--아래는 데이터 확인용 코드  -->
	
	
	
	 <%-- <section>
		<div>
			<table border="1" id="showAllPostTable">
				<caption>게시글</caption>
				<tr>
					<td colspan="2">
						<a href="showList.do"><input type="button" value="목록으로"/></a> 
						<a href="startMain.jsp"> <input type="button" value="메인으로" /></a>
					접속한 아이디=작성자인 경우 ->
					<c:choose>
						<c:when test="${ id eq table_id}">
							<a href="#"><input type="button" value="수정하기" onclick="isOK(1)"/></a>
							<a href="#"><input type="button" value="삭제하기" onclick="isOK(2)"/></a>
						</c:when>
					</c:choose>
					</td>
				</tr>
				
				<tr>
					<td>권한 확인용 칸(삭제 버튼)</td><td>${priv }->
					<c:choose>
						<c:when test="${priv eq 2 }">
								<a href="#"><input type="button" value="삭제하기" onclick="isOK(3)"/></a>
						</c:when>
					</c:choose>
					</td>
					
				</tr>
				<tr>
					<td>번호 </td><td>${ contentNo }번</td>
				</tr>
				<tr>
					<td>말머리 </td><td>${ extraTag}</td>
				</tr>
				<tr>
					<td>게시판 메뉴 </td><td>${ subTableTag}</td>
				</tr>
				<tr>
					<td>공지 여부 </td><td>[${ isNoticeThisOrAll}]
					  0:없음, 1:게시판, 2:전체</td>
				</tr>
				<tr>
					<td>제목 </td><td>${ title}</td>
				</tr>
				<tr>
					<td>작성자 </td><td>${writer }</td>
				</tr>
				<tr>
					<td>내용</td><td>${ texts}</td>
				</tr>
				<tr>
					<td>공감 여부</td><td>${isHit }</td>
				</tr>
				<tr>		
					<c:choose>
						<c:when test="${empty hitList }">
							<td colspan="2" style="text-align:center">공감 목록 : 비어 있음</td>
						</c:when>
						<c:otherwise>
							<td>${hitList }</td>
						</c:otherwise>
					</c:choose>
				</tr>	
				
				<tr>
					<td colspan="2" style="text-align:center">====댓글 창 표시용====</td>
				</tr>
				<tr>
					<td>현재 접속자의 아이디</td><td>${id }</td>
				</tr>
				<tr>
					<td>댓글 허용 여부</td><td> ${comment }</td>
				</tr>
				<tr>
					<td>댓글 작성자 </td><td> ${nickname }</td>
				</tr>
				<tr>
					<td>댓글 내용 </td><td> ${comment_texts }</td>
				</tr>
				<tr>
					<td>댓글 작성일 </td><td> ${comment_date }</td>
				</tr>
				<tr>
					<td>댓글 그룹 넘버</td><td> ${comment_groupNo }</td>
				</tr>
				<tr>
					<td>댓글 서브 넘버</td><td> ${comment_subNo }</td>
				</tr>
				<tr>
					<td>댓글 들여쓰기 수</td><td> ${comment_indentNo }</td>
				</tr>	
				<tr>
					<td colspan="2" style="text-align:center">=====속성 값 표시용=====</td>
				</tr>
				<tr>			
					<td colspan="2">접속자 별명 : (비활성화)</td>			
				</tr>
				<!-- <tr>
					<td><a href="#"><img alt="#" src="#" id="testImg"></a></td>
				</tr> -->
			</table>
		</div>
	</section> --%>
<script>
      $(document).ready(  function() {
        $('#postTextsArea').summernote(/* { 
         	width:800,
    		height:500,
    		disableResizeEditor: true,
    		} */   'disable' );         
       
    }  ); 
  	
     $(document).ready(textBoxUp);  
  	/* textBoxUp(); */
     function textBoxUp(){
   		$('.note-editable').css("height", "500").css("width","800");
   	};
$(function() {     
  	 function saveComment(){
  		/* alert('댓글 저장 oper');   */		
  		$.ajax({
  			url:"comment.do",
  			type: "get",
  			async: false,
  			data:{
  				commentWriter : '${nickname}',
  				commentTexts : $('#commentInputBox').val(),
  				tableNo : ${ contentNo },
  				comment_groupNo : ${lastGroupNo+1},
  				comment_subNo : ${subNo},
  				comment_indentNo : ${indentNo},
  			},
  			dataType :"text",
  			success : postCommentProcess,
  			error:function(){
  				alert("댓글 저장 요청 실패");
  			}
  		});
  	}
  
  	$("#commentInputBtn").on("click", saveComment);
  	
});
	function postCommentProcess(result){
			alert("댓글 저장 성공");
			waitingBox();
			
			window.location.reload();
		 /* 	newCommentPost(); */
			
	}
 	function waitingBox(){
 		setTimeout(()=> console.log('waiting'), '2000');
 	}
 	/* function clearBox(){
 		let boxPos = document.querySelector("#commentInputBox");
 		boxPos.value="";
 	} */
	function newCommentPost(){
		let textBox = document.querySelector("#newCommentBox");
		alert("새로운 댓글 박스 생성 시작");
		if(textBox != null){
			let i = document.createElement('li');
			i.innerText = '${newBoxdto.comment_writer} |'+" ";
			i.innerhtml = "&nbsp;";
			let j = document.createElement('li');
			j.innerText = '${newBoxdto.comment_date}';
			
			let k = document.createElement('li');
			let l = document.createElement('a');
			k.appendChild(l);
			l.setAttribute("href","#");
			let m = document.createElement('input');
			m.setAttribute('type','button');
			m.setAttribute('onclick','#()');
			m.setAttribute('value','답글 달기');
			m.setAttribute('id','comReplyBtn');
			l.appendChild(m);
	
			textBox.appendChild(i);
			textBox.appendChild(j);
			textBox.appendChild(k);
			
			let testContents = "";
				textContents = document.querySelector('#newCommentTexts');
			if(textContents != null){
				let n = document.createElement('li');				
				n.innerText = '${newBoxdto.comment_texts}';
				textContents.appendChild(n);
			} 
		}
		
	}
	function saveReply(${dataNo}){
  		/* alert('댓글 저장 oper');   */		
  		$.ajax({
  			url:"replycomment.do",
  			type: "get",
  			async: false,
  			data:{
  				commentWriter : '${nickname}',
  				commentTexts : $('#commentInputBoxTemp').val(),
  				tableNo : ${ contentNo },
  				comment_groupNo : dataNo.substring(0,dataNo.indexOf("_")),
  				comment_subNo :  dataNo.substring(dataNo.indexOf("_")+1,dataNo.indexOf("_")+2),
  				comment_indentNo : dataNo.substring(dataNo.indexOf("/")+1),
  			},
  			dataType :"text",
  			success : commentReplyProcess,
  			error:function(){
  				alert("댓글 저장 요청 실패");
  			}
  		});
  	}
	function commentReplyProcess(){
		alert("답글 저장 성공");  			
			waitingBox();
			clearRepBox();
	}
	function clearRepBox(){
		inputMake('off');
		kind=null;
		window.location.reload();
	}
	
	let replyOnOff = 0;
	let dataNo;
	let kind;
	function inputMake(event){
		let replySwitch = false;
		replyOnOff += 1;
		if(replyOnOff %2 !=0){
			console.log("replyOnOff:"+replyOnOff);
			replySwitch = true;
		}
		else{
			replySwitch = false;
		}
		if(replySwitch){
			kind = event.target.parentNode.parentNode.nextElementSibling;
			let pos = event.target.parentNode.parentNode.getAttributeNode("class").value;
			
			console.log("pos :"+pos);
			let gData = pos.indexOf("p");
			let sData = pos.indexOf("sub");
			let group = pos.substring(gData+1,sData-1);
			let sub = pos.substring(sData+3);
			let sub_ex = pos.substring(sData+5);
			if(sub_ex == ""){
				sub_ex = "0";
			}
			/*  console.log("group:"+group);
			console.log("sub:"+sub); */
			console.log("sub_ex:"+sub_ex); 
			
			dataNo = ""+group+"_"+sub+"/"+sub_ex;
			
			/* console.log("g:"+dataNo.substring(0,dataNo.indexOf("_")));
			console.log("s:"+dataNo.substring(dataNo.indexOf("_")+1)); */
			let dataNo2 = ""+group+"_"+sub+"/"+sub_ex;
		 	console.log("se:"+dataNo2.substring(dataNo2.indexOf("/")+1)); 
			
			let br = document.createElement("br");
			kind.appendChild(br);			
			/* console.log("kind:"+kind); */
			
			let a1 = document.createElement('li');				
			
			let a2 = document.createElement('input');
			a2.setAttribute("type","text");
			a2.setAttribute("id","commentInputBoxTemp");
			a2.setAttribute("name","commentInputBoxTemp");
			a2.setAttribute("placeholder","답글 달기");
			
			let a3 = document.createElement("input");
			a3.setAttribute('type','submit');
			a3.setAttribute('id','commentInputBtnTemp');
			
			/* a1.appendChild(b1); */			
			a1.appendChild(a2);
			a1.appendChild(a3)
			kind.appendChild(a1);
			
			/* <c:set var="dataNo" value="$dataNo" scope="request"/>
			/* session.setAttribute("dataNo",dataNo); */
			$("#commentInputBtnTemp").on("click", saveReply);
		}
		else{
			/* window.location.reload(); */
			let temp = kind;
			kind = temp.lastChild;
			console.log(kind);
			kind.remove();
			kind = temp.lastChild;
			console.log(kind);
			kind.remove();
		}
		
	}
	function modifyComment(${dataNo}){
		$.ajax({
  			url:"modifycomment.do",
  			type: "get",
  			async: false,
  			data:{
  				commentWriter : '${nickname}',
  				commentTexts : $('#commentInputBoxModify').val(),
  				tableNo : ${ contentNo },
  				comment_groupNo : dataNo.substring(0,dataNo.indexOf("_")),
  				comment_subNo : dataNo.substring(dataNo.indexOf("_")+1),
  				comment_indentNo : dataNo.substring(dataNo.indexOf("_")+1),
  				privText : tempText,
  				written_date : tempDate,
  			},
  			dataType :"text",
  			success : commentModiProcess,
  			error:function(){
  				alert("댓글 저장 요청 실패");
  			}
  		});
	}
	function commentModiProcess(){
		alert("댓글 수정 성공");
		waitingBox();
		/* inputModify('off'); */
		window.location.reload();
	}
	let modifyOn=0;	
	let tempText;
	let tempDate;
	function inputModify(event){
		
		if(event=='off'){
			modifyOn = 1;
		}
		
		let modifySwitch = false;
		modifyOn += 1;		
		
		if(modifyOn %2 != 0){
			modifySwitch = true;			
		}
		else{
			modifySwitch = false;
		}
		if(modifySwitch){
			/* console.log("modifyOn:"+modifyOn); */
			kind = event.target.parentNode.parentNode.nextElementSibling;
			let pos = event.target.parentNode.parentNode.getAttributeNode("class").value;
			let item = kind.firstElementChild;			
			let itemValue = item.innerText;
			tempDate = event.target.parentNode.previousElementSibling
			.previousElementSibling.textContent;
			/* console.log("tempDate :"+tempDate); */
			
			/* console.log("itemValue:"+itemValue);	 */		
			
			let a = document.createElement("input");
			a.setAttribute('type','text');
			a.setAttribute('value',itemValue);
			a.setAttribute('id','commentInputBoxModify');
			a.setAttribute('name','commentInputBoxModify');
			
			if(itemValue!=null){
				tempText=itemValue;
			}
			
			/* console.log("tempText:"+tempText);		 */	
			item.innerText="";
			item.appendChild(a);
			
			let b = document.createElement("input");
			b.setAttribute('type','submit');
			b.setAttribute('value','수정');
			b.setAttribute('id','commentInputModifyBtn');
			
			item.appendChild(b);
			
			/* console.log("kind: "+kind.value);
			console.log("pos :"+pos);  */
			let gData = pos.indexOf("p");
			let sData = pos.indexOf("sub");
			let group = pos.substring(gData+1,sData-1);
			let sub = pos.substring(sData+3,sData+4);
			
			 console.log("group:"+group);
			console.log("sub:"+sub); 
			dataNo = ""+group+"_"+sub;
			
			/* console.log("g:"+dataNo.substring(0,dataNo.indexOf("_")));
			console.log("s:"+dataNo.substring(dataNo.indexOf("_")+1));
			console.log("===========");  */
			$("#commentInputModifyBtn").on("click", modifyComment);
		}
		else{
			
			kind = event.target.parentNode.parentNode.nextElementSibling.firstElementChild
					.firstElementChild;			
			kind.remove();
			kind = event.target.parentNode.parentNode.nextElementSibling.firstElementChild
			.firstElementChild;		
			kind.remove();
			kind = event.target.parentNode.parentNode.nextElementSibling.firstElementChild;
			console.log("tempText2:"+tempText);
			console.log("===========");
			
			kind.innerText=tempText;
			
			
			
		}
		
	}
	function deleteComment(${dataNo}){
		$.ajax({			
			url:"deletecomment.do",
			type: "get",
			async: false,
			data:{
				commentWriter : '${nickname}',
				commentTexts : tempText,
				tableNo : ${ contentNo },
				comment_groupNo : dataNo.substring(0,dataNo.indexOf("_")),
				comment_subNo : dataNo.substring(dataNo.indexOf("_")+1),
				comment_indentNo : dataNo.substring(dataNo.indexOf("_")+1),				
				written_date : tempDate,
			},
			dataType :"text",
			success : commentDelProcess,
			error:function(){
				alert("댓글 저장 요청 실패");
			}
		});
	}
	function commentDelProcess(){
		alert("댓글 삭제 성공");
		window.location.reload();
	}
	function isDeleteCommentOK(event){
		if(window.confirm("정말로 삭제하시겠습니까?")){
			kind = event.target.parentNode.parentNode.nextElementSibling;
			let pos = event.target.parentNode.parentNode.getAttributeNode("class").value;
		
			console.log("kind: "+kind.value);
			console.log("pos :"+pos); 
			let gData = pos.indexOf("p");
			let sData = pos.indexOf("sub");
			let group = pos.substring(gData+1,sData-1);
			let sub = pos.substring(sData+3, sData+4);
			
			console.log("group:"+group);
			console.log("sub:"+sub);
			dataNo = ""+group+"_"+sub;
			
			console.log("g:"+dataNo.substring(0,dataNo.indexOf("_")));
			console.log("s:"+dataNo.substring(dataNo.indexOf("_")+1));
			
			tempDate = event.target.parentNode.previousElementSibling
			.previousElementSibling.previousElementSibling.textContent;
			console.log("tempDate:"+tempDate);
			
			let item = kind.firstElementChild;			
			let itemValue = item.innerText;
			
			if(itemValue!=null){
				tempText=itemValue;
			}
			console.log("item:"+item);
			console.log("itemValue:"+itemValue);
			
			deleteComment(dataNo);
		}
		else{
			console.log("삭제 취소");
		}
		
	}
	function hitUpEvent(){
		$.ajax({
  			url:"hitup.do",
  			type: "get",
  			async: false,
  			data:{
  				person : '${nickname}',  				
  				cNo : ${ contentNo },  				
  			},
  			dataType :"text",
  			success :  hitUpOK,
  			error:function() {
  				alert("공감 수 증가 데이터 보내기 실패");
  			}
  		});
	}
	function hitUpOK(){
			alert("공감 수 증가 데이터 보내기 성공");
			if(${hitCount}!=-3){
				document.querySelector("#hitCountBox").innerText="공감 수 : "+${hitCount};
			}				
			window.location.reload();
	}
/* 	function hitBoxReLoad(){
		hitListBox
		hitCountBox
	} */
	function hitDownEvent(){
		$.ajax({
  			url:"hitdown.do",
  			type: "get",
  			async: false,
  			data:{
  				person : '${nickname}',  				
  				cNo : ${ contentNo },  				
  			},
  			dataType :"text",
  			success : hitDownOk,
  			error:function() {
  				alert("공감 수 증가 데이터 보내기 실패");
  			}
  		});
	}
	function hitDownOk(){
		alert("공감 수 감소 데이터 보내기 성공");
		location.reload();
		document.querySelector("#hitCountBox").innerText="공감 수 : "+${hitCount};
	}
	let isListPerson;
	function isHitPerson(){		
		let items = '${items}';
		
		/* hitList.forEach((item)
				=>{
					items+=item;					
				}
		) */
		let idx = items.indexOf('${nickname}');
		if(idx!=-1){
			let imgPos = document.querySelector("#hitImg");
			imgPos.src="./image_src/showAllPost/lama-g8860e410c_1280-removebg-preview.png";
			isListPerson = true;
		}
		else{
			isListPerson = false;
		}
	}
	$(function(){
		window.onload = isHitPerson();
	})
	function isHitUp(event){
		let hitEvent = event.target;
		
		/* console.log("hitEvent:"+hitEvent);
		console.log("hitEvent src:"+hitEvent.src);
		console.log("hitupfunction work"); */
				
		let btn = document.querySelector("#hitBtn");
		let ischeck = btn.checked;
		
		console.log("ischeck:"+ischeck);
		console.log("isListPerson:"+isListPerson);
		if(isListPerson==true){
			hitDownEvent();
		}
		else if(isListPerson==false){
			hitUpEvent();
		}
		if( (ischeck==true) || (isListPerson==true)   ){
			hitEvent.src="./image_src/showAllPost/lama-g8860e410c_1280-removebg-preview.png";
			
		}
		else if( (isListPerson==false) && (ischeck==false) ){
			hitEvent.src = "./image_src/showAllPost/lama-g8860e410c_1280-removebg-preview_bw.png"
			
		}

	}
	function newReplyPost(){
		$.ajax({
			url: "replyPost.do",
			type: "get",
			async: false,
			data:{
			/* 	subTableTag : {subTableTag},
				isNoticeThisOrAll : {isNoticeThisOrAll},
				title : {title},
				texts : {texts},
				isHit : {isHit}, */				
				reSubNo : calSubNo,
				reIndentNo : calIndentNo,
				rePostLimitNo : calPostLimitNo,
			},
			dataType :"text",
			success: newReplyPostOK,
			error: function() {
				alert("newReplyPost error");
			}
			
		});
	}
	function newReplyPostOK(){
		alert("답글 쓰기 페이지로 이동합니다.");
		location.href="cafe_pro_replyPosting.jsp";
	}
	function calSubNo(){
		let result = 0;	
		let sNo = ${subNum};	
		let iNo = ${indentNum};	
		
		//현재 글이 원본인 경우.
		if(sNo == 0){
			//마지막 서브넘을 가져와서 +1
			let lastSubNum = ${lastSubNum};
			result = lastSubNum + 1;
			return result;
		}		
		//현재 글이 답글인 경우.
		else if(sNo >= 1){
			result = sNo;
			return sNo;
		}
	}
	function calIndentNo(){
		let result = 0;		
		let sNo = ${subNum};
		let iNo = ${indentNum};
		
		//현재 글이 원본인 경우
		if(sNo==0){
			return result;
		}
		//현재 글이 답글인 경우		
		else if(sNo > 0){
			//마지막 indentNo을 가져와서 +1
			let lastIndentNum = ${lastIndentNum};
			result = lastIndentNum +1;
			return result;
		}
	}
	function calPostLimitNo(){
		let result = 0;		
		let sNo = ${subNum};
		let iNo = ${indentNum};
		
		if(sNo==0){
			result=0;
			return result;
		}
		else if(sNo > 0){
			if(iNo == 0){
				result=0;
				return result;
			}
			else if(iNo > 0){
				result=-1;
				return result;
			}
		}
	}
	$("#QuitToCafe").on("click", quitToCafe_member);
	function quitToCafe_member(){
	    	  	let input=confirm("정말로 탈퇴하시겠습니까?");
	    	  	if(input){
	    			  let pwInput = prompt("사용하시던 아이디[${id}]는 재이용이 불가능합니다. "
	    					  	+"비밀번호를 입력하세요.");
	    			  if(pwInput){
	    				  alert(pwInput);
	    				  quitToCheckPassword(pwInput);
	    			  }
	    			  else{
	    				  alert("탈퇴 취소");
	    			  }
	    		  }
	    	  	else{
	    	  		
	    	  	}
	    	}
	    	function quitToCheckPassword(pwInput){
	    		$.ajax({
	    			url:"checkPWQuit.do",
	    			type:"post",
	    			async:false,
	    			data:{    				
	    				pwInput:pwInput,
	    			},
	    			dataType:"text",
	    			success: quitToCheckPasswordSendData,
	    			error: function(){
	    				alert("확인 데이터 전송 실패");
	    			}
	    			
	    		})
	    	}
	    	function quitToCheckPasswordSendData(){
	    		alert("비밀번호 체크 확인");
	    		
	    		if(${ispwOK == "yes"}){
	    			alert("탈퇴되었습니다.");
	    			location.href="startMain.jsp";
	    		}
	    		if(${ispwOK == "no"}){
	    			alert("일치하는 정보가 없습니다.");
	    		}
	    		<!-- location.href="startMain.jsp"; -->
	    	}
	    	function moveKindTable(kind){
	    		$.ajax({
	    			url:"showList.do",
	    			type:"get",
	    			async:"false",
	    			data:{
	    				subTableKind:kind,
	    			},
	    			dataType:"text",
	    			success:moveKindTableSendData,
	    			error:function(){
	    				alert("데이터 보내기 실패");
	    			}
	    		})
	    	}
	    	function moveKindTableSendData(){
	    		alert("테이블 데이터 보내기 성공");
			location.href="showKindList.jsp";
	    		
	    	}

	    	function eventRegTableMenuBtn(){
    			let btns = document.querySelectorAll(".tableMenuBtn");
    			for(let i=0; i<btns.length; i++){
    				btns[i].addEventListener("click", function(){
    					let kind = btns[i].getAttributeNode("value").value;
    					moveKindTable(kind);
    				})
    			}
    		}
	    	/* window.onload=eventRegTableMenuBtn; */
	    	$(document).ready(eventRegTableMenuBtn);
	    	

	    	function addReplyPostEvent(){
	    		let btnPos = document.querySelector("#rePlyPostBtn");
	    		
	    		if(btnPos!=null){
	    			btnPos.addEventListener('click', newReplyPost);
	    		}
	    	}
	    	window.onload = addReplyPostEvent();
	    	
	    	

	    	$('#hitImg').on('mouseover focus',function (){
	    		
	    		let btn = document.querySelector("#hitBtn");
	    		let ischeck = btn.checked;
	    		/*if(ischeck==false){
	    			$('#hitImg').attr(this.src="./image_src/showAllPost/lama-g8860e410c_1280-removebg-preview_bw.png");
	    			return;
	    			
	    		}*/
	    		$('#hitImg').attr(this.src="./image_src/showAllPost/lama-g8860e410c_1280-removebg-preview.png"
	    	)});
	    	$('#hitImg').on('mouseout blur',function (){
	    		
	    		let btn = document.querySelector("#hitBtn");
	    		let ischeck = btn.checked;
	    		if(ischeck==true || isListPerson==true){
	    			return;
	    		}
	    		$('#hitImg').attr(this.src="./image_src/showAllPost/lama-g8860e410c_1280-removebg-preview_bw.png"
	    	)});

	    	function addModifyEvent(){
	    		const button = document.querySelector('#comModifyBtn');
	    		button.addEventListener('click',inputModify(event));
	    	}
	    	window.onload = ishitUpEvent();
	    	function ishitUpEvent(){
	    		let imgpos = document.querySelector("#hitImg");
	    		
	    		if(imgpos!=null){		
	    			imgpos.addEventListener('click', isHitUp);
	    		}
	    		
	    	}
	    	function addReplyPostEvent(){
	    		let btnPos = document.querySelector("#rePlyPostBtn");
	    		
	    		if(btnPos!=null){
	    			btnPos.addEventListener('click', newReplyPost);
	    		}
	    	}
	    	window.onload = addReplyPostEvent();


  </script>
  
</body>

<c:choose>
	<c:when test="${table_id eq 'del' }">
		<script>
			watchWaring('on');
		</script>
	</c:when>
	<c:when test="${empty aId }">
		<script>
			checkLogIn('on');
		</script>
	</c:when>
</c:choose>
</html>