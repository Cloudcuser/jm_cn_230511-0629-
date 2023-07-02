package com.cafecommand.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafeprojF.www.CommentBoxDAO;
import com.cafeprojF.www.MenutableInfoDAO;

public class DeleteCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");		
		PrintWriter out = response.getWriter();		
		MenutableInfoDAO tabledao = MenutableInfoDAO.getMenutableInfoDAO();
		CommentBoxDAO boxdao = CommentBoxDAO.getBox();		
		HttpSession session = request.getSession();
		System.out.println("DeleteCommand oper");
		
		if(session.getAttribute("contentNo")!=null) {
			int contentNo = (int)session.getAttribute("contentNo");
			session.setAttribute("mode", "postDel");
			RequestDispatcher dispatcher = request.getRequestDispatcher("cafe_pro_PWPass_info.jsp?mode=postDel");
			dispatcher.forward(request, response);
		}
		else {
			System.out.println("Post Delete Command: contentNo is null. check please!");
			out.print("alert('Post Delete Command: error occured')");
		}
		if(session.getAttribute("tableNo")!=null) {
			int tableNo = (int)session.getAttribute("tableNo");
			session.setAttribute("mode", "postDel");
			RequestDispatcher dispatcher = request.getRequestDispatcher("cafe_pro_PWPass_info.jsp?mode=postDel");
			dispatcher.forward(request, response);
		}
		else {
			System.out.println("Post Delete Command: tableNo is null. check please!");
			out.print("alert('Post Delete Command: error occured')");
		}
		
	}
	
}
