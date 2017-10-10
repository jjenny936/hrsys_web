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

public class ReserveList extends JFrame{//���೻����ȸ ȭ�� Ŭ����
	private JButton jb[];
	private JPanel jp;
	private Calendar c;
	private Toolkit t;
	private Dimension d;
	
	static final int JB_LENGTH = 2;//��ư�ǰ���

	
	private ArrayList session;//����
	private String reserve_no;//�����ȣ
	ReserveList rcs; //�ڱ��ڽ� ������
	
	JScrollPane jsp;//���̺����� ��ũ��
	JTable jtb;//���̺�
	DefaultTableModel dtm;//���̺�����
	String rnos[];//�����ȣ �񱳰�
	
	public ReserveList getRcs() {//���� ������ �������� -- �̱���
		return rcs;
	}

	public void setRcs(ReserveList rcs) {// ���� ������ ���� -- �̱���
		this.rcs = rcs;
	}

	public String getReserve_no() {//�����ȣ�������� -- �̱���
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
	
	public ReserveList(){// �Ű��������� ������ -- �̱���
		super("���� ����");
	}//end of ReserveChangeScr() constructor
	
	public ReserveList(ArrayList session){//������ -- �̱���
		t = Toolkit.getDefaultToolkit();
		d = t.getScreenSize();
		int f_width  = d.width/3;
		int f_height = d.height/5;
		rcs = new ReserveList();
		rcs.setResizable(false);//������ ���������
		rcs.session = session;//���Ǽ���
		MemberVO mvo = null;
		//mvo = (MemberVO)session.get(0);//���ǿ��� MemberVO������
		mvo = new MemberVO();
		mvo.setMember_no((String)session.get(0));
		ReserveVO rvo = null;
		//rvo = new ReserveVO();//--�̱���
		ReserveChangeDAO rdao = new ReserveChangeDAO();
		//String reserve_no = rvo.getReserve_no();//�����ȣ
		rcs.reserve_no = rdao.reserveNo(mvo);//�����ȣ
		int i_reserve_no = Integer.parseInt(rcs.reserve_no);
		System.out.println("this.reserve_no>>"+rcs.reserve_no);
		
		if(i_reserve_no < 1){ // �����ȣ�� 0���϶�
			JOptionPane.showMessageDialog(null,"����� ������ �����ϴ�.");
			new MainScr(session);//���κθ���
			return;//�ݱ�
		}//end of if//


		
		rcs.getContentPane().setLayout(null);
		rcs.setBounds(f_width,f_height,700,600);
		rcs.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		rcs.getContentPane().setBackground(Color.white);//JFrame��
		
		String jbName[] = {"������ȸ","�ڷΰ���"};

		jb = new JButton[JB_LENGTH];
		for(int i = 0;i<JB_LENGTH;i++){
			jb[i] = new JButton(jbName[i]);
			jb[i].setBackground(Color.black);//JButton��
			jb[i].setForeground(Color.white);
			jb[i].addActionListener(new MyReserveChangeListener());//JButton�� ���Ǹ������߰�
		}//end of for
		
		
		jp = new JPanel();//�ǳ�
		jp.setBackground(Color.white);//JPanel��
		
		//jtb = new JTable(rowdata,colname);//���̺�
		dtm = reserveLoginList(mvo);//�����͸�
		int rowCnt = dtm.getRowCount();//row�������ϱ�
		rnos = new String[rowCnt];
		for(int i = 0;i<rowCnt;i++){
			rnos[i] = (String)dtm.getValueAt(i, 0);
		}//end of for
		
		jtb = new JTable(dtm);//���̺�
		jtb.setBackground(Color.white);
		jtb.getModel().addTableModelListener(new MyReserveChangeListener());
		
		jsp = new JScrollPane(jtb);//��ũ��
		jp.setBackground(Color.white);//JScrollBar��
		
		
		jsp.setBounds(0,0,600,210);//��ũ��
		jb[0].setBounds(0 , 260, 100, 20);//�����ϱ� ��ư
		jb[1].setBounds(120, 260, 102, 20);//�ڷΰ��� ��ư
		
		jp.setBounds(50,100,600,280);//�ǳ�
		jp.setLayout(null);
		
		for(int i = 0;i<JB_LENGTH;i++){
			jp.add(jb[i]);
		}//end of for
		
		jp.add(jsp);

		rcs.getContentPane().add(jp);//��ũ�� ���
		
		rcs.setVisible(true);
	}//end of ReserveChangeScr constructor
	
	public ArrayList getSession() {//���� �������� -- �̱���
		return session;
	}

	public void setSession(ArrayList session) {//���� �����ϱ� -- �̱���
		this.session = session;
	}

	
	public ArrayList reserveSelectWork(String mNumber){ //��ȸ�κ� -- ������
										
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
	
	public DefaultTableModel reserveLoginList(MemberVO mvo){//�α��� ȸ���� ���� ����Ʈ
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
			if(obj == jb[0]){//������ȸ
				String colName = "";
				int row = 0;
				int colIndex = 0;
				colName = jtb.getColumnName(colIndex);
				System.out.println("colName>>"+colName);
				if(!"�����ȣ".equals(colName)){
					JOptionPane.showMessageDialog(null,	"ù��° �÷��� \"�����ȣ\"�� �ƴմϴ�.");
					return;
				}//end of Inner if
				row = jtb.getSelectedRow();
				System.out.println(row);
				
				if(row == -1){//row �̼���
					JOptionPane.showMessageDialog(null, "������ ������ �����ϼ���");
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

		
		public void tableChanged(TableModelEvent e) {//���̺� ����ɽ�
			int row = 0;
			int rowSize = dtm.getRowCount();
			row = jtb.getSelectedRow();
			System.out.println(rowSize);
			System.out.println(row);
			String col = (String)dtm.getValueAt(row, 0);
			System.out.println(col);
			System.out.print(rnos[row]);
			if(!col.equals(rnos[row])){
				JOptionPane.showMessageDialog(null, "\"�����ȣ\"�� �����Ҽ� �����ϴ�.");
				rcs.removeNotify();
				new ReserveList(rcs.session);
				return;
			}//end of if
		}//end of tableChanged method
	}//end of MyReserveChangeListener Inner class
	
	public static void main(String args[]){//�����Լ�
		
		ArrayList _session = new ArrayList();
		MemberVO mvo = new MemberVO();
		
		//mvo.setMember_no("0001");//ȸ����ȣ
		
	    _session.add("0001");
		
	    ReserveList _rcs = new ReserveList(_session);
	    
	}//end of main() method
	
}//end of ReserveList class
