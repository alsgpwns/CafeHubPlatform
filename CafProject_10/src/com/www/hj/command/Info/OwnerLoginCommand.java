package com.www.hj.command.Info;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.www.hj.DAO.Info.DAOInfo;
import com.www.hj.command.front.Command;

public class OwnerLoginCommand implements Command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		DAOInfo infoDAO = DAOInfo.getDAOInfo();
		
		boolean loginCheckFlag = infoDAO.ownerLoginCheck(userId, userPw);
		request.setAttribute("loginCheckFlag", loginCheckFlag);
		
		if(loginCheckFlag)
		{
			session.setAttribute("id", userId); //세션에 ID저장
			String ownerNumber = infoDAO.ownerNumber(userId); //세션에 Number저장
			session.setAttribute("ownerNumber", ownerNumber);
			
			String cafeName = infoDAO.ownerCafeName(userId); //세션에 Name저장
			session.setAttribute("cafeName", cafeName);
		}
		
	}
}
