package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.sql.*;
import java.util.Random;

class AceFrame extends JFrame {

	private JButton resetBtn = new JButton("R");
	private ImageIcon myACEcard;
	private JLabel sunsu1 = new JLabel();
	private JLabel sunsu1name = new JLabel();
	private JLabel sunsu2 = new JLabel();
	private JLabel sunsu2name = new JLabel();
	private JLabel acelabel = new JLabel();
	private JPanel sunsupanel1 = new JPanel();
	

	public AceFrame(JFrame f,String Myteam) {
		setTitle("Mystarcraft");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.black);
		setResizable(false);
		ProjectMain s = (ProjectMain)f;

		ImageIcon aceIcon = new ImageIcon("Images/라벨.PNG");// 장식
		
		acelabel.setIcon(aceIcon);
		acelabel.setBounds(490, 350, 180, 400);
		c.add(acelabel);

		
		s.draw = new Drawlabel(f);
		s.draw.setLayout(null);
		Drawlabel2 draw1 = new Drawlabel2(f);
		draw1.setLayout(null);
		
		s.sunsupanel.setLayout(null);
		s.sunsupanel.setBounds(280,330,205,460);
		s.sunsupanel.add(s.member1JList);
		s.sunsupanel.setBackground(Color.black);
		s.sunsupanel.setBorder(new TitledBorder(new LineBorder(Color.white, 3),"선수들",2,0,new Font("",Font.BOLD,20),Color.white));
		s.member1JList.setBounds(25, 30, 150, 400);
		
		s.sunsu1.setBounds(120, 380, 100, 100);
		s.sunsu1name.setBounds(140, 450, 100, 100);
		s.draw.setBounds(55, 520, 200, 200);
		draw1.setBounds(910, 520, 200, 200);
//		s.statlabel.setBounds(120, 500, 150, 150);
		

		JPanel MapPanel = new JPanel();
		MapPanel.setLayout(null);
		MapPanel.setBounds(440,160,320,160);
		MapPanel.add(s.Mapla);
		MapPanel.add(s.Mapdatalabel);
		MapPanel.setBackground(Color.black);
		MapPanel.setBorder(new TitledBorder(new LineBorder(Color.white, 3),"맵 정보",2,0,new Font("",Font.BOLD,20),Color.white));
		add(MapPanel);
		
		Map currentMap = new Map();
		currentMap.data(s.NewMap.get(4));
		s.Mapdatalabel.setText("<html><body><center>" + s.NewMap.get(4) + "<br>T:Z " + currentMap.getMyTerranwinrate()
				+ ":" + currentMap.getYourZergwinrate() + "<br>Z:P " + currentMap.getMyZergwinrate() + ":"
				+ currentMap.getYourProtosswinrate() + "<br>P:T " + currentMap.getMyProtosswinrate() + ":"
				+ currentMap.getYourTerranwinrate() + "</center></body></html>");
		s.Mapdatalabel.setFont(new Font("맵 정보", Font.ITALIC, 17));
		s.Mapdatalabel.setForeground(Color.white);
		s.Mapdatalabel.setBounds(180, -20, 200, 200);
		ImageIcon icon = new ImageIcon("images/맵/" + s.NewMap.get(4) + ".gif");
		s.Mapla.setIcon(icon);
		s.Mapla.setBounds(30, -20, 200, 200);

		

		JButton strBtn1 = new JButton("시작");
		strBtn1.setEnabled(false);
		myACEcard = new ImageIcon("Images/ACE.gif");
		ImageIcon yourACEcard = new ImageIcon("Images/ACE.gif");

		sunsu1.setIcon(myACEcard);
		sunsu1name.setText("ACE");
		sunsu1name.setForeground(Color.white);
		s.draw.setVisible(false);
		draw1.setVisible(false);
//		s.statlabel.setVisible(false);
//		s.statlabel2.setVisible(false);
		sunsu2.setIcon(myACEcard);
		sunsu2name.setText("ACE");
		sunsu2name.setForeground(Color.white);

		s.member1JList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				JList jl = (JList) e.getSource();
				String name = (String) jl.getSelectedValue();
				String name1 = name.trim();
				s.draw.setVisible(true);
//				s.statlabel.setVisible(true);
				s.Myentry[4] = name1;
				myACEcard = new ImageIcon("images/" + name1 + ".gif");

				Connection conn;
				Statement stmt = null;

				
				s.sunsudb.data(name1);
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
//				s.statlabel.setVisible(true);
				
//				s.statlabel.setText("<html><body><center>공격력: " + s.atk1 + "<br>수비력: " + s.def1 + "<br>전략: "
//						+ s.tectics1 + "<br>센스: " + s.sense1 + "<br>물량: " + s.supply1 + "<br>컨트롤: " + s.control1
//						+ "<br>견제: " + s.keep1 + "<br>정찰: " + s.recon1
//						+"<br>종족: " + s.type1 + "</center></body></html>");
//
//				s.statlabel.setForeground(Color.white);
//				s.statlabel.setBackground(Color.black);

