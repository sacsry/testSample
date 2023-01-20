package ProJect;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class ProjectMain extends JFrame {
	private String Team[] = { "KT 롤스터", "SK 텔레콤 T1", "화승 OZ", "하이트 스파키즈", "MBC게임 히어로", "CJ 엔투스", "삼성전자 칸", "STX 소울",
			"웅진 스타즈", "eStrO", "위메이드 FOX", "공군 ACE" };
	
	private ArrayList<String> NewTeam;
	private ArrayList<String> NewMap;
	private JLabel la = new JLabel("팀을 선택해주세요!");
	private JComboBox<String> TeamCombo = new JComboBox<String>(Team);

	private JButton[] setbtn = new JButton[5];
	private JLabel[] setlabel = new JLabel[5];

	private JLabel[] winLabel1 = new JLabel[6];
	private JLabel[] loseLabel1 = new JLabel[6];

	private String Myentry[] = new String[5];
	private String Yourentry[] = new String[5];

	private int num[] = new int[3];
	private int num2[] = new int[4];
	
	private Vector<String> v = new Vector<String>();
	private Vector<String> v1 = new Vector<String>();
	private JList<String> member1JList = new JList<String>(v);
	private JLabel logolabel = new JLabel();

	private JLabel la1 = new JLabel();
	private JLabel la2 = new JLabel();

	private JPanel page1 = new JPanel();
	private int wincount1;
	private int losecount1;
	private int count1;

	private int grade = 4;
	private int a = 0;
	private int Victorycount = 0;
	String yourACECARD = "ACE";
	String ACECARD = "ACE";
	
	private JLabel[] winla = new JLabel[2]; 
	private JLabel[] losela = new JLabel[2];
	
	private JList anotherTeamJList = new JList();

	String type1;
	int atk1;
	int def1;
	int control1;
	int tectics1;
	int sense1;
	int supply1;
	String grade1;
	int sum1 ;

	String type2;
	int atk2;
	int def2;
	int control2;
	int tectics2;
	int sense2;
	int supply2;
	int sum2 ;
	String grade2;
	
	int sum3 ;

	private JLabel statlabel = new JLabel();
	private JLabel statlabel2 = new JLabel();
	
	private JLabel Mapla = new JLabel();
	private JLabel Mapdatalabel = new JLabel();

	private JTextArea Text = new JTextArea();

	
	boolean WIN ;
	boolean Lose;
	
	public ProjectMain() {
		JButton resetBtn = new JButton("R");
		Victorycount = 0;
		for(int i = 0; i<2;i++) {
			winla[i] = new JLabel("");
			losela[i] = new JLabel("");
			}
		setTitle("MyStarCraft");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setResizable(false);

		Container c = getContentPane();
		c.setBackground(Color.black);
		c.setLayout(null);

		statlabel.setBounds(600, 370, 150, 150);
		c.add(statlabel);

		for (int i = 0; i < 6; i++) {

			winLabel1[i] = new JLabel("");
			loseLabel1[i] = new JLabel("");
		}

		// 팀선택창

		TeamCombo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				JComboBox<String> t = (JComboBox<String>) e.getSource();
				Object Item = t.getSelectedItem();

				try {
					String str;
					BufferedReader br = new BufferedReader(
							new FileReader("C:\\Users\\tj-bu-12\\Desktop\\" + Item + ".txt")); // 불러올 파일이름
					v.clear();
					while ((str = br.readLine()) != null) {


						v.add(str + "\n");
						member1JList.setListData(v);

					}

					br.close();

				} catch (IOException e2) {
					e2.printStackTrace();
				}
				ImageIcon icon = new ImageIcon("images/로고/" + Item + ".gif");
				logolabel.setIcon(icon);

			}

		});

		//

		// 버튼 리스너

		JButton strBtn = new JButton("시작");

		strBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				randomteam();
				NewTeam = new ArrayList<String>();
				for (String temp : Team) {
					if (!temp.equals(TeamCombo.getSelectedItem()))
						NewTeam.add(temp);
				}

				setVisible(false);
				dispose();
				new YourFrame((String) TeamCombo.getSelectedItem());

			}
		});
		//

		// JList

		member1JList.setBounds(300, 150, 200, 400);
		MyMouseListener listener = new MyMouseListener();
		member1JList.addMouseListener(listener);
		//

		la1.setBounds(600, 200, 200, 200);
		la2.setBounds(630, 280, 200, 200);
		strBtn.setBounds(350, 600, 100, 30);
		resetBtn.setBounds(0, 0, 50, 50);
		la.setFont(new Font("팀 선택", Font.ITALIC, 40));
		la.setForeground(Color.white);
		la.setBounds(235, 0, 500, 100);
		TeamCombo.setBounds(300, 100, 200, 30);

		ImageIcon logo = new ImageIcon("images/로고/logo.gif");
//		Image img = logo.getImage();
//		Image changeImg = img.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
//		ImageIcon changelogo = new ImageIcon(changeImg);

		logolabel.setIcon(logo);
		logolabel.setBounds(100, 150, 300, 300);
		ImageIcon icon = new ImageIcon("images/로고/Logo2.gif");
		la1.setIcon(icon);
		c.add(logolabel);
		c.add(la);
		c.add(TeamCombo);
		c.add(resetBtn);
		c.add(member1JList);
		c.add(la2);
		c.add(la1);
		c.add(strBtn);

		setSize(800, 800);
		setVisible(true);

	}

	class MyMouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			JList jl = (JList) e.getSource();
			String name = (String) jl.getSelectedValue();
			String name1 = name.trim();

			ImageIcon icon = new ImageIcon("images/" + name1 + ".gif");

			la1.setIcon(icon);
			la2.setText(name);
			la2.setForeground(Color.white);

			Connection conn;
			Statement stmt = null;

			sunsu a = new sunsu(name1);
			a.data();
			atk1 = a.getAtk();
			def1 = a.getDef();
			tectics1 = a.getTectics();
			sense1 = a.getSense();
			supply1 = a.getSupply();
			control1 = a.getControl();
			type1 = a.getType();
			
			statlabel.setVisible(true);
			statlabel.setText("<html><body><center>공격력: " + atk1 + "<br>수비력: " + def1 + "<br>전략: " + tectics1
					+ "<br>센스: " + sense1 + "<br>물량: " + supply1 + "<br>컨트롤: " + control1 + "<br>종족: " + type1 + "</center></body></html>");

			statlabel.setForeground(Color.white);
			statlabel.setBackground(Color.black);

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ProjectMain();
	}
