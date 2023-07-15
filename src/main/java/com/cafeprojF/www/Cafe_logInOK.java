package com.cafeprojF.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

@WebServlet("/cafe_logInOK")
public class Cafe_logInOK extends HttpServlet {
	private static final long serialVersionUID = 1L;	
    
    public Cafe_logInOK() {
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);    	
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		 System.out.println("login 확인 영역 : doPost 작동");
		 String id = request.getParameter("uid");		 
		 String pw = request.getParameter("upw");
		 System.out.println("id:"+id);
		 System.out.println("pw:"+pw);
		 int on = 1;
		 HttpSession session = request.getSession();
		
		 CafememberInfoDAO cmiDAO = new CafememberInfoDAO();
		 CafememberInfoDTO cmiDTO = cmiDAO.selectLog(id, pw, on);
		 if(cmiDTO!=null) {
			 System.out.println("login 확인 영역 : DTO에 데이터 불러오기 성공");
			 
			 session.setAttribute("id", cmiDTO.getId());
			 session.setAttribute("pw", cmiDTO.getPw());
			 session.setAttribute("nickname", cmiDTO.getNickname());
			 
			 String priv = String.valueOf(cmiDTO.getIsStaff());
			 System.out.println("priv:"+priv);
			 session.setAttribute("priv", priv);
			 response.sendRedirect("startMain.jsp");
				/*
				 * RequestDispatcher dispatcher = request.getRequestDispatcher("startMain.jsp");
				 * dispatcher.forward(request, response);
				 */
			 
		 }
		 else {
			 response.setCharacterEncoding("utf-8");
			 response.setContentType("text/html;charset=utf-8");
			 PrintWriter out = response.getWriter();
			 out.println("<!doctype>");
			 out.println("<html>");
			 out.println("<head></head>");
			 out.println("<body>");
			 out.println("<script>alert('유효한 아이디 혹은 비밀번호가 존재하지 않습니다.')</script>");
			 out.println("<script>window.history.go(-1)</script>");
			 out.println("</body>");
			 out.println("</html>");			 
		 }
	}

}
