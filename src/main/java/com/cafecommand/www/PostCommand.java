package com.cafecommand.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafeprojF.www.MenutableInfoDAO;
import com.cafeprojF.www.MenutableInfoDTO;
import com.mysql.cj.Session;

public class PostCommand implements Command{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		MenutableInfoDAO dao = MenutableInfoDAO.getMenutableInfoDAO();
		MenutableInfoDTO dto = new MenutableInfoDTO();
		HttpSession session = request.getSession();	
		
		dto.setTitle(request.getParameter("title"));
		dto.setExtraTag(request.getParameter("extraTag"));
		dto.setSubTableTag(request.getParameter("subTableTag"));		
		String[] temp = request.getParameterValues("notice");
		String notice = null;
		if(temp!=null) {
			for(int i=0; i<temp.length; i++)
			{
				notice += temp[i];
			}
		}
		if(notice!=null)
		{
			if(notice.contains("thisNoticeOnAllNoticeOn"))
			{
				notice = "3";			
			}
			else if(notice.contains("thisNoticeOn")) {
				notice = "1";
			}
			else if(notice.contains("AllNoticeOn")) {
				notice = "2";
			}
			dto.setIsNoticeThisOrAll(Integer.parseInt(notice) );			
		}

		String comment = request.getParameter("comment");
		//댓글 허용 시 1
		if((comment!=null)&& (comment.equals("commentOn"))){
			dto.setComment(1);		
		}
		String hit = request.getParameter("isHit");
		//공감 허용 시 -1
		if((hit!=null)&& hit.equals("hitOn")) {
			dto.setIsHit(1);
		}
		dto.setTexts(request.getParameter("texts"));
		dto.setWriter((String)session.getAttribute("nickname"));
		dto.setTable_id((String)session.getAttribute("id"));
		
		dto.setSubNum(0);
		dto.setIndentNum(0);
		
		int result = 0;
		result = dao.postSave(dto);
		if(result!=0)
		{
			System.out.println("postSave OK");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('작성되었습니다. 게시글 목록으로 돌아갑니다.')</script>");
			out.println("<script>location.href='showList.do'</script>");
		}
		
		System.out.println("post : title="+dto.getTitle());
	}

	

}
