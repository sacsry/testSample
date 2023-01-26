package ProJect;

import java.awt.*;
import javax.swing.*;

public class Drawlabel extends JPanel {

	ProjectMain s;
	JLabel gradelabel = new JLabel();
	public Drawlabel(JFrame f) {
		s = (ProjectMain)f;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		setLayout(null);
		setBackground(Color.black);
		gradelabel.setText("");
		gradelabel.setText(s.grade1);
		gradelabel.setBounds(45, 45, 20, 20);
		int[] x_point = {0,10,50,90,100,90,50,10};
		int[] y_point = {50,85,100,85,50,15,0,15};
		g.setColor(Color.WHITE);
		g.drawPolygon(x_point,y_point,x_point.length);
		
//		atk1 = sunsudb.getAtk();
//		def1 = sunsudb.getDef();
//		tectics1 = sunsudb.getTectics();
//		sense1 = sunsudb.getSense();
//		supply1 = sunsudb.getSupply();
//		control1 = sunsudb.getControl();
//		type1 = sunsudb.getType();
//		recon1 = sunsudb.getRecon();
//		keep1 = sunsudb.getKeep();
		int[] x_point1 = {(int) (50-(50*s.def1*((double)1/1000))),(int) (50-(40*s.supply1*((double)1/1000))),50,
				(int) (50+(40*s.keep1*((double)1/1000))),(int) (50+(50*s.atk1*((double)1/1000))),
				(int) (50+(40*s.control1*((double)1/1000))),50,(int) (50-(40*s.recon1*((double)1/1000)))};
		int[] y_point1 = {50,(int) (50+(35*s.supply1*((double)1/1000))),(int) (50+(50*s.tectics1*((double)1/1000))),
				(int) (50+(35*s.keep1*((double)1/1000))),50,(int) (50-(35*s.control1*((double)1/1000))),(int) (50-(50*s.sense1*((double)1/1000))),
				(int) (50-(35*s.recon1*((double)1/1000)))};
		
		g.setColor(Color.red);
		g.drawPolygon(x_point1,y_point1,x_point1.length);
		add(gradelabel);
		repaint();
//		
		
		}
	
}
