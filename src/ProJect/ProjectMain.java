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
import java.util.Random;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class ProjectMain extends JFrame {
	private String Team[] = { "KT 롤스터", "SK 텔레콤 T1", "화승 OZ", "하이트 스파키즈", "MBC게임 히어로", "CJ 엔투스", "삼성전자 칸", "STX 소울",
			"웅진 스타즈", "eStrO", "위메이드 FOX", "공군 ACE" };
	private ArrayList<String> NewTeam;
	private JLabel la = new JLabel("팀을 선택해주세요!");
	private JComboBox<String> TeamCombo = new JComboBox<String>(Team);

	private JButton[] setbtn = new JButton[5];
	private JLabel[] setlabel = new JLabel[5];

	private JLabel[] winLabel1 = new JLabel[6];
	private JLabel[] loseLabel1 = new JLabel[6];

	private String Myentry[] = new String[4];
	private String Yourentry[] = new String[4];

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

	public ProjectMain() {
		JButton resetBtn = new JButton("R");

		setTitle("MyStarCraft");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setResizable(false);

		Container c = getContentPane();
		c.setBackground(Color.black);
		c.setLayout(null);

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

						ImageIcon icon = new ImageIcon("images/로고/" + Item + ".gif");
						logolabel.setIcon(icon);
						v.add(str + "\n");
						member1JList.setListData(v);

					}

					br.close();

				} catch (IOException e2) {
					e2.printStackTrace();
				}

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

		pack();
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

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ProjectMain();
	}
