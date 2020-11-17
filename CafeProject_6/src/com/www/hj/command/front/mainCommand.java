package com.www.hj.command.front;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.www.hj.DAO.Info.DAOInfo;
import com.www.hj.DTO.Board.DTOWriteOwner;

public class mainCommand implements Command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOInfo dao = DAOInfo.getDAOInfo();
		ArrayList<DTOWriteOwner> list = dao.viewBoard();
		
		ServletContext application=request.getServletContext();
		application.setAttribute("list", list);

		
	}
}

