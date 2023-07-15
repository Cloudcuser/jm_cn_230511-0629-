package com.cafeprojF.www;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MenutableInfoDAO {
	/*
	 * private final String sId = "root"; private final String sPw = "1234"; private
	 * final String url = "jdbc:mysql://localhost:3306/nicedb?serverTimezone=UTC";
	 * private final String driver = "com.mysql.cj.jdbc.driver";
	 */

	private static MenutableInfoDAO mtiDAO = new MenutableInfoDAO();
	private String Connection_pool_resource_name = "jdbc/nicedb";
	private final String Table_name = "MenutableInfo";
	private DataSource dataSource;

	public MenutableInfoDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/" + Connection_pool_resource_name);
		} catch (NamingException e) {
			System.out.println("게시판DAO 드라이버 로드 실패");
		}
	}

	public static MenutableInfoDAO getMenutableInfoDAO() {
		return mtiDAO;
	}

	public ArrayList<MenutableInfoDTO> selectBoard() {
		/*
		 * String query = "select * from menutableinfo(contentNo, writer, title," +
		 * "writtenDate, texts, readCnt, hitCnt, comment, comment_writer," +
		 * "comment_texts, comment_date, isNoticeThisOrAll, subTableTag, mainTableTag)";
		 */

		String query = "select * from " + Table_name 
				+ " order by groupNo desc, subNum asc, indentNum asc, contentNo desc";
		System.out.println(query);
		ArrayList<MenutableInfoDTO> list = new ArrayList<>();
		int count = 0;
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				MenutableInfoDTO mtiDTO = new MenutableInfoDTO();
				mtiDTO.setContentNo(rs.getInt("contentNo"));
				mtiDTO.setWriter(rs.getString("writer"));
				mtiDTO.setTitle(rs.getString("title"));
				mtiDTO.setWrittenDate(rs.getString("writtenDate"));
				mtiDTO.setTexts(rs.getString("texts"));
				mtiDTO.setReadCnt(rs.getInt("readCnt"));
				mtiDTO.setHitCnt(rs.getInt("hitCnt"));
				mtiDTO.setHitList(rs.getString("hitList"));
				mtiDTO.setComment(rs.getInt("comment"));
				mtiDTO.setIsNoticeThisOrAll(rs.getInt("isNoticeThisOrAll"));
				mtiDTO.setSubTableTag(rs.getString("subTableTag"));
				mtiDTO.setMainTableTag(rs.getString("mainTableTag"));
				mtiDTO.setSubNum(rs.getInt("subNum"));
				mtiDTO.setIndentNum(rs.getInt("indentNum"));
				mtiDTO.setExtraTag(rs.getString("extraTag"));
				mtiDTO.setTable_id(rs.getString("table_id"));
				mtiDTO.setIsHit(rs.getInt("isHit"));
				mtiDTO.setGroupNo(rs.getInt("groupNo"));
				
				list.add(mtiDTO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int countPost() {
		int result = 0;
		String query = "select count(*) from "+Table_name;
		try(Connection conn = dataSource.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(query);){			
			while(rs.next()) {
				result = rs.getInt("count(*)");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	public ArrayList<MenutableInfoDTO> selectThatBoard(int start, int end){
		ArrayList<MenutableInfoDTO> list = new ArrayList<>();
		String query = "select * from "+Table_name
					+" where (contentNo>='"+start+"') "
					+"and (contentNo<='"+end+"') "
					+"order by groupNo desc, subNum asc, indentNum asc, contentNo desc";
		System.out.println("menu dao - selectThatBoard query:"+query);
		try(Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();)
		{
			while(rs.next()) {
				MenutableInfoDTO mtiDTO = new MenutableInfoDTO();
				mtiDTO.setContentNo(rs.getInt("contentNo"));
				mtiDTO.setWriter(rs.getString("writer"));
				mtiDTO.setTitle(rs.getString("title"));
				mtiDTO.setWrittenDate(rs.getString("writtenDate"));
				mtiDTO.setTexts(rs.getString("texts"));
				mtiDTO.setReadCnt(rs.getInt("readCnt"));
				mtiDTO.setHitCnt(rs.getInt("hitCnt"));
				mtiDTO.setHitList(rs.getString("hitList"));
				mtiDTO.setComment(rs.getInt("comment"));
				mtiDTO.setIsNoticeThisOrAll(rs.getInt("isNoticeThisOrAll"));
				mtiDTO.setSubTableTag(rs.getString("subTableTag"));
				mtiDTO.setMainTableTag(rs.getString("mainTableTag"));
				mtiDTO.setSubNum(rs.getInt("subNum"));
				mtiDTO.setIndentNum(rs.getInt("indentNum"));
				mtiDTO.setExtraTag(rs.getString("extraTag"));
				mtiDTO.setTable_id(rs.getString("table_id"));
				mtiDTO.setIsHit(rs.getInt("isHit"));
				mtiDTO.setGroupNo(rs.getInt("groupNo"));
				
				list.add(mtiDTO);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	public ArrayList<MenutableInfoDTO> sendDataToMainPost() {
		String query = "select * from " + Table_name 
				+ " order by groupNo desc, subNum asc, indentNum asc, contentNo desc";
		
		ArrayList<MenutableInfoDTO> list = new ArrayList<>();
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				MenutableInfoDTO dto = new MenutableInfoDTO();
				dto.setContentNo(rs.getInt("contentNo"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setComment(rs.getInt("comment"));
				dto.setSubTableTag(rs.getString("subTableTag"));
				dto.setReadCnt(rs.getInt("readCnt"));
				dto.setIsNoticeThisOrAll(rs.getInt("isNoticeThisOrAll"));
				dto.setExtraTag(rs.getString("extraTag"));
				dto.setGroupNo(rs.getInt("groupNo"));
				dto.setSubNum(rs.getInt("subNum"));
				dto.setIndentNum(rs.getInt("indentNum"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public int postSave(MenutableInfoDTO dto) {
		String query = "insert into " + Table_name + "(title, extraTag, subTableTag, isNoticeThisOrAll,"
				+ "comment, isHit, texts, writer, table_id, subNum, indentNum)" 
				+ "values(?,?,?,?,?,?,?,?,?,?,?)";
		int result = 0;
		
		System.out.println("menuDAO write : oper");

		try (Connection conn = dataSource.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(query);) 
		{
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getExtraTag());
			pstmt.setString(3, dto.getSubTableTag());
			pstmt.setInt(4, dto.getIsNoticeThisOrAll());
			pstmt.setInt(5, dto.getComment());
			pstmt.setInt(6, dto.getIsHit());
			pstmt.setString(7, dto.getTexts());
			pstmt.setString(8, dto.getWriter());
			pstmt.setString(9, dto.getTable_id());
			pstmt.setInt(10, dto.getSubNum());
			pstmt.setInt(11, dto.getIndentNum());
			
			result = pstmt.executeUpdate();
			
			if(result!=0) {				
				
				System.out.println("table dao insert- postSave work");
				
				MenutableInfoDAO tabdao = MenutableInfoDAO.getMenutableInfoDAO();
				int result2 = 0;			
				result2 = tabdao.updateGroupNo(dto);
				if(result2!=0) {
					System.out.println("table dao insert- update work");
					return result2;
				}
				else {
					return 0;
				}
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	public int updateGroupNo(MenutableInfoDTO dto) {
		int result = 0;
		String query = "select contentNo from "+Table_name
				+" where title='"+dto.getTitle()
				+ "' and extraTag='"+dto.getExtraTag()
				+ "' and subTableTag='"+dto.getSubTableTag()
				+ "' and isNoticeThisOrAll='"+dto.getIsNoticeThisOrAll()
				+ "' and comment='"+dto.getComment()
				+ "' and isHit='"+dto.getIsHit()
				+ "' and texts='"+dto.getTexts()
				+ "' and writer='"+dto.getWriter()
				+ "' and table_id='"+dto.getTable_id()
				+ "' and subNum='"+dto.getSubNum()
				+ "' and indentNum='"+dto.getIndentNum()+"'";
	
		int contentNum =0;		
		try(Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();)
		{
			while(rs.next()) {
				contentNum = rs.getInt("contentNo");				
			}
			if(contentNum != 0) {
				System.out.println("updateGroupNo contentNo: "+contentNum);
				String upQuery ="update "+Table_name
						+" set groupNo='"+contentNum
						+"' where contentNo='"+contentNum+"';";
				try(PreparedStatement upPstmt = conn.prepareStatement(upQuery);){
					result = upPstmt.executeUpdate();
				}
			
				
				if(result!=0) {
					System.out.println("updateGroupNo : work done");
					return result;
				}
				else {
					System.out.println("updateGroupNo : work failed");
				}
			}			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public int postUpdate(MenutableInfoDTO dto) {
		int result = 0;
		int isHit = dto.getHitCnt();
		if (isHit == -1) {
			dto.setHitList(dto.getHitList() + ",modi1");
		}
		String upQuery = "update " + Table_name + "" + " set title='" + dto.getTitle() + "'," + " extraTag='"
				+ dto.getExtraTag() + "'," + " subTableTag='" + dto.getSubTableTag() + "'," + " isNoticeThisOrAll='"
				+ dto.getIsNoticeThisOrAll() + "'," + " comment='" + dto.getComment() + "'," + " isHit='"
				+ dto.getIsHit() + "'," + " texts='" + dto.getTexts().trim() + "'," + " writer='" + dto.getWriter()
				+ "'" + " where contentNo='" + dto.getContentNo() + "';";

		System.out.println("upQuery: " + upQuery);
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(upQuery);) {
			result = pstmt.executeUpdate();
			if (result != 0) {
				System.out.println("menu DAO : postUpdate success");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public MenutableInfoDTO selectPost(int no) {
		String query = "select * from " + Table_name + " where contentNo='" + no + "'";

		int result = 0;
		MenutableInfoDTO dto = new MenutableInfoDTO();
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				dto.setContentNo(rs.getInt("contentNo"));
				dto.setExtraTag(rs.getString("extraTag"));
				dto.setSubTableTag(rs.getString("subTableTag"));
				dto.setIsNoticeThisOrAll(rs.getInt("isNoticeThisOrAll"));
				dto.setTitle(rs.getString("title"));
				dto.setWrittenDate(rs.getString("writtenDate"));
				dto.setTexts(rs.getString("texts"));
				dto.setReadCnt(rs.getInt("readCnt"));
				dto.setWriter(rs.getString("writer"));
				dto.setHitList(rs.getString("hitList"));
				dto.setHitCnt(rs.getInt("hitCnt"));
				dto.setComment(rs.getInt("comment"));
				dto.setTable_id(rs.getString("table_id"));
				dto.setIsHit(rs.getInt("isHit"));
				dto.setGroupNo(rs.getInt("groupNo"));
				dto.setSubNum(rs.getInt("subNum"));
				dto.setIndentNum(rs.getInt("indentNum"));
			}
			int rCnt = dto.getReadCnt() + 1;
			result = 1;
			MenutableInfoDAO dao = MenutableInfoDAO.getMenutableInfoDAO();
			dao.updateRcnt(no, rCnt);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result != 0) {
			return dto;
		}
		return null;
	}

	public int updateRcnt(int no, int rCnt) {
		int result = 0;
		String upQuery = "update " + Table_name + " set readCnt='" + rCnt + "' where contentNo='" + no + "'";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(upQuery);) {
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result != 0) {
			System.out.println("menu DAO : update rCnt");
			return result;
		}

		return result;
	}

	public int deletePost(int contentNo) {
		int result = 0;
		String query = "update " + Table_name + " set " + "writer='del', " + "title='삭제된 글입니다.', " + "texts='삭제된 글', "
				+ "readCnt='0', " + "hitCnt='-2', " + "comment='0', " + "isNoticeThisOrAll='0', "
				+ "subTableTag='del', " + "mainTableTag='del', " + "hitList='del', " + "subNum='0', "
				+ "indentNum='0', " + "extraTag='del', " + "table_id='del' " + "where contentNo='" + contentNo + "'";

		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query);) {
			result = pstmt.executeUpdate();
			if (result != 0) {
				System.out.println("table DAO delpost 작동 확인");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

	public int deletePostByStaff(String staffName, String bec, String table_id, int contentNo, String writer) {
		int result = 0;

		String udQuery = "update " + Table_name + " set " + "writer='del', " + "title='삭제된 글입니다.', " + "texts='삭제된 글', "
				+ "readCnt='0', " + "hitCnt='-2', " + "comment='0', " + "isNoticeThisOrAll='1', "
				+ "subTableTag='del', " + "mainTableTag='del', " + "hitList='del', " + "subNum='0', "
				+ "indentNum='0', " + "extraTag='del', " + "table_id='del' " + "where contentNo='" + contentNo + "'";

		String postQuery = "insert into " + Table_name
				+ "(writer, title, texts, isNoticeThisOrAll, subTableTag, mainTableTag, extraTag, table_id)"
				+ "values(\'" + staffName + "\'," + "\'" + bec + "에 의한 게시글 삭제'," + "\'" + writer + "의 글이 " + bec
				+ "에 의해 제재 사유에 해당되어 스탭 " + staffName + "이/가 삭제하였습니다.'," + "\'1\'," + "'공지'," + "'관리 메뉴'," + "'공지',"
				+ "\'" + table_id + "')";
		String selectQuery = "select contentNo from "+Table_name
				+" where table_id='"+table_id+"'"
				+ " order by contentNo desc"
				+ " limit 1";
		
		// System.out.println("postQuery : "+postQuery);

		try (Connection conn = dataSource.getConnection();
				PreparedStatement psup = conn.prepareStatement(udQuery);
				PreparedStatement pspost = conn.prepareStatement(postQuery);)
				 {
			result = psup.executeUpdate();
			if (result != 0) {
				System.out.println("menu dao-deletePS : psup success");
				result = pspost.executeUpdate();
				if (result != 0) {
					System.out.println("menu dao-deletePS : pspost success");
					int thatContentNo = 0;
					Thread.sleep(2000);
					try(PreparedStatement slpost = conn.prepareStatement(selectQuery);
							ResultSet rs = slpost.executeQuery(selectQuery);){
					while(rs.next()) {
						thatContentNo = rs.getInt("contentNo");
					}
					
				}
					System.out.println("menu dao-deletePS thatConNum: "+thatContentNo);
					if(thatContentNo != 0) {
						String upNoticePostQuery = "update "+Table_name
								+" set groupNo='"+thatContentNo+"'"
								+" where contentNo='"+thatContentNo+"'";
						int upGroupResult = 0;
						try(PreparedStatement upNoticePstmt = conn.prepareStatement(upNoticePostQuery);){
							upGroupResult = upNoticePstmt.executeUpdate();
						}				
						
						
						if(upGroupResult != 0) {
							result = 10;
							System.out.println("menu dao-deletePS : upGroupNo success");
						}
						else {
							result = -1;
							System.out.println("menu dao-deletePS : upGroupNo failed");
						}
						return result;
					}					
				
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(InterruptedException e2) {
			e2.printStackTrace();
		}

		return result;

	}

	public boolean searchPersonInHitList(String person, int contentNo) {
		boolean flag = false; // 없는 상태로 시작.
		String query = "select hitList from " + Table_name + " where contentNo='" + contentNo + "'";
		String temp = "";

		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				temp = rs.getString("hitList");
			}
			if (temp == null) {
				return flag = false;
			} else {
				int idx = temp.indexOf("/"+person);
				if (idx == -1) {
					return flag = false;
				} else {
					return flag = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public String getHitList(int contentNo) {

		String temp = null;
		String query = "select hitList from " + Table_name + " where contentNo='" + contentNo + "'";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();) 
		{
			while (rs.next()) {
				temp = rs.getString("hitList");
			}
			if(temp!=null) {
				System.out.println("menu tabdao select hitList temp:" + temp.toString());
				
			}
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		return temp;
	
}	
	public String[] getHitListArray(int contentNo) {
		
		String query = "select hitList from " + Table_name + " where contentNo='" +contentNo+ "'";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();) 
		{
			while (rs.next()) {
				String str = rs.getString("hitList");
				if(str!=null) {
					System.out.println("menu tabdao select hitList temp:" + str.toString());
					String[] array = str.split("/");
					return array;
				}
				else {
					
					return null;
				}
			}
			
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
		//	String take = "a/b/c/d/e";		
		//	String[] alpha = take.split("/");
		//	for(String s : alpha) {
		//		System.out.println("alpha e:"+s);
		//	}
		
		
	}	
	public boolean inputPersonInHitList(String person, int contentNo) {
		boolean flag = false; //없는 상태로 시작.
		String data;
		
		MenutableInfoDAO tabdao = MenutableInfoDAO.getMenutableInfoDAO();
		if(tabdao.getHitList(contentNo)!=null) {
			String temp = tabdao.getHitList(contentNo);		
			temp += "/" + person;
			data = temp;
		}
		else {
			String temp = "/" + person;
			data = temp;
		}
			String query = "update "+Table_name
				+" set hitList='"+data
				+"' where contentNo='"+contentNo+"'";
			try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);)
			{			
				int result = pstmt.executeUpdate();
				if(result != 0) {
					System.out.println("tabdao -input work success");
					flag = true;
				}
				else {
					System.out.println("tabdao -input work failed");
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
			return flag;
	}		

	public boolean deleteFromHitList(String person, int contentNo) {
		boolean flag = false;		
		MenutableInfoDAO tabdao = MenutableInfoDAO.getMenutableInfoDAO();
		String list = tabdao.getHitList(contentNo);
		StringBuilder sb1 = new StringBuilder();
		
		/* 가져온 데이터를 올바르게 불러왔는지 확인하는 코드
		 * System.out.println("delList person:"+person);
		 * System.out.println("delList list:"+list);
		 */
		
		if(list != null) {
			
			if(list.contains(person)) {
				int idx = list.indexOf("/"+person);
				System.out.println("delList idx:"+idx);
				String temp1 = list.substring(0, idx);
				String temp2 = list.substring(idx+person.length()+1, list.length());
				/* 디버그용 코드(지우려는 person 문자열만 갖고 오는 코드)
				 * String str = list.substring(idx,idx+person.length()+1);
				 * System.out.println("delList str:"+str);
				 */
				
				System.out.println("delList newList:"+temp1+"_"+temp2);
				sb1.append(temp1);
				sb1.append(temp2);
				
			}
			
			else {
				System.out.println("tabdao - deleteFromHitList : person not contained in list");
				return flag;
			}
		}
		else {
			System.out.println("tabdao - deleteFromHitList : not found hitList");
			return flag;
		}
		
				System.out.println("tabdao - deleteFromHitList sb1:"+sb1.toString());
				
				
				String query = "update "+Table_name
							+" set hitList='"+sb1
							+"' where contentNo='"+contentNo+"'";
				try(Connection conn = dataSource.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(query);)
				{
					int result = 0;
					/*
					 * if(result==0) { return flag; }
					 */
					result = pstmt.executeUpdate();
					if(result!=0) {
						System.out.println("tabdao - deleteFromHitList : delete work success!");
						return flag=true;
					}
					else {
						System.out.println("tabdao - deleteFromHitList : delete work failed!");
						return flag=false;
					}
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
				return flag;
	}
	public int replyPostSave(MenutableInfoDTO tabdto) {
		int result = 0;
		String query = "insert into " + Table_name 
				+ "(title, "
				+ "extraTag, "
				+ "subTableTag, "
				+ "isNoticeThisOrAll,"
				+ "comment, "
				+ "isHit, "
				+ "texts, "
				+ "writer, "
				+ "table_id,"				
				+ "subNum,"
				+ "indentNum,"
				+ "groupNo)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try(Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);)
		{
			pstmt.setString(1, tabdto.getTitle());
			pstmt.setString(2, tabdto.getExtraTag());
			pstmt.setString(3, tabdto.getSubTableTag());
			pstmt.setInt(4, tabdto.getIsNoticeThisOrAll());
			pstmt.setInt(5, tabdto.getComment());
			pstmt.setInt(6, tabdto.getIsHit());
			pstmt.setString(7, tabdto.getTexts());
			pstmt.setString(8, tabdto.getWriter());
			pstmt.setString(9, tabdto.getTable_id());
			pstmt.setInt(10, tabdto.getSubNum());
			pstmt.setInt(11, tabdto.getIndentNum());
			pstmt.setInt(12, tabdto.getGroupNo());
			
			result = pstmt.executeUpdate();
			if(result!=0) {
				System.out.println("menuTab dao - replyPostSave : success");
				return result;
			}
			else {
				System.out.println("menuTab dao - replyPostSave : failed");
				return 0;
			}
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public String takeLastSubNumAndLastIndentNum(int groupNo) {
		String data = null;
		String squery = "select subNum from "+Table_name
						+" where groupNo='"+groupNo
						+"' order by subNum desc";
		String iquery = "select indentNum from "+Table_name
						+" where groupNo='"+groupNo
						+"' order by indentNum desc";
		int lastSubNum = -1;
		int lastIndentNum = -1;
		try(Connection conn = dataSource.getConnection();
			PreparedStatement sPstmt = conn.prepareStatement(squery);
			ResultSet subNumSet = sPstmt.executeQuery();
			PreparedStatement iPstmt = conn.prepareStatement(iquery);
			ResultSet indentNumSet = iPstmt.executeQuery();)
		{
			while(subNumSet.next()) {
				lastSubNum = subNumSet.getInt("subNum");
				break;
			}
			while(indentNumSet.next()) {
				lastIndentNum = indentNumSet.getInt("indentNum");
				break;
			}
			if(lastSubNum!=-1 && lastIndentNum!=-1) {
				System.out.println("menuTable dao - takeLastSubNumAndLastIndentNum : success");
				data = ""+lastSubNum+"_"+lastIndentNum;
				return data;
			}
			else {
				return null;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	
		return data;
	}
	public int selectContentNo(String where) {
		int result = 0;
		String query ="";
		if(where.equals("lastNo")) {
			query = "select contentNo from "+Table_name
					+" order by contentNo desc limit 1";
		}
		else if(where.equals("firstNo")) {
			query = "select contentNo from "+Table_name
					+" order by contentNo asc limit 1";
		}
		try(Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(query);){
			while(rs.next()) {
				result = rs.getInt("contentNo");
			}
			return result;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
}
