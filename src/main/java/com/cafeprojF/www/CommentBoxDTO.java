package com.cafeprojF.www;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


public class CommentBoxDTO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int tableNo;
	private String comment_writer;
	private String comment_texts;
	
	private String comment_date;
	private int comment_groupNo;
	private int comment_subNo;
	private int comment_indentNo;
	public int getTableNo() {
		return tableNo;
	}
	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}
	public String getComment_writer() {
		return comment_writer;
	}
	public void setComment_writer(String comment_writer) {
		this.comment_writer = comment_writer;
	}
	public String getComment_texts() {
		return comment_texts;
	}
	public void setComment_texts(String comment_texts) {
		this.comment_texts = comment_texts;
	}
	public String getComment_date() {
		return comment_date;
	}
	public void setComment_date(String comment_date) {
		this.comment_date = comment_date;
	}
	public int getComment_groupNo() {
		return comment_groupNo;
	}
	public void setComment_groupNo(int comment_groupNo) {
		this.comment_groupNo = comment_groupNo;
	}
	public int getComment_subNo() {
		return comment_subNo;
	}
	public void setComment_subNo(int comment_subNo) {
		this.comment_subNo = comment_subNo;
	}
	public int getComment_indentNo() {
		return comment_indentNo;
	}
	public void setComment_indentNo(int comment_indentNo) {
		this.comment_indentNo = comment_indentNo;
	}
	
	

}
