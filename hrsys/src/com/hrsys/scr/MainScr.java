package com.hrsys.scr;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.ImageIcon;

public class MainScr extends JFrame {
	private ArrayList session;
	JButton jb[];

	
	public MainScr(ArrayList session) {

		super("HOTEL RESERVATION SYSTEM");
		getContentPane().setBackground(Color.white);

		this.session = session;
		String btarray[] = {"마이페이지","예약하기","예약조회/변경","로그아웃"};
		jb = new JButton[4];
		int btaLength = btarray.length;

		ImageIcon icon = new ImageIcon("C:/00.KOITT/koittJava/hrsys/src/com/hrsys/scr/mypage.png");
		ImageIcon icon1 = new ImageIcon("C:/00.KOITT/koittJava/hrsys/src/com/hrsys/scr/reserve.png");
		ImageIcon icon2 = new ImageIcon("C:/00.KOITT/koittJava/hrsys/src/com/hrsys/scr/reserveChange.png");
		ImageIcon icon3 = new ImageIcon("C:/00.KOITT/koittJava/hrsys/src/com/hrsys/scr/logout.png");

		int k = 70;
		for(int i = 0 ; i <4 ; i++){
			jb[i] = new JButton(btarray[i]);

			jb[i].setBounds(150, k , 400, 100);
			k +=110;
			
			if(i==0){
				jb[0].setIcon(icon);
			}

			if(i==1){
				jb[1].setIcon(icon1);
			}

			if(i==2){
				jb[2].setIcon(icon2);
			}
			
			if(i==3){
				jb[3].setIcon(icon3);
			}

			jb[i].setForeground(Color.white);
			jb[i].setFont(new Font("Courier", Font.BOLD, 20));
			jb[i].setBorderPainted(false);
			add(jb[i]);
			jb[i].addActionListener(new MyListener());
		}
		
		
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		
		setLayout(null);
		setLocation(d.width/3, d.height/5);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setSize(700,600);
		setVisible(true);
		
	}

	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
		System.out.println(e.getActionCommand());
			//String jbVal = e.getActionCommand();
			
			if (e.getSource() == jb[0]){
				MyPageScr mps = null;
				mps = new MyPageScr();
				mps.myPageSelect(session);			
				setVisible(false);
			}
			
			if (e.getSource() == jb[1]){
				ReserveScr rs = null;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
				rs = new ReserveScr(session);
				setVisible(false);
			
			}
			
			if (e.getSource() == jb[2]){
				
				new ReserveList(session);
				setVisible(false);
				
			}
			
			if (e.getSource() == jb[3]){
				
				session = null;
			
				JOptionPane.showMessageDialog(null, "로그아웃 하셨습니다.");			
				setVisible(false);
				
				new LoginScr_1();
				
			}
			
			
		}
	}
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*ArrayList session = new ArrayList();
		int i = 0;
		session.add(i);
		
		new MainScr(session);*/
	}
	}