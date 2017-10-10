package com.koitt.baby.sql;

public class HrsysSqlMap {
	
	public static final short MNO_CNT = 0;
	public static final short RNO_CNT = 1;
	
	public static final String HRSYS_WEB_QUERY[] = {
		"SELECT NVL((MAX(A.MNO)), 0)+1 MNO FROM HMEMBER A",
		"SELECT TO_CHAR(SYSDATE, 'YYMMDD') TODAY, NVL((MAX(SUBSTR(A.RNO,7))), 0)+1 RNO FROM HRESERVE A"
	};
	
	public static String insertQuery(){
		StringBuffer sb = new StringBuffer();
		
		/*MNO,MID,MPW,MNAME,MADDR,MPHONE,MEMAIL,MDELETEYN*/
		sb.append("INSERT INTO HMEMBER      \n");
		sb.append("VALUES (?,?,?,?,?,?,?,?) \n");
		
		return sb.toString();
	}
	
	public static String idCheckQuery(){
		StringBuffer sb = new StringBuffer();
		
		
		return sb.toString();
	}
	
	public static String loginQuery(){
		StringBuffer sb = new StringBuffer();
		/*DROP TABLE HMEMBER;
		CREATE TABLE HMEMBER(
		 MNO       VARCHAR2(10) PRIMARY KEY NOT NULL    
		,MID       VARCHAR2(20) NOT NULL 
		,MPW       VARCHAR2(20) NOT NULL  
		,MNAME     VARCHAR2(20) NOT NULL
		,MADDR     VARCHAR2(50) 
		,MPHONE    VARCHAR2(15) 
		,MEMAIL    VARCHAR2(50) 
		,MDELETEYN VARCHAR2(1)  NOT NULL 
		); */
		
		sb.append("SELECT A.MNO            \n");
		sb.append("      ,A.MID            \n");
		sb.append("      ,A.MPW            \n");
		sb.append("      ,A.MNAME          \n");
		sb.append("      ,A.MADDR          \n");
		sb.append("      ,A.MPHONE         \n");
		sb.append("      ,A.MEMAIL         \n");
		sb.append("      ,A.MDELETEYN      \n");
		sb.append("FROM HMEMBER A          \n");
		sb.append("WHERE A.MDELETEYN = 'Y' \n");
		sb.append("AND A.MID  = ?          \n");
		sb.append("AND A.MPW = ?           \n");
		
		return sb.toString();
	}
	
	public static String updateQuery(){
		StringBuffer sb = new StringBuffer();
		
		sb.append("UPDATE HMEMBER A        \n");
		sb.append("SET                     \n");
		sb.append("    A.MPW =?            \n");
		sb.append("   ,A.MNAME =?          \n");
		sb.append("   ,A.MADDR =?          \n");
		sb.append("   ,A.MPHONE  =?        \n");
		sb.append("   ,A.MEMAIL =?         \n");
		sb.append("WHERE A.MID  = ?        \n");
		
		return sb.toString();
	}
	
	public static String selectQuery(){
		StringBuffer sb = new StringBuffer();
		/*DROP TABLE HMEMBER;
		CREATE TABLE HMEMBER(
		 MNO       VARCHAR2(10) PRIMARY KEY NOT NULL    
		,MID       VARCHAR2(20) NOT NULL 
		,MPW       VARCHAR2(20) NOT NULL  
		,MNAME     VARCHAR2(20) NOT NULL
		,MADDR     VARCHAR2(50) 
		,MPHONE    VARCHAR2(15) 
		,MEMAIL    VARCHAR2(50) 
		,MDELETEYN VARCHAR2(1)  NOT NULL 
		); */
		
		sb.append("SELECT MNO            \n");
		sb.append("      ,MID            \n");
		sb.append("      ,MPW            \n");
		sb.append("      ,MNAME          \n");
		sb.append("      ,MADDR          \n");
		sb.append("      ,MPHONE         \n");
		sb.append("      ,MEMAIL         \n");
		sb.append("      ,MDELETEYN      \n");
		sb.append("FROM HMEMBER           \n");
		sb.append("WHERE MDELETEYN = 'Y' \n");
		sb.append("AND MID  = ?          \n");
		
		return sb.toString();
	}
	
