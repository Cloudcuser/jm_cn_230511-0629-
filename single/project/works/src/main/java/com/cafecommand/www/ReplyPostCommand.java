package com.cafecommand.www;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ReplyPostCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		  int reSubNo = Integer.parseInt(request.getParameter("reSubNo")); int
		  reIndentNo = Integer.parseInt(request.getParameter("reIndentNo")); int
		  rePostLimitNo = Integer.parseInt(request.getParameter("rePostLimitNo"));
		  
		  HttpSession session = request.getSession();
		  
		  session.setAttribute("reSubNo", reSubNo); 
		  session.setAttribute("reIndentNo",reIndentNo); 
		  session.setAttribute("rePostLimitNo", rePostLimitNo);
		 
		System.out.println("ReplyPostCommand : work");
		/*
		 * RequestDispatcher dispatcher =
		 * request.getRequestDispatcher("cafe_pro_newPosting.jsp");
		 * dispatcher.forward(request, response);
		 * response.sendRedirect("cafe_pro_newPosting.jsp");
		 */
	}

}
