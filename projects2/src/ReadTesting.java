import java.io.*;

public class ReadTesting {
	public static void main(String[] args)
	{
		try{
		FileInputStream in = new FileInputStream("foo.ser");
		ObjectInputStream is = new ObjectInputStream(in);
		Testing test = (Testing) is.readObject();
		Testing test2 = (Testing) is.readObject();
		System.out.println(test.height +" "+test.width +" with "+test2.height +" "+test2.width);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
