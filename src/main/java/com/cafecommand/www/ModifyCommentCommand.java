package com.cafecommand.www;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafeprojF.www.CommentBoxDAO;
import com.cafeprojF.www.CommentBoxDTO;

public class ModifyCommentCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("#### modifycomment oper #####");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		CommentBoxDTO boxdto = new CommentBoxDTO();
		CommentBoxDAO boxdao = CommentBoxDAO.getBox();
		String privText = request.getParameter("privText");
		boxdto.setTableNo( Integer.parseInt(request.getParameter("tableNo")));
		boxdto.setComment_writer(request.getParameter("commentWriter").trim());
		boxdto.setComment_texts(request.getParameter("commentTexts").trim());
		boxdto.setComment_date(request.getParameter("written_date").trim());
		if(boxdto.getComment_texts() == null) {
			return;
		}
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
			System.out.println("Modify Comment command reNo error");
			return;
		}
		else {
			int result=0;
			result = boxdao.updateBox(boxdto, privText);
			
			if(result != 0) {
				System.out.println("modify comment command work ok");
			}
			
		}
	}

}
