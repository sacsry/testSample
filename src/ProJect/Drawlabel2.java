package ProJect;

import java.awt.*;
import javax.swing.*;

public class Drawlabel2 extends JPanel {

	ProjectMain s;
	
	JLabel typelabel = new JLabel();
	public Drawlabel2(JFrame f) {
		s = (ProjectMain)f;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		setLayout(null);
		setBackground(Color.black);
		
		if(s.grade2.equals("A")||s.grade2.equals("A+")||s.grade2.equals("A-")) {
			g.setColor(Color.red);
		}
		else if(s.grade2.equals("B")||s.grade2.equals("B+")||s.grade2.equals("B-")) {
			g.setColor(Color.YELLOW);
		}
		else if(s.grade2.equals("C")||s.grade2.equals("C+")||s.grade2.equals("C-")) {
			g.setColor(Color.GREEN);
		}
		else if(s.grade2.equals("D")||s.grade2.equals("D+")||s.grade2.equals("D-")) {
			g.setColor(Color.BLUE);
		}
		else {
			g.setColor(Color.gray);
		}
		
		g.drawString(s.grade2, 105, 115);	
		
		int[] x_point = {60,70,110,150,160,150,110,70};
		int[] y_point = {110,145,160,145,110,75,60,75};
		g.setColor(Color.WHITE);
		g.drawPolygon(x_point,y_point,x_point.length);
		
			
		g.setColor(Color.white);
		g.drawString("수비력\n", 20, 110);
		g.drawString(s.def2+"",25, 122);
		g.drawString("물량\n", 40, 150);
		g.drawString(s.supply2+"",43, 162);
		g.drawString("전략\n", 95, 178);
		g.drawString(s.tectics2+"",98, 190);
		g.drawString("견제\n", 155, 150);
		g.drawString(s.keep2+"",158, 162);
		g.drawString("공격력\n", 165, 110);
		g.drawString(s.atk2+"",168, 122);
		g.drawString("컨트롤\n", 155, 68);
		g.drawString(s.control2+"",160, 80);
		g.drawString("센스\n", 97, 45);
		g.drawString(s.sense2+"",100, 58);
		g.drawString("정찰\n", 40, 68);
		g.drawString(s.recon2+"",43, 80);
		if(s.type2.equals("Terran")) {
			g.setColor(Color.yellow);
		}
		else if(s.type2.equals("Zerg")) {
			g.setColor(Color.red);
		}
		else if(s.type2.equals("Protoss")) {
			g.setColor(Color.green);
		}
		g.drawString("종족:"+s.type2, 130, 195);
//		atk1 = sunsudb.getAtk();
//		def1 = sunsudb.getDef();
//		tectics1 = sunsudb.getTectics();
//		sense1 = sunsudb.getSense();
//		supply1 = sunsudb.getSupply();
//		control1 = sunsudb.getControl();
//		type1 = sunsudb.getType();
//		recon1 = sunsudb.getRecon();
//		keep1 = sunsudb.getKeep();
		int[] x_point1 = {(int) (110-(50*s.def2*((double)1/1000))),(int) (110-(40*s.supply2*((double)1/1000))),110,
				(int) (110+(40*s.keep2*((double)1/1000))),(int) (110+(50*s.atk2*((double)1/1000))),
				(int) (110+(40*s.control2*((double)1/1000))),110,(int) (110-(40*s.recon2*((double)1/1000)))};
		int[] y_point1 = {110,(int) (110+(35*s.supply2*((double)1/1000))),(int) (110+(50*s.tectics2*((double)1/1000))),
				(int) (110+(35*s.keep2*((double)1/1000))),110,(int) (110-(35*s.control2*((double)1/1000))),(int) (110-(50*s.sense2*((double)1/1000))),
				(int) (110-(35*s.recon2*((double)1/1000)))};
		
		g.setColor(Color.red);
		g.drawPolygon(x_point1,y_point1,x_point1.length);
		
//		repaint();
//		
		
		}
	
}

