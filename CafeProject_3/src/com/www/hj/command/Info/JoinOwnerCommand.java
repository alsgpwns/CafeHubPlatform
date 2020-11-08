package com.www.hj.command.Info;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.www.hj.DAO.Info.DAOInfo;
import com.www.hj.DTO.info.DTOInfoOwner;
import com.www.hj.command.front.Command;


public class JoinOwnerCommand implements Command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phoneNumber = request.getParameter("countryNumber") + request.getParameter("userPoneNumber");
		
		DTOInfoOwner ownerDTO = new DTOInfoOwner();
		
		
		ownerDTO.setId(request.getParameter("userId"));
		ownerDTO.setPw(request.getParameter("userPw"));
		ownerDTO.setName(request.getParameter("userName"));
		ownerDTO.setPermissionNumber(request.getParameter("userPermission"));
		ownerDTO.setPhoneNumber(phoneNumber);
		ownerDTO.setEmail(request.getParameter("UserEmail"));
		
		HttpSession session = request.getSession();
		String hashTag = (String)session.getAttribute("hashTagArr");
		System.out.println("hashTag: "+hashTag);
		System.out.println("hashTagArr: "+session.getAttribute("hashTagArr"));
	}
}
