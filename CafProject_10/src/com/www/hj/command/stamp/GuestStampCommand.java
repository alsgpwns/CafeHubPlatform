package com.www.hj.command.stamp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.www.hj.DAO.stamp.DAOStamp;
import com.www.hj.DTO.Board.DTOWriteOwner;
import com.www.hj.command.front.Command;


public class GuestStampCommand implements Command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOStamp dao = DAOStamp.getDAOStamp();
		HttpSession session = request.getSession();
		String userId=(String)session.getAttribute("userId");
		
		String cafeNumberSet = dao.loadCafeNumber(userId);
		System.out.println("cafeNumberSet: "+cafeNumberSet);
		
		ArrayList<DTOWriteOwner> stampList= dao.loadCafeInfo(cafeNumberSet);
		ServletContext application=request.getServletContext();
		application.setAttribute("stampList", stampList);
		
	}
}
