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

	//������ȸ �Լ�
	public ArrayList reserveSelect(String mNumber){ //mNumber�� session���� �־��־��� MemberVO�� ȸ����ȣ -- ������  
	
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList a = null;

		try{			
			conn = ConnProperty.getConnection();
			ps = conn.prepareStatement(SqlQueryMap.getReserveSelectQuery());
			
			//String selectedReserve_No = reserveNoSelect(mNumber);
			//�����ȣ�� ���ϰ����� �޾ƿ�
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
					
					//sql�� �����Ų ���� ReserveVO�� �־���.
					rvo.setReserve_no(reserve_no);
					rvo.setReserve_ci(reserve_ci);
					rvo.setReserve_co(reserve_co);
					rvo.setMember_no(member_no);
					rvo.setRoom_no(room_no);
					rvo.setReserve_date(reserve_date);
					rvo.setReserve_rate(reserve_rate);
					rvo.setReserve_nop(reserve_nop);
					rvo.setReserve_deleteyn(reserve_deleteyn);

					a.add(rvo);//ReserveVO�� �־��� ������  ArrayList�� ����.
					
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
	
	public String reserveNoSelect(String mNumber){ // -- ������
				//ȸ����ȣ(session�� �ִ� MemberVO�� ȸ����ȣ)�� ������ �����ȣ�� �޾ƿ��� �Լ�.
				//ȸ����ȣ�� mNumber�� �� �� �����ȣ�� ���� ū ���� �����ȣ�� �̾ƿ;� ��.
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String reserve_no = "";
		
		try{
			conn = ConnProperty.getConnection();
			ps = conn.prepareStatement(SqlQueryMap.getReserveNOSelectQuery());
					//���ǿ��� MemberVO�� �־��� mNumber�� ��ġ�ϴ� ȸ����ȣ�� ���� �������̺��� �����ȣ�� �θ���.
			
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
		
		return reserve_no; //�����ȣ�� ����.
	
	}// end of reserveNoSelect() method
	
	public int reserveUpdate(ReserveVO rvo){ //���� ���� �ϱ� -- �̱���
		System.out.println(rvo);
		System.out.println(rvo.getReserve_no());
		System.out.println("ReserveChangeDAO reserveUpdate() method in***");
		int updateOk = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			
			con = ConnProperty.getConnection();//Ŀ�ؼ� ����
			String sql = SqlQueryMap.getReserveUpdateQuery();
			System.out.println("sql>>"+sql);
			pstmt = con.prepareStatement(sql);
		/*
			pstmt.setString(1,"20170608");//üũ������
			pstmt.setString(2,"20170609");//üũ�ƿ�����
			pstmt.setString(3,"1");       //���ȣ
			pstmt.setInt(4,100000);       //����ݾ�
			pstmt.setInt(5,1);            //�ο���
			pstmt.setString(6,"Y");       //�����������
			pstmt.setString(7,"1");       //�����ȣ
		*/
			String reserve_ci = rvo.getReserve_ci();//üũ�� ����
			String reserve_co = rvo.getReserve_co();//üũ�ƿ� ����
			String member_no = rvo.getMember_no();//ȸ����ȣ
			String s_room_no = rvo.getRoom_no();//���ȣ
			int reserve_rate = rvo.getReserve_rate();//����ݾ�
			int reserve_nop = rvo.getReserve_nop();//�ο��� �ε���
			String reserve_no = rvo.getReserve_no();//�����ȣ

			pstmt.setString(1,reserve_ci);      //üũ������
			pstmt.setString(2,reserve_co);      //üũ�ƿ�����
			pstmt.setString(3,s_room_no);       //���ȣ
			pstmt.setInt(4,reserve_rate);       //����ݾ�
			pstmt.setInt(5,reserve_nop);        //�ο���
			pstmt.setString(6,"Y");             //�����������
			pstmt.setString(7,reserve_no);       //�����ȣ
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
		
	public int reserveDelete(ReserveVO rvo){ //���� ���(����)�ϱ� �Լ� -- �̱���
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

			pstmt.setString(1,"N");//�����Ϸ��� �����������
			pstmt.setString(2,"Y");//ã������ �����������
			pstmt.setString(3,reserve_no);//�����ȣ
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
	
	public String reserveNo(MemberVO mvo){//�����ֱ� ������ �����ȣ ���ϱ�--�̱���
		String s_reserveNo = "";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			String s_memberNo = mvo.getMember_no();//�α����� ȸ����ȣ
			con = ConnProperty.getConnection();
			String sql = SqlQueryMap.getReserveNoQeury();
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,"Y");//�����������
			pstmt.setString(2,s_memberNo);//ȸ����ȣ
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
	
	public DefaultTableModel reserveLoginList(MemberVO mvo){//�α��� ȸ���� ���� ����Ʈ--�̱���
		System.out.println("ReserveChangeDAO reserveLoginList() method in***");
		DefaultTableModel dtm = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			String mno = mvo.getMember_no();//ȸ����ȣ
			dtm = new DefaultTableModel();
			con = ConnProperty.getConnection();
			String sql = SqlQueryMap.getRMListQuery();
			System.out.println("sql>>"+sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,"Y");//������ҿ���
			//pstmt.setString(2,"0001");//ȸ����ȣ
			pstmt.setString(2,mno);//ȸ����ȣ
			rs = pstmt.executeQuery();
			if(rs != null){
				String cols[] = {    "RESERVE_NO"//�����ȣ
							        ,"RESERVE_CI"//üũ�� ����
							        ,"RESERVE_CO"//üũ�ƿ� ����
							        //,"MEMBER_NO"//ȸ����ȣ
							        ,"ROOM_NO"//���ȣ
							        ,"RESERVE_DATE"//������
							        ,"RESERVE_RATE"//����ݾ�
							        ,"RESERVE_NOP"//�ο���
							        //,"RESERVE_DELETEYN"
						        };//������ҿ���
				
				String colName[] = {    "�����ȣ"//�����ȣ
								       ,"üũ��"//üũ�� ����
								       ,"üũ�ƿ�"//üũ�ƿ� ����
								       //,"ȸ��"//ȸ����ȣ
								       ,"��"//���ȣ
								       ,"������"//������
								       ,"����ݾ�"//����ݾ�
								       ,"�ο�"//�ο���
								       //,"����YN"
							       };//������ҿ���
		
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
	
	public static void main(String args[]){//����
		ReserveChangeDAO rdao = new ReserveChangeDAO();
		MemberVO mvo = new MemberVO();
		mvo.setMember_no("1");
		String s_reserveNo = rdao.reserveNo(mvo);
		System.out.println("s_reserveNo>>"+ s_reserveNo);
	}//end of main() method
}// end of ReserveChangeDAO class
