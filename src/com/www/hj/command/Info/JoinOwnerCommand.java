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
		HttpSession session =request.getSession();
		String phoneNumber = request.getParameter("countryNumber") + request.getParameter("userPoneNumber");
		DTOInfoOwner ownerDTO = new DTOInfoOwner();
		DAOInfo dao = DAOInfo.getDAOInfo();
		
		String userPw=request.getParameter("userPw");
		String userPwCheck = request.getParameter("userPwCheck");
		
		String JoinCheck=null;
		int emailCount = dao.ownerDuplecateEmail(request.getParameter("UserEmail"));
	
		//PW check
		if( userPw.equals(userPwCheck) && userPw.length()>=8 && emailCount<3)
		{
			JoinCheck="OK";
			//저장
			ownerDTO.setId(request.getParameter("userId"));
			ownerDTO.setPw(request.getParameter("userPw"));
			ownerDTO.setPhoneNumber(phoneNumber);
			ownerDTO.setEmail(request.getParameter("UserEmail"));
			dao.JoinOwner(ownerDTO);
		}else if(emailCount>2) {
			JoinCheck="emailCountError";
		}
		else {
			JoinCheck="passwordError";	
		}
		System.out.println("emailCount: "+emailCount);
		
		//이메일 체크
		session.setAttribute("JoinCheckOwner", JoinCheck);
		session.setAttribute("userID", request.getParameter("userId"));
		
		
		
		

	}
}
