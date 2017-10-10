package com.koitt.baby.service;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.baby.dao.HrsysDAOImple;
import com.koitt.baby.dao.HrsysWebDAO;
import com.koitt.baby.vo.HrsysMemberVO;

public class HrsysMemberInsertCommand implements HrsysCommand{
	public void reserveChange(HttpServletRequest request, HttpServletResponse response){}
	public void memberInsertService(HttpServletRequest request, HttpServletResponse response){
		String mId = request.getParameter("id");
		String mPw = request.getParameter("pw");
		String mName = request.getParameter("name");
		String mAddr = request.getParameter("addr");
		String mPhone = request.getParameter("phone");
		String mEmail = request.getParameter("email");
		
		HrsysWebDAO hd = new HrsysDAOImple();
		HrsysMemberVO hv = null;
		hv = new HrsysMemberVO();
		
		hv.setmId(mId);
		hv.setmPw(mPw);
		hv.setmName(mName);
		hv.setmAddr(mAddr);
		hv.setmPhone(mPhone);
		hv.setmEmail(mEmail);
		
		int i = hd.memberInsertWork(hv);
		
		if(i>0){
			request.setAttribute("memberInsertWork", i);		
		}
		
	}
	public void memberSelectService(HttpServletRequest request, HttpServletResponse response){}
	public void memberUpdateService(HttpServletRequest request, HttpServletResponse response){}
	public void memberDeleteService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveInsertService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveSelectService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveUpdateService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveDeleteService(HttpServletRequest request, HttpServletResponse response){}
	public void idCheckService(HttpServletRequest request, HttpServletResponse response){}
	public void loginService(HttpServletRequest request, HttpServletResponse response){}
	
}
