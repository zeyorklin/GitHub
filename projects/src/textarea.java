import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class textarea implements ActionListener{
	
	JTextArea text;
	int i = 0;
	
	public static void main(String[] args)
	{
		textarea test = new textarea();
		test.go();
	}
	
	public void go()
	{
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton button = new JButton("Just click it");
		button.addActionListener(this);
		text = new JTextArea(10,20);
		text.setLineWrap(true);
		JScrollPane scroller = new JScrollPane(text);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scroller);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.setSize(350,300);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent x)
	{
			i++;
			String k = ""+i;
			text.append(k+"\n");
	}

}
