package ProJect;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.sql.*;
import java.util.ArrayList;

class sunsudata extends JFrame {

	String Team[] = { "KT 롤스터", "SK 텔레콤 T1", "화승 OZ", "하이트 스파키즈", "MBC게임 히어로", "CJ 엔투스", "삼성전자 칸", "STX 소울", "웅진 스타즈",
			"eStrO", "위메이드 FOX", "공군 ACE" };
	JComboBox<String> TeamCombo = new JComboBox<String>(Team);
	private int win;
	private int lose;
	private int vsTwincount;
	private int vsZwincount;
	private int vsPwincount;
	private int vsTlosecount;
	private int vsZlosecount;
	private int vsPlosecount;
	ArrayList<String> anotherplayer;
	ArrayList<String> Map;
	ArrayList<String> result;
	private JLabel[] record = new JLabel[10];

	int vsTwin;
	int vsTlose;
	int vsZwin;
	int vsZlose;
	int vsPwin;
	int vsPlose;

	private JPanel textpanel = new JPanel();
	public sunsudata(JFrame f, String Myteam) {

		setTitle("Mystarcraft");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.black);
		ProjectMain s = (ProjectMain) f;

		JPanel sunsupanel = new JPanel();
		JPanel recordpanel = new JPanel();
		JLabel sunsu1 = new JLabel();
		JLabel sunsu1name = new JLabel();
		JLabel recordlabel = new JLabel();
		JLabel vsTrecordlabel = new JLabel();
		JLabel vsZrecordlabel = new JLabel();
		JLabel vsPrecordlabel = new JLabel();
		JLabel winnumlabel = new JLabel();
		JLabel earlyrecord = new JLabel();
		JLabel vsTlabel = new JLabel("A");
		JLabel vsZlabel = new JLabel("b");
		JLabel vsPlabel = new JLabel("c");

		s.statlabel.setVisible(false);
		s.statlabel2.setVisible(false);

		for (int i = 0; i < 10; i++) {
			record[i] = new JLabel();
			sunsupanel.add(record[i]);
			record[i].setText("");
			record[i].setBounds(20, 60 + (30 * i), 600, 30);
			record[i].setFont(new Font("전적텍스트", Font.BOLD, 20));
			record[i].setBackground(Color.black);
		}

		s.sunsupanel.setLayout(null);
		s.sunsupanel.setBounds(350, 350, 205, 460);
		s.sunsupanel.add(s.member1JList);
		s.sunsupanel.add(s.anotherTeamJList);
		s.sunsupanel.setBackground(Color.black);
		s.sunsupanel.setBorder(new TitledBorder(new LineBorder(Color.white, 3), "선수들", 2, 0,
				new Font("", Font.BOLD, 20), Color.white));
		s.member1JList.setBounds(25, 30, 150, 400);
		s.anotherTeamJList.setBounds(25, 30, 150, 400);

		s.anotherTeamJList.setVisible(false);
		TeamCombo.setBounds(100, 900, 200, 50);
		add(TeamCombo);
//		add(s.anotherTeamJList);
		TeamCombo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JComboBox<String> t = (JComboBox<String>) e.getSource();
				Object Item = t.getSelectedItem();
				sunsu1.setVisible(false);
				sunsu1name.setVisible(false);
				s.statlabel.setVisible(false);
				s.statlabel2.setVisible(false);
				for (int i = 0; i < 10; i++) {
					record[i].setText("");
				}

				recordlabel.setVisible(false);
				vsTrecordlabel.setVisible(false);
				vsZrecordlabel.setVisible(false);
				vsPrecordlabel.setVisible(false);
				winnumlabel.setVisible(false);
				earlyrecord.setVisible(false);

