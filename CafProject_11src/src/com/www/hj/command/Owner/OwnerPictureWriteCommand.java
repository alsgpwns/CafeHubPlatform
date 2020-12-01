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
import com.www.hj.command.front.Command;

/**
 * Servlet implementation class OwnerPictureWriteCommand
 */
@WebServlet("/OwnerPictureWriteCommand")
public class OwnerPictureWriteCommand implements Command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOInfoOwner ownerDAO = DAOInfoOwner.getDAOOwner();
		HttpSession session = request.getSession();
		DTOWriteOwner ownerDTO = (DTOWriteOwner) session.getAttribute("ownerDTO");
		System.out.println("ownerDTO4: "+ownerDTO);
		
		//cos
		String picture1=null, picture2=null, picture3=null, picture4=null, picture5=null, picture6=null, picture7=null;
		ServletContext application=request.getServletContext();
		String contextPath=application.getContextPath();
		String path=application.getRealPath("UploadFolder_Owner");
		
		int count=0;
		
		
		try {
			MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
			Enumeration files=multi.getFileNames();
			
			while(files.hasMoreElements())
			{
				count++;
				String str=(String)files.nextElement();
				
				if(count==1)
				{
					picture1 = contextPath+"/UploadFolder_Owner/" +  multi.getFilesystemName(str);
				}
				else if(count==2)
				{
					picture2 = contextPath+"/UploadFolder_Owner/" +  multi.getFilesystemName(str);
				}
				else if(count==3)
				{
					picture3 = contextPath+"/UploadFolder_Owner/" +  multi.getFilesystemName(str);
				}
				else if(count==4)
				{
					picture4 = contextPath+"/UploadFolder_Owner/" +  multi.getFilesystemName(str);
				}
				else if(count==5)
				{
					picture5 = contextPath+"/UploadFolder_Owner/" + multi.getFilesystemName(str);
				}
				else if(count==6)
				{
					picture6 = contextPath+"/UploadFolder_Owner/" +  multi.getFilesystemName(str);
				}
				else if(count==7)
				{
					picture7 = contextPath+"/UploadFolder_Owner/" +  multi.getFilesystemName(str);
				}
			
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
			//DTO에 저장
			ownerDTO.setCafePicture1(picture1);
			ownerDTO.setCafePicture2(picture2);
			ownerDTO.setCafePicture3(picture3);
			ownerDTO.setCafePicture4(picture4);
			ownerDTO.setCafePicture5(picture5);
			ownerDTO.setCafePicture6(picture6);
			ownerDTO.setCafePicture7(picture7);
		
			//DAO 호출
			ownerDAO.wirteInfoStore(ownerDTO);
		
	}
}