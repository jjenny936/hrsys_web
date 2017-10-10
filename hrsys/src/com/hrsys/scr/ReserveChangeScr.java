package com.hrsys.scr;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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

public class ReserveChangeScr extends JFrame{//예약조회/변경 화면 클래스
	
	//다른 클래스에서 못쓰게 하려고 멤버변수를 모두 private 처리 했다.
	private JButton jb[];
	private JLabel jl[];
	private JComboBox jcb[];
	private JTextField jtf[];
	private JPanel jp;
	private Calendar c;
	private Toolkit t;
	private Dimension d;
	
	static final int JB_LENGTH = 3;
	static final int JL_LENGTH = 7;
	static final int JCB_LENGTH = 2;
	static final int JTF_LENGTH = 3;
	
	private ArrayList session;//세션
	private String reserve_no;//예약번호
	ReserveChangeScr rcs; //자기자신 프레임
	
	public ReserveChangeScr getRcs() {//현재 프레임 가져오기 -- 이광하
		return rcs;
	}

	public void setRcs(ReserveChangeScr rcs) {//현재 프레임 세팅 -- 이광하
		this.rcs = rcs;
	}

	public String getReserve_no() {//예약번호 가져오기 -- 이광하
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
	
	void roomRate(){//요금계산후 총액세팅
		ArrayList aList = roomTypeCombo();
		int i = jcb[0].getSelectedIndex();//방타입 콤보박스의 선택된 인덱스
		int aListSize = aList.size();
		String ss_rate[] = (String[])aList.get(1);
		int rate = 0;
		String reserve_ci = jtf[0].getText();//체크인
		String reserve_co = jtf[1].getText();//체크아웃
		String s_rate = "";
		
		String ciY = reserve_ci.substring(0,4);
		String coY = reserve_co.substring(0,4);
		
		String ciM = reserve_ci.substring(4,6);
		String coM = reserve_co.substring(4,6);
		
		String ciD = reserve_ci.substring(6);
		String coD = reserve_co.substring(6);
		
		int i_ciY = Integer.parseInt(ciY);
		int i_ciM = Integer.parseInt(ciM);
		int i_ciD = Integer.parseInt(ciD);
		
		int i_coY = Integer.parseInt(coY);
		int i_coM = Integer.parseInt(coM);
		int i_coD = Integer.parseInt(coD);
		
		System.out.println(ciY+":"+ciM+":"+ciD);
		System.out.println(coY+":"+coM+":"+coD);
		
		int ry = i_coY - i_ciY;
		int s_ry = ry*365;
		
		int rm = i_coM - i_ciM;
		int s_rm = rm*31;
		
		int rd = i_coD - i_ciD;
		
		int sum = s_ry+s_rm+rd;
		System.out.println(sum);
		rate = Integer.parseInt(ss_rate[i]) * sum;
		s_rate = String.valueOf(rate);

		jtf[2].setText(s_rate);
	}//end of roomRate method
	
	public ReserveChangeScr(){// 매개변수없는 생성자 -- 이광하
		super("예약 수정/변경");
	}//end of ReserveChangeScr() constructor
	
	public ReserveChangeScr(ArrayList session, String rno){//생성자 -- 이광하
		t = Toolkit.getDefaultToolkit();
		d = t.getScreenSize();
		int f_width  = d.width/3;
		int f_height = d.height/5;
		rcs = new ReserveChangeScr();
		rcs.setResizable(false);//프레임 사이즈고정
		System.out.println("session>>"+session);//세션값 콘솔에 출력
		rcs.session = session;//세션세팅
		MemberVO mvo = null;
		//mvo = (MemberVO)session.get(0);//세션에서 MemberVO꺼내기
		mvo = new MemberVO();
		mvo.setMember_no((String)session.get(0));
		ReserveVO rvo = null;
		//rvo = new ReserveVO();//--이광하
		ReserveChangeDAO rdao = new ReserveChangeDAO();
		//String reserve_no = rvo.getReserve_no();//예약번호
		rcs.reserve_no = rno;//예약번호
		int i_reserve_no = Integer.parseInt(rcs.reserve_no);
		System.out.println("this.reserve_no>>"+rcs.reserve_no);
		
		if(i_reserve_no < 1){ // 예약번호가 0건일때
			JOptionPane.showMessageDialog(null,"예약된 내역이 없습니다.");
			new MainScr(session);//메인부르고
			return;//닫기
		}//end of if//


		//예약내역 최근내역 1건 조회하기  -- 최재은
		ArrayList a = null;
		a = reserveSelectWork(rno); //rno는 예약번호. rcs.reserve_no = rno;
		rvo = (ReserveVO)a.get(0); 
		
		//rvo.setReserve_ci("20170707");//체크인 일자 -- 이광하
		//rvo.setReserve_co("20170708");//체크아웃 일자 -- 이광하
		//rvo.setMember_no("1");//회원번호 -- 이광하
		//rvo.setRoom_no("1");//방번호 -- 이광하
		//rvo.setReserve_date("20170707");//예약일 -- 이광하
		//rvo.setReserve_rate(100000);//결재금액 -- 이광하
		//rvo.setReserve_nop(1);//인원수 -- 이광하
		//rvo.setReserve_deleteyn("Y");//예약취소여부 -- 이광하
		
		
		String reserve_ci = rvo.getReserve_ci();//체크인 일자
		String reserve_co = rvo.getReserve_co();//체크아웃 일자
		String member_no = rvo.getMember_no();//회원번호
		String s_room_no = rvo.getRoom_no();//방번호
		int room_no = Integer.parseInt(s_room_no)-1;//방번호 인덱스
		String reserve_date = rvo.getReserve_date();//예약일
		int reserve_rate = rvo.getReserve_rate();//결재금액
		String s_reserve_rate = String.valueOf(reserve_rate);//결재금액 문자열변환
		int reserve_nop = rvo.getReserve_nop()-1;//인원수 인덱스
		String reserve_deleteyn = rvo.getReserve_deleteyn();//예약취소여부

		rcs.getContentPane().setLayout(null);
		rcs.setBounds(f_width,f_height,700,600);
		rcs.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		String jbName[] = {"예약취소", "변경", "뒤로가기"};
		String jlName[] = {"체크인 일자 : ", "체크아웃 일자 : "
						  ,"방타입 : ", "인원 수 : ", "총액 : "
						  ,"ex:20170608", "ex:20170608"};

		//String room[] = {"싱글","트윈","트리플"};
		ArrayList aList = roomTypeCombo();//방전체조회
		String room[] = (String[])aList.get(0);//방타입
		
		String people[] = {"1인","2인","3인"};
		
		rcs.getContentPane().setBackground(Color.white);//JFrame색
		jp = new JPanel();
		jp.setBackground(Color.white);//JPanel색
		
		jb = new JButton[JB_LENGTH];
		for(int i = 0;i<JB_LENGTH;i++){
			jb[i] = new JButton(jbName[i]);
			jb[i].setBackground(Color.black);//JButton색
			jb[i].setForeground(Color.white);
			jb[i].addActionListener(new MyReserveChangeListener());//JButton에 액션 리스너 추가
		}//end of for
		
		jl = new JLabel[JL_LENGTH];
		for(int i = 0;i<JL_LENGTH;i++){
			jl[i] = new JLabel(jlName[i]);
		}//end of for
		
		jcb = new JComboBox[JCB_LENGTH];
		for(int i = 0;i<JCB_LENGTH;i++){
			if(i==0){jcb[i] = new JComboBox(room);}//방타입
			if(i==1){jcb[i] = new JComboBox(people);}//인원
			jcb[i].addActionListener(new MyReserveChangeListener());//JComboBox에 엑션리스너추가
		}//end of for
		
		jtf = new JTextField[JTF_LENGTH];
		for(int i = 0;i<JTF_LENGTH;i++){
			jtf[i] = new JTextField(10);
		}//end of for
		
		jtf[0].setText(reserve_ci);//체크인 텍스트필드 값세팅
		jtf[1].setText(reserve_co);//체크아웃 텍스트필드 값세팅
		jtf[2].setText(s_reserve_rate);//총액 텍스트필드 값세팅
		
		jcb[0].setSelectedIndex(room_no);//방타입 콤보박스 값세팅
		jcb[1].setSelectedIndex(reserve_nop);//인원수 콤보박스 값세팅
		
		
		jl[0].setBounds(10,  10 , 100, 20);//체크인날짜 라벨
		jl[1].setBounds(10,  60 , 100, 20);//체크아웃날짜 라벨
		jl[2].setBounds(10,  110, 100, 20);//방타입 라벨
		jl[3].setBounds(10,  160, 100, 20);//인원수 라벨
		jl[4].setBounds(10,  210, 100, 20);//총액 라벨
		jl[5].setBounds(220,  10 , 100, 20);//체크인날짜 예시 라벨
		jl[6].setBounds(220,  60 , 100, 20);//체크아웃날짜 예시 라벨
		
		jtf[0].setBounds(110, 10 ,100,20);//체크인날짜 텍스트필드
		jtf[1].setBounds(110, 60 ,100,20);//체크아웃날짜 텍스트필드
		jtf[2].setBounds(110, 210,100,20);//총액 텍스트필드
		jtf[2].setEnabled(false);
		
		jcb[0].setBounds(110, 110, 100, 20);//방타입 콤보박스
		jcb[1].setBounds(110, 160, 100, 20);//인원수 콤보박스
		
		jb[0].setBounds(1 , 260, 100, 20);//예약취소하기 버튼
		jb[1].setBounds(116, 260, 100, 20);//변경 버튼
		jb[2].setBounds(231, 260, 102, 20);//뒤로가기 버튼
		
		jp.setBounds(200,100,330,280);//판넬
		jp.setLayout(null);
		
		for(int i = 0;i<JL_LENGTH;i++){
			jp.add(jl[i]);
		}//end of for
		
		for(int i = 0;i<JTF_LENGTH;i++){
			jp.add(jtf[i]);
		}//end of for
		
		for(int i = 0;i<JCB_LENGTH;i++){
			jp.add(jcb[i]);
		}//end of for
		
		for(int i = 0;i<JB_LENGTH;i++){
			jp.add(jb[i]);
		}//end of for
		
		rcs.getContentPane().add(jp);
		
		rcs.setVisible(true);
	}//end of ReserveChangeScr constructor
	
	public ArrayList getSession() {//세션 가져오기 -- 이광하
		return session;
	}

	public void setSession(ArrayList session) {//세션 세팅하기 -- 이광하
		this.session = session;
	}

	
	public ArrayList reserveSelectWork(String mNumber){ //조회부분 -- 최재은
									//rcs.reserve_no = rno;
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
	
	private class MyReserveChangeListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Object obj = e.getSource();
			if(obj == jcb[0]){//방타입 변경
				roomRate();//요금계산후 총액 텍스트박스에 출력
			}//end of if
			
			if(obj == jcb[1]){//인원수 변경
				roomRate();//요금계산후 총액 텍스트박스에 출력
			}//end of if
			
			if(obj == jb[1]){//예약 변경하기 -- 이광하
				String today = getYMD();//오늘 일자
				System.out.println("today>>"+today);
				
				
				ReserveVO rvo = new ReserveVO();
				
				String reserve_no = rcs.getReserve_no();//예약번호
				String reserve_ci = jtf[0].getText();//체크인 텍스트필드 값
				String reserve_co = jtf[1].getText();//체크아웃 텍스트필드 값
				int room_no = jcb[0].getSelectedIndex()+1;//방타입 콤보박스 값
				String s_room_no = String.valueOf(room_no);//방타입 문자열 변환
				String s_reserve_rate = jtf[2].getText();//총액 텍스트필드 값
				int reserve_rate = Integer.parseInt(s_reserve_rate);//총액 숫자 변환
				int reserve_nop = jcb[1].getSelectedIndex()+1;//인원수 콤보박스 값
				
				int rciLength =  reserve_ci.length();//체크인일자 글자수
				int rcoLength =  reserve_co.length();//체크아웃일자 글자수
				
				if(rciLength != 8){//체크인일자수 8이 아닐때 정지
					JOptionPane.showMessageDialog(null, "체크인일자 8자리를 입력하세요.");
					return;
				}//end of Inner if
				
				if(rcoLength != 8){//체크아웃일자수 8이 아닐때 정지
					JOptionPane.showMessageDialog(null, "체크아웃일자 8자리를 입력하세요.");
					return;
				}//end of Inner if

				int i_today = Integer.parseInt(today);//오늘 일자
				int i_reserve_ci = Integer.parseInt(reserve_ci);//체크인일자
				int i_reserve_co = Integer.parseInt(reserve_co);//체크아웃일자
								
				if(i_today > i_reserve_ci){// 오늘일자 > 
					JOptionPane.showMessageDialog(null, "체크인 일자는 금일 이후로 입력해주세요.");
					return;
				}//end of Inner if
				
				if(i_reserve_ci >= i_reserve_co){
					JOptionPane.showMessageDialog(null, "체크아웃 일자는 체크인 일자 이후로 입력해주세요.");
					return;
				}//end of Inner if
				
				rvo.setReserve_no(reserve_no);//예약번호
				rvo.setReserve_ci(reserve_ci);//체크인 일자
				rvo.setReserve_co(reserve_co);//체크아웃 일자
				rvo.setRoom_no(s_room_no);//방번호
				rvo.setReserve_rate(reserve_rate);//결재금액
				rvo.setReserve_nop(reserve_nop);//인원수
				//rvo.setReserve_deleteyn("Y");//예약취소여부
				
				int updateOk = 0;
				updateOk = reserveUpdate(rvo);
				System.out.println("updateOk>>"+updateOk);
				if(updateOk >= 1){//예약변경 성공시
					JOptionPane.showMessageDialog(null, "예약변경 성공");
					rcs.removeNotify();//현재창 닫기
					new ReserveList(rcs.session);
					return;
				}//end of Inner if
				JOptionPane.showMessageDialog(null, "예약변경 실패");
			}//end of if
			
			if(obj == jb[0]){//예약취소(삭제)하기 -- 이광하
				int deleteOk = 0;
				ReserveVO rvo = new ReserveVO();
				String reserve_no = rcs.getReserve_no();//예약번호
				rvo.setReserve_no(reserve_no);//예약번호
				deleteOk = reserveDelete(rvo);
				System.out.println("deleteOk>> "+deleteOk);
				if(deleteOk >= 1){//예약취소(삭제) 성공시
					JOptionPane.showMessageDialog(null, "예약취소 성공");
					rcs.removeNotify();//현재창 닫기
					new ReserveList(rcs.session);
					return;
				}//end of Inner if
				JOptionPane.showMessageDialog(null, "예약취소 실패");
			}//end of if
			
			if(obj == jb[2]){//뒤로가기 -- 이광하
				rcs.removeNotify();
				new ReserveList(rcs.session);
			}//end of if
			
		}//end of actionPerformed() method
		
	}//end of MyReserveChangeListener Inner class
	
	public static void main(String args[]){//메인함수
		
		ArrayList _session = new ArrayList();
		MemberVO mvo = new MemberVO();
		
		mvo.setMember_no("0001");//회원번호
		
	    _session.add("0001");
		
	    ReserveChangeScr _rcs = new ReserveChangeScr(_session,"0001");
	    //_rcs.setRcs(_rcs);
	}//end of main() method
	
}//end of ReserveChangeScr
