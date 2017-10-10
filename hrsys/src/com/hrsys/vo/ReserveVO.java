package com.hrsys.vo;

public class ReserveVO {

	String reserve_no;
	String reserve_ci;
	String reserve_co;
	String member_no;
	String room_no;
	String reserve_date;
	int    reserve_rate;
	int    reserve_nop;
	String reserve_deleteyn;

	public ReserveVO(){
		
	}// end of default reserveVO() constructor

	public String getReserve_no() {
		return reserve_no;
	}

	public void setReserve_no(String reserve_no) {
		this.reserve_no = reserve_no;
	}

	public String getReserve_ci() {
		return reserve_ci;
	}

	public void setReserve_ci(String reserve_ci) {
		this.reserve_ci = reserve_ci;
	}

	public String getReserve_co() {
		return reserve_co;
	}

	public void setReserve_co(String reserve_co) {
		this.reserve_co = reserve_co;
	}

	public String getMember_no() {
		return member_no;
	}

	public void setMember_no(String member_no) {
		this.member_no = member_no;
	}

	public String getRoom_no() {
		return room_no;
	}

	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}

	public String getReserve_date() {
		return reserve_date;
	}

	public void setReserve_date(String reserve_date) {
		this.reserve_date = reserve_date;
	}

	public int getReserve_rate() {
		return reserve_rate;
	}

	public void setReserve_rate(int reserve_rate) {
		this.reserve_rate = reserve_rate;
	}

	public int getReserve_nop() {
		return reserve_nop;
	}

	public void setReserve_nop(int reserve_nop) {
		this.reserve_nop = reserve_nop;
	}

	public String getReserve_deleteyn() {
		return reserve_deleteyn;
	}

	public void setReserve_deleteyn(String reserve_deleteyn) {
		this.reserve_deleteyn = reserve_deleteyn;
	}

}
