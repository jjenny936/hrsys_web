package com.hrsys.scr;

import java.awt.Color;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.hrsys.dao.MemberDAO;
import com.hrsys.vo.MemberVO;
import com.hrsys.scr.LoginScr_1;

public class MyPageScr extends JFrame{
	
	ArrayList session;
	JButton jb[];
	JLabel jl[];
	JTextField jtf[];
	JFrame jf;
	int i;
	
	public MyPageScr(){

		super("����������");
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.white);
		
		jb = new JButton[3];
		String a[] = {"����", "ȸ��Ż��","�ڷΰ���"};
		
		//����, ȸ��Ż��, �ڷΰ��� ��ư
		
		for(i=0; i<3; i++){
			
			jb[i] = new JButton(a[i]);
			jb[i].setSize(90, 30);
			jb[i].setLocation(300+i*110, 440);
			jb[i].setBackground(Color.black);
			jb[i].setForeground(Color.white);
			jb[i].addActionListener(new MyListener());
			add(jb[i]);			
			
		} //jb[0]����, jb[1]ȸ��Ż�� 
		
		jl = new JLabel[6];
		String b[] = {"ID", "PW", "����", "�ּ�", "��ȭ��ȣ", "Email"};
		
		//�� 6��
		for(i=0; i<6; i++){
			
			jl[i] = new JLabel(b[i]);
			jl[i].setSize(60, 30);
			jl[i].setLocation(80, 80+i*45);
			
			add(jl[i]);
		
		} //jl[0]���̵�, jl[1]��й�ȣ, jl[2]�̸�, jl[3]�ּ�, jl[4]��ȭ��ȣ, jl[5]�̸���
		
		jtf = new JTextField[6];
		
		//���� �Է� �޾ƿ� �ؽ�Ʈ�ʵ� 6��
		for(i=0; i<6; i++){
			
			jtf[i] = new JTextField(20);
			jtf[i].setSize(200, 25);
			jtf[i].setLocation(150, 85+i*45);
			if(i==0){jtf[i].setEnabled(false);}//���̵��� �ؽ�Ʈ�ʵ� --�̱���

			add(jtf[i]);
		
		} //jtf[0]���̵�, jtf[1]��й�ȣ, jtf[2]�̸�, jtf[3]�ּ�, jtf[4]��ȭ��ȣ, jtf[5]�̸���
       
		
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		
		setSize(700,600);
		setLocation(d.width/3, d.height/5);
		setVisible(true);
		setDefaultCloseOperation(super.EXIT_ON_CLOSE);
		
	}// end of MyPageScr() constructor
	
	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
		//System.out.println(e.getActionCommand());
			String jbVal = e.getActionCommand();
			if (jbVal == "����"){
								
				String pw = jtf[1].getText();
				String name = jtf[2].getText();
				String addr = jtf[3].getText();
				String hp = jtf[4].getText();
				String email =jtf[5].getText();
				String id = jtf[0].getText();
				
				int upDateCheck = updateWork(pw,name,addr,hp,email,id);
				
				System.out.println("updateCheck"+upDateCheck);
				
				if (upDateCheck != 0){
					JOptionPane.showMessageDialog(null, "ȸ������ ������ �����Ͽ����ϴ�.");
					
				}

				
			}
			if (jbVal == "ȸ��Ż��"){
				
				String dy = "N";
				String id = jtf[0].getText();
				
				int deleteCheck = deleteWork(dy, id);
				
				System.out.println("deleteCheck"+deleteCheck);
				
				if (deleteCheck != 0){
					JOptionPane.showMessageDialog(null, "ȸ��Ż�� �����Ͽ����ϴ�.");
					for(int i = 0 ; i<6;i++){
						jtf[i].setText("");
					}
					
					setVisible(false);
					new LoginScr_1();
									
				}
			
			}
			
			if (jbVal == "�ڷΰ���"){
				setVisible(false);
				new MainScr(session);
		
			}
			
						
		}
	}
	public static void main(String args[]){
		
		new MyPageScr();
		
		MyPageScr mps = null;
		mps = new MyPageScr();
			
		//mps.myPageSelect();
	
	}// end of main() method
	
	//�����Լ�
	public int updateWork(String str1, String str2, String str3,
			String str4, String str5, String str6){

		MemberDAO mDAO = null;
		mDAO = new MemberDAO();
		MemberVO mVO = null;
		mVO = new MemberVO();
				
		//�ؽ�Ʈ�ʵ�� �Է¹޾ƿ� ������ vo���� set����.
		mVO.setMember_pw(str1);
		mVO.setMember_name(str2);
		mVO.setMember_addr(str3);
		mVO.setMember_hp(str4);
		mVO.setMember_email(str5);
		mVO.setMember_id(str6);
		
		
		int nCnt = 0;
		try {
			nCnt = mDAO.memberUpdate(mVO);
			
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nCnt;
		
	}
	
	public int deleteWork(String str1, String str2){

		MemberDAO mDAO = null;
		mDAO = new MemberDAO();
		MemberVO mVO = null;
		mVO = new MemberVO();
		
		mVO.setMember_deleteyn(str1);
		mVO.setMember_id(str2);
			
		int nCnt = 0;
		try {
			nCnt = mDAO.memberDelete(mVO);
			
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nCnt;
		
	}
	
	public void myPageSelect(ArrayList session){
		MemberDAO mDAO = null;
		mDAO = new MemberDAO();
		this.session = session;
		ArrayList aList = session;
	
		/*System.out.println(aList.get(0));
		System.out.println(aList.get(1));
		System.out.println(aList.get(2));
		System.out.println(aList.get(3));
		System.out.println(aList.get(4));
		System.out.println(aList.get(5));*/
		
		jtf[0].setText((String)aList.get(1));
		jtf[1].setText((String)aList.get(2));
		jtf[2].setText((String)aList.get(3));
		jtf[3].setText((String)aList.get(4));
		jtf[4].setText((String)aList.get(5));
		jtf[5].setText((String)aList.get(6));
		
	}
	
}// end of MyPageScr class
