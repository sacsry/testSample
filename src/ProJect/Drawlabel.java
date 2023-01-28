package ProJect;

import java.awt.*;
import javax.swing.*;

public class Drawlabel extends JPanel {

	ProjectMain s;
	JLabel gradelabel = new JLabel();
	JLabel deflabel = new JLabel();
	JLabel supplylabel = new JLabel();
	JLabel tecticslabel = new JLabel();
	JLabel keeplabel = new JLabel();
	JLabel atklabel = new JLabel();
	JLabel controllabel = new JLabel();
	JLabel senselabel = new JLabel();
	JLabel reconlabel = new JLabel();
	JLabel typelabel = new JLabel();
	public Drawlabel(JFrame f) {
		s = (ProjectMain)f;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		System.out.println("test");
		setLayout(null);
		setBackground(Color.black);
<<<<<<< HEAD
		
		if(s.grade1.equals("A")||s.grade1.equals("A+")||s.grade1.equals("A-")) {
			g.setColor(Color.red);
		}
		else if(s.grade1.equals("B")||s.grade1.equals("B+")||s.grade1.equals("B-")) {
			g.setColor(Color.YELLOW);
		}
		else if(s.grade1.equals("C")||s.grade1.equals("C+")||s.grade1.equals("C-")) {
			g.setColor(Color.GREEN);
		}
		else if(s.grade1.equals("D")||s.grade1.equals("D+")||s.grade1.equals("D-")) {
			g.setColor(Color.BLUE);
		}
		else {
			g.setColor(Color.gray);
		}
		g.drawString(s.grade1, 105, 115);	
		g.setColor(Color.white);
		g.drawString("수비력\n", 20, 110);
		g.drawString(s.def1+"",25, 122);
		g.drawString("물량\n", 40, 150);
		g.drawString(s.supply1+"",43, 162);
		g.drawString("전략\n", 95, 178);
		g.drawString(s.tectics1+"",98, 190);
		g.drawString("견제\n", 155, 150);
		g.drawString(s.keep1+"",158, 162);
		g.drawString("공격력\n", 165, 110);
		g.drawString(s.atk1+"",168, 122);
		g.drawString("컨트롤\n", 155, 68);
		g.drawString(s.control1+"",160, 80);
		g.drawString("센스\n", 97, 45);
		g.drawString(s.sense1+"",100, 58);
		g.drawString("정찰\n", 40, 68);
		g.drawString(s.recon1+"",43, 80);
		if(s.type1.equals("Terran")) {
			g.setColor(Color.yellow);
		}
		else if(s.type1.equals("Zerg")) {
			g.setColor(Color.red);
		}
		else if(s.type1.equals("Protoss")) {
			g.setColor(Color.green);
		}
		g.drawString("종족:"+s.type1, 130, 195);
		
		
		int[] x_point = {60,70,110,150,160,150,110,70};
		int[] y_point = {110,145,160,145,110,75,60,75};
		deflabel.setText("");
		deflabel.setText("수비력:"+s.def1);
		deflabel.setBounds(-10, 50, 20, 10);
=======
		if(s.grade1 != null) {
			g.setColor(new Color(0, 0, 255));
			g.drawString(s.grade1, 45, 45);
		}
//		gradelabel.setText("");
//		gradelabel.setText(s.grade1);
//		gradelabel.setBounds(45, 45, 20, 20);
		int[] x_point = {0,10,50,90,100,90,50,10};
		int[] y_point = {50,85,100,85,50,15,0,15};
>>>>>>> refs/remotes/origin/master
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
		int[] x_point1 = {(int) (110-(50*s.def1*((double)1/1000))),(int) (110-(40*s.supply1*((double)1/1000))),110,
				(int) (110+(40*s.keep1*((double)1/1000))),(int) (110+(50*s.atk1*((double)1/1000))),
				(int) (110+(40*s.control1*((double)1/1000))),110,(int) (110-(40*s.recon1*((double)1/1000)))};
		int[] y_point1 = {110,(int) (110+(35*s.supply1*((double)1/1000))),(int) (110+(50*s.tectics1*((double)1/1000))),
				(int) (110+(35*s.keep1*((double)1/1000))),110,(int) (110-(35*s.control1*((double)1/1000))),(int) (110-(50*s.sense1*((double)1/1000))),
				(int) (110-(35*s.recon1*((double)1/1000)))};
		
		g.setColor(Color.red);
		g.drawPolygon(x_point1,y_point1,x_point1.length);
		add(gradelabel);
<<<<<<< HEAD
		add(deflabel);
=======
>>>>>>> refs/remotes/origin/master
//		repaint();
//		
		}
	
}
