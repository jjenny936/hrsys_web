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

public class ReserveChangeScr extends JFrame{//������ȸ/���� ȭ�� Ŭ����
	
	//�ٸ� Ŭ�������� ������ �Ϸ��� ��������� ��� private ó�� �ߴ�.
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
	
	private ArrayList session;//����
	private String reserve_no;//�����ȣ
	ReserveChangeScr rcs; //�ڱ��ڽ� ������
	
	public ReserveChangeScr getRcs() {//���� ������ �������� -- �̱���
		return rcs;
	}

	public void setRcs(ReserveChangeScr rcs) {//���� ������ ���� -- �̱���
		this.rcs = rcs;
	}

	public String getReserve_no() {//�����ȣ �������� -- �̱���
		return reserve_no;
	}

	public void setReserve_no(String reserve_no) {//�����ȣ ���� -- �̱���
		this.reserve_no = reserve_no;
	}

	String getYMD(){//��¥ ���ϱ�
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
	

	public ArrayList roomType(){//���ȣã��
		System.out.println("roomType() method in***");
		ReserveDAO rdao = null;
		ArrayList aList = null;
		rdao = new ReserveDAO();
		aList = rdao.roomType();
		return aList;
	}//end of roomType() method

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
	
	void roomRate(){//��ݰ���� �Ѿ׼���
		ArrayList aList = roomTypeCombo();
		int i = jcb[0].getSelectedIndex();//��Ÿ�� �޺��ڽ��� ���õ� �ε���
		int aListSize = aList.size();
		String ss_rate[] = (String[])aList.get(1);
		int rate = 0;
		String reserve_ci = jtf[0].getText();//üũ��
		String reserve_co = jtf[1].getText();//üũ�ƿ�
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
	
	public ReserveChangeScr(){// �Ű��������� ������ -- �̱���
		super("���� ����/����");
	}//end of ReserveChangeScr() constructor
	
	public ReserveChangeScr(ArrayList session, String rno){//������ -- �̱���
		t = Toolkit.getDefaultToolkit();
		d = t.getScreenSize();
		int f_width  = d.width/3;
		int f_height = d.height/5;
		rcs = new ReserveChangeScr();
		rcs.setResizable(false);//������ ���������
		System.out.println("session>>"+session);//���ǰ� �ֿܼ� ���
		rcs.session = session;//���Ǽ���
		MemberVO mvo = null;
		//mvo = (MemberVO)session.get(0);//���ǿ��� MemberVO������
		mvo = new MemberVO();
		mvo.setMember_no((String)session.get(0));
		ReserveVO rvo = null;
		//rvo = new ReserveVO();//--�̱���
		ReserveChangeDAO rdao = new ReserveChangeDAO();
		//String reserve_no = rvo.getReserve_no();//�����ȣ
		rcs.reserve_no = rno;//�����ȣ
		int i_reserve_no = Integer.parseInt(rcs.reserve_no);
		System.out.println("this.reserve_no>>"+rcs.reserve_no);
		
		if(i_reserve_no < 1){ // �����ȣ�� 0���϶�
			JOptionPane.showMessageDialog(null,"����� ������ �����ϴ�.");
			new MainScr(session);//���κθ���
			return;//�ݱ�
		}//end of if//


		//���೻�� �ֱٳ��� 1�� ��ȸ�ϱ�  -- ������
		ArrayList a = null;
		a = reserveSelectWork(rno); //rno�� �����ȣ. rcs.reserve_no = rno;
		rvo = (ReserveVO)a.get(0); 
		
		//rvo.setReserve_ci("20170707");//üũ�� ���� -- �̱���
		//rvo.setReserve_co("20170708");//üũ�ƿ� ���� -- �̱���
		//rvo.setMember_no("1");//ȸ����ȣ -- �̱���
		//rvo.setRoom_no("1");//���ȣ -- �̱���
		//rvo.setReserve_date("20170707");//������ -- �̱���
		//rvo.setReserve_rate(100000);//����ݾ� -- �̱���
		//rvo.setReserve_nop(1);//�ο��� -- �̱���
		//rvo.setReserve_deleteyn("Y");//������ҿ��� -- �̱���
		
		
		String reserve_ci = rvo.getReserve_ci();//üũ�� ����
		String reserve_co = rvo.getReserve_co();//üũ�ƿ� ����
		String member_no = rvo.getMember_no();//ȸ����ȣ
		String s_room_no = rvo.getRoom_no();//���ȣ
		int room_no = Integer.parseInt(s_room_no)-1;//���ȣ �ε���
		String reserve_date = rvo.getReserve_date();//������
		int reserve_rate = rvo.getReserve_rate();//����ݾ�
		String s_reserve_rate = String.valueOf(reserve_rate);//����ݾ� ���ڿ���ȯ
		int reserve_nop = rvo.getReserve_nop()-1;//�ο��� �ε���
		String reserve_deleteyn = rvo.getReserve_deleteyn();//������ҿ���

		rcs.getContentPane().setLayout(null);
		rcs.setBounds(f_width,f_height,700,600);
		rcs.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		String jbName[] = {"�������", "����", "�ڷΰ���"};
		String jlName[] = {"üũ�� ���� : ", "üũ�ƿ� ���� : "
						  ,"��Ÿ�� : ", "�ο� �� : ", "�Ѿ� : "
						  ,"ex:20170608", "ex:20170608"};

		//String room[] = {"�̱�","Ʈ��","Ʈ����"};
		ArrayList aList = roomTypeCombo();//����ü��ȸ
		String room[] = (String[])aList.get(0);//��Ÿ��
		
		String people[] = {"1��","2��","3��"};
		
		rcs.getContentPane().setBackground(Color.white);//JFrame��
		jp = new JPanel();
		jp.setBackground(Color.white);//JPanel��
		
		jb = new JButton[JB_LENGTH];
		for(int i = 0;i<JB_LENGTH;i++){
			jb[i] = new JButton(jbName[i]);
			jb[i].setBackground(Color.black);//JButton��
			jb[i].setForeground(Color.white);
			jb[i].addActionListener(new MyReserveChangeListener());//JButton�� �׼� ������ �߰�
		}//end of for
		
		jl = new JLabel[JL_LENGTH];
		for(int i = 0;i<JL_LENGTH;i++){
			jl[i] = new JLabel(jlName[i]);
		}//end of for
		
		jcb = new JComboBox[JCB_LENGTH];
		for(int i = 0;i<JCB_LENGTH;i++){
			if(i==0){jcb[i] = new JComboBox(room);}//��Ÿ��
			if(i==1){jcb[i] = new JComboBox(people);}//�ο�
			jcb[i].addActionListener(new MyReserveChangeListener());//JComboBox�� ���Ǹ������߰�
		}//end of for
		
		jtf = new JTextField[JTF_LENGTH];
		for(int i = 0;i<JTF_LENGTH;i++){
			jtf[i] = new JTextField(10);
		}//end of for
		
		jtf[0].setText(reserve_ci);//üũ�� �ؽ�Ʈ�ʵ� ������
		jtf[1].setText(reserve_co);//üũ�ƿ� �ؽ�Ʈ�ʵ� ������
		jtf[2].setText(s_reserve_rate);//�Ѿ� �ؽ�Ʈ�ʵ� ������
		
		jcb[0].setSelectedIndex(room_no);//��Ÿ�� �޺��ڽ� ������
		jcb[1].setSelectedIndex(reserve_nop);//�ο��� �޺��ڽ� ������
		
		
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
		jcb[1].setBounds(110, 160, 100, 20);//�ο��� �޺��ڽ�
		
		jb[0].setBounds(1 , 260, 100, 20);//��������ϱ� ��ư
		jb[1].setBounds(116, 260, 100, 20);//���� ��ư
		jb[2].setBounds(231, 260, 102, 20);//�ڷΰ��� ��ư
		
		jp.setBounds(200,100,330,280);//�ǳ�
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
	
	public ArrayList getSession() {//���� �������� -- �̱���
		return session;
	}

	public void setSession(ArrayList session) {//���� �����ϱ� -- �̱���
		this.session = session;
	}

	
	public ArrayList reserveSelectWork(String mNumber){ //��ȸ�κ� -- ������
									//rcs.reserve_no = rno;
		ReserveChangeDAO rcd = null;
		rcd = new ReserveChangeDAO();

		ReserveVO rvo = null;
		rvo = new ReserveVO();
				
		  //String mNumber = mvo.getMember_no(); -> session���� �޾ƿ� MemberVO�� ȸ����ȣ     
		
		rvo.setMember_no(mNumber);
		System.out.println("rvo.getMember_no() >> " + rvo.getMember_no());
		
		ArrayList a = rcd.reserveSelect(mNumber);
		System.out.println("a in reserveSelectWork() method >> " + a);
				
		return a;
	
	}// end of reserveSelectWork() method
	
	public int reserveUpdate(ReserveVO rvo){ //���� �����ϱ� -- �̱���
		System.out.println("ReserveChangeScr reserveUpdate() method in ***");
		ReserveChangeDAO rcdao = null;
		rcdao = new ReserveChangeDAO();
		int updateOk = 0;
		updateOk = rcdao.reserveUpdate(rvo);
		return updateOk;
	}// end of reserveUpdate() method
	
	public int reserveDelete(ReserveVO rvo){ //���� ���(����)�ϱ� -- �̱���
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
			if(obj == jcb[0]){//��Ÿ�� ����
				roomRate();//��ݰ���� �Ѿ� �ؽ�Ʈ�ڽ��� ���
			}//end of if
			
			if(obj == jcb[1]){//�ο��� ����
				roomRate();//��ݰ���� �Ѿ� �ؽ�Ʈ�ڽ��� ���
			}//end of if
			
			if(obj == jb[1]){//���� �����ϱ� -- �̱���
				String today = getYMD();//���� ����
				System.out.println("today>>"+today);
				
				
				ReserveVO rvo = new ReserveVO();
				
				String reserve_no = rcs.getReserve_no();//�����ȣ
				String reserve_ci = jtf[0].getText();//üũ�� �ؽ�Ʈ�ʵ� ��
				String reserve_co = jtf[1].getText();//üũ�ƿ� �ؽ�Ʈ�ʵ� ��
				int room_no = jcb[0].getSelectedIndex()+1;//��Ÿ�� �޺��ڽ� ��
				String s_room_no = String.valueOf(room_no);//��Ÿ�� ���ڿ� ��ȯ
				String s_reserve_rate = jtf[2].getText();//�Ѿ� �ؽ�Ʈ�ʵ� ��
				int reserve_rate = Integer.parseInt(s_reserve_rate);//�Ѿ� ���� ��ȯ
				int reserve_nop = jcb[1].getSelectedIndex()+1;//�ο��� �޺��ڽ� ��
				
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
				
				rvo.setReserve_no(reserve_no);//�����ȣ
				rvo.setReserve_ci(reserve_ci);//üũ�� ����
				rvo.setReserve_co(reserve_co);//üũ�ƿ� ����
				rvo.setRoom_no(s_room_no);//���ȣ
				rvo.setReserve_rate(reserve_rate);//����ݾ�
				rvo.setReserve_nop(reserve_nop);//�ο���
				//rvo.setReserve_deleteyn("Y");//������ҿ���
				
				int updateOk = 0;
				updateOk = reserveUpdate(rvo);
				System.out.println("updateOk>>"+updateOk);
				if(updateOk >= 1){//���ຯ�� ������
					JOptionPane.showMessageDialog(null, "���ຯ�� ����");
					rcs.removeNotify();//����â �ݱ�
					new ReserveList(rcs.session);
					return;
				}//end of Inner if
				JOptionPane.showMessageDialog(null, "���ຯ�� ����");
			}//end of if
			
			if(obj == jb[0]){//�������(����)�ϱ� -- �̱���
				int deleteOk = 0;
				ReserveVO rvo = new ReserveVO();
				String reserve_no = rcs.getReserve_no();//�����ȣ
				rvo.setReserve_no(reserve_no);//�����ȣ
				deleteOk = reserveDelete(rvo);
				System.out.println("deleteOk>> "+deleteOk);
				if(deleteOk >= 1){//�������(����) ������
					JOptionPane.showMessageDialog(null, "������� ����");
					rcs.removeNotify();//����â �ݱ�
					new ReserveList(rcs.session);
					return;
				}//end of Inner if
				JOptionPane.showMessageDialog(null, "������� ����");
			}//end of if
			
			if(obj == jb[2]){//�ڷΰ��� -- �̱���
				rcs.removeNotify();
				new ReserveList(rcs.session);
			}//end of if
			
		}//end of actionPerformed() method
		
	}//end of MyReserveChangeListener Inner class
	
	public static void main(String args[]){//�����Լ�
		
		ArrayList _session = new ArrayList();
		MemberVO mvo = new MemberVO();
		
		mvo.setMember_no("0001");//ȸ����ȣ
		
	    _session.add("0001");
		
	    ReserveChangeScr _rcs = new ReserveChangeScr(_session,"0001");
	    //_rcs.setRcs(_rcs);
	}//end of main() method
	
}//end of ReserveChangeScr
