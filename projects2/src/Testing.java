import java.io.*;

public class Testing implements Serializable{
	int width;
	int height;
	
	public void setwidth(int w)
	{
		width = w;
	}
	
	public void setheight(int x)
	{
		height = x;
	}
	
	public static void main(String[] args)
	{
		Testing test = new Testing();
		test.setwidth(50);
		test.setheight(30);
		Testing test2 = new Testing();
		test2.setwidth(100);
		test2.setheight(60);
		
		try
		{
			FileOutputStream fs = new FileOutputStream("foo.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(test);
			os.writeObject(test2);
			os.close();
		} catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
