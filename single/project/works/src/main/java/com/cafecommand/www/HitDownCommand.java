package com.cafecommand.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafeprojF.www.MenutableInfoDAO;

public class HitDownCommand implements Command{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String person = request.getParameter("person").trim();		
		int contentNo = Integer.parseInt(request.getParameter("cNo"));
	
		System.out.println("person:"+person);
		MenutableInfoDAO tabdao = MenutableInfoDAO.getMenutableInfoDAO();
	
		boolean delOK = false; //데이터 삭제 성공 여부.
		delOK = tabdao.deleteFromHitList(person, contentNo);
		
		if(delOK) {
			System.out.println("HitDownCommand - well done!");
			out.print("alert('해당 게시글 공감 감소')");
			String[]array = tabdao.getHitListArray(contentNo);
			HttpSession session = request.getSession();
			session.setAttribute("hitList", array);
			int hitCount = array.length-1;
			session.setAttribute("hitCount", hitCount);
		}
		else {
			System.out.println("HitDownCommand - work failed!");
		}
	}

}
