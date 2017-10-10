package com.hrsys.dao;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.hrsys.conn.ConnProperty;
import com.hrsys.sql.SqlQueryMap;
import com.hrsys.vo.MemberVO;
import com.hrsys.vo.ReserveVO;

import java.sql.SQLException; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReserveChangeDAO {

	//예약조회 함수
	public ArrayList reserveSelect(String mNumber){ //mNumber는 session에서 넣어주었던 MemberVO의 회원번호 -- 최재은  
	
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList a = null;

		try{			
			conn = ConnProperty.getConnection();
			ps = conn.prepareStatement(SqlQueryMap.getReserveSelectQuery());
			
			//String selectedReserve_No = reserveNoSelect(mNumber);
			//예약번호를 리턴값으로 받아옴
			//System.out.println("selectedReserve_No >> " + selectedReserve_No);
			
			//ps.setString(1, selectedReserve_No);
			ps.setString(1, mNumber);
			ps.setString(2, "Y");
			rs = ps.executeQuery();
			
			if(rs != null){

				a = new ArrayList();

				while(rs.next()){

					ReserveVO rvo = null;
					rvo = new ReserveVO();
					
					String reserve_no = rs.getString("RESERVE_NO");
					String reserve_ci = rs.getString("RESERVE_CI");
					String reserve_co = rs.getString("RESERVE_CO");
					String member_no = rs.getString("MEMBER_NO");
					String room_no = rs.getString("ROOM_NO");
					String reserve_date = rs.getString("RESERVE_DATE");
					int reserve_rate = rs.getInt("RESERVE_RATE");
					int reserve_nop = rs.getInt("RESERVE_NOP");
					String reserve_deleteyn = rs.getString("RESERVE_DELETEYN");
					
					//sql문 실행시킨 것을 ReserveVO에 넣어줌.
					rvo.setReserve_no(reserve_no);
					rvo.setReserve_ci(reserve_ci);
					rvo.setReserve_co(reserve_co);
					rvo.setMember_no(member_no);
					rvo.setRoom_no(room_no);
					rvo.setReserve_date(reserve_date);
					rvo.setReserve_rate(reserve_rate);
					rvo.setReserve_nop(reserve_nop);
					rvo.setReserve_deleteyn(reserve_deleteyn);

					a.add(rvo);//ReserveVO에 넣어준 내용을  ArrayList에 담음.
					
				}
					
			}
					
			if(!conn.getAutoCommit()){
				conn.commit();
			}

			ConnProperty.connClose(conn, ps, rs);

		}catch(SQLException e){
			e.printStackTrace();

		}finally{
			
			try{
				ConnProperty.connClose(conn, ps, rs);

			}catch(Exception e1){
				e1.printStackTrace();
			}
		}

		return a;
	
	}// end of reserveSelect() method
	
	public String reserveNoSelect(String mNumber){ // -- 최재은
				//회원번호(session에 있는 MemberVO의 회원번호)를 가지고 예약번호를 받아오는 함수.
				//회원번호가 mNumber인 것 중 예약번호가 가장 큰 것의 예약번호를 뽑아와야 함.
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String reserve_no = "";
		
		try{
			conn = ConnProperty.getConnection();
			ps = conn.prepareStatement(SqlQueryMap.getReserveNOSelectQuery());
					//세션에서 MemberVO에 넣어준 mNumber와 일치하는 회원번호를 가진 예약테이블의 예약번호를 부를것.
			
			/*SELECT NVL(MAX(A.RESERVE_NO),0)
			  FROM   RESERVE A           
		      WHERE  A.RESERVE_DELETEYN = ? 
		      AND    A.MEMBER_NO        = ?              */
			
			ps.setString(1, "Y"); 
			ps.setString(2, mNumber); 
					   
			rs = ps.executeQuery();

			if(rs != null){
				
				while(rs.next()){
					ReserveVO rvo = null;
					rvo = new ReserveVO();
						
					reserve_no = rs.getString("NVL(MAX(A.RESERVE_NO),0)");			
					rvo.setReserve_no(reserve_no);
					System.out.println("rvo.getReserve_no() in DAO>> " + rvo.getReserve_no());
					System.out.println("reserve_no >> " + reserve_no);
				}
			
			}
		
					
			if(!conn.getAutoCommit()){
				conn.commit();
			}

			ConnProperty.connClose(conn, ps, rs);

		}catch(SQLException e){
			e.printStackTrace();

		}finally{
			
			try{
				ConnProperty.connClose(conn, ps, rs);

			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		
		return reserve_no; //예약번호를 리턴.
	
	}// end of reserveNoSelect() method
	
	public int reserveUpdate(ReserveVO rvo){ //예약 변경 하기 -- 이광하
		System.out.println(rvo);
		System.out.println(rvo.getReserve_no());
		System.out.println("ReserveChangeDAO reserveUpdate() method in***");
		int updateOk = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			
			con = ConnProperty.getConnection();//커넥션 연결
			String sql = SqlQueryMap.getReserveUpdateQuery();
			System.out.println("sql>>"+sql);
			pstmt = con.prepareStatement(sql);
		/*
			pstmt.setString(1,"20170608");//체크인일자
			pstmt.setString(2,"20170609");//체크아웃일자
			pstmt.setString(3,"1");       //방번호
			pstmt.setInt(4,100000);       //결재금액
			pstmt.setInt(5,1);            //인원수
			pstmt.setString(6,"Y");       //예약삭제여부
			pstmt.setString(7,"1");       //예약번호
		*/
			String reserve_ci = rvo.getReserve_ci();//체크인 일자
			String reserve_co = rvo.getReserve_co();//체크아웃 일자
			String member_no = rvo.getMember_no();//회원번호
			String s_room_no = rvo.getRoom_no();//방번호
			int reserve_rate = rvo.getReserve_rate();//결재금액
			int reserve_nop = rvo.getReserve_nop();//인원수 인덱스
			String reserve_no = rvo.getReserve_no();//예약번호

			pstmt.setString(1,reserve_ci);      //체크인일자
			pstmt.setString(2,reserve_co);      //체크아웃일자
			pstmt.setString(3,s_room_no);       //방번호
			pstmt.setInt(4,reserve_rate);       //결재금액
			pstmt.setInt(5,reserve_nop);        //인원수
			pstmt.setString(6,"Y");             //예약삭제여부
			pstmt.setString(7,reserve_no);       //예약번호
			updateOk = pstmt.executeUpdate();
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
		return updateOk;
	}// end of reserveUpdate() method
		
	public int reserveDelete(ReserveVO rvo){ //예약 취소(삭제)하기 함수 -- 이광하
		System.out.println("ReserveChangeDAO reserveDelete() method in ***");
		int deleteOk = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			String reserve_no = rvo.getReserve_no();
			con = ConnProperty.getConnection();
			String sql = SqlQueryMap.getReserveDeleteQuery();
			System.out.println("sql>> \n"+sql);
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1,"N");//삭제하려는 예약삭제여부
			pstmt.setString(2,"Y");//찾으려는 예약삭제여부
			pstmt.setString(3,reserve_no);//예약번호
			deleteOk = pstmt.executeUpdate();
			boolean autoCommit = con.getAutoCommit();
			System.out.println("autoCommit>>"+autoCommit);
			if(!autoCommit){con.commit();}//end of if
			ConnProperty.connClose(con, pstmt);
		}catch(SQLException se){
			se.printStackTrace();
			System.out.println("DB err: "+se.getMessage());
		}finally{
			try{
				ConnProperty.connClose(con, pstmt);
			}catch(Exception e1){
				e1.printStackTrace();
			}//end of Inner try
		}//end of Outter try
		return deleteOk;
	}// end of reserveDelete() method
	
	public String reserveNo(MemberVO mvo){//가장최근 예약한 예약번호 구하기--이광하
		String s_reserveNo = "";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			String s_memberNo = mvo.getMember_no();//로그인한 회원번호
			con = ConnProperty.getConnection();
			String sql = SqlQueryMap.getReserveNoQeury();
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,"Y");//예약삭제여부
			pstmt.setString(2,s_memberNo);//회원번호
			rs = pstmt.executeQuery();
			if(rs != null){
				while(rs.next()){
					s_reserveNo = rs.getString("RESERVE_NO");
				}//end of while
			}//end of if
			
			ConnProperty.connClose(con, pstmt);
		}catch(SQLException se){
			se.printStackTrace();
			System.out.println("DB err: "+se.getMessage());
		}finally{
			try{
				ConnProperty.connClose(con, pstmt);
			}catch(Exception e1){
				e1.printStackTrace();
			}//end of Inner try
		}//end of Outter try
		return s_reserveNo;
	}//end of reserveNo() method
	
	public DefaultTableModel reserveLoginList(MemberVO mvo){//로그인 회원의 예약 리스트--이광하
		System.out.println("ReserveChangeDAO reserveLoginList() method in***");
		DefaultTableModel dtm = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			String mno = mvo.getMember_no();//회원번호
			dtm = new DefaultTableModel();
			con = ConnProperty.getConnection();
			String sql = SqlQueryMap.getRMListQuery();
			System.out.println("sql>>"+sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,"Y");//예약취소여부
			//pstmt.setString(2,"0001");//회원번호
			pstmt.setString(2,mno);//회원번호
			rs = pstmt.executeQuery();
			if(rs != null){
				String cols[] = {    "RESERVE_NO"//예약번호
							        ,"RESERVE_CI"//체크인 일자
							        ,"RESERVE_CO"//체크아웃 일자
							        //,"MEMBER_NO"//회원번호
							        ,"ROOM_NO"//방번호
							        ,"RESERVE_DATE"//예약일
							        ,"RESERVE_RATE"//결재금액
							        ,"RESERVE_NOP"//인원수
							        //,"RESERVE_DELETEYN"
						        };//예약취소여부
				
				String colName[] = {    "예약번호"//예약번호
								       ,"체크인"//체크인 일자
								       ,"체크아웃"//체크아웃 일자
								       //,"회원"//회원번호
								       ,"룸"//방번호
								       ,"예약일"//예약일
								       ,"결재금액"//결재금액
								       ,"인원"//인원수
								       //,"예약YN"
							       };//예약취소여부
		
				int colsLength = cols.length;
				dtm = new DefaultTableModel(colName,0);
				while(rs.next()){
					Object obj[] = new Object[colsLength];

					for(int i = 0; i< colsLength;i++){
						obj[i] = rs.getString(cols[i]);						
					}//end of for
					dtm.addRow(obj);
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
		}//end of Outer try
		return dtm;
	}//end of reserveLoginList() method
	
	public static void main(String args[]){//메인
		ReserveChangeDAO rdao = new ReserveChangeDAO();
		MemberVO mvo = new MemberVO();
		mvo.setMember_no("1");
		String s_reserveNo = rdao.reserveNo(mvo);
		System.out.println("s_reserveNo>>"+ s_reserveNo);
	}//end of main() method
}// end of ReserveChangeDAO class
