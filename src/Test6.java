import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Test6 extends JFrame{
	
	JTextField ID = new JTextField(10);
	JPasswordField PW = new JPasswordField(10);
	JLabel la = new JLabel();
	
	public Test6() {
		setTitle("로그인 테스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		
		
		c.add(p1,BorderLayout.NORTH);
		c.add(p2,BorderLayout.CENTER);
		c.add(p3,BorderLayout.SOUTH);
		
		
		p1.setLayout(new FlowLayout());
		
		la.setText(" 로그인 하세요. ");
		p1.add(la);
		
		p2.setLayout(new GridLayout(2,2));
		JLabel la1 = new JLabel();
		JLabel la2 = new JLabel();
		la1.setText("아이디");
		la2.setText("비밀번호");
		
		
		p2.add(la1);
		p2.add(la2);
		p2.add(ID);
		p2.add(PW);
		
		
		p3.setLayout(new GridLayout(1,1));
		JButton Login = new JButton();
		Login.addActionListener(new MyActionListener());
		JButton psw = new JButton();
		psw.addActionListener(new MyActionListener2());
		Login.setText("로그인");
		psw.setText("아이디/비밀번호찾기");
		
		p3.add(Login);
		p3.add(psw);
		
		setSize(300,200);
		setVisible(true);
		
	}
	public class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton Jb = (JButton)e.getSource();
			if(ID.getText().equals("test") && PW.getText().equals("test1")) {
				la.setText("로그인 성공!");
			}
			else {
				la.setText("로그인 실패!");
			}

		}
	}
	public class MyActionListener2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton Jb = (JButton)e.getSource();
			la.setText("id는 'test' pw는 'test1'입니다.");
		
		}
	}
	
	public static void main(String[] args) {
		new Test6();
	}
	

}
