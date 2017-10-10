package com.hrsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 

import com.hrsys.chae.MemberChaebun;
import com.hrsys.conn.ConnProperty;
import com.hrsys.sql.SqlQueryMap;
import com.hrsys.vo.MemberVO;

public class MemberDAO {

	public int memberJoin(MemberVO mv) throws Exception{ //ȸ������ �Լ�
		
		Connection conn = null;
		PreparedStatement ps = null;
		int i = 0;
		try{
			/* INSERT INTO MEMBER 
			   VALUES (?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, SYSDATE) */
			
			conn = ConnProperty.getConnection();
			ps = conn.prepareStatement(SqlQueryMap.SEQuery[SqlQueryMap.QUERY_MEMBERNO_JOIN]);

			ps.setString(1, MemberChaebun.memNoChaebun()); 
			ps.setString(2, mv.getMember_id()); //Scr Ŭ������ ȸ�������Լ����� set ���� ������ get �ؿ´�.
			ps.setString(3, mv.getMember_pw());
			ps.setString(4, mv.getMember_name());
			ps.setString(5, mv.getMember_addr());
			ps.setString(6, mv.getMember_hp());
			ps.setString(7, mv.getMember_email());
			ps.setString(8, "Y");

			i = ps.executeUpdate(); 
				  /*executeUpdate() method in PreparedStatement interface
				    Returns:either (1) the row count for SQL Data Manipulation Language (DML) statements or 
				                   (2) 0 for SQL statements that return nothing*/

			if(!conn.getAutoCommit()){
				conn.commit();
			}

			ConnProperty.connClose(conn, ps);
		
		}catch(SQLException e){
			e.printStackTrace();

		}finally{
			try{
				ConnProperty.connClose(conn, ps);
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}

		return i;
		
	}// end of memberJoin() method
	
	public int memberUpdate(MemberVO mVO) throws Exception{ //���������� -> �������
		
		Connection conn = null;
		PreparedStatement ps = null;
		int i = 0;
		
		try{
			conn = ConnProperty.getConnection();
			
			ps = conn.prepareStatement(SqlQueryMap.queryMemberUpdate());

			/*UPDATE MEMBER	
			  SET member_pw = ?, member_name = ?, member_addr= ?, member_hp= ?	, member_email= ?
		      WHERE	member_id = ?	*/
			
			ps.setString(1, mVO.getMember_pw());
			ps.setString(2, mVO.getMember_name());
			ps.setString(3, mVO.getMember_addr());
			ps.setString(4, mVO.getMember_hp());
			ps.setString(5, mVO.getMember_email());
			ps.setString(6, mVO.getMember_id());

			i = ps.executeUpdate(); //������ �Ͼ Ƚ���� ������ ��.

			if(!conn.getAutoCommit()){
				conn.commit();
			}

			ConnProperty.connClose(conn, ps);
		
		}catch(SQLException e){
			e.printStackTrace();

		}finally{
			try{
				ConnProperty.connClose(conn, ps);
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}

		return i;
		
	}// end of memberUpdate() method
	
	public int memberDelete(MemberVO mVO) throws Exception{ //Ż���Լ�
		
		Connection conn = null;
		PreparedStatement ps = null;
		int i = 0;
		
		try{
			conn = ConnProperty.getConnection();
			ps = conn.prepareStatement(SqlQueryMap.queryMemberDelete());

			ps.setString(1, mVO.getMember_deleteyn());
			ps.setString(2, mVO.getMember_id());

			i = ps.executeUpdate();

			if(!conn.getAutoCommit()){
				conn.commit();
			}

			ConnProperty.connClose(conn, ps);
		
		}catch(SQLException e){
			e.printStackTrace();

		}finally{
			try{
				ConnProperty.connClose(conn, ps);
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}

		return i;
		
	}// end of memberdelete() method
		
	public int idCheck(MemberVO mv) throws Exception //���̵��ߺ� üũ �Լ�
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int i = 0; //�������� i �ʱ�ȭ.

		try
		{
			/* SELECT COUNT(MEMBER_ID) A 			 
			   FROM   MEMBER A WHERE MEMBER_ID = ? 
			   AND    MEMBER_DELETEYN = ? */
			
			conn = ConnProperty.getConnection();			
			ps = conn.prepareStatement(SqlQueryMap.SEQuery[SqlQueryMap.QUERY_ID_CHECK]);						
			ps.setString(1, mv.getMember_id());//scrŬ���� idCheckWork()���� set���� member_id�� ������.
			ps.setString(2, "Y");
			rs = ps.executeQuery();

				if (rs !=null)
				{

					while (rs.next())
					{					
						i = rs.getInt("A"); //COUNT(MEMBER_ID) A -> 0�� ��� �ߺ�x.

					}
				}

				ConnProperty.connClose(conn, ps, rs);
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					ConnProperty.connClose(conn, ps, rs);
				}
				catch (Exception e2)
				{
					e2.printStackTrace();
				}
			}
			
			return i;
		
	}// end of idCheck() method

	public ArrayList memberSelect(){
		
		System.out.println();
		LoginDao lDao = null;
		lDao = new LoginDao();
		
		ArrayList aList = lDao.login();
			
		return aList;
		
	} // end of memberSelect() method
		
}// end of MemberDAO class
