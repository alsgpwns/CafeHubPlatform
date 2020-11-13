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


/****************
 * 
 * 로그인 후 Owner DAO
 * 
 * **************/
public class DAOInfoOwner {
	private static DAOInfoOwner ownerDAO = new DAOInfoOwner();
	private String CONNECTION_POOL_NAME = "jdbc/cafeinfodb";
	private final String DATABLES_NAME="";
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
	
	
	
	
	
	
	
}