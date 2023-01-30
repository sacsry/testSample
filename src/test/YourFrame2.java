package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class YourFrame2 extends JFrame {

	ProjectMain s;
	String Myteam;

	YourFrame2(JFrame f, String Myteam) {
		super("MystarCraft");
		s = (ProjectMain) f;
		this.Myteam = Myteam;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.black);
		
		setResizable(false);
		ImagePanel p = new ImagePanel();
		p.setBackground(Color.black);
		p.setBounds(0, 0, 1200, 750);

		JButton strbtn = new JButton("시작");
		strbtn.setBounds(500, 800, 100, 30);

		strbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				dispose();
				new EntryFrame(f, Myteam);
			}
		});

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

		JButton dataBtn = new JButton("선수 정보");
		dataBtn.setBounds(250, 900, 150, 30);

		dataBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				dispose();
				System.out.println(s.Scorearray);
				new sunsudata(f, Myteam);

			}
		});
		c.add(dataBtn);
		c.add(strbtn);
		c.add(p);
		setSize(1200, 1000);
		setVisible(true);
	}

	class ImagePanel extends JPanel {
		ImageIcon[] image = new ImageIcon[22];
		Image[] img = new Image[22];

		public void paint(Graphics g) {
			super.paint(g);
			ImageIcon image1 = new ImageIcon("images/로고/" + Myteam + ".gif");
			Image img1 = image1.getImage();
			g.drawImage(img1, 0, 700, 50, 50, this);

			
			g.drawLine(975, 275, 975, 175);
			g.drawLine(375, 275, 375, 175);
			for (int i = 0; i < 12; i++) {
				if (s.wincount == 1 || s.wincount == 2 || s.wincount ==3) {
					if (s.Scorearray.get(i) == 3) {
						g.setColor(Color.green);	
					} else if(s.Scorearray.get(i) != 3) {
						g.setColor(Color.darkGray);	
					}
				}
				
				int a = 100 * (i - 1);
				g.drawLine(25 + (100 * i), 700, 25 + (100 * i), 575);
				g.drawLine(25 + (100 * i), 700, 25 + (100 * i), 575);

				if (i % 2 == 0) {
					
					g.drawLine(25 + (100 * i), 575, 75 + (100 * i), 575);
				}
				if (i % 2 != 0) {
					
					g.drawLine(25 + (100 * i), 575, 75 + a, 575);
				}
				
			}

			////////////////////// 6강//////////////
			g.setColor(Color.darkGray);
			
			for (int i = 12; i < 18; i++) {

				if(s.wincount == 1 || s.wincount == 2 || s.wincount ==3) {
					g.setColor(Color.GREEN);
				}
				int a = 200 * (i - 13);
				int b = 425;
				if(i>=16) {
					
					b = 275;
				}
				g.drawLine(75 + (200 * (i - 12)), 575, 75 + (200 * (i - 12)), b);
				
				g.setColor(Color.DARK_GRAY);
				if (s.wincount == 2 || s.wincount ==3) {
					if (s.Scorearray.get(i) == 3) {
						g.setColor(Color.green);	
						g.drawLine(975, 275, 975, 175);
					} else if(s.Scorearray.get(i) != 3) {
						g.setColor(Color.darkGray);	
					}
				}
				if (i % 2 == 0) {
					g.drawLine(75 + (200 * (i - 12)), b, 175 + (200 * (i - 12)), b);
				}
				if (i % 2 != 0) {
					g.drawLine(75 + (200 * (i - 12)), b, 175 + a, b);
				}
				
			}
			

			//// 준결승
			g.setColor(Color.DARK_GRAY);
			if(s.wincount == 2 || s.wincount == 3) {
				g.setColor(Color.GREEN);
			}
			g.drawLine(175, 425, 175, 275);
			g.drawLine(575, 425, 575, 275);
			g.setColor(Color.DARK_GRAY);
			
			for(int i =18; i<20; i++) {
				if(s.wincount == 3) {
					if(s.Scorearray.get(i) == 3) {
						g.setColor(Color.GREEN);
						g.drawLine(375, 275, 375, 175);
					}
					
					else if(s.Scorearray.get(i) != 3) {
						g.setColor(Color.darkGray);	
					}
				}
			g.drawLine(175+((i-18)*400), 275, 375, 275);
			
			}
			

			g.setColor(Color.DARK_GRAY);
			g.drawLine(375, 175, 675, 175);
			g.drawLine(975, 175, 675, 175);
			for (int i = 0; i < 11; i++) {
				image[i] = new ImageIcon("images/로고/" + s.NewTeam.get(s.num[i]) + ".gif");
				img[i] = image[i].getImage();

				g.drawImage(img[i], 100 + (100 * i), 700, 50, 50, this);

			}

			if (s.wincount == 1 || s.wincount ==2 || s.wincount == 3) {
				g.setColor(Color.white);
				for (int i = 0; i < 12; i++) {
					g.drawString(s.Scorearray.get(i) + "", 25 + (100 * i), 570);

				}
				////////////////////////////// 스코어/////////////////////////////

				for (int i = 11; i < 17; i++) {

					image[i] = new ImageIcon("images/로고/" + s.NewTeam.get(i) + ".gif");
					img[i] = image[i].getImage();

					g.drawImage(img[i], 50 + (200 * (i - 11)), 550, 50, 50, this);

				}
			}

			if (s.wincount == 2 || s.wincount ==3) {
				g.setColor(Color.white);

				for (int i = 12; i < 16; i++) {
					g.drawString(s.Scorearray.get(i) + "", 75 + (200 * (i - 12)), 420);

				}
				for (int i = 16; i < 18; i++) {
					g.drawString(s.Scorearray.get(i) + "", 75 + (200 * (i - 12)), 270);

				}
				////////////////////////////// 스코어/////////////////////////////
				for (int i = 11; i < 17; i++) {
					image[i] = new ImageIcon("images/로고/" + s.NewTeam.get(i) + ".gif");
					img[i] = image[i].getImage();

					g.drawImage(img[i], 50 + (200 * (i - 11)), 550, 50, 50, this);

				}
				for (int i = 17; i < 19; i++) {
					image[i] = new ImageIcon("images/로고/" + s.NewTeam.get(i) + ".gif");
					img[i] = image[i].getImage();

					g.drawImage(img[i], 150 + (400 * (i - 17)), 400, 50, 50, this);

				}
				image[19] = new ImageIcon("images/로고/" + s.NewTeam.get(19) + ".gif");
				img[19] = image[19].getImage();

				g.drawImage(img[19], 950, 250, 50, 50, this);
			}
			if (s.wincount == 3) {
				g.setColor(Color.white);

				for (int i = 18; i < 20; i++) {
					g.drawString(s.Scorearray.get(i) + "", 175 + (400 * (i - 18)), 270);
				}

				////////////////////////////// 스코어/////////////////////////////

				
				image[20] = new ImageIcon("images/로고/" + s.NewTeam.get(20) + ".gif");
				img[20] = image[20].getImage();

				g.drawImage(img[20], 350, 250, 50, 50, this);

			}

		}
	}
}