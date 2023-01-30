package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class YourFrame extends JFrame{

	private JButton resetBtn = new JButton("R");
	private JButton dataBtn = new JButton("선수 정보");

	
	public YourFrame(JFrame f, String Myteam) {
		super("MyStarCraft");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.black);
		
		ProjectMain s = (ProjectMain)f;
		setResizable(false);
		
		DrawPanel panel = new DrawPanel(f);
		panel.setBackground(Color.black);
		panel.setBounds(0, 0, 1200, 700);
		c.add(panel);
		resetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				dispose();
				new ProjectMain();
			}
		});
		
		JFrame a = this;
		
		JButton strBtn1 = new JButton("시작");
		strBtn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				dispose();
				
				new EntryFrame(f,Myteam);

			}
		});
		
		strBtn1.setBounds(550, 900, 100, 30);
		dataBtn.setBounds(250, 900, 150, 30);

		dataBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				dispose();
				new sunsudata(f,Myteam);
			}
		});
		
	
		
		ImageIcon team = new ImageIcon("images/로고/" + Myteam + ".gif");
		ImageIcon team1 = new ImageIcon("images/로고/" + s.NewTeam.get(s.num[0]) + ".gif");
		ImageIcon team2 = new ImageIcon("images/로고/" + s.NewTeam.get(s.num[1]) + ".gif");
		ImageIcon team3 = new ImageIcon("images/로고/" + s.NewTeam.get(s.num[2]) + ".gif");

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
		
		add(teamLabel);
		add(teamLabel1);
		add(teamLabel2);
		add(teamLabel3);
		add(dataBtn);
		add(strBtn1);
		
		add(resetBtn);
		resetBtn.setBounds(0, 0, 50, 50);
		setSize(1200, 1000);
		setVisible(true);
		
		
		
	}
	class DrawPanel extends JPanel {
		JLabel la = new JLabel();
		JLabel victoryla; 
		int wincount2;
		int losecount2;
		ProjectMain s;
		
		DrawPanel(JFrame f){
			s = (ProjectMain)f;
		}

		public void paint(Graphics g) {
			super.paint(g);
			setLayout(null);
			la.setText("프로리그 시즌"+s.season+" 준플레이오프");

			victoryla = new JLabel(s.Victorycount + "회 연속 우승");
			for (int i = 0; i < 2; i++) {
				s.winla[i].setFont(new Font("승리세트 카운트", Font.ITALIC, 20));
				s.losela[i].setFont(new Font("패배세트 카운트", Font.ITALIC, 20));
				s.winla[i].setForeground(Color.WHITE);
				s.losela[i].setForeground(Color.WHITE);
			}

			g.setColor(Color.GREEN);
			g.drawLine(160, 750, 160, 550);
			g.setColor(Color.gray);
			if (s.wincount == 2) {
				la.setText("프로리그 시즌"+s.season+" 결승");
				g.setColor(Color.green);
				s.winla[1].setText(s.wincount1 + "");
				s.losela[1].setText(s.losecount1 + "");
				s.winla[0].setBounds(280, 500, 50, 50);
				s.losela[0].setBounds(330, 500, 50, 50);
				s.winla[1].setBounds(505, 360, 50, 50);
				s.losela[1].setBounds(555, 360, 50, 50);
			}
			g.drawLine(535, 400, 535, 250);
			g.drawLine(310, 400, 535, 400);
			if (s.wincount == 1) {
				wincount2 = s.wincount1;
				losecount2 = s.losecount1;
				la.setText("프로리그 시즌"+s.season+" 플레이오프");
				g.setColor(Color.green);
				s.winla[0].setText(wincount2 + "");
				s.losela[0].setText(losecount2 + "");
				s.winla[0].setBounds(280, 500, 50, 50);
				s.losela[0].setBounds(330, 500, 50, 50);
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
			
			victoryla.setBounds(700, 100, 300, 150);
			victoryla.setFont(new Font("우승", Font.ITALIC, 30));
			victoryla.setForeground(Color.green);
			la.setBounds(300, 0, 700, 150);
			la.setFont(new Font("포스트시즌", Font.ITALIC, 50));
			la.setForeground(Color.WHITE);
			add(s.winla[0]);
			add(s.losela[0]);
			add(s.winla[1]);
			add(s.losela[1]);
			add(victoryla);
			add(la);
		}
	}
	

}
