package ProJect;

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
			
			g.drawLine(125, 700, 125, 575);
			g.drawLine(225, 700, 225, 575);
			g.drawLine(325, 700, 325, 575);
			g.drawLine(425, 700, 425, 575);
			g.drawLine(525, 700, 525, 575);
			g.drawLine(625, 700, 625, 575);
			g.drawLine(725, 700, 725, 575);
			g.drawLine(825, 700, 825, 575);
			g.drawLine(925, 700, 925, 575);
			g.drawLine(1025, 700, 1025, 575);
			g.drawLine(1125, 700, 1125, 575);
			
			g.drawLine(125, 575, 75, 575);
			g.drawLine(225, 575, 275, 575);
			g.drawLine(325, 575, 275, 575);
			g.drawLine(425, 575, 475, 575);
			g.drawLine(525, 575, 475, 575);
			g.drawLine(625, 575, 675, 575);
			g.drawLine(725, 575, 675, 575);
			g.drawLine(825, 575, 875, 575);
			g.drawLine(925, 575, 875, 575);
			g.drawLine(1025, 575, 1075, 575);
			g.drawLine(1125, 575, 1075, 575);
			
			g.drawLine(75, 575, 75, 425);
			g.drawLine(275, 575, 275, 425);
			g.drawLine(475, 575, 475, 425);
			g.drawLine(675, 575, 675, 425);
			g.drawLine(875, 575, 875, 425);
			g.drawLine(1075, 575, 1075, 425);
			
			
			g.drawLine(75, 425, 175, 425);
			g.drawLine(275, 425, 175, 425);
			g.drawLine(475, 425, 575, 425);
			g.drawLine(675, 425, 575, 425);
			g.drawLine(875, 425, 975, 425);
			g.drawLine(1075, 425, 975, 425);
			////수정
			for (int i = 0; i < 11; i++) {
				image[i] = new ImageIcon("images/로고/" + s.NewTeam.get(s.num[i]) + ".gif");
				img[i] = image[i].getImage();

				g.drawImage(img[i], 100 + (100 * i), 700, 50, 50, this);

			}
			
			if (s.wincount == 1) {
				for (int i = 11; i < 17; i++) {
					g.setColor(Color.green);
					image[i] = new ImageIcon("images/로고/" + s.NewTeam.get(i) + ".gif");
					img[i] = image[i].getImage();

					g.drawImage(img[i], 50 + (200 * (i-11)), 550, 50, 50, this);

				}
			}
			g.drawLine(25, 700, 25, 575);
			g.drawLine(25, 575, 75, 575);
			if(s.wincount == 2) {
				for (int i = 11; i < 17; i++) {
					image[i] = new ImageIcon("images/로고/" + s.NewTeam.get(i) + ".gif");
					img[i] = image[i].getImage();

					g.drawImage(img[i], 50 + (200 * (i-11)), 550, 50, 50, this);

				}
				for (int i = 17; i < 20; i++) {
					image[i] = new ImageIcon("images/로고/" + s.NewTeam.get(i) + ".gif");
					img[i] = image[i].getImage();

					g.drawImage(img[i], 150 + (400 * (i-17)), 400, 50, 50, this);

				}
			}
			if(s.wincount == 3) {
				for (int i = 11; i < 17; i++) {
					image[i] = new ImageIcon("images/로고/" + s.NewTeam.get(i) + ".gif");
					img[i] = image[i].getImage();

					g.drawImage(img[i], 50 + (200 * (i-11)), 550, 50, 50, this);

				}
				for (int i = 17; i < 20; i++) {
					image[i] = new ImageIcon("images/로고/" + s.NewTeam.get(i) + ".gif");
					img[i] = image[i].getImage();

					g.drawImage(img[i], 150 + (400 * (i-17)), 400, 50, 50, this);

				}
				for (int i = 20; i < 22; i++) {
					image[i] = new ImageIcon("images/로고/" + s.NewTeam.get(i) + ".gif");
					img[i] = image[i].getImage();

					g.drawImage(img[i], 300 + (600 * (i-20)), 250, 50, 50, this);

				}
			}
			
			
		}
	}
}