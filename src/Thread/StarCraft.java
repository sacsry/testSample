package Thread;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StarCraft extends JFrame {

	// 더블 버퍼링을 위해 이미지를 담는 인스턴스 두개
	private Image screenImage;
	private Graphics screenGraphic;

	private Image introBackground;
	private JLabel menuBar;
	private JButton exitButton;
	int mouseX, mouseY,x,y;

	// 클래스를 이용한 객체를 만들었을 때 가장먼저 실행되는 생성자. 자신의 클래스와 같은 이름을 가진 메소드.
	public StarCraft() throws Exception {

		//new JLabel(new ImageIcon(Main.class.getResource("images/StarCraftMenuBar.png")));
		//new JButton(new ImageIcon(Main.class.getResource("images/exitButton.png")));
		
		ImageIcon icon1 = new ImageIcon("images/StarCraftMenuBar.png");
		menuBar = new JLabel(icon1);
		
		ImageIcon icon2 = new ImageIcon("images/exitButton.png");
		exitButton = new JButton(icon2);

		setUndecorated(true);
		setTitle("StarCraft");
		setSize(1000,1000);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0)); // 페인트컴포넌트시 배경을 회색이아닌 하얀색으로 바꿈
		
		exitButton.setBounds(1565, 0, 30, 30);
		//엑싯버튼 네모 없애는 코드들
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);		
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}		
		
			
			@Override
		   public void mousePressed(MouseEvent e) {
			 //클릭시 종료
			   System.exit(0);
		   }
			
		});
		add(exitButton);
		
		
		
		menuBar.setBounds(0, 0, 1600, 30);
		add(menuBar);
	
		menuBar.addMouseListener(new MouseAdapter() {
		      @Override
		      public void mousePressed(MouseEvent e) {
		    	  mouseX = e.getX();
		    	  mouseY = e.getY();
		      }
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		

		// 이미지 아이콘에 이미지를 넣고 이미지에 이미지아이콘을 세팅한다.
		ImageIcon icon = new ImageIcon("images/StarCraftTitle.jpg");
		introBackground = icon.getImage();

		// ImageIcon icon2 = new ImageIcon("images/StarCraftMenuBar.png");
		// menuBar = icon2.getImage();

		// 배경음악재생
		while (true) {
			File a = new File("mp3/MainMenu.wav");
			AudioInputStream b = AudioSystem.getAudioInputStream(a);
			Clip c = AudioSystem.getClip();
			c.open(b);
			c.start();
			Thread.sleep(c.getMicrosecondLength() / 1000);

		}

	}

	public void paint(Graphics g) {
		screenImage = createImage(1600, 900);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}
	
	public static void main(String[] args) throws Exception {
		new StarCraft();
	}

}
