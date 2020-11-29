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
import com.www.hj.DTO.Board.DTOWriteOwner;
import com.www.hj.command.front.Command;


//메뉴 사진 수정//
public class OwnerMenuModifyCommand implements Command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//dto가져오기
		HttpSession session = request.getSession();
		DTOWriteOwner myDTO = (DTOWriteOwner) session.getAttribute("myDTO"); 
		System.out.println("myDTO_textCommand: "+session.getAttribute("myDTO")); //주석
		
		//path설정
		ServletContext application = request.getServletContext();
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
					System.out.println("파일명1: "+multi.getFilesystemName(str));
					
					if(multi.getFilesystemName(str)!=null)
					{
						System.out.println("if (널이 아님)");
						System.out.println("menu1: "+menu1);
						menu1 = "/CafeProject_10/UploadFolder_Owner/" +multi.getFilesystemName(str);
					}
					else
					{
						System.out.println("else");
						menu1 = myDTO.getCafeMenu1();
						System.out.println("menu1: "+menu1);
					}
					
				}
				else if(count==2)
				{
					System.out.println("파일명2: "+multi.getFilesystemName(str));
					if(multi.getFilesystemName(str)!=null)
					{
						menu2 = contextPath+"/UploadFolder_Owner/" +multi.getFilesystemName(str);
					}
					else
					{
						menu2 = contextPath+"/UploadFolder_Owner/" + myDTO.getCafeMenu2();
					}
				}
				else if(count==3)	
				{
					System.out.println("파일명3: "+multi.getFilesystemName(str));
					if(multi.getFilesystemName(str)!=null)
					{
						menu3 = contextPath+"/UploadFolder_Owner/" +multi.getFilesystemName(str);
					}
					else
					{
						menu3 = contextPath+"/UploadFolder_Owner/" + myDTO.getCafeMenu3();
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

		//DTO에 저장
		myDTO.setCafeMenu1(menu1);			
		myDTO.setCafeMenu2(menu2);
		myDTO.setCafeMenu3(menu3);
		
		System.out.println("=============");
		System.out.println(menu1);
		System.out.println(menu2);
		System.out.println(menu3);
		
		session.setAttribute("modifyDTO", myDTO);
		
	}
}