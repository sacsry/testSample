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
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ProjectMain extends JFrame {
	String Team[] = { "KT 롤스터", "SK 텔레콤 T1", "화승 OZ", "하이트 스파키즈", "MBC게임 히어로", "CJ 엔투스", "삼성전자 칸", "STX 소울",
			"웅진 스타즈", "eStrO", "위메이드 FOX", "공군 ACE" };
	
	JComboBox<String> TeamCombo = new JComboBox<String>(Team);
	ArrayList<String> NewTeam;
	Vector<String> v = new Vector<String>();//// 우리팀 선수목록
	Vector<String> v1 = new Vector<String>();////상대 팀선수목록
	JList<String> member1JList = new JList<String>(v);
	JList<String> anotherTeamJList = new JList(v1);
    String Myteam;
    private JButton resetBtn = new JButton("R");
    private JLabel la1 = new JLabel();
	private JLabel la2 = new JLabel();
	private JLabel la = new JLabel("팀을 선택해주세요!");
	
	String type1;
	int atk1;
	int def1;
	int control1;
	int tectics1;
	int sense1;
	int supply1;
	int recon1;
	int keep1;
	String grade1;
	int sum1;
	
	/////////////////우리팀 스탯///////////////////
	
	String type2;
	int atk2;
	int def2;
	int control2;
	int tectics2;
	int sense2;
	int supply2;
	int sum2;
	int recon2;
	int keep2;
	String grade2;
	
	int season = 1;
	//////////상대선수 스탯////////////////////
	
	JLabel statlabel = new JLabel();
	JLabel statlabel2 = new JLabel();
	JPanel statpanel = new JPanel();
	JPanel statpanel2 = new JPanel();
	
	//////////////////////스텟 라벨////////////////
	JLabel sunsu1 = new JLabel();
	JLabel sunsu1name = new JLabel();
	JLabel sunsu2 = new JLabel();
	JLabel sunsu2name = new JLabel();
	///////////////선수 이름///////////////////
	ArrayList<String> NewMap; /// 맵 리스트
	JButton[] setbtn = new JButton[5]; // 세트 버튼
	
	
	String Myentry[] = new String[5];
	String Yourentry[] = new String[5];
	/////////////////////엔트리///////////////////
	
	int wincount1 ;
	int losecount1 ;
	int count1 ;
	int Victorycount;
	///////////////////////세트 승리 및 패배 카운트//////////////////
	int sum3;
	
	int num[] = new int[3];// 랜덤 팀 생성	
	int num2[] = new int[4];///상대 엔트리 랜덤
	
	int wincount;///////매치 승리 카운트
	
	JLabel Mapla = new JLabel();
	JLabel Mapdatalabel = new JLabel();
	///////////////////맵 사진 및 데이터///////////////////
	
	Recorddata recorddb = new Recorddata();
	sunsu sunsudb = new sunsu();
	String yourACECARD = "ACE";
	String ACECARD = "ACE";
	JLabel[] winLabel1 = new JLabel[6];
	JLabel[] loseLabel1 = new JLabel[6];
	///////////////////////////////////////////////////////
	

	JLabel[] winla = new JLabel[2];
	JLabel[] losela = new JLabel[2];
	////////////////////////대진표 라벨///////////////////

	JTextArea Text = new JTextArea();
	int grade = 4;

	JPanel sunsupanel = new JPanel();
	boolean WIN;
	boolean Lose;
	
	JLabel Teamname = new JLabel();
	/////////////////////////////////////////////////////////
	int money = 50;
	String sniperitem;
	int snipercount;
	boolean answer;
	//////////////////////////////////////////////////////////
	
	Drawlabel draw;
	
	public ProjectMain(){
		setTitle("MyStarCraft");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setResizable(false);

		sunsudb.recordreset();
		recorddb.deleteRecorddata();
		Container c = getContentPane();
		c.setBackground(Color.black);
		c.setLayout(null);
		
		for (int i = 0; i < 6; i++) {

			winLabel1[i] = new JLabel("");
			loseLabel1[i] = new JLabel("");
		}///////////////////////경기 스코어 라벨 생성//////////////
		
		for (int i = 0; i < 2; i++) {
			winla[i] = new JLabel("");
			losela[i] = new JLabel("");
		}/////////////////대진표 스코어 라벨 생성//////////////////
		System.out.println("1");
//		statlabel.setBounds(600, 390, 150, 150);
//		c.add(statlabel);
		draw = new Drawlabel(this);
		draw.setLayout(null);
		draw.setBounds(600, 450, 300, 300);
//		statpanel.setBackground(Color.black);
		
		c.add(draw);
		JLabel logolabel = new JLabel();
		TeamCombo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JComboBox<String> t = (JComboBox<String>) e.getSource();
				Object Item = t.getSelectedItem();

				
//				statlabel.setVisible(true);
//				la1.setVisible(false);
//				la2.setVisible(true);
				try {
					String str;
					BufferedReader br = new BufferedReader(new FileReader("src/" + Item + ".txt")); // 불러올
																												// 파일이름
					v.clear();
					while ((str = br.readLine()) != null) {

						v.add(str + "\n");
						member1JList.setListData(v);

					}
					br.close();

				} catch (IOException e2) {
					e2.printStackTrace();
				}
				ImageIcon icon1 = new ImageIcon("images/" + v.get(0).trim() + ".gif");
				la1.setIcon(icon1);
				la2.setText(v.get(0).trim());
				la2.setForeground(Color.white);
				sunsudb.data(v.get(0).trim());
				atk1 = sunsudb.getAtk();
				def1 = sunsudb.getDef();
				tectics1 = sunsudb.getTectics();
				sense1 = sunsudb.getSense();
				supply1 = sunsudb.getSupply();
				control1 = sunsudb.getControl();
				type1 = sunsudb.getType();
				recon1 = sunsudb.getRecon();
				keep1 = sunsudb.getKeep();
				grade1 = sunsudb.getGrade();

//				statlabel.setVisible(true);
//				statlabel.setText("<html><body><center>공격력: " + atk1 + "<br>수비력: " + def1 + "<br>전략: " + tectics1
//						+ "<br>센스: " + sense1 + "<br>물량: " + supply1 + "<br>컨트롤: " + control1 
//						+"<br>견제: " + keep1 + "<br>정찰: " + recon1 + "<br>종족: " + type1+ "</center></body></html>");
//
//				statlabel.setForeground(Color.white);
//				statlabel.setBackground(Color.black);

				Myteam = (String) TeamCombo.getSelectedItem();
				Teamname.setText(Myteam);
			}
			
		});
		JButton strBtn = new JButton("시작");
		
		JFrame a = this;
		strBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if(v.get(0) != null) {
				randomteam();
				NewTeam = new ArrayList<String>();
				for (String temp : Team) {
					if (!temp.equals(Myteam))
						NewTeam.add(temp);
				}

				setVisible(false);
				dispose();
				new YourFrame(a, Myteam);
				
				}
			}
		});
		
		
		
		member1JList.setBounds(25, 25, 200, 400);
		MyMouseListener listener = new MyMouseListener(this);
		member1JList.addMouseListener(listener);
