package com.www.hj.DAO.Info;

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

import com.www.hj.DTO.Board.DTOWriteOwner;
import com.www.hj.DTO.info.DTOInfoGuest;
import com.www.hj.DTO.info.DTOInfoOwner;


/****************
 * 
 * 로그인 전 DAO
 * 
 * **************/


public class DAOInfo {
	
	private static DAOInfo infoDAO = new DAOInfo();
	private String CONNECTION_POOL_NAME = "jdbc/cafeinfodb";
	private final String ADMIN_TABLE_NAME ="admininfo";
	private final String GUEST_TABLE_NAME ="guestinfo";
	private final String OWNER_TABLE_NAME ="ownerinfo";
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
    
    
    /*Join*/
    /*Join_guest*/
    //게스트 회원가입
    public void JoinGuest(DTOInfoGuest dto)
    {
    	Connection conn = getConnection();
    	PreparedStatement ps = null;
    	int rs = 0;
    	final String JOIN_GUEST_SQL="insert into "+GUEST_TABLE_NAME+" values(?,?,?,?,?)";
    	try {
    		ps = conn.prepareStatement(JOIN_GUEST_SQL);
    		ps.setString(1, dto.getId());
    		ps.setString(2, dto.getPw());
    		ps.setString(3, dto.getPhoneNumber());
    		ps.setString(4, dto.getEmail());
    		ps.setString(5, dto.getHastag());
    		System.out.println(ps); //주석
    		rs=ps.executeUpdate();
    	} catch(SQLException e)
    	{
    		e.printStackTrace();
    	}finally {
    		close(ps,conn);
    	}
    }
    
  //게스트 id 중복 확인
    public int duplecateID(String id)
    {
    	int checkNum = 0;
    	Connection conn = getConnection();
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	
    	final String DUPLECATE_ID_SQL="select* from "+GUEST_TABLE_NAME+" where id=?";
    	try {
    		ps=conn.prepareStatement(DUPLECATE_ID_SQL);
    		ps.setString(1, id);
    		rs=ps.executeQuery();
    		if(rs.next())
    		{
    			checkNum=1;
    		}
    	} catch(SQLException e){
    		e.printStackTrace();
    	} finally {
    		close(rs,ps,conn);
    	}
    	return checkNum;
    }
    
    
    //email 갯수 확인
    public int duplecateEmail(String email)
    {
    	Connection conn = getConnection();
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	int emailCount = 0;
    	
    	final String DUPLECATE_EMAIL_SQL="select count(id) from "+GUEST_TABLE_NAME+"  where email=?";
    	try {
    		ps=conn.prepareStatement(DUPLECATE_EMAIL_SQL);
    		ps.setString(1, email);
    		rs=ps.executeQuery();
    		if(rs.next())
    		{
    			emailCount=Integer.parseInt(rs.getString(1));
    		}
    		
    	} catch(SQLException e) {
    		e.printStackTrace();
    	} finally {
    		close(rs,ps,conn);
    	}
    	
		return emailCount;
    }
    
    /*Join_owenr*/
    // 오너 가입
    public void JoinOwner(DTOInfoOwner ownerDTO)
    {
    	Connection conn = getConnection();
    	PreparedStatement ps = null;
    	int rs = 0;
    	final String JOIN_GUEST_SQL="insert into "+OWNER_TABLE_NAME+" values(?,?,?,?)";
    	try {
    		ps = conn.prepareStatement(JOIN_GUEST_SQL);
    		ps.setString(1, ownerDTO.getId());
    		ps.setString(2, ownerDTO.getPw());
    		ps.setString(3, ownerDTO.getPhoneNumber());
    		ps.setString(4, ownerDTO.getEmail());
    		System.out.println(ps);
    		rs=ps.executeUpdate();
    	} catch(SQLException e)
    	{
    		e.printStackTrace();
    	}finally {
    		close(ps,conn);
    	}
    }
    
    //오너 id 중복 확인
    public int duplecateIDOwner(String id)
    {
    	int checkNum = 0;
    	Connection conn = getConnection();
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	
    	final String DUPLECATE_ID_SQL="select* from "+OWNER_TABLE_NAME+" where id=?";
    	try {
    		ps=conn.prepareStatement(DUPLECATE_ID_SQL);
    		ps.setString(1, id);
    		rs=ps.executeQuery();
    		System.out.println("ps: "+ps);
    		if(rs.next())
    		{
    			checkNum=1;
    		}
    	} catch(SQLException e){
    		e.printStackTrace();
    	} finally {
    		close(rs,ps,conn);
    	}
    	System.out.println(checkNum);
    	return checkNum;
    }
    
    
    //email 갯수 확인
    public int ownerDuplecateEmail(String email)
    {
    	Connection conn = getConnection();
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	int emailCount = 0;
    	
    	final String DUPLECATE_EMAIL_SQL="select count(id) from "+OWNER_TABLE_NAME+"  where email=?";
    	try {
    		ps=conn.prepareStatement(DUPLECATE_EMAIL_SQL);
    		ps.setString(1, email);
    		rs=ps.executeQuery();
    		if(rs.next())
    		{
    			emailCount=Integer.parseInt(rs.getString(1));
    		}
    		
    	} catch(SQLException e) {
    		e.printStackTrace();
    	} finally {
    		close(rs,ps,conn);
    	}
    	
		return emailCount;
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
    
    


}
