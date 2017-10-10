package com.koitt.baby.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koitt.baby.dao.*;
import com.koitt.baby.vo.HrsysReserveVO;

public class HrsysReserveInsertCommand implements HrsysCommand{
	public void reserveChange(HttpServletRequest request, HttpServletResponse response){}
	public void memberInsertService(HttpServletRequest request, HttpServletResponse response){}
	public void memberSelectService(HttpServletRequest request, HttpServletResponse response){}
	public void memberUpdateService(HttpServletRequest request, HttpServletResponse response){}
	public void memberDeleteService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveInsertService(HttpServletRequest request, HttpServletResponse response){
		
		HrsysWebDAO hd = new HrsysDAOImple();
		
		HrsysReserveVO rv = null;
		rv = new HrsysReserveVO();
		
		HttpSession session = request.getSession();
		
		String checkin = request.getParameter("checkin");
		String checkout = request.getParameter("checkout");
		String mno = (String)session.getAttribute("mno");
		String roomtype = request.getParameter("roomtype");
		String people = request.getParameter("people");
		
		rv.setrCheckIn(checkin);
		rv.setrCheckOut(checkout);
		rv.setmNo(mno);
		rv.setrType(roomtype);
		rv.setrNum(people);
		
		int i = hd.reserveWork(rv);
		
		if(i>0){
			request.setAttribute("reserveInsertResult", i);
		}
	}
	public void reserveSelectService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveUpdateService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveDeleteService(HttpServletRequest request, HttpServletResponse response){}
	public void idCheckService(HttpServletRequest request, HttpServletResponse response){}
	public void loginService(HttpServletRequest request, HttpServletResponse response){}
	
}	
