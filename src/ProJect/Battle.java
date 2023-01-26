package ProJect;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.sql.*;
import java.util.Random;

public class Battle extends JFrame {
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
	private int height;
	
	private  boolean exitThread;
	MyLabel con1;
	MyLabel con2;
	int sniperbonus;
	
	private String sunsu1;
	private String sunsu2;
	private int count;
	private JButton strBtn1 = new JButton("시작");
	
	private int mapwinrate = 0;
	private int sum1;
	private int sum2;
	private int sum3;
	private int winrate ;
	
	
	public Battle(JFrame f,String Myteam, String sunsu1, String sunsu2, int wincount, int losecount, int count) {

		super("Mystarcraft");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.black);
		
		ProjectMain s = (ProjectMain)f;
		
		this.sunsu1 = sunsu1;
		this.sunsu2 = sunsu2;
		this.count = count;
		
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
		
		s.draw = new Drawlabel(f);
		s.draw.setLayout(null);
		Drawlabel2 draw1 = new Drawlabel2(f);
		draw1.setLayout(null);

		s.scrollPane.setBounds(460, 330, 300, 500);
		c.add(s.scrollPane);
		
		s.sunsudb.data(sunsu1);
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
		s.sum1 = s.atk1 + s.def1 + s.control1 + s.tectics1 + s.sense1 + s.supply1+s.recon1+s.keep1;
		sum1 = s.sum1;
		s.draw.repaint();
		
		s.draw.setVisible(true);
		s.draw.setBounds(70,520,200,200);
		c.add(s.draw);
//		s.statlabel.setVisible(true);
//		
//		s.statlabel.setText("<html><body><center>공격력: " + s.atk1 + "<br>수비력: " + s.def1 + "<br>전략: "
//				+ s.tectics1 + "<br>센스: " + s.sense1 + "<br>물량: " + s.supply1 + "<br>컨트롤: " + s.control1
//				+ "<br>견제: " + s.keep1 + "<br>정찰: " + s.recon1
//				+"<br>종족: " + s.type1 + "</center></body></html>");
//
//		s.statlabel.setForeground(Color.white);
//		s.statlabel.setBackground(Color.black);
//		s.statlabel.setBounds(130, 500, 150, 150);
//		c.add(s.statlabel);

		
		s.sunsudb.data(sunsu2);
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
		
		
		s.sum2 = s.atk2 + s.def2 + s.control2 + s.tectics2 + s.sense2 + s.supply2+s.keep2+s.recon2;
		sum2 = s.sum2;

		draw1.setVisible(true);
		draw1.setBounds(930, 520, 200, 200);
		c.add(draw1);
//		s.statlabel2.setText("<html><body><center>공격력: " + s.atk2 + "<br>수비력: " + s.def2 + "<br>전략: "
//				+ s.tectics2 + "<br>센스: " + s.sense2 + "<br>물량: " + s.supply2 + "<br>컨트롤: " + s.control2
//				+ "<br>견제: " + s.keep2 + "<br>정찰: " + s.recon2
//				+"<br>종족: " + s.type2 + "</center></body></html>");
//
//		s.statlabel2.setForeground(Color.white);
//		s.statlabel2.setBackground(Color.black);
//		s.statlabel2.setBounds(970, 500, 150, 150);
//		c.add(s.statlabel2);

		s.sum3 = s.sum1 + s.sum2;
		sum3 = s.sum3;
		nextBtn1.setVisible(false);
//		JButton strBtn1 = new JButton("시작");
		Random r1 = new Random();

		Map currentMap = new Map();
		currentMap.data(s.NewMap.get(count));
		s.Mapdatalabel.setText("<html><body><center>" + s.NewMap.get(count) + "<br>T:Z " + currentMap.getMyTerranwinrate()
						+ ":" + currentMap.getYourZergwinrate() + "<br>Z:P " + currentMap.getMyZergwinrate() + ":"
						+ currentMap.getYourProtosswinrate() + "<br>P:T " + currentMap.getMyProtosswinrate() + ":"
						+ currentMap.getYourTerranwinrate() + "</center></body></html>");
		s.Mapdatalabel.setFont(new Font("맵 정보", Font.ITALIC, 17));
		s.Mapdatalabel.setForeground(Color.white);
		s.Mapdatalabel.setBounds(680, 150, 200, 200);
		ImageIcon icon = new ImageIcon("images/맵/" + s.NewMap.get(count) + ".gif");
		s.Mapla.setIcon(icon);
		s.Mapla.setBounds(460, 150, 200, 200);

		