	public static String deleteQuery(){
		StringBuffer sb = new StringBuffer();
		
		sb.append("UPDATE HMEMBER A        \n");
		sb.append("SET                     \n");
		sb.append("    A.MDELETEYN ='N'    \n");
		sb.append("WHERE A.MID  = ?        \n");
		
		return sb.toString();
	}
	
	public static String reserveQuery(){
		StringBuffer sb = new StringBuffer();
		
		/* RNO, RCHECKIN, RCHECKOUT, MNO, RTYPE, SYSDATE, RNUM, 'Y'*/
		sb.append("INSERT INTO HRESERVE      \n");
		sb.append("VALUES (?,?,?,?,?,SYSDATE,?,'Y') \n");
		
		return sb.toString();
	}
	
	public static String reserveSelectQuery(){
		StringBuffer sb = new StringBuffer();
		/* RNO        VARCHAR2(10) PRIMARY KEY NOT NULL  --예약번호 
		,RCHECKIN   VARCHAR2(10) NOT NULL  --체크인일자
		,RCHECKOUT  VARCHAR2(10) NOT NULL   --체크아웃일자
		,MNO        VARCHAR2(10) NOT NULL --고객번호
		,RTYPE       VARCHAR2(4)  NOT NULL --방타입
		,RDATE      VARCHAR2(10) NOT NULL --예약된 일자
		,RNUM       VARCHAR2(15)    NOT NULL --총 인원수
		,RDELETEYN  VARCHAR2(1)  NOT NULL */
		
		sb.append("SELECT RNO            \n");
		sb.append("      ,RCHECKIN       \n");
		sb.append("      ,RCHECKOUT      \n");
		sb.append("      ,RTYPE          \n");
		sb.append("      ,RDATE          \n");
		sb.append("      ,RNUM           \n");
		sb.append("      ,RDELETEYN      \n");
		sb.append("FROM HRESERVE         \n");
		sb.append("WHERE RDELETEYN = 'Y' \n");
		sb.append("AND MNO  = ?          \n");
		sb.append("ORDER BY 1 DESC       \n");
		
		return sb.toString();
	}
	
	public static String reserveChangeQuery(){
		StringBuffer sb = new StringBuffer();
		/* RNO        VARCHAR2(10) PRIMARY KEY NOT NULL  --예약번호 
		,RCHECKIN   VARCHAR2(10) NOT NULL  --체크인일자
		,RCHECKOUT  VARCHAR2(10) NOT NULL   --체크아웃일자
		,MNO        VARCHAR2(10) NOT NULL --고객번호
		,RTYPE       VARCHAR2(4)  NOT NULL --방타입
		,RDATE      VARCHAR2(10) NOT NULL --예약된 일자
		,RNUM       VARCHAR2(15)    NOT NULL --총 인원수
		,RDELETEYN  VARCHAR2(1)  NOT NULL */
		
		sb.append("SELECT RNO            \n");
		sb.append("      ,RCHECKIN       \n");
		sb.append("      ,RCHECKOUT      \n");
		sb.append("      ,RTYPE          \n");
		sb.append("      ,RDATE          \n");
		sb.append("      ,RNUM           \n");
		sb.append("      ,RDELETEYN      \n");
		sb.append("      ,MNO            \n");
		sb.append("FROM HRESERVE         \n");
		sb.append("WHERE RDELETEYN = 'Y' \n");
		sb.append("AND RNO  = ?          \n");
		
		return sb.toString();
	}
	
	public static String reserveDelete(){
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE HRESERVE A        \n");
		sb.append("SET                     \n");
		sb.append("    A.RDELETEYN ='N'    \n");
		sb.append("WHERE A.RNO  = ?        \n");
		return sb.toString();
	}
	
	public static String reserveUpdate(){
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE HRESERVE       \n");
		sb.append("SET RCHECKIN=?        \n");
		sb.append("   ,RCHECKOUT=?       \n");
		sb.append("   ,RTYPE=?           \n");
		sb.append("   ,RDATE=SYSDATE     \n");
		sb.append("   ,RNUM=?            \n");
		sb.append("WHERE RDELETEYN='Y'   \n");
		sb.append("AND RNO=?             \n");
		return sb.toString();
	}
}
