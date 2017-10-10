package com.koitt.baby.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.koitt.baby.dao.*;
import com.koitt.baby.vo.HrsysMemberVO;

public class HrsysMemberUpdateCommand implements HrsysCommand{
	public void reserveChange(HttpServletRequest request, HttpServletResponse response){}
	public void memberInsertService(HttpServletRequest request, HttpServletResponse response){}
	public void memberSelectService(HttpServletRequest request, HttpServletResponse response){}
	public void memberUpdateService(HttpServletRequest request, HttpServletResponse response){
		
		HrsysWebDAO hd = new HrsysDAOImple();
		HrsysMemberVO mv = null;
		mv = new HrsysMemberVO();

		String mid = request.getParameter("mid");			
		String mpw = request.getParameter("mpw");	
		String mname = request.getParameter("mname");	
		String maddr = request.getParameter("maddr");	
		String mphone = request.getParameter("mphone");	
		String memail = request.getParameter("memail");	
		
		System.out.println("mname >> " + mname);
				
		mv.setmId(mid);
		mv.setmPw(mpw);
		mv.setmName(mname);
		mv.setmAddr(maddr);
		mv.setmPhone(mphone);
		mv.setmEmail(memail);
		
		int i = hd.memberUpdateWork(mv);
		
		if(i>0){
			request.setAttribute("updateResult", i);
			request.setAttribute("mid", mid);
		}
		
	}
	public void memberDeleteService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveInsertService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveSelectService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveUpdateService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveDeleteService(HttpServletRequest request, HttpServletResponse response){}
	public void idCheckService(HttpServletRequest request, HttpServletResponse response){}
	public void loginService(HttpServletRequest request, HttpServletResponse response){}
	
}
