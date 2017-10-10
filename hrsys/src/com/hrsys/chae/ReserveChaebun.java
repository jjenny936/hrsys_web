package com.hrsys.chae;

import java.sql.SQLException;

import com.hrsys.conn.ConnProperty;
import com.hrsys.sql.SqlQueryMap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReserveChaebun {
	public static String reserveNoChb(){//예약번호 4자리수 채번하기
		String reserveNoOk = "";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = ConnProperty.getConnection();
			String sql = SqlQueryMap.SEQuery[SqlQueryMap.RESERVE_CHB];
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs != null){
				while(rs.next()){
					reserveNoOk = rs.getString("CHB"); 
				}//end of while
			}//end of if
			int rLength = reserveNoOk.length();
			String zero[] = {"000","00","0"};
			//1 >>000+1
			if(rLength==1){reserveNoOk = zero[0]+reserveNoOk;}
			//11 >>00+11
			if(rLength==2){reserveNoOk = zero[1]+reserveNoOk;}
			//111 >>0+111
			if(rLength==3){reserveNoOk = zero[2]+reserveNoOk;}
			ConnProperty.connClose(con, pstmt);
		}catch(SQLException se){
			se.printStackTrace();
			System.out.println("DB err"+se.getMessage());
		}finally{
			try{
				ConnProperty.connClose(con, pstmt);
			}catch(Exception e1){
				e1.printStackTrace();
			}//end of Inner try
		}//end of Outter try
		return reserveNoOk;	
	}//end of reserveNoChb() method
	
	public static void main(String args[]){
		String chb = reserveNoChb();
		System.out.println(chb);
	}//end of main() method
}//end of ReserveChaebun class
