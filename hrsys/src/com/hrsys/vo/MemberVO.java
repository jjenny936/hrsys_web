package com.hrsys.vo;

public class MemberVO {

	String member_no;
	String member_id;
	String member_pw;
	String member_name;
	String member_addr;
	String member_hp;
	String member_email;
	String member_deleteyn;
	String member_in;
	String member_up;

	public MemberVO(){

	}// end of default memberVO() constructor

	public MemberVO(String member_no
	               ,String member_id
	               ,String member_pw
	               ,String member_name
	               ,String member_addr
	               ,String member_hp
	               ,String member_email
	               ,String member_deleteyn
	               ,String member_in
	               ,String member_up){

		this.member_no = member_no;
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_name = member_name;
		this.member_addr = member_addr;
		this.member_hp = member_hp;
		this.member_email = member_email;
		this.member_deleteyn = member_deleteyn;
		this.member_in = member_in;
		this.member_up = member_up;

	}// end of memberVO() constructor

	public void setMember_no(String member_no){this.member_no = member_no;}
	public void setMember_id(String member_id){this.member_id = member_id;}
	public void setMember_pw(String member_pw){this.member_pw = member_pw;}
	public void setMember_name(String member_name){this.member_name = member_name;}
	public void setMember_addr(String member_addr){this.member_addr = member_addr;}
	public void setMember_hp(String member_hp){this.member_hp = member_hp;}
	public void setMember_email(String member_email){this.member_email = member_email;}
	public void setMember_deleteyn(String member_deleteyn){this.member_deleteyn = member_deleteyn;}
	public void setMember_in(String member_in){this.member_in = member_in;}
	public void setMember_up(String member_up){this.member_up = member_up;}
	
	public String getMember_no(){return this.member_no;}
	public String getMember_id(){return this.member_id;}
	public String getMember_pw(){return this.member_pw;}
	public String getMember_name(){return this.member_name;}	
	public String getMember_addr(){return this.member_addr;}
	public String getMember_hp(){return this.member_hp;}
	public String getMember_email(){return this.member_email;}
	public String getMember_deleteyn(){return this.member_deleteyn;}
	public String getMember_in(){return this.member_in;}
	public String getMember_up(){return this.member_up;}
	
}