				sunsu1.setIcon(myACEcard);
				sunsu1name.setText(name1);
				sunsu1name.setForeground(Color.white);
				strBtn1.setEnabled(true);

			}
		});
		
		sunsupanel1.setLayout(null);
		sunsupanel1.setBounds(700,330,205,460);
		sunsupanel1.add(s.anotherTeamJList);
		sunsupanel1.setBackground(Color.black);
		sunsupanel1.setBorder(new TitledBorder(new LineBorder(Color.white, 3),"선수들",2,0,new Font("",Font.BOLD,20),Color.white));
		s.anotherTeamJList.setBounds(25, 30, 150, 400);
		s.anotherTeamJList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				JList jl = (JList) e.getSource();
				String name = (String) jl.getSelectedValue();
				String name1 = name.trim();

				s.Yourentry[4] = name1;
				draw1.setVisible(true);
//				s.statlabel2.setVisible(true);
				ImageIcon icon = new ImageIcon("images/" + name1 + ".gif");

				sunsu2.setIcon(icon);

				sunsu2name.setText(name1);
				sunsu2name.setForeground(Color.white);

				s.sunsudb.data(name1);
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
////				s.statlabel2.setVisible(true);
//				
////				s.statlabel2.setText("<html><body><center>공격력: " + s.atk2 + "<br>수비력: " + s.def2 + "<br>전략: "
//						+ s.tectics2 + "<br>센스: " + s.sense2 + "<br>물량: " + s.supply2 + "<br>컨트롤: " + s.control2
//						+ "<br>견제: " + s.keep2 + "<br>정찰: " + s.recon2
//						+"<br>종족: " + s.type2 + "</center></body></html>");
//
//				s.statlabel2.setForeground(Color.white);
//				s.statlabel2.setBackground(Color.black);

			}
		});

		resetBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				dispose();
				new ProjectMain();
			}
		});

		strBtn1.setBounds(550, 900, 100, 30);
		strBtn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Random random = new Random();
				int a = random.nextInt(s.v1.size());
				s.yourACECARD = s.v1.get(a).trim();
				s.sunsudb.data(s.yourACECARD);
				while(s.sunsudb.getSum()<=5200) {
					
					a = random.nextInt(s.v1.size());
					s.yourACECARD = s.v1.get(a).trim();
					s.sunsudb.data(s.yourACECARD);
				}
				String MyAceCard = (String)s.member1JList.getSelectedValue();
				s.ACECARD = MyAceCard.trim();
				setVisible(false);
//				new Battle(Myteam, ACECARD, yourACECARD, 2, 2, 5);
				new gameFrame(f,Myteam, 4, 2, 2);
				System.out.print(s.Myentry[4]);
				System.out.print(s.Yourentry[4]);

			}
		});
		JLabel PvP = new JLabel();
		PvP.setFont(new Font("PvP", Font.PLAIN, 70));
		PvP.setForeground(Color.white);
		PvP.setBounds(360, 0, 600, 200);
		PvP.setText(2 + "           :           " + 2);

		int k = 0;
		if(s.wincount == 0) {
			k = s.num[0];
		}
		if(s.wincount == 1) {
			k = 12;
		}
		else if(s.wincount == 2) {
			k = 18;
		}
		else if(s.wincount == 3) {
			k = 19;
		}

		ImageIcon team = new ImageIcon("images/로고/" + Myteam + ".gif");
		ImageIcon team1 = null;
		if(s.postmode) {
			team1 = new ImageIcon("images/로고/" + s.NewTeam.get(s.num[s.wincount]) + ".gif");
		}
		if(s.tonerment) {
			team1 = new ImageIcon("images/로고/" + s.NewTeam.get(k) + ".gif");
		}
		if(s.seasonmode) {
			team1 = new ImageIcon("images/로고/" + s.yourteam.get(s.game) + ".gif");
		}
		JLabel myteam = new JLabel();
		JLabel yourteam = new JLabel();
		myteam.setIcon(team);
		yourteam.setIcon(team1);
		myteam.setBounds(130, 30, 150, 150);
		yourteam.setBounds(950, 30, 150, 150);
		c.add(myteam);
		c.add(yourteam);

		sunsu1.setBounds(120, 380, 100, 100);
		sunsu1name.setBounds(160, 450, 100, 100);
		sunsu2.setBounds(960, 380, 100, 100);
		sunsu2name.setBounds(990, 450, 100, 100);
		c.add(PvP);
//		c.add(s.statlabel);
//		c.add(s.statlabel2);
		c.add(draw1);
		c.add(s.draw);
		c.add(sunsu1);
		c.add(sunsu1name);
		c.add(sunsu2);
		c.add(sunsu2name);
		c.add(sunsupanel1);
		c.add(s.sunsupanel);
		c.add(strBtn1);
		setSize(1200, 1000);
		setVisible(true);

	}
}