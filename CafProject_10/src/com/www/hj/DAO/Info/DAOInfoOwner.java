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
import com.www.hj.DTO.info.DTOInfoOwner;


/****************
 * 
 * 로그인 후 Owner DAO
 * 
 * **************/
public class DAOInfoOwner {
	private static DAOInfoOwner ownerDAO = new DAOInfoOwner();
	private String CONNECTION_POOL_NAME = "jdbc/cafeinfodb";
	private final String OWNER_TABLE_NAME="board";
	private final String COLUMN_NAME=" (id,cafeName ,cafeNumber ,cafeMenu ,cafePrice ,cafeParking,cafeHours,cafeBreakeTime,cafeLastOrder,cafeIntroduce,cafeHashTag,cafeRepresentativePicture,cafeMenu1,cafeMenu2,cafeMenu3,cafePicture1,cafePicture2,cafePicture3,cafePicture4,cafePicture5,cafePicture6,cafePicture7,cafePlace,cafegift5,cafegift10,cafegift15,cafegift20 ) ";
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
	
	
	//글쓰기 검사
	public int ownerCheck(String id)
	{
		final String OWNER_WRTIE_CHECK_SQL = "select id from board where id=?";
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int check = 0;
		
		try {
			ps = conn.prepareStatement(OWNER_WRTIE_CHECK_SQL);
			ps.setString(1, id);
			rs=ps.executeQuery();
			while(rs.next())
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
	

	
	//글쓰기 저장
	public void wirteInfoStore(DTOWriteOwner ownerDTO) {
		System.out.println("ownerDTO5: "+ownerDTO);
		final String OWNER_WRITE_SQL ="insert into "+OWNER_TABLE_NAME+COLUMN_NAME+" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			ps.setString(24, ownerDTO.getStamp5());
			ps.setString(25, ownerDTO.getStamp10());
			ps.setString(26, ownerDTO.getStamp15());
			ps.setString(27, ownerDTO.getStamp20());
			System.out.println(ps);
			rs=ps.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			close(ps,conn);
		}
	}
	
	//내 글 수정 
	//1. 데이터 불러오기
	public DTOWriteOwner modifyProfile(String id,DTOWriteOwner myDTO)
	{
		final String OWNER_MOIDFY_SQL="select* from "+OWNER_TABLE_NAME+" where id=?";
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		
		try {
			ps = conn.prepareStatement(OWNER_MOIDFY_SQL);
			ps.setString(1, id);
			rs=ps.executeQuery();
			while(rs.next())
			{
				myDTO.setcafeAddress(rs.getString("cafePlace"));
				myDTO.setCafeBreakeTime(rs.getString("cafeBreakeTime"));
				myDTO.setCafeHashTag(rs.getString("cafeHashTag"));
				myDTO.setCafeHours(rs.getString("cafeHours"));
				myDTO.setCafeIntroduce(rs.getString("cafeIntroduce"));
				myDTO.setCafeLastorder(rs.getString("cafeLastOrder"));
				myDTO.setCafeMenu(rs.getString("cafeMenu"));
				myDTO.setCafeMenu1(rs.getString("cafeMenu1"));
				myDTO.setCafeMenu2(rs.getString("cafeMenu2"));
				myDTO.setCafeMenu3(rs.getString("cafeMenu3"));
				myDTO.setCafeName(rs.getString("cafeName"));
				myDTO.setCafeNumber(rs.getString("cafeNumber"));
				myDTO.setCafeParking(rs.getString("cafeParking"));
				myDTO.setCafePicture1(rs.getString("cafePicture1"));
				myDTO.setCafePicture2(rs.getString("cafePicture2"));
				myDTO.setCafePicture3(rs.getString("cafePicture3"));
				myDTO.setCafePicture4(rs.getString("cafePicture4"));
				myDTO.setCafePicture5(rs.getString("cafePicture5"));
				myDTO.setCafePicture6(rs.getString("cafePicture6"));
				myDTO.setCafePicture7(rs.getString("cafePicture7"));
				myDTO.setCafePrice(rs.getString("cafePrice"));
				myDTO.setCafeReprePicture(rs.getString("cafeRepresentativePicture"));
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		} finally {
			close(rs,ps,conn);
		}
		return myDTO;
	}
	
	//2. 데이터 저장하기
	public void modifyPrifileOK(DTOWriteOwner ownerDTO) {
		final String OWNER_WRITE_SQL ="update "+OWNER_TABLE_NAME+" set cafeName=?, cafeNumber=? ,cafeMenu=?, cafePrice =?,cafeParking=?,"
				+ "cafeHours=?, cafeBreakeTime=?, cafeLastOrder=?, cafeIntroduce=?, cafeHashTag=?, cafeRepresentativePicture=?, cafeMenu1=?, cafeMenu2=?, cafeMenu3=?, "
				+ "cafePicture1=?, cafePicture2=?, cafePicture3=?, cafePicture4=?, cafePicture5=?, cafePicture6=?, cafePicture7=?,cafePlace=?"
				+ " where id=? ;";
		Connection conn=getConnection();
		PreparedStatement ps = null;
		int rs=0;
		try {
			ps=conn.prepareStatement(OWNER_WRITE_SQL);
			ps.setString(1, ownerDTO.getCafeName());
			ps.setString(2, ownerDTO.getCafeNumber());
			ps.setString(3, ownerDTO.getCafeMenu());
			ps.setString(4, ownerDTO.getCafePrice());
			ps.setString(5, ownerDTO.getCafeParking());
			ps.setString(6, ownerDTO.getCafeHours());
			ps.setString(7, ownerDTO.getCafeBreakeTime());
			ps.setString(8, ownerDTO.getCafeLastorder());
			ps.setString(9, ownerDTO.getCafeIntroduce());
			ps.setString(10, ownerDTO.getCafeHashTag());
			ps.setString(11, ownerDTO.getCafeReprePicture());
			ps.setString(12, ownerDTO.getCafeMenu1());
			ps.setString(13, ownerDTO.getCafeMenu2());
			ps.setString(14, ownerDTO.getCafeMenu3());
			ps.setString(15, ownerDTO.getCafePicture1());
			ps.setString(16, ownerDTO.getCafePicture2());
			ps.setString(17, ownerDTO.getCafePicture3());
			ps.setString(18, ownerDTO.getCafePicture4());
			ps.setString(19, ownerDTO.getCafePicture5());
			ps.setString(20, ownerDTO.getCafePicture6());
			ps.setString(21, ownerDTO.getCafePicture7());
			ps.setString(22, ownerDTO.getcafeAddress());
			ps.setString(23, ownerDTO.getId());
			System.out.println("수정완료: "+ps);
			rs=ps.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			close(ps,conn);
		}
	}
	
	
	
	
	
	
	
}