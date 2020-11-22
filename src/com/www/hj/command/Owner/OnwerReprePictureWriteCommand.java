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


public class OnwerReprePictureWriteCommand implements Command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOInfoOwner ownerDAO = DAOInfoOwner.getDAOOwner();
		HttpSession session = request.getSession();
		
		DTOWriteOwner ownerDTO = (DTOWriteOwner) session.getAttribute("ownerDTO");
		String representative=null;
		
		//path저장
		ServletContext application=request.getServletContext();
		String contextPath=application.getContextPath();
		String path=application.getRealPath("UploadFolder_Owner");
		
		try {
			MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
			Enumeration files = multi.getFileNames();
			while(files.hasMoreElements())
			{
				String str = (String)files.nextElement();
				//representative = path+ "/" + multi.getFilesystemName(str);
				representative = contextPath+"/UploadFolder_Owner/" + multi.getFilesystemName(str);

			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//DTO에 저장
		ownerDTO.setCafeReprePicture(representative);
		
		
		
	}
}