		if (s.type1.equals("Terran") && s.type2.equals("Zerg")) {
			mapwinrate = currentMap.getMyTerranwinrate() - currentMap.getYourZergwinrate();
		}
		if (s.type1.equals("Zerg") && s.type2.equals("Protoss")) {
			mapwinrate = currentMap.getMyZergwinrate() - currentMap.getYourProtosswinrate();
		}
		if (s.type1.equals("Protoss") && s.type2.equals("Terran")) {
			mapwinrate = currentMap.getMyProtosswinrate() - currentMap.getYourTerranwinrate();
		}
		if (s.type1.equals("Zerg") && s.type2.equals("Terran")) {
			mapwinrate = currentMap.getYourZergwinrate() - currentMap.getMyTerranwinrate();
		}
		if (s.type1.equals("Protoss") && s.type2.equals("Zerg")) {
			mapwinrate = currentMap.getYourProtosswinrate() - currentMap.getMyZergwinrate();
		}
		if (s.type1.equals("Terran") && s.type2.equals("Protoss")) {
			mapwinrate = currentMap.getYourTerranwinrate() - currentMap.getMyProtosswinrate();
		}
		if(s.answer == true) {
			sniperbonus = 500;
		}
		int winrate1 = (int) ((double) ((sum1+sum1-sum2+sniperbonus + (mapwinrate * 50)) * 100)  / ((double) sum3 ));
		winrate = winrate1;

		
		MyLabel bar = new MyLabel(100,f);
		
		bar.setBackground(Color.black);
		bar.setOpaque(true);
		bar.setLocation(300,300);
		bar.setSize(100,500);
		bar.setBorder(new LineBorder(Color.white,2));
		
		MyLabel bar1 = new MyLabel(100,f);
		bar1.setBackground(Color.black);
		bar1.setOpaque(true);
		bar1.setLocation(800,300);
		bar1.setSize(100,500);
		bar1.setBorder(new LineBorder(Color.white,2));
		
		JLabel la = new JLabel("승률");
		la.setFont(new Font("승률라벨",Font.BOLD,20));
		la.setBounds(330, 800, 100, 50);
		la.setForeground(Color.white);
		add(la);
		
