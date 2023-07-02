package com.cafecommand.www;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ClearCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//테이블, 댓글 정보 초기화
				
		  HttpSession session = request.getSession();
		  session.removeAttribute("contentNo"); session.removeAttribute("extraTag");
		  session.removeAttribute("subTableTag");
		  session.removeAttribute("isNoticeThisOrAll");
		  session.removeAttribute("title"); session.removeAttribute("writer");
		  session.removeAttribute("texts"); session.removeAttribute("hitList");
		  session.removeAttribute("comment_writer");
		  session.removeAttribute("comment_texts");
		  session.removeAttribute("comment_date");
		  session.removeAttribute("comment_groupNo");
		  session.removeAttribute("comment_subNo");
		  session.removeAttribute("comment_indentNo");
	}
	
}
