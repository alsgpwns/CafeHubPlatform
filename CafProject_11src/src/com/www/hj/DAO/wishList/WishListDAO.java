package com.www.hj.DAO.wishList;

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

public class WishListDAO {
	private static WishListDAO wishDAO = new WishListDAO();
	private String CONNECTION_POOL_NAME = "jdbc/cafeinfodb";
	private final String GUEST_WISH_LIST_TABLE="guestwishlist";
	private final String OWNER_WISH_LIST_TABLE="ownerwishList";
	
	
	private DataSource dataSource;
	
	 public WishListDAO() {
	        try {
	        	Context context = new InitialContext();
	        	dataSource = (DataSource)context.lookup("java:comp/env/"+CONNECTION_POOL_NAME);
	        } catch(NamingException e) {
	        	e.printStackTrace();
	        }
	    }
	
	  public static WishListDAO getWishDAO() {
	    	return wishDAO;
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
	       
	    
	    // 리스트 검사하기
	    //1. guest_ 이미 리스트에 있는지 검사
	    public int wishListGuestCheck(String likeId, String userId)
	    {
	    	Connection conn = getConnection();
	    	PreparedStatement ps = null;
	    	ResultSet rs = null;
	    	int check = 0;
	    	final String GUEST_WISH_LIST_CHECK_SQL="select* from "+GUEST_WISH_LIST_TABLE+" where writerId=? and id=?";
	    	
	    	try {
	    		ps = conn.prepareStatement(GUEST_WISH_LIST_CHECK_SQL);
	    		ps.setString(1, likeId);
	    		ps.setString(2, userId);
	    		rs=ps.executeQuery();
	    		if(rs.next())
	    		{
	    			check=1;
	    		}
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}finally {
	    		close(rs,ps,conn);
	    	}
	    	return check;
	    }
	    
	    //2. owner_ 이미 리스트에 있는지 검사
	    public int wishListOwnerCheck(String likeId, String userId)
	    {
	    	Connection conn = getConnection();
	    	PreparedStatement ps = null;
	    	ResultSet rs = null;
	    	int check = 0;
			
	    	final String OWNER_WISH_LIST_CHECK_SQL="select* from "+OWNER_WISH_LIST_TABLE+" where writerId=? and id=?";
	    	
	    	try {
	    		ps = conn.prepareStatement(OWNER_WISH_LIST_CHECK_SQL);
	    		ps.setString(1, likeId);
	    		ps.setString(2, userId);
	    		rs=ps.executeQuery();
	    		if(rs.next())
	    		{
	    			check=1;
	    		}
	    	}catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	} finally {
	    		close(rs,ps,conn);
	    	}
	    	return check;
	    }
	    
