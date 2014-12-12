
public class RunThreads implements Runnable {
	
	public static void main(String[] args)
	{
		Runnable runner = new RunThreads();
		Thread alpha = new Thread(runner);
		Thread beta = new Thread(runner);
		alpha.setName("Alpha thread");
		beta.setName("Beta thread");
		alpha.start();
		beta.start();
	}
	
	public void run()
	{
		for(int i = 0; i<10 ; i++)
		{
			String threadname = Thread.currentThread().getName();
			System.out.println(threadname + " us running");
		}
	}
}
