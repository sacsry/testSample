package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class YourFrame3 extends JFrame {

	private JLabel[] teamla = new JLabel[11];
	ImageIcon[] image = new ImageIcon[12];
	Image[] img = new Image[12];

	YourFrame3(JFrame f, String Myteam) {
		super("MystarCraft");
		ProjectMain s = (ProjectMain) f;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.black);

		s.gamejung = false;
		s.teamdb.array();

		setResizable(false);
		
		for(int i =0; i<7;i++) {
			s.setlabel[i] = new JLabel("Hidden");
			s.Mysunsulabel[i] = new JLabel("Hidden");
			s.Yoursunsulabel[i] = new JLabel("Hidden");
		}
		s.wincount1 = 0;
		s.losecount1 = 0;
		s.count1 = 0;

		JButton resetBtn = new JButton("R");
		resetBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				new ProjectMain();
			}
		});

		JLabel roundla = new JLabel(s.round + "라운드 경기일정");
		roundla.setFont(new Font("라운드 일정", Font.ITALIC, 40));
		roundla.setBounds(450, 0, 400, 100);
		roundla.setForeground(Color.white);
		c.add(roundla);

		for (int i = 0; i < 11; i++) {
			int a = 0;
			int b = 0;
			if (i % 2 != 0) {
				a = 500;
			}
//			s.yourteam.add(s.NewTeam.get(s.num[i]));
			b = i / 2;
			teamla[i] = new JLabel();
			teamla[i].setForeground(Color.white);
			teamla[i].setBounds(100 + a, 150 + (100 * b), 500, 100);
			teamla[i].setText("vs " + s.yourteam.get(i));
			teamla[i].setFont(new Font("상대팀", Font.ITALIC, 20));
			teamla[i].setBorder(new LineBorder(Color.white, 3));
			c.add(teamla[i]);

			s.seasonwinsetla[i].setBounds(400 + a, 170 + (100 * b), 70, 50);
			s.seasonlosesetla[i].setBounds(430 + a, 170 + (100 * b), 70, 50);
			s.seasonwinla[i].setBounds(460 + a, 170 + (100 * b), 70, 50);
			s.seasonwinsetla[i].setFont(new Font("승리스코어", Font.ITALIC, 20));
			s.seasonlosesetla[i].setFont(new Font("패배스코어", Font.ITALIC, 20));
			s.seasonwinla[i].setFont(new Font("결과", Font.ITALIC, 20));

			s.seasonwinsetla[i].setForeground(Color.white);
			s.seasonlosesetla[i].setForeground(Color.white);

			c.add(s.seasonwinsetla[i]);
			c.add(s.seasonlosesetla[i]);
			c.add(s.seasonwinla[i]);

		}
		teamla[s.week].setBorder(new LineBorder(Color.green, 5));

//		s.array[0][0][0] = Myteam;
//		s.array[0][0][1] = s.yourteam.get(0);
//
//		int a = 1;
//
//		for (int i = 1; i < 6; i++) {
//			for (int k = 0; k < 2; k++) {
//
//				s.array[0][i][k] = s.yourteam.get(a);
//				a++;
//			}
//		}
//
//		s.yourteam = new ArrayList<String>();
//		s.yourteam.add(s.array[0][0][1]);
//		for (int j = 1; j < 11; j++) {
//			
//			s.array[j][0][1] = s.array[j - 1][1][0];
//			s.yourteam.add(s.array[j][0][1]);
//			for (int i = 1; i < 6; i++) {
//
//				s.array[j][i][1] = s.array[j - 1][i - 1][1];
//
//				if (i == 5) {
//					s.array[j][5][0] = s.array[j - 1][5][1];
//				} else {
//					s.array[j][i][0] = s.array[j - 1][i + 1][0];
//				}
//
//			}
//
//		}

		for (int j = 0; j < 11; j++) {
//			System.out.println(Myteam + "vs" + s.array[j][0][1]);
			teamla[j].setText("vs " + s.yourteam.get(j));
			for (int i = 1; i < 6; i++) {

//				System.out.println(s.array[j][i][0] + "vs" + s.array[j][i][1]);

			}
//			System.out.println("--------------------------------");
		}

//		System.out.println(Arrays.deepToString(s.array[0]));
//		System.out.println(Arrays.deepToString(s.array[1]));

		resetBtn.setBounds(0, 0, 50, 50);

		JButton strbtn = new JButton("시작");
		strbtn.setBounds(500, 800, 150, 30);

		strbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				dispose();
				if(s.round%3 !=0)
				new EntryFrame(f, Myteam);
				if(s.round%3 ==0) {
				new winnersEntryFrame(f, Myteam, 0,0,0);
				}
			}
		});

		c.add(strbtn);

		JButton strbtn1 = new JButton("팀 순위");
		strbtn1.setBounds(900, 800, 150, 30);

		strbtn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				dispose();
				new teamth(f, Myteam);

			}
		});

		JButton dataBtn = new JButton("선수 정보");
		dataBtn.setBounds(150, 800, 150, 30);

		dataBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				dispose();
				new sunsudata(f, Myteam);
				System.out.println(s.yourteam);
				for (int j = 0; j < 11; j++) {
					System.out.println(s.array[j][0][1]);
					}

			}
		});
		c.add(dataBtn);

		JButton rankBtn = new JButton("선수 다승순위");
		rankBtn.setBounds(150, 830, 150, 30);

		rankBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				dispose();
				s.sunsudb.array();
				new sunsuwinranking(f, Myteam);

			}
		});
		c.add(rankBtn);

		MyPanel p = new MyPanel(f, Myteam);

		p.setBounds(0, 0, 1200, 800);
		p.setBackground(Color.black);
		c.add(p);

		c.add(strbtn1);
		c.add(resetBtn);
		setVisible(true);
		setSize(1200, 1000);
	}

	class MyPanel extends JPanel {

		ProjectMain s;

		MyPanel(JFrame f, String Myteam) {
			s = (ProjectMain) f;
		}

		public void paint(Graphics g) {
			super.paint(g);
			setLayout(null);

			for (int i = 0; i < 11; i++) {
				int a = 0;
				int b = 0;
				if (i % 2 != 0) {
					a = 500;
				}
				b = i / 2;
				image[i] = new ImageIcon("images/로고/" + s.yourteam.get(i) + ".gif");
				img[i] = image[i].getImage();
				g.setColor(Color.white);
//			    g.setFont(new Font("",Font.ITALIC,20));

				g.drawImage(img[i], 300 + a, 170 + (100 * b), 70, 50, this);
			}

		}

	}
}
