package com.cafeprojF.www;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/myInfoOK")
public class MyInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyInfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		CafememberInfoDAO dao = new CafememberInfoDAO();
		
		
		  String id = (String)session.getAttribute("id");
		  System.out.println("info : "+id); 
		 
		CafememberInfoDTO dto = dao.selectBoard(id);
		System.out.println("true");
		
		  if(dto != null) { 
			  session.setAttribute("myNickname", dto.getNickname());
			  session.setAttribute("myHobby", dto.getHobby());
			  session.setAttribute("myRegDate", dto.getRegDate());
			  session.setAttribute("myComeDate", dto.getLastComeDate());
			  session.setAttribute("myQues", dto.getAcntFindQuestion());
			  session.setAttribute("myAns", dto.getAnctFindAnswer());
			  session.setAttribute("myPriv", dto.getIsStaff());
			  session.setAttribute("myVisitCnt", dto.getVisitCnt());
			  System.out.println(session.getAttribute("myPriv"));
		  System.out.println("myInfo: 세션 저장 성공");
		  
		  response.sendRedirect("cafe_pro_lookMyInfo.jsp"); }
		 
		 
	}

}
