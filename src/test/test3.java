package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class test3 extends JFrame {
	
	private JTextField ID = new JTextField(10);
	private JPasswordField password = new JPasswordField(10);
	private MyDialog dialog;

	public test3() {
		setTitle("test1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		creatMenu();
		Container c = getContentPane();
		c.setLayout(null);

		
		JPanel south = new JPanel();
		

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerPanel.setSize(200, 200);
		centerPanel.setOpaque(true);
		centerPanel.add(new JLabel("ID                 :"));
		centerPanel.add(ID);
		centerPanel.add(new JLabel("password : "));
		centerPanel.add(password);
		centerPanel.setBackground(Color.yellow);
		centerPanel.setSize(220,100);
		centerPanel.setLocation(30,10);

		south.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		JButton jb1 = new JButton("로그인");
		JButton jb2 = new JButton("회원가입");
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(ID.getText().equals("test") && Integer.parseInt(password.getText()) == 1234) {
					JOptionPane.showMessageDialog(null, "로그인 성공", "성공",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(ID.getText().equals("test") && Integer.parseInt(password.getText()) != 1234)
					JOptionPane.showMessageDialog(null, "Pwd를 확인하세요.", "실패",JOptionPane.CANCEL_OPTION);
				else if(!ID.getText().equals("test") && Integer.parseInt(password.getText()) == 1234)
					JOptionPane.showMessageDialog(null, "ID를 확인하세요.", "실패",JOptionPane.CANCEL_OPTION);
				else
					JOptionPane.showMessageDialog(null, "ID,Pwd를 확인하세요.", "실패",JOptionPane.CANCEL_OPTION);
			}
		});
		dialog = new MyDialog(this, "test");
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dialog.setVisible(true);
				
			}
		});
		south.add(jb1);
		south.add(jb2);
		south.setSize(200,100);
		south.setLocation(50,120);
		c.add(centerPanel);
		c.add(south);
		
		
		

		setSize(300, 250);
		setVisible(true);
	}
	
	public void creatMenu() {
		JMenuBar jb = new JMenuBar();
		JMenu screenMenu = new JMenu("screen");
		JMenuItem Clear = new JMenuItem("Clear");
		Clear.addActionListener(new MyActionListener());
		
		screenMenu.add(Clear);
		setJMenuBar(jb);
		jb.add(screenMenu);
		
	}
	
	class MyActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ID.setText("");
			password.setText("");
		}
	}
	
	class MyDialog extends JDialog {
		private String [] region = {"서울                                    ", "대전", "부산", "경기"};
		private JTextField tf = new JTextField(15);
		private JPasswordField psd = new JPasswordField(15); 
		private JButton okButton = new JButton("회원가입"); 
		private JLabel la1 = new JLabel("회원정보 페이지 입니다.");
		private JLabel la2 = new JLabel("아이디:         ");
		private JLabel la3 = new JLabel("패스워드:       ");
		private JLabel la4 = new JLabel("주소:          ");
		private JLabel la5 = new JLabel("취미:     ");
		private JLabel la6 = new JLabel("성별:                 ");
		private JComboBox<String> strCombo = new JComboBox<String>(region);
		
		private JRadioButton box2 = new JRadioButton();
		
		
		public MyDialog(JFrame frame, String title) {
			super(frame,title,true);
			setLayout(new FlowLayout());
			JCheckBox check = new JCheckBox("운동");
			JCheckBox check1 = new JCheckBox("게임");
			JCheckBox check2 = new JCheckBox("영화감상");
			
			ButtonGroup g = new ButtonGroup();
			JRadioButton man = new JRadioButton("남자");
			JRadioButton girl = new JRadioButton("여자");
			g.add(man);
			g.add(girl);
			la1.setFont(new Font("godic",Font.BOLD,20));
			la1.setForeground(Color.blue);
			la2.setFont(new Font("godic",Font.BOLD,15));
			la3.setFont(new Font("godic",Font.BOLD,15));
			la4.setFont(new Font("godic",Font.BOLD,15));
			la5.setFont(new Font("godic",Font.BOLD,15));
			la6.setFont(new Font("godic",Font.BOLD,15));
		
			add(la1);
			add(la2);
			add(tf);
			add(la3);
			add(psd);
			add(la4);
			
			add(strCombo);
			add(la5);
			add(check);
			add(check1);
			add(check2);
			add(la6);
			add(man);
			add(girl);
			
			add(okButton);
			setSize(300, 400);
		
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false); 
				}
			});
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new test3();
	}
}
