package com.cafecommand.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafeprojF.www.MenutableInfoDAO;
import com.cafeprojF.www.MenutableInfoDTO;

public class HitUpCommand implements Command{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String person = request.getParameter("person").trim();		
		int contentNo = Integer.parseInt(request.getParameter("cNo"));
		System.out.println("person:"+person);
		MenutableInfoDAO tabdao = MenutableInfoDAO.getMenutableInfoDAO();
		
		boolean isPersonThere = false; //list에 존재하는지 여부. 
		boolean inputOK = false; //데이터 삽입 성공 여부.
		isPersonThere = tabdao.searchPersonInHitList(person, contentNo);
		// 공감 목록에서 사람 찾기(if) / 공감 목록에 사람 추가하기(else)
		
		if(isPersonThere) {
			System.out.println("이미 공감 목록에 존재하는 사람입니다.");
			return;
		}
		else {
			// 공감 목록에 추가하는 기능 실행.
			
			// 공감 목록에서 제외하기(HitDownCommand로 작성하기)
			
			inputOK = tabdao.inputPersonInHitList(person, contentNo);
			
			if(inputOK) {
				System.out.println("hitUp Command well done");				
				out.print("alert('해당 게시글 공감 증가')");
				String[]array = tabdao.getHitListArray(contentNo);
				HttpSession session = request.getSession();
				session.setAttribute("hitList", array);
				int hitCount = array.length-1;
				session.setAttribute("hitCount", hitCount);
			}
			else {
				System.out.println("hitUp Command failed");
			}
		}
	}
	
}
