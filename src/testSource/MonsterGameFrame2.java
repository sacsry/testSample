package testSource;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MonsterGameFrame2 extends JFrame {	
	private JPanel gamePanel = new GamePanel("@", "M", 'q', 200); 

	public MonsterGameFrame2() {
		setTitle("테스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(gamePanel); 
	
		setSize(300,300);
		setVisible(true);
		
		gamePanel.setFocusable(true);

	}

	class GamePanel extends JPanel {
		private String avatarChar;
		private String monsterChar;
		private char quitChar;
		private long monsterDelay;
		private JLabel avatar;
		private JLabel monster; 
		final int AVATAR_MOVE = 10;

		public GamePanel(String avatarChar, String monsterChar, char quitChar, long monsterDelay) {
			this.avatarChar = avatarChar;
			this.monsterChar = monsterChar;
			this.quitChar = quitChar;
			this.monsterDelay = monsterDelay;
			
			avatar = new JLabel(avatarChar); 
			monster = new JLabel(monsterChar);
			
			setLayout(null); 
			addKeyListener(new MyKeyListener()); 
			
			MyKeyListener keylistener = new MyKeyListener();
			avatar.setLocation(50,50);
			avatar.setSize(15,15);
			avatar.setForeground(Color.RED);
			avatar.addKeyListener(keylistener);
			add(avatar);
			
			
			monster.setLocation(200,5);
			monster.setSize(15,15);
			add(monster);
			
			MonsterThread th = new MonsterThread(monster, avatar, monsterDelay);
			th.start();
			
			this.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					JPanel panel = (JPanel)e.getSource();
					
				}
			});

		}
		
		class MyKeyListener extends KeyAdapter {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == quitChar) 
					System.exit(0); 
				
				int keyCode = e.getKeyCode(); 
				
				switch(keyCode) {
				case KeyEvent.VK_UP: 
					avatar.setLocation(avatar.getX(), avatar.getY()-AVATAR_MOVE); 
					break;
				case KeyEvent.VK_DOWN: 
					avatar.setLocation(avatar.getX(), avatar.getY()+AVATAR_MOVE); 
					break;
				case KeyEvent.VK_RIGHT: 
					avatar.setLocation(avatar.getX()+AVATAR_MOVE, avatar.getY()); 
					break;
				case KeyEvent.VK_LEFT: 
					avatar.setLocation(avatar.getX()-AVATAR_MOVE, avatar.getY()); 
					break;
				}
				
				avatar.getParent().repaint(); 
			}
		}

		class MonsterThread extends Thread {
			private JLabel from;
			private JLabel to; 
			private long monsterDelay;
			private final int MONSTER_MOVE = 5; 
			
			public MonsterThread(JLabel from, JLabel to, long monsterDelay) {
				this.from = from;
				this.to = to;
				this.monsterDelay = monsterDelay;
			}
			
			@Override
			public void run() {
				int x=from.getX(),y=from.getY(); 
				
				while(true) {
					if(to.getX() < from.getX())
						x = from.getX() - MONSTER_MOVE;
					else 						
						x = from.getX() + MONSTER_MOVE;
					
					if(to.getY() < from.getY()) 
						y = from.getY() - MONSTER_MOVE;
					else 						
						y = from.getY() + MONSTER_MOVE;			
					
					from.setLocation(x, y);
					
					from.getParent().repaint();
					
					try {
						sleep(monsterDelay);
					}catch(InterruptedException e) {
						return;
					}
				}
			}
		}
	}

	
	public static void main(String [] args) {
		new MonsterGameFrame2();
	}
} 