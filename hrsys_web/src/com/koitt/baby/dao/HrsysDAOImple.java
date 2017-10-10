package com.koitt.baby.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.commons.codec.binary.Base64;

import com.koitt.baby.sql.HrsysSqlMap;
import com.koitt.baby.dao.HrsysWebDAO;
import com.koitt.baby.vo.HrsysMemberVO;
import com.koitt.baby.vo.HrsysReserveVO;
import com.koitt.baby.common.ChaeBun;
import com.koitt.baby.common.ReserveChaeBun;
import com.koitt.baby.common.ConnProperty;

public class HrsysDAOImple implements HrsysWebDAO{
	
	public int memberInsertWork(HrsysMemberVO mv){
		int i =0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			String s = new String(Base64.encodeBase64(mv.getmPw().getBytes()));
			conn = ConnProperty.getConnection();
			ps = conn.prepareStatement(HrsysSqlMap.insertQuery());
			/*MNO,MID,MPW,MNAME,MADDR,MPHONE,MEMAIL,MDELETEYN*/
			ps.setString(1, ChaeBun.mnoChaebun());
			ps.setString(2, mv.getmId());
			ps.setString(3, s);
			ps.setString(4, mv.getmName());
			ps.setString(5, mv.getmAddr());
			ps.setString(6, mv.getmPhone());
			ps.setString(7, mv.getmEmail());
			ps.setString(8, "Y");
			
			i = ps.executeUpdate();
			
			if(!conn.getAutoCommit()){
				conn.commit();
			}
			ConnProperty.connClose(conn, ps);
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnProperty.connClose(conn, ps);
		}
		
