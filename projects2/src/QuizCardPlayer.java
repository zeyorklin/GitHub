import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class QuizCardPlayer {
	
	JTextArea display;
	JTextArea answer;
	ArrayList<QuizCard> cardList;
	QuizCard currentCard;
	int currentCardIndex;
	JFrame frame;
	JButton nextButton;
	boolean isShowAnswer;
	
	public static void main(String[] args)
	{
		QuizCardPlayer player = new QuizCardPlayer();
		player.go();
	}
	
	public void go()
	{
		frame = new JFrame("Quiz Card Player");
		JPanel panel = new JPanel();
		Font big = new Font("sanserif", Font.BOLD, 24);
		
		display = new JTextArea(10,20);
		display.setFont(big);
		display.setLineWrap(true);
		display.setEditable(false);
		
		JScrollPane qScroller = new JScrollPane(display);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		nextButton = new JButton("Show Question");
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(qScroller);
		panel.add(nextButton);
		nextButton.addActionListener(new NextCardListener());
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem loadMenuItem = new JMenuItem("Load card set");
		loadMenuItem.addActionListener(new OpenMenuListener());
		menu.add(loadMenuItem);
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setSize(640, 500);
		frame.setVisible(true);
	}
	
	public class NextCardListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ev)
		{
			if(isShowAnswer)
			{
				display.setText(currentCard.getAnswer());
				nextButton.setText("Next Card");
				isShowAnswer = false;
			}
			else
			{
				if(currentCardIndex < cardList.size())
				{
					showNextCard();
				}
				else
				{
					display.setText("That was the last card");
					nextButton.setEnabled(false);
				}
			}
		}
	}
	
	public class OpenMenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ev)
		{
			JFileChooser fileopen = new JFileChooser();
			fileopen.showOpenDialog(frame);
			loadFile(fileopen.getSelectedFile());
		}
	}
	
	public void loadFile(File file)
	{
		cardList = new ArrayList<QuizCard>();
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = reader.readLine()) != null)
			{
				makeCard(line);
			}
		}
		catch(Exception ex)
		{
			System.out.println("Couldnt read card file");
			ex.printStackTrace();
		}
		showNextCard();
	}
	
	public void makeCard(String quizline)
	{
		String[] result = quizline.split("/");
		QuizCard card = new QuizCard(result[0], result[1]);
		cardList.add(card);
		System.out.println("made a card");
	}
	
	public void showNextCard()
	{
		currentCard = cardList.get(currentCardIndex);
		currentCardIndex++;
		display.setText(currentCard.getQuestion());
		nextButton.setText("Show answer");
		isShowAnswer = true;
	}
}
