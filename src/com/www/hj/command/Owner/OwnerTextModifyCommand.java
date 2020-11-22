package com.www.hj.command.Owner;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.www.hj.DAO.Info.DAOInfoOwner;
import com.www.hj.DTO.Board.DTOWriteOwner;
import com.www.hj.command.front.Command;

public class OwnerTextModifyCommand implements Command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		DTOWriteOwner myDTO = (DTOWriteOwner) session.getAttribute("myDTO");
		System.out.println("modifyDTO_textCommand: "+session.getAttribute("modifyDTO")); //주석
		
		String Hours=request.getParameter("cafeOpen")+request.getParameter("openHour")+" ~ "+request.getParameter("cafeClose")+request.getParameter("CloseHour");
		String BreakTime=request.getParameter("BreakStart")+request.getParameter("BreakStartHour")+" "+request.getParameter("BreakEnd")+request.getParameter("BreakEndHour");
		String LastOrder=request.getParameter("lastOrder")+request.getParameter("SelectLastOrder");

		//DTO에 저장
		myDTO.setCafeName(request.getParameter("cafeName"));
		myDTO.setCafeNumber(request.getParameter("cafeNumber"));
		myDTO.setCafeMenu(request.getParameter("cafeMenu"));
		myDTO.setCafePrice(request.getParameter("price"));
		myDTO.setCafeParking(request.getParameter("cafeParking"));
		myDTO.setCafeHours(Hours);
		myDTO.setCafeBreakeTime(BreakTime);
		myDTO.setCafeLastorder(LastOrder);
		myDTO.setCafeIntroduce(request.getParameter("cafeIntroduce"));
		myDTO.setCafeHashTag(request.getParameter("hashtag"));
		myDTO.setId((String)session.getAttribute("id"));
		myDTO.setcafeAddress(request.getParameter("cafeAddress"));
		
		session.setAttribute("myDTO", myDTO);
		
	}
}
