package com.koitt.baby.common;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import com.koitt.baby.sql.HrsysSqlMap;

public class ChaeBun {	
	
		public static String mnoChaebun(){ //static일 경우 인스턴스안하고 import만으로 불러다 쓸 수 있다.
			String mno = "";
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try{
				conn = ConnProperty.getConnection();
				ps = conn.prepareStatement(HrsysSqlMap.HRSYS_WEB_QUERY[HrsysSqlMap.MNO_CNT]);
					//SELECT NVL((MAX(A.MNO)), 0)+1 MNO FROM HMEMBER A;
				rs = ps.executeQuery(); 
				
				if(rs != null){
					while(rs.next()){
						mno = String.valueOf(rs.getInt("MNO")); 
					}
					
					int mLen = mno.length();
					if(mLen==1){
						mno = "000"+mno;
					}
					
					if(mLen==2){
						mno = "00"+mno;
					}
					
					if(mLen==3){
						mno = "0"+mno;
					}
					
				}
				
				ConnProperty.connClose(conn, ps, rs);
				
				if(!conn.getAutoCommit()){
					conn.commit();
				}
				
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				ConnProperty.connClose(conn, ps, rs);
			}
					
			return mno;
		}
		
	}


