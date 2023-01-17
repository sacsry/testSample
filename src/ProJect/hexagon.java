package ProJect;

import java.awt.*;
import javax.swing.*;

public class hexagon extends JPanel{

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int [] xPoints = {30,90,120,90,30,0};
		int [] yPoints = {120,120,60,0,0,60};
		g.drawPolygon(xPoints,yPoints,xPoints.length);
		g.setColor(Color.white);
	}
	

}
