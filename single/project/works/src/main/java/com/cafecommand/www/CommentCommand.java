package com.cafecommand.www;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import com.cafeprojF.www.CommentBoxDAO;
import com.cafeprojF.www.CommentBoxDTO;

public class CommentCommand implements Command{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		CommentBoxDTO boxdto = new CommentBoxDTO();
		CommentBoxDAO boxdao = CommentBoxDAO.getBox();
		
		boxdto.setTableNo( Integer.parseInt(request.getParameter("tableNo")));
		boxdto.setComment_writer(request.getParameter("commentWriter"));
		boxdto.setComment_texts(request.getParameter("commentTexts"));
		if(boxdto.getComment_texts() == null) {
			return;
		}
		System.out.println("newBoxdto texts:"+boxdto.getComment_texts());
		int gNo = -1;
		int sNo = -1;
		int iNo = -1;
		boolean flag = false;
		gNo = Integer.parseInt(request.getParameter("comment_groupNo"));
		if(gNo != -1) {
			boxdto.setComment_groupNo(gNo);
		}else {
			flag=true;
		}
		sNo = Integer.parseInt(request.getParameter("comment_subNo"));
		if(sNo != -1) {
			boxdto.setComment_subNo(sNo);
		}else {
			flag=true;
		}
		iNo = Integer.parseInt(request.getParameter("comment_indentNo"));
		if(iNo != -1) {
			boxdto.setComment_indentNo(iNo);
		}else {
			flag=true;
		}		
		if(flag) {
			System.out.println("Comment command reNo error");
			return;
		}
		else {
			String data = boxdao.insertBox(boxdto);
			if(data != null) {
				System.out.println("Comment command insert OK");				
				String texts = data.substring(0,data.indexOf("/"));
				String date = data.substring(data.indexOf("/")+1,data.length());
				boxdto.setComment_date(date);
				boxdto.setComment_texts(texts);
				System.out.println("comment texts :"+texts);
				System.out.println("comment date :"+date);
				
				HttpSession session = request.getSession();
				session.setAttribute("newBoxdto", boxdto);
				
				
				response.sendRedirect("view.jsp");
				 
			}
		}
		
		
	}
	
}
