package com.koitt.baby.controller;

import java.io.IOException;

import com.koitt.baby.service.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HrsysController
 */
@WebServlet("*.do")
public class HrsysController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HrsysController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("EUC-KR");
		String nextPage="";
		
		String contextPath = request.getContextPath();
		String requestURI = request.getRequestURI();
		String command = requestURI.substring(contextPath.length());
		
		if(command.equals("/insert.do")){
				
			HrsysCommand hc = new HrsysMemberInsertCommand();
			hc.memberInsertService(request, response);
			nextPage="/jsp/memberInsert.jsp";
		}
		
		if(command.equals("/idCheck.do")){
			System.out.println("중복확인 서블릿 진입>>");

		}
		
		if(command.equals("/login.do")){
			System.out.println("로그인 서블릿 진입>>");
			HrsysCommand hc = new HrsysLoginCommand();
			hc.loginService(request, response);
			nextPage="/jsp/login.jsp";
		}
		
		if(command.equals("/update.do")){
			System.out.println("수정 서블릿 진입>>");
			
			HrsysCommand hc = new HrsysMemberUpdateCommand();
			hc.memberUpdateService(request, response);
			nextPage="/jsp/memberUpdate.jsp";
			
		}
		
		if(command.equals("/memberSelect.do")){
			System.out.println("멤버조회 서블릿 진입>>");
			HttpSession session = request.getSession();
			String mid = (String)session.getAttribute("mid");
			
			HrsysCommand hc = new HrsysMemberSelectCommand();
			hc.memberSelectService(request, response);
			nextPage="/jsp/memberSelect.jsp";
			
		}
		
		if(command.equals("/delete.do")){
			System.out.println("삭제 서블릿 진입>>");
			HrsysCommand hc = new HrsysMemberDeleteCommand();
			hc.memberDeleteService(request, response);
			nextPage="/jsp/memberDelete.jsp";
			
		}
		
		if(command.equals("/logout.do")){
			System.out.println("로그아웃 서블릿 진입>>");
			HttpSession session = request.getSession();
			session.removeAttribute("mid");
			nextPage="/jsp/logout.jsp";
			
		}
		
		if(command.equals("/reserve.do")){
			System.out.println("예약 서블릿 진입>>");
			HttpSession session = request.getSession();
			String mno = (String)session.getAttribute("mno");
			System.out.println("mno >> " + mno);
			HrsysCommand hc = new HrsysReserveInsertCommand();
			hc.reserveInsertService(request, response);
			nextPage="/jsp/reserveInsert.jsp";
			
		}
		
		if(command.equals("/reserveSelect.do")){
			System.out.println("예약조회 서블릿 진입>>");
			HttpSession session = request.getSession();
			String mno = (String)session.getAttribute("mno");
			System.out.println("mno >> " + mno);
			HrsysCommand hc = new HrsysReserveSelectCommand();
			hc.reserveSelectService(request, response);
			nextPage="/jsp/reserveList.jsp";
			
		}
		
		if(command.equals("/reserveChange.do")){
			System.out.println("예약 한 건 조회 서블릿 진입>>");
			HttpSession session = request.getSession();
			String rno = (String)session.getAttribute("rno");
			HrsysCommand hc = new HrsysReserveChangeCommand();
			hc.reserveChange(request, response);
			nextPage="/jsp/reserveChange.jsp";
			
		}
		
		if(command.equals("/reserveDelete.do")){
			System.out.println("예약취소 서블릿 진입>>");
			HrsysCommand hc = new HrsysReserveDeleteCommand();
			hc.reserveDeleteService(request, response);
			nextPage="/jsp/reserveDeleteResult.jsp";
			
		}
		
		if(command.equals("/reserveUpdate.do")){
			System.out.println("예약수정 서블릿 진입>>");
			HrsysCommand hc = new HrsysReserveUpdateCommand();
			hc.reserveUpdateService(request, response);
			nextPage="/jsp/reserveChangeResult.jsp";
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
