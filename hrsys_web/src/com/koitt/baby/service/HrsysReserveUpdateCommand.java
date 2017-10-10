package com.koitt.baby.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.koitt.baby.dao.*;
import com.koitt.baby.vo.HrsysReserveVO;

public class HrsysReserveUpdateCommand implements HrsysCommand{
	public void memberInsertService(HttpServletRequest request, HttpServletResponse response){}
	public void memberSelectService(HttpServletRequest request, HttpServletResponse response){}
	public void memberUpdateService(HttpServletRequest request, HttpServletResponse response){}
	public void memberDeleteService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveInsertService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveSelectService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveUpdateService(HttpServletRequest request, HttpServletResponse response){
		HrsysWebDAO hd = new HrsysDAOImple();
		HrsysReserveVO rv = null;
		rv = new HrsysReserveVO();
		String rno = request.getParameter("rno");
		String rcheckin = request.getParameter("checkin");
		String rcheckout = request.getParameter("checkout");
		String rtype = request.getParameter("roomtype");
		String rnum = request.getParameter("people");
		
		System.out.println("rno >> " + rno);
		
		rv.setrNo(rno);
		rv.setrCheckIn(rcheckin);
		rv.setrCheckOut(rcheckout);
		rv.setrType(rtype);
		rv.setrNum(rnum);
		
		int i = hd.reserveUpdate(rv);
		if(i>0){
			request.setAttribute("updateResult", i);
		}
	}
	public void reserveDeleteService(HttpServletRequest request, HttpServletResponse response){}
	public void idCheckService(HttpServletRequest request, HttpServletResponse response){}
	public void loginService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveChange(HttpServletRequest request, HttpServletResponse response){}
}
