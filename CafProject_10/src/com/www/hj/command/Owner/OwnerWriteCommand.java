package com.www.hj.command.Owner;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.www.hj.DAO.Info.DAOInfoOwner;
import com.www.hj.command.front.Command;

public class OwnerWriteCommand implements Command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			DAOInfoOwner dao = DAOInfoOwner.getDAOOwner();
			HttpSession session = request.getSession();
			String id= (String) session.getAttribute("id");
			int check = dao.ownerCheck(id);
			
			request.setAttribute("check", check);
			
	}
}
