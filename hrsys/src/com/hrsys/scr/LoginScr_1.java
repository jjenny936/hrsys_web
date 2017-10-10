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
import javax.swing.JPasswordField;

import com.hrsys.dao.LoginDao;
import com.hrsys.vo.MemberVO;

import com.hrsys.scr.MainScr;

public class LoginScr_1 extends JFrame{

public ArrayList session;

	JButton jb[];
	JLabel jl[];	
	JTextField jtf;
	JPasswordField jpf;
	
		public LoginScr_1(){		

		super("환영합니다!");
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.white);
		
		String a[] = {"LOGIN", "JOIN"}; 
		jb = new JButton[2];
		
		//로그인, 회원가입 버튼.
		for(int i = 0; i<2; i++){
			
			jb[i] = new JButton(a[i]);	
			jb[i].setLocation(230+i*130, 330);
			jb[i].setSize(100, 40);
			jb[i].setBackground(Color.black);
			jb[i].setForeground(Color.white);
			
			add(jb[i]);
			jb[i].addActionListener(new MyListener());
			
		} //jb[0]로그인, jb[1]회원가입 
		
		String b[] = {"ID", "PW"}; 
		jl = new JLabel[2];
		
		//ID, PW 라벨.
		for(int j = 0; j<2; j++){
			
			jl[j] = new JLabel(b[j]);	
			jl[j].setLocation(250, 190+j*30);
			jl[j].setSize(70, 90);
			add(jl[j]);
			
		} //jl[0]아이디, jl[1]비밀번호 
		
		jtf = new JTextField();
		jpf = new JPasswordField();
		
		//ID와 PW를 입력 받을 텍스트필드.
		
		jtf.setLocation(300, 225);
		jtf.setSize(150, 25);
		jpf.setLocation(300, 255);
		jpf.setSize(150, 25);
		
		add(jtf);
		add(jpf);
		
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		
		setSize(700,600);
		setLocation(d.width/3, d.height/5);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	
		
	}// end of LoginScr_1() constructor
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new LoginScr_1();
		
		

	} // end of main() Method
	
	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			String jbVal = e.getActionCommand();
			String jtfidVal = jtf.getText();
			@SuppressWarnings("deprecation")
			String jtfpwVal = jpf.getText();
	

		if(jbVal == "LOGIN"){
			
			
			int j =0;
			ArrayList aList = LoginMethod();

			int aListCnt = aList.size();
			
			
			if(aListCnt > 0){
				
				for (int i=0;i < aListCnt ; i++ )
				{
					MemberVO mVO = null;
					mVO = (MemberVO)aList.get(i);
					
					String id1 = mVO.getMember_id();
					System.out.println("ID >>> "+id1);
					String pw1 = mVO.getMember_pw();
					System.out.println("PW >>> "+pw1);
					
					if (jtfidVal.equals(id1) && jtfpwVal.equals(pw1))
					{
						j = 1;
						
						session = new ArrayList();
						session.add(mVO.getMember_no());
						session.add(mVO.getMember_id());
						session.add(mVO.getMember_pw());
						session.add(mVO.getMember_name());
						session.add(mVO.getMember_addr());
						session.add(mVO.getMember_hp());
						session.add(mVO.getMember_email());
						session.add(mVO.getMember_deleteyn());
						session.add(mVO.getMember_in());
						session.add(mVO.getMember_up());
										
					} //end of else			
							
				} //end of for
				if(j == 1){
					
					JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다.");
					setVisible(false);
					new MainScr(session);
					
				} // end of if
				
				if(j !=1 ){
					jtf.setText("");
					jpf.setText("");
					JOptionPane.showMessageDialog(null, "ID 혹은 비밀번호가 일치하지 않습니다.");
				} // end of if
				
				} // end of if(aListCnt > 0){
			} // end of if(jbVal == "LOGIN"){
		
		if(jbVal == "JOIN"){
			setVisible(false);
			new MemberJoinScr();
		} // end of if(jbVal == "JOIN")
					
		} // end of public void actionPerformed(ActionEvent e){
		
	/*	private ArrayList LoginScr(MemberVO mVO) {
			// TODO Auto-generated method stub
			return null;
		}*/

		public ArrayList LoginMethod() {
			
			LoginDao lDao = null;
			lDao = new LoginDao();
			ArrayList aList = lDao.login();
			
		return aList;
		
		} // end of public ArrayList LoginMethod() {
		} //end of private class MyListener implements ActionListener {
			
	}// end of MyListener Class