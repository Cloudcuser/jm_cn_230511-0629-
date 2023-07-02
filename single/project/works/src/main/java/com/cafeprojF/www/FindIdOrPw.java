package com.cafeprojF.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/findIdOrPw")
public class FindIdOrPw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindIdOrPw() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String mode = request.getParameter("mode");
		
		String nName = request.getParameter("nName");
		if(nName != null){
			nName = nName.trim();
		}
		String question=null;
		String answer=null;
		String id=null;
		
		PrintWriter out;
		CafememberInfoDAO dao = new CafememberInfoDAO();
		
		int on = -1;
		//아이디 찾기
		if(mode.equals("1"))
		{
			question=request.getParameter("question").trim();
			answer=request.getParameter("answer").trim();
			
			//db에 계정 찾기 질문과 답변이 일치하는지 확인
			//일치하면 아이디를 confirm창으로 보여주고,
			//확인을 누르면 비밀번호 찾기로 이동, 취소를 누르면 메인으로 이동
			
			//일치하지 않으면 계정 찾기 질문 혹은 
			//계정 찾기 답변이 일치하지 않습니다라는 alert창을 보여줌.
			//관리자에게 문의 바랍니다, 라는 메세지 포함.
			//확인을 누르면 메인으로 이동.
			String mId = dao.selectLog(question, answer,nName,id, mode);
			if(mId != null)
			{
				out = response.getWriter();
				out.print("<script>"
						//+ "confirm('아이디를 찾았습니다. 아이디: "+mId+" 비밀번호를 찾으시겠습니까? 예:찾기, 아니오:로그인 화면 ');"
						
						  +"var f = (function (){ var find = confirm('아이디를 찾았습니다. 아이디: "+mId+" 비밀번호를 찾으시겠습니까? 예:찾기, 아니오:로그인 화면 ');" 
						  +"if(find){ location.href='cafe_findPw.jsp'}" 
						  +"else{ location.href='cafe_pro_logIn.html'} })()"
						 
						+ "</script>)");				
			}
			else if(mId ==null)
			{
				out = response.getWriter();
				out.print("<script>"
						+ "alert('별명 혹은 질문, 답변이 일치하지 않습니다. ');"
						+ "window.history.go(-1)"				 
						+ "</script>)");
			}
			
			
		}
		//비밀번호 찾기
		else if(mode.equals("2"))
		{
			id = request.getParameter("id").trim();
			question=request.getParameter("question").trim();
			answer=request.getParameter("answer").trim();
			
			String mPw = dao.selectLog(question, answer, nName, id, mode);
			
			if(mPw != null)
			{
				out = response.getWriter();
				out.print("<script>"
						+ "alert('비밀번호를 찾았습니다. 비밀번호: "+mPw+" 로그인 창으로 돌아갑니다. ');"
						+ "location.href='cafe_pro_logIn.html'"			 
						+ "</script>)");
			}else if(mPw ==null)
			{
				out = response.getWriter();
				out.print("<script>"
						+ "alert('아이디 혹은 질문, 답변이 일치하지 않습니다. ');"
						+ "window.history.go(-1)"
						+ "</script>)");
			}
		}
		
	}

}
