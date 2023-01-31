package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class winnersgameFrame extends JFrame {
	private JButton resetBtn = new JButton("R");
	private JLabel winLabel = new JLabel("WIN");
	private JLabel loseLabel = new JLabel("Lose");

	private JLabel MyImage = new JLabel();
	private JLabel YourImage = new JLabel();
	private JLabel PvP = new JLabel();

	
	

	public winnersgameFrame(JFrame f, String Myteam, int count, int wincount, int losecount) {
		super("Mystarcraft");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ProjectMain s = (ProjectMain) f;
		Container c = getContentPane();
		c.setBackground(Color.black);
		setLayout(null);
		setResizable(false);

		resetBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				new ProjectMain();
			}
		});

		s.draw = new Drawlabel(f);
		s.draw.setLayout(null);
		Drawlabel2 draw1 = new Drawlabel2(f);
		draw1.setLayout(null);

		for (int i = 0; i < 7; i++) {
			s.setbtn1[i] = new JButton(s.NewMap.get(i));
			s.setbtn1[i].setBounds(550, 350 + (70 * i), 100, 30);
			int a = i;
			s.setbtn1[i].addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					Map currentMap = new Map();
					currentMap.data(s.NewMap.get(a));
					s.Mapdatalabel.setText("<html><body><center>" + s.NewMap.get(a) + "<br>T:Z "
							+ currentMap.getMyTerranwinrate() + ":" + currentMap.getYourZergwinrate() + "<br>Z:P "
							+ currentMap.getMyZergwinrate() + ":" + currentMap.getYourProtosswinrate() + "<br>P:T "
							+ currentMap.getMyProtosswinrate() + ":" + currentMap.getYourTerranwinrate()
							+ "</center></body></html>");
					s.Mapdatalabel.setFont(new Font("맵 정보", Font.ITALIC, 17));
					s.Mapdatalabel.setForeground(Color.white);
					s.Mapdatalabel.setBounds(630, 150, 200, 200);
					ImageIcon icon = new ImageIcon("images/맵/" + s.NewMap.get(a) + ".gif");
					s.Mapla.setIcon(icon);
					s.Mapla.setBounds(480, 150, 200, 200);

					MyImage.setIcon(s.MysunsuImage[a]);
					MyImage.setBounds(130, 380, 100, 100);
					YourImage.setIcon(s.YoursunsuImage[a]);
					YourImage.setBounds(970, 380, 100, 100);

					s.sunsudb.data(s.Mysunsulabel[a].getText());
					s.atk1 = s.sunsudb.getAtk();
					s.def1 = s.sunsudb.getDef();
					s.tectics1 = s.sunsudb.getTectics();
					s.sense1 = s.sunsudb.getSense();
					s.supply1 = s.sunsudb.getSupply();
					s.control1 = s.sunsudb.getControl();
					s.type1 = s.sunsudb.getType();
					s.recon1 = s.sunsudb.getRecon();
					s.keep1 = s.sunsudb.getKeep();
					s.grade1 = s.sunsudb.getGrade();
					if(s.Mysunsulabel[a].getText().equals("Hidden")) {
						s.draw.setVisible(false);
					}
					else {
					s.draw.setVisible(true);
					}
					s.draw.repaint();
//					s.statlabel.setVisible(true);
//					
//					s.statlabel.setText("<html><body><center>공격력: " + s.atk1 + "<br>수비력: " + s.def1 + "<br>전략: "
//							+ s.tectics1 + "<br>센스: " + s.sense1 + "<br>물량: " + s.supply1 + "<br>컨트롤: " + s.control1
//							+ "<br>견제: " + s.keep1 + "<br>정찰: " + s.recon1
//							+"<br>종족: " + s.type1 + "</center></body></html>");

					s.sunsudb.data(s.Yoursunsulabel[a].getText());
					s.atk2 = s.sunsudb.getAtk();
					s.def2 = s.sunsudb.getDef();
					s.tectics2 = s.sunsudb.getTectics();
					s.sense2 = s.sunsudb.getSense();
					s.supply2 = s.sunsudb.getSupply();
					s.control2 = s.sunsudb.getControl();
					s.type2 = s.sunsudb.getType();
					s.recon2 = s.sunsudb.getRecon();
					s.keep2 = s.sunsudb.getKeep();
					s.grade2 = s.sunsudb.getGrade();
					if(s.Mysunsulabel[a].getText().equals("Hidden")) {
						draw1.setVisible(false);
					}
					else {
					draw1.setVisible(true);
					}
					draw1.repaint();
//					s.statlabel2.setVisible(true);
//					
//					s.statlabel2.setText("<html><body><center>공격력: " + s.atk2 + "<br>수비력: " + s.def2 + "<br>전략: "
//							+ s.tectics2 + "<br>센스: " + s.sense2 + "<br>물량: " + s.supply2 + "<br>컨트롤: " + s.control2
//							+ "<br>견제: " + s.keep2 + "<br>정찰: " + s.recon2
//							+"<br>종족: " + s.type2 + "</center></body></html>");

					s.sunsu1name.setText(s.Mysunsulabel[a].getText());
					s.sunsu1name.setForeground(Color.white);
					s.sunsu2name.setText(s.Yoursunsulabel[a].getText());
					s.sunsu2name.setForeground(Color.white);

				}
			});
			c.add(s.setbtn1[i]);

		}
		
		System.out.println("승리카운트" + wincount);
		System.out.println("세트" + count);

		for(int i =0; i<7; i++) {
			s.Mysunsulabel[i].setBounds(350, 350 + (70 * i), 100, 30);
			s.Mysunsulabel[i].setFont(new Font("출전선수", Font.ITALIC, 20));
			s.Mysunsulabel[i].setForeground(Color.white);
			
			s.Yoursunsulabel[i].setBounds(750, 350 + (70 * i), 100, 30);
			s.Yoursunsulabel[i].setFont(new Font("출전선수", Font.ITALIC, 20));
			s.Yoursunsulabel[i].setForeground(Color.white);
		}
		JButton strBtn1 = new JButton("시작");

		
		s.Mysunsulabel[count].setText(s.Myentry[losecount]);
