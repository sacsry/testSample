package test;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import test.teamth.ImagePanel;

public class sunsuwinranking extends JFrame{
	ArrayList<String> sunsuname = new ArrayList<String>();
	ArrayList<Integer> winarray = new ArrayList<Integer>();
	ArrayList<Integer> losearray = new ArrayList<Integer>();
	ImageIcon[] image = new ImageIcon[10];
	Image[] img = new Image[10];
	
	sunsuwinranking(JFrame f, String Myteam){
		super("MystarCraft");
		ProjectMain s = (ProjectMain) f;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.black);

		setResizable(false);
		JButton resetBtn = new JButton("R");
		resetBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				new ProjectMain();
			}
		});

		resetBtn.setBounds(0, 0, 50, 50);
		c.add(resetBtn);
		
		JButton backBtn1 = new JButton("<<back");
		backBtn1.setBounds(550, 900, 100, 30);
		if(s.gamejung) {
			backBtn1.setText("다음>>");
		}
		backBtn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				s.member1JList.setVisible(true);
				s.anotherTeamJList.setVisible(true);
				setVisible(false);
				dispose();
				new YourFrame3(f,Myteam);
			}
		});

		sunsuname = s.sunsudb.getSunsuname();
		losearray = s.sunsudb.getLosearray();
		winarray = s.sunsudb.getWinarray();
		
		ImagePanel panel = new ImagePanel();
		panel.setBackground(Color.black);
		panel.setBounds(0, 0, 1200, 900);
		c.add(panel);
		c.add(backBtn1);
		setVisible(true);
		setSize(1200, 1000);
		
	}
	class ImagePanel extends JPanel {

		public void paint(Graphics g) {
			super.paint(g);
		
			for (int i = 1; i < 11; i++) {
				image[i-1] = new ImageIcon("images/" + sunsuname.get(i - 1) + ".gif");
			    img[i-1] = image[i-1].getImage();
				g.setColor(Color.white);
			    g.setFont(new Font("",Font.ITALIC,20));
			    g.drawString(i + "등: " + sunsuname.get(i - 1), 300, 50+(80*(i-1)));
			    g.drawImage(img[i-1], 550,25+(80*(i-1)),70,50 , this);
			    g.setFont(new Font("",Font.ITALIC,20));
			    g.drawString( winarray.get(i - 1) + "승         "+ losearray.get(i - 1) + "패(", 650, 50+(80*(i-1)));
			    g.setFont(new Font("",Font.ITALIC,15));
			    g.drawString(Math.round((double)winarray.get(i-1)*100/(double)(losearray.get(i-1)+winarray.get(i-1)))+"", 790, 50+(80*(i-1)));
			    g.setColor(Color.white);
			    g.setFont(new Font("",Font.ITALIC,20));
			    g.drawString(")%", 815, 50+(80*(i-1)));
			}
			
			
		}

	}

}
