package com.koitt.baby.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koitt.baby.dao.*;
import com.koitt.baby.vo.*;
import java.util.ArrayList;

public class HrsysReserveChangeCommand implements HrsysCommand {
	public void reserveChange(HttpServletRequest request, HttpServletResponse response){
		String dif = request.getParameter("dif");
		System.out.println("dif(rno) >> " + dif);
		
		HttpSession session = request.getSession();
		String rno = (String)session.getAttribute("rno");
		System.out.println("rno >> " + rno);
		
		HrsysWebDAO hd = new HrsysDAOImple();
		HrsysReserveVO rv= null;
		rv = new HrsysReserveVO();
		
		if(dif != null){
			rv.setrNo(dif);
		}else{
			rv.setrNo(rno);
		}	
		
		ArrayList aList = hd.reserveChangeWork(rv);
		int aSize = aList.size();
		for(int i =0; i<aSize; i++){
			HrsysReserveVO rv_1 = (HrsysReserveVO)aList.get(i);
			String rno_1 = rv_1.getrNo();
			session.setAttribute("rno", rno_1);
		}
		
		if(aList != null){
			request.setAttribute("reserveChangeResult", aList);
		}
		
	}
	
	@Override
	public void memberInsertService(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void memberSelectService(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void memberUpdateService(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void memberDeleteService(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reserveInsertService(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reserveSelectService(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reserveUpdateService(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reserveDeleteService(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void idCheckService(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void loginService(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
