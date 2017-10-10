package com.koitt.baby.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnProperty {

	private static final String JDBC_DRIVER="oracle.jdbc.driver.OracleDriver";
	private static final String JDBC_URL="jdbc:oracle:thin:@localhost:1521:orclCJE00";
	private static final String JDBC_ID="scott";
	private static final String JDBC_PW="tiger";
	
	public static Connection getConnection() throws SQLException{
		Connection conn = null;
		
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, JDBC_ID, JDBC_PW);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
						
		return conn;
	}
	
	public static void connClose(Connection conn, PreparedStatement ps){
		
		try{
			if(conn != null){
				try{
					conn.close();
					conn = null;
				}catch(Exception e){
					e.getMessage();
				}
			}
			
			if(ps != null){
				try{
					ps.close();
					ps = null;
				}catch(Exception e){
					e.getMessage();
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void connClose(Connection conn, PreparedStatement ps, ResultSet rs){
		
		try{
			if(conn != null){
				try{
					conn.close();
					conn = null;
					
				}catch(Exception e){
					e.getMessage();
				}				
			}
			
			if(ps != null){
				try{
					ps.close();
					ps = null;
					
				}catch(Exception e){
					e.getMessage();
				}				
			}
			
			if(rs != null){
				try{
					rs.close();
					rs = null;
					
				}catch(Exception e){
					e.getMessage();
				}				
			}
					
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
