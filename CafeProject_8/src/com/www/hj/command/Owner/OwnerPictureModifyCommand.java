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


public class OwnerPictureModifyCommand implements Command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		DTOWriteOwner myDTO = (DTOWriteOwner) session.getAttribute("myDTO");
		DAOInfoOwner ownerDAO = DAOInfoOwner.getDAOOwner();
		
		String picture1 =null, picture2=null, picture3=null, picture4=null, picture5=null, picture6=null, picture7=null;
		
		ServletContext application = request.getServletContext();
		String contextPath=application.getContextPath();
		String path= application.getRealPath("UploadFolder_Owner");
		int count = 0;
		
		try {
			MultipartRequest multi = new MultipartRequest(request,path,1024 * 1024 * 10,"UTF-8",new DefaultFileRenamePolicy());
			Enumeration files = multi.getFileNames();
			
			while(files.hasMoreElements())
			{
				count++;
				String str = (String)files.nextElement();
				System.out.println("파일명: "+multi.getFilesystemName(str));
				
				if(count==1)
				{
					if(multi.getFilesystemName(str)!=null)
					{
						picture1 = contextPath+"/UploadFolder_Owner/" + multi.getFilesystemName(str);
					}
					else
					{
						picture1 = myDTO.getCafePicture1();
					}
				}
				
				if(count==2)
				{
					if(multi.getFilesystemName(str)!=null)
					{
						picture2 = contextPath+"/UploadFolder_Owner/" + multi.getFilesystemName(str);
					}
					else
					{
						picture2 = myDTO.getCafePicture1();
					}
				}
				
				if(count==3)
				{
					if(multi.getFilesystemName(str)!=null)
					{
						picture3 = contextPath+"/UploadFolder_Owner/" + multi.getFilesystemName(str);
					}
					else
					{
						picture3 = myDTO.getCafePicture1();
					}
				}
				
				if(count==4)
				{
					if(multi.getFilesystemName(str)!=null)
					{
						picture4 = contextPath+"/UploadFolder_Owner/" + multi.getFilesystemName(str);
					}
					else
					{
						picture4 = myDTO.getCafePicture1();
					}
				}
				
				if(count==5)
				{
					if(multi.getFilesystemName(str)!=null)
					{
						picture5 = contextPath+"/UploadFolder_Owner/" + multi.getFilesystemName(str);
					}
					else
					{
						picture5 = myDTO.getCafePicture1();
					}
				}
				
				if(count==6)
				{
					if(multi.getFilesystemName(str)!=null)
					{
						picture6 = contextPath+"/UploadFolder_Owner/" + multi.getFilesystemName(str);
					}
					else
					{
						picture6 = myDTO.getCafePicture1();
					}
				}
				
				if(count==7)
				{
					if(multi.getFilesystemName(str)!=null)
					{
						picture7 = contextPath+"/UploadFolder_Owner/" + multi.getFilesystemName(str);
					}
					else
					{
						picture7 = myDTO.getCafePicture1();
					}
				}
				
				
			}

		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		myDTO.setCafePicture1(picture1);
		myDTO.setCafePicture2(picture2);
		myDTO.setCafePicture3(picture3);
		myDTO.setCafePicture4(picture4);
		myDTO.setCafePicture5(picture5);
		myDTO.setCafePicture6(picture6);
		myDTO.setCafePicture7(picture7);
		
		ownerDAO.modifyPrifileOK(myDTO);
		
		
		
		
		
		
	}
}