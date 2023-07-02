package com.cafeprojF.www;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


public class CafeBasicInfoDTO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int infoNo;
	private String cafeAddress;
	private String cafeName;
	private String managersNickname;
	private boolean isCafeOpen;
	private boolean isConfirmSignMember;
	private String cafeIntroduce;
	private boolean isOpenMemberListInfo;
	private String cafeTheme;
	private String cafeArea;
	private String cafeWordForSearch;
	private String cafeGrade;
	private int visitedCafeCount;
	private String editCafeInfoDate;
	public int getInfoNo() {
		return infoNo;
	}
	public void setInfoNo(int infoNo) {
		this.infoNo = infoNo;
	}
	public String getCafeAddress() {
		return cafeAddress;
	}
	public void setCafeAddress(String cafeAddress) {
		this.cafeAddress = cafeAddress;
	}
	public String getCafeName() {
		return cafeName;
	}
	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}
	public String getManagersNickname() {
		return managersNickname;
	}
	public void setManagersNickname(String managersNickname) {
		this.managersNickname = managersNickname;
	}
	public boolean isCafeOpen() {
		return isCafeOpen;
	}
	public void setCafeOpen(boolean isCafeOpen) {
		this.isCafeOpen = isCafeOpen;
	}
	public boolean isConfirmSignMember() {
		return isConfirmSignMember;
	}
	public void setConfirmSignMember(boolean isConfirmSignMember) {
		this.isConfirmSignMember = isConfirmSignMember;
	}
	public String getCafeIntroduce() {
		return cafeIntroduce;
	}
	public void setCafeIntroduce(String cafeIntroduce) {
		this.cafeIntroduce = cafeIntroduce;
	}
	public boolean isOpenMemberListInfo() {
		return isOpenMemberListInfo;
	}
	public void setOpenMemberListInfo(boolean isOpenMemberListInfo) {
		this.isOpenMemberListInfo = isOpenMemberListInfo;
	}
	public String getCafeTheme() {
		return cafeTheme;
	}
	public void setCafeTheme(String cafeTheme) {
		this.cafeTheme = cafeTheme;
	}
	public String getCafeArea() {
		return cafeArea;
	}
	public void setCafeArea(String cafeArea) {
		this.cafeArea = cafeArea;
	}
	public String getCafeWordForSearch() {
		return cafeWordForSearch;
	}
	public void setCafeWordForSearch(String cafeWordForSearch) {
		this.cafeWordForSearch = cafeWordForSearch;
	}
	public String getCafeGrade() {
		return cafeGrade;
	}
	public void setCafeGrade(String cafeGrade) {
		this.cafeGrade = cafeGrade;
	}
	public int getVisitedCafeCount() {
		return visitedCafeCount;
	}
	public void setVisitedCafeCount(int visitedCafeCount) {
		this.visitedCafeCount = visitedCafeCount;
	}
	public String getEditCafeInfoDate() {
		return editCafeInfoDate;
	}
	public void setEditCafeInfoDate(String editCafeInfoDate) {
		this.editCafeInfoDate = editCafeInfoDate;
	}
	
	
}
