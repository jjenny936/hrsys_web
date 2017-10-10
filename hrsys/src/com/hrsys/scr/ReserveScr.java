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

public class ReserveScr extends JFrame {//���� ȭ�� Ŭ����
	private JButton jb[];
	private JLabel jl[];
	private JComboBox jcb[];
	private JTextField jtf[];
	private JPanel jp;
	private Calendar c;
	private Toolkit t;
	private Dimension d;
	static final int JB_LENGTH = 2;//��ư�ǰ���
	static final int JL_LENGTH = 7;//���ǰ���
	static final int JCB_LENGTH = 4;//�޺��ڽ��� ����
	static final int JTF_LENGTH = 3;//�ؽ�Ʈ�ʵ��� ����
	
	private ArrayList session;//���Ǽ���
	ReserveScr rss;//�ڱ��ڽ� ������


	public ArrayList getSession() {//���ǰ�������
		return session;
	}//end of getSession method

	public void setSession(ArrayList session) {//���Ǽ���
		this.session = session;
	}//end of getSession method

	public int roomReserve(ReserveVO rvo){//�����ϱ�
		System.out.println("ReserveScr roomReserve() method in***");
		int reserveOk = 0;
		ReserveDAO rdao = null;
		rdao = new ReserveDAO();
		reserveOk = rdao.roomReserve(rvo);
		System.out.println("reserveOk>>"+reserveOk);
		return reserveOk;
	}//end of roomReserve() method
	
	public ArrayList roomType(){//���ȣã��
		System.out.println("roomType() method in***");
		ReserveDAO rdao = null;
		ArrayList aList = null;
		rdao = new ReserveDAO();
		aList = rdao.roomType();
		return aList;
	}//end of roomType() method 
	
