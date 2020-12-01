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
import com.www.admin.DTO.reportDTO;
import com.www.hj.command.front.Command;

public class viewReportCommand implements Command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOAdmin dao = DAOAdmin.getDAOAdmin();
		 ArrayList<reportDTO> reportList =dao.viewReport();
		 
		ServletContext application=request.getServletContext();
		application.setAttribute("reportList", reportList);
	}
}
