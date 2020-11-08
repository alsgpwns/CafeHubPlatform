package com.www.hj.command.Info;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.www.hj.DAO.Info.DAOInfo;
import com.www.hj.DTO.info.DTOInfoGuest;
import com.www.hj.command.front.Command;

public class JoinGuestCommand implements Command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		String phoneNumber = request.getParameter("countryNumber") + request.getParameter("userPoneNumber");
		DTOInfoGuest dto = new DTOInfoGuest();
		DAOInfo dao = DAOInfo.getDAOInfo();
		
		String userPw=request.getParameter("userPw");
		String userPwCheck = request.getParameter("userPwCheck");
		
		String likingType = request.getParameter("hashtag");
		if(likingType.length()<=3)
		{
			likingType="none";
		}
		
		//PW check
		String JoinCheck=null;
		if( userPw.equals(userPwCheck) && userPw.length()>=8 )
		{
			JoinCheck="OK";
			
			//저장
			dto.setId(request.getParameter("userId"));
			dto.setPw(request.getParameter("userPw"));
			dto.setPhoneNumber(phoneNumber);
			dto.setEmail(request.getParameter("UserEmail"));
			dto.setHastag(likingType);
			dao.JoinGuest(dto);
		}else {
			JoinCheck="fail";
			
		}
		session.setAttribute("JoinCheck", JoinCheck);


	}
}
