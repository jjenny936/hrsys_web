package com.hrsys.scr;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.event.TableModelListener;
import javax.swing.event.TableModelEvent;

import javax.swing.table.DefaultTableModel;

import com.hrsys.vo.MemberVO;
import com.hrsys.vo.ReserveVO;
import com.hrsys.vo.RoomVO;
import com.hrsys.dao.ReserveChangeDAO;
import com.hrsys.dao.ReserveDAO;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Calendar;

public class ReserveList extends JFrame{//예약내역조회 화면 클래스
	private JButton jb[];
	private JPanel jp;
	private Calendar c;
	private Toolkit t;
	private Dimension d;
	
	static final int JB_LENGTH = 2;//버튼의갯수

	
	private ArrayList session;//세션
	private String reserve_no;//예약번호
	ReserveList rcs; //자기자신 프레임
	
	JScrollPane jsp;//테이블보여줄 스크롤
	JTable jtb;//테이블
	DefaultTableModel dtm;//테이블데이터
	String rnos[];//예약번호 비교값
	
	public ReserveList getRcs() {//현재 프레임 가져오기 -- 이광하
		return rcs;
	}

	public void setRcs(ReserveList rcs) {// 현재 프레임 세팅 -- 이광하
		this.rcs = rcs;
	}

	public String getReserve_no() {//예약번호가져오기 -- 이광하
		return reserve_no;
	}

	public void setReserve_no(String reserve_no) {//예약번호 세팅 -- 이광하
		this.reserve_no = reserve_no;
	}

	String getYMD(){//날짜 구하기
		c = null;
		c = Calendar.getInstance();
		int y = c.getWeekYear();
		int m = c.get(Calendar.MONTH)+1;
		int d = c.get(Calendar.DAY_OF_MONTH);
		String s_y = String.valueOf(y); 
		String s_m = String.valueOf(m);
		String s_d = String.valueOf(d);
		if(m<10){s_m="0"+s_m;}
		if(d<10){s_d="0"+s_d;}
		String ymd = s_y+s_m+s_d;
		return ymd;
	}//end of getYMD() method
	
	public ArrayList roomType(){//방번호찾기
		System.out.println("roomType() method in***");
		ReserveDAO rdao = null;
		ArrayList aList = null;
		rdao = new ReserveDAO();
		aList = rdao.roomType();
		return aList;
	}//end of roomType() method

	ArrayList roomTypeCombo(){//방타입 콤보
		ArrayList aList = roomType();
		int aListSize = aList.size();
		String roomName[] = null;
		
		String roomRate[] = null;
		roomName = new String[aListSize];
		roomRate = new String[aListSize];
		
		for(int i = 0;i<aListSize;i++){
			RoomVO rvo = null;
			rvo = (RoomVO)aList.get(i);
			roomName[i] = rvo.getRoom_type(); 
			roomRate[i] = String.valueOf(rvo.getRoom_rate()); 
		}//end of for
		aList = null;
		aList = new ArrayList();
		aList.add(roomName);
		aList.add(roomRate);
		return aList;
	}//end of roomTypeCombo() method
	
	public ReserveList(){// 매개변수없는 생성자 -- 이광하
		super("예약 내역");
	}//end of ReserveChangeScr() constructor
	
	public ReserveList(ArrayList session){//생성자 -- 이광하
		t = Toolkit.getDefaultToolkit();
		d = t.getScreenSize();
		int f_width  = d.width/3;
		int f_height = d.height/5;
		rcs = new ReserveList();
		rcs.setResizable(false);//프레임 사이즈고정
		rcs.session = session;//세션세팅
		MemberVO mvo = null;
		//mvo = (MemberVO)session.get(0);//세션에서 MemberVO꺼내기
		mvo = new MemberVO();
		mvo.setMember_no((String)session.get(0));
		ReserveVO rvo = null;
		//rvo = new ReserveVO();//--이광하
		ReserveChangeDAO rdao = new ReserveChangeDAO();
		//String reserve_no = rvo.getReserve_no();//예약번호
		rcs.reserve_no = rdao.reserveNo(mvo);//예약번호
		int i_reserve_no = Integer.parseInt(rcs.reserve_no);
		System.out.println("this.reserve_no>>"+rcs.reserve_no);
		
		if(i_reserve_no < 1){ // 예약번호가 0건일때
			JOptionPane.showMessageDialog(null,"예약된 내역이 없습니다.");
			new MainScr(session);//메인부르고
			return;//닫기
		}//end of if//


		
		rcs.getContentPane().setLayout(null);
		rcs.setBounds(f_width,f_height,700,600);
		rcs.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		rcs.getContentPane().setBackground(Color.white);//JFrame색
		
		String jbName[] = {"예약조회","뒤로가기"};

		jb = new JButton[JB_LENGTH];
		for(int i = 0;i<JB_LENGTH;i++){
			jb[i] = new JButton(jbName[i]);
			jb[i].setBackground(Color.black);//JButton색
			jb[i].setForeground(Color.white);
			jb[i].addActionListener(new MyReserveChangeListener());//JButton에 엑션리스너추가
		}//end of for
		
		
		jp = new JPanel();//판넬
		jp.setBackground(Color.white);//JPanel색
		
		//jtb = new JTable(rowdata,colname);//테이블
		dtm = reserveLoginList(mvo);//데이터모델
		int rowCnt = dtm.getRowCount();//row갯수구하기
		rnos = new String[rowCnt];
		for(int i = 0;i<rowCnt;i++){
			rnos[i] = (String)dtm.getValueAt(i, 0);
		}//end of for
		
		jtb = new JTable(dtm);//테이블
		jtb.setBackground(Color.white);
		jtb.getModel().addTableModelListener(new MyReserveChangeListener());
		
		jsp = new JScrollPane(jtb);//스크롤
		jp.setBackground(Color.white);//JScrollBar색
		
		
		jsp.setBounds(0,0,600,210);//스크롤
		jb[0].setBounds(0 , 260, 100, 20);//예약하기 버튼
		jb[1].setBounds(120, 260, 102, 20);//뒤로가기 버튼
		
		jp.setBounds(50,100,600,280);//판넬
		jp.setLayout(null);
		
		for(int i = 0;i<JB_LENGTH;i++){
			jp.add(jb[i]);
		}//end of for
		
		jp.add(jsp);

		rcs.getContentPane().add(jp);//스크롤 담기
		
		rcs.setVisible(true);
	}//end of ReserveChangeScr constructor
	