	    // 검사 하고 DB에 저장
	    //1.guest
	    public void addWishListGuest(String likeId,String userId)
	    {
	    	Connection conn = getConnection();
	    	PreparedStatement ps = null;
	    	int rs = 0;
	    	final String GUEST_WISH_LIST_SQL="insert into "+GUEST_WISH_LIST_TABLE+" (id, writerId)  values (?,?)";
	    	
	    	try {
	    		ps = conn.prepareStatement(GUEST_WISH_LIST_SQL);
	    		ps.setString(1, userId);
	    		ps.setString(2, likeId);
	    		rs=ps.executeUpdate();
	    	}catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}finally {
	    		close(ps,conn);
	    	}
	    }
	    
	    //2. owner
	    public void addWishListOwner(String likeId, String userId)
	    {
	    	Connection conn = getConnection();
	    	PreparedStatement ps = null;
	    	int rs = 0;
	    	final String OWNER_WISH_LIST_SQL="insert into "+OWNER_WISH_LIST_TABLE+" (id, writerId) values (?,?)";
	    	try {
	    		ps = conn.prepareStatement(OWNER_WISH_LIST_SQL);
	    		ps.setString(1, userId);
	    		ps.setString(2, likeId);
	    		rs=ps.executeUpdate();
	    	}catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}finally {
	    		close(ps,conn);
	    	}
	    }
	    
	    
	    // 좋아요 갯수 증가
	    // 1.guest 
	    public void increasesLikeGuest(String likeId)
	    {
	    	Connection conn = getConnection();
	    	PreparedStatement ps = null;
	    	int rs=0;
	    	final String INCRESE_LIKE_GUEST_SQL="update board set liking=liking+1 where id=?";
	    	try {
	    		ps = conn.prepareStatement(INCRESE_LIKE_GUEST_SQL);
	    		ps.setString(1, likeId);
	    		rs=ps.executeUpdate();
	    	}catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}finally {
	    		close(ps,conn);
	    	}
	    }
	    
	    // 2.owner
	    public void increasesLikeOwner(String likeId)
	    {
	    	Connection conn = getConnection();
	    	PreparedStatement ps = null;
	    	int rs=0;
	    	final String INCRESE_LIKE_GUEST_SQL="update board set liking=liking+1 where id=?";
	    	try {
	    		ps = conn.prepareStatement(INCRESE_LIKE_GUEST_SQL);
	    		ps.setString(1, likeId);
	    		rs=ps.executeUpdate();
	    	}catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}finally {
	    		close(ps,conn);
	    	}
	    }
	    
	    
	    // wishList 찍어주기
	    // 1. guest
	    public ArrayList<DTOWriteOwner> showWishListGuest(String id)
	    {
	    	ArrayList<DTOWriteOwner> wishList = new ArrayList<DTOWriteOwner>();
	    	DTOWriteOwner showDTO =null;
	    	Connection conn = getConnection();
	    	PreparedStatement ps = null;
	    	ResultSet rs = null;
	    	final String SHOW_WISH_LIST="select* from board where id in(select writerId from guestwishlist where id=?)";
	    	try {
	    		ps = conn.prepareStatement(SHOW_WISH_LIST);
	    		ps.setString(1, id);
	    		rs = ps.executeQuery();
	    		while(rs.next())
	    		{
	    			showDTO = new DTOWriteOwner();
	    			showDTO.setCafeHours(rs.getString("cafeHours"));
	    			showDTO.setcafeAddress(rs.getString("cafePlace"));
	    			showDTO.setCafeIntroduce(rs.getString("cafeIntroduce"));
					showDTO.setCafeMenu(rs.getString("cafeMenu"));
					showDTO.setCafeName(rs.getString("cafeName"));
					showDTO.setLike(rs.getInt("liking"));
					showDTO.setCafeReprePicture(rs.getString("cafeRepresentativePicture"));
					showDTO.setCafeIntroduce(rs.getString("cafeIntroduce"));
					showDTO.setId(rs.getString("id"));
					wishList.add(showDTO);
	    		}
	    	}catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	} finally {
	    		close(rs,ps,conn);
	    	}
	    		
	    	return wishList;
	    }
	    
	    // 2. owner
	    public ArrayList<DTOWriteOwner> showWishListOwner(String id)
	    {
	    	ArrayList<DTOWriteOwner> wishList = new ArrayList<DTOWriteOwner>();
	    	DTOWriteOwner showDTO =null;
	    	Connection conn = getConnection();
	    	PreparedStatement ps = null;
	    	ResultSet rs = null;
	    	final String SHOW_WISH_LIST="select* from board where id in(select writerId from ownerwishlist where id=?)";
	    	try {
	    		ps = conn.prepareStatement(SHOW_WISH_LIST);
	    		ps.setString(1, id);
	    		rs = ps.executeQuery();
	    		while(rs.next())
	    		{
	    			showDTO = new DTOWriteOwner();
	    			showDTO.setCafeHours(rs.getString("cafeHours"));
	    			showDTO.setcafeAddress(rs.getString("cafePlace"));
	    			showDTO.setCafeIntroduce(rs.getString("cafeIntroduce"));
					showDTO.setCafeMenu(rs.getString("cafeMenu"));
					showDTO.setCafeName(rs.getString("cafeName"));
					showDTO.setLike(rs.getInt("liking"));
					showDTO.setCafeReprePicture(rs.getString("cafeRepresentativePicture"));
					showDTO.setCafeIntroduce(rs.getString("cafeIntroduce"));
					showDTO.setId(rs.getString("id"));
					wishList.add(showDTO);
	    		}
	    	}catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	} finally {
	    		close(rs,ps,conn);
	    	}
	    		
	    	return wishList;
	    }
	    
	    //wish list에서 삭제하기
	    //1. guest
	    public void deleteWishListGUest(String userId, String writerId) {
	    	Connection conn = getConnection();
	    	PreparedStatement ps = null;
	    	int rs=0;
	    	final String DELETE_WISHLIST_GUEST="delete from guestwishlist where id=? and writerId=?";
	    	try {
	    		ps = conn.prepareStatement(DELETE_WISHLIST_GUEST);
	    		ps.setString(1, userId);
	    		ps.setString(2, writerId);
	    		rs = ps.executeUpdate();
	    	}catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
	    }
	    
	    //2. owner
	    public void deleteWishListOwner(String userId, String writerId) {
	    	Connection conn = getConnection();
	    	PreparedStatement ps = null;
	    	int rs=0;
	    	final String DELETE_WISHLIST_GUEST="delete from ownerwishlist where id=? and writerId=?";
	    	try {
	    		ps = conn.prepareStatement(DELETE_WISHLIST_GUEST);
	    		ps.setString(1, userId);
	    		ps.setString(2, writerId);
	    		rs = ps.executeUpdate();
	    	}catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
	    }
	    
	    //좋아요 갯수 마이너스
	    //1. guest
	    public void decresLikeGuest(String writerId)
	    {
	    	Connection conn = getConnection();
	    	PreparedStatement ps = null;
	    	int rs=0;
	    	final String DECRES_LIKE_GUEST_SQL="update board set liking=liking-1 where id=?";
	    	try {
	    		ps = conn.prepareStatement(DECRES_LIKE_GUEST_SQL);
	    		ps.setString(1, writerId);
	    		rs=ps.executeUpdate();
	    	}catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}finally {
	    		close(ps,conn);
	    	}
	    }

	    

	    
	    
}