package com.www.admin.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.www.admin.command.MainCommand;
import com.www.admin.command.viewReportCommand;
import com.www.hj.command.Info.GuestLoginCommand;
import com.www.hj.command.front.Command;

@WebServlet("*.go")
public class AmdinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public AmdinController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage="null";
		Command cmd = null;
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String servletPath = request.getServletPath();
		System.out.println("path: "+servletPath);
		
		if(servletPath.equals("/AdminPage/adminIndex.go"))
		{
			cmd = new MainCommand();
			cmd.excute(request, response);
			viewPage="/AdminPage/AdminMain.jsp";
		}
		
		// 신고 알림창
		else if(servletPath.equals("/AdminPage/viewReport.go"))
		{
			cmd = new viewReportCommand();
			cmd.excute(request, response);
			viewPage="/AdminPage/viewReport.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}