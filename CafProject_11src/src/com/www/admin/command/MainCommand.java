package com.www.admin.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.www.admin.DAO.DAOAdmin;
import com.www.hj.DTO.Board.DTOWriteOwner;
import com.www.hj.command.front.Command;

public class MainCommand implements Command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOAdmin dao = DAOAdmin.getDAOAdmin();
		ArrayList<DTOWriteOwner> adminList = dao.viewBoard();
		
		ServletContext application=request.getServletContext();
		application.setAttribute("adminList", adminList);
	}
}
