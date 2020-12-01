package com.www.hj.command.stamp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.www.hj.DAO.stamp.DAOStamp;
import com.www.hj.DAO.wishList.WishListDAO;
import com.www.hj.command.front.Command;

public class OwnerStampCommand implements Command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOStamp dao = DAOStamp.getDAOStamp();
		HttpSession session = request.getSession();
		String ownerNumber=(String)session.getAttribute("ownerNumber"); 
		String cafeName=(String)session.getAttribute("cafeName");
		String saveId = (String)session.getAttribute("saveId");
		String saveStamp=(String)session.getAttribute("saveStamp");
		
		int check = dao.checkStampCafe(cafeName, ownerNumber);
		
		if(check==1) //이미 있다면
		{
			dao.updateStamp(saveId,saveStamp,ownerNumber);
		}
		else if(check==0)
		{
			dao.insertStamp(saveId, saveStamp, cafeName, ownerNumber);
		}
		
				
		
	}
}
