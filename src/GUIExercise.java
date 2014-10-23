import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIExercise {
	JFrame frame;
	JButton button;
	int x =1;
	int y =1;
	
	public static void main(String[] args)
	{
		GUIExercise practice = new GUIExercise();
		practice.go();
	}
	
	public void go()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		button = new JButton("A");
		button.addActionListener(new BListener());
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		painting paint = new painting();
		frame.getContentPane().add(BorderLayout.CENTER, paint);
		frame.setSize(500, 300);
		frame.setVisible(true);
		for(int i = 0;i<124;i++,x++,y++)
		{
			x++;
			paint.repaint();
			try
			{
				Thread.sleep(50);
			}
			catch(Exception e){}
		}
	}
	
	class BListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(button.getText().equals("A"))
					button.setText("B");
			else
				button.setText("A");
		}
	}
	
	class painting extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			g.setColor(Color.white);
			g.fillRect(0,0,500,250);
			g.setColor(Color.blue);
			g.fillRect(x,y,500-x*2,250-y*2);
		}
	}
}
