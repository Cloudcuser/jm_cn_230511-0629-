package com.cafeprojF.www;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MenutableInfoDTO extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private int contentNo;
	private String writer;
	private String title;
	private String writtenDate;
	private String texts;
	private int readCnt;
	private int hitCnt;
	private String hitList;
	
	private int comment;

	private int isNoticeThisOrAll;
	private String subTableTag;
	private String mainTableTag;
	private int subNum;
	private int indentNum;
	private String extraTag;
	private String table_id;
	private int isHit;
	private int groupNo;

	public int getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public String getExtraTag() {
		return extraTag;
	}

	public void setExtraTag(String extraTag) {
		this.extraTag = extraTag;
	}

	public int getContentNo() {
		return contentNo;
	}

	public void setContentNo(int contentNo) {
		this.contentNo = contentNo;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWrittenDate() {
		return writtenDate;
	}

	public void setWrittenDate(String writtenDate) {
		this.writtenDate = writtenDate;
	}

	public String getTexts() {
		return texts;
	}

	public void setTexts(String texts) {
		this.texts = texts;
	}

	public int getReadCnt() {
		return readCnt;
	}

	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}

	public int getHitCnt() {
		return hitCnt;
	}

	public void setHitCnt(int hitCnt) {
		this.hitCnt = hitCnt;
	}	
	
	public String getHitList() {
		return hitList;
	}

	public void setHitList(String hitList) {
		this.hitList = hitList;
	}

	public int getComment() {
		return comment;
	}

	public void setComment(int comment) {
		this.comment = comment;
	}

	public int getIsNoticeThisOrAll() {
		return isNoticeThisOrAll;
	}

	public void setIsNoticeThisOrAll(int isNoticeThisOrAll) {
		this.isNoticeThisOrAll = isNoticeThisOrAll;
	}

	public String getSubTableTag() {
		return subTableTag;
	}

	public void setSubTableTag(String subTableTag) {
		this.subTableTag = subTableTag;
	}

	public String getMainTableTag() {
		return mainTableTag;
	}

	public void setMainTableTag(String mainTableTag) {
		this.mainTableTag = mainTableTag;
	}
  
    public int getSubNum() {
		return subNum;
	}

	public void setSubNum(int subNum) {
		this.subNum = subNum;
	}

	public int getIndentNum() {
		return indentNum;
	}

	public void setIndentNum(int indentNum) {
		this.indentNum = indentNum;
	}

	public MenutableInfoDTO() {
        super();
    }	

	public String getTable_id() {
		return table_id;
	}

	public void setTable_id(String table_id) {
		this.table_id = table_id;
	}

	public int getIsHit() {
		return isHit;
	}

	public void setIsHit(int isHit) {
		this.isHit = isHit;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	
}
