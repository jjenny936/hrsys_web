package com.koitt.baby.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.koitt.baby.dao.*;
import com.koitt.baby.vo.HrsysMemberVO;
import com.koitt.baby.vo.HrsysReserveVO;

public class HrsysReserveDeleteCommand implements HrsysCommand{
	public void reserveChange(HttpServletRequest request, HttpServletResponse response){}
	public void memberInsertService(HttpServletRequest request, HttpServletResponse response){}
	public void memberSelectService(HttpServletRequest request, HttpServletResponse response){}
	public void memberUpdateService(HttpServletRequest request, HttpServletResponse response){}
	public void memberDeleteService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveInsertService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveSelectService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveUpdateService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveDeleteService(HttpServletRequest request, HttpServletResponse response){
		HrsysWebDAO hd = new HrsysDAOImple();
		HrsysReserveVO rv = null;
		rv = new HrsysReserveVO();
		String rno = request.getParameter("rno");
		
		System.out.println("rno >> " + rno);
		
		rv.setrNo(rno);
		
		int i = hd.reserveDelete(rv);	
		if(i>0){
			request.setAttribute("deleteResult", i);
		}
		
	}
	public void idCheckService(HttpServletRequest request, HttpServletResponse response){}
	public void loginService(HttpServletRequest request, HttpServletResponse response){}
	
}
