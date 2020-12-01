package com.www.hj.command.Owner;

import java.io.IOException;
import java.util.ArrayList;
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
import com.www.hj.DAO.Info.DAOInfo;
import com.www.hj.DTO.Board.DTOWriteOwner;
import com.www.hj.command.front.Command;


public class OwnerReprePictureModifyCommand implements Command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		DTOWriteOwner myDTO = (DTOWriteOwner) session.getAttribute("myDTO");
		String picture=null;
		
		//path저장
		ServletContext application = request.getServletContext();
		String contextPath=application.getContextPath();
		String path= application.getRealPath("UploadFolder_Owner");
		
		try {
			MultipartRequest multi = new MultipartRequest(request,path,1024 * 1024 * 10,"UTF-8",new DefaultFileRenamePolicy());
			Enumeration files = multi.getFileNames();
			
			while(files.hasMoreElements())
			{
				String str = (String)files.nextElement();
				System.out.println("파일명: "+multi.getFilesystemName(str));

				if(multi.getFilesystemName(str)!=null)
				{
					picture = contextPath+"/UploadFolder_Owner/" + multi.getFilesystemName(str);
				}
				else
				{
					picture = myDTO.getCafeReprePicture();
				}
			}

		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("picture: "+picture);
		myDTO.setCafeReprePicture(picture);
		
	}
}
