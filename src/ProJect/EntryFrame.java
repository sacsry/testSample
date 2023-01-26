package ProJect;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class EntryFrame extends JFrame{

	private JButton resetbtn = new JButton("R");	
	int sunsuentry;
	
	Map currentMap = new Map();
	JLabel[] setlabel = new JLabel[5]; // 세트 라벨
	JPanel sunsupanel1 = new JPanel();
	
	
	EntryFrame(JFrame f, String Myteam){
		
		super("MyStarCraft");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		Container c = getContentPane();
		c.setBackground(Color.black);
		
	
		ProjectMain s = (ProjectMain)f;
		
		s.draw = new Drawlabel(f);
		s.draw.setLayout(null);
		Drawlabel2 draw1 = new Drawlabel2(f);
		draw1.setLayout(null);
		
		
		s.sunsu2.setVisible(false);
		s.sunsu1.setVisible(false);
		s.sunsu1name.setText("");
		
		s.wincount1 = 0;
		s.losecount1 = 0;
		s.count1 = 0;
		s.Mapla.setVisible(false);
		s.Mapdatalabel.setVisible(false);
		s.draw.setVisible(false);
		draw1.setVisible(false);
//		s.statlabel.setVisible(false);
//		s.statlabel2.setVisible(false);
		s.sunsu2name.setText("");
		
		
		MapChoice choice = new MapChoice();
		s.NewMap = choice.getNewMap();
		JPanel MapPanel = new JPanel();
		MapPanel.setLayout(null);
		MapPanel.setBounds(440,160,320,160);
		MapPanel.add(s.Mapla);
		MapPanel.add(s.Mapdatalabel);
		MapPanel.setBackground(Color.black);
		MapPanel.setBorder(new TitledBorder(new LineBorder(Color.white, 3),"맵 정보",2,0,new Font("",Font.BOLD,20),Color.white));
		add(MapPanel);
		/////////////////////////맵 배치//////////////////////
		
		JButton strBtn1 = new JButton("시작");
		strBtn1.setEnabled(false);
		//게임 시작 버튼////////////////////////////////////////////////////
		
		resetbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				new ProjectMain();
			}
		}); 
		
		resetbtn.setBounds(0, 0, 50, 50);
		//////////////// 리셋버튼////////////////////////////
		
		MymouseAdapter mouse = new MymouseAdapter(f);
		s.sunsupanel.setLayout(null);
		s.sunsupanel.setBounds(280,330,205,460);
		s.sunsupanel.add(s.member1JList);
		s.sunsupanel.setBackground(Color.black);
		s.sunsupanel.setBorder(new TitledBorder(new LineBorder(Color.white, 3),"선수들",2,0,new Font("",Font.BOLD,20),Color.white));
		s.member1JList.addMouseListener(mouse);
		s.member1JList.setBounds(25, 30, 150, 400);
		
		s.sunsu1.setBounds(120, 380, 100, 100);
		s.sunsu1name.setBounds(140, 450, 100, 100);
		s.draw.setBounds(60,510,200,200);
//		s.statlabel.setBounds(120, 500, 150, 150);
		///////////////우리팀 엔트리 관련//////////////////////
		
