package com.hrsys.sql;

import java.util.ArrayList;

public abstract class SqlQueryMap {

	public static final int RESERVE_CHB = 5;	
	public static final short QUERY_MEMBERNO_CHAE_BUN = 6;
	public static final short QUERY_ID_CHECK = 7;
	public static final short QUERY_MEMBERNO_JOIN = 8;
	public static final short QUERY_RESERVE_CHANGE_SELECT = 9;
	//public static final short QUERY_LOGIN_CHECK = 10;
	//public static final short QUERY_MEMBERUPDATE = 11;
	//public static final short QUERY_MEMBERDELETE = 12;

	public static final String SEQuery[] = {

		 ""
		,""
		,""
		,""
		,""
		," SELECT NVL(SUBSTR(MAX(A.RESERVE_NO),1),0)+1 CHB FROM RESERVE A "
		,"SELECT NVL((MAX(A.MEMBER_NO)), 0)+1 memNo FROM MEMBER A" //회원가입 member_no 채번
		,"SELECT COUNT(MEMBER_ID) A FROM MEMBER A WHERE MEMBER_ID = ? AND MEMBER_DELETEYN = ?" //아이디중복 확인
		,"INSERT INTO MEMBER VALUES (?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, SYSDATE)"//회원가입
		,"SELECT A.RESERVE_NO, A.RESERVE_CI, A.RESERVE_CO, A.MEMBER_NO, A.ROOM_NO, A.RESERVE_DATE, A.RESERVE_RATE,"
		  + "A.RESERVE_NOP, A.RESERVE_DELETEYN FROM RESERVE A WHERE A.MEMBER_NO =?"
		,"SELECT A.MEMBER_NO, A.MEMBER_ID, A.MEMBER_PW,	A.MEMBER_NAME,	A.MEMBER_ADDR, A.MEMBER_HP, A.MEMBER_EMAIL,"
		 + "A.MEMBER_DELETEYN,	A.MEMBER_IN, A.MEMBER_UP  FROM MEMBER A WHERE A.MEMBER_DELETEYN = 'Y'"
		,"UPDATE MEMBER SET member_pw = ?, member_name = ?, member_addr= ? , member_hp= ?,"
		 + "member_email= ? WHERE member_id = ?"
		 ,"UPDATE MEMBER SET member_deleteyn = ? WHERE member_id = ?"
		}; 
	
	static String getMemberInsertQuery(){ //회원가입에 들어가는 쿼리문.
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("INSERT INTO                        \n");
		sb.append("            MEMBER                 \n");
		sb.append("                   VALUES(         \n");
		sb.append("                          ?,       \n");
		sb.append("                          ?,       \n");
		sb.append("                          ?,       \n");
		sb.append("                          ?,       \n");
		sb.append("                          ?,       \n");
		sb.append("                          ?,       \n");
		sb.append("                          ?,       \n");
		sb.append("                          ?,       \n");
		sb.append("                          SYSDATE, \n");
		sb.append("                          SYSDATE) \n");
		
		return sb.toString();
		
	}// end of getMemberInsertQuery() method
	
	public static String getReserveSelectQuery(){ //예약조회에 들어가는 쿼리문.
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("SELECT A.RESERVE_NO                                   \n");
		sb.append("      ,TO_CHAR(A.RESERVE_CI, 'YYYYMMDD') RESERVE_CI   \n");
		sb.append("      ,TO_CHAR(A.RESERVE_CO, 'YYYYMMDD') RESERVE_CO   \n");
		sb.append("      ,A.MEMBER_NO                                    \n");
		sb.append("      ,A.ROOM_NO               						 \n");
		sb.append("      ,A.RESERVE_DATE          						 \n");
		sb.append("      ,A.RESERVE_RATE           						 \n");
		sb.append("      ,A.RESERVE_NOP           						 \n");
		sb.append("      ,A.RESERVE_DELETEYN       						 \n");
		sb.append("FROM                           						 \n");
		sb.append("      RESERVE A                 						 \n");
		sb.append("WHERE                           					     \n");
		sb.append("      A.RESERVE_NO =                 				 \n");
		sb.append("                     ?          					     \n");
		sb.append("AND                             						 \n");
		sb.append("      A.RESERVE_DELETEYN =      						 \n");
		sb.append("                           ?    						 \n");
		
		return sb.toString();
		
	}// end of getReserveSelectQuery() method
	
	public static String getReserveNOSelectQuery(){ //예약조회에서 예약번호 불러오기 위한 쿼리문.
												//회원번호가 1인 것 중 예약번호가 가장 큰 것의 예약번호를 뽑아와야 함.
		StringBuffer sb = new StringBuffer();

		sb.append(" SELECT NVL(MAX(A.RESERVE_NO),0)            \n");//예약번호
		sb.append(" FROM   RESERVE A                           \n");
		sb.append(" WHERE  A.RESERVE_DELETEYN = ?              \n");//예약삭제여부
		sb.append(" AND    A.MEMBER_NO        = ?              \n");//회원번호
		
		return sb.toString();
		
	}// end of getReserveNOSelectQuery() method
	
