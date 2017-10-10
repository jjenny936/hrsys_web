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
	public int roomReserve(ReserveVO rvo){//�����ϱ�
		System.out.println("ReserveDAO roomReserve() method in***");
		int reserveOk = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = ConnProperty.getConnection();
			String sql = SqlQueryMap.getReserveInsertQuery();
			System.out.println("sql>>"+sql);
			pstmt = con.prepareStatement(sql);
						
			pstmt.setString(1,ReserveChaebun.reserveNoChb());    //�����ȣ;
			pstmt.setString(2,rvo.getReserve_ci()); //üũ������;
			pstmt.setString(3,rvo.getReserve_co()); //üũ�ƿ�����;
			pstmt.setString(4,rvo.getMember_no());    //ȸ����ȣ;
			pstmt.setString(5,rvo.getRoom_no());    //���ȣ;
			//pstmt.setString(); //������;
			pstmt.setInt(6,rvo.getReserve_rate());    //����ݾ�;
			pstmt.setInt(7,rvo.getReserve_nop());    //�ο���;
			pstmt.setString(8,"Y"); //������ҿ���;
			
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
	
	public ArrayList roomType(){//���ȣã��
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
					//int    room_no = 0;//���ȣ
					String room_no = "";//���ȣ
					String room_type = "";//��Ÿ��
					int    room_rate = 0;//�̿�ݾ�
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

	public int reserveCancel(){//���� ����ϱ�
		return 0;
	}//end of reserveCancel
	
	public int reserveUpdate(){//���� �����ϱ�
		return 0;
	}//end of reserveUpdate
	
	public ArrayList reserveSelect(){//���� ���� ��ȸ
		return null;
	}//end of reserveSelect

}//end of ReserveDAO
