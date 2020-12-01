package com.www.hj.command.wishList;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.www.hj.DAO.wishList.WishListDAO;
import com.www.hj.command.front.Command;

public class OwnerDeleteWishCommand implements Command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		WishListDAO dao = WishListDAO.getWishDAO();
		String writerId =(String)session.getAttribute("writingId");
		String userId = (String)session.getAttribute("userId");
		
		dao.deleteWishListOwner(userId, writerId);
		dao.decresLikeGuest(writerId);
	}
}