	String getYMD(){//��¥ ���ϱ�
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
	
	void setCheckDay(){//üũ�� üũ�ƿ� ���� �������ڷ� ����
		jtf[0].setText(getYMD());//üũ�� ����
		int nextDay = Integer.parseInt(getYMD())+1;
		String s_nextDay = String.valueOf(nextDay);
		jtf[1].setText(s_nextDay);//üũ�ƿ� ����
	}//end of for
	
	ArrayList roomTypeCombo(){//��Ÿ�� �޺�
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
	
	void roomRate(ArrayList aList,JComboBox jcb, int i){//��ݰ���� �Ѿ׼���
		int aListSize = aList.size();
		String ss_rate[] = (String[])aList.get(1);
		int rate = 0;
		String reserve_ci = jtf[0].getText();//üũ��
		String reserve_co = jtf[1].getText();//üũ�ƿ�
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
	
	ReserveScr(){//�Ű����� ���� ������
		super("����");
	}//end of ReserveScr
	
	public ReserveScr(ArrayList session){//������
		t = Toolkit.getDefaultToolkit();
		d = t.getScreenSize();
		int f_width  = d.width/3;
		int f_height = d.height/5;
		rss = new ReserveScr();
		rss.setResizable(false);//������ ���������

		System.out.println("session>>"+session);//���ǰ� �ֿܼ� ���
		rss.session = session;//���Ǽ���
		System.out.println("roomType()>>"+roomType());
		rss.getContentPane().setLayout(null);
		rss.setBounds(f_width,f_height,700,600);
		rss.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		String jbName[] = {"�����ϱ�","�ڷΰ���"};
		String jlName[] = {"üũ�� ���� : ", "üũ�ƿ� ���� : "
						  ,"��Ÿ�� : ", "�ο� �� : ", "�Ѿ� : "
						  ,"ex: 20170601","ex: 20170602"};
		ArrayList aList = roomTypeCombo();
		String room[] = (String[])aList.get(0);//��Ÿ��
		String people1[] = {"1��"};
		String people2[] = {"1��","2��"};
		String people3[] = {"1��","2��","3��"};		
		String rate[] = (String[])aList.get(1);//���̿���
		rss.getContentPane().setBackground(Color.white);//JFrame��
		jp = new JPanel();
		jp.setBackground(Color.white);//JPanel��
		
		jb = new JButton[JB_LENGTH];
		for(int i = 0;i<JB_LENGTH;i++){
			jb[i] = new JButton(jbName[i]);
			jb[i].setBackground(Color.black);//JButton��
			jb[i].setForeground(Color.white);
			jb[i].addActionListener(new MyReserveListener());//JButton�� ���Ǹ������߰�
		}//end of for
		
		jl = new JLabel[JL_LENGTH];
		for(int i = 0;i<JL_LENGTH;i++){
			jl[i] = new JLabel(jlName[i]);
		}//end of for
		
		jcb = new JComboBox[JCB_LENGTH];
		for(int i = 0;i<JCB_LENGTH;i++){
			if(i==0){jcb[i] = new JComboBox(room);}//��Ÿ��
			if(i==1){jcb[i] = new JComboBox(people1);}//�ο�1��
			if(i==2){jcb[i] = new JComboBox(people2);}//�ο�2��
			if(i==3){jcb[i] = new JComboBox(people3);}//�ο�3��
			jcb[i].addActionListener(new MyReserveListener());//JComboBox�� ���Ǹ������߰�
		}//end of for
		
		jtf = new JTextField[JTF_LENGTH];
		for(int i = 0;i<JTF_LENGTH;i++){
			jtf[i] = new JTextField(10);
		}//end of for
		
		jl[0].setBounds(10,  10 , 100, 20);//üũ�γ�¥ ��
		jl[1].setBounds(10,  60 , 100, 20);//üũ�ƿ���¥ ��
		jl[2].setBounds(10,  110, 100, 20);//��Ÿ�� ��
		jl[3].setBounds(10,  160, 100, 20);//�ο��� ��
		jl[4].setBounds(10,  210, 100, 20);//�Ѿ� ��
		jl[5].setBounds(220,  10 , 100, 20);//üũ�γ�¥ ���� ��
		jl[6].setBounds(220,  60 , 100, 20);//üũ�ƿ���¥ ���� ��
		
		jtf[0].setBounds(110, 10 ,100,20);//üũ�γ�¥ �ؽ�Ʈ�ʵ�
		jtf[1].setBounds(110, 60 ,100,20);//üũ�ƿ���¥ �ؽ�Ʈ�ʵ�
		jtf[2].setBounds(110, 210,100,20);//�Ѿ� �ؽ�Ʈ�ʵ�
		jtf[2].setEnabled(false);
		
		jcb[0].setBounds(110, 110, 100, 20);//��Ÿ�� �޺��ڽ�
		jcb[1].setBounds(110, 160, 100, 20);//�ο���1 �޺��ڽ�
		jcb[2].setBounds(110, 160, 100, 20);//�ο���2 �޺��ڽ�
		jcb[3].setBounds(110, 160, 100, 20);//�ο���3 �޺��ڽ�
		
		jb[0].setBounds(10 , 260, 100, 20);//�����ϱ� ��ư
		jb[1].setBounds(231, 260, 102, 20);//�ڷΰ��� ��ư
		
		jp.setBounds(200,100,330,280);//�ǳ�
		jp.setLayout(null);
		
		jcb[1].setVisible(true);//�ο��� 1
		jcb[2].setVisible(false);//�ο��� 2
		jcb[3].setVisible(false);//�ο��� 3
		setCheckDay();//üũ�� üũ�ƿ����� �������ڷ� ����
		roomRate(aList,jcb[1],0);//�Ѿ׼���

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
	
	private class MyReserveListener implements ActionListener{//�̺�ƮŬ����
		public void actionPerformed(ActionEvent e){
			Object obj = e.getSource();
			
			if(obj==jb[0]){//�����ϱ� ��ư Ŭ��
				String today = getYMD();//���� ����
				System.out.println("today>>"+today);
				
				//int    reserve_no=3;//�����ȣ;
				String reserve_ci=jtf[0].getText();//üũ������;
				String reserve_co=jtf[1].getText();//üũ�ƿ�����;
				
				int rciLength =  reserve_ci.length();//üũ������ ���ڼ�
				int rcoLength =  reserve_co.length();//üũ�ƿ����� ���ڼ�
				
				if(rciLength != 8){//üũ�����ڼ� 8�� �ƴҶ� ����
					JOptionPane.showMessageDialog(null, "üũ������ 8�ڸ��� �Է��ϼ���.");
					return;
				}//end of Inner if
				
				if(rcoLength != 8){//üũ�ƿ����ڼ� 8�� �ƴҶ� ����
					JOptionPane.showMessageDialog(null, "üũ�ƿ����� 8�ڸ��� �Է��ϼ���.");
					return;
				}//end of Inner if

				int i_today = Integer.parseInt(today);//���� ����
				int i_reserve_ci = Integer.parseInt(reserve_ci);//üũ������
				int i_reserve_co = Integer.parseInt(reserve_co);//üũ�ƿ�����
								
				if(i_today > i_reserve_ci){// �������� > 
					JOptionPane.showMessageDialog(null, "üũ�� ���ڴ� ���� ���ķ� �Է����ּ���.");
					return;
				}//end of Inner if
				
				if(i_reserve_ci >= i_reserve_co){
					JOptionPane.showMessageDialog(null, "üũ�ƿ� ���ڴ� üũ�� ���� ���ķ� �Է����ּ���.");
					return;
				}//end of Inner if
				
				//Object _mvo = rss.getSession().get(0);//���ǿ��� MemverVOŬ���� ������
				Object _mno = rss.getSession().get(0);//���ǿ��� ȸ����ȣ ������

				MemberVO mvo = null;
				//mvo = (MemberVO)_mvo;
				mvo = new MemberVO();
				mvo.setMember_no((String)_mno);
				//int    member_no=1;//ȸ����ȣ;
				String    s_member_no=mvo.getMember_no();//ȸ����ȣ;
				//int      member_no = Integer.parseInt(s_member_no);
				int i = jcb[0].getSelectedIndex();//��Ÿ�Լ������ε���
				int room_no=i+1;//���ȣ;
				String s_room_no = String.valueOf(room_no);
				String s_reserve_rate = jtf[2].getText();//�Ѿ�
				int    reserve_rate= Integer.parseInt(s_reserve_rate);//����ݾ�; 
				ArrayList aList = roomTypeCombo();//��Ÿ���Լ�
				int    reserve_nop = 0;
				if(i == 0){//1��Ÿ��
					reserve_nop=jcb[room_no].getSelectedIndex()+1;//�ο���1;
				}//end of Inner if
				
				if(i == 1){//2��Ÿ��
					reserve_nop=jcb[room_no].getSelectedIndex()+1;//�ο���2;
				}//end of Inner if
				
				if(i == 2){//3��Ÿ��
					reserve_nop=jcb[room_no].getSelectedIndex()+1;//�ο���3;
				}//end of Inner if
				
				ReserveVO rvo = new ReserveVO();
				//rvo.setReserve_no(reserve_no);    //�����ȣ;
				rvo.setReserve_ci(reserve_ci); //üũ������;
				rvo.setReserve_co(reserve_co); //üũ�ƿ�����;
				rvo.setMember_no(s_member_no);    //ȸ����ȣ;
				
				rvo.setRoom_no(s_room_no);    //���ȣ;
				//pstmt.setString(); //������;
				rvo.setReserve_rate(reserve_rate);    //����ݾ�;
				rvo.setReserve_nop(reserve_nop);    //�ο���;
				int reserveOk = roomReserve(rvo);
				System.out.println("reserveOk>>"+reserveOk);
				//setCheckDay();//üũ�� üũ�ƿ����� �������ڷ� ����
				if(reserveOk >= 1){// ������ ������
					JOptionPane.showMessageDialog(null, "���༺��");
					rss.removeNotify();//���� ������â �ݱ�
					new MainScr(rss.session);//����â���ư���
					return;
				}//end of Inner if
				JOptionPane.showMessageDialog(null, "���� ����");
			}//end of Outer if
			
			if(obj == jcb[0]){//��Ÿ�Լ���
				ArrayList aList = roomTypeCombo();//��Ÿ���Լ�
				int i = jcb[0].getSelectedIndex();//��Ÿ�Լ������ε���
				if(i == 0){//1��Ÿ��
					jcb[1].setVisible(true);//�ο��� 1
					jcb[2].setVisible(false);//�ο��� 2
					jcb[3].setVisible(false);//�ο��� 3
					int index = i+1;
					roomRate(aList,jcb[index],i);//��ݰ��
				}
				if(i == 1){//2��Ÿ��
					jcb[1].setVisible(false);//�ο��� 1
					jcb[2].setVisible(true);//�ο��� 2
					jcb[3].setVisible(false);//�ο��� 3	
					int index = i+1;
					roomRate(aList,jcb[index],i);//��ݰ��
				}
				if(i == 2){//3��Ÿ��
					jcb[1].setVisible(false);//�ο��� 1
					jcb[2].setVisible(false);//�ο��� 2
					jcb[3].setVisible(true);//�ο��� 3	
					int index = i+1;
					roomRate(aList,jcb[index],i);//��ݰ��
				}
			}//end of if
			if(obj == jcb[1]){//�ο��� ����
				ArrayList aList = roomTypeCombo();
				int i = jcb[0].getSelectedIndex();//��Ÿ�Լ������ε���
				roomRate(aList,jcb[1],i);//��ݰ��
			}//end of if
			if(obj == jcb[2]){//�ο��� ����
				ArrayList aList = roomTypeCombo();
				int i = jcb[0].getSelectedIndex();//��Ÿ�Լ������ε���
				roomRate(aList,jcb[2],i);//��ݰ��
			}//end of if
			if(obj == jcb[3]){//�ο��� ����
				ArrayList aList = roomTypeCombo();
				int i = jcb[0].getSelectedIndex();//��Ÿ�Լ������ε���
				roomRate(aList,jcb[3],i);//��ݰ��
			}//end of if
			
			if(obj == jb[1]){//�ڷΰ��� -- �̱���
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
		//String s1 = "�׽���";
		//mvo.setMember_no(mn);
		//mvo.setMember_id(s);
		//mvo.setMember_name(s1);
		_session.add("0001");
		ReserveScr rss1 = new ReserveScr(_session); 
	}//end of main() method
}//end of ReserveScr
