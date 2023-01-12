import java.awt.Color;
import java.awt.Container;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test5 extends JFrame{
	public Test5() {
		setTitle("컨테이너 출력 예시");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Random ra = new Random();
		
		Container c = getContentPane();
		c.setLayout(null);
		
		for(int i = 1; i<10; i++) {
			
			JLabel b = new JLabel();
			int x = ra.nextInt(200)+50;
			int y = ra.nextInt(200)+50;
			b.setOpaque(true);
			b.setSize(20,20);
			b.setText(i+"");
			b.setBackground(Color.magenta);
			b.setLocation(x,y);
			c.add(b);
		}
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test5();
		
	}

}
