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
import com.www.hj.command.Info.LogOutCommand;
import com.www.hj.command.Info.OwnerLoginCommand;
import com.www.hj.command.Owner.OnwerReprePictureWriteCommand;
import com.www.hj.command.Owner.OwnerMenuWriteCommand;
import com.www.hj.command.Owner.OwnerPictureWriteCommand;
import com.www.hj.command.Owner.OwnerTextWriteCommand;
import com.www.hj.command.front.Command;
import com.www.hj.command.front.mainCommand;

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
		System.out.println("Front id: "+session.getAttribute("id")); //주석

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
			if(loginCheckFlag) viewPage="LoginOkOwner.jsp"; //suply Loginpage 나누기
			else viewPage="/AlertPage/LoginError.jsp";
		}

		//회원가입
		else if(servletPath.equals("/LoginPage/JoinOwner.do"))
		{
			cmd = new JoinOwnerCommand();
			cmd.excute(request, response);
			String JoinOwnerResult = (String)session.getAttribute("JoinCheckOwner");
			System.out.println("result: "+JoinOwnerResult);
			if (JoinOwnerResult.equals("OK")) viewPage="/AlertPage/LoginOk.jsp";
			else if (JoinOwnerResult.equals("passwordError")) {
				viewPage="/ErrorPage/OwnerJoinError.jsp";
			} 
			else if(JoinOwnerResult.equals("emailCountError")) viewPage="/ErrorPage/OwnerJoinEmailError.jsp";
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
		else if(servletPath.equals("/LoginPage/signOut.do"))
		{
			cmd = new LogOutCommand();
			cmd.excute(request, response);
			viewPage="/AlertPage/LogOut.jsp";
		}
		
		//Owner_글쓰기
		else if(servletPath.equals("/OwnerPage/OwnerText.do"))
		{
			cmd= new OwnerTextWriteCommand();
			cmd.excute(request, response);
			viewPage="/OwnerPage/OwnerMenuWrite.jsp";
		}
		else if(servletPath.equals("/OwnerPage/OwnerPictureMenu.do"))
		{
			cmd= new OwnerMenuWriteCommand();
			cmd.excute(request, response);
			viewPage="/OwnerPage/OwnerRepresentPictureWrite.jsp";
		}		
		else if(servletPath.equals("/OwnerPage/OwnerCafeReprePicture.do"))
		{
			cmd = new OnwerReprePictureWriteCommand();
			cmd.excute(request, response);
			viewPage="/OwnerPage/OwnerPictureWrite.jsp";
		}
		else if(servletPath.equals("/OwnerPage/OwnerCafePicture.do"))
		{
			cmd = new OwnerPictureWriteCommand();
			cmd.excute(request, response);
			viewPage="/AlertPage/WriteOk.jsp";
		}
		
		//index
		else if(servletPath.equals("/index.do"))
		{
			System.out.println("index");
			cmd = new mainCommand();
			cmd.excute(request, response);
			viewPage="/LoginPage/main.jsp";
		}

		


		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