	public ArrayList getSession() {//세션 가져오기 -- 이광하
		return session;
	}

	public void setSession(ArrayList session) {//세션 세팅하기 -- 이광하
		this.session = session;
	}

	
	public ArrayList reserveSelectWork(String mNumber){ //조회부분 -- 최재은
										
		ReserveChangeDAO rcd = null;
		rcd = new ReserveChangeDAO();

		ReserveVO rvo = null;
		rvo = new ReserveVO();
				
		  //String mNumber = mvo.getMember_no(); -> session에서 받아온 MemberVO의 회원번호     
		
		rvo.setMember_no(mNumber);
		System.out.println("rvo.getMember_no() >> " + rvo.getMember_no());
		
		ArrayList a = rcd.reserveSelect(mNumber);
		System.out.println("a in reserveSelectWork() method >> " + a);
				
		return a;
	
	}// end of reserveSelectWork() method
	
	public int reserveUpdate(ReserveVO rvo){ //예약 변경하기 -- 이광하
		System.out.println("ReserveChangeScr reserveUpdate() method in ***");
		ReserveChangeDAO rcdao = null;
		rcdao = new ReserveChangeDAO();
		int updateOk = 0;
		updateOk = rcdao.reserveUpdate(rvo);
		return updateOk;
	}// end of reserveUpdate() method
	
	public int reserveDelete(ReserveVO rvo){ //예약 취소(삭제)하기 -- 이광하
		System.out.println("ReserveChangeScr reserveDelete() method in ***");
		int deleteOk = 0;
		ReserveChangeDAO rcdao = null;
		rcdao = new ReserveChangeDAO();
		deleteOk = rcdao.reserveDelete(rvo);
		return deleteOk;
	}// end of reserveDelete() method
	
	public DefaultTableModel reserveLoginList(MemberVO mvo){//로그인 회원의 예약 리스트
		System.out.println("ReserveList reserveLoginList() method in***");
		DefaultTableModel aList = null;
		ReserveChangeDAO rcdao = null;
		rcdao = new ReserveChangeDAO();
		aList = rcdao.reserveLoginList(mvo);
		return aList;
	}//end of reserveLoginList() method
	
	private class MyReserveChangeListener implements ActionListener,TableModelListener{
		public void actionPerformed(ActionEvent e){
			Object obj = e.getSource();
			if(obj == jb[0]){//예약조회
				String colName = "";
				int row = 0;
				int colIndex = 0;
				colName = jtb.getColumnName(colIndex);
				System.out.println("colName>>"+colName);
				if(!"예약번호".equals(colName)){
					JOptionPane.showMessageDialog(null,	"첫번째 컬럼이 \"예약번호\"가 아닙니다.");
					return;
				}//end of Inner if
				row = jtb.getSelectedRow();
				System.out.println(row);
				
				if(row == -1){//row 미선택
					JOptionPane.showMessageDialog(null, "변경할 예약을 선택하세요");
					return;
				}//end of Inner if
				
				String rno = (String)jtb.getValueAt(row,colIndex);
				rcs.removeNotify();
				new ReserveChangeScr(rcs.session, rno);
			}//end of Outer if 
			
			if(obj == jb[1]){
				rcs.removeNotify();
				new MainScr(rcs.session);
			}//end of if
		}//end of actionPerformed() method

		
		public void tableChanged(TableModelEvent e) {//테이블 변경될시
			int row = 0;
			int rowSize = dtm.getRowCount();
			row = jtb.getSelectedRow();
			System.out.println(rowSize);
			System.out.println(row);
			String col = (String)dtm.getValueAt(row, 0);
			System.out.println(col);
			System.out.print(rnos[row]);
			if(!col.equals(rnos[row])){
				JOptionPane.showMessageDialog(null, "\"예약번호\"는 변경할수 없습니다.");
				rcs.removeNotify();
				new ReserveList(rcs.session);
				return;
			}//end of if
		}//end of tableChanged method
	}//end of MyReserveChangeListener Inner class
	
	public static void main(String args[]){//메인함수
		
		ArrayList _session = new ArrayList();
		MemberVO mvo = new MemberVO();
		
		//mvo.setMember_no("0001");//회원번호
		
	    _session.add("0001");
		
	    ReserveList _rcs = new ReserveList(_session);
	    
	}//end of main() method
	
}//end of ReserveList class