//		s.Mysunsulabel[count].setBounds(350, 350 + (70 * s.count1), 100, 30);
//		s.Mysunsulabel[count].setFont(new Font("출전선수", Font.ITALIC, 20));
//		s.Mysunsulabel[count].setForeground(Color.white);

		
		s.Yoursunsulabel[count].setText(s.Yourentry[wincount]);
//		s.Yoursunsulabel[count].setBounds(750, 350 + (70 * s.count1), 100, 30);
//		s.Yoursunsulabel[count].setFont(new Font("출전선수", Font.ITALIC, 20));
//		s.Yoursunsulabel[count].setForeground(Color.white);

		s.MysunsuImage[count] = new ImageIcon("images/" + s.Mysunsulabel[count].getText() + ".gif");
		s.YoursunsuImage[count] = new ImageIcon("images/" + s.Yoursunsulabel[wincount].getText() + ".gif");

		for(int i =0; i<7; i++) {
		c.add(s.Mysunsulabel[i]);
		c.add(s.Yoursunsulabel[i]);
		}
		MyImage.setIcon(s.MysunsuImage[count]);
		MyImage.setBounds(130, 380, 100, 100);
		YourImage.setIcon(s.YoursunsuImage[count]);
		YourImage.setBounds(970, 380, 100, 100);

		s.sunsudb.data(s.Mysunsulabel[count].getText());
		s.atk1 = s.sunsudb.getAtk();
		s.def1 = s.sunsudb.getDef();
		s.tectics1 = s.sunsudb.getTectics();
		s.sense1 = s.sunsudb.getSense();
		s.supply1 = s.sunsudb.getSupply();
		s.control1 = s.sunsudb.getControl();
		s.type1 = s.sunsudb.getType();
		s.recon1 = s.sunsudb.getRecon();
		s.keep1 = s.sunsudb.getKeep();
		s.grade1 = s.sunsudb.getGrade();
		s.draw.repaint();
		s.draw.setVisible(true);
		s.draw.setBounds(70, 520, 200, 200);
		c.add(s.draw);
//		s.statlabel.setVisible(true);
//		
//		s.statlabel.setText("<html><body><center>공격력: " + s.atk1 + "<br>수비력: " + s.def1 + "<br>전략: "
//				+ s.tectics1 + "<br>센스: " + s.sense1 + "<br>물량: " + s.supply1 + "<br>컨트롤: " + s.control1
//				+ "<br>견제: " + s.keep1 + "<br>정찰: " + s.recon1
//				+"<br>종족: " + s.type1 + "</center></body></html>");
//
//		s.statlabel.setForeground(Color.white);
//		s.statlabel.setBackground(Color.black);
//		s.statlabel.setBounds(130, 500, 150, 150);
//		c.add(s.statlabel);

		s.sunsudb.data(s.Yoursunsulabel[count].getText());
		s.atk2 = s.sunsudb.getAtk();
		s.def2 = s.sunsudb.getDef();
		s.tectics2 = s.sunsudb.getTectics();
		s.sense2 = s.sunsudb.getSense();
		s.supply2 = s.sunsudb.getSupply();
		s.control2 = s.sunsudb.getControl();
		s.type2 = s.sunsudb.getType();
		s.recon2 = s.sunsudb.getRecon();
		s.keep2 = s.sunsudb.getKeep();
		s.grade2 = s.sunsudb.getGrade();
		draw1.repaint();
		draw1.setVisible(true);
		draw1.setBounds(910, 520, 200, 200);
		c.add(draw1);
