package Thread;

import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CalcClientEx extends JFrame {
	
	private BufferedReader in = null;
	private BufferedWriter out = null;
	private Socket socket = null;
	private JTextField num1 = new JTextField(7);
	private JTextField cal = new JTextField(3);
	private JTextField num2 = new JTextField(7);
	private JTextField num3 = new JTextField(7);
	private JButton jb = new JButton("계산");
	
	public CalcClientEx() {
		
		
		
		
		setTitle("계산 클라이언트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(num1);
		c.add(cal);
		c.add(num2);
		c.add(num3);
		c.add(jb);
		setSize(300,100);
		setVisible(true);
		
		setupConnection();
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
				String num1Text = num1.getText().trim(); 
				String calText = cal.getText().trim();
				String num2Text = num2.getText().trim();
				
				if(num1Text.length() == 0 || calText.length() == 0 || num2Text.length() ==0)
					return;
				out.write(num1Text+"\n");
				out.write(calText+"\n");
				out.write(num2Text+"\n");
				out.flush();
				
				String result = in.readLine();
				num3.setText(result);
				
				}catch(IOException e) {
					System.out.println("클라이언트 : 서버로부터 연결 종료");
					return;
				}
				}
		});
		
		
		
	}
	
	public void setupConnection() {
		try {
			socket = new Socket("localhost",9999);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
		}catch(UnknownHostException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		new CalcClientEx();
	}
}