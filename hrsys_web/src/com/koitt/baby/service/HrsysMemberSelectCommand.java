package com.koitt.baby.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.koitt.baby.dao.*;
import com.koitt.baby.vo.*;
import java.util.ArrayList;

public class HrsysMemberSelectCommand implements HrsysCommand{
	public void reserveChange(HttpServletRequest request, HttpServletResponse response){}
	public void memberInsertService(HttpServletRequest request, HttpServletResponse response){}
	public void memberSelectService(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		String mid= (String)session.getAttribute("mid");
		
		HrsysWebDAO hd = new HrsysDAOImple();
		HrsysMemberVO mv = null;
		mv = new HrsysMemberVO();
		mv.setmId(mid);
		
		ArrayList a = hd.memberSelectWork(mv);
		
		if(a != null){
			request.setAttribute("selectResult", a);
		}else{
			System.out.println("a°¡ null");
		}
		
	}
	public void memberUpdateService(HttpServletRequest request, HttpServletResponse response){}
	public void memberDeleteService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveInsertService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveSelectService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveUpdateService(HttpServletRequest request, HttpServletResponse response){}
	public void reserveDeleteService(HttpServletRequest request, HttpServletResponse response){}
	public void idCheckService(HttpServletRequest request, HttpServletResponse response){}
	public void loginService(HttpServletRequest request, HttpServletResponse response){}
	
}
