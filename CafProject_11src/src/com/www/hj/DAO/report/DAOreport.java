package com.www.hj.DAO.report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.www.hj.DAO.search.DAOSearch;

/****************
 * 
 *  report 관련 DAO
 * 
 * **************/
public class DAOreport {
	private static DAOreport reportDAO = new DAOreport();
	private String CONNECTION_POOL_NAME = "jdbc/cafeinfodb";
	private DataSource dataSource;
	
	
	public DAOreport() {
        try {
        	Context context = new InitialContext();
        	dataSource = (DataSource)context.lookup("java:comp/env/"+CONNECTION_POOL_NAME);
        } catch(NamingException e) {
        	e.printStackTrace();
        }
    }
	
	  public static DAOreport getReportDAO() {
	    	return reportDAO;
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
	    
	    //신고
	    public void report(String writerId,String contents)
	    {
	    	final String REPORT_SQL="insert report(writerId,reportContents)  values(?, ?)";
	    	Connection conn = getConnection();
			PreparedStatement ps = null;
			int curNum=0;
			int rs=0;
			try {
				ps=conn.prepareStatement(REPORT_SQL);
				ps.setString(1, writerId);
				ps.setString(2, contents);
				System.out.println("ps: "+ps); //주석
				rs=ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(ps,conn);
			}
	    }
	    
	  //신고
	    public void reportText(String writerId,String contents,String select)
	    {
	    	final String REPORT_SQL="insert report values(?, ?,?)";
	    	Connection conn = getConnection();
			PreparedStatement ps = null;
			int curNum=0;
			int rs=0;
			try {
				ps=conn.prepareStatement(REPORT_SQL);
				ps.setString(1, writerId);
				ps.setString(2, contents);
				ps.setString(3, select);
				System.out.println("ps: "+ps); //주석
				rs=ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(ps,conn);
			}
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
