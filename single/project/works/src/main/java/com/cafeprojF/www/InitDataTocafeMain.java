package com.cafeprojF.www;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/InitDataTocafeMain")
public class InitDataTocafeMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InitDataTocafeMain() {    	
    	
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	CafememberInfoDAO cmiDAO = new CafememberInfoDAO();    	
    	String data = cmiDAO.sendDataToMain();
    	    	
    	if( !(data.equals("-1") )) {
    		System.out.println("initData oper");
    		int idx = data.indexOf(",");
    		String mCnt = data.substring(0, idx);
    		String adminName = data.substring(idx+1);
    		
    		System.out.println("cnt : "+mCnt+"명");
    		System.out.println("adName : "+adminName);
    		
    		session.setAttribute("mCnt", mCnt);
    		session.setAttribute("adminName", adminName);    		
    		System.out.println("initnick:"+session.getAttribute("cNickname"));
    		
    	}
    	MenutableInfoDAO mtiDao = MenutableInfoDAO.getMenutableInfoDAO();
    	ArrayList<MenutableInfoDTO> tableList = mtiDao.sendDataToMainPost();    	
    	session.setAttribute("tableList", tableList);
    	
    	CommentBoxDAO boxdao = CommentBoxDAO.getBox();
    	ArrayList<CommentBoxDTO> boxList = boxdao.selectAllBox();
    	session.setAttribute("boxList", boxList);
    	
    	response.sendRedirect("cafe_proj_cafeMain.jsp");
    }
	public void init(ServletConfig config) throws ServletException {
	}

}