				try {
					String str;
					BufferedReader br = new BufferedReader(new FileReader("src/" + Item + ".txt")); // 불러올
																									// 파일이름
					s.v1.clear();
					if (!Item.equals(Myteam)) {
						s.member1JList.setVisible(false);
						s.anotherTeamJList.setVisible(true);
						while ((str = br.readLine()) != null) {
							s.v1.add(str + "\n");
							s.anotherTeamJList.setListData(s.v1);
						}
					} else if (Item.equals(Myteam)) {
						s.member1JList.setVisible(true);
						s.anotherTeamJList.setVisible(false);
					}
					br.close();

				} catch (IOException e2) {
					e2.printStackTrace();
				}

			}

		});

		sunsupanel.setLayout(null);
		sunsupanel.setBounds(580, 400, 600, 400);
		sunsupanel.setBackground(Color.black);
		sunsupanel.add(winnumlabel);
		sunsupanel.add(earlyrecord);
		sunsupanel.setBorder(new TitledBorder(new LineBorder(Color.white, 3), "최근 전적", 0, 0,
				new Font("", Font.BOLD, 20), Color.white));

		recordpanel.setLayout(null);
		recordpanel.setBounds(580, 160, 600, 240);
		recordpanel.setBackground(Color.black);
		recordpanel.add(recordlabel);
		recordpanel.add(vsTrecordlabel);
		recordpanel.add(vsZrecordlabel);
		recordpanel.add(vsPrecordlabel);
		recordpanel.add(vsTlabel);
		recordpanel.add(vsZlabel);
		recordpanel.add(vsPlabel);
		recordpanel.setBorder(new LineBorder(Color.white, 3));

		winnumlabel.setBounds(480, 20, 100, 50);
		winnumlabel.setFont(new Font("연승텍스트", Font.BOLD, 20));
		winnumlabel.setBackground(Color.black);
		winnumlabel.setForeground(Color.white);

		earlyrecord.setBounds(20, 20, 300, 50);
		earlyrecord.setFont(new Font("최근전적", Font.BOLD, 20));
		earlyrecord.setBackground(Color.black);
		earlyrecord.setForeground(Color.white);
		s.member1JList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				JList jl = (JList) e.getSource();
				String name = (String) jl.getSelectedValue();
				String name1 = name.trim();

				int winnum = 0;// 연승
				int losenum = 0;// 연패
				sunsu1.setVisible(true);
				sunsu1name.setVisible(true);
				s.sunsudb.data(name1);
				win = s.sunsudb.getWincount();
				lose = s.sunsudb.getLosecount();
				vsTwincount = s.sunsudb.getVsTwincount();
				vsZwincount = s.sunsudb.getVsZwincount();
				vsPwincount = s.sunsudb.getVsPwincount();
				vsTlosecount = s.sunsudb.getVsTlosecount();
				vsZlosecount = s.sunsudb.getVsZlosecount();
				vsPlosecount = s.sunsudb.getVsPlosecount();
				int earlywin = 0;
				int earlylose = 0;

				anotherplayer = new ArrayList<String>();
				Map = new ArrayList<String>();
				result = new ArrayList<String>();

				recordlabel.setVisible(true);
				vsTrecordlabel.setVisible(true);
				vsZrecordlabel.setVisible(true);
				vsPrecordlabel.setVisible(true);
				winnumlabel.setVisible(true);
				earlyrecord.setVisible(true);
				for (int i = 0; i < 10; i++) {
					record[i].setText("");
				}

//				Recorddata rec = new Recorddata(name1);
				s.recorddb.searchRecorddata(name1);
				anotherplayer = s.recorddb.getAnotherplayer();
				Map = s.recorddb.getMap();
				result = s.recorddb.getResult();

/////////////////////////////////////////////////////////////////////////////////////////////////////////

			
				
				if (s.recorddb.getVsTwin() == 0) {
					vsTwin = s.recorddb.getVsTlose();
					vsTlabel.setText(vsTwin + " 연패중");
					vsTlabel.setFont(new Font("", Font.BOLD, 20));
					vsTlabel.setForeground(Color.red);
				}
				if (s.recorddb.getVsTlose() == 0) {
					vsTwin = s.recorddb.getVsTwin();
					vsTlabel.setText(vsTwin + " 연승중");
					vsTlabel.setFont(new Font("", Font.BOLD, 20));
					vsTlabel.setForeground(Color.green);
				}
				
				if (s.recorddb.getVsZwin() == 0) {
					vsZwin = s.recorddb.getVsZlose();
					vsZlabel.setText(vsZwin + " 연패중");
					vsZlabel.setFont(new Font("", Font.BOLD, 20));
					vsZlabel.setForeground(Color.red);
				}
				if (s.recorddb.getVsZlose() == 0) {
					vsZwin = s.recorddb.getVsZwin();
					vsZlabel.setText(vsZwin + " 연승중");
					vsZlabel.setFont(new Font("", Font.BOLD, 20));
					vsZlabel.setForeground(Color.green);
				}
				
				if (s.recorddb.getVsPwin() == 0) {
					vsPwin = s.recorddb.getVsPlose();
					vsPlabel.setText(vsPwin + " 연패중");
					vsPlabel.setFont(new Font("", Font.BOLD, 20));
					vsPlabel.setForeground(Color.red);
				}
				if (s.recorddb.getVsPlose() == 0) {
					vsPwin = s.recorddb.getVsPwin();
					vsPlabel.setText(vsPwin + " 연승중");
					vsPlabel.setFont(new Font("", Font.BOLD, 20));
					vsPlabel.setForeground(Color.green);
				}

