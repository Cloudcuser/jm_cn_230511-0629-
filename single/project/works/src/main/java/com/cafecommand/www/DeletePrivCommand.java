package com.cafecommand.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafeprojF.www.CommentBoxDAO;
import com.cafeprojF.www.MenutableInfoDAO;

public class DeletePrivCommand implements Command{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();		
		PrintWriter out = response.getWriter();
		
		String bec = request.getParameter("because");
		String staffName = (String)session.getAttribute("nickname");
		String writer = (String)session.getAttribute("writer");		
		int contentNo = (int)session.getAttribute("contentNo");
		int tableNo = 0;
		if(session.getAttribute("tableNo")!=null) {
			tableNo = (int)(session.getAttribute("tableNo"));
		}
		String table_id = (String)session.getAttribute("id");
		
		System.out.println("sName"+staffName);
		System.out.println("bec:"+bec);
		System.out.println("writer:"+writer);
		System.out.println("contentNo:"+contentNo);
		System.out.println("tableNo:"+tableNo);
		
		
		
		int result = 0;
		//포스트 삭제
		if(contentNo != 0) {		
			//댓글박스 삭제
			if(tableNo != 0) {
				if(contentNo == tableNo)  {
					CommentBoxDAO cboxDao = CommentBoxDAO.getBox();
					result = cboxDao.deleteBox(tableNo);
					if(result != 0) {
						System.out.println("댓글 박스 삭제 성공");
					}
				}				
			}
			MenutableInfoDAO tabDao = MenutableInfoDAO.getMenutableInfoDAO();
			result = tabDao.deletePostByStaff(staffName, bec, table_id, contentNo, writer);
			if(result==10) {
				System.out.println("포스트 삭제 성공");
				out.println("<script>alert('해당 게시글을 삭제했습니다.')</script>");
				out.println("<script>location.href='showList.do'</script>");
			}
		}		
		
		//넘겨주기 / 스탭의 별명(삭제한 사람), 사유, 삭제한 글의 작성자
		
	}
	
}