//		sunsu2.setBounds(960, 380, 100, 100);
//		sunsu2name.setBounds(990, 450, 100, 100);
		
		strBtn1.setBounds(520, 850, 200, 40);
		strBtn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for (int i = 0; i < 4; i++) {
					String bc = setlabel[i].getText().trim();
					s.Myentry[i] = bc;

				}

				setVisible(false);
				dispose();
				new gameFrame(f,Myteam, 0, 0, 0);
				s.member1JList.removeMouseListener(mouse);
			}

		});
		
		////////////////////////시작 버튼////////////////////////////////
		JLabel finalLabel = new JLabel("ACE");
		for (int i = 0; i < 5; i++) {
			s.setbtn[i] = new JButton(s.NewMap.get(i));
			s.setbtn[i].setBounds(550, 350 + (70 * i), 100, 30);
			add(s.setbtn[i]);

		}//세트 버튼
		
		for (int i = 0; i < 4; i++) {
			setlabel[i] = new JLabel("empty");
			setlabel[i].setBorder(new LineBorder(Color.white, 3));
			setlabel[0].setBorder(new LineBorder(Color.red, 3));
			setlabel[i].setForeground(Color.white);
			setlabel[i].setFont(new Font("선수이름", Font.ITALIC, 15));
			setlabel[i].setBounds(550, 380 + (70 * i), 100, 30);
			c.add(setlabel[i]);
			int a = i;

			
			
			s.setbtn[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					for (int j = 0; j < 4; j++) {

						setlabel[j].setBorder((new LineBorder(Color.white, 3)));
						finalLabel.setBorder(new TitledBorder(new LineBorder(Color.white, 3), ""));
					}
					sunsuentry = a;
					setlabel[a].setBorder(new TitledBorder(new LineBorder(Color.red, 3), ""));
					currentMap.data(s.NewMap.get(a));
					s.Mapla.setVisible(true);
					s.Mapdatalabel.setVisible(true);
					s.Mapdatalabel.setText("<html><body><center>" + s.NewMap.get(a) + "<br>T:Z "
							+ currentMap.getMyTerranwinrate() + ":" + currentMap.getYourZergwinrate() + "<br>Z:P "
							+ currentMap.getMyZergwinrate() + ":" + currentMap.getYourProtosswinrate() + "<br>P:T "
							+ currentMap.getMyProtosswinrate() + ":" + currentMap.getYourTerranwinrate()
							+ "</center></body></html>");
					s.Mapdatalabel.setFont(new Font("맵 정보", Font.ITALIC, 17));
					s.Mapdatalabel.setForeground(Color.white);
					s.Mapdatalabel.setBounds(180, -20, 200, 200);
					ImageIcon icon = new ImageIcon("images/맵/" + s.NewMap.get(a) + ".gif");
					s.Mapla.setIcon(icon);
					s.Mapla.setBounds(30, -20, 200, 200);

				}
			});
		}
		
		
		finalLabel.setBorder(new LineBorder(Color.white, 3));
		finalLabel.setFont(new Font("선수이름", Font.ITALIC, 15));
		finalLabel.setForeground(Color.white);
		finalLabel.setBounds(550, 660, 100, 30);
		
		s.setbtn[4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sunsuentry = 5;
				for (int j = 0; j < 4; j++) {

					setlabel[j].setBorder((new LineBorder(Color.white, 3)));
					
				}
				finalLabel.setBorder(new TitledBorder(new LineBorder(Color.red, 3), ""));
				currentMap.data(s.NewMap.get(4));
				s.Mapdatalabel.setText(
						"<html><body><center>" + s.NewMap.get(4) + "<br>T:Z " + currentMap.getMyTerranwinrate() + ":"
								+ currentMap.getYourZergwinrate() + "<br>Z:P " + currentMap.getMyZergwinrate() + ":"
								+ currentMap.getYourProtosswinrate() + "<br>P:T " + currentMap.getMyProtosswinrate()
								+ ":" + currentMap.getYourTerranwinrate() + "</center></body></html>");
				s.Mapdatalabel.setFont(new Font("맵 정보", Font.ITALIC, 17));
				s.Mapdatalabel.setForeground(Color.white);
				s.Mapdatalabel.setBounds(180, -20, 200, 200);
				ImageIcon icon = new ImageIcon("images/맵/" + s.NewMap.get(4) + ".gif");
				s.Mapla.setIcon(icon);
				s.Mapla.setBounds(30, -20, 200, 200);
			}
		});
		
		currentMap.data(s.NewMap.get(0));
		s.Mapla.setVisible(true);
		s.Mapdatalabel.setVisible(true);
		s.Mapdatalabel.setText("<html><body><center>" + s.NewMap.get(0) + "<br>T:Z "
				+ currentMap.getMyTerranwinrate() + ":" + currentMap.getYourZergwinrate() + "<br>Z:P "
				+ currentMap.getMyZergwinrate() + ":" + currentMap.getYourProtosswinrate() + "<br>P:T "
				+ currentMap.getMyProtosswinrate() + ":" + currentMap.getYourTerranwinrate()
				+ "</center></body></html>");
		s.Mapdatalabel.setFont(new Font("맵 정보", Font.ITALIC, 17));
		s.Mapdatalabel.setForeground(Color.white);
		s.Mapdatalabel.setBounds(180, -20, 200, 200);
		ImageIcon icon = new ImageIcon("images/맵/" + s.NewMap.get(0) + ".gif");
		s.Mapla.setIcon(icon);
		s.Mapla.setBounds(30, -20, 200, 200);
		////////////////////////////////////엔트리 설정 및 맵정보 로드////////////////////////////////////////////////////
	
		JButton jb = new JButton("엔트리 제출");
		jb.setBounds(475, 810, 150, 40);
		

		JButton jb1 = new JButton("엔트리 재설정");
		jb1.setBounds(625, 810, 150, 40);
		jb1.setEnabled(false);
		c.add(jb1);

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
							for (int k = 0; k < 4; k++) {
								s.setbtn[k].setEnabled(false);
							}
							jb1.setEnabled(true);
							strBtn1.setText("경기 시작");
						}
						sunsuentry = 5;
					}

				}

				s.randomentry();
				for (int i = 0; i < s.num2.length; i++) {

					String yourentry = s.v1.get(s.num2[i]).trim();
					s.Yourentry[i] = yourentry;

				}/////////상대팀도 엔트리 제출////////////////

			}
		});

		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jb1.setEnabled(false);
				strBtn1.setEnabled(false);
				for (int k = 0; k < 4; k++) {
					s.setbtn[k].setEnabled(true);
				}
			}
		});
		//////////////////////////////////////엔트리 재설정//////////////////
		sunsupanel1.setLayout(null);
		sunsupanel1.setBounds(700,330,205,460);
		sunsupanel1.add(s.anotherTeamJList);
		sunsupanel1.setBackground(Color.black);
		sunsupanel1.setBorder(new TitledBorder(new LineBorder(Color.white, 3),"선수들",2,0,new Font("",Font.BOLD,20),Color.white));
		s.anotherTeamJList.setBounds(25, 30, 150, 400);
		try {
			String str;
			BufferedReader br = new BufferedReader(new FileReader("src/" + s.NewTeam.get(s.num[s.wincount]) + ".txt")); // 불러올
																														// 파일이름
			s.v1.clear();
			while ((str = br.readLine()) != null) {


				s.v1.add(str + "\n");
				s.anotherTeamJList.setListData(s.v1);

			}

			br.close();

		} catch (IOException e2) {
			e2.printStackTrace();
		}

		s.anotherTeamJList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				JList jl = (JList) e.getSource();
				String name = (String) jl.getSelectedValue();
				String name1 = name.trim();

				ImageIcon icon = new ImageIcon("images/" + name1 + ".gif");

				s.sunsu2.setVisible(true);
				s.sunsu2.setIcon(icon);

				s.sunsu2name.setVisible(true);
				s.sunsu2name.setText(name1);
				s.sunsu2name.setForeground(Color.white);

				
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
//				s.statlabel2.setVisible(true);
				