//		s.statlabel2.setVisible(true);
//		
//		s.statlabel2.setText("<html><body><center>공격력: " + s.atk2 + "<br>수비력: " + s.def2 + "<br>전략: "
//				+ s.tectics2 + "<br>센스: " + s.sense2 + "<br>물량: " + s.supply2 + "<br>컨트롤: " + s.control2
//				+ "<br>견제: " + s.keep2 + "<br>정찰: " + s.recon2
//				+"<br>종족: " + s.type2 + "</center></body></html>");
//
//		s.statlabel2.setForeground(Color.white);
//		s.statlabel2.setBackground(Color.black);
//		s.statlabel2.setBounds(970, 500, 150, 150);
//		c.add(s.statlabel2);

		Map currentMap = new Map();
		currentMap.data(s.NewMap.get(count));
		s.Mapdatalabel
				.setText("<html><body><center>" + s.NewMap.get(count) + "<br>T:Z " + currentMap.getMyTerranwinrate()
						+ ":" + currentMap.getYourZergwinrate() + "<br>Z:P " + currentMap.getMyZergwinrate() + ":"
						+ currentMap.getYourProtosswinrate() + "<br>P:T " + currentMap.getMyProtosswinrate() + ":"
						+ currentMap.getYourTerranwinrate() + "</center></body></html>");
		s.Mapdatalabel.setFont(new Font("맵 정보", Font.ITALIC, 17));
		s.Mapdatalabel.setForeground(Color.white);
		s.Mapdatalabel.setBounds(630, 150, 200, 200);
		ImageIcon icon = new ImageIcon("images/맵/" + s.NewMap.get(count) + ".gif");
		s.Mapla.setIcon(icon);
		s.Mapla.setBounds(480, 150, 200, 200);

		s.sunsu1name.setText(s.Myentry[losecount]);
		s.sunsu1name.setForeground(Color.white);
		s.sunsu2name.setText(s.Yourentry[wincount]);
		s.sunsu2name.setForeground(Color.white);

		s.sunsu1name.setBounds(150, 450, 100, 100);

		s.sunsu2name.setBounds(1000, 450, 100, 100);

		for (int i = 0; i < 6; i++) {

			s.winLabel1[i].setBounds(450, 350 + (i * 70), 100, 30);
			s.loseLabel1[i].setBounds(850, 350 + (i * 70), 100, 30);

			c.add(s.winLabel1[i]);
			c.add(s.loseLabel1[i]);
		}

		PvP.setFont(new Font("PvP", Font.PLAIN, 70));
		PvP.setForeground(Color.white);
		PvP.setBounds(360, 0, 600, 200);
		PvP.setText(wincount + "           :           " + losecount);

		strBtn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				s.Text.setText("");// 문자중계 초기화
				setVisible(false);
				dispose();
				s.answer = false;
				if (count == s.snipercount && s.Yourentry[s.snipercount].equals(s.sniperitem)) {
					s.answer = true;
				}

				new winnersBattle(f, Myteam, s.Mysunsulabel[count].getText(), s.Yoursunsulabel[count].getText(), wincount, losecount, count);

//				else if(s.postmode || s.seasonmode) {
//					new Battle(f,Myteam, s.Myentry[count], s.Yourentry[count], wincount, losecount, count);
//				}
//				else if(s.tonerment) {
//					new twelveBattle(f,Myteam, s.Myentry[count], s.Yourentry[count], wincount, losecount, count);
//				}

			}
		});

		int k = 0;
		if (s.wincount == 0) {
			k = s.num[0];
		}
		if (s.wincount == 1) {
			k = 12;
		} else if (s.wincount == 2) {
			k = 18;
		} else if (s.wincount == 3) {
			k = 19;
		}

		ImageIcon team = new ImageIcon("images/로고/" + Myteam + ".gif");
		ImageIcon team1 = null;
		if (s.postmode) {
			team1 = new ImageIcon("images/로고/" + s.NewTeam.get(s.num[s.wincount]) + ".gif");
		}
		if (s.tonerment) {
			team1 = new ImageIcon("images/로고/" + s.NewTeam.get(k) + ".gif");
		}
		if (s.seasonmode) {
			team1 = new ImageIcon("images/로고/" + s.yourteam.get(s.game) + ".gif");
		}
		JLabel myteam = new JLabel();
		JLabel yourteam = new JLabel();
		myteam.setIcon(team);
		yourteam.setIcon(team1);
		myteam.setBounds(130, 30, 150, 150);
		yourteam.setBounds(950, 30, 150, 150);

		resetBtn.setBounds(0, 0, 50, 50);
		strBtn1.setBounds(550, 900, 100, 30);

		c.add(s.Mapdatalabel);
		c.add(s.Mapla);
		c.add(s.sunsu1name);
		c.add(s.sunsu2name);
		c.add(myteam);
		c.add(yourteam);
		c.add(PvP);
		c.add(winLabel);
		c.add(loseLabel);
		c.add(MyImage);
		c.add(YourImage);
		c.add(strBtn1);
		c.add(resetBtn);
		setSize(1200, 1000);
		setVisible(true);
	}

}
