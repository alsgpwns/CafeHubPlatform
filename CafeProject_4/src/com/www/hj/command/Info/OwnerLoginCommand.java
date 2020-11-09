package com.www.hj.command.Info;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.www.hj.DAO.Info.DAOInfo;
import com.www.hj.command.front.Command;

public class OwnerLoginCommand implements Command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		DAOInfo infoDAO = DAOInfo.getDAOInfo();
		
		boolean loginCheckFlag = infoDAO.ownerLoginCheck(userId, userPw);
		request.setAttribute("loginCheckFlag", loginCheckFlag);
	}
}
