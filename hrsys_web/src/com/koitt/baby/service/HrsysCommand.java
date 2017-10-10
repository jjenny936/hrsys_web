package com.koitt.baby.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HrsysCommand {
	
	public void memberInsertService(HttpServletRequest request, HttpServletResponse response);
	public void memberSelectService(HttpServletRequest request, HttpServletResponse response);
	public void memberUpdateService(HttpServletRequest request, HttpServletResponse response);
	public void memberDeleteService(HttpServletRequest request, HttpServletResponse response);
	public void reserveInsertService(HttpServletRequest request, HttpServletResponse response);
	public void reserveSelectService(HttpServletRequest request, HttpServletResponse response);
	public void reserveUpdateService(HttpServletRequest request, HttpServletResponse response);
	public void reserveDeleteService(HttpServletRequest request, HttpServletResponse response);
	public void idCheckService(HttpServletRequest request, HttpServletResponse response);	
	public void loginService(HttpServletRequest request, HttpServletResponse response);
	public void reserveChange(HttpServletRequest request, HttpServletResponse response);
}
