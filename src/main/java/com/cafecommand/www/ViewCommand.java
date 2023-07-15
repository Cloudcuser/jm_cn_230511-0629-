package com.cafecommand.www;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafeprojF.www.CommentBoxDAO;
import com.cafeprojF.www.CommentBoxDTO;
import com.cafeprojF.www.MenutableInfoDAO;
import com.cafeprojF.www.MenutableInfoDTO;

public class ViewCommand implements Command{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MenutableInfoDAO dao = MenutableInfoDAO.getMenutableInfoDAO();
		MenutableInfoDTO dto = new MenutableInfoDTO();		
		String temp = request.getParameter("no");
		int no = Integer.parseInt(temp);
		
		System.out.println("view : no="+no);	
		
		dto = dao.selectPost(no);
		if(dto!= null) {
		HttpSession session = request.getSession();
		session.setAttribute("contentNo", dto.getContentNo());
		session.setAttribute("extraTag", dto.getExtraTag());
		session.setAttribute("subTableTag", dto.getSubTableTag());
		session.setAttribute("isNoticeThisOrAll", dto.getIsNoticeThisOrAll());
		session.setAttribute("title", dto.getTitle());
		session.setAttribute("writtenDate", dto.getWrittenDate());
		session.setAttribute("texts", dto.getTexts());
		session.setAttribute("readCnt", dto.getReadCnt());
		session.setAttribute("writer", dto.getWriter());
		session.setAttribute("groupNo", dto.getGroupNo());
		session.setAttribute("subNum", dto.getSubNum());
		session.setAttribute("indentNum", dto.getIndentNum());
		
		String[] array = dao.getHitListArray(no);
		if(array!=null) {			
			session.setAttribute("hitList", array);
			int hitCount = array.length-1;
			session.setAttribute("hitCount", hitCount);
		}
		else {
			session.setAttribute("hitCount", 0);
		}
		session.setAttribute("hitCnt", dto.getHitCnt());
		session.setAttribute("comment", dto.getComment());
		session.setAttribute("table_id", dto.getTable_id());
		session.setAttribute("isHit", dto.getIsHit());
		/* System.out.println("ishit:"+dto.getIsHit()); */
		System.out.println("view_command : session content set ok");
		
		CommentBoxDAO boxdao = CommentBoxDAO.getBox();
		ArrayList<CommentBoxDTO> list = new ArrayList<>();
		
	
		
		list = boxdao.selectTheBox(dto.getContentNo());
		session.setAttribute("boxList", list);
		if(list.size() != 0) {
			session.setAttribute("tableNo", list.get(0).getTableNo());
			
		}
		
		/*
		 * session.setAttribute("tableNo", boxdto.getTableNo());
		 * session.setAttribute("comment_writer", boxdto.getComment_writer());
		 * session.setAttribute("comment_texts", boxdto.getComment_texts());
		 * session.setAttribute("comment_date", boxdto.getComment_date());
		 * session.setAttribute("comment_groupNo", boxdto.getComment_groupNo());
		 * session.setAttribute("comment_subNo", boxdto.getComment_subNo());
		 * session.setAttribute("comment_indentNo", boxdto.getComment_indentNo());
		 */
		
		String data = dao.takeLastSubNumAndLastIndentNum(dto.getGroupNo());
		
		System.out.println("view_Command take number data :"+data);
		
		int lastSubNum = Integer.parseInt(data.substring(0,data.indexOf("_")));
		int lastIndentNum = Integer.parseInt(data.substring(data.indexOf("_")+1));
		
		System.out.println("view_Command take number lastSubNum :"+ lastSubNum);
		System.out.println("view_Command take number lastIndentNum :"+ lastIndentNum);
		
		session.setAttribute("lastSubNum", lastSubNum);
		session.setAttribute("lastIndentNum", lastIndentNum);
		
		int contentLastNo = dao.selectContentNo("lastNo");
		int contentFirstNo = dao.selectContentNo("firstNo");
		
		session.setAttribute("contentLastNo",contentLastNo);
		session.setAttribute("contentFirstNo",contentFirstNo);
		
		System.out.println("view_command : session box set ok");		
		}
		else {
			System.out.println("view_Command : 데이터 불러오기 실패");
		}
	}
	

	

}
