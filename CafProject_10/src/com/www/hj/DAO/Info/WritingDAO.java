package com.www.hj.DAO.Info;

//글 확인 (view DAO)
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

public class WritingDAO {
	
	private static WritingDAO writeDAO = new WritingDAO();
	private String CONNECTION_POOL_NAME = "jdbc/cafeinfodb";
	private final String TABLE_NAME="board";
	private final String GUEST_WISH_LIST_TABLE="guestwishlist";
	private final String OWNER_WISH_LIST_TABLE="ownerwishList";
	
	private DataSource dataSource;
	
	 public WritingDAO() {
	        try {
	        	Context context = new InitialContext();
	        	dataSource = (DataSource)context.lookup("java:comp/env/"+CONNECTION_POOL_NAME);
	        } catch(NamingException e) {
	        	e.printStackTrace();
	        }
	    }
	
	  public static WritingDAO getDAOInfo() {
	    	return writeDAO;
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
	    
	    //글 보기, 내 카페(글) 보기
	    public DTOWriteOwner showWriting(String id,DTOWriteOwner showDTO)
	    {
	    	Connection conn = getConnection();
	    	PreparedStatement ps = null;
	    	ResultSet rs = null;
	    	final String SHOW_WRITING_SQL ="select* from "+TABLE_NAME+" where id=?";
	    	
	    	try {
	    		ps = conn.prepareStatement(SHOW_WRITING_SQL);
	    		ps.setString(1, id);
	    		rs = ps.executeQuery();
	    		if(rs.next())
	    		{
	    			showDTO.setcafeAddress(rs.getString("cafePlace"));
	    			showDTO.setCafeBreakeTime(rs.getString("cafeBreakeTime"));
	    			showDTO.setCafeHashTag(rs.getString("cafeHashTag"));
	    			showDTO.setCafeHours(rs.getString("cafeHours"));
	    			showDTO.setCafeIntroduce(rs.getString("cafeIntroduce"));
	    			showDTO.setCafeLastorder(rs.getString("cafeLastOrder"));
					showDTO.setCafeMenu(rs.getString("cafeMenu"));
					showDTO.setCafeMenu1(rs.getString("cafeMenu1"));
					showDTO.setCafeMenu2(rs.getString("cafeMenu2"));
					showDTO.setCafeMenu3(rs.getString("cafeMenu3"));
					showDTO.setCafeName(rs.getString("cafeName"));
					showDTO.setCafeNumber(rs.getString("cafeNumber"));
					showDTO.setCafeParking(rs.getString("cafeParking"));
					showDTO.setCafePicture1(rs.getString("cafePicture1"));
					showDTO.setCafePicture2(rs.getString("cafePicture2"));
					showDTO.setCafePicture3(rs.getString("cafePicture3"));
					showDTO.setCafePicture4(rs.getString("cafePicture4"));
					showDTO.setCafePicture5(rs.getString("cafePicture5"));
					showDTO.setCafePicture6(rs.getString("cafePicture6"));
					showDTO.setCafePicture7(rs.getString("cafePicture7"));
					showDTO.setCafePrice(rs.getString("cafePrice"));
					showDTO.setCafeReprePicture(rs.getString("cafeRepresentativePicture"));
					showDTO.setCafeIntroduce(rs.getString("cafeIntroduce"));
					showDTO.setId(rs.getString("id"));
	    		}
	    	} catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	} finally {
	    		close(rs,ps,conn);
	    	}
	    	
			return showDTO;
	    }
	    
	    // 찜 눌려있는지 확인
	    // 1. guest
	    public String likeingCheckGuest(String writerId,String userId)
	    {
	    	Connection conn = getConnection();
	    	PreparedStatement ps= null;
	    	ResultSet rs = null;
	    	String wishCheck = null;
	    	final String LIKEING_CHECK_SQL="select* from guestwishlist where id=? and writerId=? ";
	    	
	    	try {
	    		ps = conn.prepareStatement(LIKEING_CHECK_SQL);
	    		ps.setString(1, userId);
	    		ps.setString(2, writerId);
	    		rs = ps.executeQuery();
				System.out.println("ps: "+ps);
	    		if(rs.next())
	    		{
	    			wishCheck = "isNotEmpty";
	    		}
	    	} catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	} finally {
	    		close(rs,ps,conn);
	    	}
	    	return wishCheck;
	    }
	 
	    public String likeingCheckOwner(String writerId,String userId)
	    {
	    	Connection conn = getConnection();
	    	PreparedStatement ps= null;
	    	ResultSet rs = null;
	    	String wishCheck = null;
	    	final String LIKEING_CHECK_OWNER_SQL="select* from ownerwishlist where id=? and writerId=? ";
	    	
	    	try {
	    		ps = conn.prepareStatement(LIKEING_CHECK_OWNER_SQL);
	    		ps.setString(1, userId);
	    		ps.setString(2, writerId);
	    		rs = ps.executeQuery();
				System.out.println("ps: "+ps);
	    		if(rs.next())
	    		{
	    			wishCheck = "isNotEmpty";
	    		}
	    	} catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	} finally {
	    		close(rs,ps,conn);
	    	}
	    	return wishCheck;
	    }

}