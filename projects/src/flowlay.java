import javax.swing.*;

import java.awt.*;

public class flowlay {
	public static void main(String[] args)
	{
		flowlay test = new flowlay();
		test.go();
	}
	
	public void go()
	{
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setBackground(Color.darkGray);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JButton button = new JButton("click me");
		panel.add(button);
		JButton button2 = new JButton("below");
		panel.add(button2);
		frame.setContentPane(panel);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
}
