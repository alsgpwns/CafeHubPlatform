package com.www.hj.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.www.hj.DAO.Info.DAOInfo;
import com.www.hj.command.Info.GuestLoginCommand;
import com.www.hj.command.Info.JoinGuestCommand;
import com.www.hj.command.Info.JoinOwnerCommand;
import com.www.hj.command.Info.OwnerLoginCommand;
import com.www.hj.command.front.Command;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}
	
	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String servletPath = request.getServletPath();
		String viewPage="null";
		Command cmd = null;
		System.out.println("path: "+servletPath);
		
		//로그인
		if(servletPath.equals("/LoginPage/GuestLogin.do"))
		{
			cmd = new GuestLoginCommand();
			cmd.excute(request, response);
			boolean loginCheckFlag = (boolean) request.getAttribute("loginCheckFlag");
			if(loginCheckFlag) viewPage="LoginOk.jsp"; //user Loginpage 나누기
			else viewPage="/AlertPage/LoginError.jsp";
			
		}
		else if(servletPath.equals("/LoginPage/OwnerLogin.do"))
		{
			cmd = new OwnerLoginCommand();
			cmd.excute(request, response);
			boolean loginCheckFlag = (boolean) request.getAttribute("loginCheckFlag");
			if(loginCheckFlag) viewPage="/AlertPage/LoginOk.jsp"; //suply Loginpage 나누기
			else viewPage="/AlertPage/LoginError.jsp";
		}
		
		//회원가입
		else if(servletPath.equals("/LoginPage/JoinOwner.do"))
		{
			cmd = new JoinOwnerCommand();
			cmd.excute(request, response);
			viewPage="/AlertPage/LoginOk.jsp";
		}
		else if(servletPath.equals("/LoginPage/JoinGuest.do"))
		{
			cmd = new JoinGuestCommand();
			cmd.excute(request, response);
			String JoinResult = (String)session.getAttribute("JoinCheck");
			if (JoinResult.equals("OK")) viewPage="/AlertPage/LoginOk.jsp";
			else if (JoinResult.equals("passwordError")) viewPage="/ErrorPage/GuestJoinError.jsp"; 
			else if(JoinResult.equals("emailCountError")) viewPage="/ErrorPage/GuestJoinEmailError.jsp";
			
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
