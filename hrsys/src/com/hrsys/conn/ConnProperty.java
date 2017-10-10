package com.hrsys.conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public abstract class ConnProperty {

	private static final String JDBC_DRIVER ="oracle.jdbc.driver.OracleDriver";
	private static final String JDBC_URL ="jdbc:oracle:thin:@localhost:1521:orclCJE00";
	private static final String JDBC_USER ="scott";
	private static final String JDBC_PW ="tiger";
	
	public static Connection getConnection() throws SQLException{

		Connection conn = null;

		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PW);

		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}

		return conn;

	}// end of getConnection() method

	public static void connClose(Connection conn, PreparedStatement ps, ResultSet rs){

		try{
			if(rs != null){
				
				try{  rs.close();
					  rs = null;
					  
				}catch(Exception e){}
				
			}

			

			if(ps != null){
				
				try{  ps.close();
					  ps = null;
					  
				}catch(Exception e){}
				
			}
			
			if(conn != null){
				
				try{  conn.close();
					  conn = null;
					  
				}catch(Exception e){}
				
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
			
		}

	}// end of connClose();

	public static void connClose(Connection conn, PreparedStatement ps){

		try{
			
			

			if(ps != null){
				
				try{  ps.close();
					  ps = null;
					  
				}catch(Exception e){}
			}
			
			if(conn != null){
				
				try{  conn.close();
					  conn = null;
					  
				}catch(Exception e){}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}// end of connClose();
	
} //end of ConnProperty class 
