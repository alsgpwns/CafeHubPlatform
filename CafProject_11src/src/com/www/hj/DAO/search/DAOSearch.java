package com.www.hj.DAO.search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.www.hj.DAO.stamp.DAOStamp;
import com.www.hj.DTO.Board.DTOWriteOwner;

/****************
 * 
 *  search 관련 DAO
 * 
 * **************/

public class DAOSearch {
	private static DAOSearch searchDAO = new DAOSearch();
	private String CONNECTION_POOL_NAME = "jdbc/cafeinfodb";
	private DataSource dataSource;

	public DAOSearch() {
        try {
        	Context context = new InitialContext();
        	dataSource = (DataSource)context.lookup("java:comp/env/"+CONNECTION_POOL_NAME);
        } catch(NamingException e) {
        	e.printStackTrace();
        }
    }
    
    public static DAOSearch getSearchDAO() {
    	return searchDAO;
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
    
    //검색
    public ArrayList<DTOWriteOwner> loadCafeInfo(String searchWord)
    {
    	System.out.println("searchWord: "+searchWord); //주석
    	ArrayList<DTOWriteOwner> searchList = new ArrayList<DTOWriteOwner>();
    	final String SEARCH_SQL="SELECT* FROM board WHERE cafename like '%"+searchWord+"%' or cafeplace like '%"+searchWord+"%'";
    	DTOWriteOwner showDTO = null;
    	Connection conn = getConnection();
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	try {
    		ps  = conn.prepareStatement(SEARCH_SQL);
    		System.out.println("ps : "+ps); //주석
    		rs=ps.executeQuery();
    		while(rs.next())
    		{
    			showDTO=new DTOWriteOwner();
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
				showDTO.setLike(rs.getInt("liking"));
				showDTO.setCafePrice(rs.getString("cafePrice"));
				showDTO.setCafeReprePicture(rs.getString("cafeRepresentativePicture"));
				showDTO.setCafeIntroduce(rs.getString("cafeIntroduce"));
				showDTO.setId(rs.getString("id"));
    			searchList.add(showDTO);
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	} finally {
    		close(rs,ps,conn);
    	}
    	
    	return searchList;
    }
    
    
}
