import java.io.*;
import java.net.*;

public class DailyAdviceClient {
	public void go()
	{
		try
		{
			Socket s = new Socket("127.0.0.1", 4242);
			
			InputStreamReader streamreader = new InputStreamReader(s.getInputStream());
			BufferedReader reader = new BufferedReader(streamreader);
			
			String advice = reader.readLine();
			System.out.println("Today you should " + advice);
			
		} catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		DailyAdviceClient test = new DailyAdviceClient();
		test.go();
	}
}
