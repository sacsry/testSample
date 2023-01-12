package test;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class test4 extends JFrame {
	
	private JTextField ID = new JTextField(10);
	private JPasswordField password = new JPasswordField(10);

	public test4() {
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
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new test4();
	}
}