//////////////////////////////////////////////////////////////////////테저프연승라벨////////////////////////////////////////

				winnumlabel.setText(winnum + " 연승중");
				winnumlabel.setForeground(Color.white);

				earlyrecord.setForeground(Color.white);
				for (int i = 0; i < Map.size(); i++) {

					record[i].setText(
							result.get(i) + "      vs      " + anotherplayer.get(i) + "    on    " + Map.get(i) + "\n");
					sunsupanel.add(record[i]);
					if (result.get(i).equals("승")) {

						record[i].setForeground(Color.green);
						earlywin++;
//						winnum++;
						losenum = 0;
						winnumlabel.setText(s.recorddb.getWin() + " 연승중");
						winnumlabel.setForeground(Color.green);

					} else if (result.get(i).equals("패")) {
						winnum = 0;
						earlylose++;
//						losenum++;
						winnumlabel.setText(s.recorddb.getLose() + " 연패중");
						winnumlabel.setForeground(Color.red);
						record[i].setForeground(Color.red);
					}

				}

				earlyrecord.setText("최근 10전:" + earlywin + "승 " + earlylose + "패");

				recordlabel.setText("총 전적:    " + win + "   승   " + lose + "   패    ("
						+ (Math.round((double) win * 100.0 / (double) (win + lose))) + ")%");
				recordlabel.setForeground(Color.white);
				recordlabel.setBounds(20, -20, 600, 100);
				recordlabel.setFont(new Font("전적라벨", Font.BOLD, 30));

				vsTrecordlabel.setBounds(20, 40, 300, 80);
				vsTrecordlabel.setText("VS Terran         " + s.sunsudb.getVsTwincount() + "승     "
						+ s.sunsudb.getVsTlosecount() + "패");
				vsTrecordlabel.setFont(new Font("", Font.BOLD, 20));
				vsTrecordlabel.setForeground(Color.WHITE);
				vsZrecordlabel.setBounds(20, 100, 300, 80);
				vsZrecordlabel.setText("VS Zerg           " + s.sunsudb.getVsZwincount() + "승     "
						+ s.sunsudb.getVsZlosecount() + "패");
				vsZrecordlabel.setFont(new Font("", Font.BOLD, 20));
				vsZrecordlabel.setForeground(Color.WHITE);
				vsPrecordlabel.setBounds(20, 160, 300, 80);
				vsPrecordlabel.setText("VS Protoss        " + s.sunsudb.getVsPwincount() + "승     "
						+ s.sunsudb.getVsPlosecount() + "패");
				vsPrecordlabel.setFont(new Font("", Font.BOLD, 20));
				vsPrecordlabel.setForeground(Color.WHITE);

				vsTlabel.setBounds(420, 40, 200, 80);
				vsZlabel.setBounds(420, 100, 200, 80);
				vsPlabel.setBounds(420, 160, 200, 80);
				ImageIcon icon = new ImageIcon("images/" + name1 + ".gif");

				sunsu1.setIcon(icon);
				sunsu1name.setText(name1);
				sunsu1name.setForeground(Color.white);

			}
		});

		s.anotherTeamJList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				JList jl = (JList) e.getSource();
				String name = (String) jl.getSelectedValue();
				String name1 = name.trim();

				int winnum = 0;// 연승
				int losenum = 0;// 연패
				sunsu1.setVisible(true);
				sunsu1name.setVisible(true);

				s.sunsudb.data(name1);
				win = s.sunsudb.getWincount();
				lose = s.sunsudb.getLosecount();
				vsTwincount = s.sunsudb.getVsTwincount();
				vsZwincount = s.sunsudb.getVsZwincount();
				vsPwincount = s.sunsudb.getVsPwincount();
				vsTlosecount = s.sunsudb.getVsTlosecount();
				vsZlosecount = s.sunsudb.getVsZlosecount();
				vsPlosecount = s.sunsudb.getVsPlosecount();
				int earlywin = 0;
				int earlylose = 0;

				anotherplayer = new ArrayList<String>();
				Map = new ArrayList<String>();
				result = new ArrayList<String>();

				recordlabel.setVisible(true);
				vsTrecordlabel.setVisible(true);
				vsZrecordlabel.setVisible(true);
				vsPrecordlabel.setVisible(true);
				winnumlabel.setVisible(true);
				earlyrecord.setVisible(true);
				for (int i = 0; i < 10; i++) {
					record[i].setText("");

				}

