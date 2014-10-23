import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoButtonGUI {
	JFrame frame;
	JLabel label;
	
	public static void main(String[] args)
	{
		TwoButtonGUI gui = new TwoButtonGUI();
		gui.go();
	}
	
	public void go()
	{
		frame = new JFrame();
		label = new JLabel("I am a label");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		JButton labelbutton = new JButton("change label");
		labelbutton.addActionListener(new LabelListener());
		JButton colorbutton = new JButton("change color");
		colorbutton.addActionListener(new ColorListener());
		painting paint = new painting();
		
		frame.getContentPane().add(BorderLayout.SOUTH, colorbutton);
		frame.getContentPane().add(BorderLayout.CENTER, paint);
		frame.getContentPane().add(BorderLayout.EAST, labelbutton);
		frame.getContentPane().add(BorderLayout.WEST, label);
		
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	
	class LabelListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			label.setText("Ouch");
		}
	}
	
	class ColorListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			frame.repaint();
		}
	}
	
}
