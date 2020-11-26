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
	    		System.out.println("ps: "+ps);
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
	    		System.out.println(ps); //주석
	    		rs=ps.executeUpdate();
	    	}catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}finally {
	    		close(ps,conn);
	    	}
	    }
	    
	    //wish list 보여주기
	    // 1. 찜한 게시글 ID가져오기
	    public String loadWishListGuest(String userId)
	    {
	    	final String LOAD_GUEST_WISH_LIST_SQL="select writerId from "+GUEST_WISH_LIST_TABLE+" where id=?";
	    	Connection conn = getConnection();
	    	PreparedStatement ps = null;
	    	ResultSet rs = null;
	    	String result= "";
	    	String str = " \"홍길동\" ";
	    	System.out.println(str);
	    	
	    	try {
	    		ps = conn.prepareStatement(LOAD_GUEST_WISH_LIST_SQL);
	    		ps.setString(1, userId);
	    		System.out.println(ps); //주석
	    		rs=ps.executeQuery();
	    		while(rs.next())
	    		{
	    			result = result +"\"" +rs.getString("writerId")+"\",";
	    			
	    		}
	    	} catch(SQLException e) {
	    		e.printStackTrace();
	    	}finally {
	    		close(rs,ps,conn);
	    	}
	    	
	    	System.out.println("result: "+result);
	    	String idSet = result.substring(0,result.length()-1);
	    	System.out.println("idSet: "+idSet);
	    	
	    	return idSet;
	    }
	    
	    //2. ID로 DTO 저장
	    //select cafeName from board where id in("test111","test222");
	    public void viewWishListGuest(String idSet)
	    {
	    	final String VIEW_GUEST_WISH_LIST_SQL="select* from board where id in("+idSet+")";
	    	Connection conn = getConnection();
	    	PreparedStatement ps = null;
	    	ResultSet rs = null;
	    	DTOWriteOwner showDTO=null;
	    	try {
	    		ps = conn.prepareStatement(VIEW_GUEST_WISH_LIST_SQL);
	    		rs=ps.executeQuery();
	    		System.out.println("!ps:"+ps); //주석
	    		while(rs.next())
	    		{
	    			//메인처럼 저장하기
	    		}
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}finally {
	    		close(rs,ps,conn);
	    	}
	    }
	    
	    // 찍어주기
	    public ArrayList<DTOWriteOwner> showWishListGuest(String id)
	    {
	    	System.out.println("여기");
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
					wishList.add(showDTO);
					System.out.println("showDTO: "+showDTO);
					System.out.println("ps: "+ps);
	    		}
	    	}catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	} finally {
	    		close(rs,ps,conn);
	    	}
	    	
	    	
	    	return wishList;
	    }
	    
	    

	    
	    
}