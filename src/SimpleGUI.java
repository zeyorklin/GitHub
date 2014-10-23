import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.*;

public class SimpleGUI implements ActionListener {
	JButton button;
	JFrame frame;
	public static void main (String[] args)
	{
		SimpleGUI gui = new SimpleGUI();
		gui.go();
	}
	
	public void go()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button = new JButton("change color");
		button.addActionListener(this);
		button.setSize(30,30);
		painting paint = new painting();
		frame.getContentPane().add(BorderLayout.CENTER, paint);
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		frame.repaint();
	}
}
