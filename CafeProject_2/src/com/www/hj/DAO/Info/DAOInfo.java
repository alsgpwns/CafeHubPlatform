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

public class DAOInfo {
	
	private static DAOInfo infoDAO = new DAOInfo();
	private String CONNECTION_POOL_NAME = "jdbc/cafeinfodb";
	private final String ADMIN_TABLE_NAME ="admin";
	private final String GUEST_TABLE_NAME ="guest";
	private final String OWNER_TABLE_NAME ="owner";
	private DataSource dataSource;
	
    public DAOInfo() {
        try {
        	Context context = new InitialContext();
        	dataSource = (DataSource)context.lookup("java:comp/env/"+CONNECTION_POOL_NAME);
        } catch(NamingException e) {
        	e.printStackTrace();
        }
    }
    
    public static DAOInfo getDAOInfo() {
    	return infoDAO;
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
    
    /*Login*/
    //user Login check
    public boolean userLoginCheck(String userId, String userPw)
    {
    	boolean loginFlag = false;
    	Connection conn = getConnection();
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	String USER_LOGIN_SQL ="select* from "+GUEST_TABLE_NAME+" where id=? and pw=?";
    	try {
    		ps = conn.prepareStatement(USER_LOGIN_SQL);
    		ps.setString(1, userId);
    		ps.setString(2, userPw);
    		System.out.println("ps :"+ps);
    		rs=ps.executeQuery();
    		if(rs.next())
    		{
    			loginFlag=true;
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	} finally {
    		close(rs,ps,conn);
    	}
    	
    	
		return loginFlag;
    }
    
    //점주 login Check
    public boolean ownerLoginCheck(String userId,String userPw)
    {
    	boolean loginFlag = false;
    	Connection conn = getConnection();
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	String USER_LOGIN_SQL ="select* from "+OWNER_TABLE_NAME+" where id=? and pw=?";
    	try {
    		ps = conn.prepareStatement(USER_LOGIN_SQL);
    		ps.setString(1, userId);
    		ps.setString(2, userPw);
    		System.out.println("ps :"+ps);
    		rs=ps.executeQuery();
    		if(rs.next())
    		{
    			loginFlag=true;
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	} finally {
    		close(rs,ps,conn);
    	}
    	
    	
		return loginFlag;
    }
    
    
    
    
    


}
