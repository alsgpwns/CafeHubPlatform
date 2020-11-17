package com.www.hj.DAO.Info;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.www.hj.DTO.Board.DTOWriteOwner;


/****************
 * 
 * 로그인 후 Owner DAO
 * 
 * **************/
public class DAOInfoOwner {
	private static DAOInfoOwner ownerDAO = new DAOInfoOwner();
	private String CONNECTION_POOL_NAME = "jdbc/cafeinfodb";
	private final String OWNER_TABLE_NAME="board";
	private final String COLUMN_NAME=" (id,cafeName ,cafeNumber ,cafeMenu ,cafePrice ,cafeParking,cafeHours,cafeBreakeTime,cafeLastOrder,cafeIntroduce,cafeHashTag,cafeRepresentativePicture,cafeMenu1,cafeMenu2,cafeMenu3,cafePicture1,cafePicture2,cafePicture3,cafePicture4,cafePicture5,cafePicture6,cafePicture7,cafePlace ) ";
	private DataSource dataSource;
	
	public DAOInfoOwner() {
		 try {
	        	Context context = new InitialContext();
	        	dataSource = (DataSource)context.lookup("java:comp/env/"+CONNECTION_POOL_NAME);
	        } catch(NamingException e) {
	        	e.printStackTrace();
	        }
	}
	
	public static DAOInfoOwner getDAOOwner() {
		return ownerDAO;
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
	
	//글쓰기 저장
	public void wirteInfoStore(DTOWriteOwner ownerDTO) {
		System.out.println("ownerDTO5: "+ownerDTO);
		final String OWNER_WRITE_SQL ="insert into "+OWNER_TABLE_NAME+COLUMN_NAME+" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn=getConnection();
		PreparedStatement ps = null;
		int rs=0;
		try {
			ps=conn.prepareStatement(OWNER_WRITE_SQL);
			ps.setString(1, ownerDTO.getId());
			ps.setString(2, ownerDTO.getCafeName());
			ps.setString(3, ownerDTO.getCafeNumber());
			ps.setString(4, ownerDTO.getCafeMenu());
			ps.setString(5, ownerDTO.getCafePrice());
			ps.setString(6, ownerDTO.getCafeParking());
			ps.setString(7, ownerDTO.getCafeHours());
			ps.setString(8, ownerDTO.getCafeBreakeTime());
			ps.setString(9, ownerDTO.getCafeLastorder());
			ps.setString(10, ownerDTO.getCafeIntroduce());
			ps.setString(11, ownerDTO.getCafeHashTag());
			ps.setString(12, ownerDTO.getCafeReprePicture());
			ps.setString(13, ownerDTO.getCafeMenu1());
			ps.setString(14, ownerDTO.getCafeMenu2());
			ps.setString(15, ownerDTO.getCafeMenu3());
			ps.setString(16, ownerDTO.getCafePicture1());
			ps.setString(17, ownerDTO.getCafePicture2());
			ps.setString(18, ownerDTO.getCafePicture3());
			ps.setString(19, ownerDTO.getCafePicture4());
			ps.setString(20, ownerDTO.getCafePicture5());
			ps.setString(21, ownerDTO.getCafePicture6());
			ps.setString(22, ownerDTO.getCafePicture7());
			ps.setString(23, ownerDTO.getcafeAddress());
			System.out.println(ps);
			rs=ps.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			close(ps,conn);
		}
	}
	
	
	
	
	
	
	
}