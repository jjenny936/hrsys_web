package com.hrsys.dao;

import java.util.ArrayList;

import com.hrsys.chae.ReserveChaebun;
import com.hrsys.conn.ConnProperty;
import com.hrsys.sql.SqlQueryMap;
import com.hrsys.vo.ReserveVO;
import com.hrsys.vo.RoomVO;

import java.sql.SQLException; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReserveDAO {
	public int roomReserve(ReserveVO rvo){//예약하기
		System.out.println("ReserveDAO roomReserve() method in***");
		int reserveOk = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = ConnProperty.getConnection();
			String sql = SqlQueryMap.getReserveInsertQuery();
			System.out.println("sql>>"+sql);
			pstmt = con.prepareStatement(sql);
						
			pstmt.setString(1,ReserveChaebun.reserveNoChb());    //예약번호;
			pstmt.setString(2,rvo.getReserve_ci()); //체크인일자;
			pstmt.setString(3,rvo.getReserve_co()); //체크아웃일자;
			pstmt.setString(4,rvo.getMember_no());    //회원번호;
			pstmt.setString(5,rvo.getRoom_no());    //방번호;
			//pstmt.setString(); //예약일;
			pstmt.setInt(6,rvo.getReserve_rate());    //결재금액;
			pstmt.setInt(7,rvo.getReserve_nop());    //인원수;
			pstmt.setString(8,"Y"); //예약취소여부;
			
			reserveOk = pstmt.executeUpdate();
			boolean autoCommit = con.getAutoCommit();
			if(!autoCommit){con.commit();}
			ConnProperty.connClose(con, pstmt);
		}catch(SQLException se){
			se.printStackTrace();
			System.out.println("DB err:"+se.getMessage());
		}finally{
			try{
				ConnProperty.connClose(con, pstmt);
			}catch(Exception e1){
				e1.printStackTrace();
			}//end of Inner try
		}//end of Outer try
		return reserveOk;
	}//end of roomReserve
	
	public ArrayList roomType(){//방번호찾기
		ArrayList aList = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			aList = new ArrayList();
			con = ConnProperty.getConnection();
			String sql = SqlQueryMap.getRoomSelectAllQuery();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			String cols[] = {"ROOM_NO","ROOM_TYPE","ROOM_RATE"};
			int colsLength = cols.length;
			if(rs != null){
				while(rs.next()){
					RoomVO rvo = new RoomVO();
					//int    room_no = 0;//방번호
					String room_no = "";//방번호
					String room_type = "";//방타입
					int    room_rate = 0;//이용금액
					for(int i = 0;i < colsLength;i++){
						if(i==0){room_no = rs.getString(cols[i]);}
						if(i==1){room_type = rs.getString(cols[i]);}
						if(i==2){room_rate = rs.getInt(cols[i]);}
					}//end of for
					rvo.setRoom_no(room_no);
					rvo.setRoom_type(room_type);
					rvo.setRoom_rate(room_rate);
					aList.add(rvo);
				}//end of while
			}//end of if
			ConnProperty.connClose(con, pstmt, rs);
		}catch(SQLException se){
			se.printStackTrace();
			System.out.println("DB err:"+se.getMessage());
		}finally{
			try{
				ConnProperty.connClose(con, pstmt, rs);
			}catch(Exception e1){
				e1.printStackTrace();
			}//end of Inner try
		}//end of Outter try
		return aList;
	}//end of roomType

	public int reserveCancel(){//예약 취소하기
		return 0;
	}//end of reserveCancel
	
	public int reserveUpdate(){//예약 변경하기
		return 0;
	}//end of reserveUpdate
	
	public ArrayList reserveSelect(){//예약 조건 조회
		return null;
	}//end of reserveSelect

}//end of ReserveDAO
