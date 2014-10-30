import java.io.*;

public class ReadFile {
	public static void main(String[] args)
	{
		try{
			File myfile = new File("quizcard");
			FileReader reader = new FileReader(myfile);
			BufferedReader breader = new BufferedReader(reader);
			
			String line = null;
			while((line = breader.readLine()) != null)
			{
				System.out.println(line);
			}
			breader.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
