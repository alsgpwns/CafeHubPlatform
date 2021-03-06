package com.www.hj.command.Writing;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.www.hj.DAO.Info.DAOInfo;
import com.www.hj.DAO.Info.WritingDAO;
import com.www.hj.DTO.Board.DTOWriteOwner;
import com.www.hj.command.front.Command;


public class WritingCommand implements Command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String writerId= request.getParameter("id");
		System.out.println("여기 ID: "+writerId);
		WritingDAO dao = WritingDAO.getDAOInfo();
		DTOWriteOwner showDTO =new DTOWriteOwner();
		
		showDTO = dao.showWriting(writerId,showDTO);
		
		session.setAttribute("showDTO", showDTO);

	}
}

