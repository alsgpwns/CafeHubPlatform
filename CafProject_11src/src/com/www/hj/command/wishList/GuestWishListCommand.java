package com.www.hj.command.wishList;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.www.hj.DAO.wishList.WishListDAO;
import com.www.hj.DTO.Board.DTOWriteOwner;
import com.www.hj.command.front.Command;

// 게스트 wishList 찍어주기
public class GuestWishListCommand implements Command  {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("userId");

		WishListDAO dao = WishListDAO.getWishDAO();
		
		ArrayList<DTOWriteOwner> wishList = dao.showWishListGuest(id);
		
		ServletContext application = request.getServletContext();
		application.setAttribute("wishList", wishList);
		
	}
}
