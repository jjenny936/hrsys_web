package com.hrsys.scr;

import java.awt.Color;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.hrsys.dao.MemberDAO;
import com.hrsys.vo.MemberVO;
import com.hrsys.scr.LoginScr_1;

public class MemberJoinScr extends JFrame {
	
	JButton jb[];
	JButton jbBack;
	JTextField jtf[];
	JPasswordField jpf;	
	JLabel jl[];
	Font f1;
	
	int isIdChecked; //id중복체크
	int isPwChecked; //pw확인
	
	public MemberJoinScr(){

		super("MEMBER JOIN");
		
		setLayout(null);
		getContentPane().setBackground(Color.white);
		
		String jBarray[] = {"ID중복체크" , "PW확인" , "등록"};
		//String jtfarray[] = {"ID","PW","PW확인","성명","주소","전화번호","E-Mail"};
		String jlarray[] = {"ID","PW","PW확인","성명","주소","전화번호","E-Mail"};
		jb = new JButton[3];
		jtf = new JTextField[7];
		jl = new JLabel[7];
		
		f1 = new Font("굴림", Font.BOLD, 20);
		int JbArrayLength = jl.length;
		int jBarrayLength = jBarray.length;
		System.out.println(JbArrayLength);
		
		int k = 30;
		
		for(int i =0 ; i < JbArrayLength ; i++){
			jl[i] = new JLabel(jlarray[i]);
			jl[i].setBounds(50, k , 150, 30);
			jl[i].setFont(f1);
			jtf[i] = new JTextField("");
			jtf[i].setBounds(150, k , 150, 30);
			//System.out.println(jl[i]);
			k += 40;
			System.out.println(k);
			add(jl[i]);
			add(jtf[i]);
		}
		
		for(int i = 0 ; i<jBarrayLength ;i ++){
			if(i == 0){
				jb[i] = new JButton(jBarray[i]); // ID중복체크
				jb[i].setBounds(330, 30 , 100, 20);
			}
			if(i == 1){
				jb[i] = new JButton(jBarray[i]); // PW확인
				jb[i].setBounds(330, 110 , 100, 20);
				
			}
			if(i == 2){
				jb[i] = new JButton(jBarray[i]); // 등록버튼
				jb[i].setBounds(450, 450 , 200,50);
				jb[i].setBackground(Color.black);
				jb[i].setForeground(Color.white);
			}
			
			add(jb[i]);
			jb[i].addActionListener(new MyListener());
			
		}
		
		//뒤로가기 버튼
		jbBack = new JButton("뒤로가기");
		jbBack.setSize(200, 50);
		jbBack.setLocation(230, 450);
		jbBack.setBackground(Color.black);
		jbBack.setForeground(Color.white);
		
		add(jbBack);
		jbBack.addActionListener(new MyListener());
		
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();		
		setSize(700,600);
		setLocation(d.width/3, d.height/5);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
				
		
	}// end of MemberJoinScr() constructor
	
	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			System.out.println(e.getActionCommand());
			
			if(e.getSource() == jb[0]){ //아이디 중복확인
				
				isIdChecked = 1;
				String idCheck = jtf[0].getText();
				
				if (idCheck.length() != 0) 
				{
					int i = idCheckWork(idCheck);
	                System.out.println(" nCnt >>> : " + i);		
	                
					
					if (i > 0)
					{
						System.out.println(" 이미 사용중인 ID 입니다.");
						JOptionPane.showMessageDialog(null, " 이미 사용중인 ID 입니다.");
						jb[0].setText("");	
											
					}else{
						System.out.println(" 사용가능한 ID 입니다.");
						JOptionPane.showMessageDialog(null, " 사용가능한 ID 입니다.");	
					}
					
				}else{
					System.out.println(" ID를 입력하세요.");
					JOptionPane.showMessageDialog(null, "ID를 입력하세요.");
				}
			
			}// end of id 중복확인 if문
			
			if(e.getSource() == jb[1]){ //비밀번호 확인
				
				isPwChecked = 1;			
				if(jtf[1].getText().equals(jtf[2].getText())){			
					JOptionPane.showMessageDialog(null, "비밀번호 확인 성공!");					
				
				}else{
					JOptionPane.showMessageDialog(null, "비밀번호를 다시 확인해 주십시오.");	
				}
				
			}
	
			if(e.getSource() == jb[2]){ //등록버튼 이벤트
							
				try{
					
					if(isIdChecked == 1 && isPwChecked == 1){ //jb[0], jb[1]을 모두 한 번 이상 거쳐야만 아래내용 실행될 것.
						
						String mId = jtf[0].getText();
						String mPw = jtf[1].getText();
						String mName = jtf[3].getText();
						String mAddr = jtf[4].getText();
						String mHp = jtf[5].getText();
						String mEmail = jtf[6].getText();

						int i = insertWork(mId, 
										   mPw, 
										   mName, 
										   mAddr, 
										   mHp, 
										   mEmail); //insertWork의 리턴값 -> 삽입이 일어난 횟수
													//through executeUpdate() method in PrepraredStatement class				
					
						if(i>0){
							
							JOptionPane.showMessageDialog(null, "회원가입 성공!");
							setTextClear();	
							setVisible(false);
							new LoginScr_1(); 
							

						}else{
							JOptionPane.showMessageDialog(null, "등록에 실패했습니다.");
							setTextClear();
						}
					
					}
						
					
					if(isIdChecked != 1 || isPwChecked != 1){
						JOptionPane.showMessageDialog(null, "ID 중복확인 또는 비밀번호 확인이 완료되지 않았습니다.");
					}
						

				}catch(Exception e1){
					e1.printStackTrace();
				}

			}	
			
			if(e.getSource() == jbBack){//뒤로가기 버튼	
				setVisible(false);
				new LoginScr_1();				
			}
			
		}// end of actionPerformed() method
		
	}// end of MyListener class
	
	public void setTextClear(){

		jtf[0].setText("");
		jtf[1].setText("");
		jtf[2].setText("");
		jtf[3].setText("");
		jtf[4].setText("");
		jtf[5].setText("");
		jtf[6].setText("");

	}// end of setTextClear() method
	
	//id 중복확인 함수.
	public int idCheckWork(String idCheck)//String idCheck = id 텍스트 필드에 입력받은 내용.
	{
		int i = 0;

		try
		{
			MemberDAO md = null;
			md = new MemberDAO();
			
			MemberVO mv = null;
			mv = new MemberVO();
			
			mv.setMember_id(idCheck); //idCheck를 vo에 set 해줌			
			
			i = md.idCheck(mv);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return i;
		
	}// end of idCheckWork() method
	
	public int insertWork(String mId, 
			    		  String mPw, 
			    		  String mName, 
			    		  String mAddr, 
			    		  String mHp, 
			    		  String mEmail) throws Exception{

		MemberDAO md = null;
		md = new MemberDAO();

		MemberVO mv = null;
		mv = new MemberVO();

		//화면에서 텍스트필드에 입력받아온 정보를 vo에 set해줌.
		mv.setMember_id(mId);
		mv.setMember_pw(mPw);
		mv.setMember_name(mName);
		mv.setMember_addr(mAddr);
		mv.setMember_hp(mHp);
		mv.setMember_email(mEmail);

		int i = md.memberJoin(mv); 
		return i; 

	}// end of insertWork() method	
	
	public static void main(String args[]) throws Exception
	{
		new MemberJoinScr();
		
	}// end of main() method
	
}// end of MemberJoinScr class

