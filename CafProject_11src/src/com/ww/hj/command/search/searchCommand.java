package com.ww.hj.command.search;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.www.hj.DAO.search.DAOSearch;
import com.www.hj.DTO.Board.DTOWriteOwner;
import com.www.hj.command.front.Command;


public class searchCommand implements Command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOSearch dao = DAOSearch.getSearchDAO();
		String woard=(String)request.getAttribute("searchWord");
		ArrayList<DTOWriteOwner> searchList = dao.loadCafeInfo(woard);
		
		ServletContext application=request.getServletContext();
		application.setAttribute("searchList", searchList);
	}
}