		return i;
	}
	
	public int idCheckWork(){
		int i = 0;
		return i;
	}
	
	public ArrayList loginWork(HrsysMemberVO mv){
		ArrayList aList = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs= null;
		try{	
			conn = ConnProperty.getConnection();
			ps = conn.prepareStatement(HrsysSqlMap.loginQuery());
			String s = new String(Base64.encodeBase64(mv.getmPw().getBytes()));
			/*SELECT A.MNO        
		            ,A.MID
		            ,A.MPW 
		            ,A.MNAME 
		            ,A.MADDR 
		            ,A.MPHONE 
		            ,A.MEMAIL
		            ,A.MDELETEYN  
		      FROM HMEMBER A         
		      WHERE A.MDELETEYN = 'Y' 
		      AND A.MID  = ?  
		      AND A.MPW = ?*/
			
			ps.setString(1, mv.getmId());
			ps.setString(2, s);
			rs = ps.executeQuery();
			if(rs != null){
				
				aList = new ArrayList();
				HrsysMemberVO mv_1 = null;
				mv_1 = new HrsysMemberVO();
				
				while(rs.next()){
					mv_1.setmNo(rs.getString("MNO"));
					mv_1.setmId(rs.getString("MID"));
					mv_1.setmPw(rs.getString("MPW"));
					mv_1.setmName(rs.getString("MNAME"));
					mv_1.setmAddr(rs.getString("MADDR"));
					mv_1.setmPhone(rs.getString("MPHONE"));
					mv_1.setmEmail(rs.getString("MEMAIL"));
					mv_1.setmDeleteyn(rs.getString("MDELETEYN"));
					
					aList.add(mv_1);
				}
			}
			ConnProperty.connClose(conn, ps, rs);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnProperty.connClose(conn, ps, rs);
		}
		return aList;
	}
	
	public int memberUpdateWork(HrsysMemberVO mv){
		int i = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try{
			conn = ConnProperty.getConnection();
			ps = conn.prepareStatement(HrsysSqlMap.updateQuery());
			String s = new String(Base64.encodeBase64(mv.getmPw().getBytes()));
			/*UPDATE HMEMBER A     
			  SET A.MPW =?
			   ,A.MNAME =? 
			   ,A.MADDR =? 
			   ,A.MPHONE  =?
			   ,A.MEMAIL =? 
			  WHERE A.MID  = ?*/

			ps.setString(1, s);
			ps.setString(2, mv.getmName());
			ps.setString(3, mv.getmAddr());
			ps.setString(4, mv.getmPhone());
			ps.setString(5, mv.getmEmail());
			ps.setString(6, mv.getmId());
			
			i = ps.executeUpdate();
			
			if(!conn.getAutoCommit()){
				conn.commit();
			}
			ConnProperty.connClose(conn, ps);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnProperty.connClose(conn, ps);
		}
		
		return i;
	}
	
	public ArrayList memberSelectWork(HrsysMemberVO mv){
		ArrayList aList = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs= null;
		try{	
			conn = ConnProperty.getConnection();
			ps = conn.prepareStatement(HrsysSqlMap.selectQuery());
			/*SELECT A.MNO        
		            ,A.MID
		            ,A.MPW 
		            ,A.MNAME 
		            ,A.MADDR 
		            ,A.MPHONE 
		            ,A.MEMAIL
		            ,A.MDELETEYN  
		      FROM HMEMBER A         
		      WHERE A.MDELETEYN = 'Y' 
		      AND A.MID  = ?*/
			
			ps.setString(1, mv.getmId());
			rs = ps.executeQuery();
			if(rs != null){
				
				aList = new ArrayList();
				HrsysMemberVO mv_1 = null;
				mv_1 = new HrsysMemberVO();
				
				while(rs.next()){
					mv_1.setmNo(rs.getString("MNO"));
					mv_1.setmId(rs.getString("MID"));
					mv_1.setmPw(rs.getString("MPW"));
					mv_1.setmName(rs.getString("MNAME"));
					mv_1.setmAddr(rs.getString("MADDR"));
					mv_1.setmPhone(rs.getString("MPHONE"));
					mv_1.setmEmail(rs.getString("MEMAIL"));
					mv_1.setmDeleteyn(rs.getString("MDELETEYN"));
					
					System.out.println(rs.getString("MNO"));
					System.out.println(rs.getString("MID"));
					System.out.println(rs.getString("MNAME"));
					System.out.println(rs.getString("MADDR"));
					System.out.println(rs.getString("MPHONE"));
					System.out.println(rs.getString("MEMAIL"));
					
					aList.add(mv_1);
				}
			}
			ConnProperty.connClose(conn, ps, rs);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnProperty.connClose(conn, ps, rs);
		}
		return aList;
	}
	
	public int memberDeleteWork(HrsysMemberVO mv){
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		
		try{
			conn = ConnProperty.getConnection();
			ps = conn.prepareStatement(HrsysSqlMap.deleteQuery());
			/*UPDATE HMEMBER A   
			  SET A.MDELETEYN ='N'
			  WHERE A.MID  = ?*/
			ps.setString(1, mv.getmId());
			i = ps.executeUpdate();
			if(!conn.getAutoCommit()){
				conn.commit();
			}
			ConnProperty.connClose(conn, ps);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnProperty.connClose(conn, ps);
		}
		return i;
	}
	
	public int reserveWork(HrsysReserveVO rv){
		int i = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = ConnProperty.getConnection();
			ps = conn.prepareStatement(HrsysSqlMap.reserveQuery());
			/* RNO, RCHECKIN, RCHECKOUT, MNO, RTYPE, SYSDATE, RNUM, 'Y'*/
			ps.setString(1, ReserveChaeBun.reserveNoChb());
			ps.setString(2, rv.getrCheckIn());
			ps.setString(3, rv.getrCheckOut());
			ps.setString(4, rv.getmNo());
			ps.setString(5, rv.getrType());
			ps.setString(6, rv.getrNum());
			
			i = ps.executeUpdate();
			
			if(!conn.getAutoCommit()){
				conn.commit();
			}
			ConnProperty.connClose(conn, ps);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnProperty.connClose(conn, ps);
		}
		
		return i;
	}
	
	public ArrayList reserveSelectWork(HrsysReserveVO rv){
		
		ArrayList aList = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = ConnProperty.getConnection();
			ps = conn.prepareStatement(HrsysSqlMap.reserveSelectQuery());
			/*SELECT RNO 
			        ,RCHECKIN  
			        ,RCHECKOUT
			        ,RTYPE
			        ,RDATE
			        ,RNUM
			        ,RDELETEYN   
		      FROM HRESERVE 
		      WHERE RDELETEYN = 'Y'
		      AND MNO  = ? */
			ps.setString(1, rv.getmNo());
			rs = ps.executeQuery();
			
			if(rs != null){
				aList = new ArrayList();
				while(rs.next()){
					HrsysReserveVO rv_1 = null;
					rv_1 = new HrsysReserveVO();
					
					rv_1.setrNo(rs.getString("RNO"));
					rv_1.setrCheckIn(rs.getString("RCHECKIN"));
					rv_1.setrCheckOut(rs.getString("RCHECKOUT"));
					rv_1.setrType(rs.getString("RTYPE"));
					rv_1.setrDate(rs.getString("RDATE"));
					rv_1.setrNum(rs.getString("RNUM"));
					rv_1.setrDeleteyn(rs.getString("RDELETEYN"));
					
					aList.add(rv_1);
				}
			}
			
			ConnProperty.connClose(conn, ps, rs);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnProperty.connClose(conn, ps, rs);
		}
		
		return aList;
	}
	
	public ArrayList reserveChangeWork(HrsysReserveVO rv){
		ArrayList aList = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = ConnProperty.getConnection();
			ps = conn.prepareStatement(HrsysSqlMap.reserveChangeQuery());
			/*SELECT RNO 
			        ,RCHECKIN  
			        ,RCHECKOUT
			        ,RTYPE
			        ,RDATE
			        ,RNUM
			        ,RDELETEYN  
			        ,MNO  
		      FROM HRESERVE 
		      WHERE RDELETEYN = 'Y'
		      AND RNO  = ? */
			ps.setString(1, rv.getrNo());
			rs = ps.executeQuery();
			
			if(rs != null){
				aList = new ArrayList();
				while(rs.next()){
					HrsysReserveVO rv_1 = null;
					rv_1 = new HrsysReserveVO();
					
					rv_1.setrNo(rs.getString("RNO"));
					rv_1.setrCheckIn(rs.getString("RCHECKIN"));
					rv_1.setrCheckOut(rs.getString("RCHECKOUT"));
					rv_1.setrType(rs.getString("RTYPE"));
					rv_1.setrDate(rs.getString("RDATE"));
					rv_1.setrNum(rs.getString("RNUM"));
					rv_1.setrDeleteyn(rs.getString("RDELETEYN"));
					rv_1.setmNo(rs.getString("MNO"));
					
					aList.add(rv_1);
				}
			}
			
			ConnProperty.connClose(conn, ps, rs);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnProperty.connClose(conn, ps, rs);
		}
		
		return aList;
	}
	
	public int reserveUpdate(HrsysReserveVO rv){
		int i =0;
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = ConnProperty.getConnection();
			ps = conn.prepareStatement(HrsysSqlMap.reserveUpdate());
			/* UPDATE HRESERVE   
		       SET RCHECKIN=?   
		          ,RCHECKOUT=?    
		          ,RTYPE=?       
		          ,RDATE=SYSDATE   
		          ,RNUM=?     
		       WHERE RDELETEYN='Y'  
		       AND RNO=?    */
			ps.setString(1, rv.getrCheckIn());
			ps.setString(2, rv.getrCheckOut());
			ps.setString(3, rv.getrType());
			ps.setString(4, rv.getrNum());
			ps.setString(5, rv.getrNo());
			
			i = ps.executeUpdate();
			
			if(!conn.getAutoCommit()){
				conn.commit();
			}
			ConnProperty.connClose(conn, ps);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnProperty.connClose(conn, ps);
		}
		
		return i;
		
	}
	public int reserveDelete(HrsysReserveVO rv){
		int i =0;
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = ConnProperty.getConnection();
			ps = conn.prepareStatement(HrsysSqlMap.reserveDelete());
			/* UPDATE HRESERVE A     
		       SET A.RDELETEYN ='N'  
		       WHERE A.RNO  = ?      */
			ps.setString(1, rv.getrNo());

			i = ps.executeUpdate();
			
			if(!conn.getAutoCommit()){
				conn.commit();
			}
			ConnProperty.connClose(conn, ps);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnProperty.connClose(conn, ps);
		}
		return i;
	}
}
