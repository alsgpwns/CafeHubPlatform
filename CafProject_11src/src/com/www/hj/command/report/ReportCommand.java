package com.www.hj.command.report;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.www.hj.DAO.report.DAOreport;
import com.www.hj.command.front.Command;

public class ReportCommand implements Command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOreport dao = DAOreport.getReportDAO();
		HttpSession session =request.getSession();
		String reportId = (String) session.getAttribute("reportId");
		String contents=(String) request.getAttribute("contents");
		String select=(String)request.getAttribute("reportSelect");
		
		if(contents!=null)
		{
			dao.reportText(reportId, contents, select);
		}
		else {			
			dao.report(reportId, contents);
		}
	}
}
