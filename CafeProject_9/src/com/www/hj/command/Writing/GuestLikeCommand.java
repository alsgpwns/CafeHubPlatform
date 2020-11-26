package com.www.hj.command.Writing;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.www.hj.DAO.wishList.WishListDAO;
import com.www.hj.command.front.Command;

public class GuestLikeCommand implements Command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		WishListDAO dao = WishListDAO.getWishDAO();
		String likeId =(String)request.getAttribute("likeId");
		String userId =(String)session.getAttribute("id");
		System.out.println("id_command: "+userId);
		System.out.println("likeId_command: "+likeId);
		
		
		int check = dao.wishListGuestCheck(likeId, userId);
		//이미 wishlist에 있으면 1, 없으면 0
		if(check==1)
		{
			//삭제할건지 물어보는 page
		}
		else if(check==0)
		{
			dao.addWishListGuest(likeId, userId);	
		}
		String idSet = dao.loadWishListGuest(userId);
		dao.viewWishListGuest(idSet);
		
		System.out.println("check:"+check);
		request.setAttribute("check", check);
		
	}
}