	public static String queryLoginCheck() {

		StringBuffer sb = new StringBuffer();
		sb.append("			SELECT					 ");
		sb.append("			A.MEMBER_NO,			 ");
		sb.append("			A.MEMBER_ID,			 ");
		sb.append("			 A.MEMBER_PW,			 ");
		sb.append("			A.MEMBER_NAME,			 ");
		sb.append("			A.MEMBER_ADDR,			 ");
		sb.append("			A.MEMBER_HP,			 ");
		sb.append("			A.MEMBER_EMAIL,			 ");
		sb.append("			A.MEMBER_DELETEYN,		 ");
		sb.append("			A.MEMBER_IN,			 ");
		sb.append("			A.MEMBER_UP				 ");
		sb.append("			FROM					 ");
		sb.append("			MEMBER A				 ");
		sb.append("			WHERE		 			 ");
		sb.append("			 A.MEMBER_DELETEYN = 'Y' ");
		
		return sb.toString();
	}
	public static String queryMemberUpdate() {

		StringBuffer sb = new StringBuffer();
		sb.append("			UPDATE					 ");
		sb.append("			MEMBER					 ");
		sb.append("			SET						 ");
		sb.append("			member_pw = ?			 ");
		sb.append("			,member_name = ?		 ");
		sb.append("			,member_addr= ?			 ");
		sb.append("			,member_hp= ?			 ");
		sb.append("			,member_email= ?		 ");
		sb.append("			WHERE		 			 ");
		sb.append("			member_id = ?			 ");
		   
		return sb.toString();
	}
	
	public static String queryMemberDelete() {

		StringBuffer sb = new StringBuffer();
		sb.append("			UPDATE					 ");
		sb.append("			MEMBER					 ");
		sb.append("			SET						 ");
		sb.append("			member_deleteyn = ?		 ");
		sb.append("			WHERE		 			 ");
		sb.append("			member_id = ?		 	 ");

		return sb.toString();
	}

	public static String getReserveInsertQuery(){//예약하기 -- 이광하
		StringBuffer sb = new StringBuffer();
		sb.append(" INSERT INTO RESERVE             ");
		sb.append(" VALUES(?,?,?,?,?,SYSDATE,?,?,?) ");
		return sb.toString();
	}//end of reserveInsertQuery() method

	public static String getRoomSelectAllQuery(){//호텔객실 전체 조회 -- 이광하
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT A.ROOM_NO ROOM_NO     ");//방번호
		sb.append("       ,A.ROOM_TYPE ROOM_TYPE ");//방타입
		sb.append("       ,A.ROOM_RATE ROOM_RATE ");//이용금액
		sb.append(" FROM   ROOM A");
		sb.append(" ORDER BY 1 ");
		return sb.toString();
	}//end of roomTypeSelectQuery() method

	public static String getReserveUpdateQuery(){//예약변경 -- 이광하
		StringBuffer sb = new StringBuffer();
		sb.append(" UPDATE  RESERVE A                   \n");//예약테이블
		sb.append(" SET                                 \n");
		sb.append("        A.RESERVE_CI       = ?       \n");//체크인일자
		sb.append("       ,A.RESERVE_CO       = ?       \n");//체크아웃일자
		sb.append("       ,A.ROOM_NO          = ?       \n");//방번호
		sb.append("       ,A.RESERVE_DATE     = SYSDATE \n");//예약일
		sb.append("       ,A.RESERVE_RATE     = ?       \n");//결재금액
		sb.append("       ,A.RESERVE_NOP      = ?       \n");//인원수
		sb.append(" WHERE  A.RESERVE_DELETEYN = ?       \n");//예약삭제여부
		sb.append(" AND    A.RESERVE_NO       = ?       \n");//예약번호
		return sb.toString();
	}//end of reserveUpdateQuery() method

	public static String getReserveNoQeury(){//가장최근 예약한 예약번호 구하기 -- 이광하
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT NVL(MAX(A.RESERVE_NO),0) RESERVE_NO \n");//예약번호
		sb.append(" FROM   RESERVE A                           \n");
		sb.append(" WHERE  A.RESERVE_DELETEYN = ?              \n" );//예약삭제여부
		sb.append(" AND    A.MEMBER_NO        = ?              \n" );//회원번호
		return sb.toString();
	}//end of reserveNoSelect() method

	public static String getReserveDeleteQuery(){//예약취소(삭제)하기 -- 이광하
		StringBuffer sb = new StringBuffer();
		sb.append(" UPDATE RESERVE A              \n");//예약테이블
		sb.append(" SET    A.RESERVE_DELETEYN = ? \n");//삭제하려는 예약삭제여부
		sb.append(" WHERE  A.RESERVE_DELETEYN = ? \n");//찾으려는 예약삭제여부
		sb.append(" AND    A.RESERVE_NO       = ? \n");//예약번호
		return sb.toString();
	}//end of reserveDeleteQuery() method	
	
	public static String getRMListQuery(){//로그인 회원의 예약 리스트 쿼리 -- 이광하
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT A.RESERVE_NO                           RESERVE_NO       \n");//예약번호
		sb.append("       ,TO_CHAR(A.RESERVE_CI,'YYYYMMDD')       RESERVE_CI       \n");//체크인 일자
		sb.append("       ,TO_CHAR(A.RESERVE_CO,'YYYYMMDD')       RESERVE_CO       \n");//체크아웃 일자
		sb.append("       ,A.MEMBER_NO                            MEMBER_NO        \n");//회원번호
		sb.append("       ,A.ROOM_NO                              ROOM_NO          \n");//방번호
		sb.append("       ,TO_CHAR(A.RESERVE_DATE,'YYYYMMDD')     RESERVE_DATE     \n");//예약일
		sb.append("       ,A.RESERVE_RATE                         RESERVE_RATE     \n");//결재금액
		sb.append("       ,A.RESERVE_NOP                          RESERVE_NOP      \n");//인원수
		sb.append("       ,A.RESERVE_DELETEYN                     RESERVE_DELETEYN \n");//예약취소여부
		sb.append(" FROM   RESERVE A                                               \n");
		sb.append(" WHERE  A.RESERVE_DELETEYN                     = ?              \n");//예약취소여부
		sb.append(" AND    A.MEMBER_NO                            = ?              \n");//회원번호
		sb.append(" ORDER BY 1                                                     \n");
		return sb.toString();
	}//end of reserveLoginListQuery() method
}// end of SqlQueryMap class