///////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////////	
	
	class YourFrame extends JFrame {

		private JButton resetBtn = new JButton("R");
		
		public YourFrame(String Myteam) {
			wincount1 = 0;
			losecount1 = 0;
			count1 = 0;
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
			setTitle("Mystarcraft");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c = getContentPane();
			c.setLayout(null);
			c.setBackground(Color.black);

			for (int i = 0; i < 5; i++) {
				setbtn[i] = new JButton((i + 1) + "");
				setbtn[i].setBounds(550, 350 + (70 * i), 100, 30);
				c.add(setbtn[i]);

			}

			for (int i = 0; i < 4; i++) {
				setlabel[i] = new JLabel("empty");
				setlabel[i].setForeground(Color.white);
				setlabel[i].setFont(new Font("선수이름", Font.ITALIC, 15));
				setlabel[i].setBounds(550, 380 + (70 * i), 100, 30);
				c.add(setlabel[i]);
				setbtn[i].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						setlabel[Integer.parseInt(e.getActionCommand()) - 1].setText(member1JList.getSelectedValue());
					}
				});
			}

			JLabel finalLabel = new JLabel("ACE");
			finalLabel.setFont(new Font("선수이름", Font.ITALIC, 15));

			JList anotherTeamJList = new JList();
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

				}
			});

			finalLabel.setBounds(550, 660, 100, 30);

			try {
				String str;
				BufferedReader br = new BufferedReader(
						new FileReader("C:\\Users\\tj-bu-12\\Desktop\\" + NewTeam.get(num[a]) + ".txt")); // 불러올 파일이름
				v1.clear();
				while ((str = br.readLine()) != null) {

					ImageIcon icon = new ImageIcon("images/로고/" + NewTeam.get(num[a]) + ".gif");
					logolabel.setIcon(icon);
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
			teamLabel.setBounds(100, 200, 150, 100);

			ImageIcon team1 = new ImageIcon("images/로고/" + NewTeam.get(num[a]) + ".gif");
			JLabel yourteam = new JLabel();
			yourteam.setIcon(team1);
			yourteam.setBounds(950, 200, 150, 100);

			resetBtn.setBounds(0, 0, 50, 50);
			strBtn1.setBounds(520, 850, 200, 40);
			sunsu1.setBounds(120, 380, 100, 100);
			sunsu1name.setBounds(140, 450, 100, 100);
			sunsu2.setBounds(960, 380, 100, 100);
			sunsu2name.setBounds(990, 450, 100, 100);

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
		private JLabel[] MysunsuLabel = new JLabel[4];
		private JLabel[] YoursunsuLabel = new JLabel[4];
		private ImageIcon[] MysunsuImage = new ImageIcon[4];
		private ImageIcon[] YoursunsuImage = new ImageIcon[4];

		private JLabel MyImage = new JLabel();
		private JLabel YourImage = new JLabel();
		private JLabel winLabel = new JLabel("WIN");
		private JLabel loseLabel = new JLabel("Lose");

		private JLabel PvP = new JLabel();

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

			JButton strBtn1 = new JButton("시작");

			for (int i = 0; i < 4; i++) {
				MysunsuLabel[i] = new JLabel();
				MysunsuLabel[i].setText(Myentry[i]);
				MysunsuLabel[i].setBounds(350, 350 + (100 * i), 100, 100);
				MysunsuLabel[i].setFont(new Font("출전선수", Font.ITALIC, 20));
				MysunsuLabel[i].setForeground(Color.white);

				YoursunsuLabel[i] = new JLabel();
				YoursunsuLabel[i].setText(Yourentry[i]);
				YoursunsuLabel[i].setBounds(850, 350 + (100 * i), 100, 100);
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

			JLabel sunsu1name = new JLabel();

			JLabel sunsu2name = new JLabel();

			sunsu1name.setText(Myentry[count]);
			sunsu1name.setForeground(Color.white);
			sunsu2name.setText(Yourentry[count]);
			sunsu2name.setForeground(Color.white);

			sunsu1name.setBounds(150, 450, 100, 100);

			sunsu2name.setBounds(1000, 450, 100, 100);

			for (int i = 0; i < 6; i++) {

				winLabel1[i].setBounds(450, 350 + (i * 100), 100, 100);
				loseLabel1[i].setBounds(750, 350 + (i * 100), 100, 100);
				
				c.add(winLabel1[i]);
				c.add(loseLabel1[i]);
			}

			PvP.setFont(new Font("PvP", Font.PLAIN, 70));
			PvP.setForeground(Color.white);
			PvP.setBounds(380, 100, 600, 300);
			PvP.setText(wincount + "           :           " + losecount);
			strBtn1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					
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
			myteam.setBounds(130, 200, 150, 150);
			yourteam.setBounds(950, 200, 150, 150);

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
		private JButton nextBtn1 = new JButton("next>>");

		private JLabel winLabel = new JLabel("WIN");
		private JLabel loseLabel = new JLabel("Lose");

		public Battle(String Myteam, String sunsu1, String sunsu2, int wincount, int losecount, int count) {

			super("Mystarcraft");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c = getContentPane();
			c.setLayout(null);
			c.setBackground(Color.black);
			winLabel.setFont(new Font("승리", Font.PLAIN, 25));
			winLabel.setForeground(Color.green);
			loseLabel.setFont(new Font("패배", Font.PLAIN, 25));
			loseLabel.setForeground(Color.red);

			resetBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					setVisible(false);
					dispose();
					new ProjectMain();
				}
			});
			nextBtn1.setVisible(false);
			JButton strBtn1 = new JButton("시작");
			Random r1 = new Random();
			int winrate = r1.nextInt(2);
			strBtn1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					if (winrate == 0) {
						winLabel.setBounds(450, 350, 50, 50);
						loseLabel.setBounds(750, 350, 50, 50);
						PvP.setText((wincount + 1) + "           :           " + losecount);
						wincount1 = wincount + 1;
						winLabel1[count].setText("WIN");
						winLabel1[count].setForeground(Color.green);
						loseLabel1[count].setText("Lose");
						loseLabel1[count].setForeground(Color.red);

					}

					else {
						loseLabel.setBounds(450, 350 + 100, 50, 50);
						winLabel.setBounds(750, 350 + 100, 50, 50);
						PvP.setText(wincount + "           :           " + (losecount + 1));
						losecount1 = losecount + 1;
						winLabel1[count].setText("Lose");
						loseLabel1[count].setText("WIN");
						winLabel1[count].setForeground(Color.red);
						loseLabel1[count].setForeground(Color.green);

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

					if(wincount1 == 2 && losecount1 ==2) {
						setVisible(false);
						dispose();
						new AceFrame(Myteam);
					}
					else if(wincount1 ==3) {
						grade--;
						a++;
						
						if(a == 3) {
							setVisible(false);
							dispose();
							new loseFrame(Myteam,1);
						}
						else {
							for (int i = 0; i < 6; i++) {

								winLabel1[i].setText("");
								loseLabel1[i].setText("");
							}
						setVisible(false);
						dispose();
						new YourFrame(Myteam);
						}
					}
					else if(losecount1 ==3 ) {
						setVisible(false);
						dispose();
						new loseFrame(Myteam,grade);
					}
					else {
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
			YoursunsuLabel.setBounds(920, 380, 100, 100);

			PvP.setText(wincount + "           :           " + losecount);
			PvP.setFont(new Font("PvP", Font.PLAIN, 70));
			PvP.setForeground(Color.white);
			PvP.setBounds(380, 100, 600, 300);

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
			sunsu2name.setBounds(940, 450, 100, 100);

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
	}
	///////////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////////////
	class AceFrame extends JFrame {

		private JButton resetBtn = new JButton("R");

		public AceFrame(String Myteam) {
			setTitle("Mystarcraft");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c = getContentPane();
			c.setLayout(null);
			c.setBackground(Color.black);

			member1JList.setBounds(500, 350, 150, 400);
			JLabel sunsu1 = new JLabel();
			JLabel sunsu1name = new JLabel();
			JButton strBtn1 = new JButton("시작");
			strBtn1.setEnabled(false);
			String acename;

			member1JList.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {

					JList jl = (JList) e.getSource();
					String name = (String) jl.getSelectedValue();
					String name1 = name.trim();

					ImageIcon icon = new ImageIcon("images/" + name1 + ".gif");

					sunsu1.setIcon(icon);
					sunsu1name.setText(name1);
					sunsu1name.setForeground(Color.white);
					strBtn1.setEnabled(true);

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
					String yourentry = v1.get(a).trim();
					String name = (String) member1JList.getSelectedValue();
					String name1 = name.trim();
					setVisible(false);
					new Battle(Myteam, name1, yourentry, 2, 2, 5);

				}
			});

			sunsu1.setBounds(120, 380, 100, 100);
			sunsu1name.setBounds(140, 450, 100, 100);
			c.add(sunsu1);
			c.add(sunsu1name);
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

		public loseFrame(String Myteam, int grade) {
			setTitle("MyStarCraft");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c = getContentPane();
			c.setLayout(null);
			c.setBackground(Color.black);

			JLabel gradeLabel = new JLabel(grade + "위 달성.");
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

			resetBtn.setBounds(0, 0, 50, 50);
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
