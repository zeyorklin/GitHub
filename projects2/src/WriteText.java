import java.io.*;

public class WriteText {
	public static void main(String[] args)
	{
		try
		{
			FileWriter writer = new FileWriter("foo.txt");
			writer.write("whats up");
			writer.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
