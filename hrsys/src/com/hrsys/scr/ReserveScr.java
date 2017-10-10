package com.hrsys.scr;

import java.util.ArrayList;
import java.util.Calendar;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Dimension;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import com.hrsys.dao.ReserveDAO;
import com.hrsys.vo.MemberVO;
import com.hrsys.vo.ReserveVO;
import com.hrsys.vo.RoomVO;

import javax.swing.JPanel;
import javax.swing.JFrame;

public class ReserveScr extends JFrame {//예약 화면 클래스
	private JButton jb[];
	private JLabel jl[];
	private JComboBox jcb[];
	private JTextField jtf[];
	private JPanel jp;
	private Calendar c;
	private Toolkit t;
	private Dimension d;
	static final int JB_LENGTH = 2;//버튼의갯수
	static final int JL_LENGTH = 7;//라벨의갯수
	static final int JCB_LENGTH = 4;//콤보박스의 갯수
	static final int JTF_LENGTH = 3;//텍스트필드의 갯수
	
	private ArrayList session;//세션설정
	ReserveScr rss;//자기자신 프레임


	public ArrayList getSession() {//세션가져오기
		return session;
	}//end of getSession method

	public void setSession(ArrayList session) {//세션설정
		this.session = session;
	}//end of getSession method

	public int roomReserve(ReserveVO rvo){//예약하기
		System.out.println("ReserveScr roomReserve() method in***");
		int reserveOk = 0;
		ReserveDAO rdao = null;
		rdao = new ReserveDAO();
		reserveOk = rdao.roomReserve(rvo);
		System.out.println("reserveOk>>"+reserveOk);
		return reserveOk;
	}//end of roomReserve() method
	
	public ArrayList roomType(){//방번호찾기
		System.out.println("roomType() method in***");
		ReserveDAO rdao = null;
		ArrayList aList = null;
		rdao = new ReserveDAO();
		aList = rdao.roomType();
		return aList;
	}//end of roomType() method 
	
