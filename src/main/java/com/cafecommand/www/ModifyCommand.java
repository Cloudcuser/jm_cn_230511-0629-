package com.cafecommand.www;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ModifyCommand implements Command{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ModifyCommand oper");	
		RequestDispatcher dispatcher = request.getRequestDispatcher("cafe_pro_PWPass_info.jsp?mode=postModi");
		HttpSession session = request.getSession();
		session.setAttribute("mode", "postModi");
		dispatcher.forward(request, response);
	}
	
}
