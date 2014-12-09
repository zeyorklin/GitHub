
public class ThreadTester {
	
	
	public static void main(String[] args)
	{
		Runnable threadjob = new MyRunnable();
		Thread myThread = new Thread(threadjob);
		
		myThread.start();
		
		System.out.println("back in main");
	}
}
