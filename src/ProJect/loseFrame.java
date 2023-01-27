package ProJect;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

class loseFrame extends JFrame {
	private JButton resetBtn = new JButton("R");

	public loseFrame(JFrame f,String Myteam, int grade1) {
		setTitle("MyStarCraft");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.black);
		
		ProjectMain s = (ProjectMain)f;

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
				s.wincount = 0;
				s.grade = 4;
				s.season++;
				for (int i = 0; i < 6; i++) {

					s.winLabel1[i].setText("");
					s.loseLabel1[i].setText("");
				}
				for (int i = 0; i < 2; i++) {
					s.winla[i] = new JLabel("");
					s.losela[i] = new JLabel("");
				}
				s.randomteam();
				s.NewTeam = new ArrayList<String>();
				for (String temp : s.Team) {
					if (!temp.equals(s.TeamCombo.getSelectedItem()))
						s.NewTeam.add(temp);
				}
				setVisible(false);
				dispose();
				if(s.tonerment == false) {
				new YourFrame(f,Myteam);
				}
				if(s.tonerment == true) {
					new YourFrame2(f,Myteam);
				}
			}
		});
		if (grade1 == 1) {
			s.Victorycount++;
			
		} else {
			s.Victorycount = 0;
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
