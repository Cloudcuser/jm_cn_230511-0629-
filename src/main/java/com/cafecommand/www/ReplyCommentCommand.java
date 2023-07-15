package com.cafecommand.www;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafeprojF.www.CommentBoxDAO;
import com.cafeprojF.www.CommentBoxDTO;

public class ReplyCommentCommand implements Command	{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		CommentBoxDTO boxdto = new CommentBoxDTO();
		CommentBoxDAO boxdao = CommentBoxDAO.getBox();
		
		boxdto.setComment_writer(request.getParameter("commentWriter"));
		boxdto.setComment_texts(request.getParameter("commentTexts"));
		boxdto.setTableNo( Integer.parseInt(request.getParameter("tableNo")));
		
		int gNo = -1;
		int sNo = -1;
		int iNo = -1;
		boolean flag = false;
		System.out.println("gNo:"+request.getParameter("comment_groupNo"));
		System.out.println("sNo:"+request.getParameter("comment_subNo"));
		System.out.println("iNo:"+request.getParameter("comment_indentNo"));
		
		gNo = Integer.parseInt(request.getParameter("comment_groupNo"));
		if(gNo != -1) {
			boxdto.setComment_groupNo(gNo);
		}else {
			flag=true;
		}
		sNo = Integer.parseInt(request.getParameter("comment_subNo"))+1;
		if(sNo != -1) {
			boxdto.setComment_subNo(sNo);
		}else {
			flag=true;
		}
		iNo = Integer.parseInt(request.getParameter("comment_indentNo"))+1;
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
			String result = null;
			result = boxdao.insertBox(boxdto);
			
			if(result!=null) {
				System.out.println("reply comment command ok");
			}
			else {
				System.out.println("reply comment command failed");
			}
		}
		
	}
	
}
