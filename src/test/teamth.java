package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class teamth extends JFrame {

	JLabel[] teamlabel = new JLabel[12];
	ArrayList<String> teamarray = new ArrayList<String>();
	ArrayList<Integer> winarray = new ArrayList<Integer>();
	ArrayList<Integer> losearray = new ArrayList<Integer>();
	ArrayList<Integer> advantagearray = new ArrayList<Integer>();
	ImageIcon[] image = new ImageIcon[12];
	Image[] img = new Image[12];

	teamth(JFrame f, String Myteam) {

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

		losearray = s.teamdb.getLosearray();
		winarray = s.teamdb.getWinarray();
		teamarray = s.teamdb.getTeamarray();
		advantagearray = s.teamdb.getAdvantagearray();
//
//		for (int i = 1; i < 13; i++) {
//			teamlabel[i - 1] = new JLabel();
//			teamlabel[i - 1].setText(i + "등: " + teamarray.get(i - 1) + " " + winarray.get(i - 1) + "승 "
//					+ losearray.get(i - 1) + "패 (" + advantagearray.get(i - 1) + ")");
//			teamlabel[i - 1].setBounds(700, 50 + (70 * i), 300, 70);
//			teamlabel[i - 1].setForeground(Color.white);
//			c.add(teamlabel[i - 1]);
//		}
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
		
			for (int i = 1; i < 13; i++) {
				image[i-1] = new ImageIcon("images/로고/" + teamarray.get(i - 1) + ".gif");
			    img[i-1] = image[i-1].getImage();
				g.setColor(Color.white);
			    g.setFont(new Font("",Font.ITALIC,20));
			    g.drawString(i + "등: " + teamarray.get(i - 1), 300, 50+(70*(i-1)));
			    g.drawImage(img[i-1], 550,25+(70*(i-1)),70,50 , this);
			    g.setFont(new Font("",Font.ITALIC,20));
			    g.drawString( winarray.get(i - 1) + "승          "+ losearray.get(i - 1) + "패(", 650, 50+(70*(i-1)));
			    g.setFont(new Font("",Font.ITALIC,15));
			    if(advantagearray.get(i - 1)>=0) {
			    g.setColor(Color.green);
			    g.drawString("+", 785, 50+(70*(i-1)));
			    }
			    else {
			    	g.setColor(Color.red);
			    }
			    g.drawString(advantagearray.get(i - 1)+"", 800, 50+(70*(i-1)));
			    g.setColor(Color.white);
			    g.setFont(new Font("",Font.ITALIC,20));
			    g.drawString(" )", 815, 50+(70*(i-1)));
			}
			
			
		}

	}

}
