import java.io.*;

class gamenum implements Serializable{
	public int x =3;
	transient long y = 4;
	private short z = 5;
	int getx()
	{
		return x;
	}
	long gety()
	{
		return y;
	}
	short getz()
	{
		return z;
	}
}

class games
{
	public static void main(String[] args)
	{
		gamenum d = new gamenum();
		System.out.println(d.getx() + d.gety() + d.getz());
		try{
			FileOutputStream fos = new FileOutputStream("dg.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(d);
			oos.close();
			FileInputStream fis = new FileInputStream("dg.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			d = (gamenum) ois.readObject();
			ois.close();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(d.getx() + d.gety() + d.getz());
	}
}

