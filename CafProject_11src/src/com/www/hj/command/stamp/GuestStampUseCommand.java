package com.www.hj.command.stamp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.www.hj.DAO.stamp.DAOStamp;
import com.www.hj.command.front.Command;

public class GuestStampUseCommand implements Command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOStamp dao = DAOStamp.getDAOStamp();
		String stampNum=(String)request.getAttribute("stampNum");
		String cafeNumber=(String)request.getAttribute("cafeNumber");
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("userId");
		
		int userStamp =dao.checkStampNum(id, cafeNumber);
		int stamp = Integer.parseInt(stampNum);
		System.out.println("userStamp: "+userStamp);
		
		if(userStamp>=stamp)
		{			
			System.out.println("check>=stamp");
			int stampFlag=0;
			request.setAttribute("stampFlag", stampFlag);
			dao.decresstampNum(stampNum, cafeNumber, id);
		}
		else
		{
			System.out.println("else");
			int stampFlag=1;
			request.setAttribute("stampFlag", stampFlag);
		}
		
	}
}
