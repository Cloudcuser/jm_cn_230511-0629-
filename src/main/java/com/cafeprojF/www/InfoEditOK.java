package com.cafeprojF.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/InfoEditOK")
public class InfoEditOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public InfoEditOK() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("id");
		String nickname = request.getParameter("nickname").trim();
		String hobby = request.getParameter("hobby").trim();
		String question = request.getParameter("question").trim();
		String answer = request.getParameter("answer").trim();
		
		System.out.println("data:"+id+" ,"+nickname+", "+hobby+", "+question+", "+hobby);
		CafememberInfoDAO dao = new CafememberInfoDAO();
		String cNickname = dao.updateInfo(id, nickname, hobby, question, answer);
				
		if(!(cNickname.equals(null)))
		{
			System.out.println("infonick2 :"+ cNickname);
			session.setAttribute("cNickname", cNickname);
			System.out.println("infonick22 :"+session.getAttribute("cNickname"));
			out.println("<script>alert('정보 업데이트 성공. 카페 메인으로 돌아갑니다.')</script>");
			out.println("<script>location.href='startMain.jsp'</script>");			
		}
		else {
			out.println("<script>alert('정보 업데이트 실패. 관리자에게 문의해주세요.')</script>");
			out.println("<script>location.href='startMain.jsp'</script>");			
			
		}
		
		
		
		
	}

}
