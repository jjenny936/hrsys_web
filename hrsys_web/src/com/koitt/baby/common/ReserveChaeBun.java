package com.koitt.baby.common;

import java.sql.SQLException;

import com.koitt.baby.common.ConnProperty;
import com.koitt.baby.sql.HrsysSqlMap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReserveChaeBun {
	public static String reserveNoChb(){//예약번호 채번하기
		String reserveNoOk = "";
		String today = "";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = ConnProperty.getConnection();
			String sql = HrsysSqlMap.HRSYS_WEB_QUERY[HrsysSqlMap.RNO_CNT];
			/*SELECT TO_CHAR(SYSDATE, 'YYMMDD') TODAY, NVL((MAX(A.RNO)), 0)+1 RNO FROM HRESERVE A*/
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs != null){
				while(rs.next()){
					today = rs.getString("TODAY");
					reserveNoOk = rs.getString("RNO"); 
				}//end of while
			}//end of if
			int rLength = reserveNoOk.length();
			String zero[] = {"000","00","0"};
			//1 >>000+1
			if(rLength==1){reserveNoOk = today+zero[0]+reserveNoOk;}
			//11 >>00+11
			if(rLength==2){reserveNoOk = today+zero[1]+reserveNoOk;}
			//111 >>0+111
			if(rLength==3){reserveNoOk = today+zero[2]+reserveNoOk;}
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
