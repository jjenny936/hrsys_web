package com.hrsys.chae;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hrsys.conn.ConnProperty;
import com.hrsys.sql.SqlQueryMap;

public abstract class MemberChaebun {

	public static String memNoChaebun(){
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;	
		
		String memNO = "";		 
		
		try
		{
			conn = ConnProperty.getConnection();
			System.out.println("Connection이 성공되었습니다.");
			
			/* SELECT NVL((MAX(A.MEMBER_NO)), 0)+1 memNo 
			   FROM MEMBER A 
			   
			   memNo는 NVL((MAX(A.MEMBER_NO)), 0)+1의 컬럼명*/
				
			ps = conn.prepareStatement(
					SqlQueryMap.SEQuery[SqlQueryMap.QUERY_MEMBERNO_CHAE_BUN]);			
			rs = ps.executeQuery();	
			System.out.println(" CAHBUN ===> : \n" 
					+ SqlQueryMap.SEQuery[SqlQueryMap.QUERY_MEMBERNO_CHAE_BUN]);	
			
			if ( rs != null)
			{
				while (rs.next())
			  {
					 memNO = String.valueOf(rs.getInt("memNO"));					
			  }
			}
			
			System.out.println(" memNO >>>> : " + memNO);
			
			//MEMBER_NO의 데이타 타입이 VARCHAR2.
			if (1 == memNO.length())
			{
				memNO = "000" + memNO;
			}
			
			if (2 == memNO.length())
			{
				memNO = "00" + memNO;
			}
			
			if (3 == memNO.length())
			{
				memNO = "0" + memNO;
			}
			
			ConnProperty.connClose(conn, ps);
		}
		catch (SQLException e)
		{
			System.out.println(" DB 에러 " + e.getMessage());
		}
		finally 
		{
			try
			{
				ConnProperty.connClose(conn, ps);
			}
			catch (Exception e2)
			{
				e2.printStackTrace();
			}		
								
		} 
	
		return memNO;		
		
	}// end of memNoChaebun() method
	
	public static void main(String args[]){
		
		String memNO= "";
		memNO = MemberChaebun.memNoChaebun();
		
	}// end of main() method
	
}// end of MemberChaebun class
