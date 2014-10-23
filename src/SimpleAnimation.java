import javax.swing.*;
import java.awt.*;

public class SimpleAnimation {
	int x = 70;
	int y = 70;
	
	public static void main(String[] args)
	{
		SimpleAnimation animation = new SimpleAnimation();
		animation.go();
	}
	
	public void go()
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		DrawPanel paint = new DrawPanel();
		
		frame.getContentPane().add(paint);
		frame.setSize(300, 300);
		frame.setVisible(true);
		
		for(int i = 0;i<300;i++)
		{
			x++;
			y++;
			paint.repaint();
			try
			{
				Thread.sleep(50);
			}
			catch(Exception ex)
			{
				
			}
		}
	}
	
	class DrawPanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			g.setColor(Color.white);
			g.fillRect(0,0,this.getWidth(), this.getHeight());
			g.setColor(Color.green);
			g.fillOval(x, y, 40, 40);
		}
	}
}
