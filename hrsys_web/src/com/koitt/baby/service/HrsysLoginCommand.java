package com.koitt.baby.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.koitt.baby.dao.*;
import com.koitt.baby.vo.*;
import java.util.ArrayList;

public class HrsysLoginCommand implements HrsysCommand{
	public void reserveChange(HttpServletRequest request, HttpServletResponse response){}
	public void memberInsertService(HttpServletRequest request, HttpServletResponse response){}
	public void memberSelectService(HttpServletRequest request, HttpServletResponse response){}
	public void memberUpdateService(HttpServletRequest request, HttpServletResponse response){}
	public void memberDeleteService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveInsertService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveSelectService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveUpdateService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveDeleteService(HttpServletRequest request, HttpServletResponse response){}
	public void idCheckService(HttpServletRequest request, HttpServletResponse response){}	
	public void loginService(HttpServletRequest request, HttpServletResponse response){
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		HrsysWebDAO hd = new HrsysDAOImple();
		HrsysMemberVO mv = null;
		mv = new HrsysMemberVO();
		mv.setmId(mid);
		mv.setmPw(mpw);
		ArrayList a = hd.loginWork(mv);
		if(a != null){
			request.setAttribute("loginResult", a);
			request.setAttribute("loginId", mid);
			request.setAttribute("loginPw", mpw);
		}
		
	}
	
}
