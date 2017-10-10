package com.koitt.baby.vo;

public class HrsysReserveVO {
	
	String rNo; //예약번호
	String rCheckIn; //체크인일자
	String rCheckOut; //체크아웃일자
	String mNo; //고객번호
	String rType; //방타입
	String rDate; //예약된 일자
	String    rNum; //총 인원수
	String rDeleteyn;
	public String getrNo() {
		return rNo;
	}
	public void setrNo(String rNo) {
		this.rNo = rNo;
	}
	public String getrCheckIn() {
		return rCheckIn;
	}
	public void setrCheckIn(String rCheckIn) {
		this.rCheckIn = rCheckIn;
	}
	public String getrCheckOut() {
		return rCheckOut;
	}
	public void setrCheckOut(String rCheckOut) {
		this.rCheckOut = rCheckOut;
	}
	public String getmNo() {
		return mNo;
	}
	public void setmNo(String mNo) {
		this.mNo = mNo;
	}
	public String getrType() {
		return rType;
	}
	public void setrType(String rType) {
		this.rType = rType;
	}
	public String getrDate() {
		return rDate;
	}
	public void setrDate(String rDate) {
		this.rDate = rDate;
	}
	public String getrNum() {
		return rNum;
	}
	public void setrNum(String rNum) {
		this.rNum = rNum;
	}
	public String getrDeleteyn() {
		return rDeleteyn;
	}
	public void setrDeleteyn(String rDeleteyn) {
		this.rDeleteyn = rDeleteyn;
	}
	
}
