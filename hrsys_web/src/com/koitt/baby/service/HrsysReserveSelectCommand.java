package com.koitt.baby.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.koitt.baby.dao.*;
import com.koitt.baby.vo.*;
import java.util.ArrayList;

public class HrsysReserveSelectCommand implements HrsysCommand{
	public void reserveChange(HttpServletRequest request, HttpServletResponse response){}
	public void memberInsertService(HttpServletRequest request, HttpServletResponse response){}
	public void memberSelectService(HttpServletRequest request, HttpServletResponse response){}
	public void memberUpdateService(HttpServletRequest request, HttpServletResponse response){}
	public void memberDeleteService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveInsertService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveSelectService(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		String mno = (String)session.getAttribute("mno");
		HrsysWebDAO hd = new HrsysDAOImple();
		HrsysReserveVO rv= null;
		rv = new HrsysReserveVO();
		
		rv.setmNo(mno);
		
		ArrayList aList = hd.reserveSelectWork(rv);
		if(aList != null){
			request.setAttribute("reserveSelectResult", aList);
		}
		
	}
	public void reserveUpdateService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveDeleteService(HttpServletRequest request, HttpServletResponse response){}
	public void idCheckService(HttpServletRequest request, HttpServletResponse response){}
	public void loginService(HttpServletRequest request, HttpServletResponse response){}
	
}
