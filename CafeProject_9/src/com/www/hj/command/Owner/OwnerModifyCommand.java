package com.www.hj.command.Owner;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.www.hj.DAO.Info.DAOInfoOwner;
import com.www.hj.DTO.Board.DTOWriteOwner;
import com.www.hj.DTO.info.DTOInfoOwner;
import com.www.hj.command.front.Command;


public class OwnerModifyCommand implements Command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		DAOInfoOwner ownerDAO = DAOInfoOwner.getDAOOwner();
		DTOWriteOwner myDTO = new DTOWriteOwner();
		
		String id= (String) session.getAttribute("id");
		myDTO = ownerDAO.modifyProfile(id,myDTO);
		
		session.setAttribute("myDTO", myDTO);
		System.out.println("modifyDTO_menuCommand: "+session.getAttribute("modifyDTO")); //
		
	}
}