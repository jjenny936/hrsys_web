package com.hrsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hrsys.conn.ConnProperty;
import com.hrsys.sql.SqlQueryMap;
import com.hrsys.vo.MemberVO;

public class LoginDao {
	
	public ArrayList login(){
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList aList = null;
		
		try
		{
				
		conn = ConnProperty.getConnection();
		
		/*
		  SELECT A.MEMBER_NO, A.MEMBER_ID, A.MEMBER_PW,	A.MEMBER_NAME, A.MEMBER_ADDR,
		         A.MEMBER_HP, A.MEMBER_EMAIL, A.MEMBER_DELETEYN, A.MEMBER_IN, A.MEMBER_UP
		  FROM	MEMBER A
		  WHERE	 A.MEMBER_DELETEYN = 'Y' */
		
		ps = conn.prepareStatement(SqlQueryMap.queryLoginCheck());
		rs = ps.executeQuery();
			
		aList = new ArrayList();
				
		while (rs.next())
		{
			
			MemberVO mVO = new MemberVO();
			
			mVO.setMember_no(rs.getString("member_no"));
			mVO.setMember_id(rs.getString("member_id"));
			mVO.setMember_pw(rs.getString("member_pw"));
			mVO.setMember_name(rs.getString("member_name"));
			mVO.setMember_addr(rs.getString("member_addr"));
			mVO.setMember_hp(rs.getString("member_hp"));
			mVO.setMember_email(rs.getString("member_email"));
			mVO.setMember_deleteyn(rs.getString("member_deleteyn"));
			
			aList.add(mVO);
			
		}
	
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		finally{
			
			ConnProperty.connClose(conn, ps, rs);
		}
		
		return aList;
	}
	
}
