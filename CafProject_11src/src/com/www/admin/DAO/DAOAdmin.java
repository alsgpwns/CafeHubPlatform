package com.www.admin.DAO;
/****************
 * 
 * admin DAO
 * 
 * **************/
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.www.admin.DTO.reportDTO;
import com.www.hj.DTO.Board.DTOWriteOwner;

public class DAOAdmin  {
	private static DAOAdmin adminDAO = new DAOAdmin();
	private String CONNECTION_POOL_NAME = "jdbc/cafeinfodb";
	private final String TABLE_NAME="board";

	private DataSource dataSource;

	public DAOAdmin() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/"+CONNECTION_POOL_NAME);
		} catch(NamingException e) {
			e.printStackTrace();
		}
	}

	public static DAOAdmin getDAOAdmin() {
		return adminDAO;
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void close(ResultSet rs, PreparedStatement ps, Connection conn)
	{
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void close(PreparedStatement ps, Connection conn)
	{
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	//list찍어주기
	public ArrayList<DTOWriteOwner> viewBoard(){
		ArrayList<DTOWriteOwner> list = new ArrayList<DTOWriteOwner>();
		Connection conn = getConnection();
		PreparedStatement ps =null;
		ResultSet rs = null;
		final String LIST_SQL="select cafeName,cafeIntroduce, liking, cafePlace,cafeRepresentativePicture,cafeHours,id  from board";
		DTOWriteOwner dto = null;
		try {
			ps=conn.prepareStatement(LIST_SQL);
			rs=ps.executeQuery();
			while(rs.next())
			{
				dto = new DTOWriteOwner();
				dto.setCafeName(rs.getString("cafename"));
				dto.setCafeIntroduce(rs.getString("cafeIntroduce"));
				dto.setLike(rs.getInt("liking"));
				dto.setcafeAddress(rs.getString("cafePlace"));
				dto.setCafeReprePicture(rs.getString("cafeRepresentativePicture"));
				dto.setCafeHours(rs.getString("cafeHours"));
				dto.setId(rs.getString("id"));
				list.add(dto);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			close(rs,ps,conn);
		}
		return list;
	}

	//알림창
	public ArrayList<reportDTO> viewReport() {
		final String VIEW_REPOR_SQL="select* from report ";
		ArrayList<reportDTO> reportList = new ArrayList<reportDTO>();
		Connection conn = getConnection();
		PreparedStatement ps =null;
		ResultSet rs = null;
		reportDTO dto = null;
		try {
			ps=conn.prepareStatement(VIEW_REPOR_SQL);
			rs=ps.executeQuery();
			System.out.println("ps: "+ps); //
			while(rs.next())
			{
				dto = new reportDTO();
				dto.setWriterId(rs.getString("writerId"));
				dto.setReportContents(rs.getString("reportContents"));
				dto.setReportSelect(rs.getString("reportSelect"));
				reportList.add(dto);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			close(rs,ps,conn);
		}
		return reportList;
		
	}



}