		JLabel la2 = new JLabel("승률");
		la2.setFont(new Font("승률라벨",Font.BOLD,20));
		la2.setBounds(830, 800, 100, 50);
		la2.setForeground(Color.white);
		add(la2);
		strBtn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
//				Person1 p1 = new Person1(sunsu1,f);
//				Person2 p2 = new Person2(sunsu2,f);
				ConsumerThread th = new ConsumerThread(f,bar,sunsu1);
				ConsumerThread2 th1 = new ConsumerThread2(f,bar1,sunsu2);
//				p1.start();
//				p2.start();
				th.start();
				th1.start();
				System.out.println(s.answer);
			}
		});

		strBtn1.setBounds(550, 900, 100, 30);

		nextBtn1.setBounds(550, 900, 100, 30);

		nextBtn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (s.wincount1 == 2 && s.losecount1 == 2) {
					setVisible(false);
					dispose();
					new AceFrame(f,Myteam);
				} else if (s.wincount1 == 3) {
					s.grade--;
					s.wincount++;
					s.ACECARD = "ACE";
					s.yourACECARD = "ACE";

					if (s.wincount == 3) {

						setVisible(false);
						dispose();
						new loseFrame(f,Myteam, 1);
					} else {
						for (int i = 0; i < 6; i++) {

							s.winLabel1[i].setText("");
							s.loseLabel1[i].setText("");
						}
						setVisible(false);
						dispose();
						new YourFrame(f,Myteam);

					}
				} else if (s.losecount1 == 3) {
					setVisible(false);
					dispose();
					new loseFrame(f,Myteam, s.grade);
				} else {
					setVisible(false);
					dispose();
					new gameFrame(f,Myteam, s.count1, s.wincount1, s.losecount1);
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
		ImageIcon team1 = new ImageIcon("images/로고/" + s.NewTeam.get(s.num[s.wincount]) + ".gif");
		JLabel myteam = new JLabel();
		JLabel yourteam = new JLabel();
		myteam.setIcon(team);
		yourteam.setIcon(team1);
		myteam.setBounds(130, 30, 150, 150);
		yourteam.setBounds(950, 30, 150, 150);
		
//		DrawPanel1 draw = new DrawPanel1();
//		draw.setBounds(300, 300, 100, 600);
//		draw.setBackground(Color.black);
//		draw.setBorder(new LineBorder(Color.white));
		
		
		
		c.add(bar);
		c.add(bar1);
		c.add(myteam);
		c.add(yourteam);

		c.add(s.Mapla);
		c.add(s.Mapdatalabel);
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

	

	class ConsumerThread extends Thread{
	    
	    ProjectMain s;
	    
	    String name ;
	    ConsumerThread(JFrame f,MyLabel con,String name){
	    	s = (ProjectMain)f;
	        con1=con;
	        this.name = name;
	    }
	    public void run(){
	    	if(s.wincount == 0) {
	    	s.Text.append("준플레이오프 "+(s.count1+1)+"경기 시작했습니다.\n");
	    	s.Text.setCaretPosition(s.Text.getDocument().getLength());
	    	}
	    	if(s.wincount == 1) {
		    	s.Text.append("플레이오프 "+(s.count1+1)+"경기 시작했습니다.\n");
		    	s.Text.setCaretPosition(s.Text.getDocument().getLength());
		    }
	    	if(s.wincount == 2) {
		    	s.Text.append("결승 "+(s.count1+1)+"경기 시작했습니다.\n");
		    	s.Text.setCaretPosition(s.Text.getDocument().getLength());
		    }
	    	
	    	if(s.type1.equals("Terran")){
	    		s.Text.append(sunsu1+" 마린생산후 팩토리 올라갑니다\n");
	    		s.Text.setCaretPosition(s.Text.getDocument().getLength());
	    	}
	    	if(s.type1.equals("Zerg")){
	    		s.Text.append(sunsu1+" 12드론까지 눌렀어요\n");
	    		s.Text.setCaretPosition(s.Text.getDocument().getLength());
	    	}
	    	if(s.type1.equals("Protoss")){
	    		s.Text.append(sunsu1+" 질럿 생산후 코어 들어갑니다\n");
	    		s.Text.setCaretPosition(s.Text.getDocument().getLength());
	    	}
	    	winLabel.setVisible(false);
			loseLabel.setVisible(false);
			strBtn1.setVisible(false);
			nextBtn1.setEnabled(false);
			con1.setBarSize(50);
	        while(con1.getBarSize()<100 && con2.getBarSize()<100){
	        	
	            try{
	            	sleep(50);
	                con1.fill();//
	                if(con1.getBarSize()<20) {
	                	s.Text.append(sunsu1+" 선수 끝까지 포기하지 않네요\n");
	                	s.Text.setCaretPosition(s.Text.getDocument().getLength());
	                }
	                if(con1.getBarSize()<40) {
	                	s.Text.append(sunsu1+" 선수 집중해야 합니다.\n");
	                	s.Text.setCaretPosition(s.Text.getDocument().getLength());
	                }
	                if(con1.getBarSize()>60) {
	                	s.Text.append(sunsu1+" 선수 "+con1.getBarSize()+"% 유리\n");
	                	s.Text.setCaretPosition(s.Text.getDocument().getLength());
	                }
	                if(con1.getBarSize()>80) {
	                	s.Text.append(sunsu1+" 선수 승기를 잡았어요!\n");
	                	s.Text.setCaretPosition(s.Text.getDocument().getLength());
	                }
	                
	            }
	            catch(Exception e){
	                return;
	            }
	            
	        }
			if (con2.getBarSize() < 100) {
				winLabel.setBounds(130, 300, 100, 50);
				loseLabel.setBounds(980, 400, 100, 50);
				s.wincount1 = wincount + 1;
				PvP.setText((s.wincount1) + "           :           " + losecount);
				s.winLabel1[count].setText("WIN");
				s.winLabel1[count].setForeground(Color.green);
				s.loseLabel1[count].setText("Lose");
				s.loseLabel1[count].setForeground(Color.red);
				s.WIN = true;
				s.Lose = false;
				s.sunsudb.record(sunsu1, s.WIN, s.type2);
				s.sunsudb.record(sunsu2, s.Lose, s.type1);
				s.recorddb.insertRecorddata(sunsu1, sunsu2,s.type1,s.type2, s.NewMap.get(count));
				s.money +=10;

			}

			else if(con1.getBarSize() < 100) {
				loseLabel.setBounds(130, 400, 100, 50);
				winLabel.setBounds(980, 300, 100, 50);
				s.losecount1 = losecount + 1;
				PvP.setText(wincount + "           :           " + s.losecount1);
				s.winLabel1[count].setText("Lose");
				s.loseLabel1[count].setText("WIN");
				s.winLabel1[count].setForeground(Color.red);
				s.loseLabel1[count].setForeground(Color.green);
				s.Lose = true;
				s.WIN = false;
				s.sunsudb.record(sunsu1, s.WIN, s.type2);
				s.sunsudb.record(sunsu2, s.Lose, s.type1);
				s.recorddb.insertRecorddata(sunsu2, sunsu1,s.type2,s.type1, s.NewMap.get(count));

			}
			if (s.WIN) {
			s.Text.append(sunsu1 + "선수 역시 이기는 법을 아는거같아요!");
			s.Text.setCaretPosition(s.Text.getDocument().getLength());
			s.wincount1 = wincount + 1;
			PvP.setText(s.wincount1 + "           :           " + losecount);
			}
			if (s.Lose) {
				s.Text.append(sunsu2 + "선수 역시 이기는 법을 아는거같아요!");
				s.Text.setCaretPosition(s.Text.getDocument().getLength());
				s.losecount1 = losecount + 1;
				PvP.setText(wincount + "           :           " + s.losecount1);
			}

			s.count1 = count + 1;

			
			nextBtn1.setVisible(true);
	        winLabel.setVisible(true);
			loseLabel.setVisible(true);
			nextBtn1.setEnabled(true);
	    }
	    
	    
	    
	}
	
	class ConsumerThread2 extends Thread{
	   
	    ProjectMain s;
	    
	    String name;
	    ConsumerThread2(JFrame f,MyLabel con,String name){
	    	s = (ProjectMain)f;
	        con2=con;
	        this.name = name;
	    }
	    public void run(){
	    	con2.setBarSize(50);
	    	if(s.type2.equals("Terran")){
	    		s.Text.append(sunsu2+" 마린생산후 팩토리 올라갑니다\n");
	    		s.Text.setCaretPosition(s.Text.getDocument().getLength());
	    	}
	    	if(s.type2.equals("Zerg")){
	    		s.Text.append(sunsu2+" 12드론까지 눌렀어요\n");
	    		s.Text.setCaretPosition(s.Text.getDocument().getLength());
	    	}
	    	if(s.type2.equals("Protoss")){
	    		s.Text.append(sunsu2+" 질럿 생산후 코어 들어갑니다\n");
	    		s.Text.setCaretPosition(s.Text.getDocument().getLength());
	    	}
			while(con1.getBarSize()<100 && con2.getBarSize()<100){
				
	        	
	            try{
	                sleep(50);
	                con2.setBarSize(100-con1.getBarSize());
	                if(con2.getBarSize()<20) {
	                	s.Text.append(sunsu2+" 선수 끝까지 포기하지 않네요\n");
	                	s.Text.setCaretPosition(s.Text.getDocument().getLength());
	                }
	                if(con2.getBarSize()<40) {
	                	s.Text.append(sunsu2+" 선수 집중해야 합니다.\n");
	                	s.Text.setCaretPosition(s.Text.getDocument().getLength());
	                }
	                if(con2.getBarSize()>60) {
	                	s.Text.append(sunsu2+" 선수 "+con1.getBarSize()+"% 유리\n");
	                	s.Text.setCaretPosition(s.Text.getDocument().getLength());
	                }
	                if(con2.getBarSize()>80) {
	                	s.Text.append(sunsu2+" 선수 승기를 잡았어요!\n");
	                	s.Text.setCaretPosition(s.Text.getDocument().getLength());
	                }
	                con2.paint();
	                }
	            catch(Exception e){
	                return;
	            }
	        }
	    }
	    
	    
	}
	
	class MyLabel extends JLabel{
		int barSize=0;//바의 크기
	    int maxBarSize;
	    ProjectMain s;
	    MyLabel(){
	    	
	    }
	    
	    MyLabel(int maxBarSize,JFrame f){
	        this.maxBarSize=maxBarSize;
	        s = (ProjectMain)f;
	        
	    }
	    public void paintComponent(Graphics g){
	        super.paintComponent(g);
	        g.setColor(Color.green);
	        int height =(int)(((double)(this.getHeight()))/maxBarSize*barSize);
	        if(height==0) return;//크기가 0이면 바를 그릴 필요 없음
	        g.fillRect(0,500,this.getWidth(),-height);
	    }
	    synchronized void fill(){
	    	Random r1 = new Random();
	    	int randomint;
	    	if(s.type1.equals(s.type2)) {
	    		randomint = r1.nextInt(20)-10;
	    	}
	    	else {
	    		randomint = r1.nextInt(16)-8;
	    	}
	    	if(randomint>6) {
	    		if(s.type1.equals("Protoss")) {
	    			s.Text.append(sunsu1+" 선수 절묘한 사이오닉스톰!\n");
	    			s.Text.setCaretPosition(s.Text.getDocument().getLength());
	    		}
	    		if(s.type1.equals("Terran")) {
	    			s.Text.append(sunsu1+" 선수 마인대박!!!\n");
	    			s.Text.setCaretPosition(s.Text.getDocument().getLength());
	    		}
	    		if(s.type1.equals("Zerg")) {
	    			s.Text.append(sunsu1+" 선수 병력돌려서 크게 이득봅니다!\n");
	    			s.Text.setCaretPosition(s.Text.getDocument().getLength());
	    		}
	    		
	    	}
	    	
	    	if(randomint<-6) {
	    		if(s.type2.equals("Protoss")) {
	    			s.Text.append(sunsu2+" 선수 절묘한 사이오닉스톰!\n");
	    			s.Text.setCaretPosition(s.Text.getDocument().getLength());
	    		}
	    		if(s.type2.equals("Terran")) {
	    			s.Text.append(sunsu2+" 선수 마인대박!!!\n");
	    			s.Text.setCaretPosition(s.Text.getDocument().getLength());
	    		}
	    		if(s.type2.equals("Zerg")) {
	    			s.Text.append(sunsu2+" 선수 병력돌려서 크게 이득봅니다!\n");
	    			s.Text.setCaretPosition(s.Text.getDocument().getLength());
	    		}
	    	}
	        barSize+=(winrate/5+randomint-10);
	        System.out.println(winrate/5);
	        System.out.println(randomint+"랜덤숫자"+winrate);
	        System.out.println(barSize);
	        this.repaint();//바 다시그리기
	        this.notify();//기다리는 ConsumerThread 스레드 깨우기
	    }
	    synchronized void paint() {
	    	this.repaint();
	    	this.notify();
	    }
	    public int getBarSize() {
			return barSize;
		}
		public void setBarSize(int barSize) {
			this.barSize = barSize;
		}

	}
	
}