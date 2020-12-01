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

public class OwnerLikeCommnad implements Command{
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		WishListDAO dao = WishListDAO.getWishDAO();
		String likeId=(String)request.getAttribute("likeId");
		String userId=(String)session.getAttribute("id");
		
		System.out.println("likeId: "+likeId);
		System.out.println("userId: "+userId);
		
		int check =dao.wishListOwnerCheck(likeId, userId);
		
		if(check == 1)
		{
			
		}
		else if(check==0)
		{
			dao.addWishListOwner(likeId,userId);
			dao.increasesLikeOwner(likeId);
		}
		request.setAttribute("check", check);
	}
}
