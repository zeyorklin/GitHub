import java.io.*;
import java.net.*;

public class DailyAdviceServer {
	String[] adviceList = {"advice 1","advice 2","advice 3","advice 4"};
	
	public void go()
	{
		try{
			ServerSocket serversock = new ServerSocket(4242);
			while(true)
			{
				Socket sock = serversock.accept();
				
				PrintWriter writer = new PrintWriter(sock.getOutputStream());
				String advice = getAdvice();
				writer.println(advice);
				writer.close();
				System.out.println(advice);
			}
			
		} catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public String getAdvice()
	{
		int random = (int)(Math.random()*adviceList.length);
		return adviceList[random];
	}
	
	public static void main(String[] args)
	{
		DailyAdviceServer server = new DailyAdviceServer();
		server.go();
	}
	
}