	String getYMD(){//날짜 구하기
		c = null;
		c = Calendar.getInstance();
		int y = c.getWeekYear();
		/*public int getWeekYear() in Calendar class ->
			Returns the week year represented by this Calendar. 
			The week year is in sync with the week cycle. 
			The first day of the first week is the first day of the week year. */
		
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
	
	void setCheckDay(){//체크인 체크아웃 일자 현재일자로 설정
		jtf[0].setText(getYMD());//체크인 일자
		int nextDay = Integer.parseInt(getYMD())+1;
		String s_nextDay = String.valueOf(nextDay);
		jtf[1].setText(s_nextDay);//체크아웃 일자
	}//end of for
	
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
	
	void roomRate(ArrayList aList,JComboBox jcb, int i){//요금계산후 총액세팅
		int aListSize = aList.size();
		String ss_rate[] = (String[])aList.get(1);
		int rate = 0;
		String reserve_ci = jtf[0].getText();//체크인
		String reserve_co = jtf[1].getText();//체크아웃
		//rate = (jcb.getSelectedIndex()+1)*(Integer.parseInt(ss_rate[i]));
		String s_rate = "";
		
		/*public String substring(int beginIndex, int endIndex) in String class ->
		Returns a string that is a substring of this string. 
		The substring begins at the specified beginIndex and extends to the character at index endIndex - 1.
	    Thus the length of the substring is endIndex-beginIndex. 
		Examples: 
 			"hamburger".substring(4, 8) returns "urge"
 			"smiles".substring(1, 5) returns "mile" */
		
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
	
	ReserveScr(){//매개변수 없는 생성자
		super("예약");
	}//end of ReserveScr
	
	public ReserveScr(ArrayList session){//생성자
		t = Toolkit.getDefaultToolkit();
		d = t.getScreenSize();
		int f_width  = d.width/3;
		int f_height = d.height/5;
		rss = new ReserveScr();
		rss.setResizable(false);//프레임 사이즈고정

		System.out.println("session>>"+session);//세션값 콘솔에 출력
		rss.session = session;//세션설정
		System.out.println("roomType()>>"+roomType());
		rss.getContentPane().setLayout(null);
		rss.setBounds(f_width,f_height,700,600);
		rss.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		String jbName[] = {"예약하기","뒤로가기"};
		String jlName[] = {"체크인 일자 : ", "체크아웃 일자 : "
						  ,"방타입 : ", "인원 수 : ", "총액 : "
						  ,"ex: 20170601","ex: 20170602"};
		ArrayList aList = roomTypeCombo();
		String room[] = (String[])aList.get(0);//방타입
		String people1[] = {"1인"};
		String people2[] = {"1인","2인"};
		String people3[] = {"1인","2인","3인"};		
		String rate[] = (String[])aList.get(1);//방이용요금
		rss.getContentPane().setBackground(Color.white);//JFrame색
		jp = new JPanel();
		jp.setBackground(Color.white);//JPanel색
		
		jb = new JButton[JB_LENGTH];
		for(int i = 0;i<JB_LENGTH;i++){
			jb[i] = new JButton(jbName[i]);
			jb[i].setBackground(Color.black);//JButton색
			jb[i].setForeground(Color.white);
			jb[i].addActionListener(new MyReserveListener());//JButton에 엑션리스너추가
		}//end of for
		
		jl = new JLabel[JL_LENGTH];
		for(int i = 0;i<JL_LENGTH;i++){
			jl[i] = new JLabel(jlName[i]);
		}//end of for
		
		jcb = new JComboBox[JCB_LENGTH];
		for(int i = 0;i<JCB_LENGTH;i++){
			if(i==0){jcb[i] = new JComboBox(room);}//방타입
			if(i==1){jcb[i] = new JComboBox(people1);}//인원1명
			if(i==2){jcb[i] = new JComboBox(people2);}//인원2명
			if(i==3){jcb[i] = new JComboBox(people3);}//인원3명
			jcb[i].addActionListener(new MyReserveListener());//JComboBox에 엑션리스너추가
		}//end of for
		
		jtf = new JTextField[JTF_LENGTH];
		for(int i = 0;i<JTF_LENGTH;i++){
			jtf[i] = new JTextField(10);
		}//end of for
		
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
		jcb[1].setBounds(110, 160, 100, 20);//인원수1 콤보박스
		jcb[2].setBounds(110, 160, 100, 20);//인원수2 콤보박스
		jcb[3].setBounds(110, 160, 100, 20);//인원수3 콤보박스
		
		jb[0].setBounds(10 , 260, 100, 20);//예약하기 버튼
		jb[1].setBounds(231, 260, 102, 20);//뒤로가기 버튼
		
		jp.setBounds(200,100,330,280);//판넬
		jp.setLayout(null);
		
		jcb[1].setVisible(true);//인원수 1
		jcb[2].setVisible(false);//인원수 2
		jcb[3].setVisible(false);//인원수 3
		setCheckDay();//체크인 체크아웃일자 현재일자로 설정
		roomRate(aList,jcb[1],0);//총액세팅

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
		
		rss.getContentPane().add(jp);
		
		rss.setVisible(true);
	}//end of ReserveScr constructor
	
	private class MyReserveListener implements ActionListener{//이벤트클래스
		public void actionPerformed(ActionEvent e){
			Object obj = e.getSource();
			
			if(obj==jb[0]){//예약하기 버튼 클릭
				String today = getYMD();//오늘 일자
				System.out.println("today>>"+today);
				
				//int    reserve_no=3;//예약번호;
				String reserve_ci=jtf[0].getText();//체크인일자;
				String reserve_co=jtf[1].getText();//체크아웃일자;
				
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
				
				//Object _mvo = rss.getSession().get(0);//세션에서 MemverVO클래스 가져옴
				Object _mno = rss.getSession().get(0);//세션에서 회원번호 가져옴

				MemberVO mvo = null;
				//mvo = (MemberVO)_mvo;
				mvo = new MemberVO();
				mvo.setMember_no((String)_mno);
				//int    member_no=1;//회원번호;
				String    s_member_no=mvo.getMember_no();//회원번호;
				//int      member_no = Integer.parseInt(s_member_no);
				int i = jcb[0].getSelectedIndex();//방타입선택한인덱스
				int room_no=i+1;//방번호;
				String s_room_no = String.valueOf(room_no);
				String s_reserve_rate = jtf[2].getText();//총액
				int    reserve_rate= Integer.parseInt(s_reserve_rate);//결재금액; 
				ArrayList aList = roomTypeCombo();//방타입함수
				int    reserve_nop = 0;
				if(i == 0){//1번타입
					reserve_nop=jcb[room_no].getSelectedIndex()+1;//인원수1;
				}//end of Inner if
				
				if(i == 1){//2번타입
					reserve_nop=jcb[room_no].getSelectedIndex()+1;//인원수2;
				}//end of Inner if
				
				if(i == 2){//3번타입
					reserve_nop=jcb[room_no].getSelectedIndex()+1;//인원수3;
				}//end of Inner if
				
				ReserveVO rvo = new ReserveVO();
				//rvo.setReserve_no(reserve_no);    //예약번호;
				rvo.setReserve_ci(reserve_ci); //체크인일자;
				rvo.setReserve_co(reserve_co); //체크아웃일자;
				rvo.setMember_no(s_member_no);    //회원번호;
				
				rvo.setRoom_no(s_room_no);    //방번호;
				//pstmt.setString(); //예약일;
				rvo.setReserve_rate(reserve_rate);    //결재금액;
				rvo.setReserve_nop(reserve_nop);    //인원수;
				int reserveOk = roomReserve(rvo);
				System.out.println("reserveOk>>"+reserveOk);
				//setCheckDay();//체크인 체크아웃일자 현재일자로 설정
				if(reserveOk >= 1){// 예약등록 성공시
					JOptionPane.showMessageDialog(null, "예약성공");
					rss.removeNotify();//현재 프레임창 닫기
					new MainScr(rss.session);//메인창돌아가기
					return;
				}//end of Inner if
				JOptionPane.showMessageDialog(null, "예약 실패");
			}//end of Outer if
			
			if(obj == jcb[0]){//방타입선택
				ArrayList aList = roomTypeCombo();//방타입함수
				int i = jcb[0].getSelectedIndex();//방타입선택한인덱스
				if(i == 0){//1번타입
					jcb[1].setVisible(true);//인원수 1
					jcb[2].setVisible(false);//인원수 2
					jcb[3].setVisible(false);//인원수 3
					int index = i+1;
					roomRate(aList,jcb[index],i);//요금계산
				}
				if(i == 1){//2번타입
					jcb[1].setVisible(false);//인원수 1
					jcb[2].setVisible(true);//인원수 2
					jcb[3].setVisible(false);//인원수 3	
					int index = i+1;
					roomRate(aList,jcb[index],i);//요금계산
				}
				if(i == 2){//3번타입
					jcb[1].setVisible(false);//인원수 1
					jcb[2].setVisible(false);//인원수 2
					jcb[3].setVisible(true);//인원수 3	
					int index = i+1;
					roomRate(aList,jcb[index],i);//요금계산
				}
			}//end of if
			if(obj == jcb[1]){//인원수 선택
				ArrayList aList = roomTypeCombo();
				int i = jcb[0].getSelectedIndex();//방타입선택한인덱스
				roomRate(aList,jcb[1],i);//요금계산
			}//end of if
			if(obj == jcb[2]){//인원수 선택
				ArrayList aList = roomTypeCombo();
				int i = jcb[0].getSelectedIndex();//방타입선택한인덱스
				roomRate(aList,jcb[2],i);//요금계산
			}//end of if
			if(obj == jcb[3]){//인원수 선택
				ArrayList aList = roomTypeCombo();
				int i = jcb[0].getSelectedIndex();//방타입선택한인덱스
				roomRate(aList,jcb[3],i);//요금계산
			}//end of if
			
			if(obj == jb[1]){//뒤로가기 -- 이광하
				rss.removeNotify();
				new MainScr(rss.session);
			}//end of if
		}//end of actionPerformed() method
	}//end of MyReserveListener Inner class
	
	public static void main(String args[]){
		ArrayList _session = new ArrayList();
		//MemberVO mvo = new MemberVO();
		//String mn = "0001";
		//String s = "A";
		//String s1 = "테스터";
		//mvo.setMember_no(mn);
		//mvo.setMember_id(s);
		//mvo.setMember_name(s1);
		_session.add("0001");
		ReserveScr rss1 = new ReserveScr(_session); 
	}//end of main() method
}//end of ReserveScr