//				s.statlabel2.setText("<html><body><center>공격력: " + s.atk2 + "<br>수비력: " + s.def2 + "<br>전략: "
//						+ s.tectics2 + "<br>센스: " + s.sense2 + "<br>물량: " + s.supply2 + "<br>컨트롤: " + s.control2
//						+ "<br>견제: " + s.keep2 + "<br>정찰: " + s.recon2
//						+"<br>종족: " + s.type2 + "</center></body></html>");
//
//				s.statlabel2.setForeground(Color.white);
//				s.statlabel2.setBackground(Color.black);

			}
		});
		
		s.sunsu2.setBounds(960, 380, 100, 100);
		s.sunsu2name.setBounds(990, 450, 100, 100);
//		s.statlabel2.setBounds(960, 500, 150, 150);
		draw1.setBounds(910,510,200,200);
		///////////////////////////////상대팀 선수목록 리스트//////////////////////
		
		
		ImageIcon team = new ImageIcon("images/로고/" + Myteam + ".gif");

		JLabel teamLabel = new JLabel();
		teamLabel.setIcon(team);
		teamLabel.setBounds(100, 30, 150, 100);

		ImageIcon team1 = new ImageIcon("images/로고/" + s.NewTeam.get(s.num[s.wincount]) + ".gif");
		JLabel yourteam = new JLabel();
		yourteam.setIcon(team1);
		yourteam.setBounds(950, 30, 150, 100);
		
        ////////////////////////////////////////////로고///////////////////////////////
		JLabel PvP = new JLabel();
		PvP.setText("0           :           0");
		PvP.setFont(new Font("PvP", Font.PLAIN, 70));
		PvP.setForeground(Color.white);
		PvP.setBounds(360, 0, 600, 200);
		///////////////////////////////PVP////////////////////////////////////
		
		JLabel moneylabel = new JLabel("<html><body><center>보유 금액: "+ s.money + "<br> 스나이핑 사용:맵과 상대선수 클릭후 스나이핑 버튼 클릭+ </center></body></html>");
		moneylabel.setFont(new Font("돈", Font.BOLD,20));
		moneylabel.setForeground(Color.white);
		moneylabel.setBounds(100, 750 , 150, 150);
		
		JButton ItemButton = new JButton("스나이핑(비용 40),경기당 1회 사용가능");
		
		
		ItemButton.setBounds(940, 750, 250, 30);
		ItemButton.setEnabled(true);
		ItemButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(s.money>=40 && !setlabel[sunsuentry].getText().equals("empty"));
				if(s.money>=40 && !setlabel[sunsuentry].getText().equals("empty")) {
					s.money -=40;
					String sniping = s.anotherTeamJList.getSelectedValue().trim();
					System.out.println(sunsuentry);
					System.out.println(sniping);
					s.sniperitem = sniping;
					s.snipercount = sunsuentry;
					ItemButton.setEnabled(false);
				}
				
			}
		});
		/////////////////////////////////////////////////////////////////////
		add(ItemButton);
		add(moneylabel);
		add(s.draw);
		add(draw1);
		add(s.sunsupanel);
		add(sunsupanel1);
		add(s.sunsu1name);
		add(s.sunsu1);
		add(s.sunsu2name);
		add(s.sunsu2);
		add(teamLabel);
		add(yourteam);
		add(jb);
		add(jb1);
		add(strBtn1);
		add(PvP);
		add(resetbtn);
//		add(s.statlabel);
//		add(s.statlabel2);
		add(finalLabel);
		setSize(1200, 1000);
		setVisible(true);
		
		
		
	}
	class MymouseAdapter extends MouseAdapter {
		ProjectMain s;
		MymouseAdapter(JFrame f){
			s = (ProjectMain)f;
		}
		public void mouseClicked(MouseEvent e) {

			JList jl = (JList) e.getSource();
			String name = (String) jl.getSelectedValue();
			String name1 = name.trim();

			s.sunsu1.setVisible(true);
			ImageIcon icon = new ImageIcon("images/" + name1 + ".gif");

			s.sunsu1.setIcon(icon);
			s.sunsu1name.setText(name1);
			s.sunsu1name.setForeground(Color.white);
			setlabel[sunsuentry].setText(name1);

		}
	}
	
	
	
}
