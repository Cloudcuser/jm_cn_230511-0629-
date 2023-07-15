package com.cafeprojF.www;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CafememberInfoDTO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String pw;
	private String nickname;
	private String hobby;
	private String regDate;
	private String lastComeDate;
	private String acntFindQuestion;
	private String anctFindAnswer;
	private int isStaff;
	private int visitCnt;

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getHobby() {
		return hobby;
	}


	public void setHobby(String hobby) {
		this.hobby = hobby;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	public String getLastComeDate() {
		return lastComeDate;
	}


	public void setLastComeDate(String lastComeDate) {
		this.lastComeDate = lastComeDate;
	}


	public String getAcntFindQuestion() {
		return acntFindQuestion;
	}


	public void setAcntFindQuestion(String acntFindQuestion) {
		this.acntFindQuestion = acntFindQuestion;
	}


	public String getAnctFindAnswer() {
		return anctFindAnswer;
	}


	public void setAnctFindAnswer(String anctFindAnswer) {
		this.anctFindAnswer = anctFindAnswer;
	}


	public int getIsStaff() {
		return isStaff;
	}


	public void setIsStaff(int isStaff) {
		this.isStaff = isStaff;
	}	
    public CafememberInfoDTO() {
        super();        
    }
    
    public int getVisitCnt() {
		return visitCnt;
	}

	public void setVisitCnt(int visitCnt) {
		this.visitCnt = visitCnt;
	}

	

}
