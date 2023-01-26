package ProJect;

import java.awt.*;
import javax.swing.*;
import java.lang.Math;



public class test extends JFrame {

	public test() {

		setTitle("테스트 오각형");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setBackground(Color.black);
		c.setLayout(null);
		
		setVisible(true);
		setSize(300,300);
		
	}
	public void paint(Graphics g) {
		super.paint(g);
		setLayout(null);
		
		int[] x_point = {50,60,100,140,150,140,100,60};
		int[] y_point = {100,135,150,135,100,65,50,65};
		int[] x_point1 = {(int) (100-((double)50*(double)750*((double)1/1000))),(int) (100-(40*0.75)),100,
				(int) (100+(40*0.75)),(int) (100+(50*0.75)),
				(int) (100+(40*0.75)),100,(int) (100-(40*0.75))};
		int[] y_point1 = {100,(int) (100+(35*0.75)),(int) (100+(50*0.75)),(int) (100+(35*0.75))
				,100,(int) (100-(35*0.75)),(int) (100-(50*0.75)),(int) (100-(35*0.75))};
		g.setColor(Color.WHITE);
		g.drawPolygon(x_point,y_point,x_point.length);
		g.setColor(Color.red);
		g.drawPolygon(x_point1,y_point1,x_point1.length);
		System.out.println("a");
		repaint();
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new test();
		System.out.println((100-(50*750*((double)1/1000))));
	}

}
