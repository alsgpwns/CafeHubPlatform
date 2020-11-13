package com.www.hj.command.Owner;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.www.hj.DAO.Info.DAOInfo;
import com.www.hj.DAO.Info.DAOInfoOwner;
import com.www.hj.command.front.Command;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

public class OwnerPictureWriteCommand implements Command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOInfoOwner ownerDAO = DAOInfoOwner.getDAOOwner();
		
		System.out.println("==================");
		/* cos: 사진 저장 */
		String menu1=null, menu2=null, menu3=null, menu4=null, menu5=null;

		//DB에 저장될 변수
		String menuStore1,menuStore2,menuStore3;
		String fileStore1,fileStore2,fileStore3,fileStore4,fileStore5,fileStore6,fileStore7;
		
		int count=0;
		
		String path=request.getRealPath("UploadFolder_Owner");
		try {
			MultipartRequest multi = new MultipartRequest(request,path,1024 * 1024 * 10,"UTF-8",new DefaultFileRenamePolicy());
			Enumeration files = multi.getFileNames();

			
			while(files.hasMoreElements())
			{
				count++;
				String str = (String)files.nextElement();
				if(count==1)
				{					
					menu1 = multi.getFilesystemName(str);
				}
				else if(count==2)
				{
					menu2 = multi.getFilesystemName(str);
				}
				else if(count==3)
				{
					menu3 = multi.getFilesystemName(str);
				}
				else if(count==4)
				{
					menu4 = multi.getFilesystemName(str);
				}
				else if(count==5)
				{
					menu5 = multi.getFilesystemName(str);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	
		
		
	
		//request.getParameter("hashtag");
		System.out.println("menu1: "+menu1);
		System.out.println("menu2: "+menu2);
		System.out.println("menu3: "+menu3);
		System.out.println("menu4: "+menu4);
		System.out.println("menu5: "+menu5);
	
	
	
	}
}