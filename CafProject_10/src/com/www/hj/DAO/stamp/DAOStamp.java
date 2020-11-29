package com.www.hj.DAO.stamp;

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

import com.www.hj.DAO.Info.DAOInfo;
import com.www.hj.DTO.Board.DTOWriteOwner;

/****************
 * 
 * 스탬프 관련 DAO
 * 
 * **************/

public class DAOStamp{
	private static DAOStamp stampDAO = new DAOStamp();
	private String CONNECTION_POOL_NAME = "jdbc/cafeinfodb";
	private DataSource dataSource;
	
    public DAOStamp() {
        try {
        	Context context = new InitialContext();
        	dataSource = (DataSource)context.lookup("java:comp/env/"+CONNECTION_POOL_NAME);
        } catch(NamingException e) {
        	e.printStackTrace();
        }
    }
    
    public static DAOStamp getDAOStamp() {
    	return stampDAO;
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
    
    //스탬프 적립
    // 이미 DB에 있는지 확인(적립 내역)
    public int checkStampCafe(String cafeName, String cafeNo)
    {
    	final String CHECK_STAMP_SQL="select* from stamp where cafeName=? and cafeNo=?";
    	int check = 0;
    	Connection conn = getConnection();
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	try {
    		ps  = conn.prepareStatement(CHECK_STAMP_SQL);
    		ps.setString(1, cafeName);
    		ps.setString(2, cafeNo);
    		rs=ps.executeQuery();
    		if(rs.next())
    		{
    			check=1;
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	} finally {
    		close(rs,ps,conn);
    	}
    	return check;
    }
    
    
    // stamp 적립하기
    // 1. stamp 적립 내역이 없을 떄
    public void insertStamp(String userId, String saveStamp, String cafeName, String ownerNumber)
    {
    	final String INSERT_STAMP_OWNER_SQL="insert into stamp values(?,?,?,?)";
    	Connection conn = getConnection();
    	PreparedStatement ps = null;
    	int rs = 0;
    	try {
    		ps  = conn.prepareStatement(INSERT_STAMP_OWNER_SQL);
    		ps.setString(1, userId);
    		ps.setString(2, cafeName);
    		ps.setString(3, ownerNumber);
    		ps.setString(4, saveStamp);
    		rs=ps.executeUpdate();
    	}catch(SQLException e) {
    		e.printStackTrace();
    	} finally {
    		close(ps,conn);
    	}
    }
    
    // 2. stamp 적립 내역이 있을 떄
    public void updateStamp(String userId, String saveStamp, String ownerNumber)
    {
    	final String UPDATE_STAMP_OWNER_SQL="update stamp set stamp=stamp+? where cafeNo=? and id=?";
    	Connection conn = getConnection();
    	PreparedStatement ps = null;
    	int rs = 0;
    	try {
    		ps  = conn.prepareStatement(UPDATE_STAMP_OWNER_SQL);
    		ps.setString(1, saveStamp);
    		ps.setString(2, ownerNumber);
    		ps.setString(3, userId);
    		rs=ps.executeUpdate();
    	}catch(SQLException e) {
    		e.printStackTrace();
    	} finally {
    		close(ps,conn);
    	}
    }
    
    
    // 스탬프 적립 _ guest
    // 1. 갔던 카페 불러오기
    public String loadCafeNumber(String id)
    {
    	String cafeNumberSet = "";
    	
    	final String CAFE_NUMBER_SQL="select cafeNo from stamp where id=?";
    	int check = 0;
    	Connection conn = getConnection();
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	try {
    		ps  = conn.prepareStatement(CAFE_NUMBER_SQL);
    		ps.setString(1, id);
    		rs=ps.executeQuery();
    		while(rs.next())
    		{
    			cafeNumberSet=cafeNumberSet+rs.getString("cafeNo")+",";
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	} finally {
    		close(rs,ps,conn);
    	}
    	cafeNumberSet = cafeNumberSet.substring(0,cafeNumberSet.length()-1);
    	System.out.print("cafeNumberSet: "+cafeNumberSet); //주석
    	return cafeNumberSet;
    }
    
    public ArrayList<DTOWriteOwner> loadCafeInfo(String cafeNumberSet)
    {
    	ArrayList<DTOWriteOwner> infoList = new ArrayList<DTOWriteOwner>();
    	final String CAFE_INFO_SQL="select* from board where no in("+cafeNumberSet+")";
    	DTOWriteOwner dto = null;
    	Connection conn = getConnection();
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	try {
    		ps  = conn.prepareStatement(CAFE_INFO_SQL);
    		//ps.setString(1, cafeNumberSet);
    		rs=ps.executeQuery();
    		System.out.println("ps: "+ps);
    		while(rs.next())
    		{
    			dto = new DTOWriteOwner();
    			dto.setCafeReprePicture(rs.getString("cafeRepresentativePicture"));
    			dto.setCafeName(rs.getString("cafeName"));
    			dto.setStamp5(rs.getString("cafeGift5"));
    			dto.setStamp10(rs.getString("cafeGift10"));
    			dto.setStamp15(rs.getString("cafeGift15"));
    			dto.setStamp20(rs.getString("cafeGift20"));
    			infoList.add(dto);
    			System.out.println("infoList: "+infoList);
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	} finally {
    		close(rs,ps,conn);
    	}
    	
    	return infoList;
    }

}
