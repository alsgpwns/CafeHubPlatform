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

import com.www.hj.DAO.Info.DAOInfo;
import com.www.hj.DAO.Info.DAOInfoOwner;
import com.www.hj.DTO.Board.DTOWriteOwner;
import com.www.hj.command.front.Command;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

public class OwnerMenuWriteCommand implements Command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		DTOWriteOwner ownerDTO = (DTOWriteOwner) session.getAttribute("ownerDTO");
		ServletContext application=request.getServletContext();
		String contextPath=application.getContextPath();
		
		/* cos: 사진 저장 */
		String menu1=null, menu2=null, menu3=null;

		int count=0;
		String path=request.getSession().getServletContext().getRealPath("UploadFolder_Owner");
		System.out.println("path: "+path);
		try {
			MultipartRequest multi = new MultipartRequest(request,path,1024 * 1024 * 10,"UTF-8",new DefaultFileRenamePolicy());
			Enumeration files = multi.getFileNames();

			
			while(files.hasMoreElements())
			{
				count++;
				String str = (String)files.nextElement();
				if(count==1)
				{					
					menu1 = contextPath+"/UploadFolder_Owner/" + multi.getFilesystemName(str);
				}
				else if(count==2)
				{
					menu2 = contextPath+"/UploadFolder_Owner/" +multi.getFilesystemName(str);
				}
				else if(count==3)
				{
					menu3 =contextPath+"/UploadFolder_Owner/" +multi.getFilesystemName(str);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	
	
		//request.getParameter("hashtag");
		System.out.println("menu1: "+menu1);
		System.out.println("menu2: "+menu2);
		System.out.println("menu3: "+menu3);
		
		
		//DTO에 저장
		ownerDTO.setCafeMenu1(menu1);			
		ownerDTO.setCafeMenu2(menu2);
		ownerDTO.setCafeMenu3(menu3);


	
	
	
	}
}