import java.awt.*;
import javax.swing.*;

public class painting extends JPanel {
	public void paintComponent(Graphics g)
	{
		g.fillRect(0,0,this.getWidth(),this.getHeight());
		int red = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);
		Color random = new Color(red, green, blue);
		g.setColor(random);
		g.fillOval(70, 70, 100, 100);
	}
}
