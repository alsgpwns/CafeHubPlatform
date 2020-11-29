package com.www.hj.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.www.hj.DAO.Info.DAOInfo;
import com.www.hj.command.Info.GuestLoginCommand;
import com.www.hj.command.Info.JoinGuestCommand;
import com.www.hj.command.Info.JoinOwnerCommand;
import com.www.hj.command.Info.LogOutCommand;
import com.www.hj.command.Info.OwnerLoginCommand;
import com.www.hj.command.Owner.OnwerReprePictureWriteCommand;
import com.www.hj.command.Owner.OwnerMenuModifyCommand;
import com.www.hj.command.Owner.OwnerMenuWriteCommand;
import com.www.hj.command.Owner.OwnerModifyCommand;
import com.www.hj.command.Owner.OwnerPictureModifyCommand;
import com.www.hj.command.Owner.OwnerPictureWriteCommand;
import com.www.hj.command.Owner.OwnerReprePictureModifyCommand;
import com.www.hj.command.Owner.OwnerTextModifyCommand;
import com.www.hj.command.Owner.OwnerTextWriteCommand;
import com.www.hj.command.Owner.OwnerWriteCommand;
import com.www.hj.command.Writing.GuestLikeCommand;
import com.www.hj.command.Writing.OwnerLikeCommnad;
import com.www.hj.command.Writing.WritingCommand;
import com.www.hj.command.Writing.WritingGuestCommand;
import com.www.hj.command.Writing.WritingOwnerCommand;
import com.www.hj.command.Writing.YourCafeViewCommand;
import com.www.hj.command.front.Command;
import com.www.hj.command.front.mainCommand;
import com.www.hj.command.stamp.GuestStampCommand;
import com.www.hj.command.stamp.OwnerStampCommand;
import com.www.hj.command.wishList.GuestDeleteWishCommand;
import com.www.hj.command.wishList.GuestWishListCommand;
import com.www.hj.command.wishList.OwnerDeleteWishCommand;
import com.www.hj.command.wishList.OwnerWishListCommand;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public FrontController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String servletPath = request.getServletPath();
		String viewPage="null";
		Command cmd = null;
		System.out.println("path: "+servletPath);
		String id = (String) session.getAttribute("id");
		session.setAttribute("userId", id); // 로그인 아이디 저장

		//로그인
		if(servletPath.equals("/LoginPage/GuestLogin.do"))
		{
			cmd = new GuestLoginCommand();
			cmd.excute(request, response);
			boolean loginCheckFlag = (boolean) request.getAttribute("loginCheckFlag");
			if(loginCheckFlag) viewPage="LoginOk.jsp"; 
			else viewPage="/AlertPage/LoginError.jsp";

		}
		else if(servletPath.equals("/LoginPage/OwnerLogin.do"))
		{
			cmd = new OwnerLoginCommand();
			cmd.excute(request, response);
			boolean loginCheckFlag = (boolean) request.getAttribute("loginCheckFlag");
			if(loginCheckFlag) viewPage="LoginOkOwner.jsp";
			else viewPage="/AlertPage/LoginError.jsp";
		}

		//회원가입
		else if(servletPath.equals("/LoginPage/JoinOwner.do"))
		{
			cmd = new JoinOwnerCommand();
			cmd.excute(request, response);
			String JoinOwnerResult = (String)session.getAttribute("JoinCheckOwner");
			System.out.println("result: "+JoinOwnerResult);
			if (JoinOwnerResult.equals("OK")) viewPage="/AlertPage/LoginOk.jsp";
			else if (JoinOwnerResult.equals("passwordError")) {
				viewPage="/ErrorPage/OwnerJoinError.jsp";
			} 
			else if(JoinOwnerResult.equals("emailCountError")) viewPage="/ErrorPage/OwnerJoinEmailError.jsp";
		}
		else if(servletPath.equals("/LoginPage/JoinGuest.do"))
		{
			cmd = new JoinGuestCommand();
			cmd.excute(request, response);
			String JoinResult = (String)session.getAttribute("JoinCheck");
			if (JoinResult.equals("OK")) viewPage="/AlertPage/LoginOk.jsp";
			else if (JoinResult.equals("passwordError")) viewPage="/ErrorPage/GuestJoinError.jsp"; 
			else if(JoinResult.equals("emailCountError")) viewPage="/ErrorPage/GuestJoinEmailError.jsp";	
		}
		else if(servletPath.equals("/LoginPage/signOut.do") || servletPath.equals("/OwnerPage/signOut.do"))
		{
			cmd = new LogOutCommand();
			cmd.excute(request, response);
			viewPage="/AlertPage/LogOut.jsp";
		}
		
		////////
		//글쓰기 - 글 검사
		else if(servletPath.equals("/OwnerPage/write.do")||servletPath.equals("/LoginPage/write.do"))
		{
			cmd = new OwnerWriteCommand();
			cmd.excute(request, response);
			int check = (int) request.getAttribute("check");
			if(check==0) {				
				viewPage="/OwnerPage/OwnerTextWrite.jsp";
			}
			else viewPage="/AlertPage/WriteFail.jsp";
		}
		
		
		
		////////////
		//Owner_글쓰기
		else if(servletPath.equals("/OwnerPage/OwnerText.do")||servletPath.equals("/LoginPage/OwnerText.do"))
		{
			cmd= new OwnerTextWriteCommand();
			cmd.excute(request, response);
			viewPage="/OwnerPage/OwnerMenuWrite.jsp";
		}
		else if(servletPath.equals("/OwnerPage/OwnerPictureMenu.do")||servletPath.equals("/LoginPage/OwnerPictureMenu.do"))
		{
			cmd= new OwnerMenuWriteCommand();
			cmd.excute(request, response);
			viewPage="/OwnerPage/OwnerRepresentPictureWrite.jsp";
		}		
		else if(servletPath.equals("/OwnerPage/OwnerCafeReprePicture.do")||servletPath.equals("/LoginPage/OwnerCafeReprePicture.do"))
		{
			cmd = new OnwerReprePictureWriteCommand();
			cmd.excute(request, response);
			viewPage="/OwnerPage/OwnerPictureWrite.jsp";
		}
		else if(servletPath.equals("/OwnerPage/OwnerCafePicture.do")||servletPath.equals("/LoginPage/OwnerCafePicture.do"))
		{
			cmd = new OwnerPictureWriteCommand();
			cmd.excute(request, response);
			viewPage="/AlertPage/WriteOk.jsp";
		}
		
		//index (메인페이지)
		else if(servletPath.equals("/index.do"))
		{
			cmd = new mainCommand();
			cmd.excute(request, response);
			viewPage="/LoginPage/main.jsp";
		}
		
		//////////
		//owner 글 수정
		else if(servletPath.equals("/LoginPage/EdityourCafe.do")||servletPath.equals("/OwnerPage/EdityourCafe.do"))
		{
			cmd = new OwnerModifyCommand();
			cmd.excute(request, response);
			viewPage="/OwnerPage/OwnerCafeProfile.jsp";
		}
		else if(servletPath.equals("/LoginPage/OwnerTextModify.do")||servletPath.equals("/OwnerPage/OwnerTextModify.do"))
		{
			cmd = new OwnerTextModifyCommand(); //text 저장
			cmd.excute(request, response);
			viewPage="/OwnerPage/OwnerModifyMenu.jsp";
		}
		else if(servletPath.equals("/LoginPage/OwnerModifyReprePicture.do"))
		{
			cmd = new OwnerMenuModifyCommand();
			cmd.excute(request, response);
			viewPage="/OwnerPage/OwnerModifyReprePicture.jsp";
		}
		else if(servletPath.equals("/LoginPage/OwnerModifyPicture.do"))
		{
			cmd = new OwnerReprePictureModifyCommand();
			cmd.excute(request, response);
			viewPage="/OwnerPage/OwnerModifyPicture.jsp";
		}
		else if(servletPath.equals("/LoginPage/OwnerModifyPictureOk.do"))
		{
			cmd = new OwnerPictureModifyCommand();
			cmd.excute(request, response);
			viewPage="/AlertPage/OwnerModifyOk.jsp";
		}
		
		
		/////
		//카페 글 확인
		else if(servletPath.equals("/viewContents.do")||servletPath.equals("/LoginPage/viewContents.do"))
		{
			String type=request.getParameter("type");
			String writerId= request.getParameter("id");
			request.setAttribute("writerId", id);
			session.setAttribute("writingId", writerId);
			
			if(type.equals("guest"))
			{
				cmd = new WritingGuestCommand();
				cmd.excute(request, response);
				session.getAttribute("showDTO");
				viewPage="/viewWritingPage/GuestWritingPage.jsp";
				
			}
			else if(type.equals("owner"))
			{
				cmd = new WritingOwnerCommand();
				cmd.excute(request, response);
				session.getAttribute("showDTO");
				viewPage="/viewWritingPage/OwnerWritingPage.jsp";
			}
			else if(type.equals("default"))
			{
				cmd = new WritingCommand();
				cmd.excute(request, response);
				session.getAttribute("showDTO");
				viewPage="/viewWritingPage/WritingPage.jsp";
			}
		}
		
		//카페 내 글 확인
		else if(servletPath.equals("yourCafe.do")||servletPath.equals("/LoginPage/yourCafe.do"))
		{
			cmd = new YourCafeViewCommand();
			cmd.excute(request, response);
			session.getAttribute("showDTO");
			viewPage="/viewWritingPage/yourCafeView.jsp";
		}
		
		/////////
		//하트 (wish List) 담아주기
		else if(servletPath.equals("/LoginPage/iLikeIt.do") )
		{
			String likeType=request.getParameter("likeType");
			String likeId = request.getParameter("likeId");
			request.setAttribute("likeId", likeId);
			session.setAttribute("writingType", likeType);
			System.out.println("likeType: "+likeType);
			
			if(likeType.equals("guest"))
			{
				cmd = new GuestLikeCommand();
				cmd.excute(request, response);
				int check = (int) request.getAttribute("check");
				if(check==1) //wishList에 이미 있다면, 삭제
				{					
					viewPage="/AlertPage/WishListDelete.jsp"; //삭제 물어보기
				}
				else if(check==0) //wishList에 없다면,
				{
					viewPage="/AlertPage/WishListAdd.jsp"; // wishList보여주기
				}
			}
			else if(likeType.equals("owner"))
			{
				cmd = new OwnerLikeCommnad();
				cmd.excute(request, response);
				int check = (int) request.getAttribute("check");
				if(check==1) //wishList에 이미 있다면, 삭제
				{					
					viewPage="/AlertPage/WishListDelete.jsp";
				}
				else if(check==0) //wishList에 없다면,
				{
					viewPage="/AlertPage/WishListAdd.jsp"; // wishList보여주기
				}
				
			}
			else if(likeType.equals("default"))
			{
				viewPage="/ErrorPage/defaultwishListError.jsp";
			}
			
		}
		
		// wishList 찍어주기
		//1. guest
		else if(servletPath.equals("/LoginPage/viewGuestWishList.do"))
		{
			cmd = new GuestWishListCommand();
			cmd.excute(request, response);
			viewPage="/wishList/GuestWishList.jsp";
		}
		// 2. owner
		else if(servletPath.equals("/LoginPage/viewOwnerWishList.do"))
		{
			cmd = new OwnerWishListCommand();
			cmd.excute(request, response);
			viewPage="/wishList/OwnerWishList.jsp";
		}
		
		//wishList 삭제하기
		// 1.guest
		else if(servletPath.equals("/LoginPage/GuestDeleteWishList.do"))
		{
			String wishiId=(String)session.getAttribute("writingId");
			String wishType=(String)session.getAttribute("writingType");
			cmd = new GuestDeleteWishCommand();
			cmd.excute(request, response);
			viewPage="/LoginPage/viewContents.do?id="+wishiId+"&type="+wishType;
		}
		// 2.owner
		else if(servletPath.equals("/LoginPage/OnwerDeleteWishList.do"))
		{
			String wishiId=(String)session.getAttribute("writingId");
			String wishType=(String)session.getAttribute("writingType");
			cmd = new OwnerDeleteWishCommand();
			cmd.excute(request, response);
			viewPage="/LoginPage/viewContents.do?id="+wishiId+"&type="+wishType;
		}
		
		//stamp 페이지 찍어주기
		// 1. owner
		else if(servletPath.equals("/LoginPage/Ownerstamp.do") || servletPath.equals("/StampPage/ownerStamp.do"))
		{
			viewPage="/StampPage/ownerStamp.jsp";
		}
		//guest
		else if(servletPath.equals("/LoginPage/viewGuestStamp.do"))
		{
			cmd = new GuestStampCommand();
			cmd.excute(request, response);
			viewPage="/StampPage/guestStamp.jsp";
		}
		
		
		//stamp 적립하기
		else if(servletPath.equals("/LoginPage/ownerSaveStamp.do"))
		{
			String saveId=request.getParameter("saveID");
			String saveStamp=request.getParameter("saveStamp");
			session.setAttribute("saveId", saveId);
			session.setAttribute("saveStamp", saveStamp);
			viewPage="/AlertPage/OwnerStampCheck.jsp";
		}
		else if(servletPath.equals("/LoginPage/ownerSaveStampOK.do"))
		{
			cmd = new OwnerStampCommand();
			cmd.excute(request, response);
			viewPage="/AlertPage/OwnerStampOk.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