//				Recorddata rec = new Recorddata(name1);
				s.recorddb.searchRecorddata(name1);
				anotherplayer = s.recorddb.getAnotherplayer();
				Map = s.recorddb.getMap();
				result = s.recorddb.getResult();

				/////////////////////////////////////////////////////////////////////////////////////////////////////////

				if (s.recorddb.getVsTwin() == 0) {
					vsTwin = s.recorddb.getVsTlose();
					vsTlabel.setText(vsTwin + " 연패중");
					vsTlabel.setFont(new Font("", Font.BOLD, 20));
					vsTlabel.setForeground(Color.red);
				}
				if (s.recorddb.getVsTlose() == 0) {
					vsTwin = s.recorddb.getVsTwin();
					vsTlabel.setText(vsTwin + " 연승중");
					vsTlabel.setFont(new Font("", Font.BOLD, 20));
					vsTlabel.setForeground(Color.green);
				}
				
				if (s.recorddb.getVsZwin() == 0) {
					vsZwin = s.recorddb.getVsZlose();
					vsZlabel.setText(vsZwin + " 연패중");
					vsZlabel.setFont(new Font("", Font.BOLD, 20));
					vsZlabel.setForeground(Color.red);
				}
				if (s.recorddb.getVsZlose() == 0) {
					vsZwin = s.recorddb.getVsZwin();
					vsZlabel.setText(vsZwin + " 연승중");
					vsZlabel.setFont(new Font("", Font.BOLD, 20));
					vsZlabel.setForeground(Color.green);
				}
				
				if (s.recorddb.getVsPwin() == 0) {
					vsPwin = s.recorddb.getVsPlose();
					vsPlabel.setText(vsPwin + " 연패중");
					vsPlabel.setFont(new Font("", Font.BOLD, 20));
					vsPlabel.setForeground(Color.red);
				}
				if (s.recorddb.getVsPlose() == 0) {
					vsPwin = s.recorddb.getVsPwin();
					vsPlabel.setText(vsPwin + " 연승중");
					vsPlabel.setFont(new Font("", Font.BOLD, 20));
					vsPlabel.setForeground(Color.green);
				}
				

				////////////////////////////////////////////////////////////////////// 테저프연승라벨////////////////////////////////////////

				winnumlabel.setText(winnum + " 연승중");
				winnumlabel.setForeground(Color.white);

				earlyrecord.setForeground(Color.white);
				for (int i = 0; i < Map.size(); i++) {

					record[i].setText(result.get(i) + " vs " + anotherplayer.get(i) + "in" + Map.get(i) + "\n");
					sunsupanel.add(record[i]);
					if (result.get(i).equals("승")) {

						record[i].setForeground(Color.green);
						earlywin++;
//						winnum++;
						losenum = 0;
						winnumlabel.setText(s.recorddb.getWin() + " 연승중");
						winnumlabel.setForeground(Color.green);

					} else if (result.get(i).equals("패")) {
						winnum = 0;
						earlylose++;
//						losenum++;
						winnumlabel.setText(s.recorddb.getLose() + " 연패중");
						winnumlabel.setForeground(Color.red);
						record[i].setForeground(Color.red);
					}

				}

				earlyrecord.setText("최근 10전:" + earlywin + "승 " + earlylose + "패");

				recordlabel.setText("총 전적:    " + win + "   승   " + lose + "   패    ("
						+ (Math.round((double) win * 100.0 / (double) (win + lose))) + ")%");
				recordlabel.setForeground(Color.white);
				recordlabel.setBounds(20, 0, 600, 100);
				recordlabel.setFont(new Font("전적라벨", Font.BOLD, 30));

				vsTrecordlabel.setBounds(20, 40, 600, 80);
				vsTrecordlabel.setText("VS Terran            " + s.sunsudb.getVsTwincount() + "승     "
						+ s.sunsudb.getVsTlosecount() + "패");
				vsTrecordlabel.setFont(new Font("", Font.BOLD, 20));
				vsTrecordlabel.setForeground(Color.WHITE);
				vsZrecordlabel.setBounds(20, 100, 600, 80);
				vsZrecordlabel.setText("VS Zerg              " + s.sunsudb.getVsZwincount() + "승     "
						+ s.sunsudb.getVsZlosecount() + "패");
				vsZrecordlabel.setFont(new Font("", Font.BOLD, 20));
				vsZrecordlabel.setForeground(Color.WHITE);
				vsPrecordlabel.setBounds(20, 160, 600, 80);
				vsPrecordlabel.setText("VS Protoss           " + s.sunsudb.getVsPwincount() + "승     "
						+ s.sunsudb.getVsPlosecount() + "패");
				vsPrecordlabel.setFont(new Font("", Font.BOLD, 20));
				vsPrecordlabel.setForeground(Color.WHITE);

				

				s.sunsudb.data(name1);
				s.atk2 = s.sunsudb.getAtk();
				s.def2 = s.sunsudb.getDef();
				s.tectics2 = s.sunsudb.getTectics();
				s.sense2 = s.sunsudb.getSense();
				s.supply2 = s.sunsudb.getSupply();
				s.control2 = s.sunsudb.getControl();
				s.type2 = s.sunsudb.getType();

				s.statlabel2.setVisible(true);
				s.statlabel2.setText("<html><body><center>공격력: " + s.atk2 + "<br>수비력: " + s.def2 + "<br>전략: "
						+ s.tectics2 + "<br>센스: " + s.sense2 + "<br>물량: " + s.supply2 + "<br>컨트롤: " + s.control2
						+ "<br>종족: " + s.type2 + "</center></body></html>");

				s.statlabel2.setForeground(Color.white);
				s.statlabel2.setBackground(Color.black);

				ImageIcon icon = new ImageIcon("images/" + name1 + ".gif");

				sunsu1.setIcon(icon);
				sunsu1name.setText(name1);
				sunsu1name.setForeground(Color.white);

			}
		});

		JButton backBtn1 = new JButton("<<back");
		backBtn1.setBounds(550, 900, 100, 30);
		backBtn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				s.member1JList.setVisible(true);
				s.anotherTeamJList.setVisible(true);
				setVisible(false);
				dispose();
				new YourFrame(f, Myteam);

			}
		});

		s.statlabel.setBounds(120, 500, 150, 150);
		c.add(s.statlabel);

		s.statlabel2.setBounds(120, 500, 150, 150);
		c.add(s.statlabel2);
		sunsu1.setBounds(120, 380, 100, 100);
		sunsu1name.setBounds(140, 450, 100, 100);

		JLabel textla = new JLabel("선수 정보");
		textla.setFont(new Font("",Font.BOLD,40));
		textla.setForeground(Color.white);
		textpanel.setLayout(null);
		textpanel.setBounds(120,160,420,170);
		textpanel.add(textla);
		textla.setBounds(120,0,180,180);
		textpanel.setBackground(Color.black);
		textpanel.setBorder(new LineBorder(Color.white, 3));
		add(textpanel);
		
//		c.add(earlyrecord);
//		c.add(winnumlabel);
		c.add(sunsupanel);
		c.add(recordpanel);
//		c.add(recordlabel);
		c.add(backBtn1);
		c.add(s.sunsupanel);
		c.add(sunsu1);
		c.add(sunsu1name);
		setSize(1200, 1000);
		setVisible(true);

	}
}