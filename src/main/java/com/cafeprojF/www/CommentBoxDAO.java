package com.cafeprojF.www;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

public class CommentBoxDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static CommentBoxDAO dao = new CommentBoxDAO();
	private String Connection_pool_resource_name="jdbc/nicedb";
	private final String Table_name="CommentBox";
	private DataSource dataSource;
		
		public CommentBoxDAO() {
			try {
				Context context = new InitialContext();
				dataSource = (DataSource)context.lookup("java:comp/env/"
					+Connection_pool_resource_name);
			}
			catch(NamingException e) {
				System.out.println("댓글 DAO : 드라이버 로드 실패");
				e.printStackTrace();
			}
		}
		public static CommentBoxDAO getBox() {
			return dao;
		}
		
		public ArrayList<CommentBoxDTO> selectAllBox(){
			ArrayList<CommentBoxDTO> list = new ArrayList<>();
			String query = "select * from "+Table_name;			
			
			try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();)			
			{
				while(rs.next()) {
					CommentBoxDTO dto = new CommentBoxDTO();
					dto.setTableNo(rs.getInt("tableNo"));
					dto.setComment_writer(rs.getString("comment_writer"));
					dto.setComment_texts(rs.getString("comment_texts"));
					dto.setComment_date(rs.getString("comment_date"));
					dto.setComment_groupNo(rs.getInt("comment_groupNo"));
					dto.setComment_subNo(rs.getInt("comment_subNo"));
					dto.setComment_indentNo(rs.getInt("comment_indentNo"));
					
					list.add(dto);
				}			
				System.out.println("commentBoxDao-selectAllBox : getBoxList success");
			}
			catch(SQLException e) {
				e.printStackTrace();
			}			
			return list;			
		}
		
		public ArrayList<CommentBoxDTO> selectTheBox(int boxNo){			
			String query = "select * from "+Table_name+" where tableNo='"+boxNo
					+"' order by comment_groupNo asc, comment_subNo asc,"
					+ "comment_indentNo asc";		
			ArrayList<CommentBoxDTO> list = new ArrayList<>();
			
			try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();)			
			{
				while(rs.next()) {
					CommentBoxDTO dto = new CommentBoxDTO();
					dto.setTableNo(rs.getInt("tableNo"));
					dto.setComment_writer(rs.getString("comment_writer"));
					dto.setComment_texts(rs.getString("comment_texts"));
					dto.setComment_date(rs.getString("comment_date"));
					dto.setComment_groupNo(rs.getInt("comment_groupNo"));
					dto.setComment_subNo(rs.getInt("comment_subNo"));
					dto.setComment_indentNo(rs.getInt("comment_indentNo"));
					list.add(dto);					
				}
				if(list != null) {
					System.out.println("댓글 dto : selectTheBox success");
					return list;			
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}			
			return list;			
		}
		
		public String insertBox(CommentBoxDTO dto) {
			int result = 0;
			String query = "insert into "+Table_name
					+"(tableNo, comment_writer,"
					+ "comment_texts, comment_groupNo,"
					+ "comment_subNo, comment_indentNo)"
					+ "values(?,?,?,?,?,?)";
			
		try(Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);)
		{
			
			pstmt.setInt(1, dto.getTableNo());
			pstmt.setString(2, dto.getComment_writer());
			pstmt.setString(3, dto.getComment_texts());
			pstmt.setInt(4, dto.getComment_groupNo());
			pstmt.setInt(5, dto.getComment_subNo());
			pstmt.setInt(6, dto.getComment_indentNo());
			
			result = pstmt.executeUpdate();
			if(result != 0)
			{
				System.out.println("댓글 DAO : insertBox success");
				String sQuery = "select comment_texts, comment_date from "+Table_name
						+" where comment_writer='"+dto.getComment_writer()+"'"
						+"order by comment_date desc";
				
				try(PreparedStatement pstmt2 = conn.prepareStatement(sQuery);
						ResultSet rs = pstmt2.executeQuery(); )
				{
					//(임시 메모) 테이블 넘버, 댓글 작성자, 댓글 내용, 그룹 넘버, 서브 넘버 조회해서 갖고 오기.
					
					while(rs.next()) {
						String data =  rs.getString("comment_texts"); 
						data += "/"+rs.getString("comment_date");
						System.out.println("boxdao comment data :"+data);
						return data;
					}
					
				}
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}			
			return null;
		}
		
		public int deleteBox(int tableNo) {
			int result = 0;
			String query = "delete from "+Table_name+" where tableNo='"+tableNo+"'";
			
			try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);)
			{
				result = pstmt.executeUpdate();			
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
		public int updateBox(CommentBoxDTO boxdto, String privText) {
			int result = 0;
			String writer = boxdto.getComment_writer();
			int tableNo = boxdto.getTableNo();
			String prText = privText;
			int gNo = boxdto.getComment_groupNo();
			int sNo = boxdto.getComment_subNo();
			String wDate = boxdto.getComment_date();
			
			String query = "update "+Table_name
					+" set comment_texts='"+boxdto.getComment_texts()
					+"' where comment_writer='"+writer
					+"'and tableNo='"+tableNo
					+"'and comment_texts='"+prText
					+"'and comment_groupNo='"+gNo
					+"'and comment_subNo='"+sNo
					+"'and comment_date='"+wDate+"'";
			try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);)
				{
					result = pstmt.executeUpdate();
				}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
		
		public int deleteBox(CommentBoxDTO boxdto) {
			int result = 0;
			
			String writer = boxdto.getComment_writer();
			int tableNo = boxdto.getTableNo();
			String prText = boxdto.getComment_texts();
			int gNo = boxdto.getComment_groupNo();
			int sNo = boxdto.getComment_subNo();
			String wDate = boxdto.getComment_date();
			
			String query = "delete from "+Table_name
					+" where comment_writer='"+writer
					+"' and tableNo='"+tableNo					
					+"' and comment_texts='"+prText
					+"' and comment_groupNo='"+gNo
					+"' and comment_subNo='"+sNo
					+"' and comment_date='"+wDate+"'";
			try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);)
				{
					result = pstmt.executeUpdate();
				}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
}