//		member1JList.setBorder(new TitledBorder(new LineBorder(Color.green, 2), "선수들"));
		//

		
		la1.setBounds(600, 200, 200, 200);
		la2.setBounds(630, 280, 200, 200);
		strBtn.setBounds(350, 650, 100, 30);
		resetBtn.setBounds(0, 0, 50, 50);
		la.setFont(new Font("팀 선택", Font.ITALIC, 40));
		la.setForeground(Color.white);
		la.setBounds(235, 0, 500, 100);
		
		Teamname.setBounds(100, 350, 150, 50);
		Teamname.setFont(new Font("팀명",Font.BOLD,20));
		Teamname.setForeground(Color.white);
		TeamCombo.setBounds(300, 100, 200, 30);

		ImageIcon logo = new ImageIcon("images/로고/logo.gif");
//		Image img = logo.getImage();
//		Image changeImg = img.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
//		ImageIcon changelogo = new ImageIcon(changeImg);

		logolabel.setIcon(logo);
		logolabel.setBounds(100, 200, 200, 200);
		ImageIcon icon = new ImageIcon("images/로고/Logo2.gif");
		la1.setIcon(icon);
		sunsupanel.setLayout(null);
		sunsupanel.setBounds(280,160,255,460);
		sunsupanel.add(member1JList);
		sunsupanel.setBackground(Color.black);
		sunsupanel.setBorder(new TitledBorder(new LineBorder(Color.white, 3),"선수들",2,0,new Font("",Font.BOLD,20),Color.white));
		c.add(sunsupanel);
		c.add(Teamname);
//		c.add(member1JList);
		c.add(logolabel);
		c.add(la);
		c.add(TeamCombo);
		c.add(resetBtn);
//		c.add(member1JList);
		c.add(la1);
		c.add(la2);
		c.add(strBtn);

		setSize(800, 800);
		setVisible(true);

	}

	class MyMouseListener extends MouseAdapter {
		ProjectMain s;
		public MyMouseListener(JFrame f) {
			s = (ProjectMain)f;
		}
		public void mouseClicked(MouseEvent e) {
		JList jl = (JList) e.getSource();
		String name = (String) jl.getSelectedValue();
		String name1 = name.trim();

		ImageIcon icon = new ImageIcon("images/" + name1 + ".gif");

		la1.setVisible(true);
		la2.setVisible(true);
		la1.setIcon(icon);
		la2.setText(name);
		la2.setForeground(Color.white);

		
		sunsudb.data(name1);
		atk1 = sunsudb.getAtk();
		def1 = sunsudb.getDef();
		tectics1 = sunsudb.getTectics();
		sense1 = sunsudb.getSense();
		supply1 = sunsudb.getSupply();
		control1 = sunsudb.getControl();
		type1 = sunsudb.getType();
		recon1 = sunsudb.getRecon();
		keep1 = sunsudb.getKeep();
		grade1 = sunsudb.getGrade();
		
		draw.repaint();

//		statlabel.setVisible(true);
//		statlabel.setText("<html><body><center>공격력: " + atk1 + "<br>수비력: " + def1 + "<br>전략: " + tectics1
//				+ "<br>센스: " + sense1 + "<br>물량: " + supply1 + "<br>컨트롤: " + control1 
//				+"<br>견제: " + keep1 + "<br>정찰: " + recon1+ "<br>종족: " + type1 + "</center></body></html>");
//
//		statlabel.setForeground(Color.white);
//		statlabel.setBackground(Color.black);

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
//	public void paint(Graphics g) {
//		super.paint(g);
//		g.setColor(Color.white);
//		g.drawRect(280,180,255,460);
//	}
	public static void main(String[] args) {
		new ProjectMain();
	}
}