///////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////////	
	class DrawPanel extends JPanel {
		JLabel la = new JLabel();
		JLabel victoryla = new JLabel(Victorycount +"회 연속 우승");
		int wincount2;
		int losecount2;

		public void paint(Graphics g) {
			super.paint(g);
			setLayout(null);
			la.setText("준플레이오프");
			
			
			for(int i = 0; i<2; i++) {
			winla[i].setFont(new Font("승리 카운트", Font.ITALIC, 20));
			losela[i].setFont(new Font("승리 카운트", Font.ITALIC, 20));
			winla[i].setForeground(Color.WHITE);
			losela[i].setForeground(Color.WHITE);
			}
			
			
			g.setColor(Color.GREEN);
			g.drawLine(160, 750, 160, 550);
			g.setColor(Color.gray);
			if (a == 2) {
				la.setText("결승");
				g.setColor(Color.green);
				winla[1].setText(wincount1+"");
				losela[1].setText(losecount1+"");
				winla[0].setBounds(280,500,50,50);
				losela[0].setBounds(330,500,50,50);
				winla[1].setBounds(505,360,50,50);
				losela[1].setBounds(555,360,50,50);
			}
			g.drawLine(535, 400, 535, 250);
			g.drawLine(310, 400, 535, 400);
			if (a == 1) {
				wincount2 = wincount1;
				losecount2 = losecount1;
				la.setText("플레이오프");
				g.setColor(Color.green);
				winla[0].setText(wincount2+"");
				losela[0].setText(losecount2+"");
				winla[0].setBounds(280,500,50,50);
				losela[0].setBounds(330,500,50,50);
			}
			g.drawLine(160, 550, 310, 550);
			g.drawLine(310, 550, 310, 400);
			g.setColor(Color.WHITE);
			g.drawLine(460, 750, 460, 550);
			g.drawLine(760, 750, 760, 400);
			g.setColor(Color.gray);
			g.drawLine(310, 550, 460, 550);
			g.drawLine(760, 400, 535, 400);
			g.drawLine(535, 250, 1060, 250);
			g.setColor(Color.WHITE);
			g.drawLine(1060, 750, 1060, 250);
			victoryla.setBounds(700,100,300,150);
			victoryla.setFont(new Font("우승", Font.ITALIC, 30));
			victoryla.setForeground(Color.green);
			la.setBounds(400, 0, 500, 150);
			la.setFont(new Font("포스트시즌", Font.ITALIC, 50));
			la.setForeground(Color.WHITE);
			add(winla[0]);
			add(losela[0]);
			add(winla[1]);
			add(losela[1]);
			add(victoryla);
			add(la);
		}
	}

	class YourFrame extends JFrame {

		private JButton resetBtn = new JButton("R");

		public YourFrame(String Myteam) {
			
			
			setTitle("Mystarcraft");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c = getContentPane();
			c.setLayout(null);
			c.setBackground(Color.black);

			DrawPanel panel = new DrawPanel();
			panel.setBackground(Color.black);
			panel.setBounds(0, 0, 1200, 700);
			c.add(panel);
			resetBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
					new ProjectMain();
				}
			});
			JButton strBtn1 = new JButton("시작");
			strBtn1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					setVisible(false);
					dispose();
					new EntryFrame(Myteam);

				}
			});

			ImageIcon team = new ImageIcon("images/로고/" + Myteam + ".gif");
			ImageIcon team1 = new ImageIcon("images/로고/" + NewTeam.get(num[0]) + ".gif");
			ImageIcon team2 = new ImageIcon("images/로고/" + NewTeam.get(num[1]) + ".gif");
			ImageIcon team3 = new ImageIcon("images/로고/" + NewTeam.get(num[2]) + ".gif");

			JLabel teamLabel = new JLabel();
			teamLabel.setIcon(team);
			JLabel teamLabel1 = new JLabel();
			teamLabel1.setIcon(team1);
			JLabel teamLabel2 = new JLabel();
			teamLabel2.setIcon(team2);
			JLabel teamLabel3 = new JLabel();
			teamLabel3.setIcon(team3);

			teamLabel.setBounds(100, 700, 150, 100);
			teamLabel1.setBounds(400, 700, 150, 100);
			teamLabel2.setBounds(700, 700, 150, 100);
			teamLabel3.setBounds(1000, 700, 150, 100);
			resetBtn.setBounds(0, 0, 50, 50);
			strBtn1.setBounds(550, 900, 100, 30);

			c.add(teamLabel);
			c.add(teamLabel1);
			c.add(teamLabel2);
			c.add(teamLabel3);
			c.add(strBtn1);
			c.add(resetBtn);
			setSize(1200, 1000);
			setVisible(true);
		}

	}
