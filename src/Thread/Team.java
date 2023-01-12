package Thread;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.*;

import ProJect.ProJectMain;

public class Team extends JFrame {

	private String Team[] = { "KT 롤스터", "SK 텔레콤 T1", "화승 OZ", "하이트 스파키즈", "MBC게임 히어로", "CJ 엔투스", "삼성전자 칸", "STX 소울",
			"웅진 스타즈", "eStrO", "위메이드 FOX", "공군 ACE" };
	private JLabel la = new JLabel("팀을 선택해주세요!");
	private JComboBox<String> TeamCombo = new JComboBox<String>(Team);
	private JButton strBtn = new JButton("시작");

	private Vector<String> v = new Vector<String>();
	private Vector<String> v1 = new Vector<String>();
	private JList<String> member1JList = new JList<String>(v);

	private JLabel la1 = new JLabel();
	private JLabel la2 = new JLabel();
	private JLabel la3 = new JLabel();

	public Team() {
		setTitle("MyStarCraft");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setBackground(Color.black);
		c.setLayout(new BorderLayout(30, 20));

		JPanel North = new JPanel();
		North.setLayout(new GridLayout(2, 1));
		North.setOpaque(true);

		JPanel North1 = new JPanel();
		North1.setBackground(Color.black);
		North1.setLayout(new FlowLayout(FlowLayout.CENTER));
		North1.add(la);
		North.add(North1);

		JPanel North2 = new JPanel();
		North2.add(TeamCombo);
		North2.setBackground(Color.black);
		North.add(North2);
		JPanel cen = new JPanel();
		JPanel cen1 = new JPanel();
		JPanel cen2 = new JPanel();

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

			}

		});
		MyMouseListener listener = new MyMouseListener();
		member1JList.addMouseListener(listener);
		
		cen.setLayout(new GridLayout(2, 1));
		cen.setOpaque(true);
		cen.setBackground(Color.black);
		cen1.setOpaque(true);
		cen1.setBackground(Color.black);
		cen2.setOpaque(true);
		cen2.setBackground(Color.black);

		cen2.add(new JScrollPane(member1JList));
		cen1.add(strBtn);

		cen.add(cen2);
		cen.add(cen1);

		c.add(North, BorderLayout.NORTH);
		c.add(cen, BorderLayout.CENTER);
		c.add(la1, BorderLayout.EAST);
		c.add(la2, BorderLayout.WEST);
		c.add(la3, BorderLayout.SOUTH);

		setSize(400, 400);
		setVisible(true);

	}
	
	class MyMouseListener extends MouseAdapter{
		 public void mouseClicked(MouseEvent e) {
			JList jl = (JList)e.getSource();
			ImageIcon icon = new ImageIcon("images/"+jl.getName()+".gif");
			
			la1.setIcon(icon);
		 }
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Team();

	}

}
