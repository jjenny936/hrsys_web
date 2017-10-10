package com.koitt.baby.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.baby.dao.HrsysDAOImple;
import com.koitt.baby.dao.HrsysWebDAO;
import com.koitt.baby.vo.HrsysMemberVO;

public class HrsysMemberDeleteCommand implements HrsysCommand{
	public void reserveChange(HttpServletRequest request, HttpServletResponse response){}
	public void memberInsertService(HttpServletRequest request, HttpServletResponse response){}
	public void memberSelectService(HttpServletRequest request, HttpServletResponse response){}
	public void memberUpdateService(HttpServletRequest request, HttpServletResponse response){}
	public void memberDeleteService(HttpServletRequest request, HttpServletResponse response){

		HrsysWebDAO hd = new HrsysDAOImple();
		HrsysMemberVO mv = null;
		mv = new HrsysMemberVO();
		
		String mid = request.getParameter("mid");
		mv.setmId(mid);

		int i = hd.memberDeleteWork(mv);
	
		if(i>0){
		
			request.setAttribute("deleteResult", i);
		}
	}
	public void reserveInsertService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveSelectService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveUpdateService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveDeleteService(HttpServletRequest request, HttpServletResponse response){}
	public void idCheckService(HttpServletRequest request, HttpServletResponse response){}
	public void loginService(HttpServletRequest request, HttpServletResponse response){}
	
}
