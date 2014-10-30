
public class StringSplit {
	public static void main(String[] args)
	{
		String test = "What is yellow + blue?/green";
		String[] result = test.split("/");
		for(String color:result)
		{
			System.out.println(color);
		}
	}
}