/////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////
	class EntryFrame extends JFrame {
		private JButton resetBtn = new JButton("R");

		public EntryFrame(String Myteam) {
			wincount1 = 0;
			losecount1 = 0;
			count1 = 0;
			Mapla.setVisible(false);
			Mapdatalabel.setVisible(false);
			setTitle("Mystarcraft");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c = getContentPane();
			c.setLayout(null);
			c.setBackground(Color.black);
			
			MapChoice choice = new MapChoice();
			NewMap = choice.getNewMap();
			
			
			for (int i = 0; i < 5; i++) {
				setbtn[i] = new JButton(NewMap.get(i));
				setbtn[i].setBounds(550, 350 + (70 * i), 100, 30);
				c.add(setbtn[i]);

			}

			
			for (int i = 0; i < 4; i++) {
				setlabel[i] = new JLabel("empty");
				setlabel[i].setForeground(Color.white);
				setlabel[i].setFont(new Font("선수이름", Font.ITALIC, 15));
				setlabel[i].setBounds(550, 380 + (70 * i), 100, 30);
				c.add(setlabel[i]);
				int a = i;
				
				
				setbtn[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						
						Map currentMap = new Map(NewMap.get(a));
						currentMap.data();
						Mapla.setVisible(true);
						Mapdatalabel.setVisible(true);
						Mapdatalabel.setText("<html><body><center>"+NewMap.get(a)+"<br>T:Z " + currentMap.getMyTerranwinrate() +":"+currentMap.getYourZergwinrate()+ 
								"<br>Z:P " + currentMap.getMyZergwinrate() +":"+currentMap.getYourProtosswinrate()+ 
								"<br>P:T " + currentMap.getMyProtosswinrate() +":"+currentMap.getYourTerranwinrate()
								+ "</center></body></html>");
						Mapdatalabel.setFont(new Font("맵 정보", Font.ITALIC, 17));
						Mapdatalabel.setForeground(Color.white);
						Mapdatalabel.setBounds(630, 150, 200, 200);
						ImageIcon icon = new ImageIcon("images/맵/" + NewMap.get(a) + ".gif");
						Mapla.setIcon(icon);
						Mapla.setBounds(480,150, 200, 200);
						setlabel[a].setText(member1JList.getSelectedValue());
					}
				});
			}
			setbtn[4].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Map currentMap = new Map(NewMap.get(4));
					currentMap.data();
					Mapdatalabel.setText("<html><body><center>"+NewMap.get(4)+"<br>T:Z " + currentMap.getMyTerranwinrate() +":"+currentMap.getYourZergwinrate()+ 
							"<br>Z:P " + currentMap.getMyZergwinrate() +":"+currentMap.getYourProtosswinrate()+ 
							"<br>P:T " + currentMap.getMyProtosswinrate() +":"+currentMap.getYourTerranwinrate()
							+ "</center></body></html>");
					Mapdatalabel.setFont(new Font("맵 정보", Font.ITALIC, 17));
					Mapdatalabel.setForeground(Color.white);
					Mapdatalabel.setBounds(630, 150, 200, 200);
					ImageIcon icon = new ImageIcon("images/맵/" + NewMap.get(4) + ".gif");
					Mapla.setIcon(icon);
					Mapla.setBounds(480,150, 200, 200);
				}
			});
			c.add(Mapla);
			c.add(Mapdatalabel);

			JLabel finalLabel = new JLabel("ACE");
			finalLabel.setFont(new Font("선수이름", Font.ITALIC, 15));

			
			
			resetBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
					new ProjectMain();
				}
			});

			JButton jb = new JButton("엔트리 제출");
			jb.setBounds(545, 810, 150, 40);
			JButton strBtn1 = new JButton("시작");
			strBtn1.setEnabled(false);
			jb.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					for (int i = 0; i < 4; i++) {
						for (int j = i + 1; j < 4; j++) {
							if ((setlabel[i].getText()).equals(setlabel[j].getText())) {
								strBtn1.setEnabled(false);
								strBtn1.setText("선수가 중복되었습니다");
								return;
							}
							if ((setlabel[j].getText()).equals("empty")) {
								strBtn1.setEnabled(false);
								strBtn1.setText("선수가 비어있습니다.");
								return;

							} else {
								strBtn1.setEnabled(true);
								strBtn1.setText("경기 시작");
							}

						}

					}

					randomentry();
					for (int i = 0; i < num2.length; i++) {

						String yourentry = v1.get(num2[i]).trim();
						Yourentry[i] = yourentry;

					}

				}
			});

			strBtn1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					for (int i = 0; i < 4; i++) {
						String a = setlabel[i].getText().trim();
						Myentry[i] = a;

					}

					setVisible(false);
					dispose();
					new gameFrame(Myteam, 0, 0, 0);

				}
			});

			anotherTeamJList.setBounds(700, 350, 150, 400);
			member1JList.setBounds(350, 350, 150, 400);
			JLabel sunsu1 = new JLabel();
			JLabel sunsu1name = new JLabel();

			member1JList.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {

					JList jl = (JList) e.getSource();
					String name = (String) jl.getSelectedValue();
					String name1 = name.trim();

					ImageIcon icon = new ImageIcon("images/" + name1 + ".gif");

					sunsu1.setIcon(icon);
					sunsu1name.setText(name1);
					sunsu1name.setForeground(Color.white);

				}
			});

			JLabel sunsu2 = new JLabel();
			JLabel sunsu2name = new JLabel();

			anotherTeamJList.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {

					JList jl = (JList) e.getSource();
					String name = (String) jl.getSelectedValue();
					String name1 = name.trim();

					ImageIcon icon = new ImageIcon("images/" + name1 + ".gif");

					sunsu2.setIcon(icon);

					sunsu2name.setText(name1);
					sunsu2name.setForeground(Color.white);

					sunsu a = new sunsu(name1);
					a.data();
					atk2 = a.getAtk();
					def2 = a.getDef();
					tectics2 = a.getTectics();
					sense2 = a.getSense();
					supply2 = a.getSupply();
					control2 = a.getControl();
					type2 = a.getType();

					statlabel2.setVisible(true);
					statlabel2.setText("<html><body><center>공격력: " + atk2 + "<br>수비력: " + def2 + "<br>전략: " + tectics2
							+ "<br>센스: " + sense2 + "<br>물량: " + supply2 + "<br>컨트롤: " + control2+ "<br>종족: " + type2
							+ "</center></body></html>");

					statlabel2.setForeground(Color.white);
					statlabel2.setBackground(Color.black);

				}
			});

			finalLabel.setBounds(550, 660, 100, 30);

			try {
				String str;
				BufferedReader br = new BufferedReader(
						new FileReader("C:\\Users\\tj-bu-12\\Desktop\\" + NewTeam.get(num[a]) + ".txt")); // 불러올 파일이름
				v1.clear();
				while ((str = br.readLine()) != null) {

//					ImageIcon icon = new ImageIcon("images/로고/" + NewTeam.get(num[a]) + ".gif");
//					logolabel.setIcon(icon);
					v1.add(str + "\n");
					anotherTeamJList.setListData(v1);

				}

				br.close();

			} catch (IOException e2) {
				e2.printStackTrace();
			}

			ImageIcon team = new ImageIcon("images/로고/" + Myteam + ".gif");

			JLabel teamLabel = new JLabel();
			teamLabel.setIcon(team);
			teamLabel.setBounds(100, 30, 150, 100);

			ImageIcon team1 = new ImageIcon("images/로고/" + NewTeam.get(num[a]) + ".gif");
			JLabel yourteam = new JLabel();
			yourteam.setIcon(team1);
			yourteam.setBounds(950, 30, 150, 100);

			resetBtn.setBounds(0, 0, 50, 50);
			strBtn1.setBounds(520, 850, 200, 40);
			sunsu1.setBounds(120, 380, 100, 100);
			sunsu1name.setBounds(140, 450, 100, 100);
			sunsu2.setBounds(960, 380, 100, 100);
			sunsu2name.setBounds(990, 450, 100, 100);

			JLabel PvP = new JLabel();
			PvP.setText("0           :           0");
			PvP.setFont(new Font("PvP", Font.PLAIN, 70));
			PvP.setForeground(Color.white);
			PvP.setBounds(360, 0, 600, 200);
			
			c.add(PvP);
			statlabel.setVisible(false);
			statlabel2.setVisible(false);
			statlabel.setBounds(120, 500, 150, 150);
			statlabel2.setBounds(960, 500, 150, 150);
			c.add(statlabel2);
			
			c.add(statlabel);
			c.add(yourteam);
			c.add(teamLabel);
			c.add(sunsu1name);
			c.add(sunsu1);
			c.add(sunsu2name);
			c.add(sunsu2);
			c.add(finalLabel);
			c.add(jb);
			c.add(anotherTeamJList);
			c.add(member1JList);
			c.add(strBtn1);
			c.add(resetBtn);
			setSize(1200, 1000);
			setVisible(true);
		}

	}
	//////////////////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////////////////////

	class gameFrame extends JFrame {
		private JButton resetBtn = new JButton("R");
		private JLabel[] MysunsuLabel = new JLabel[5];
		private JLabel[] YoursunsuLabel = new JLabel[5];
		private ImageIcon[] MysunsuImage = new ImageIcon[5];
		private ImageIcon[] YoursunsuImage = new ImageIcon[5];

		private JLabel MyImage = new JLabel();
		private JLabel YourImage = new JLabel();
		private JLabel winLabel = new JLabel("WIN");
		private JLabel loseLabel = new JLabel("Lose");

		private JLabel PvP = new JLabel();
		
		private JLabel sunsu1name = new JLabel();

		private JLabel sunsu2name = new JLabel();

		public gameFrame(String Myteam, int count, int wincount, int losecount) {
			setTitle("Mystarcraft");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c = getContentPane();
			c.setLayout(null);
			c.setBackground(Color.black);
			resetBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
					new ProjectMain();
				}
			});
			
			JButton[] setbtn1 = new JButton[5];
			for (int i = 0; i < 5; i++) {
				setbtn1[i] = new JButton(NewMap.get(i));
				setbtn1[i].setBounds(550, 350 + (70 * i), 100, 30);
				int a = i;
				setbtn1[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						Map currentMap = new Map(NewMap.get(a));
						currentMap.data();
						Mapdatalabel.setText("<html><body><center>" + NewMap.get(a) + "<br>T:Z "
								+ currentMap.getMyTerranwinrate() + ":" + currentMap.getYourZergwinrate() + "<br>Z:P "
								+ currentMap.getMyZergwinrate() + ":" + currentMap.getYourProtosswinrate() + "<br>P:T "
								+ currentMap.getMyProtosswinrate() + ":" + currentMap.getYourTerranwinrate()
								+ "</center></body></html>");
						Mapdatalabel.setFont(new Font("맵 정보", Font.ITALIC, 17));
						Mapdatalabel.setForeground(Color.white);
						Mapdatalabel.setBounds(630, 150, 200, 200);
						ImageIcon icon = new ImageIcon("images/맵/" + NewMap.get(a) + ".gif");
						Mapla.setIcon(icon);
						Mapla.setBounds(480, 150, 200, 200);
						
	                    MyImage.setIcon(MysunsuImage[a]);
						MyImage.setBounds(130, 380, 100, 100);
						YourImage.setIcon(YoursunsuImage[a]);
						YourImage.setBounds(970, 380, 100, 100);
						
						sunsu a1 = new sunsu(Myentry[a]);
						a1.data();
						atk1 = a1.getAtk();
						def1 = a1.getDef();
						tectics1 = a1.getTectics();
						sense1 = a1.getSense();
						supply1 = a1.getSupply();
						control1 = a1.getControl();
						type1 = a1.getType();

						
						statlabel.setText("<html><body><center>공격력: " + atk1 + "<br>수비력: " + def1 + "<br>전략: " + tectics1
								+ "<br>센스: " + sense1 + "<br>물량: " + supply1 + "<br>컨트롤: " + control1 + "<br>종족: " + type1 + "</center></body></html>");
						
						sunsu a2 = new sunsu(Yourentry[a]);
						a2.data();
						atk2 = a2.getAtk();
						def2 = a2.getDef();
						tectics2 = a2.getTectics();
						sense2 = a2.getSense();
						supply2 = a2.getSupply();
						control2 = a2.getControl();
						type2 = a2.getType();
						
						
						statlabel2.setText("<html><body><center>공격력: " + atk2 + "<br>수비력: " + def2 + "<br>전략: " + tectics2
								+ "<br>센스: " + sense2 + "<br>물량: " + supply2 + "<br>컨트롤: " + control2 + "<br>종족: " + type2 +"</center></body></html>");
						
						sunsu1name.setText(Myentry[a]);
						sunsu1name.setForeground(Color.white);
						sunsu2name.setText(Yourentry[a]);
						sunsu2name.setForeground(Color.white);

					

					}
				});
				c.add(setbtn1[i]);

			}
			
			Myentry[4] = new String(ACECARD);
			Yourentry[4] = new String(yourACECARD);
			MysunsuImage[4] = new ImageIcon("images/"+Myentry[4]+".gif");
			YoursunsuImage[4] = new ImageIcon("images/"+Yourentry[4]+".gif");
			
			c.add(Mapdatalabel);
			c.add(Mapla);
			setbtn1[4] = new JButton(NewMap.get(4));
			setbtn1[4].setBounds(550, 630, 100, 30);
			c.add(setbtn[4]);
			

			JButton strBtn1 = new JButton("시작");

			for (int i = 0; i < 5; i++) {
				MysunsuLabel[i] = new JLabel();
				MysunsuLabel[i].setText(Myentry[i]);
				MysunsuLabel[i].setBounds(350, 350 + (70 * i), 100, 30);
				MysunsuLabel[i].setFont(new Font("출전선수", Font.ITALIC, 20));
				MysunsuLabel[i].setForeground(Color.white);

				YoursunsuLabel[i] = new JLabel();
				YoursunsuLabel[i].setText(Yourentry[i]);
				YoursunsuLabel[i].setBounds(750, 350 + (70 * i), 100, 30);
				YoursunsuLabel[i].setFont(new Font("출전선수", Font.ITALIC, 20));
				YoursunsuLabel[i].setForeground(Color.white);

				MysunsuImage[i] = new ImageIcon("images/" + Myentry[i] + ".gif");
				YoursunsuImage[i] = new ImageIcon("images/" + Yourentry[i] + ".gif");

				c.add(MysunsuLabel[i]);
				c.add(YoursunsuLabel[i]);
			}
			
			MyImage.setIcon(MysunsuImage[count]);
			MyImage.setBounds(130, 380, 100, 100);
			YourImage.setIcon(YoursunsuImage[count]);
			YourImage.setBounds(970, 380, 100, 100);

			Connection conn;
			Statement stmt = null;

			sunsu a1 = new sunsu(Myentry[count]);
			a1.data();
			atk1 = a1.getAtk();
			def1 = a1.getDef();
			tectics1 = a1.getTectics();
			sense1 = a1.getSense();
			supply1 = a1.getSupply();
			control1 = a1.getControl();
			type1 = a1.getType();

			statlabel.setVisible(true);
			statlabel.setText("<html><body><center>공격력: " + atk1 + "<br>수비력: " + def1 + "<br>전략: " + tectics1
					+ "<br>센스: " + sense1 + "<br>물량: " + supply1 + "<br>컨트롤: " + control1 + "<br>종족: " + type1 + "</center></body></html>");

			statlabel.setForeground(Color.white);
			statlabel.setBackground(Color.black);
			statlabel.setBounds(130, 500, 150, 150);
			c.add(statlabel);

			sunsu a2 = new sunsu(Yourentry[count]);
			a2.data();
			atk2 = a2.getAtk();
			def2 = a2.getDef();
			tectics2 = a2.getTectics();
			sense2 = a2.getSense();
			supply2 = a2.getSupply();
			control2 = a2.getControl();
			type2 = a2.getType();

			statlabel2.setVisible(true);
			statlabel2.setText("<html><body><center>공격력: " + atk2 + "<br>수비력: " + def2 + "<br>전략: " + tectics2
					+ "<br>센스: " + sense2 + "<br>물량: " + supply2 + "<br>컨트롤: " + control2 + "<br>종족: " + type2 +"</center></body></html>");

			statlabel2.setForeground(Color.white);
			statlabel2.setBackground(Color.black);
			statlabel2.setBounds(970, 500, 150, 150);
			c.add(statlabel2);

			Map currentMap = new Map(NewMap.get(count));
			currentMap.data();
			Mapdatalabel.setText("<html><body><center>"+NewMap.get(count)+"<br>T:Z " + currentMap.getMyTerranwinrate() +":"+currentMap.getYourZergwinrate()+ 
					"<br>Z:P " + currentMap.getMyZergwinrate() +":"+currentMap.getYourProtosswinrate()+ 
					"<br>P:T " + currentMap.getMyProtosswinrate() +":"+currentMap.getYourTerranwinrate()
					+ "</center></body></html>");
			Mapdatalabel.setFont(new Font("맵 정보", Font.ITALIC, 17));
			Mapdatalabel.setForeground(Color.white);
			Mapdatalabel.setBounds(630, 150, 200, 200);
			ImageIcon icon = new ImageIcon("images/맵/" + NewMap.get(count) + ".gif");
			Mapla.setIcon(icon);
			Mapla.setBounds(480,150, 200, 200);

			sunsu1name.setText(Myentry[count]);
			sunsu1name.setForeground(Color.white);
			sunsu2name.setText(Yourentry[count]);
			sunsu2name.setForeground(Color.white);

			sunsu1name.setBounds(150, 450, 100, 100);

			sunsu2name.setBounds(1000, 450, 100, 100);

			for (int i = 0; i < 6; i++) {

				winLabel1[i].setBounds(450, 350 + (i * 70), 100, 30);
				loseLabel1[i].setBounds(850, 350 + (i * 70), 100, 30);

				c.add(winLabel1[i]);
				c.add(loseLabel1[i]);
			}

			PvP.setFont(new Font("PvP", Font.PLAIN, 70));
			PvP.setForeground(Color.white);
			PvP.setBounds(360, 0, 600, 200);
			PvP.setText(wincount + "           :           " + losecount);
			
			strBtn1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Text.setText("");//문자중계 초기화
					setVisible(false);
					dispose();
					new Battle(Myteam, Myentry[count], Yourentry[count], wincount, losecount, count);

				}
			});

			ImageIcon team = new ImageIcon("images/로고/" + Myteam + ".gif");
			ImageIcon team1 = new ImageIcon("images/로고/" + NewTeam.get(num[a]) + ".gif");

			JLabel myteam = new JLabel();
			JLabel yourteam = new JLabel();
			myteam.setIcon(team);
			yourteam.setIcon(team1);
			myteam.setBounds(130, 30, 150, 150);
			yourteam.setBounds(950, 30, 150, 150);
			

			resetBtn.setBounds(0, 0, 50, 50);
			strBtn1.setBounds(550, 900, 100, 30);

			
			c.add(sunsu1name);
			c.add(sunsu2name);
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

	//////////////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////////////////
	class Battle extends JFrame {

		private JButton resetBtn = new JButton("R");
		private JLabel MysunsuLabel = new JLabel();
		private JLabel YoursunsuLabel = new JLabel();
		private ImageIcon MysunsuImage = new ImageIcon();
		private ImageIcon YoursunsuImage = new ImageIcon();
		private JLabel PvP = new JLabel();
		
		

		private JLabel winLabel = new JLabel("WIN");
		private JLabel loseLabel = new JLabel("GG");
		private JButton nextBtn1 = new JButton("next>>");/// battle frame 다음세트 버튼
		private int wincount;
		private int losecount;

		public Battle(String Myteam, String sunsu1, String sunsu2, int wincount, int losecount, int count) {

			super("Mystarcraft");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c = getContentPane();
			c.setLayout(null);
			c.setBackground(Color.black);
			winLabel.setFont(new Font("승리", Font.BOLD, 40));
			winLabel.setForeground(Color.green);
			loseLabel.setFont(new Font("패배", Font.BOLD, 40));
			loseLabel.setForeground(Color.red);

			this.wincount = wincount;
			this.losecount = losecount;
			
			resetBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					setVisible(false);
					dispose();
					new ProjectMain();
				}
			});
			
			Text.setBounds(460, 330, 300, 500);
			c.add(Text);
			sunsu a1 = new sunsu(sunsu1);
			a1.data();
			atk1 = a1.getAtk();
			def1 = a1.getDef();
			tectics1 = a1.getTectics();
			sense1 = a1.getSense();
			supply1 = a1.getSupply();
			control1 = a1.getControl();
			type1 = a1.getType();
			sum1 = atk1 + def1 + control1 + tectics1 + sense1 + supply1;

			statlabel.setVisible(true);
			statlabel.setText("<html><body><center>공격력: " + atk1 + "<br>수비력: " + def1 + "<br>전략: " + tectics1
					+ "<br>센스: " + sense1 + "<br>물량: " + supply1 + "<br>컨트롤: " + control1 + "<br>종족: " + type1 + "</center></body></html>");

			statlabel.setForeground(Color.white);
			statlabel.setBackground(Color.black);
			statlabel.setBounds(130, 500, 150, 150);
			c.add(statlabel);

			sunsu a2 = new sunsu(sunsu2);
			a2.data();
			atk2 = a2.getAtk();
			def2 = a2.getDef();
			tectics2 = a2.getTectics();
			sense2 = a2.getSense();
			supply2 = a2.getSupply();
			control2 = a2.getControl();
			type2 = a2.getType();
			sum2 = atk2 + def2 + control2 + tectics2 + sense2 + supply2;

			statlabel2.setVisible(true);
			statlabel2.setText("<html><body><center>공격력: " + atk2 + "<br>수비력: " + def2 + "<br>전략: " + tectics2
					+ "<br>센스: " + sense2 + "<br>물량: " + supply2 + "<br>컨트롤: " + control2 + "<br>종족: " + type2 +"</center></body></html>");

			statlabel2.setForeground(Color.white);
			statlabel2.setBackground(Color.black);
			statlabel2.setBounds(970, 500, 150, 150);
			c.add(statlabel2);
			
			sum3 = sum1 + sum2;
			nextBtn1.setVisible(false);
			JButton strBtn1 = new JButton("시작");
			Random r1 = new Random();
			
			Map currentMap = new Map(NewMap.get(count));
			currentMap.data();
			Mapdatalabel.setText("<html><body><center>"+NewMap.get(count)+"<br>T:Z " + currentMap.getMyTerranwinrate() +":"+currentMap.getYourZergwinrate()+ 
					"<br>Z:P " + currentMap.getMyZergwinrate() +":"+currentMap.getYourProtosswinrate()+ 
					"<br>P:T " + currentMap.getMyProtosswinrate() +":"+currentMap.getYourTerranwinrate()
					+ "</center></body></html>");
			Mapdatalabel.setFont(new Font("맵 정보", Font.ITALIC, 17));
			Mapdatalabel.setForeground(Color.white);
			Mapdatalabel.setBounds(680, 150, 200, 200);
			ImageIcon icon = new ImageIcon("images/맵/" + NewMap.get(count) + ".gif");
			Mapla.setIcon(icon);
			Mapla.setBounds(460,150, 200, 200);
			
			int mapwinrate = 0;
			
			if(a1.getType().equals("Terran") && a2.getType().equals("Zerg")) {
				mapwinrate = currentMap.getMyTerranwinrate()-currentMap.getYourZergwinrate();
			}
			if(a1.getType().equals("Zerg") && a2.getType().equals("Protoss")) {
				mapwinrate = currentMap.getMyZergwinrate()-currentMap.getYourProtosswinrate();
			}
			if(a1.getType().equals("Protoss") && a2.getType().equals("Terran")) {
				mapwinrate = currentMap.getMyProtosswinrate()-currentMap.getYourTerranwinrate();
			}
			if(a1.getType().equals("Zerg") && a2.getType().equals("Terran")) {
				mapwinrate = currentMap.getYourZergwinrate()-currentMap.getMyTerranwinrate();
			}
			if(a1.getType().equals("Protoss") && a2.getType().equals("Zerg")) {
				mapwinrate = currentMap.getYourProtosswinrate()-currentMap.getMyZergwinrate();
			}
			if(a1.getType().equals("Terran") && a2.getType().equals("Protoss")) {
				mapwinrate = currentMap.getYourTerranwinrate()-currentMap.getMyProtosswinrate();
			}
			int winrate = r1.nextInt(100);
			int winrate1 = (int)((double)((sum1+(mapwinrate*50))*100)/((double)sum3/1.2));
			
			strBtn1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println(winrate);
					System.out.println(winrate1);
					Person1 p1 = new Person1(sunsu1);
					Person2 p2 = new Person2(sunsu2);
					p1.start();
					p2.start();
					if (winrate <= winrate1) {
						winLabel.setBounds(130, 300, 100, 50);
						loseLabel.setBounds(980, 400, 100, 50);
//						PvP.setText((wincount1) + "           :           " + losecount);
//						wincount1 = wincount + 1;
						winLabel1[count].setText("WIN");
						winLabel1[count].setForeground(Color.green);
						loseLabel1[count].setText("Lose");
						loseLabel1[count].setForeground(Color.red);
						WIN = true;
						Lose = false;

					}
					
					else {
						loseLabel.setBounds(130, 400, 100, 50);
						winLabel.setBounds(980, 300, 100, 50);
//						PvP.setText(wincount + "           :           " + losecount1);
//						losecount1 = losecount + 1;
						winLabel1[count].setText("Lose");
						loseLabel1[count].setText("WIN");
						winLabel1[count].setForeground(Color.red);
						loseLabel1[count].setForeground(Color.green);
						WIN = false;
						Lose = true;
					}

					count1 = count + 1;

					strBtn1.setVisible(false);
					nextBtn1.setVisible(true);

				}
			});

			
			strBtn1.setBounds(550, 900, 100, 30);

			nextBtn1.setBounds(550, 900, 100, 30);

			nextBtn1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					if (wincount1 == 2 && losecount1 == 2) {
						setVisible(false);
						dispose();
						new AceFrame(Myteam);
					} else if (wincount1 == 3) {
						grade--;
						a++;
						ACECARD = "ACE";
						yourACECARD = "ACE";

						if (a == 3) {
							Victorycount++;
							setVisible(false);
							dispose();
							new loseFrame(Myteam, 1);
						} else {
							for (int i = 0; i < 6; i++) {

								winLabel1[i].setText("");
								loseLabel1[i].setText("");
							}
							setVisible(false);
							dispose();
							new YourFrame(Myteam);
							
						}
					} else if (losecount1 == 3) {
						setVisible(false);
						dispose();
						new loseFrame(Myteam, grade);
					} else {
						setVisible(false);
						dispose();
						new gameFrame(Myteam, count1, wincount1, losecount1);
					}
				}

			});
			MysunsuImage = new ImageIcon("images/" + sunsu1 + ".gif");
			YoursunsuImage = new ImageIcon("images/" + sunsu2 + ".gif");
			MysunsuLabel.setIcon(MysunsuImage);
			YoursunsuLabel.setIcon(YoursunsuImage);
			MysunsuLabel.setBounds(120, 380, 100, 100);
			YoursunsuLabel.setBounds(970, 380, 100, 100);

			PvP.setText(wincount + "           :           " + losecount);
			PvP.setFont(new Font("PvP", Font.PLAIN, 70));
			PvP.setForeground(Color.white);
			PvP.setBounds(360, 0, 600, 200);

			resetBtn.setBounds(0, 0, 50, 50);

			JLabel mysunsu = new JLabel();
			JLabel sunsu1name = new JLabel();
			JLabel yoursunsu = new JLabel();
			JLabel sunsu2name = new JLabel();
			
			

			sunsu1name.setText(sunsu1);
			sunsu1name.setForeground(Color.white);
			sunsu2name.setText(sunsu2);
			sunsu2name.setForeground(Color.white);

			mysunsu.setBounds(120, 380, 100, 100);
			sunsu1name.setBounds(140, 450, 100, 100);
			yoursunsu.setBounds(920, 380, 100, 100);
			sunsu2name.setBounds(990, 450, 100, 100);
			
			ImageIcon team = new ImageIcon("images/로고/" + Myteam + ".gif");
			ImageIcon team1 = new ImageIcon("images/로고/" + NewTeam.get(num[a]) + ".gif");
			JLabel myteam = new JLabel();
			JLabel yourteam = new JLabel();
			myteam.setIcon(team);
			yourteam.setIcon(team1);
			myteam.setBounds(130, 30, 150, 150);
			yourteam.setBounds(950, 30, 150, 150);
			c.add(myteam);
			c.add(yourteam);

			c.add(Mapla);
			c.add(Mapdatalabel);
			c.add(mysunsu);
			c.add(yoursunsu);
			c.add(sunsu1name);
			c.add(sunsu2name);

			c.add(resetBtn);
			c.add(winLabel);
			c.add(loseLabel);
			c.add(strBtn1);
			c.add(MysunsuLabel);
			c.add(YoursunsuLabel);
			c.add(PvP);

			c.add(nextBtn1);

			setSize(1200, 1000);
			setVisible(true);
			
			
		}
		
		class Person1 extends Thread
		{
			private String name;
			public Person1(String name)
			{
				this.name = name;
			}

			public void run()
			{
				
				try{
					
					for (int i = 1 ; i <=5 ; i++)
					{
						
						Text.append(name+" 문자중계 테스트"+i+"\n");
						Thread.sleep(100);
						
					}
					if(WIN) {
						Text.append(name+"선수 역시 이기는 법을 아는거같아요!");
						wincount1 = wincount + 1;
						PvP.setText(wincount1 + "           :           " + losecount);
					}
					
				}catch(Exception e){
				}
			}

		}
		class Person2 extends Thread
		{
			private String name;
			public Person2(String name)
			{
				this.name = name;
			}

			public void run()
			{
				
				try{
					winLabel.setVisible(false);
					loseLabel.setVisible(false);
					nextBtn1.setEnabled(false);
					for (int i = 1 ; i <=5 ; i++)
					{
						
						Text.append(name+" 문자중계 테스트"+i+"\n");
						Thread.sleep(100);
						
					}
					if(Lose) {
						Text.append(name+"선수 역시 이기는 법을 아는거같아요!");
						losecount1 = losecount + 1;
						PvP.setText(wincount + "           :           " + losecount1);
					}
					winLabel.setVisible(true);
					loseLabel.setVisible(true);
					nextBtn1.setEnabled(true);
				}catch(Exception e){
				}
			}

		}
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////////////
	class AceFrame extends JFrame {

		private JButton resetBtn = new JButton("R");
		private ImageIcon myACEcard ;
		private JLabel sunsu1 = new JLabel();
		private JLabel sunsu1name = new JLabel();
		private JLabel sunsu2 = new JLabel();
		private JLabel sunsu2name = new JLabel();
		private JLabel acelabel = new JLabel();
		public AceFrame(String Myteam) {
			setTitle("Mystarcraft");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c = getContentPane();
			c.setLayout(null);
			c.setBackground(Color.black);
			
			ImageIcon aceIcon= new ImageIcon("Images/라벨.PNG");//장식
			member1JList.setBounds(300, 350, 150, 400);
			acelabel.setIcon(aceIcon);
			acelabel.setBounds(500,350,200,400);
			c.add(acelabel);

			member1JList.setBounds(350, 350, 150, 400);
			
			Map currentMap = new Map(NewMap.get(4));
			currentMap.data();
			Mapdatalabel.setText("<html><body><center>"+NewMap.get(4)+"<br>T:Z " + currentMap.getMyTerranwinrate() +":"+currentMap.getYourZergwinrate()+ 
					"<br>Z:P " + currentMap.getMyZergwinrate() +":"+currentMap.getYourProtosswinrate()+ 
					"<br>P:T " + currentMap.getMyProtosswinrate() +":"+currentMap.getYourTerranwinrate()
					+ "</center></body></html>");
			Mapdatalabel.setFont(new Font("맵 정보", Font.ITALIC, 17));
			Mapdatalabel.setForeground(Color.white);
			Mapdatalabel.setBounds(630, 150, 200, 200);
			ImageIcon icon = new ImageIcon("images/맵/" + NewMap.get(4) + ".gif");
			Mapla.setIcon(icon);
			Mapla.setBounds(480,150, 200, 200);
			
			c.add(Mapdatalabel);
			c.add(Mapla);
			
			JButton strBtn1 = new JButton("시작");
			strBtn1.setEnabled(false);
			myACEcard = new ImageIcon("Images/ACE.gif");
			ImageIcon yourACEcard = new ImageIcon("Images/ACE.gif");

			sunsu1.setIcon(myACEcard);
			sunsu1name.setText("ACE");
			sunsu1name.setForeground(Color.white);
			statlabel.setVisible(false);
			statlabel2.setVisible(false);
			sunsu2.setIcon(myACEcard);
			sunsu2name.setText("ACE");
			sunsu2name.setForeground(Color.white);
			
			member1JList.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {

					JList jl = (JList) e.getSource();
					String name = (String) jl.getSelectedValue();
					String name1 = name.trim();
					statlabel.setVisible(true);
					
					myACEcard = new ImageIcon("images/" + name1 + ".gif");
				
					Connection conn;
					Statement stmt = null;

					sunsu a = new sunsu(name1);
					a.data();
					atk1 = a.getAtk();
					def1 = a.getDef();
					tectics1 = a.getTectics();
					sense1 = a.getSense();
					supply1 = a.getSupply();
					control1 = a.getControl();
					type1 = a.getType();
					
					statlabel.setVisible(true);
					statlabel.setText("<html><body><center>공격력: " + atk1 + "<br>수비력: " + def1 + "<br>전략: " + tectics1
							+ "<br>센스: " + sense1 + "<br>물량: " + supply1 + "<br>컨트롤: " + control1 + "<br>종족: " + type1 + "</center></body></html>");

					statlabel.setForeground(Color.white);
					statlabel.setBackground(Color.black);
					
					sunsu1.setIcon(myACEcard);
					sunsu1name.setText(name1);
					sunsu1name.setForeground(Color.white);
					strBtn1.setEnabled(true);

				}
			});
			anotherTeamJList = new JList();
			anotherTeamJList.setBounds(700, 350, 150, 400);
			anotherTeamJList.setListData(v1);
			anotherTeamJList.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {

					JList jl = (JList) e.getSource();
					String name = (String) jl.getSelectedValue();
					String name1 = name.trim();
					
					statlabel2.setVisible(true);
					ImageIcon icon = new ImageIcon("images/" + name1 + ".gif");

					sunsu2.setIcon(icon);

					sunsu2name.setText(name1);
					sunsu2name.setForeground(Color.white);

					sunsu a = new sunsu(name1);
					a.data();
					atk2 = a.getAtk();
					def2 = a.getDef();
					tectics2 = a.getTectics();
					sense2 = a.getSense();
					supply2 = a.getSupply();
					control2 = a.getControl();
					type2 = a.getType();

					statlabel2.setVisible(true);
					statlabel2.setText("<html><body><center>공격력: " + atk2 + "<br>수비력: " + def2 + "<br>전략: " + tectics2
							+ "<br>센스: " + sense2 + "<br>물량: " + supply2 + "<br>컨트롤: " + control2+ "<br>종족: " + type2
							+ "</center></body></html>");

					statlabel2.setForeground(Color.white);
					statlabel2.setBackground(Color.black);

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
					int a = random.nextInt(v1.size());
					yourACECARD = v1.get(a).trim();
					String MyAceCard = (String) member1JList.getSelectedValue();
					ACECARD = MyAceCard.trim();
					setVisible(false);
//					new Battle(Myteam, ACECARD, yourACECARD, 2, 2, 5);
					new gameFrame(Myteam,4,2,2);

				}
			});
			JLabel PvP = new JLabel(); 
			PvP.setFont(new Font("PvP", Font.PLAIN, 70));
			PvP.setForeground(Color.white);
			PvP.setBounds(360, 0, 600, 200);
			PvP.setText(2 + "           :           " + 2);
			
			ImageIcon team = new ImageIcon("images/로고/" + Myteam + ".gif");
			ImageIcon team1 = new ImageIcon("images/로고/" + NewTeam.get(num[a]) + ".gif");
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
			sunsu2.setBounds(920, 380, 100, 100);
			sunsu2name.setBounds(960, 450, 100, 100);
			c.add(PvP);
			c.add(statlabel);
			c.add(statlabel2);
			c.add(sunsu1);
			c.add(sunsu1name);
			c.add(sunsu2);
			c.add(sunsu2name);
			c.add(anotherTeamJList);
			c.add(member1JList);
			c.add(strBtn1);
			setSize(1200, 1000);
			setVisible(true);

		}
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	class loseFrame extends JFrame {
		private JButton resetBtn = new JButton("R");

		public loseFrame(String Myteam, int grade1) {
			setTitle("MyStarCraft");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c = getContentPane();
			c.setLayout(null);
			c.setBackground(Color.black);

			
			JLabel gradeLabel = new JLabel(grade1 + "위 달성.");
			gradeLabel.setFont(new Font("순위", Font.ITALIC, 100));
			gradeLabel.setForeground(Color.green);
			gradeLabel.setBounds(400, 200, 650, 300);

			ImageIcon team = new ImageIcon("images/로고/" + Myteam + ".gif");
			JLabel imagelabel = new JLabel();
			imagelabel.setIcon(team);
			imagelabel.setBounds(500, 500, 150, 150);

			resetBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					setVisible(false);
					dispose();
					new ProjectMain();
				}
			});
			
			JButton jb = new JButton("다음 토너먼트>>");
			jb.setBounds(450, 800, 200, 50);
			jb.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					a = 0;
					grade = 4;
					for (int i = 0; i < 6; i++) {

						winLabel1[i].setText("");
						loseLabel1[i].setText("");
					}
					for(int i = 0; i<2;i++) {
						winla[i] = new JLabel("");
						losela[i] = new JLabel("");
						}
					randomteam();
					NewTeam = new ArrayList<String>();
					for (String temp : Team) {
						if (!temp.equals(TeamCombo.getSelectedItem()))
							NewTeam.add(temp);
					}
					setVisible(false);
					dispose();
					new YourFrame(Myteam);	
				}
			});
			if(grade1 == 1) {
				jb.setEnabled(true);
			}
			else {
				jb.setEnabled(false);
			}

			resetBtn.setBounds(0, 0, 50, 50);
			c.add(jb);
			c.add(resetBtn);
			c.add(gradeLabel);
			c.add(imagelabel);
			setSize(1200, 1000);
			setVisible(true);

		}
	}

	public void randomteam() {
		Random random = new Random();

		for (int i = 0; i < num.length; i++) {
			num[i] = random.nextInt(11);
			for (int j = 0; j < i; j++) {
				if (num[i] == num[j]) {
					i--;
					break;
				}
			}
		}
	}
	
	

	public void randomentry() {
		Random random = new Random();

		for (int i = 0; i < num2.length; i++) {
			num2[i] = random.nextInt(v1.size());
			for (int j = 0; j < i; j++) {
				if (num2[i] == num2[j]) {
					i--;
					break;
				}
			}
		}
	}

}
