package com.www.hj.command.Owner;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.www.hj.DTO.Board.DTOWriteOwner;
import com.www.hj.command.front.Command;


public class OwnerTextWriteCommand implements Command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		DTOWriteOwner writeDTO =new DTOWriteOwner();
		String Hours=request.getParameter("cafeOpen")+request.getParameter("openHour")+" ~ "+request.getParameter("cafeClose")+request.getParameter("CloseHour");
		String BreakTime=request.getParameter("BreakStart")+request.getParameter("BreakStartHour")+" "+request.getParameter("BreakEnd")+request.getParameter("BreakEndHour");
		String LastOrder=request.getParameter("lastOrder")+request.getParameter("SelectLastOrder");

		//DTO에 저장
		writeDTO.setCafeName(request.getParameter("cafeName"));
		writeDTO.setCafeNumber(request.getParameter("cafeNumber"));
		writeDTO.setCafeMenu(request.getParameter("cafeMenu"));
		writeDTO.setCafePrice(request.getParameter("price"));
		writeDTO.setCafeParking(request.getParameter("cafeParking"));
		writeDTO.setCafeHours(Hours);
		writeDTO.setCafeBreakeTime(BreakTime);
		writeDTO.setCafeLastorder(LastOrder);
		writeDTO.setCafeIntroduce(request.getParameter("cafeIntroduce"));
		writeDTO.setCafeHashTag(request.getParameter("hashtag"));
		writeDTO.setId((String)session.getAttribute("id"));
		writeDTO.setcafeAddress(request.getParameter("cafeAddress"));
		
		session.setAttribute("ownerDTO", writeDTO);
	}
}